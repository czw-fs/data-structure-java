package 老鼠走迷宫问题;

public class NodeList {
    Node first;
    Node last;
    //压栈
    public void push(int x,int y){
        Node newNode=new Node(x,y);
        if(first==null){
            first=newNode;
            last=newNode;
        }else{
            last.next=newNode;
            last=newNode;
        }
    }
    //出栈
    public void pop(){
        if(first==null){
            System.out.println("堆栈已满，误删除选项");
            return;
        }else{
            Node delNode=first;
            while(delNode.next!=last)
                delNode=delNode.next;
            delNode.next=last.next;
            last=delNode;
        }
    }
}
