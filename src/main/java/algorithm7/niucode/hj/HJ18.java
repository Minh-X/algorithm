package algorithm7.niucode.hj;

import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/1/14 4:37
 * @Version: 1.0
 * @ClassName: HJ18
 * @Description: HJ18 识别有效的IP地址和掩码并进行分类统计
 */
public class HJ18 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int aNum;
        int bNum;
        int cNum;
        int dNum;
        int eNum;
        int eIpOrMaskNum;
        int priIpNum;

        while (in.hasNextLine()) {
            String str = in.nextLine();
            String[] ss = str.split("~");
            String ipAddres = ss[0];
            String maskAddres = ss[0];
            String isType = isIp(ipAddres);
            Boolean isMask = isTrueMask(maskAddres);

        }
    }

    private static String isIp(String ipAddres) {
        String[] split = ipAddres.split("\\.");

        //如果是0开头与127开头的，则返回一个null
        //类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略
        if (split[0].equals("0") || split[0].equals("127")) {
            return null;
        }

        //如果后三个数字有大于255的，则属于非法ip
        for (int c = 1; c < split.length; c++) {
            if (split[c].trim().equals("") || Integer.parseInt(split[c]) > 255) {
                return "illegalIp";
            }
        }

        int type = Integer.parseInt(split[0]);
        //区分A,B,C,D,E类IP
        if (type >= 1 && type <= 126) {
            return "A";
        } else if (type >= 128 && type <= 191) {
            return "B";
        } else if (type >= 192 && type <= 223) {
            return "C";
        } else if (type >= 224 && type <= 239) {
            return "D";
        } else if (type >= 240 && type <= 255) {
            return "E";
        } else {
            return "illegalIp";
        }
    }

    private static Boolean isTrueMask(String maskAddres) {
        String[] split = maskAddres.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            if (s.trim().equals("")) {
                return false;
            }
            int i = Integer.parseInt(s);
            //如果有数字大于255，则直接返回false
            if (i > 255) {
                return false;
            }
            String binary = Integer.toBinaryString(i);
            //如果长度小于8，则在前面补0
            while (binary.length() < 8) {
                binary = "0".concat(binary);
            }
            sb.append(binary);
        }
        //32位二进制数中需要同时存在0和1，且不存在01
        return sb.toString().contains("1") && sb.toString().contains("0") && !sb.toString().contains("01");
    }

}
