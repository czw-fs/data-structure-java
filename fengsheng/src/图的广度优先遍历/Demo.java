package 图的广度优先遍历;

public class Demo {
    public static int[] run=new int[9];
    public static GraphLink[] head=new GraphLink[9];
    //广度优先遍历
    public static void bfs(int cur){
        Queue q=new Queue();
        q.add(cur);
        Node tmpNode;
        run[cur]=1;
        System.out.print(cur+" ");
        while(q.front!=q.rear){
            cur=q.delqueue();
            tmpNode=head[cur].first;
            while(tmpNode!=null){
                if(run[tmpNode.data]==0){
                    q.add(tmpNode.data);
                    run[tmpNode.data]=1;
                    System.out.print(tmpNode.data+" ");
                }
                tmpNode=tmpNode.next;
            }
        }

    }
    public static void main(String[] args){
        int[][] arr={{6,3},{3,6},{1,3},{3,1},{1,2},
                {2,1},{1,4},{4,1},{5,1},{1,5},{5,7}
                ,{7,5},{5,8},{8,5}};
        for(int i=1;i<head.length;i++){
            head[i]=new GraphLink();
            for(int j=0;j<arr.length;j++) {
                if (arr[j][0] == i) {
                    head[i].add(arr[j][1]);
                }
            }

        }
        System.out.println("打印广度度优先遍历的结点");
        bfs(1);
        System.out.println();
    }
}
