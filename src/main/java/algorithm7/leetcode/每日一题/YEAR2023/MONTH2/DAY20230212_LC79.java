package algorithm7.leetcode.每日一题.YEAR2023.MONTH2;

/**
 * @Author: permission
 * @Date: 2023/2/12 17:18
 * @Version: 1.0
 * @ClassName: LC79
 * @Description: 79. 单词搜索
 */
public class DAY20230212_LC79 {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'C'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "BCCED";
        boolean res = exist(board, word);
        System.out.println(res);
    }


    public static boolean exist(char[][] board, String word) {
        return handle1(board, word);
    }

    private static boolean handle1(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 每个点为起始点，判断是否能匹配word
                boolean checked = dfs(board, visited, i, j, word, 0);
                if (checked) {
                    return true;
                }
            }
        }
        return false;
    }

    //k表示当前正在判断word中第k个字符（下标）
    private static boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        if (board[i][j] != word.charAt(k)) {//如果当前字符判断失败，后面不用在判断了
            return false;
        } else if (k == word.length() - 1) {//到了最后一个字符,且最后一个字符没走上面个分支，说明最后一个字符也是匹配的，返回true
            return true;
        }
        //当前走过的点标记
        visited[i][j] = true;
        //dfs走四个方向
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean res = false;
        for (int[] direction : directions) {//四个方向分别和下一个字符比
            int nextI = i + direction[0];
            int nextJ = j + direction[1];
            //判断是否越界
            if (nextI >= 0 && nextI < board.length && nextJ >= 0 && nextJ < board[0].length) {//未越界
                if (!visited[nextI][nextJ]) {//没走过
                    boolean temp = dfs(board, visited, nextI, nextJ, word, k + 1);//比下一个字符
                    if (temp) {
                        res = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;//回溯的时候将当前点置为没走过
        return res;
    }

}
