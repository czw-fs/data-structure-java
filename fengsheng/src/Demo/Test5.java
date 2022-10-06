package Demo;

import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int val;
    Node(int val) {
        this.val = val;
    }
}
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Test5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        while (in.hasNextInt()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            Node root = createTree(str);
            inorder(root);
        }

    }
    static int i = 0;
    public static Node createTree(String str) {
        Node root = null;
        if (str.charAt(i) != '#') {
            root = new Node(str.charAt(i));
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        } else {
            i++;
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}