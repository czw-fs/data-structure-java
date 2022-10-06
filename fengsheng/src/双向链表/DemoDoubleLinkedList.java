package 双向链表;



import java.util.Scanner;

public class DemoDoubleLinkedList {
    public static void main(String[] args){
       DoubleLinkedList D=new DoubleLinkedList();

        Scanner sc=new Scanner(System.in);
        boolean flag=true;
        while(flag){
            menu();
            int key=sc.nextInt();
            switch(key){

                case 1:
                    System.out.println("请输入数字:");
                    int n1=sc.nextInt();
                    Node w1=new Node(n1);
                    D.add(w1);
                    break;
                case 2:
                    System.out.println("请输入删除元素序列号:");
                    int n2=sc.nextInt();
                    Node w2=new Node();
                    w2.Num=n2;
                    D.delete(w2);
                    break;
                case 3:
                    System.out.println("请输入查找元素数据:");
                    int n3=sc.nextInt();
                    Node w3=new Node(n3);
                    if(D.findElem(w3)!=null){
                        System.out.println("找到此元素，序列为:"+D.findElem(w3).Num);
                    }
                    break;
                case 4:
                    System.out.println("请输入更改元素序列号:");
                    int n4=sc.nextInt();
                    System.out.println("请输入更改数字");
                    int n44=sc.nextInt();
                    Node w4=new Node(n44,n4);
                    D.revise(w4);
                    break;
                case 5:
                    System.out.println("请输入要插入元素的数据");
                    int n5=sc.nextInt();
                    System.out.println("请输入将元素插入到的位置:");
                    int n55=sc.nextInt();
                    Node w5=new Node(n5,n55);
                    D.insertElem(w5);
                    break;
                case 6:
                    System.out.println("链表遍历如下:");
                    D.ergod();
                    break;
                case 7:
                    System.out.println("退出程序完毕");
                    flag=false;
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }
        }


    }
    public static void menu(){
        System.out.println("          1.增加元素");
        System.out.println("          2.删除元素");
        System.out.println("          3.查找元素");
        System.out.println("          4.更改元素");
        System.out.println("          5.插入元素");
        System.out.println("          6.遍历链表");
        System.out.println("          7.退出");
    }

}
