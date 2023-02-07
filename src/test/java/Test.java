import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: permission
 * @Date: 2023/1/16 21:17
 * @Version: 1.0
 * @ClassName: Test
 * @Description:
 */
public class Test {

    @org.junit.Test
    public void s() {
        String s = Integer.toString(3, 2);
        System.out.println(s);
        System.out.println("------------");
        System.out.println(Integer.parseInt("1111001011", 2));
        int a = 8;

        int c = 3 | 1;
        System.out.println(c);
    }

    @org.junit.Test
    public void t1() {
        int[] ints = {9, 4, 1, 7};
        String path = this.getClass().getResource("/").getPath();
        System.out.println(path);
    }

    @org.junit.Test
    public void t2() {
        int[][] arr = new int [7][3];

        for (int j = 0; j < 7; j++) {
            arr[j][0] = j;
        }
        for (int j = 0; j < 7; j++) {
            arr[j][1] = 170 + (int)(Math.random()*10);
        }
        arr[0][2] = 0;
        arr[1][2] = 1;
        arr[2][2] = 0;
        arr[3][2] = 0;
        arr[4][2] = 1;
        arr[5][2] = 1;
        arr[6][2] = 0;

        System.out.println("排序前");
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] != o1[2]? o1[2] - o2[2]:o1[1] - o2[1];
            }
        });
        System.out.println("排序后");

        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }

    }

}
