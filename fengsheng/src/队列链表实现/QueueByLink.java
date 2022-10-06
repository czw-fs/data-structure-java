package 队列链表实现;

public class QueueByLink {
    private Node front;
    private Node rear;
    public QueueByLink(){
        front=null;
        rear=null;
    }
    //入队
    public void add(int data){
        Node newNode=new Node(data);
        if(rear==null){
            front=newNode;
            rear=newNode;
        }else{
            rear.next=newNode;
            rear=newNode;
        }
    }
    //出列
    public Node delete(){
        if(rear==null) {
            throw new RuntimeException("队列为空，无法删除数据");
        }else if(rear!=front){
            Node cur=front.next;
            front=front.next;
            return cur;
        }else{
            front=null;
            rear=null;
            return null;
        }
    }
    //便利队列
    public void ergodic(){
        if(rear==null){
            System.out.println("队列为空，无法遍历");
            return;
        }
        Node cur=front;
        while(cur!=null){
            System.out.println(cur.data);
            cur=cur.next;
        }
    }
}
