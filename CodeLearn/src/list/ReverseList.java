package list;


/**
 * 翻转单向链表
 * create by  ZhouJianhua  2017/9/2
 * Email: zjhua678@163.com
 */
class Node {
    public int data;
    public Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }

}

public class ReverseList {


    /**
     * 翻转单向链表
     *
     * @param root
     * @return
     */
    Node reverseList(Node root) {
        if (null == root) {
            return null;
        }
        Node current = root;
        Node pre = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        Node root = new Node(arr[0]);
        Node p = root;
        for (int i = 1; i < arr.length; i++) {
            p.next = new Node(arr[i]);
            p = p.next;
        }

        Node tmp = root;
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();

        ReverseList reverseList = new ReverseList();
        Node result = reverseList.reverseList(root);
        System.out.println("reverseList");
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
        System.out.println();
    }
}
