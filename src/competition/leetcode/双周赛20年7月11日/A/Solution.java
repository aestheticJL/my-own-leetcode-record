/*
5177. 转变日期格式 显示英文描述
通过的用户数1765
尝试过的用户数1801
用户总通过次数1786
用户总提交次数3160
题目难度Easy
给你一个字符串 date ，它的格式为 Day Month Year ，其中：

Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
Year 的范围在 ​[1900, 2100] 之间。
请你将字符串转变为 YYYY-MM-DD 的格式，其中：

YYYY 表示 4 位的年份。
MM 表示 2 位的月份。
DD 表示 2 位的天数。


示例 1：

输入：date = "20th Oct 2052"
输出："2052-10-20"
示例 2：

输入：date = "6th Jun 1933"
输出："1933-06-06"
示例 3：

输入：date = "26th May 1960"
输出："1960-05-26"
 */
package competition.leetcode.双周赛20年7月11日.A;

class Solution {
    public String reformatDate(String date) {
        String[] split = date.split(" ");
        String month, day;
        if (split[0].charAt(1) >= '0' && split[0].charAt(1) <= '9') {
            day = split[0].substring(0, 2);
        } else {
            day = "0" + split[0].substring(0, 1);
        }
        month = "00";
        switch (split[1]) {
            case "Jan":
                month = "01";
                break;
            case "Feb":
                month = "02";
                break;
            case "Mar":
                month = "03";
                break;
            case "Apr":
                month = "04";
                break;
            case "May":
                month = "05";
                break;
            case "Jun":
                month = "06";
                break;
            case "Jul":
                month = "07";
                break;
            case "Aug":
                month = "08";
                break;
            case "Sep":
                month = "09";
                break;
            case "Oct":
                month = "10";
                break;
            case "Nov":
                month = "11";
                break;
            case "Dec":
                month = "12";
                break;
        }
        return split[2] + "-" + month + "-" + day;
    }
}