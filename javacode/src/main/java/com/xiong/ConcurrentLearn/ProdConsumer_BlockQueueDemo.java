package com.xiong.ConcurrentLearn;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/16 20:16
 * @description： 生产者消费者模式 阻塞队列版 生产一个消费一个
 * @modified By：
 * @version: $
 */


public class ProdConsumer_BlockQueueDemo {
    static class MyResource {

        private volatile boolean FLAG = true; //标志位
        private AtomicInteger atomicInteger = new AtomicInteger();
        private BlockingQueue<String> blockingQueue = null;

        public MyResource(BlockingQueue<String> blockingQueue) { //传接口
            this.blockingQueue = blockingQueue;
        }

        public void myProd() throws Exception {
            String data = null;
            boolean retValue;
            while (FLAG) {
                data = atomicInteger.incrementAndGet() + "";
                retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);

                if (retValue) {
                    System.out.println(Thread.currentThread().getName() + "\t插入" + data + "成功");
                } else {
                    System.out.println(Thread.currentThread().getName() + "\t插入" + data + "失败");
                }
                try{ TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e){e.printStackTrace();}
            }
            System.out.println(Thread.currentThread().getName() + "停止生产了，FLAG = false ");
        }

        public void myConsumer() throws Exception {
            String retValue;
            while (FLAG) {
                retValue = blockingQueue.poll(2L, TimeUnit.SECONDS);
                if (null == retValue || retValue.equalsIgnoreCase("")) {
                    FLAG = false;
                    System.out.println(Thread.currentThread().getName() + "\t 超时无数据消费，停止消费");
                    return;// 一定要加return
                    //否则出现
                    //myConumer	 超时无数据消费，停止消费
                    //myConumer	消费null成功
                }
                System.out.println(Thread.currentThread().getName() + "\t消费" + retValue + "成功");
                //这里不暂停 不然 FLAG 变为了 false 就进不来了 看不到： myConumer	 超时无数据消费，停止消费
            }
        }


        public void stop() {
            this.FLAG = false;
        }

    }
    public static void main(String[] args)  {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "myProd1").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "myProd2").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t消费线程启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "myConumer").start();

        try{ TimeUnit.SECONDS.sleep(10); } catch (InterruptedException e){e.printStackTrace();}
        System.out.println("时间到，停止");
        myResource.stop();
    }
}
