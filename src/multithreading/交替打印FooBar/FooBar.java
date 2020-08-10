package multithreading.交替打印FooBar;

class FooBar {
    private int n;

    Object lock = new Object();

    volatile boolean isFoo;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (!isFoo) {
                    lock.wait();
                }
                printFoo.run();
                isFoo = !isFoo;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (isFoo) {
                    lock.wait();
                }
                printBar.run();
                isFoo = !isFoo;
                lock.notifyAll();
            }
        }
    }
}