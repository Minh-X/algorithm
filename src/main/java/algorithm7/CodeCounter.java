package algorithm7;

import java.io.*;

public class CodeCounter {

    private static Integer code = 0;
    private static Integer codeComments = 0;
    private static Integer codeBlank = 0;
    private static Integer javaFileNum = 0;

    public static void main(String[] args) {
        File file = new File("D:/app/workspace/idea2021/algorithm");
        factFiles(file);
        System.out.println("代码行数" + code);
        System.out.println("空白行数" + codeBlank);
        System.out.println("注释行数" + codeComments);
        System.out.println("java文件数：" + javaFileNum);
    }

    public static void factFiles(File file) {
        BufferedReader br = null;
        String s = null;


        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                factFiles(f);
            }
        } else {
            if (file.getName().endsWith(".java")) {
                javaFileNum++;
            }
            try {
                br = new BufferedReader(new FileReader(file));
                boolean comm = false;
                while ((s = br.readLine()) != null) {
                    if (s.startsWith("/*") && s.endsWith("*/")) {
                        codeComments++;
                    } else if (s.trim().startsWith("//")) {
                        codeComments++;
                    } else if (s.startsWith("/*") && !s.endsWith("*/")) {
                        codeComments++;
                        comm = true;
                    } else if (!s.startsWith("/*") && s.endsWith("*/")) {
                        codeComments++;
                        comm = false;
                    } else if (comm) {
                        codeComments++;
                    } else if (s.trim().length() < 1) {
                        codeBlank++;
                    } else {
                        code++;
                    }
                }
                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}