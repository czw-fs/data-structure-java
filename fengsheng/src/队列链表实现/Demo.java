package 队列链表实现;

public class Demo {
    public static void main(String[] args){
        QueueByLink Q=new QueueByLink();
        for(int i=0;i<6;i++){
            Q.add(i);
        }
        Q.delete();
        Q.delete();
        Q.delete();
        Q.delete();
        Q.delete();
        Q.add(120);
        Q.add(120);
        Q.add(120);
        Q.add(120);
        Q.ergodic();
    }

}
