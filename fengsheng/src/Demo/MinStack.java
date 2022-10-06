package Demo;

/**
 * @author: fs
 * @date: 2022/4/1 21:14
 * @Description:
 */
import java.util.Stack;
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(!minStack.empty()){
            int top=minStack.peek();
            if(val<=top){
                minStack.push(val);
            }
        }else{
            minStack.push(val);
        }
    }

    public void pop() {
        int pop=stack.pop();
        if(!minStack.empty() && pop==minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


}
