package com.xiong.SortAlgorithm;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/10/30 19:48
 * @description： 队列问题
 * @modified By：
 * @version: $
 */
public class QueueProblems {
    /**
     *  @author: xiongcong
     *  @Date: 2019/10/30 19:50
     *  @Description: 用数组实现 顺序队列 队空条件为 head == tail  队满为 head == 0 && tail == n 需要数据搬移的条件 head != 0 && tail == n
     */
    class ArrayQueue{
        private String[] items;
        private int head;
        private int tail;
        private int n;

        public ArrayQueue(int n){
            items = new String[n];
            this.n = n;
            this.head = 0;
            this.tail = 0;
        }

        //入队 随着不停地进行入队、出队操作，head和tail都会持续往后移动。当tail移动到最右边，
        //即使数组中还有空闲空间，也无法继续往队列中添加数据了。  此时需要数据搬移 条件是当 head != 0 && tail == n
        public boolean enqueue(String data){
            if(tail == n) {
                if (head == 0) {//队满
                    return false;
                }else {//数据搬移 并改变 head 和tail的值
                    for (int i = 0; i < n; i++) {
                        items[i - head] = items[i];
                        tail = tail - head;
                        head = 0;
                    }
                }
            }
            items[tail] = data;
            tail++;
            return true;
        }
        //出队
        public String dequeue(){
            if(head == tail){//队空
                return null;
            }
            String res = items[head];
            head++;
            return res;
        }
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/10/30 20:07
     *  @Description: 数组实现 循环队列 ，关键是队满和队空的条件  ，队空条件为 head == tail  队满为 (tail + 1) % n == head
     */
    class CircularQueue{
        private String[] items;
        private int head;
        private int tail;
        private int n;

        public CircularQueue(int n){
            items = new String[n];
            this.n = n;
            this.head = 0;
            this.tail = 0;
        }
        public boolean enqueue(String data){
            if((tail + 1) % n == head){
                return false;
            }
            items[tail] = data;
            tail = (tail+1) % n;
            return true;
        }
        //出队
        public String dequeue(){
            if(head == tail){
                return null;
            }
            String res = items[head];
            head =(head + 1) % n;
            return res;
        }
    }


}
