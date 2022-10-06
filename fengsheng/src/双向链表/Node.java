package 双向链表;

public class Node {
    int data;
    int Num;
    Node lnext;
    Node rnext;

    public Node(){}
    public Node(int data){
        this.data=data;
        lnext=null;
        rnext=null;
    }

    public Node(int data,int Num){
        this.data=data;
        this.Num=Num;
        lnext=null;
        rnext=null;
    }
}
