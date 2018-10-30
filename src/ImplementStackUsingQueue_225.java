import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue_225 {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int top;
    class MyStack {
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
            top = 0;
        }

        /** Push element x onto stack */
        public void push(int x) {
            queue1.add(x);
            top = x;
        }

        /** Removes the elements on top of the staack and return that element */
        public int pop() {
            int theTop = top;
            while (queue1.size() > 1) {
                top = queue1.remove();
                queue2.add(top);
            }
            queue1.remove();
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;

            return theTop;
        }


        /** Get the top element */
        public int top() {
            return top;
        }

        /** Return whether the stack is empty */
        public boolean empty() {
            return queue1.isEmpty();
        }
    }

    public void main(String[] args) {
        MyStack obj = new MyStack();


    }
}
