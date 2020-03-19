package ex_20_03_16;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * TODO 并发流程控制
 * Barrier：栅栏
 * 屏障是一种协调机制（一种算法)，它迫使参与并发(或分布式）算法的进程等到它们中的每一个在其程序中达到某一点。
 * 这些协调点的集合称为屏障。 一旦所有进程都达到障碍，它们都被允许继续越过障碍。
 *
 * @author : zhaopanqi
 * @date : Created in 2020\3\16 0016
 */
public class Barriers {

    private int threadCount;
    private CyclicBarrier cyclicBarrier;
    private int loopCount = 10;

    /**
     *
     * @param threadCount 屏障前线程数
     */
    public Barriers (int threadCount) {
        this.threadCount = threadCount;
        cyclicBarrier = new CyclicBarrier(threadCount, () ->{
            this.collectionTestResult();
        });
        for (int i = 0; i < threadCount; i++) {
            new Thread( () -> {
                for (int j = 0; j < loopCount; j++) {
                    this.doTest();
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        return;
                    } catch (BrokenBarrierException e) {
                        return;
                    }
                }
            }, ""+i).start();
        }
    }

    @Deprecated
    private void doTest () {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("********* do Test *********");
    }

    private void collectionTestResult () {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("********** new Barrier **********");
    }

    public static void main(String[] args) {
        Barriers barriers = new Barriers(10);
    }


}
