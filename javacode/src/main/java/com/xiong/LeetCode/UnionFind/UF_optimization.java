package com.xiong.LeetCode.UnionFind;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/8 11:42
 * @description： 并查集 api 类 的 优化 版本
 * @modified By：
 * @version: $
 */
// 平衡性优化  将时间复杂度 优化至  logN
public class UF_optimization {

    private int count;
    //节点 x 的父节点是 parent[x]
    private int[] parent;
    // 新增⼀个数组记录树的“重量”
    private int[] size;


    public UF_optimization(int n) {
        this.count = n;
        parent = new int[n];
        // 最初每棵树只有⼀个节点
        // 重量应该初始化 1
        size = new int[n];
        for (int i = 0; i < n; i++) {
            // ⽗节点指针初始指向⾃⼰
            parent[i] = i;
            size[i] = 1;
        }
    }

    //将 p 和 q 连接
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // 路径压缩之后 ，这里就没必要了
        // 平衡性优化  将时间复杂度 优化至  logN
        // 修改 union 算法
        // 让小树连接到  大树下面 较平衡
        if (size[rootP] < size[rootQ]){
            parent[rootP] = rootQ;
            // 更新 size
            size[rootQ] += size[rootP];
        }else{
            parent[rootQ] = rootP;
            // 更新 size
            size[rootP] += size[rootQ];
        }

        this.count--;
    }

    //判断 p 和 q 是否相连
    public boolean connected(int p, int q) {
        //节点 p 和 q 连通的话，它们⼀定拥有相同的根节点
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    //返回 图中有多少个连通分量， 即 图中 互不相连的 块 的个数
    public int count() {
        return count;
    }

    //返回某个节点 x 的根节点, 根节点是指向自己的节点 即 parent[i] == i;
    private int find(int x) {
        // 继续优化  进行路径压缩 ，让 find 以 O(1) 的时间找到某⼀节点的根节点
        // 进行路径压缩之后 ，上面的平衡性优化就没有必要了
        while (parent[x] != x) {
            //加上这一句
            //例 ：
            // 3 --> 2 --> 1 可变为
            // 3 --------> 1 <-- 2
            // 即 减小层数 至  最多 2 层
            parent[x] = parent[parent[x]];
            // 下一轮
            x = parent[x];
        }
        return x;
    }

}
