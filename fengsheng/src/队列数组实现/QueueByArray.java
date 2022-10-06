package 队列数组实现;

public class QueueByArray {
    private int front=-1;
    private int rear=-1;
    private int[] arr;
   public  int size;
    //构造函数中初始化数组容量
    public QueueByArray(int s){
        this.size=s;
        arr=new int[this.size];
    }
    //入队
    public void add(int data){
        if(rear==this.size-1){
            System.out.println("队列已满，无法添加数据");
            return;
        }else{
            arr[++rear]=data;
        }
    }
    //出队
    public int delete(){
        if(front>=rear){
            throw new RuntimeException("队列为空，无法添加数据");
        }else{
            int tmp=arr[front+1];
            for(int i=0;i<rear;i++)
                arr[i]=arr[i+1];
            rear--;
            return tmp;
            //return arr[++front];
        }
    }
    //遍历队列
    public void ergodic(){
        if(front>=rear){
            System.out.println("队列为空，无法添加数据");
            return;
        }
        int cur=front+1;
        while(true){
            System.out.println(arr[cur]);
            if(cur==rear)
                break;
            cur++;
        }
    }
}
