package 堆栈数组实现;

import java.util.Arrays;

public class StackByArray {
    private int[] arr;
    private int top;

    public StackByArray(int size) {
        arr = new int[size];
        top = -1;
    }

    //判断堆栈是否为空
    public boolean isEmpty() {

        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    //将指定数据压入堆栈
    public void push(int data) {
        //方式1:不扩容
        /*if(top>=arr.length){
            System.out.println("堆栈已满，无法再压入");
            return false;
        }else{
            arr[++top]=data;
            return true;
        }*/
        //方式2:扩容
        if (top >= arr.length) {
            this.arr = Arrays.copyOf(this.arr, 2 * arr.length);
        } else {
            arr[++top] = data;
        }
    }
        //从堆栈弹出数据
        public int pop () {
            if (isEmpty()) {
                return -1;
            } else {
                return arr[top--];
            }
        }
    }


