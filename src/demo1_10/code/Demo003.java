package demo1_10.code;

import java.util.*;

/**
 * @author xuezy
 * @description 给定一个字符串，找到没有重复字符的最长子串，返回它的长度。
 * @date 2021/5/21 15:42
 */
public class Demo003 {

	/**
	 * 方法1（自行思考）
	 * 耗时：4小时
	 */
	public static int method(String s){
		// 存储字符串
		StringBuilder sf = new StringBuilder();
		// 存储字符串长度
		Set<Integer> res = new HashSet<>();
		String tempStr = "";
		for(int i=0;i<s.length();i++) {
			tempStr = String.valueOf(s.charAt(i));
			// 包含字符的时候，字符串长度放入set结果集中  给I赋值重新从重复点的下一个位置循环
			if (sf.toString().contains(tempStr)) {
				res.add(sf.length());
				s = s.substring(s.indexOf(tempStr) + 1);
				i = -1;
				sf = new StringBuilder();
			} else {
				// 不包含元素的时候，继续放入
				sf.append(tempStr);
			}
		}
		res.add(sf.length());
		return Collections.max(res);
	}

	/**
	 * 方法2（来自leetcode题目评价区）
	 */
	public static int method2(String s){
		// 记录字符上一次出现的位置
		int[] last = new int[128];
		int n = s.length();
		int res = 0;
		// 窗口开始位置
		int start = 0;
		for(int i=0;i<n;i++){
			// 获取字符对应的 unicode值
			int index = s.charAt(i);
			start = Math.max(start, last[index]);
			res = Math.max(res, i - start + 1);
			// 记录字符出现的位置
			last[index] = i + 1;
		}
		return res;
	}



	public static void main(String[] args) {
		// " " "aab"  "devdf"
		String str = "abcabcbb";
//		System.out.println(method(str));
		System.out.println(method2(str));
	}

}
