package 二叉搜索树;

import com.sun.source.tree.Tree;

public class BinarySearch {
    public TreeNode root;
    public int count=0;
    //添加节点1
    public void add(int data){
        TreeNode newNode=new TreeNode(data);
        if(root==null){
            root=newNode;
            return;
        }else{
            TreeNode cur=root;
            while(true){
                if(newNode.value<cur.value){
                    if(cur.left==null){
                        cur.left=newNode;
                        return;
                    }else{
                        cur=cur.left;
                    }
                }else{
                    if(cur.right==null){
                        cur.right=newNode;
                        return;
                    }else{
                        cur=cur.right;
                    }
                }
            }
        }
    }

//    添加节点2
    public boolean insert(int k){
        if(root==null){
            root=new TreeNode(k);
            return true;
        }
        TreeNode cur=root;
        TreeNode parent=null;
        while(cur!=null){
            if(cur.value<k){
                parent=cur;
                cur=cur.right;
            }else if(cur.value>k){
                parent=cur;
                cur=cur.left;
            }else{
                return false;
            }
        }
        TreeNode node=new TreeNode(k);
        if(parent.value<k){
            parent.right=node;
        }else{
            parent.left=node;
        }
        return true;
    }
    //查找：非递归
    public TreeNode search(int k){
        TreeNode cur=root;

        while(cur!=null){
            if(k>cur.value){
                cur=cur.right;
            }else if(k<cur.value){
                cur=cur.left;
            }else{
                return cur;
            }
        }
        return null;
    }
    //查找该二叉树上是否含有该元素：递归
    public boolean findTreeNode(TreeNode root,int value){
        if(root==null){
            return false;
        }else{
            if(root.value==value){
                return true;
            }else{
                if(value<root.value){
                    count++;
                    return findTreeNode(root.left,value);
                }else{
                    count++;
                    return findTreeNode(root.right,value);
                }
            }
        }
    }

    //删除结点


    public void remove(int key) {
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if(cur.value == key) {
                //这里开始删除
                removeNode(cur,parent);
                break;
            }else if(cur.value < key) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
    }

    public void removeNode(TreeNode cur,TreeNode parent) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            }else if(cur == parent.left) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if(cur.right == null) {
            if(cur == root) {
                root = cur.left;
            }else if(cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            TreeNode targetParent = cur;
            TreeNode target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.value = target.value;
            if(target == targetParent.left) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }

    public void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.value+" ");
        inOrder(root.right);
    }



    public static void main(String[] args) {
        int[] array = {10,8,19,3,9,4,7};
        BinarySearch binarySearchTree = new BinarySearch();
        for (int i = 0; i < array.length; i++) {
            binarySearchTree.insert(array[i]);
        }
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println();
        System.out.println("插入重复的数据");
        System.out.println(binarySearchTree.insert(3));
        System.out.println("删除数据：");
        binarySearchTree.remove(7);
        binarySearchTree.inOrder(binarySearchTree.root);

    }

}
