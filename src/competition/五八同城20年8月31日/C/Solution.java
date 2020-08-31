package competition.五八同城20年8月31日.C;

public class Solution {
    /**
     * 翻译组合数
     *
     * @param num int整型 数字加密报文
     * @return int整型
     */
    int res = 0;

    public int translateNum(int num) {
        res = 0;
        String s = String.valueOf(num);
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int i) {
        if (i == s.length()) {
            res++;
            return;
        }
        dfs(s, i + 1);
        if (i <= s.length() - 2 && s.charAt(i) != '0' && Integer.valueOf(s.substring(i, i + 2)) < 26) {
            dfs(s, i + 2);
        }
    }
}