package 双向链表;

public class DoubleLinkedList {
    private Node first;
    private Node last;
    private int total;
    public DoubleLinkedList(){}
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
            newNode.lnext=last;
            last.rnext=newNode;
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
            first=first.rnext;
            first.lnext=null;
            Node newptr=first;
            while(newptr!=null){
                newptr.Num--;
                newptr=newptr.rnext;
            }
            total--;
        }
        else if(delNode.Num==last.Num){
            Node tmp=last.lnext;
           last.lnext.rnext=null;
            last.lnext=null;
            last=tmp;
            total--;
        }
        else {
            Node cur = first;
            while (cur != null && cur.Num != delNode.Num) {//找到被修改元素
                cur = cur.rnext;
            }

            if (cur != null) {
                cur.lnext.rnext=cur.rnext;
                cur.rnext.lnext=cur.lnext;

                Node newptr = cur.rnext;
                while (newptr != null) {
                    newptr.Num--;
                    newptr = newptr.rnext;
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
        while(cur!=null&&cur.Num!=findNode.Num)
            cur=cur.rnext;//从头往友查找

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
            cur=cur.rnext;
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
        while(cur!=null&&cur.Num!= newNode.Num) {//找到被修改元素
            cur = cur.rnext;
        }
        if(cur!=null){
            newNode.lnext=cur.lnext;
            cur.lnext.rnext=newNode;

            newNode.rnext=cur;
            cur.lnext=newNode;

            while(cur!=null){
                cur.Num++;
                cur=cur.rnext;
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
            cur=cur.rnext;
        }
    }
}
