package algorithm_21.字符串问题.kmp;

/**
 * @Author: permission
 * @Date: 2023/1/15 2:54
 * @Version: 1.0
 * @ClassName: KMP
 * @Description: kmp 改进的字符串匹配算法
 */
public class KMP {

    /*

    	0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	21	22
        a	c	d	b	s	t	a	c	d	t	x	e	a	c	d	b	s	t	a	c	d	b	k
next	-1	0	0	0	0	0	0	1	2	3	0	0	0	1	2	3	4	5	6	7	8	9	4

     */
    public static int kmp(String str1, String str2) {
        if (str1 == null || str2 == null || str2.length() < 1 || str1.length() < str2.length()) {
            return -1;
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int x = 0;//s1指针
        int y = 0;//s2指针
        int[] next = getNextArray(s2);
        while (x < s1.length && y < s2.length) {
            if (s1[x] == s2[y]) {
                x++;
                y++;
            } else if (next[y] == -1){//此时y为0，已经重置到最开始位置
                x++;
            } else {
                y = next[y];
            }
        }

        return y == s2.length ? x - y : -1;
    }

//    void getNext(char * p, int * next){
//        next[0] = -1;
//        int i = 0, j = -1;
//        while (i < strlen(p)){
//            if (j == -1 || p[i] == p[j]){
//                ++i;
//                ++j;
//                next[i] = j;
//            } else	j = next[j];
//        }
//    }

    private static int[] getNextArray(char[] s) {
        if (s.length == 1) {//如果字符串长度为1，直接返回长度为1且next[0] = -1 的next数组，
            return new int[] {-1};
        }
        int[] next = new int[s.length];
        next[0] = -1;//next[0]设为-1
        next[1] = 0;//next[1]设为0
        int i = 2;//s数组的下标，表示当前正在求哪个下标位置的next数组的值
        int nv = 0;//next[i-1]对应的值，（next[i-1]的值也是前缀的最后的一个字符的下标+1）
        while (i < next.length) {
            if (s[i-1] == s[nv]) {//（next[i-1]的值也是前缀的最后的一个字符的下标+1）
//                next[i++] = ++nv;
                nv = nv + 1;
                next[i] = nv;
                i++;
            } else if (nv > 0) {
                nv = next[nv];
            } else {
//                next[i++] = 0;
                next[i] = 0;
                i++;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String s1 = "dsdsdsadsadsadsadwqdsadasdasdasd";
        String s2 = "baabaaa";// Next[] ={0,0,0,1,2,3,3}

        int index = kmp(s1, s2);

//        int possibilities = 5;
//        int strSize = 40;
//        int matchSize = 7;
//        int testTimes = 5000000;
//        System.out.println("test begin");
//        for (int i = 0; i < testTimes; i++) {
//            String str = getRandomString(possibilities, strSize);
//            String match = getRandomString(possibilities, matchSize);
//            int index = getIndexOf(str, match);
//            if (index>0 && match.length()>4){
//                System.out.println(str);
//                System.out.println(match);
//                System.out.println(index);
//                System.out.println();
//            }
//            if (index != str.indexOf(match)) {
//                System.out.println("Oops!");
//            }
//        }
//        System.out.println("test finish");

    }



    // for test
    public static String getRandomString(int possibilities, int size) {
        char[] ans = new char[(int) (Math.random() * size) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(ans);
    }





    public static int getIndexOf(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < 1 || s1.length() < s2.length()) {
            return -1;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int x = 0;
        int y = 0;
        // O(M) m <= n
        int[] next = getNextArray2(str2);
        // O(N)
        while (x < str1.length && y < str2.length) {
            if (str1[x] == str2[y]) {
                x++;
                y++;
            } else if (next[y] == -1) { // y == 0
                x++;
            } else {
                y = next[y];
            }
        }
        return y == str2.length ? x - y : -1;
    }

    public static int[] getNextArray2(char[] str2) {
        if (str2.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2; // 目前在哪个位置上求next数组的值
        int cn = 0; // 当前是哪个位置的值再和i-1位置的字符比较
        while (i < next.length) {
            if (str2[i - 1] == str2[cn]) { // 配成功的时候
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

}
