package 堆;


import java.util.Arrays;

/**
 * @author: fs
 * @date: 2022/4/7 16:26
 * @Description:
 */
public class Heap {
    public int[] elem;
    public int usedSize;

    public Heap() {
        this.elem = new int[10];
    }

    /*
    parent:每棵树的根节点
    len：每棵树的结束位置
     */

//创建大根堆
    public void createHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }

        for (int parent = (usedSize - 1 - 1) / 2; parent >= 0; parent--) {
            //调整
            shiftDown(parent, usedSize);
        }
    }

//    设置大根堆的父元素
    public void shiftDown(int parent, int len) {
        int child = 2 * parent + 1;
//        最起码有一个左树
        while (child < len) {
            if (child + 1 < len && elem[child] < elem[child + 1]) {
                child++;//保证当前为数值最大的子树
            }

            if (elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }
    //添加一个元素
    public void offer(int val) {
        if (isFull()) {
            elem = Arrays.copyOf(elem, 2 * elem.length);
        }
        elem[usedSize++] = val;
        shiftUp(usedSize - 1);
    }

//    将添加的元素放到合适的位置
    private void shiftUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child=parent;
                parent=(child-1)/2;
            } else {
                break;
            }
        }
    }

    // 弹出最后一个元素
    public int poll(){
        if(isEmpty()){
            throw new RuntimeException("优先队列为空!");
        }
        int tmp=elem[0];
        elem[0]=elem[usedSize-1];
        elem[usedSize-1]=tmp;
        usedSize--;
        shiftDown(0,usedSize);
        return tmp;
    }

//    利用大根堆将一组数据从小到大进行排序
    public void heapSort(){
        int end=this.usedSize-1;
        while(end>0){
            int tmp=elem[end];
            elem[end]=elem[0];
            elem[0]=tmp;
            shiftDown(0,end);
            end--;
        }
    }

//    判断堆是否为满
    public boolean isFull() {
        return usedSize == elem.length;
    }
    //    判断堆是否为空
    public boolean isEmpty(){
        return usedSize==0;
    }
}
