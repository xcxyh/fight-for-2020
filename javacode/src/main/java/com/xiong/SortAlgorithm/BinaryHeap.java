package com.xiong.SortAlgorithm;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/12 9:41
 * @description： 构建一个 大顶堆
 * @modified By：
 * @version: $
 */
public class BinaryHeap {

    private Integer[] priorityQueue;

    private int N = 0;

    private int capacity;

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        priorityQueue = new Integer[capacity + 1];
    }

    // 从索引 1 开始
    public int max() {
        return priorityQueue[1];
    }

    //返回父节点的索引
    private int parent(int root) {
        return root / 2;
    }

    //返回左孩子节点的索引
    private int left(int root) {
        return root * 2;
    }

    //返回右孩子节点的索引
    private int right(int root) {
        return root * 2 + 1;
    }

    //向堆中插入一个元素 从堆底插入
    public void insert(Integer element) {
        N++;

        if (N <= capacity) {
            //添加到最后面
            priorityQueue[N] = element;
            // 上浮
            swim(N);
        } else {
            System.out.println("堆满了,先删掉堆顶，再插入");
            deleteMax();
            insert(element);
        }
    }

    //从堆中删除堆顶元素 并返回
    public int deleteMax() {
        int max = priorityQueue[1];
        // 把它换到最后 删除
        swap(1, N);
        priorityQueue[N] = null;
        N--;
        // 让换上来的 这个的元素 下沉到正确的位置
        sink(1);
        return max;
    }

    //上浮操作 大顶堆  大的上浮，  k 为元素的索引
    private void swim(int k) {

        while (k > 1 && isilessj(parent(k), k)) {
            // 第 k 个元素比 它父节点大 上浮
            swap(parent(k), k);
            k = parent(k);
        }

    }

    //下沉操作 大顶堆 小的下沉  ，  k 为元素的索引
    private void sink(int k) {
        //
        while (left(k) <= N) {
            int older = left(k);
            // 右孩子存在， 并且 值  大于 左孩子
            if (right(k) <= N && isilessj(older, right(k))) {
                older = right(k);
            }
            // k 位置 元素 比 这个 大的还大， 不用下沉
            if (isilessj(older, k)) {
                break;
            }
            //否则交换
            swap(k, older);
            k = older;
        }

    }

    //交换数组中两个元素的位置  传入的参数是 索引
    private void swap(int i, int j) {
        int temp = priorityQueue[i];
        priorityQueue[i] = priorityQueue[j];
        priorityQueue[j] = temp;
    }

    //比较数组中两个元素的大小 传入的参数是 索引
    private boolean isilessj(int i, int j) {
        return priorityQueue[i] < priorityQueue[j];
    }
}
