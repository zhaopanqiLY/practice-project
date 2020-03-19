package Collection;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 写入时复制技术就是不同进程访问同一资源的时候，只有在写操作，才会去复制一份新的数据，否则都是访问同一个资源。
 * 适当使用会加快程序响应速度
 *
 * @author : zhaopanqi
 * @date : Created in 2020\3\16 0016
 */
public class CopyWriteArrayList {

    List<Object> objects = new CopyOnWriteArrayList<>();

    /**
     *
     * @param o
     * @return
     */
    public boolean add (Object o) {
        return objects.add(o);
    }

    /**
     * 适当使用CopyOnWriteArrayList，增快程序的读操作效率
     */
    public void doXXX () {
        for (Object o : objects) {
            o.toString();
        }
    }

}
