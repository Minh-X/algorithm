package algorithm_21.test;


/**
 * @Author: permission
 * @Date: 2022/9/24 21:02
 * @Version: 1.0
 * @ClassName: test
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Integer integer = new Integer(177);
        Integer integer2 = new Integer(177);
        Integer integer3 = 177;
        Integer integer4 = 177;
        System.out.println(integer.equals(integer2));
        System.out.println(integer == integer2);
        System.out.println(integer3.equals(integer4));
        System.out.println(integer3 == integer4);


    }
}
