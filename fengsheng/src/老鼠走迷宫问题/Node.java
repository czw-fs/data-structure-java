package 老鼠走迷宫问题;

public class Node {
    int x;
    int y;
    Node next;

    public Node(){}

    public Node(int x,int y){
        this.x =x;
        this.y =y;
        next=null;
    }
}
