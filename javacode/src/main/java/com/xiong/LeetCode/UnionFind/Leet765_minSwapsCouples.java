package com.xiong.LeetCode.UnionFind;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/2/14 11:30
 * @description：  765. 情侣牵手   并查集  将一对情侣看成一个节点 ，如果 两个相邻的人不是情侣， 就连一条边
 * @modified By：
 * @version: $
 */
public class Leet765_minSwapsCouples {


    public int minSwapsCouples(int[] row) {
        int len = row.length / 2;
        UnionFind uf = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            int x = row[2 * i] / 2;
            int y = row[2 * i + 1] / 2;
            if (x != y) {
                uf.union(x, y);
            }
        }
        //对每个连通分量分别统计节点的数量，其实总数就是连通分量去掉代表元的数量(每个连通分量的节点数量-1相加)
        //相当于节点数量减去连通分量的数量
        return len - uf.getCount();
    }

    /**
     * 并查集模板
     */
    private static class UnionFind {
        private int[] parent;

        private int count;

        public UnionFind(int len) {
            this.parent = new int[len];
            this.count = len;
            //初始化，每个节点的父节点就是自己
            for (int i = 0; i < len; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                //路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                this.count -= 1;
                return true;
            } else {
                return false;
            }
        }

        public int getCount() {
            return count;
        }
    }
}
