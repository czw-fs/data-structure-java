package 环形链表;

public class CircleLink {
    private Node first;
    private Node last;

    public void add(int n){

        for(int i=1;i<=n;i++){
            Node newNode=new Node(i);
            if(first==null){
                first=newNode;
                last=newNode;
            }
            last.next=newNode;
            last=newNode;
        }
        last.next=first;
    }
    //添加元素
//    public void add(Node newNode){
//        if(first==null){
//            first=newNode;
//            last=newNode
//           last.next=first;
//        }else {
//            last.next = newNode;
//            newNode.next = first;
//            last = newNode;
//        }
//    }

    //解决约瑟夫问题
    public int solveJ(int n,int m){
        if(m == 1 || n < 2){
            System.out.println("输入参数有误");
            return 0;
        }
        add(n);
        int count=1;
        Node cur=first;
        Node ptr=null;

        while(cur.next!=cur){
            if(count==m){
                ptr.next=cur.next;
                cur=ptr.next;
                count=1;
            }else{
                ptr=cur;
                cur=cur.next;
                count++;
            }
        }
        return cur.data;
    }

    public void delete(Node newNode){

    }
    //遍历环形链表
    public void show(){
        Node empty=first;
        if(empty==null){
            System.out.println("this list is null");
            return;
        }
        do{
            System.out.printf("this is %dth data\n",empty.data);
            empty=empty.next;
        }while(empty!=first);
    }
}
