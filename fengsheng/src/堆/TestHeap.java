package 堆;

/**
 * @author: fs
 * @date: 2022/4/8 9:59
 * @Description:
 */
public class TestHeap {
    public static void main(String[] args) {
        int[] array = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        Heap heap=new Heap();
        heap.createHeap(array);
        heap.heapSort();
        System.out.println("hh");

    }
}
