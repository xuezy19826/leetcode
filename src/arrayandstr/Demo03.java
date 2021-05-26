package arrayandstr;

import java.util.Arrays;

/**
 * @author xuezy
 * @description 合并区间
 * @date 2021/5/26 17:10
 */
public class Demo03 {

	/**
	 * @describe 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
	 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
	 */
	public static int[][] merge(int[][] intervals) {
		int n = intervals.length;
		if(n == 1){
			return intervals;
		}
		int[][] endary = new int[n][];
		int i = 0;
		int[] temp = null;
		while (i < n) {
			if(temp != null){
				if(temp[0] >= intervals[i][0] && temp[0] <= intervals[i][1] ||
								(temp[1] >= intervals[i][0] && temp[1] <= intervals[i][1])) {
					temp[0] = Math.min(temp[0], intervals[i][0]);
					temp[1] = Math.max(temp[1], intervals[i][1]);
					endary = new int[n-1][];
					endary[i - 1] = temp;
				} else {
					if (n == 2){
						if(temp[1] > intervals[i][0] && temp[1] > intervals[i][1]){
							endary[i - 1] = intervals[i];
							endary[i] = temp;
						} else {
							endary[i - 1] = temp;
							endary[i] = intervals[i];
						}
					} else {
						temp = intervals[i];
						endary[i - 1] = temp;
					}
				}
			} else {
				temp = intervals[i];
			}
			i++;
		}
		return endary;
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
		System.out.println(Arrays.deepToString(merge(new int[][]{{1,4}, {2,3}})));
	}
}
