package com.xiong.LeetCode.BinarySearchTree.RedBlackTree;


/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/24 16:34
 * @description： 红黑树
 * ①创建RBTree，定义颜色
 * ②创建RBNode
 * ③辅助方法定义：parentOf(node)，isRed(node)，setRed(node)，setBlack(node)，inOrderPrint(RBNode tree)
 * ④左旋方法定义：leftRotate(node)
 * ⑤右旋方法定义：rightRotate(node)
 * ⑥公开插入接口方法定义：insert(K key, V value);
 * ⑦内部插入接口方法定义：insert(RBNode node);
 * ⑧修正插入导致红黑树失衡的方法定义：insertFIxUp(RBNode node);
 * ⑨测试红黑树正确性
 */
public class RBTree<K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    //红黑树的树根
    private RBNode root;

    public RBNode getRoot() {
        return root;
    }

    // 公开的插入方法
    public void insert(K key, V value) {
        RBNode<K, V> node = new RBNode<>();
        node.setKey(key);
        node.setValue(value);
        //插入的节点一定是红色
        node.setColor(RED);
        insert(node);
    }

    /**
     * 内部插入接口定义, 实际上为一个 二叉搜索树的插入操作 ，
     * 只是在最后多了一步自平衡的过程
     * 这里即 insertFixUp(node) 方法
     */
    private void insert(RBNode node) {
        RBNode parent = null;
        //首先要找到 插入位置，即找到 要插入节点的 父节点 应该是 哪一个
        RBNode x = this.root;

        while (x != null) {
            parent = x;

            //a > b 则返回 1，否则返回 -1 ，相等返回0
            int cmp = node.key.compareTo(parent.key);

            if (cmp > 0) {
                x = x.right;
            } else if (cmp < 0) {
                x = x.left;
            } else {
                parent.setValue(node.value);
                return; // 替换完了， 必须返回， 不走下面的 代码
            }
        }
        //从 node 指向 parent
        node.parent = parent;
        //从 parent 指向 node
        if (parent != null) {
            if (node.key.compareTo(parent.key) < 0) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        } else {
            this.root = node;
        }

        //插入之后需要进行修复红黑树，让红黑树再次平衡。
        insertFixUp(node);
    }

    /**
     * 插入后修复红黑树平衡的方法
     * |---情景1：红黑树为空树  染根节点为黑色
     * |---情景2：插入节点的key已经存在， 不用做处理
     * |---情景3：插入节点的父节点为黑色 ，不改变平衡性， 不用做处理
     * <p>
     * 情景4 需要咱们去处理
     * |---情景4：插入节点的父节点为红色
     * |---情景4.1：叔叔节点存在，并且为红色（父-叔 双红）
     * |---情景4.2：叔叔节点不存在，或者为黑色，父节点为爷爷节点的左子树
     * |---情景4.2.1：插入节点为其父节点的左子节点（LL情况）
     * |---情景4.2.2：插入节点为其父节点的右子节点（LR情况）
     * |---情景4.3：叔叔节点不存在，或者为黑色，父节点为爷爷节点的右子树
     * |---情景4.3.1：插入节点为其父节点的右子节点（RR情况）
     * |---情景4.3.2：插入节点为其父节点的左子节点（RL情况）
     */
    private void insertFixUp(RBNode node) {
        RBNode parent = parentOf(node);
        RBNode gparent = parentOf(parent);
        //情景4 : 存在父节点且父节点为红色
        if (parent != null && isRed(parent)) {
            //父节点是红色的，那么一定存在爷爷节点

            // 父节点为爷爷节点的左子树  L
            if (parent == gparent.left) {
                RBNode uncle = gparent.right;
                //4.1：叔叔节点存在，并且为红色（父-叔 双红）
                //将父和叔染色为黑色，再将爷爷染红，并将爷爷设置为当前节点，进入下一次循环判断
                if (uncle != null && isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    insertFixUp(gparent);
                    return;
                }
                //叔叔节点不存在，或者为黑色，父节点为爷爷节点的左子树
                if (uncle == null || isBlack(uncle)) {
                    // 4.2.1：插入节点为其父节点的左子节点（LL情况）
                    //变色（父节点变黑，爷爷节点变红），右旋爷爷节点
                    if (node == parent.left){
                        setBlack(parent);
                        setRed(gparent);
                        rightRotate(gparent);
                        return;
                    }else{//4.2.2：插入节点为其父节点的右子节点（LR情况）
                        //左旋（父节点），当前节点设置为父节点，进入下一次循环
                        // 变为 LL情况
                        leftRotate(parent);
                        insertFixUp(parent);
                        return;
                    }
                }

            } else { //父节点为爷爷节点的右子树 R
                RBNode uncle = gparent.left;
                //4.1：叔叔节点存在，并且为红色（父-叔 双红）
                //将父和叔染色为黑色，再将爷爷染红，并将爷爷设置为当前节点，进入下一次循环判断
                if (uncle != null && isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    insertFixUp(gparent);
                    return;
                }

                //叔叔节点不存在，或者为黑色，父节点为爷爷节点的右子树
                if(uncle == null || isBlack(uncle)) {
                    //4.3.1：插入节点为其父节点的右子节点（RR情况）
                    //变色（父节点变黑，爷爷节点变红），左旋爷爷节点
                    if (node == parent.right){
                        setBlack(parent);
                        setRed(gparent);
                        leftRotate(gparent);
                        return;
                    }else{//4.3.2：插入节点为其父节点的左子节点（RL情况）
                        //右旋（父节点），当前节点设置为父节点，进入下一次循环
                        // 变为 RR情况
                        rightRotate(parent);
                        insertFixUp(parent);
                        return;
                    }
                }

            }
        }
        //根节点为黑色
        setBlack(this.root);
    }


    /**
     * 左旋方法
     * 左旋示意图：左旋x节点
     * p                   p
     * | (2)               |
     * x                   y
     * / \     ---->   (3) / \
     * lx  y               x   ry
     * (1)/ \             / \
     * ly  ry          lx  ly
     * <p>
     * 左旋做了几件事？
     * 1.将y的左子节点赋值给x的右边，并且把x设置为y的左子节点的父节点
     * 2.将x的父节点（非空时）指向y，更新y的父节点为x的父节点
     * 3.将y的左子节点指向x，更新x的父节点为y
     */
    private void leftRotate(RBNode x) {
        //获取y
        RBNode y = x.right;
        //1 将y的左子节点赋值给x的右边
        x.right = y.left;
        //并且把x设置为y的左子节点的父节点
        if (y.left != null) {
            y.left.parent = x;
        }

        // 2 将x的父节点（非空时）指向y
        if (x.parent != null) {
            //更新y的父节点为x的父节点
            y.parent = x.parent;
            //判断 x 在 parent 的左还是右
            if (x == x.parent.left) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        } else {
            this.root = y;
            this.root.parent = null;
        }

        //3 将y的左子节点指向x，更新x的父节点为y
        y.left = x;
        x.parent = y;
    }

    /**
     * 右旋方法
     * 右旋示意图：右旋y节点
     * <p>
     * p                       p
     * |                       |
     * y                       x
     * / \          ---->      / \
     * x   ry                  lx  y
     * / \                         / \
     * lx  ly                      ly  ry
     * <p>
     * 右旋都做了几件事？
     * 1.将x的右子节点 赋值 给了 y 的左子节点，并且更新x的右子节点的父节点为 y
     * 2.将y的父节点（不为空时）指向x，更新x的父节点为y的父节点
     * 3.将x的右子节点指向y，更新y的父节点为x
     */
    private void rightRotate(RBNode y) {
        RBNode x = y.left;
        //1 将x的右子节点 赋值 给了 y 的左子节点
        y.left = x.right;
        //并且更新x的右子节点的父节点为 y
        if (x.right != null) {
            x.right.parent = y;
        }

        //2 将y的父节点（不为空时）指向x
        if (y.parent != null) {
            //更新x的父节点为y的父节点
            x.parent = y.parent;

            if (y == y.parent.left) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        } else {
            this.root = x;
            this.root.parent = null;
        }
        // 3 将x的右子节点指向y，更新y的父节点为x
        x.right = y;
        y.parent = x;
    }


    private RBNode parentOf(RBNode node) {
        if (node != null) {
            return node.parent;
        }
        return null;
    }

    private boolean isRed(RBNode node) {
        if (node != null) {
            return node.color == RED;
        }
        return false;
    }

    private boolean isBlack(RBNode node) {
        if (node != null) {
            return node.color == BLACK;
        }
        return false;
    }

    private void setRed(RBNode node) {
        if (node != null) {
            node.color = RED;
        }
    }

    private void setBlack(RBNode node) {
        if (node != null) {
            node.color = BLACK;
        }
    }

    //公开出去
    public void inorderPrint() {
        if (root != null) {
            inorderPrint(this.root);
        }
    }

    private void inorderPrint(RBNode node) {
        if (node != null) {
            inorderPrint(node.left);
            System.out.println("key -> " + node.key + ", value -> " + node.value);
            inorderPrint(node.right);
        }
    }

    static class RBNode<K extends Comparable<K>, V> {

        private RBNode parent;
        private RBNode left;
        private RBNode right;
        private K key;
        private V value;
        private boolean color;

        public RBNode() {
        }

        public RBNode(RBNode parent, RBNode left, RBNode right, K key, V value, boolean color) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
            this.color = color;
        }

        public RBNode getParent() {
            return parent;
        }

        public void setParent(RBNode parent) {
            this.parent = parent;
        }

        public RBNode getLeft() {
            return left;
        }

        public void setLeft(RBNode left) {
            this.left = left;
        }

        public RBNode getRight() {
            return right;
        }

        public void setRight(RBNode right) {
            this.right = right;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }
    }


}
