package 后序遍历化线索二叉树;

public class Demo {
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6,7,8,9};
        postThreadBinaryTree P=new postThreadBinaryTree(arr,0);
        P.postThreadOrder(P.root);
        P.postOrderBinaryTree();
    }
}
