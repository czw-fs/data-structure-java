package 图的广度优先遍历;

public class Queue {
    int rear=-1;
    int front=-1;
    public int[] queue=new int[8];
    public void add(int data){
        if(rear>=8)
            return;
        queue[++rear]=data;
    }
    public int delqueue(){
        if(front==rear)
            throw new RuntimeException("队列为空");
        return queue[++front];
    }

}
