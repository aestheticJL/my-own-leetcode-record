package multithreading.三个线程打印ABC;

import java.util.concurrent.Semaphore;

class Foo {
    private static Semaphore first = new Semaphore(1);
    private static Semaphore second = new Semaphore(0);
    private static Semaphore third = new Semaphore(0);

    static class First extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    first.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A");
                second.release();
            }
        }
    }

    static class Second extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    second.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B");
                third.release();
            }
        }
    }

    static class Third extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    third.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C");
                first.release();
            }
        }
    }

    public static void main(String[] args) {
        new First().start();
        new Second().start();
        new Third().start();
    }
}