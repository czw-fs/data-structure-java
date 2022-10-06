package TopK;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: fs
 * @date: 2022/4/8 16:02
 * @Description:
 */
public class TopK {
    public static int[] topK(int[] array ,int k){
        //1.创建一个大小为k的大根堆
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //遍历数组当中的元素，前k个元素放到队列中
        for (int i = 0; i < array.length; i++) {
            if(maxHeap.size()<k){
                maxHeap.offer(array[i]);
            }else {
//                从第k+1个元素开始，每个元素和堆顶元素进行比较
                int top=maxHeap.peek();
                if(top>array[i]){
//                    先弹出
                    maxHeap.poll();
//                    后存入
                    maxHeap.offer(array[i]);
                }
            }
        }
//        将得到的最大堆存入数组
        int[] tmp=new int[k];
        for(int i=0;i<k;i++){
            tmp[i] = maxHeap.poll();
        }
        return tmp;
    }

//    https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o2.get(0)+o2.get(1))-(o1.get(0)+o1.get(1));
            }
        });
//        for (int i = 0; i < Math.min(nums1.length,k); i++) {
//            for (int j = 0; j < Math.min(nums2.length,k); j++) {
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(maxHeap.size() < k) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums1[i]);
                    tmpList.add(nums2[j]);
                    maxHeap.offer(tmpList);
                }else {
                    int top = maxHeap.peek().get(0) + maxHeap.peek().get(1);
                    if(top > nums1[i]+nums2[j]) {
                        //记住  要弹出的
                        maxHeap.poll();

                        List<Integer> tmpList = new ArrayList<>();
                        tmpList.add(nums1[i]);
                        tmpList.add(nums2[j]);
                        maxHeap.offer(tmpList);
                    }
                }
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            ret.add(maxHeap.poll());
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        List<List<Integer>> ret = kSmallestPairs(nums1,nums2,3);
        System.out.println(ret);
    }

}
