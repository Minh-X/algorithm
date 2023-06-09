package algorithm7.niucode.nc.字符串;

/**
 * @Author: permission
 * @Date: 2023/1/13 21:32
 * @Version: 1.0
 * @ClassName: NC22
 * @Description:
 */
public class NC22 {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        merge(arr1, 3, arr2, 3);
    }

    public static void merge(int A[], int m, int B[], int n) {
        int[] res = new int[m + n];
        int i = 0, j = 0, r = 0;
        while (i < m && j < n) {      //遍历A.B中的元素
            if (A[i] <= B[j]) {    //如果A<=B,A先放
                res[r++] = A[i++];
            } else {             //如果A>B，B先放
                res[r++] = B[j++];
            }
        }
        //如果A，B其中有一个遍历完，另一个没遍历完，则将未遍历完的数组中的元素全部加入res中
        while (i < m) {     //当A中的元素未遍历完时，将A中剩下的元素全部放入res中
            res[r++] = A[i++];
        }
        while (j < n) {     //当B中的元素未遍历完时，将B中剩下的元素全部放入res中
            res[r++] = B[j++];
        }
//        for (int k = 0; k < res.length; k++) { //最后将数组res中的元素全部存入数组A中
//            A[k] = res[k];
//        }
        for (int k = 0; k < res.length; k++) {
            System.out.print(res[k] + " ");
        }
    }
}
