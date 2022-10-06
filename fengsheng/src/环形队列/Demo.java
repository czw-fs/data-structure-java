package 环形队列;

public class Demo {
    public static void main(String[] args){
        CircleQueueByArray C=new CircleQueueByArray(5);
        C.add(2);
        C.add(2);
        C.add(2);
        C.add(2);

        C.delete();
        C.delete();
        C.delete();



        C.add(6);
        C.add(6);
        C.add(6);
        C.add(6);

        C.ergodic();



    }
}
