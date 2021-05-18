package Dropbox;

import java.util.*;

/**
 * 输入格式是List<List<String>>代表操作组合，
 * 每个操作有操作序号，方法，以及方法对应的输入，注意操作组合需要先按照操作序号排序。
 * 我用两个stack实现undo和redo，执行append和backspace的时候把存redo的stack清空。
 *
 * 你直接在输出string中插入表示BOLD的字符其实就可以跑过所有test case了。而且也不用考虑交集合并的问题。
 *
 * redo/undo stack里不要存之前的command，
 * 就直接存之前stringBuilder里的result， 然后pop出来copy到现在的stringbuilder就可以了
 *
 * undo and redo stack and StringBuilder
 *
 * stack里直接存stringbuilder
 */
public class SimpleTextEditor {
    static int selectStart;
    static int selectEnd;
    static Stack<StringBuilder> redoStack;
    static Stack<StringBuilder> undoStack;

    public SimpleTextEditor() {
        selectStart = -1;
        selectEnd = -1;
        redoStack = new Stack<>();
        undoStack = new Stack<>();
    }
    public static String textEditor(List<List<String>> input) {
        Collections.sort(input, Comparator.comparing(a -> a.get(0)));

        for (int i = 0; i < input.size(); i++) {
            List<String> cur = input.get(i);

            String type = cur.get(1);
            switch (type) {
                case "APPEND" :
                    APPEND(cur.get(2));
                    break;
                case "BACKSPACE":
                    BACKSPACE();
                    break;
                case "UNDO":
                    UNDO();
                    break;
                case "REDO":
                    if (i > 0 && !input.get(i - 1).get(1).equals("UNDO") && !input.get(i - 1).get(1).equals("REDO")) {
                        continue;
                    }
                    REDO();
                    break;
                case "SELECT":
                    // if selection operation is followed by another select, the most recent should be used
                    if (i + 1 < input.size() && input.get(i + 1).get(1).equals("SELECT")) continue;
                    SELECT(cur.get(2), cur.get(3));
                    break;
                case "BOLD":
                    BOLD();
                    break;
            }
        }
        return redoStack.isEmpty() ? "" : redoStack.peek().toString();
    }

    public static void APPEND(String s) {
        StringBuilder cur;
        if (redoStack.isEmpty()) {
            cur = new StringBuilder();
        } else {
            cur = new StringBuilder(redoStack.peek());
        }

        if (selectStart != -1 && selectEnd != -1) {
            cur.replace(selectStart, selectEnd, s);
        } else {
            cur.append(s);
        }

        redoStack.push(cur);
    }

    public static void BACKSPACE() {
        if (redoStack.isEmpty()) return;

        StringBuilder cur = new StringBuilder(redoStack.peek());

        if (selectStart != -1 && selectEnd != -1) {
            String res = cur.substring(0, selectStart) + cur.substring(selectEnd);
            redoStack.push(new StringBuilder(res));
            return;
        }
        String res = cur.deleteCharAt(cur.length() - 1).toString();
        if (res.equals("") && redoStack.size() == 1) {
            redoStack.pop();
            return;
        }
        redoStack.push(new StringBuilder(res));
    }

    public static void UNDO() {
        if (!redoStack.isEmpty()) {
            StringBuilder last = redoStack.pop();
            undoStack.push(last);
        }
    }

    // should do nothing when there are more REDO than UNDO
    // should only work immediately after a UNDO/REDO operation

    public static void REDO() {
        if (!undoStack.isEmpty()) {
            StringBuilder last = undoStack.pop();
            redoStack.push(last);
        }
    }

    public static void SELECT(String start, String end) {
        int e = Integer.parseInt(end);
        int s = Integer.parseInt(start);
        if (!redoStack.isEmpty()) {
            String curStr = redoStack.peek().toString();

            // 判断开始跟结束位置是否有效
            if (e > curStr.length()) {
                e = curStr.length();
            }

            if (s < 0 || s > curStr.length()) {
                return;
            }
            selectStart = s;
            selectEnd = e;
        }
    }

    public static void BOLD() {
        StringBuilder cur;
        if (redoStack.isEmpty()) {
            cur = new StringBuilder();
        } else {
            cur = new StringBuilder(redoStack.peek());
        }

        StringBuilder res = new StringBuilder();
        if (selectStart != -1 && selectEnd != -1) {
            res.append(cur.substring(0, selectStart) + "*" + cur.substring(selectStart, selectEnd) + "*" + cur.substring(selectEnd));
            redoStack.push(res);

        }
    }


    // input需要按照时间排序来进行操作


    public static void main(String[] args) {
        SimpleTextEditor ste = new SimpleTextEditor();

        // append
        List<List<String>> input1 = new ArrayList<>();
        input1.add(Arrays.asList("0", "APPEND", "Hey"));
        input1.add(Arrays.asList("1", "APPEND", " there"));
        input1.add(Arrays.asList("2", "APPEND", "!"));  // return "Hey there!"

        // backspace
        List<List<String>> input2 = new ArrayList<>();
        input2.add(Arrays.asList("0", "APPEND", "Hey you"));
        input2.add(Arrays.asList("1", "BACKSPACE"));  // return "Hey yo"
        List<List<String>> input3 = new ArrayList<>();
        input3.add(Arrays.asList("0", "APPEND", "Hey you"));
        input3.add(Arrays.asList("1", "BACKSPACE"));
        input3.add(Arrays.asList("2", "BACKSPACE"));  // return "Hey y"
        List<List<String>> input4 = new ArrayList<>();
        input4.add(Arrays.asList("0", "APPEND", "!"));
        input4.add(Arrays.asList("1", "BACKSPACE"));
        input4.add(Arrays.asList("2", "BACKSPACE"));  // return ""

        // undo
        List<List<String>> input5 = new ArrayList<>();
        input5.add(Arrays.asList("0", "APPEND", "Hey"));
        input5.add(Arrays.asList("1", "APPEND", " there"));
        input5.add(Arrays.asList("2", "APPEND", "!"));
        input5.add(Arrays.asList("3", "UNDO"));
        input5.add(Arrays.asList("4", "UNDO"));   // return "Hey"
        // TODO should do nothing if there are more UNDOs than APPEND and BACKSPACE operations
        List<List<String>> input6 = new ArrayList<>();
        input6.add(Arrays.asList("0", "APPEND", "Hey"));
        input6.add(Arrays.asList("1", "UNDO"));
        input6.add(Arrays.asList("2", "UNDO"));  // return ""

        // redo
        List<List<String>> input7 = new ArrayList<>();
        input7.add(Arrays.asList("0", "APPEND", "Hey"));
        input7.add(Arrays.asList("1", "APPEND", " there"));
        input7.add(Arrays.asList("2", "UNDO"));
        input7.add(Arrays.asList("3", "REDO"));  // return "Hey there"
        List<List<String>> input8 = new ArrayList<>();
        input8.add(Arrays.asList("0", "APPEND", "Hey"));
        input8.add(Arrays.asList("1", "UNDO"));
        input8.add(Arrays.asList("2", "REDO"));
        input8.add(Arrays.asList("3", "REDO"));  // return "Hey"
        // TODO should only work immediately after an UNDO or REDO operation
        List<List<String>> input9 = new ArrayList<>();
        input9.add(Arrays.asList("0", "APPEND", "Hey"));
        input9.add(Arrays.asList("1", "UNDO"));
        input9.add(Arrays.asList("2", "APPEND", " there"));
        input9.add(Arrays.asList("3", "REDO"));  // return " there"

        // 排序
        List<List<String>> input10 = new ArrayList<>();
        input10.add(Arrays.asList("1548185072722", "APPEND", "ey"));
        input10.add(Arrays.asList("1548185072721", "APPEND", "H"));  // return "Hey"

        // select
        // TODO SELECT AND BACKSPACE  should remove the selected characters
        List<List<String>> input11 = new ArrayList<>();
        input11.add(Arrays.asList("1548185072721", "APPEND", "Hello"));
        input11.add(Arrays.asList("1548185072722", "SELECT", "1", "3"));
        input11.add(Arrays.asList("1548185072723", "BACKSPACE")); // return "Hlo"
        List<List<String>> input12 = new ArrayList<>();
        input12.add(Arrays.asList("1548185072721", "APPEND", "Hello"));
        input12.add(Arrays.asList("1548185072722", "SELECT", "2", "5"));
        input12.add(Arrays.asList("1548185072723", "APPEND", "y there"));  // return "Hey there"

        // BOLD
        List<List<String>> input13 = new ArrayList<>();
        input13.add(Arrays.asList("1548185072721", "APPEND", "Hello"));
        input13.add(Arrays.asList("1548185072722", "SELECT", "1", "3"));
        input13.add(Arrays.asList("1548185072723", "BOLD"));  // return "H*el*lo"

        System.out.println(textEditor(input9));
    }

}
