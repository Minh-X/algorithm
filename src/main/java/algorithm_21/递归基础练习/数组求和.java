package algorithm_21.递归基础练习;

/**
 * 数组求和
 * @author permission
 * @Date 2021 - 06 - 18 - 23:28
 * @package algorithm.递归基础练习
 * @Description:
 */
public class 数组求和 {

    /**
     * 数组求和
     * @param arr
     * @return
     */
    public int sum(int[] arr, int begin){
        if (begin == arr.length-1){
            return arr[begin];
        }
        return arr[begin] + sum(arr, begin+1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int result = new 数组求和().sum(arr,0);
        System.out.println(result);
    }
}
