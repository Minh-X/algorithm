package algorithm777.h.s200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: permission
 * @Date: 2023/2/8 14:50
 * @Version: 1.0
 * @ClassName: H7_90_垃圾短信识别
 * @Description: 200
 */
public class H6_90_垃圾短信识别 {

    public static void main(String[] args) {

/*

15
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10
1 11
1 12
1 13
1 14
14 1
1 15
1
期望输出：true 13 13
 */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] info = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                info[i][j] = scanner.nextInt();
            }
        }
        int targetId = scanner.nextInt();
        handle(info, targetId);
    }

    private static void handle(int[][] infos, int targetId) {
        ArrayList<Integer> receiveList = new ArrayList<>();//targetId给哪些人发
        ArrayList<Integer> sendList = new ArrayList<>();//targetId收到哪些人的消息

        HashMap<Integer, Integer> map_id_receiveTimes = new HashMap<>();//targetId发送给id的次数，id_times
        HashMap<Integer, Integer> map_id_sendTimes = new HashMap<>();//id发送给targetId的次数， id_times

        boolean isTrash = false;
        int totalSend = 0;
        int totalReceive = 0;
        for (int[] info : infos) {
            int sender = info[0];
            int receiver = info[1];
            if (sender == targetId) {
                totalSend++;
                receiveList.add(receiver);
                map_id_receiveTimes.put(receiver, map_id_receiveTimes.getOrDefault(receiver, 0) + 1);
            } else if (receiver == targetId) {
                totalReceive++;
                sendList.add(sender);
                map_id_sendTimes.put(sender, map_id_sendTimes.getOrDefault(sender, 0) + 1);
            }
        }
        int M = totalSend - totalReceive;
        int L = 0;
        int N = 0;
        for (Integer receiverId : receiveList) {
            Integer receiveTimes = map_id_receiveTimes.get(receiverId);
            Integer senTimes = map_id_sendTimes.getOrDefault(receiverId, 0);
            if (senTimes == 0) {//targetId发送的人没给他发
                L++;
            } else {
                N = receiveTimes - senTimes;
            }
        }
        if (M > 10 || L > 5 || N > 5) {
            isTrash = true;
        }

        System.out.println(isTrash == true ? "true " : "false " + L + " " + M);
    }

}
