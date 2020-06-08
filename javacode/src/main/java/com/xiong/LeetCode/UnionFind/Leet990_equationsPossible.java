package com.xiong.LeetCode.UnionFind;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/8 14:43
 * @description： 990. 等式方程的可满足性   并查集 uf 法
 * @modified By：
 * @version: $
 */
public class Leet990_equationsPossible {

    public boolean equationsPossible(String[] equations) {
        // 等号的传递性
        //即元素之间的联通性问题，并查集问题
        UF uf = new UF(26);

        // 遍历 建立联通性
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int e1 = equation.charAt(0) - 'a';
                int e2 = equation.charAt(3) - 'a';
                uf.union(e1, e2);
            }
        }

        //检查 是否有不符合连通性的
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int e1 = equation.charAt(0) - 'a';
                int e2 = equation.charAt(3) - 'a';
                boolean flag = uf.connected(e1, e2);
                if (flag) {
                    return false;
                }
            }
        }
        return true;

    }

    class UF {

        private int count;
        //节点 x 的父节点是 parent[x]
        private int[] parent;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                // ⽗节点指针初始指向⾃⼰
                parent[i] = i;
            }
        }

        //将 p 和 q 连接
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            //parent[rootQ] =rootP; 也可以
            parent[rootP] = rootQ;

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
            // 优化：进行路径压缩 ，让 find 以 O(1) 的时间找到某⼀节点的根节点
            while (parent[x] != x) {
                //加上这一句
                //例 ：
                // 3 --> 2 --> 1 可变为
                // 3 --------> 1 <-- 2
                // 即 减小层数 至  最多 2 层
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    }
}
