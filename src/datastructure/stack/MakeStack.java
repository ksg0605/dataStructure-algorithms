// 쉽게 해결함

package datastructure.stack;

import java.util.ArrayList;

public class MakeStack<T> {
    private ArrayList<T> array = new ArrayList<T>();

    public void push(T item) {
        array.add(item);
    }

    public T pop() {
        Integer size = array.size();
        if (array.isEmpty()) {
            return null;
        }
        return array.remove(size - 1);
    }

    public static void main(String[] args) {
        MakeStack<Integer> makeStack = new MakeStack<Integer>();
        makeStack.push(1);
        makeStack.push(2);
        makeStack.push(3);
        System.out.println(makeStack.pop());
        System.out.println(makeStack.pop());
        System.out.println(makeStack.pop());
    }
}