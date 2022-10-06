package 双向队列;

public class Demo {
    public static void main(String[] args){
        Deque D=new Deque();
        D.fadd(2);
        D.fadd(2);
        D.fadd(2);
        D.radd(3);
        D.radd(3);
        D.radd(3);
        D.fdelete();
        D.rdelete();
        D.ergodic();
    }
}
