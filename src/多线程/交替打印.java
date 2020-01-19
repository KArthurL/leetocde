package 多线程;

import java.util.concurrent.Semaphore;

public class 交替打印 {

    private Semaphore semaphoreA=new Semaphore(1);
    private Semaphore semaphoreB=new Semaphore(0);
    private Semaphore semaphoreC=new Semaphore(0);
    public void printA() throws InterruptedException {
        semaphoreA.acquire();
        System.out.println(Thread.currentThread().getName()+"A");
        Thread.sleep(2000);
        semaphoreB.release();
    }
    public void printB() throws InterruptedException {
        semaphoreB.acquire();
        System.out.println(Thread.currentThread().getName()+"B");
        Thread.sleep(2000);
        semaphoreC.release();
    }

    public void printC() throws InterruptedException {
        semaphoreC.acquire();
        System.out.println(Thread.currentThread().getName()+"C");
        Thread.sleep(2000);
        semaphoreA.release();
    }


    public static void main(String[] args) {
        交替打印 test=new 交替打印();

        new Thread(()-> {
            try {
                while(true) {
                    test.printA();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                while(true) {
                    test.printB();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                while(true) {
                    test.printC();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
