package 堆栈数组实现;

public class Demo {
    public static void main(String[] args){
        StackByArray S=new StackByArray(10);
        for(int i=0;i<10;i++){
            S.push(i);
        }
        while(!S.isEmpty()){
            System.out.println(S.pop());
        }
    }
}
