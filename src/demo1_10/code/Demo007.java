package demo1_10.code;

/**
 * @author xuezy
 * @description 整数反转
 * @date 2021/5/24 18:49
 */
public class Demo007 {
	/*
	 *  给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
		如果反转后整数超过 32 位的有符号整数的范围 [-2的31次方，2的31次方 -1] ，就返回 0。
		假设环境不允许存储 64 位整数（有符号或无符号）。
		示例 1：
		输入：x = 123
		输出：321
		示例 2：
		输入：x = -123
		输出：-321
		示例 3：
		输入：x = 120
		输出：21
		示例 4：
		输入：x = 0
		输出：0
		提示：
		-231 <= x <= 231 - 1
		来源：力扣（LeetCode）
		链接：https://leetcode-cn.com/problems/reverse-integer
		著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */


	// 2的多少次方：Math.pow(2,n)
	public static int reverse(int x){
		if(x == 0){
			return 0;
		}
		// 获取符号 1表示正数
		float fh = Math.signum(x);
		// 转字符串
		String tempStr = String.valueOf(x);
		// 使用StringBulider反转方法
		StringBuilder stb = null;
		stb = fh == 1 ? new StringBuilder(tempStr) : new StringBuilder(tempStr.substring(1));
		String tempStr2 = stb.reverse().toString();
		Double num = Double.valueOf(tempStr2);
		Double tempVal = (fh > 0) ? num : num * -1;
		if (tempVal < Math.pow(-2, 31) || tempVal > Math.pow(2, 31) - 1) {
			return 0;
		}
		return tempVal.intValue();
	}


	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}
}
