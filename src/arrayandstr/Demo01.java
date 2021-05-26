package arrayandstr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xuezy
 * @description 寻找数组的中心索引
 * @date 2021/5/25 11:50
 */
public class Demo01 {
	
	/**
	 * 描述：
	 * 给你一个整数数组nums，请编写一个能够返回数组 “中心下标” 的方法。
	 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
	 * 如果数组不存在中心下标，返回 -1 。如果数组有多个中心下标，应该返回最靠近左边的那一个。
	 * 注意：中心下标可能出现在数组的两端。
	 * [示例 1]
	 * 输入：nums = [1, 7, 3, 6, 5, 6]
	 * 输出：3
	 * 解释：
	 * 中心下标是 3 。
	 * 左侧数之和 (1 + 7 + 3 = 11)，
	 * 右侧数之和 (5 + 6 = 11) ，二者相等。
	 * [示例 2]
	 * 输入：nums = [1, 2, 3]
	 * 输出：-1
	 * 解释：
	 * 数组中不存在满足此条件的中心下标。
	 * [示例 3]
	 * 输入：nums = [2, 1, -1]
	 * 输出：0
	 * 解释：
	 * 中心下标是 0 。
	 * 下标 0 左侧不存在元素，视作和为 0 ；
	 * 右侧数之和为 1 + (-1) = 0 ，二者相等。
	 * [提示]
	 * nums 的长度范围为[0, 10000]。
	 * 任何一个nums[i] 将会是一个范围在[-1000, 1000]的整数。
	 *
	 *
	 * 思路
	 * 记数组的全部元素之和为 total，当遍历到第 i 个元素时，设其左侧元素之和为 sum，
	 * 则其右侧元素之和为 total - nums[i] - sum
	 * 左右侧元素相等即为 sum = total - nums[i] - sum  即 2 * sum = total - nums[i]
	 * 当中心索引左侧或右侧没有元素时，即为零个项相加，这在数学上称作「空和」（empty sum）。在程序设计中我们约定「空和是零」。
	 */
	public static int centorIndex(int[] nums){
		int total = Arrays.stream(nums).sum();
		int sum = 0;
		int n = nums.length;
		for(int i = 0; i < n; i++){
			if(2 * sum + nums[i] == total){
				return i;
			}
			sum += nums[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		// 输入：nums = [1, 7, 3, 6, 5, 6]    输出：3
		int[] nums = {1, 7, 3, 6, 5, 6};
		System.out.println(centorIndex(nums));

		//  输入：nums = [1, 2, 3]    输出：-1
		int[] nums2 = {1, 2, 3};
		System.out.println(centorIndex(nums2));

		// 输入：nums = [2, 1, -1]    输出：0
		int[] nums3 = {2, 1, -1};
		System.out.println(centorIndex(nums3));

		// 输入：[-1,-1,-1,1,1,1]    输出：-1
		int[] nums4 = {-1,-1,-1,1,1,1};
		System.out.println(centorIndex(nums4));

		// 输入：[-1,-1,0,-1,-1,0]	输出：2
		int[] nums5 = {-1,-1,0,-1,-1,0};
		System.out.println(centorIndex(nums5));
	}
}
