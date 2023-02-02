package algorithm_21.递归;

/**
 * 打印 i 到 j
 *
 * @author permission
 * @Date 2021 - 06 - 18 - 21:38
 * @package algorithm.递归基础
 * @Description:
 */
public class 打印i到j {

    /**
     * 打印 i 到 j
     * @param i
     * @param j
     */
    public void print_i_j(int i, int j){
        if (i>j){
            return;
        }
        System.out.println(i);
        print_i_j(i+1,j);
    }

    public static void main(String[] args) {
        new 打印i到j().print_i_j(1,10);
    }
}
