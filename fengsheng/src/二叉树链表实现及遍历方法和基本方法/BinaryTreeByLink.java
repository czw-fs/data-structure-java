package 二叉树链表实现及遍历方法和基本方法;

import java.util.*;

public class BinaryTreeByLink {
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
    //二叉树的遍历

    //前序遍历
    public void preOrder1(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrder1(root.left);
            preOrder1(root.right);
        }
    }

    //前序遍历非递归1
    public void preOrder2(TreeNode cur) {

        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                System.out.print(cur.value + " ");
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }

    //前序遍历非递归2
    public void preOrder3(TreeNode cur) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(cur);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            System.out.print(cur.value + " ");
            if (cur.right != null)
                stack.add(cur.right);
            if (cur.left != null)
                stack.add(cur.left);
        }
    }

    //中序遍历
    public void inOrder1(TreeNode root) {
        if (root != null) {
            inOrder1(root.left);
            System.out.print(root.value + " ");
            inOrder1(root.right);
        }
    }

    //中序遍历非递归
    public void inOrder2(TreeNode cur) {
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
    }

    //后序遍历
    public void postOrder1(TreeNode root) {
        if (root != null) {
            postOrder1(root.left);
            postOrder1(root.right);
            System.out.print(root.value + " ");
        }
    }

    //后序遍历非递归
    public void postOrder2(TreeNode cur) {
        if (cur == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        stack.add(cur);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                System.out.print(cur.value + " ");
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null)
                    stack.add(cur.right);
                if (cur.left != null)
                    stack.add(cur.left);
            }
        }
    }

    void postOrderNor(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.peek();
            //如果当前节点的右子树被打印过 或者 遍历过  直接弹出了
            if (top.right == null || top.right == prev) {
                stack.pop();
                System.out.print(top.value+" ");
                prev = top;//记录一下 最近一次打印的节点
            } else {
                cur = top.right;
            }
        }
    }


    //层序遍历递归
    public void levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.value + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    //层序遍历：分层打印
    public List<List<Integer>> levelOrder3(TreeNode root) {

        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();//这个值代表 当前层有多少个节点
            List<Integer> list = new ArrayList<>();
            while (size != 0) {
                TreeNode cur = queue.poll();
                //list.add(cur.val); 你在OJ写的时候  需要放开这个注释
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;//1 0
            }
            ret.add(list);
        }
        return ret;
    }

    //层序遍历非递归
    public void levelOrder2(TreeNode cur) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(cur);
        while (!queue.isEmpty()) {
            cur = queue.pop();
            System.out.print(cur.value + " ");
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }


    /**
     *获取树中节点的个数
     */
/*
    int count = 0;
    int size1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        count++;
        size1(root.left);
        size1(root.right);
        return count;
    }
    */

    /**
     * 子问题思路
     *
     * @param root
     * @return
     */
    int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    /**
     * 获取叶子节点的个数
     * 遍历思路：
     */
    static int leafCount = 0;
/*    void getLeafNodeCount(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            leafCount ++;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
    }*/

    /**
     * 获取叶子节点的个数
     * 子问题思路
     *
     * @param root
     * @return
     */

    void getLeafNodeCount(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafCount++;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
    }

    /**
     * 获取叶子节点的个数
     * 子问题思路
     *
     * @param root
     * @return
     */
    int getLeafNodeCount2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            //当前的root是叶子节点
            return 1;
        }
        return getLeafNodeCount2(root.left) + getLeafNodeCount2(root.right);
    }

    /**
     * 获取第K层节点的个数
     * 子问题思路：
     */
    int getKLevelNodeCount(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.left, k - 1) + getKLevelNodeCount(root.right, k - 1);
    }

    /**
     * 获取二叉树的高度
     * 时间复杂度：O(n)
     * 空间复杂度：O()
     */
    int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    //递归次数容易太多，超出时间限制
    int getHeight2(TreeNode root) {
        if (root == null) return 0;
        return getHeight2(root.left) > getHeight2(root.right) ? getHeight2(root.left) + 1 : getHeight2(root.right) + 1;
    }


    /**
     * 检测值为value的元素是否存在
     */
    TreeNode find(TreeNode root, char val) {
        if (root == null) return null;
        if (root.value == val) return root;

        TreeNode ret = find(root.left, val);
        if (ret != null) {
            return ret;
        }
        ret = find(root.right, val);
        if (ret != null) {
            return ret;
        }
        return null;
    }

    /**
     * 是不是完全二叉树
     *
     * @param root
     * @return
     */
    boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }
        }

        while (!queue.isEmpty()) {
            TreeNode top = queue.peek();
            if (top != null) {
                return false;
            }
            queue.poll();
        }
        return true;
    }

    //判断两个二叉树是否完全相等
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.value != q.value) {
            return false;
        }
        //p != null && q!= null && p.val == q.val
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //判断一个树是否是该树的子树
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }
        //等价于上面
//        if(root == null && subRoot != null) {
//            return false;
//        }
//        if(root != null && subRoot == null) {
//            return false;
//        }
//        if(root == null && subRoot == null) {
//            return true;
//        }


        //判断根节点是不是两棵相同的树
        if (isSameTree(root, subRoot)) {
            return true;
        }

        //subroot是不是root的左子树
        if (isSubtree(root.left, subRoot)) {
            return true;
        }

        //subroot是不是root的右子树
        if (isSubtree(root.right, subRoot)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否是平衡二叉树
     * 时间复杂度：O(N^2)
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 判断是否是平衡二叉树
     * 时间复杂度：O(n)
     */
    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;

        return getHeight3(root) >= 0;
    }

    int getHeight3(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight >= 0 && rightHeight >= 0 && Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        } else {
            return -1;
        }
    }

    //检查二叉树是否轴对称。
    public boolean judge(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree != null && rightTree == null) return false;

        if (leftTree == null && rightTree != null) return false;

        if (leftTree == null && rightTree == null) return true;

        if (leftTree.value != rightTree.value) return false;

        return judge(leftTree.left, rightTree.right) && judge(leftTree.right, rightTree.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return judge(root.left, root.right);
        }
    }

    //求最小公共祖先 理解不了！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // LCA 问题
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }

//    求最小公共祖先 栈模拟链表实现
    public boolean getPath(TreeNode root,TreeNode node,Stack<TreeNode> stack){
        if(root==null||node==null) return false;

        stack.push(root);

        if(root==node) return true;

        boolean flag=getPath(root.left,node,stack);
        if(flag==true) return true;

        flag=getPath(root.right,node,stack);
        if(flag==true) return true;

        stack.pop();
        return false;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();

        getPath(root,p,stack1);
        getPath(root,q,stack2);

        Stack<TreeNode> stackmax=stack1.size()>stack2.size() ? stack1:stack2;
        Stack<TreeNode> stackmin= stackmax==stack1 ? stack2 : stack1;

        while(!stackmax.isEmpty() && !stackmin.isEmpty() && stackmax.size()!=stackmin.size()){
            stackmax.pop();
        }

        while(!stackmax.isEmpty() && !stackmin.isEmpty()){
            if(stackmax.peek()==stackmin.peek()){
                return stackmax.peek();
            }else{
                stackmax.pop();
                stackmin.pop();
            }
        }
        return null;
    }



    /**
     * 二叉搜索树 转换为排序的双向链表
     */

    TreeNode prev = null;

    public void inorder(TreeNode pCur) {
        if(pCur == null) return;
        inorder(pCur.left);

        //打印
        pCur.left = prev;
        if(prev != null) {
            prev.right = pCur;
        }
        prev = pCur;
        //System.out.print(pCur.val+" ");
        inorder(pCur.right);
    }

    public TreeNode Convert(TreeNode pRootOfTree) {

        if(pRootOfTree == null) return null;

        inorder(pRootOfTree);

        TreeNode head = pRootOfTree;
        while(head.left != null) {
            head = head.left;
        }
        return head;
    }

    /*
    根据前中序遍历创建二叉树
     */
    public int preIndex = 0;

    public TreeNode createTreeByPandI(int[] preorder, int[] inorder,int inbegin,int inend) {

        if(inbegin > inend) {
            //如果满足这个条件  说明 没有左树 或者 右树了
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        //找到根在中序遍历的位置
        int rootIndex = findIndexOfI(inorder,inbegin,inend,preorder[preIndex]);
        if(rootIndex == -1) {
            return null;
        }
        preIndex++;
        //分别创建 左子树 和 右子树
        root.left = createTreeByPandI(preorder,inorder,inbegin,rootIndex-1);
        root.right = createTreeByPandI(preorder,inorder,rootIndex+1,inend);
        return root;
    }

    private int findIndexOfI(int[] inorder,int inbegin,int inend,int key) {

        for(int i = inbegin; i <= inend;i++) {
            if(inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;

        return createTreeByPandI(preorder,inorder,0,inorder.length-1);
    }


/*
    根据前中后遍历创建二叉树
    public int postIndex = 0;

    public TreeNode createTreeByPandI(int[] inorder, int[] postorder,int inbegin,int inend) {

        if(inbegin > inend) {
            //如果满足这个条件  说明 没有左树 或者 右树了
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        //找到根在中序遍历的位置
        int rootIndex = findIndexOfI(inorder,inbegin,inend,postorder[postIndex]);
        if(rootIndex == -1) {
            return null;
        }
        postIndex--;
        //分别创建右子树 和  左子树
        root.right = createTreeByPandI(inorder,postorder,rootIndex+1,inend);

        root.left = createTreeByPandI(inorder,postorder,inbegin,rootIndex-1);
        return root;
    }
    private int findIndexOfI(int[] inorder,int inbegin,int inend,int key) {

        for(int i = inbegin; i <= inend;i++) {
            if(inorder[i] == key) {
                return i;
            }

        }
        return -1;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || inorder == null) return null;
        postIndex = postorder.length-1;

        return createTreeByPandI(inorder,postorder,0,inorder.length-1);
    }*/
}
