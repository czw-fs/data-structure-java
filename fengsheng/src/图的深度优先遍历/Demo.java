package 图的深度优先遍历;

public class Demo {
    public static int run[]=new int[9];
    public static GraphLink[] head=new GraphLink[9];
    //深度优先遍历
    public static void dfs(int cur){
        run[cur]=1;
        System.out.print(cur+" ");
        while((head[cur].first)!=null){
            if(run[head[cur].first.data]==0)
                dfs(head[cur].first.data);
            head[cur].first=head[cur].first.next;
        }
    }
    //广度优先遍历
    public static void bfs(int cur){

    }
    public static void main(String[] args){
        int[][] arr={{6,3},{3,6},{1,3},{3,1},{1,2},
                {2,1},{1,4},{4,1},{5,1},{1,5},{5,7}
                ,{7,5},{5,8},{8,5}};
        for(int i=1;i<head.length;i++){
            run[i]=0;
            head[i]=new GraphLink();
//            System.out.print(i+"->");
            for(int j=0;j<arr.length;j++) {
                if (arr[j][0] == i) {
                    head[i].add(arr[j][1]);
                }
            }
//            head[i].ergodic();
        }
        System.out.println("打印深度优先遍历的结点");
        dfs(1);
        System.out.println();
    }
}
