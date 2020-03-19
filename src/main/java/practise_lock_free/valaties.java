package practise_lock_free;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author : zhaopanqi
 * @date : Created in 2020\3\18 0018
 */
public class valaties {

    public static volatile int race = 0;
    private
    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    private ExecutorService executors = new ThreadPoolExecutor();

    public static void main(String[] args) {


        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable(){
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                }
            });
            //new Thread( () -> {for (int j = 0; j < 10000; j++) { increase(); }}).start();
            threads[i].start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(race);
    }


}
