package TopK;

import java.util.Arrays;

/**
 * @author: fs
 * @date: 2022/4/8 18:36
 * @Description:
 */
public class TestTopK {
    public static void main(String[] args) {
        int[] arr={18,21,8,10,34,12};
        System.out.println(Arrays.toString(TopK.topK(arr, 3)));
    }
}
