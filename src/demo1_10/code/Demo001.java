package demo1_10.code;

import java.util.*;

/**
 * @author xuezy
 * @description 给定一个数组和一个目标和，从数组中找两个数字相加等于目标和，输出这连个数字的下标
 * @date 2021/5/13 17:54
 */
public class Demo001 {

	/**
	 * @describe 解法一：两个for遍历数组，返回符合条件的下标
	 * 时间复杂度0（n * n）  空间复杂度0（1）
	 * @author xuezy
	 * @date 2021/5/13 17:56
	 * @param nums 数组
	 * @param target 目标和
	 * @return int[]
	 */
	public static String method01(int[] nums, int target){
		StringBuilder sbr = new StringBuilder();
		int len = nums.length;
		for(int i=0;i<len;i++){
			for(int j=i+1;j<len;j++){
				if(nums[i] + nums[j] == target){
					sbr.append(i).append(",").append(j).append(";");
				}
			}
		}
		return sbr.toString();
	}

	/**
	 * @describe 解法二：1个for循环，时间复杂度为0（n）
	 * @author xuezy
	 * @date 2021/5/13 17:56
	 * @param nums 数组
	 * @param target 目标和
	 * @return int[]
	 */
	public static int[] method02(int[] nums, int target) {
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		int[] res = {0,0};
		for(int i=0;i<n;i++){
			int num = nums[i];
			int temp = target - num;
			if(map.containsKey(temp)){
				res[0] = map.get(temp).intValue();
				res[1] = i;
				break;
			}
			map.put(nums[i], i);
		}
		return res;
	}

	/**
	 * @describe 解法二：1个for循环，时间复杂度为0（n）  （来自leetcode题目评价区）
	 * @author xuezy
	 * @date 2021/5/13 17:56
	 * @param nums 数组
	 * @param target 目标和
	 * @return int[]
	 */
	public static int[] method022(int[] nums, int target) {
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<n;i++){
			int num = nums[i];
			int temp = target - num;
			if(map.containsKey(num)){
				return new int[]{map.get(num), i};
			}
			map.put(temp, i);
		}
		return null;
	}

	/**
	 * @describe 使用while循环
	 * @author xuezy
	 * @date 2021/5/24 18:25
	 * @param nums
	 * @param target
	 * @return int[]
	 */
	public static int[] method03(int[] nums, int target) {
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>(4);
		int[] res = {0,0};
		int i = 0;
		while(i < n){
			int num = nums[i];
			int temp = target - num;
			if(map.containsKey(temp)){
				res[0] = map.get(temp).intValue();
				res[1] = i;
				break;
			}
			map.put(nums[i], i);
			i++;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] tempAry = {1,2,3,4,5};
		int tempTarget = 7;
		// 调用方法一
		String res1 = method01(tempAry, tempTarget);
		System.out.println("调用方法一结果（符合条件的两个数组元素的下标用逗号隔开，多组用分号隔开）：" + res1);
		// 调用方法二
		int[] res2 = method022(tempAry, tempTarget);
		System.out.println(Arrays.toString(res2));
		// 调用方法二
		int[] res3 = method03(tempAry, tempTarget);
		System.out.println(Arrays.toString(res3));
	}

}
