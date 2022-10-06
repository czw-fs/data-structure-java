package Demo;

import java.util.Stack;

/**
 * @author: fs
 * @date: 2022/4/5 9:20
 * @Description:
 */
public class Test3 {
}

 class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(){}
    public TreeNode(int value){
        this.value=value;
        left=null;
        right=null;
    }
}


class Solution {
    public boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
        if (root == null || node == null) return false;

        stack.push(root);

        if (root == node) return true;

        boolean flag = getPath(root.left, node, stack);
        if (flag == true) return true;

        flag = getPath(root.right, node, stack);
        if (flag == true) return true;

        stack.pop();
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        getPath(root, p, stack1);
        getPath(root, q, stack2);

        Stack<TreeNode> stackmax = stack1.size() > stack2.size() ? stack1 : stack2;
        Stack<TreeNode> stackmin = stackmax == stack1 ? stack2 : stack1;

        while (!stackmax.isEmpty() && !stackmin.isEmpty() && stackmax.size() != stackmin.size()) {
            stackmax.pop();
        }

        while (!stackmax.isEmpty() && !stackmin.isEmpty()) {
            if (stackmax.peek() == stackmin.peek()) {
                return stackmax.peek();
            } else {
                stackmax.pop();
                stackmin.pop();
            }
        }
        return null;
    }
}