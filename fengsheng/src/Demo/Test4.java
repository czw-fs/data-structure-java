package Demo;

import java.util.*;

/**
 * @author: fs
 * @date: 2022/4/10 20:32
 * @Description:
 */
public class Test4 {
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        //1、统计每个单词出现的次数 map
        for (String s : words) {
            if(map.get(s) == null) {
                map.put(s,1);
            }else {
                int val = map.get(s);
                map.put(s,val+1);
            }
        }
        //2、建立一个大小为K的小根堆
        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().compareTo(o2.getValue()) == 0) {
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue()-o2.getValue();
            }
        });

        //3、遍历Map
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            if(minHeap.size() < k) {
                minHeap.offer(entry);
            }else {
                //说明堆中 已经放满了K个元素，需要看堆顶元素的数据 和当前的数据的大小关系
                Map.Entry<String,Integer> top = minHeap.peek();
                //判断频率是否相同，如果相同，比较单词的大小，单词小 的入堆
                if(top.getValue().compareTo(entry.getValue()) == 0) {
                    if(top.getKey().compareTo(entry.getKey()) > 0) {
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                }else {
                    if(top.getValue().compareTo(entry.getValue()) < 0) {
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                }
            }
        }
        //System.out.println(minHeap);
        List<String> ret = new ArrayList<>();
        for (int i = 0;i < k;i++) {
            Map.Entry<String,Integer> top = minHeap.poll();
            ret.add(top.getKey());
        }
        Collections.reverse(ret);
        return ret;
    }


    public static void main(String[] args) {
        //String[] worlds = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        String[] worlds = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> ret = topKFrequent(worlds,3);
        System.out.println(ret);
    }

}
