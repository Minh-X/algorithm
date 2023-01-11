package algorithm_21.位运算;

import algorithm.util.MyUtil;

/**
 * 题目描述：
 * 数组中只有一个数出现了1次，其他数都出现了k次，请输出只出现了1次的数
 * @author permission
 * @Date 2021 - 06 - 09 - 15:47
 * @package algorithm.位运算
 * @Description:
 */
public class 出现k次与出现1次 {

    /**
     * 题解：
     * 2个相同的2进制数进行不进位加法，结果为0
     * 10个相同的10进制数进行不进位加法，结果为0
     * k个相同的k进制数进行不进位加法，结果为0
     *
     * 先将数组中的元素转换为k进制，然后全部进行不进位加法运算，再将得到的结果转换为10进制即为答案
     *
     * @param arr
     */
    public void count_cx1c(int[] arr){
        MyUtil.printArr(arr);
        int length = arr.length;
        char[][] kRadix = new char[length][];
        int k = 3;
        //转换为k进制字符数组
        int maxLen = 0;
        for (int i = 0; i < length; i++) {
            //求每个数字的三进制字符串并反转，然后转为字符数组
            kRadix[i] = new StringBuffer(Integer.toString(arr[i],k)).reverse().toString().toCharArray();
            if (kRadix[i].length > maxLen){
                maxLen = kRadix[i].length;
            }
        }
        int[] resArr = new int[maxLen];
        for (int i = 0; i < length; i++) {
            //不进位加法
            for (int j = 0; j < maxLen; j++) {
                if (j >= kRadix[i].length){
                    resArr[j] += 0;
                } else {
                    resArr[j] +=kRadix[i][j] - '0';
                }
            }
        }
        int res = 0;
        for (int i = 0; i < maxLen; i++) {
            res += (resArr[i]%k) * (int)(Math.pow(k,i));
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,9,7,7,7,3,3,3,6,6,6,0,0,0};
        new 出现k次与出现1次().count_cx1c(arr);
    }
}
