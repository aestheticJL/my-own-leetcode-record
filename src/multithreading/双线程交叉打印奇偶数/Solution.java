package multithreading.双线程交叉打印奇偶数;

public class Solution implements Runnable{
    static int sum = 1;

    @Override
    public void run(){
        while (sum <= 100) {
            synchronized (Solution.class) {
                System.out.println(Thread.currentThread().getName() + "打印了：" + sum++);
                Solution.class.notify();
                if (sum <= 100) {
                    try {
                        Solution.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Solution(), "奇数线程池").start();
        Thread.sleep(1);
        new Thread(new Solution(), "偶数线程池").start();

    }
}
