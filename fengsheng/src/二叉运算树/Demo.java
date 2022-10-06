package 二叉运算树;

public class Demo {
    public static void main(String[] args) {
        char[] ch={' ','+','*','%','6','3','9','5'};
        BinaryTree B=new BinaryTree(ch,1);

        System.out.println("中");
        B.inOrder(B.root);
        System.out.println();

        System.out.println("前");
        B.preOrder(B.root);
        System.out.println();

        System.out.println("后");
        B.postOrder(B.root);
        System.out.println();

        System.out.println("答案");
        System.out.println(B.answer(B.root));
    }
}
