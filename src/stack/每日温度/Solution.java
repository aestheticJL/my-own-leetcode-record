/*
每日温度
根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
###解题思路
利用栈来维护
执行用时 :23 ms, 在所有 Java 提交中击败了65.00%的用户
内存消耗 :47.1 MB, 在所有 Java 提交中击败了6.45%的用户
 */
package stack.每日温度;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        Arrays.fill(res, 0);
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty()) {
                if (T[i] > T[stack.peek()]) {
                    Integer pop = stack.pop();
                    res[pop] = i - pop;
                }else {
                    break;
                }
            }
            stack.push(i);
        }
        return res;
    }
}