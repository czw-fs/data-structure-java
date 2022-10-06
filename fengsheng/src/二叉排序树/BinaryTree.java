package 二叉排序树;


public class BinaryTree {

    public TreeNode root;

    //添加节点
    public void add(int data) {
        TreeNode newNode = new TreeNode(data);
        //建立树根
        if (root == null) {
            root = newNode;
            return;
        }
        TreeNode cur = root;
        while (true) {
            if (newNode.value < cur.value) {
                if (cur.left == null) {
                    cur.left = newNode;
                    return;
                } else {
                    cur = cur.left;
                }
            } else {
                if (cur.right == null) {
                    cur.right = newNode;
                    return;
                } else {
                    cur = cur.right;
                }
            }
        }
    }
    //中序遍历
    public void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.value+" ");
            inOrder(root.right);
        }
    }
}
