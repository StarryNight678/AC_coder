package tree;

import java.util.LinkedList;

/**
 * create by  ZhouJianhua  2017/8/30
 * Email: zjhua678@163.com
 */
public class TravelTree {

    //根节点
    Node root;

    public TravelTree(Node root) {
        this.root = root;
    }


    /**
     * 统计节点数
     *
     * @param p
     * @return
     */
    int count(Node p) {

        if (null == p) {
            return 0;
        }

        return 1 + count(p.left) + count(p.right);

    }

    /**
     * 统计二叉树深度
     *
     * @param p
     * @return
     */
    int depth(Node p) {

        if (null == p) {
            return 0;
        }

        return 1 + Math.max(depth(p.left), depth(p.right));

    }


    /**
     * 深度优先遍历
     *
     * @param root
     */
    void depthOrderTraversal(Node root) {
        Node p = root;

        if (null == p) {
            return;
        }
        System.out.print(p.data + " ");
        depthOrderTraversal(p.left);
        depthOrderTraversal(p.right);

    }

    /**
     * 广度优先遍历
     *
     * @param root
     */
    void levelOrderTraversal(Node root) {
        Node p = root;
        if (null == p) {
            return;
        }
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.add(p);

        while (!linkedList.isEmpty()) {
            Node tmp = linkedList.poll();
            System.out.print(tmp.data + " ");
            if (tmp.left != null) {
                linkedList.add(tmp.left);
            }
            if (tmp.right != null) {
                linkedList.add(tmp.right);
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 6, 19, 1, 2, 16, 11, 55, 18, 0, 8};
        BSTree bSTree = new BSTree();
        Node root = bSTree.createTree(arr);

        TravelTree travelTree = new TravelTree(root);
        System.out.println("节点数:" + travelTree.count(travelTree.root));
        System.out.println("深度:" + travelTree.depth(travelTree.root));
        System.out.println("深度优先遍历");
        travelTree.depthOrderTraversal(travelTree.root);
        System.out.println();
        System.out.println("广度优先遍历");
        travelTree.levelOrderTraversal(travelTree.root);
        System.out.println();
    }

}
