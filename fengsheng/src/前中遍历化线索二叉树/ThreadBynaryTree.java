package 前中遍历化线索二叉树;

public class ThreadBynaryTree {
    TreeNode root;
    TreeNode pre;

    public ThreadBynaryTree(int[] arr, int index) {
        root = creatBinaryTree(arr, index);
    }

    //利用数组创建二叉树
    public TreeNode creatBinaryTree(int[] arr, int index) {
        if (index >= arr.length) {
            return null;
        } else {
            TreeNode tmp = new TreeNode(arr[index]);
            tmp.left = creatBinaryTree(arr, 2 * index + 1);
            tmp.right = creatBinaryTree(arr, 2 * index + 2);
            return tmp;
        }
    }

    //中序线索化二叉树
    public void inThreadOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        //处理左子树
        inThreadOrder(root.left);
        if (root.left == null) {
            root.left = pre;
            root.lef = true;
        }
        //前一个节点的后继结点指向当前节点
        if (pre != null && pre.right == null) {
            pre.right = root;
            pre.rig = true;
        }
        pre = root;
        inThreadOrder(root.right);
    }

    //中序遍历线索二叉树，按照后继方式遍历
    public void inOrderBlack() {
        TreeNode cur = root;
        while (cur != null && !cur.lef) {
            cur = cur.left;
        }
        while (cur != null) {
            System.out.print(cur.value + " ");
            if (cur.rig) {
                cur = cur.right;
            } else {
                cur = cur.right;
                while (cur != null && !cur.lef)
                    cur = cur.left;
            }
        }
    }

    //中序遍历线索二叉树，按照前驱方式遍历
    public void inOrderBefore() {
        TreeNode cur = root;
        while (cur.right != null && !cur.rig)
            cur = cur.right;
        while (cur != null) {
            System.out.print(cur.value + " ");
            if (cur.lef) {
                cur = cur.left;
            } else {
                cur = cur.left;
                while (cur.right != null && !cur.rig)
                    cur = cur.right;
            }
        }
    }

    //前序遍历线索化二叉树
    public void preOrderBinaryTrree(TreeNode root) {
        if (root == null)
            return;
        //左指针为空，将左指针指向前驱节点
        if (root.left == null) {
            root.left = pre;
            root.lef = true;
        }
        //将前一个节点的后继节点指向当前节点
        if (pre != null && pre.right == null) {
            pre.right = root;
            root.rig = true;
        }

        pre = root;

        if (!root.lef)
            preOrderBinaryTrree(root.left);
        if (!root.rig)
            preOrderBinaryTrree(root.right);
    }

    //前序遍历线索二叉树
    public void preOrderblack() {
        TreeNode cur = root;
        while (cur != null) {
            while (!cur.lef) {
                System.out.println(cur.value + " ");
                cur = cur.left;
            }
            System.out.println(cur.value + " ");
            cur = cur.right;
        }
    }

}
