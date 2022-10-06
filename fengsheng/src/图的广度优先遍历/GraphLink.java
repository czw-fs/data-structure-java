package 图的广度优先遍历;

public class GraphLink {
    Node first;
    Node last;
    //判断是否为空
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
    //遍历
    public void ergodic(){
        Node cur=first;
        while(cur!=null){
            System.out.println(cur.data+" ");
            cur=cur.next;
        }
    }
}
