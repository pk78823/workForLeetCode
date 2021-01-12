package com.example.ddc.leetcode.editor.cn;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 909 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution283 {
    public static void moveZeroes(int[] nums) {
        //1.要保证非0元素的相对顺序2.只能在原数组上操作

        //直接将所有的非0元素顺序移动 , 然后最后补0就可以了
        int j=0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i] !=0) {
                nums[j++] = nums[i];
            }
        }
        while (j<nums.length){
            nums[j++] = 0;
        }
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{1});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
