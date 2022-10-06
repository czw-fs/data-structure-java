package 二叉树链表实现及遍历方法和基本方法;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        BinaryTreeByLink B = new BinaryTreeByLink();
        for (int i = 0; i < arr.length; i++) {
            B.add(arr[i]);
        }
//        System.out.println("中序遍历");
        B.inOrder1(B.root);
//        System.out.println();
//        B.inOrder2(B.root);
//        System.out.println();
//        System.out.println("后序遍历");
//        B.postOrder2(B.root);
//        System.out.println();
//        B.postOrder1(B.root);
//        System.out.println("前序遍历");
//        B.preOrder1(B.root);
//          B.preOrder3(B.root);
//        B.levelOrder(B.root);
    }
}
