import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        List<Integer> num = new ArrayList();
        Collections.sort(num, (s1, s2) -> s1.compareTo(s2));

        Lock lock = new ReentrantLock();
        lock.tryLock();
        Integer a = new Integer(100);
        Integer b = new Integer(100);
        System.out.println(a == b);
        Integer.valueOf(1).intValue();
        //int类型可取的最大值：2147483647
        System.out.println(Integer.MAX_VALUE);
        //int类型可取的最小值：-2147483648
        System.out.println(Integer.MIN_VALUE);
        //char类型可取的最大值：65535
        System.out.println(Character.MAX_VALUE + 0); //加0转为int显示
        //char类型可取的最小值：0
        System.out.println(Character.MIN_VALUE + 0);
        //int类型的二进制位数：32
        System.out.println(Integer.SIZE);
        //所表示的基本类型：int
        System.out.println(Integer.TYPE);
    }
}
