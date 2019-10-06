package datastructure.tree;

import java.util.*;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/9/8 17:51
 * @description 树的操作
 */
public class TreeOperate {


    /**
     * 创建二叉树
     *
     * @param node 一个节点
     * @param data 传入节点的数据
     * @return
     */
    public static TreeNode createTree(TreeNode node, int data) {
        if (node == null) {
            //创建节点
            node = new TreeNode(data);
            node.val = data;
            return node;
        } else {
            //当前节点的数据和上一个节点数据比较
            if (data > node.val) {
                node.right = createTree(node.right, data);
            } else {
                node.left = createTree(node.left, data);
            }
        }
        return node;
    }

    public static TreeNode findNode(TreeNode node, int data) {
        if (node == null) {
            System.out.println("没有找到节点");
            return null;
        }
        if (data > node.val) {
            node = findNode(node.right, data);
            return node;
        } else if (data < node.val) {
            node = findNode(node.left, data);
            return node;
        } else {
            System.out.println("没有找到节点");
            return null;
        }
    }

    /**
     * 递归遍历二叉树的入口方法
     *
     * @return 遍历的结果
     */
    public static List<Integer> treeTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) {
            return res;
        }
        helper(root, res);
        return res;
    }

    /**
     * 递归前序遍历
     * 1、先遍历根节点
     * 2、遍历左子节点，若左孩子为空，再遍历右孩子
     * 3、遍历右子节点，若有孩子为空，返回上一层遍历
     *
     * @param root 根节点
     * @param res  遍历结果
     */
    private static void helper(TreeNode root, List<Integer> res) {
        //先遍历根节点
        res.add(root.val);
        if (root.left != null) {
            //遍历左子节点
            helper(root.left, res);
        }
        if (root.right != null) {
            //遍历右边子节点
            helper(root.right, res);
        }
    }

    /**
     * 递归中序遍历
     * 1、先遍历左子结点，若左子结点为空返回上一层的根节点
     * 2、根节点
     * 3、右子节点
     *
     * @param root 根节点
     * @param res  遍历结果
     */
    public static void helperInOrder(TreeNode root, List<Integer> res) {
        if (root.left != null) {
            helperInOrder(root, res);
        }
        res.add(root.val);
        if (root.right != null) {
            helperInOrder(root, res);
        }
    }

    /**
     * 递归后序遍历
     * 1、左子节点
     * 2、右子节点
     * 3、根节点
     *
     * @param root 根节点
     * @param res  遍历结果
     */
    public static void helperLastOrder(TreeNode root, List<Integer> res) {
        if (root.left != null) {
            helperInOrder(root, res);
        }
        if (root.right != null) {
            helperInOrder(root, res);
        }
        res.add(root.val);
    }

    /**
     * 迭代法-前序遍历
     * 利用栈来存放节点
     * 每次都弹出栈顶元素
     * 由于栈是后进先出，先压入右子节点，再压入左子节点
     *
     * @param root 根节点
     * @return 遍历结果
     */
    public static List<Integer> preOrderTraversalForStack(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) {
            return res;
        }
        //利用栈来存放遍历的节点
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        //先把根节点入栈
        nodeStack.push(root);
        while (nodeStack.size() != 0) {
            //根节点出栈
            root = nodeStack.pop();
            res.add(root.val);
            //先压入右子节点
            if (root.right != null) {
                nodeStack.push(root.right);
            }
            //再压入左子节点
            if (root.left != null) {
                nodeStack.push(root.left);
            }
        }
        return res;
    }

    /**
     * 迭代法-中序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) {
            return res;
        }
        TreeNode curr = root;
        Stack<TreeNode> node = new Stack<TreeNode>();
        while (curr != null || node.size() != 0) {
            //遍历左子节点入栈，直到curr.left为空
            while (curr != null) {
                node.push(curr);
                curr = curr.left;
            }
            //弹出curr
            curr = node.pop();
            res.add(curr.val);
            //取其右子节点，进而取其左子节点
            curr = curr.right;
        }
        return res;
    }

    /**
     * 迭代法-后序遍历
     * 一、
     * 1、把前序遍历（根左右）改为根右左再反转
     *
     * @param root 根节点
     * @return 遍历的结果
     */
    public static List<Integer> lastOrderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        if (root == null) {
            return res;
        }
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            //pop()弹出栈顶元素并返回值，peek():取栈顶元素的值，但元素不出栈
            root = nodeStack.pop();
            res.add(root.val);
            if (root.left != null) {
                nodeStack.push(root.left);
            }
            if (root.right != null) {
                nodeStack.push(root.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 层次遍历
     *
     * @param root 根节点
     * @return
     */
    private List<List<Integer>> levels = new LinkedList<List<Integer>>();

    /**
     * 层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> layerTraversal(TreeNode root) {
        if (root == null) {
            return levels;
        }
        helperLayerTraversal(root, 0);
        return levels;
    }

    /**
     * 递归调用
     *
     * @param root  当前节点
     * @param level 当前节点所在的层
     */
    public void helperLayerTraversal(TreeNode root, int level) {
        if (levels.size() == level) {
            //里面还没有元素，创建结果集合
            levels.add(new LinkedList<Integer>());
        }
        //添加节点值到结果集合
        levels.get(level).add(root.val);

        //如果当前节点存在左子节点，添加进去
        if (root.left != null) {
            helperLayerTraversal(root.left, level + 1);
        }
        if (root.right != null) {
            helperLayerTraversal(root.right, level + 1);
        }
    }

    /**
     * 层次遍历-利用队列
     *
     * @param root 根节点
     * @return 遍历的结果
     */
    public static List<List<Integer>> layerTraversalForQueue(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<Integer>();
            int count = queue.size();
            while (count > 0) {
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                count--;
            }
            res.add(list);
        }
        return res;
    }


    public static void main(String[] args) {
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.isEmpty();
        nodeStack.pop();
        int[] arr = {1, 2, 3};
        TreeNode root = new TreeNode(11);
        //从root开始创建
        for (int i : arr) {
            System.out.println(createTree(root, i));
        }
        System.out.println("查找节点");
        findNode(root, 7);

    }

}
