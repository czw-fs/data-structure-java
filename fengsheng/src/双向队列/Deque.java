package 双向队列;

public class Deque {
    private Node front;
    private Node rear;
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==null;
    }
    //头入队
    public void fadd(int data){
        Node newNode=new Node(data);
        if(isEmpty()){
            front=newNode;
            rear=newNode;
        }else{
            newNode.next=front;
            front=newNode;
        }
    }
    //尾入队
    public void radd(int data){
        Node newNode=new Node(data);
        if(isEmpty()){
            front=newNode;
            rear=newNode;
        }else{
            rear.next=newNode;
            rear=newNode;
        }
    }
    //头出队
    public Node fdelete(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法删除");
        }else{
            Node first=front;
            front=front.next;
            return first;
        }
    }
    //尾出队
    public Node rdelete(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法删除");
        }else{
            Node bef=rear;
            Node cur=front;
            while(cur.next!=rear)
                cur=cur.next;
            cur.next=rear.next;
            rear=cur;
            return bef;
        }
    }
    //遍历队列
    public void ergodic(){
        Node cur=front;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
}
