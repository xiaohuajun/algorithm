package datastructure.tree;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/9/8 16:42
 * @description 树的节点
 */
public class TreeNode {
    /**
     * 数据
     */
    public int val;
    /**
     * 左孩子的指针
     */
    public TreeNode left;
    /**
     * 右孩子指针
     */
    public TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }

}
