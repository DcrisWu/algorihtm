package classification.双指针.相向双指针.code_11_盛最多水的容器;

class Solution {
    /**
     * 盛最多水的容器
     * 首先设定两个指针分别在一头一尾，无论是哪个指针往中间移动，容器的底都是不断变小的
     * 要想容量变大，就只能尝试选择尽量长的短板，所以双指针在移动时候，就选择 height[i] 的指针移动
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int ans = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                ans = Math.max(ans, (j - i) * height[i]);
                i++;
            }else {
                ans = Math.max(ans, (j - i) * height[j]);
                j--;
            }
        }
        return ans;
    }
}