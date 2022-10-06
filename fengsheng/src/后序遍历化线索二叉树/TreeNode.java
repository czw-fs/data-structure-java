package 后序遍历化线索二叉树;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    boolean lef=false;
    boolean rig=false;
    public TreeNode(){}
    public TreeNode(int data){
        this.value=data;
        left=null;
        right=null;
    }
}

