/**
 * @Author: permission
 * @Date: 2023/1/14 14:22
 * @Version: 1.0
 * @ClassName: t1
 * @Description:
 */
public class t1 {
    public static void main(String[] args) {
        int[] a = {129,2,130,4,5};

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        swap(a, 0, 2);
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void swap(int[] a, int i, int j) {
        a[i] = a[i] + a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }


}
