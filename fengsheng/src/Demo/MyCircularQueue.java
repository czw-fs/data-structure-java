package Demo;

/**
 * @author: fs
 * @date: 2022/4/2 9:53
 * @Description:
 */
class MyCircularQueue {
    public static void main(String[] args) {

  MyCircularQueue obj = new MyCircularQueue(3);
  boolean a = obj.enQueue(1);
  boolean b = obj.enQueue(1);
  boolean c = obj.enQueue(1);
  boolean d = obj.enQueue(1);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    private int[] myQueue;
    private int front;
    private int rear;

    public MyCircularQueue(int k) {
        myQueue=new int[k+1];
        front=0;
        rear=0;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }else{
            myQueue[rear]=value;
            rear=(rear+1)%myQueue.length;
            return true;
        }



    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }else{
            front=(front+1)%myQueue.length;
            return true;
        }
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }else{
            return myQueue[front];
        }
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }else{
            int index=-1;
            if(rear==0){
                index=myQueue.length-1;
            }else{
                index=rear-1;
            }
            return myQueue[index];
        }

    }

    public boolean isEmpty() {
        return front==rear;
    }

    public boolean isFull() {
        rear=(rear+1)%myQueue.length;
        return rear==front;
    }
}




/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
