package 队列数组实现;

public class DemoQueueByArray {
    public static void main(String[] args){
        QueueByArray Q=new QueueByArray(10);
        for(int i=0;i<5;i++){
            Q.add(i);
        }
        Q.delete();
        Q.delete();
        Q.delete();
        Q.delete();
        Q.delete();
        Q.add(5);
        Q.ergodic();




    }
}
