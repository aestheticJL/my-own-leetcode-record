package string.字符串相乘;

class Solution {
    public String multiply(String num1, String num2) {
        String res = "";
        if (num1.equals("0") || num2.equals("0")) return "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            String temp = mul(num1, num2.charAt(i) - '0');
            StringBuilder sb = new StringBuilder(temp);
            if (sb.toString() != "0") {
                for (int j = num2.length() - 1; j > i; j--) {
                    sb.append('0');
                }
                res = add(res, sb.toString());
            }
        }
        return res;
    }

    public String mul(String num1, int n) {
        if (n == 0) return "0";
        int pre = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int res = (num1.charAt(i) - '0') * n + pre;
            int next = res % 10;
            pre = res / 10;
            sb.insert(0, next);
        }
        if (pre != 0) sb.insert(0, pre);
        return sb.toString();
    }

    public String add(String a, String b) {
        int pre = 0;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < a.length() || index < b.length() || pre != 0) {
            int first = 0;
            int second = 0;
            if (index < a.length()) first = a.charAt(a.length() - index - 1) - '0';
            if (index < b.length()) second = b.charAt(b.length() - index - 1) - '0';
            int res = first + second + pre;
            int next = res % 10;
            pre = res / 10;
            index++;
            sb.insert(0, next);
        }
        return sb.toString();
    }
}