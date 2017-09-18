package tree;

/**
 * 树的节点
 * create by  ZhouJianhua  2017/8/30
 * Email: zjhua678@163.com
 */
public class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}