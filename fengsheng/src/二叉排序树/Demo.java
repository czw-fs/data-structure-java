package 二叉排序树;

import java.util.LinkedList;
import java.util.Queue;

public class Demo {
    public static void main(String[] args){
        BinaryTree B=new BinaryTree();
        int[] arr={5,9,3,3,4,7,19,75,7,6,1};
        for(int i=0;i<arr.length;i++){
            B.add(arr[i]);
        }
        B.inOrder(B.root);
        System.out.println();
        getLeafCount(B.root);
        System.out.println(leafCount);
        System.out.println(getLeafCount2(B.root));
        System.out.println(getLeafCount3(B.root));
        System.out.println();

        System.out.println(getLevelNodeCount1(B.root,3));
        System.out.println(getLevelNodeCount1(B.root,3));
        System.out.println(getLevelNodeCount1(B.root,3));
        System.out.println();

        System.out.println(getHigh(B.root));
        System.out.println();

        System.out.println(findNode(B.root,75).value);
        System.out.println();

        System.out.println(isCompleteTree(B.root));
    }

    //判断是否是完全二叉树
    public static Boolean isCompleteTree(TreeNode root){
        if(root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur != null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else{
                break;
            }
        }
        while(!queue.isEmpty()){
            if(queue.poll() != null){
                return false;
            }
        }
        return true;

    }
    //查找二叉树中是否存在某一节点
    public static TreeNode findNode(TreeNode root,int val){
        if(root == null){
            return null;
        }
        if(root.value == val){
            return root;
        }
        TreeNode left = findNode(root.left,val);
        if(left != null){
            return left;
        }
        TreeNode right = findNode(root.right,val);
        if(right != null){
            return right;
        }
        return null;
    }
    //求二叉树的深度
    public static int getHigh(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getHigh(root.left);
        int right = getHigh(root.right);
        return Math.max(left,right) + 1;
    }
    //**五.求二叉树某一层节点个数**
    public static int getLevelNodeCount1(TreeNode root,int k){
        if(root == null && k < 1){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getLevelNodeCount(root.left,k - 1) + getLevelNodeCount(root.right,k - 1);
    }

    public static int getLevelNodeCount2(TreeNode root,int k){
        if(root == null && k < 1){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        int left = getLevelNodeCount(root.left,k - 1);
        int right = getLevelNodeCount(root.right,k - 1);
        return left + right;
    }

    public static int getLevelNodeCount(TreeNode root,int k){
        int count = 0;
        if(root == null && k < 1){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        int left = getLevelNodeCount(root.left,k - 1);
        count += left;
        int right = getLevelNodeCount(root.right,k - 1);
        count += right;
        return count;
    }

    public static int getLeafCount2(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = getLeafCount2(root.left);
        int right = getLeafCount2(root.right);
        return left +right;
    }
    private static int leafCount = 0;
    public static void getLeafCount(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leafCount++;
        }
        getLeafCount(root.left);
        getLeafCount(root.right);
    }

    public static int getLeafCount3(TreeNode root){
        int count = 0;
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = getLeafCount2(root.left);
        count += left;
        int right = getLeafCount2(root.right);
        count += right;
        return count;
    }


}
