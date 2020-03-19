package ex_20_03_16;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 匿名内部类样例
 *
 * @author : zhaopanqi
 * @date : Created in 2020\3\17 0017
 */
abstract class Person {
    public abstract void eat ();
}

public class Demo {


    public static void main(String[] args) {

        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(1, 1);

        // 用int做时间戳

        AtomicStampedReference<Integer> tail = new AtomicStampedReference<Integer>(null, 0);

        int[] currentStamp = new int[1];

        // currentStamp中返回了时间戳信息

        Integer tailNode = tail.get(currentStamp);

        tail.compareAndSet(tailNode, null, currentStamp[0], currentStamp[0] + 1);

        int i = 0;
            Person p = new Person() {
                @Override
                public void eat() {
                    System.err.println("eat!"+i);
                }
            };
            p.eat();
    }

}
