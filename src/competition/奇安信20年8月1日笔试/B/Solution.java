package competition.奇安信20年8月1日笔试.B;

public class Solution {
    /**
     * 返回亲7数个数
     *
     * @param digit int整型一维数组 组成亲7数的数字数组
     * @return int整型
     */
    int res;

    public int reletive_7(int[] digit) {
        if (digit.length == 0 || digit == null) return 0;
        res = 0;
        StringBuilder sb = new StringBuilder();
        int[] vis = new int[digit.length];
        dfs(digit, vis, sb);
        return res;
    }

    public void dfs(int[] digit, int[] vis, StringBuilder sb) {
        if (sb.length() == digit.length) {
            Integer num = Integer.valueOf(sb.toString());
            if (num % 7 == 0) res++;
            return;
        }
        for (int i = 0; i < digit.length; i++) {
            if (sb.length() == 0 && digit[i] == 0) continue;
            if (vis[i] == 0) {
                sb.append(digit[i]);
                vis[i] = 1;
                dfs(digit, vis, sb);
                vis[i] = 0;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}