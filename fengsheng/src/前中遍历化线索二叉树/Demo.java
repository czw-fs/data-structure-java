package 前中遍历化线索二叉树;

public class Demo {
    public static void main(String[] args){
        int[] arr={1,2,3};
        ThreadBynaryTree T=new ThreadBynaryTree(arr,0);
//            System.out.println("中序遍历中序遍历化线索化二叉树");
//            T.inThreadOrder(T.root);
//            T.inOrderBlack();
//            System.out.println();
//            T.inOrderBefore();
            System.out.println("前序遍历前序遍历化二叉树");
        T.inThreadOrder(T.root);
            T.inOrderBefore();

    }
}
