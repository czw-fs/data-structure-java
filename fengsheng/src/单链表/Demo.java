package 单链表;

public class Demo {
    public static void main(String[] args){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);

        NodeList L=new NodeList();
        L.add(n1);
        L.add(n2);
        L.add(n3);
        L.add(n4);
        L.add(n5);
        L.add(n6);


        L.reverseElem();

        L.ergod();
    }
}
