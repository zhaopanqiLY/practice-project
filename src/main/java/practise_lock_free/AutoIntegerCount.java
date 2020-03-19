package practise_lock_free;

import java.util.concurrent.atomic.AtomicInteger;

class Counters {

    private AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * LockFree算法，不需要加锁实现线程安全
     * @param value
     */
    public void add (int value) {
        //多循环几次
        for (int i = 0; i < 10 ; i++) {
            int current = atomicInteger.get();
            if (current < value) {
                //AQS回退
                if (atomicInteger.compareAndSet(current, value)) {
                    break;
                } else {
                    continue;
                }
            } else {
                break;
            }
        }
    }
    public Integer getAtomicInteger() {
        return atomicInteger.get();
    }

}

/**
 * 线程安全的自加
 * @author : zhaopanqi
 * @date : Created in 2020\3\13 0013
 */
public class AutoIntegerCount {

    public static void main(String[] args) {
        Counters counters = new Counters();
        new Thread( () -> {
            int num = 1;
            for (int i = 0; i < 1000 ; i++) {
                num++;
                counters.add(num);
            }
        System.err.println(counters.getAtomicInteger());
        }, "A").start();

        new Thread( () -> {
            int num = 1;
            for (int i = 0; i < 1000 ; i++) {
                num++;
                counters.add(num);
            }
        System.err.println(counters.getAtomicInteger());
        }, "B").start();

    }

}
