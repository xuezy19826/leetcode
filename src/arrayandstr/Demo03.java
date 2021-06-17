package arrayandstr;

import java.util.*;

/**
 * @author xuezy
 * @description 合并区间
 * @date 2021/5/26 17:10
 */
public class Demo03 {

	/**
	 * @describe 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
	 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
	 *
	 * 总结：没想到有按照二维数组某个元素排序的方法可以直接调用导致写了好多代码
	 */
	public static int[][] merge(int[][] intervals) {
		int n = intervals.length;
		if(n == 0){
			return intervals;
		}
		// 按照每行的第0列升序排列
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
		// 使用list存储数组
		List<int[]> list = new ArrayList<>();
		// 定义一个int类型的数组用于比较，默认为二维数组中第一个数组的值
		int[] ints = intervals[0];
		// 循环二维数组
		for(int i = 1; i < n; i++){
			// 如果第一个数组的右端点大于第二个数组的左端点，说明两个数组有交集
			if(ints[1] >= intervals[i][0]){
				// int类型的数组右端点等于两个数组中右端点大的那个值
				ints[1] = Math.max(ints[1], intervals[i][1]);
			} else {
				// 比较没有重合 ints添加到数组中
				list.add(ints);
				// 重新赋值
				ints = intervals[i];
			}
		}
		list.add(ints);
		return list.toArray(new int[list.size()][2]);
	}

	public static void main(String[] args) {
		// 	 * 示例 1：
		//	 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]  输出：[[1,6],[8,10],[15,18]]
		//	 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
		//	 *
		//	 * 示例2：
		//	 * 输入：intervals = [[1,4],[4,5]]  输出：[[1,5]]
		//	 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
		//	 *
		//	 * 示例3：
		//	 * 输入：intervals = [[1,3]]  输出：[[1,3]]
		//	 *
		//	 * 示例4：
		//	 * 输入：intervals = [[1,4],[1,4]]  输出：[[1,4]]
		//	 *
		//	 * 示例5：
		//	 * 输入：intervals = [[1,4],[5,6]]  输出：[[1,4],[5,6]]
		//	 *
		//	 * 示例6：
		//	 * 输入：intervals = [[1,4],[0,4]]  输出：[[0,4]]
		//	 *
		//	 * 示例7：
		//	 * 输入：intervals = [[1,4],[0,0]]  输出：[[0,0],[1,4]]
		//	 *
		//	 * 示例8：
		//	 * 输入：intervals = [[1,4],[0,1]]  输出：[[0,4]
		//	 *
		//	 * 示例9：
		//	 * 输入：intervals = [[1,4],[2,3]]  输出：[[1,4]
//		System.out.println(Arrays.deepToString(merge(new int[][]{{1,3}, {2,6}, {8,10}, {15,18}})));
//		System.out.println(Arrays.deepToString(merge(new int[][]{{1,4}, {4,5}})));
//		System.out.println(Arrays.deepToString(merge(new int[][]{{1,3}})));
//		System.out.println(Arrays.deepToString(merge(new int[][]{{1,4}, {1,4}})));
//		System.out.println(Arrays.deepToString(merge(new int[][]{{1,4}, {0,4}})));
//		System.out.println(Arrays.deepToString(merge(new int[][]{{1,4}, {0,0}})));
//		System.out.println(Arrays.deepToString(merge(new int[][]{{1,4}, {0,1}})));
		System.out.println(Arrays.deepToString(merge(new int[][]{{1,4}, {0,2}, {3,5}})));
	}
}
