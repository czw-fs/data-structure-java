package 堆栈链表实现;

public class Demo {
    public static void main(String[] args){
        StackByLink S=new StackByLink();
        for(int i=1;i<=16;i++){
            S.push(i);
        }
        S.ergodic();
        for(int i=1;i<=16;i++){
            System.out.println(S.rear.data);
            S.pop();
        }
    }
}
