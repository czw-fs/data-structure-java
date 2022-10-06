package 二叉搜索树;

import 二叉排序树.BinaryTree;

public class Demo {
    public static void main(String[] args){
        int[] arr={2,4,6,9,8,7,1,3,6,88,55,44,22,66,91};
        BinarySearch B=new BinarySearch();
        for(int i=0;i<arr.length;i++){
            B.add(arr[i]);
        }
        System.out.println(B.findTreeNode(B.root,91));
        System.out.println(B.count);
    }

}
