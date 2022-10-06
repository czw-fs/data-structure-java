package 环形队列;

public class CircleQueueByArray {
    private int front;
    private int rear;
    private int[] arr;
    private int size;
    public CircleQueueByArray(int size){
        this.size=size;
        arr=new int[this.size+1];
        front=0;
        rear=0;
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear+1)%(size+1)==front;
    }
    //判断队列是否空
    public boolean isEmpty(){
        return rear==front;
    }
    //入队
    public void add(int data){
        if(isFull()){
            System.out.println("队列已满，无法入队");
            return;
        }else{
            rear=(rear+1)%(size+1);
            arr[rear]=data;
        }
    }
    //出队
    public int delete(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法出列");
        }else{

            front=(front+1)%(size+1);
            return arr[front-1];
        }
    }
    //遍历环形队列
    public void ergodic(){
        if(isEmpty()){
            System.out.println("队列为空，无法遍历");
            return;
        }
        int cur=(front+1)%(size+1);
        while(cur!=rear){
            System.out.print(arr[cur]+" ");
            cur++;
            cur%=size+1;
        }
        System.out.print(arr[rear]);
        System.out.println();
    }
}
