package reptile;

/**
 * 每次运行对象的.hashCode()的值代表的是对象的地址，然而每次运行的结果是一样的
 * 代表这个程序运行的位置是确定的
 *
 * 非内核程序从不使用绝对内存地址，它们使用虚拟内存，每个进程在其中获得自己的地址空间。
 * 因此，在每次运行中，确定性程序会将东西放置在同一位置，这并不奇怪。
 *
 * @author : zhaopanqi
 * @date : Created in ${date}
 */
public class EqualityIndex {

    private int index;

    public EqualityIndex(int initialIndex) {
        this.index = initialIndex;
    }

    public static void main(String[] args) {
        EqualityIndex ei1 = new EqualityIndex(3);
        EqualityIndex ei2 = new EqualityIndex(3);
        System.err.println(ei1.hashCode());
        System.err.println(ei2.hashCode());
        System.err.println("2".hashCode());
    }

}
