package 二叉树数组实现;

public class BinaryTreeByArray {
        int[] data;
        int[] btree=new int[300];
        public BinaryTreeByArray(int[] arr){
            data=arr;
        }
        //添加元素
        public void add(){
            int level=1;
            for(int i=0;i<data.length;i++){
                for(level=1;btree[level]!=0; ){
                    if(data[i]<btree[level])
                        level=level*2;
                    else
                        level=level*2+1;
                }
                btree[level]=data[i];
            }
        }
        //遍历二叉树
        public void ergodic(){
            System.out.println("二叉树的内容");
            for(int i=1;i<btree.length;i++)
                System.out.print(btree[i]+" ");
            System.out.println();
        }
}
