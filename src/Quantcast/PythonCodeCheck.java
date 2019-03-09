package Quantcast;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 第一题有下面几条Rules，处理一个python script, 里面的test cases都是函数块里面的代码，
 * 输出第一个violate这些rules的代码是第几行(one-based)。
 * 1. 第一行无缩进
 * 2. Control Statement以冒号结尾，下一行代码的缩进要比这个Control Statement多
 * 3. 同一个块里面缩进相同，如果下一行缩进变少，必须要变少到之前出现过的有效缩进
 * 4. comment以 '#' 开始，不需要满足上面的几条
 *
 * HackerRank有一些hidden test cases是不会显示出来的。所以Debug比较麻烦。一共有13个cases, 我有一个老是跑不过。
 * 所以最好在做之前写好，然后多找些tricky cases来测试。
 *
 * 我遇到的几个tricky cases:
 * control statement的冒号后面出现空格.
 * 一个块里面只有comments，并且这个块出现在代码的最后
 */
public class PythonCodeCheck {
    public static void main(String[] args) {
        PythonCodeCheck test = new PythonCodeCheck();
        String[] lines = {
                "def:",
                "#abc: ",
                "  bcc:",
                "   abc",
                "   def",
                "   def",
                "  b6c"
        };
        System.out.println(test.validate(lines));
    }

    public boolean validate(String[] lines) {
        Stack<String> stack = new Stack<>();   // stack is used to store the python lines which are valid
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].trim().startsWith("#")) {    // if starting with '#', that is a comment, just skip it
                continue;
            }
            int level = getSpaceNum(lines[i]);    // get the current line's spaces number
            if (stack.isEmpty()) {   // first line
                if (level != 0) {    // if there is a space in first line, we need to output this invalid line
                    System.out.println(i + 1);
                    return false;
                }
            } else if (stack.peek().trim().charAt(stack.peek().trim().length() - 1) == ':') {   // if current line is a control line
                if (getSpaceNum(stack.peek()) >= level) {   // stack.peek() can get the pre-line, if pre-lines' spaces >= current line's spaces
                    System.out.println(i + 1);    // that means current line didn't do a retract，output this line
                    return false;
                }
            } else {
                while (!stack.isEmpty() && getSpaceNum(stack.peek()) > level) {  // while loop to get the correct space
                    stack.pop();
                }
                if (getSpaceNum(stack.peek()) != level) {   // if the valid retract is not equal to current line's spaces
                    System.out.println(i + 1);   // output this line
                    return false;
                }
            }
            stack.push(lines[i]);   // valid line we need to push it to stack
        }
        return true;
    }

    // get the number of space in the current line
    public int getSpaceNum(String line) {
        int res = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}
