package 多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 交替打印2 {
    boolean flag=true;
    ReentrantLock lock=new ReentrantLock();
    Condition A=lock.newCondition();
    Condition B=lock.newCondition();
    Condition C=lock.newCondition();
    public void printA() throws InterruptedException {
        lock.lock();
        if(!flag){
            A.await();
        }
        flag=false;
        System.out.println(Thread.currentThread().getName()+"A");
        Thread.sleep(1000);
        B.signal();
        lock.unlock();

    }
    public void printB() throws InterruptedException {
        lock.lock();
        B.await();
        System.out.println(Thread.currentThread().getName()+"B");
        Thread.sleep(1000);
        C.signal();
        lock.unlock();
    }
    public void printC() throws InterruptedException {
        lock.lock();
        C.await();
        System.out.println(Thread.currentThread().getName()+"C");
        Thread.sleep(1000);
        A.signal();
        lock.unlock();
    }

    public static void main(String[] args) {
        交替打印2 test=new 交替打印2();
        new Thread(()-> {
            try {
                while(true) {
                    test.printC();
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
                    test.printA();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
