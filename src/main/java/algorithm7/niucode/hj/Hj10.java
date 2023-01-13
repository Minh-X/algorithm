package algorithm7.niucode.hj;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/12 2:55
 * @Version: 1.0
 * @ClassName: Hj10
 * @Description:
 */
public class Hj10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = null;
        if (scanner.hasNextLine()) {
            str = scanner.nextLine();
        }
//        c1(str);
        c2(str);
    }

    private static void c2(String str) {
        BitSet bitSet = new BitSet(128);
        for (char ch : str.toCharArray()) {
            if (!bitSet.get(ch)) {
                bitSet.set(ch);
            }
        }
        System.out.println(bitSet.cardinality());
    }

    private static void c1(String str) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
            System.out.println(set.size());
        }
    }

}
