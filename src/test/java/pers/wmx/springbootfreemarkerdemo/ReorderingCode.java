package pers.wmx.springbootfreemarkerdemo;

import java.util.concurrent.CountDownLatch;

/**
 * @author: wangmingxin03
 * @date: 2020-04-13
 */
public class ReorderingCode {

    private static int A=0,B=0;

    //volatile 防止指令重排序
    private volatile static int a=0,b=0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(1);
        int sum=0;

        for (;;){

            // A B a b重新置为0，避免之前的赋值影响后续的结果
            A=0;
            B=0;
            a=0;
            b=0;
            sum++;
            Thread thread1 = new Thread(new Runnable()  {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a=1;
                    A=b;
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b=1;
                    B=a;
                }
            });
            thread1.start();
            thread2.start();

            //放行 目的是为了让thread1、thread2都启动
            countDownLatch.countDown();

            //目的是为了让thread1、thread2 都执行完，在执行主程序
            thread1.join();
            thread2.join();

//            if (A==0 && B==0){
//                System.out.println("执行了"+sum+"次"+"A="+A+","+"B="+B);
//                break;
//            };

            if (A==1 && B==1){
                System.out.println("执行了"+sum+"次"+"A="+A+","+"B="+B);
                break;
            };
        }

    }

}
