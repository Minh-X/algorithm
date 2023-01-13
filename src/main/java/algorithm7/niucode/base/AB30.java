package algorithm7.niucode.base;

/**
 * @Author: permission
 * @Date: 2023/1/13 15:06
 * @Version: 1.0
 * @ClassName: AB30
 * @Description: 排序     升序
 */
public class AB30 {
    // 冒泡
    public int[] MySort (int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    arr[j] = arr[j] + arr[j+1];
                    arr[j + 1] = arr[j] - arr[j+1];
                    arr[j] = arr[j] - arr[j+1];
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arr;
    }
}
