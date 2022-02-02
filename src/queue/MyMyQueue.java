// 제네릭 문법이 부족하여 제네릭 타입으로 작성 못함
// 처음에 isEmpty() 메소드를 사용하지 않고 size()를 사용하였다.

package queue;

import java.util.ArrayList;

public class MyMyQueue {
    private ArrayList<Integer> arrayList1 = new ArrayList<Integer>();

    public void enqueueTest(Integer number) {
        arrayList1.add(number);
    }

    public String dequeueTest() {
        if (arrayList1.isEmpty()) {
            return "null";
        }
        else {
            arrayList1.remove(0);
            return "true";
        }
    }

    public static void main(String[] args) {
        MyMyQueue myQueue = new MyMyQueue();
        myQueue.enqueueTest(1);
        myQueue.enqueueTest(2);
        myQueue.dequeueTest();
        System.out.println(myQueue.arrayList1);
    }
}
