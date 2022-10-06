package 图的邻接矩阵法数组实现;

public class Demo {
    public static void main(String[] args){
        int[][] data={{1,2},{2,1},{1,5},{5,1},{2,3},{3,2},{2,4},{4,2},{3,4},{4,3},{3,5},{5,3},{4,5},{5,4}};
        int[][] arr=new int[6][6];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=0;
            }
        }

        for(int i=0;i<data.length;i++){
                    arr[data[i][0]][data[i][1]]=1;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
