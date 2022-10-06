package 单链表;

public class NodeList {
    private Node first;
    private Node last;
    private int total;
    public NodeList(){}
    //判断是否为空
    public boolean isEmpty(){
        return first==null;
    }
    //增加元素
    public void add(Node newNode){
        if(isEmpty()){
            first=newNode;
            last=newNode;
        }else{
            last.next=newNode;
            last=newNode;
        }
        newNode.Num=++total;
    }
    //删除元素
    public void delete(Node delNode){
        if(isEmpty()){
            System.out.println("链表为空，无删除选项");
        }
        else if(delNode.Num==first.Num){
            first=first.next;
            Node newptr=first;
            while(newptr!=null){
                newptr.Num--;
                newptr=newptr.next;
            }
            total--;
        }
        else if(delNode.Num==last.Num){
            Node cur=first;
            while(cur.next.Num!=last.Num)
                cur=cur.next;
            cur.next=null;
            last=cur;
            total--;
        }
        else {
            Node cur = first;
            Node ptr = first;
            while (cur != null && cur.Num != delNode.Num) {//找到被修改元素
                ptr = cur;
                cur = cur.next;
            }
            if (cur != null) {
                ptr.next = cur.next;
                Node newptr = cur.next;
                while (newptr != null) {
                    newptr.Num--;
                    newptr = newptr.next;
                }
                total--;
            } else {
                System.out.println("查无此元素");
            }
        }
    }
    //查找元素
    public Node findElem(Node findNode){
        if(isEmpty()){
            System.out.println("链表为空，无法查找");
            return null;
        }
        Node cur=first;
        while(cur!=null&&cur.data!=findNode.data)
            cur=cur.next;

        return cur;
    }
    //更改元素
    public void revise(Node reNode){
        if(isEmpty()){
            System.out.println("链表为空，无法查找");
            return;
        }
        Node cur=first;
        while(cur!=null&&cur.Num!=reNode.Num)
            cur=cur.next;
        if(cur!=null){
            cur.data=reNode.data;
        }else{
            System.out.println("查无此元素");
        }
    }
    //往中间插入元素插入元素
    public void insertElem(Node newNode){
        if(isEmpty()){
         first=newNode;
         last=newNode;
         return;
        }
        Node cur=first;
        Node ptr=first;
        while(cur!=null&&cur.Num!= newNode.Num) {//找到插入位置
            ptr=cur;
            cur = cur.next;
        }
        if(cur!=null){
            ptr.next=newNode;
            newNode.next=cur;
            while(cur!=null){
                cur.Num++;
                cur=cur.next;
            }
            total++;
        }
    }
    //遍历链表
    public void ergod(){
        if(isEmpty()){
            System.out.println("链表为空，无法遍历");
            return;
        }
        Node cur=first;
        while(cur!=null){
            System.out.println(cur.Num+"\t"+cur.data);
            cur=cur.next;
        }
    }
    //反转链表
    public void reverseElem(){
        Node cur=first;
        Node bef=null;
        while(cur!=null){
            Node tmp=cur.next;
            cur.next=bef;
            bef=cur;
            cur=tmp;

        }
        first=bef;
    }
}




