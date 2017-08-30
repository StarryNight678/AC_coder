package tree;

/**
 * 先序和中序遍历构造二叉树
 * 参考: http://www.cnblogs.com/bmrs/archive/2010/08/19/SloveTree.html
 * create by  ZhouJianhua  2017/8/30
 * Email: zjhua678@163.com
 */


/**
 * 已知二叉树的前序序列和中序序列，求解树。
 * <p>
 * 1、确定树的根节点。树根是当前树中所有元素在前序遍历中最先出现的元素。
 * <p>
 * 2、求解树的子树。找出根节点在中序遍历中的位置，根左边的所有元素就是左子树，根右边的所有元素就是右子树。
 * 若根节点左边或右边为空，则该方向子树为空；若根节点左边和右边都为空，则根节点已经为叶子节点。
 * <p>
 * 3、递归求解树。将左子树和右子树分别看成一棵二叉树，重复1、2、3步，直到所有的节点完成定位。
 */

class CharNode {
    char data;
    CharNode left;
    CharNode right;

    CharNode(char data, CharNode left, CharNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class PreAndInOrderBuiltTree {

    /**
     * 根节点
     */
    public CharNode root;

    PreAndInOrderBuiltTree() {
        this.root = null;
    }

    CharNode addNode(char data) {


        return null;
    }

    CharNode buildTree(char[] preOrderCharArray, int preOrderStart, int preOrderEnd, char[] inOrderCharArray, int inOrderStart, int inOrderEnd) {


        if (inOrderStart <= inOrderEnd) {

            CharNode p = new CharNode(preOrderCharArray[preOrderStart], null, null);

            char flag = preOrderCharArray[preOrderStart];
            int pos = -1;
            for (int i = inOrderStart; i <= inOrderEnd; i++) {
                if (flag == inOrderCharArray[i]) {
                    pos = i;
                    break;
                }
            }

            p.left = buildTree(preOrderCharArray, preOrderStart + 1, preOrderStart + (pos - inOrderStart), inOrderCharArray, inOrderStart, pos - 1);
            p.right = buildTree(preOrderCharArray, preOrderStart + (pos - inOrderStart) + 1, preOrderEnd, inOrderCharArray, pos + 1, inOrderEnd);

            return p;
        }

        return null;

    }

    /**
     * 先序
     *
     * @param p
     */
    void preOrderTravel(CharNode p) {
        if (null == p) {
            return;
        }
        System.out.print(p.data + " ");
        preOrderTravel(p.left);
        preOrderTravel(p.right);
    }

    /**
     * 中序
     *
     * @param p
     */
    void inOrderTravel(CharNode p) {
        if (null == p) {
            return;
        }
        inOrderTravel(p.left);
        System.out.print(p.data + " ");
        inOrderTravel(p.right);
    }

    public static void main(String[] args) {
        String preOrder = "ABECDFGHIJ";
        char[] preOrderCharArray = preOrder.toCharArray();
        String inOrder = "EBCDAFHIGJ";
        char[] inOrderCharArray = inOrder.toCharArray();
        System.out.println("构建树");
        PreAndInOrderBuiltTree preAndInOrderBuiltTree = new PreAndInOrderBuiltTree();
        CharNode node = preAndInOrderBuiltTree.buildTree(preOrderCharArray, 0, preOrderCharArray.length - 1, inOrderCharArray, 0, inOrderCharArray.length - 1);
        System.out.println("先序遍历");
        preAndInOrderBuiltTree.preOrderTravel(node);
        System.out.println();
        System.out.println("中序遍历");
        preAndInOrderBuiltTree.inOrderTravel(node);
        System.out.println();
    }
}
