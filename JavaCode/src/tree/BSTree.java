package tree;

/**
 * 二叉排序树
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
     * 节点删除
     * <p>
     * 1) 没有孩子结点
     * 2) 只有左子树或只有右子树
     * 3) 左右子树均不空
     *
     * @param n
     * @return
     */
    int removeNode(int n) {

        Node p = root;
        Node parent = null;
        while (p != null) {

            if (p.data == n) {
                break;
            }
            if (n < p.data) {
                parent = p;
                p = p.left;
            } else {
                parent = p;
                p = p.right;
            }
        }

        if (null == p) {
            return -1;
        }

        //无子节点
        if (p.left == null && p.right == null) {

            if (p.data < parent.data) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return n;
        }

        //一个子节点为空
        if (p.left == null && p.right != null) {
            if (p.data < parent.data) {
                parent.left = p.right;
            } else {
                parent.right = p.right;
            }
            return n;
        }

        if (p.left != null && p.right == null) {
            if (p.data < parent.data) {
                parent.left = p.left;
            } else {
                parent.right = p.left;
            }
            return n;
        }

        //双节点非空
        if (p.left != null && p.right != null) {
            Node s = p.left;
            Node q = p;
            while (s.right != null) {
                q = s;
                s = s.right;
            }

            p.data = s.data;
            if (q != p) {
                q.right = s.left;
            } else {
                q.left = s.left;
            }
            return n;
        }
        return -1;
    }

    /**
     * bst添加数据
     *
     * @param n
     */
    Node addData(Node p, int n) {

        if (null == p) {
            Node myNode = new Node(n, null, null);
            return myNode;
        }
        if (n < p.data) {
            p.left = addData(p.left, n);
        } else {
            p.right = addData(p.right, n);
        }
        return p;
    }


    /**
     * 创建bst
     *
     * @param arr
     * @return
     */
    Node createTree(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            root = addData(root, arr[i]);
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

        int[] arr = {9, 3, 6, 19, 1, 2, 16, 11, 55, 18, 0, 8, 5, 17};
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
        System.out.println("search 89:" + BSTree.search(89));
        System.out.println("search 6:" + BSTree.search(10));
        System.out.println("删除节点");
        int removeResult = BSTree.removeNode(19);
        System.out.println("removeResult:"+removeResult);
        System.out.println("中序遍历");
        BSTree.inordertraverse(root);

    }
}
