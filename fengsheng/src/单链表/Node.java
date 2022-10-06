package 单链表;

public class Node {
    int data;
    int Num;
    Node next;

    public Node(){}

    public Node(int data){
        this.data=data;
        next=null;
    }

    public Node(int data,int Num){
        this.data=data;
        this.Num=Num;
    }
}
