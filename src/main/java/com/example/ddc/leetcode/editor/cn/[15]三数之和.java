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


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        /**
         1.暴力解法
         直接三重循环进行求解,难点在于是需要进行去重的 , 所以首先使用了排序 , 令三个元素包顺序 , 可以去掉可能的重复
         2.双指针夹逼
         简单来说 , 就是固定一个指针 , 让两个指针来同时移动,可以减少一层循环
         这样的问题就是需要知道怎么移动着两个指针?规则是什么呢
         由于有了排序,所以规则就确定了下来,左指针从小到大,右指针从大到小
         3.使用hash表的方式
         将所有的值写入hash表中 , 循环得到
         */
        /****************************************************************************************/
        //1.暴力解法(运行已经超出时间限制了)
//        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; ++i) {
//            //如果是相同的元素,那不在进行选择
//            if (i >0 && nums[i] == nums[i-1]) {
//                continue;
//            }
//            for (int j = i + 1; j < nums.length; ++j) {
//                if (j> i+1 && nums[j] == nums[j-1]) {
//                    continue;
//                }
//                for (int k = j + 1; k < nums.length; ++k) {
//                    //如果是满足了条件
//                    if (k> j+1 && nums[k] == nums[k-1]) {
//                        continue;
//                    }
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        ArrayList<Integer> integers = new ArrayList<Integer>();
//                        integers.add(nums[i]);
//                        integers.add(nums[j]);
//                        integers.add(nums[k]);
//                        lists.add(integers);
//                    }
//                }
//            }
//        }
//        return lists;
        /**********************************************************************************************/
        //双指针
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
        int n = nums.length;
        //进行排序之后 , 就可以确定双指针的移动方式
        Arrays.sort(nums);
        //第一层循环来解决固定指针的问题
        //第二层循环来解决双指针的问题
        for (int i =0;i<n-2;++i){
            int target = nums[i];
            //先行判定条件:
            // 因为最后是要找和为0的三个数 , 并且由于已经从小到大进行排序了,所以最外层的要求就是不大于0
            // 如果是相同的数, 也不用再找了
            if (target > 0) {
                continue;
            }
            if (i > 0 && nums[i-1] == target) {
                continue;
            }
            int left = i+1,right = n-1;
            while (left < right){
                int sum = nums[left] + nums[right] + target;
                if (sum == 0) {
                    //如果已经满足条件,进行添加
                    lists.add(Arrays.asList(nums[left],nums[right],nums[i]));
                    //处理可能造成的重复
                    while (left<right && nums[left] == nums[++left]);
                    while (right > left && nums[right] == nums[--right]);
                }else if (sum < 0){
                    //如果现在和是小于0的话 ,那就是后两个数小了,需要加大,即left指针进行右移的操作
                    ++left;
                }else {
                    //如果现在和是大于0的话 ,那就是后两个数大了,需要减小,即right指针进行左移的操作
                    --right;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        threeSum(new int[]{0,0,0});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
