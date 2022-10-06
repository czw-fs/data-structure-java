package 后序遍历化线索二叉树;

public class postThreadBinaryTree {

        TreeNode root;
        TreeNode pre;

        public postThreadBinaryTree(int[] arr, int index) {
            root = creatBinaryTree(arr, index);
        }

        //利用数组创建二叉树
        public TreeNode creatBinaryTree(int[] arr, int index) {
            TreeNode tmp=null;
            if (index <arr.length) {
                tmp = new TreeNode(arr[index]);
                tmp.left = creatBinaryTree(arr, 2 * index + 1);
                tmp.right = creatBinaryTree(arr, 2 * index + 2);

                if (tmp.left != null)
                    tmp.left.parent = tmp;
                if (tmp.right != null)
                    tmp.right.parent = tmp;
            }
            return tmp;
        }
    //后序遍历线索化二叉树
    public void postThreadOrder(TreeNode root) {
        if (root == null)
            return;
        //处理左子树
        postThreadOrder(root.left);
        //处理右子树
        postThreadOrder(root.right);

        if (root.left == null) {
            root.left = pre;
            root.lef = true;
        }
        if (pre != null && pre.right == null) {
            pre.right = root;
            pre.rig = true;
        }
        pre = root;
    }

    //遍历后序遍历线索化的二叉树
    public void postOrderBinaryTree() {
        pre = null;
        TreeNode cur = root;
        while (cur != null && !cur.lef)
            cur = cur.left;

        while (cur != null) {
            if (cur.lef) {
                System.out.println(cur.value + " ");
                pre = cur;
                cur = cur.right;
            } else {
                if (cur.right == pre) {

                    System.out.println(cur.value + " ");

                    if(cur==root)
                        return;

                    pre=cur;
                    cur=cur.parent;
                }else{
                    if(cur==root&&cur.right==null)
                        return;

                        cur=cur.right;
                        while(cur!=null&&!cur.lef)
                            cur=cur.left;
                }
            }
        }
    }
}
