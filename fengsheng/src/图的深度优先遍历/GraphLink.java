package 图的深度优先遍历;

public class GraphLink {
    public Node first;
    public Node last;

    public boolean isEmpty(){
        return first==null;
    }
    //添加元素
    public void add(int data){
        Node newNode=new Node(data);
        if(isEmpty()){
            first=newNode;
            last=newNode;
        }else{
            last.next=newNode;
            last=newNode;
        }
    }
    //遍历链表
    public void ergodic(){
        Node cur=first;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
}
