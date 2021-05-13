package demo1_10.code;

import	java.util.ArrayList;
import java.util.List;

/**
 * @author xuezy
 * @description 给定一个数组和一个目标和，从数组中找两个数字相加等于目标和，输出这连个数字的下标
 * @date 2021/5/13 17:54
 */
public class Demo001 {

	/**
	 * @describe 解法一：遍历数组，返回符合条件的下标
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

	public static void main(String[] args) {
		int[] tempAry = {1,2,3,4,5};
		int tempTarget = 7;
		// 调用方法一
		String res1 = method01(tempAry, tempTarget);
		System.out.println("调用方法一结果（符合条件的两个数组元素的下标用逗号隔开，多组用分号隔开）：" + res1);
	}

}
