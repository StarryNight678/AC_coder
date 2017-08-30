package tree;

/**
 * create by  ZhouJianhua  2017/8/30
 * Email: zjhua678@163.com
 */



public class BSTree {

    //根节点
    public static Node root;

    BSTree() {
        this.root = null;
    }

    /**
     * 二叉排序树搜索
     *
     * @param data
     * @return
     */
    int search(int data) {
        Node p = root;
        while (p != null) {

            if (data == p.data) {
                return data;
            }

            if (data < p.data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return -1;
    }


    /**
     * bst添加数据
     *
     * @param n
     */
    void addData(int n) {
        Node myNode = new Node(n, null, null);
        Node p = root;

        if (null == p) {
            root = myNode;
            return;
        }
        while (true) {
            if (n < p.data) {
                if (null == p.left) {
                    p.left = myNode;
                    return;
                } else {
                    p = p.left;
                }
            } else {
                if (null == p.right) {
                    p.right = myNode;
                    return;
                } else {
                    p = p.right;
                }
            }
        }
    }


    /**
     * 创建bst
     *
     * @param arr
     * @return
     */
    Node createTree(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            addData(arr[i]);
        }
        return root;
    }


    /**
     * 中序遍历
     *
     * @param p
     */
    void inordertraverse(Node p) {

        if (null == p) {
            return;
        }
        inordertraverse(p.left);
        System.out.print(p.data + " ");
        inordertraverse(p.right);

    }


    /**
     * 先序遍历
     *
     * @param p
     */
    void preOrderTraverse(Node p) {

        if (null == p) {
            return;
        }
        System.out.print(p.data + " ");
        inordertraverse(p.left);
        inordertraverse(p.right);

    }


    /**
     * 后序遍历
     *
     * @param p
     */
    void PostOrderTraverse(Node p) {

        if (null == p) {
            return;
        }
        inordertraverse(p.left);
        inordertraverse(p.right);
        System.out.print(p.data + " ");

    }

    public static void main(String[] args) {

        int[] arr = {1, 5, 7, 9, 3, 6, 33, 12, 55, 89, 0};
        BSTree BSTree = new BSTree();
        Node root = BSTree.createTree(arr);
        System.out.println("中序遍历");
        BSTree.inordertraverse(root);
        System.out.println();
        System.out.println("先序遍历");
        BSTree.preOrderTraverse(root);
        System.out.println();
        System.out.println("后序遍历");
        BSTree.PostOrderTraverse(root);
        System.out.println();
        System.out.println("search:" + BSTree.search(89));
    }
}
