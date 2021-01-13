package com.example.ddc.leetcode.editor.cn;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 2879 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        //1.暴力解法
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
        //3层循环找到需要的
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                for (int k=j+1;k<nums.length;k++){
                    //如果是满足了条件
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> integers = new ArrayList<Integer>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[k]);
                        //去重
                        if (lists.size() == 0) {
                            lists.add(integers);
                        }else {
                            boolean b = true;
                            for (int x=0;x<lists.size();x++){
                                List<Integer> list = lists.get(i);
                                if (list.containsAll(integers)) {
                                    b = false;
                                }
                            }
                            if (b){
                                lists.add(integers);
                            }
                        }
                    }
                }
            }
        }
        return lists;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
