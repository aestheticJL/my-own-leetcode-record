/*
1419. 数青蛙
给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。

注意：要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。

如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。



示例 1：

输入：croakOfFrogs = "croakcroak"
输出：1
解释：一只青蛙 “呱呱” 两次
示例 2：

输入：croakOfFrogs = "crcoakroak"
输出：2
解释：最少需要两只青蛙，“呱呱” 声用黑体标注
第一只青蛙 "crcoakroak"
第二只青蛙 "crcoakroak"
示例 3：

输入：croakOfFrogs = "croakcrook"
输出：-1
解释：给出的字符串不是 "croak" 的有效组合。
示例 4：

输入：croakOfFrogs = "croakcroa"
输出：-1


提示：

1 <= croakOfFrogs.length <= 10^5
字符串中的字符只有 'c', 'r', 'o', 'a' 或者 'k'
###解题思路
类似消除，集齐croak就消除，某一时刻c的数量比k的数量大多少就是这一时刻至少需要的青蛙数，取最大值。
不能出现前一个字母比后一个字母数量少的情况
执行用时：27 ms, 在所有 Java 提交中击败了11.58%的用户
内存消耗：40.2 MB, 在所有 Java 提交中击败了65.22%的用户
 */
package string.数青蛙;

class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] arr = new int[5];
        int res = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            if (croakOfFrogs.charAt(i) == 'c') arr[0]++;
            else if (croakOfFrogs.charAt(i) == 'r') arr[1]++;
            else if (croakOfFrogs.charAt(i) == 'o') arr[2]++;
            else if (croakOfFrogs.charAt(i) == 'a') arr[3]++;
            else if (croakOfFrogs.charAt(i) == 'k') arr[4]++;
            if (!(arr[0] >= arr[1] && arr[1] >= arr[2] && arr[2] >= arr[3] && arr[3] >= arr[4])) return -1;
            res = Math.max(res, arr[0] - arr[4]);
        }
        if (arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3] && arr[3] == arr[4]) return res;
        else return -1;
    }
}