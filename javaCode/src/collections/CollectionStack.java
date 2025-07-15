package collections;

import java.util.Stack;

public class CollectionStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        //for (int i : stack) System.out.println(i);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }


}
