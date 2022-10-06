package 堆栈链表实现;

public class StackByLink {
    Node front;
    Node rear;
    //判断是否为空
    public boolean isEmpty(){
        return front==null;
    }
    //将指定数据压入栈顶
    public void push(int data){
        Node newNode=new Node(data);
        if(isEmpty()){
            front=newNode;
            rear=newNode;
        }else{
            rear.next=newNode;
            rear=newNode;
        }
    }
    //从栈顶中弹出数据
    public void pop(){
        if(isEmpty()){
            System.out.println("当前堆栈为空，无法弹出数据");
            return;
        }else if(front==rear){
            front=null;
            rear=null;
        } else{
            Node ptr=front;
            while(ptr.next!=rear)
                ptr=ptr.next;
            ptr.next=rear.next;
            rear=ptr;
        }
    }
    //遍历堆栈
    public void ergodic(){
        System.out.println("****************************");
        Node cur=front;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
}
