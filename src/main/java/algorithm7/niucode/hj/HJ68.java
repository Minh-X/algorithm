package algorithm7.niucode.hj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author: permission
 * @Date: 2023/1/22 2:37
 * @Version: 1.0
 * @ClassName: HJ68
 * @Description: HJ68 成绩排序
 */
public class HJ68 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        List<Student> list = new ArrayList<>();
        int n = in.nextInt();
        int sortedType = in.nextInt();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            int score = in.nextInt();
            list.add(new Student(name, score));
        }
        sortedByScore(list, sortedType);
    }

    private static void sortedByScore(List<Student> list, int sortedType) {
        List<Student> resList = null;
        if (sortedType == 0) {
            resList = list.stream().sorted(new MyComparator0()).collect(Collectors.toList());
        } else if (sortedType == 1) {
            resList = list.stream().sorted(new MyComparator1()).collect(Collectors.toList());
        }
        int i = 0;
        for (; i < resList.size() - 1; i++) {
            Student student = resList.get(i);
            System.out.print(student.name + " " + student.score);
            System.out.println();
        }
        Student student = resList.get(i);
        System.out.print(student.name + " " + student.score);
    }

    //降序
    public static class MyComparator0 implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o2.score - o1.score;
        }
    }
    //升序
    public static class MyComparator1 implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.score - o2.score;
        }
    }

    public static class Student {
        private String name;
        private Integer score;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        public Student(String name, Integer score) {
            this.name = name;
            this.score = score;
        }
    }
}
