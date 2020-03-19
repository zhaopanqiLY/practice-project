package practise_lock_free;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 进一步使用lock_free数据结构
 * 通过普通map加锁来实现
 *
 * @author : zhaopanqi
 * @date : Created in 2020\3\14 0014
 */
public class BeanManager {

    Map<String, Object> map = new HashMap<>();

    //指定key值
    public Object getBean (String key) {
        synchronized (map) {
            Object bean = map.get(key);
            if (bean == null) {
                map.put(key, createBean());
                bean = map.get(key);
            }
            return bean;
        }
    }

    private Object createBean() {
        return null;
    }

}

class BeanManager2 {

    ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();

    //指定key值
    public Object getBean (String key) {
        Object bean = map.get(key);
        if (bean == null) {
            //如果传入key对应的value已经存在，就返回存在的value，不进行替换。如果不存在，就添加key和value，返回null
            map.putIfAbsent(key, createBean());
            bean = map.get(key);
        }
        return bean;
    }
private Object createBean() {
    return null;
}
}

