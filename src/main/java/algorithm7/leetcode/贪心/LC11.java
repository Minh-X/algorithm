package algorithm7.leetcode.贪心;

/**
 * @Author: permission
 * @Date: 2023/2/4 3:28
 * @Version: 1.0
 * @ClassName: LC11
 * @Description: 11. 盛最多水的容器
 */
public class LC11 {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int res = maxArea(height);
        System.out.println(res);
    }

    public static int maxArea(int[] height) {
        return handle_greed(height);
    }

    /*
            贪心
                下标i为宽 height[i]为高

            当left指针在最左，right在最有时，宽最大， 接下来left、right指针向内移动，每次移动height[i]小的指针
     */
    private static int handle_greed(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = (right - left) * Math.min(height[left], height[right]);
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
        }
        return res;
    }

}
