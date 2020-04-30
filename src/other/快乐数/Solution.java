/*
快乐数
编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。

如果 n 是快乐数就返回 True ；不是，则返回 False 。



示例：

输入：19
输出：true
解释：
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
###解题思路
没啥好说的，每次判断是否结果是否出现过即可，出现则陷入循环
执行用时 :1 ms, 在所有 Java 提交中击败了99.89%的用户
内存消耗 :36.8 MB, 在所有 Java 提交中击败了8.33%的用户
 */
package other.快乐数;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public  boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        while (true) {
            int sum = 0;
            int key = n;
            while (n / 10 > 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            sum += Math.pow(n, 2);
            if (sum == 1) return true;
            if (map.containsKey(sum)) return false;
            map.put(key, sum);
            n = sum;
        }
    }
}