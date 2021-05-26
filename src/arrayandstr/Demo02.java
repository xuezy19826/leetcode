package arrayandstr;

/**
 * @author xuezy
 * @description 搜索插入位置
 * @date 2021/5/26 16:48
 */
public class Demo02 {

	/**
	 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
	 * 你可以假设数组中无重复元素。
	 * 时间复杂度 0(n)
	 */
	public static int insertIndex(int[] nums, int insertNum){
		int n = nums.length;
		int max = nums[n - 1];
		// 大于最大值 直接返回下标
		if (insertNum > max) {
			return n;
		}
		for(int i = 0; i < n; i++){
			// 当插入的数字小于最小的元素  直接返回下标
			if(insertNum <= nums[i]){
				return i;
			}
		}
		return 0;
	}

	/**
	 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
	 * 你可以假设数组中无重复元素。
	 * 时间复杂度 0(log n)  比方法一好
	 */
	public static int insertIndex2(int[] nums, int insertNum){
		int n = nums.length;
		int max = nums[n - 1];
		// 大于最大值 直接返回下标
		if (insertNum > max) {
			return n;
		}
		int i = 0;
		while(i < n){
			// 当插入的数字小于最小的元素  直接返回下标
			if(insertNum <= nums[i]){
				return i;
			}
			i++;
		}
		return 0;
	}

	public static void main(String[] args) {
		// 输入: [1,3,5,6], 5   输出: 2
		System.out.println(insertIndex2(new int[]{1,3,5,6}, 5));
		// 输入: [1,3,5,6], 2   输出: 1
		System.out.println(insertIndex2(new int[]{1,3,5,6}, 2));
		// 输入: [1,3,5,6], 7   输出: 4
		System.out.println(insertIndex2(new int[]{1,3,5,6}, 7));
		// 输入: [1,3,5,6], 0   输出: 0
		System.out.println(insertIndex2(new int[]{1,3,5,6}, 0));
	}

}
