package com.xiong.LeetCode.RaceOfWeek;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/19 12:34
 * @description：  第 185 场力扣周赛
 * @modified By：
 * @version: $
 */
public class Race_185 {
    public static void main(String[] args) {
        System.out.println(reformat("covid2019"));
    }

    //题1  5388. 重新格式化字符串  通过
    public static String reformat(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        char[] sb1 = new char[len];
        char[] sb2 = new char[len];
        int i = 0;
        int j = 0;
        for (char c : chars) {

            if (c >= '0' && c <= '9') {
                sb1[i++] = c;
            }
            if (c >= 'a' && c <= 'z') {
                sb2[j++] = c;
            }

        }
        if (Math.abs(i - j) > 1) {
            return "";
        }
        int k = 0;
        int m = 0;
        StringBuilder sb = new StringBuilder();
        if (i >= j) {
            for (char c : sb1) {
                if (c >= '0' && c <= '9') {
                    sb.append(c);
                }
                if (sb2[k] >= 'a' && sb2[k] <= 'z') {
                    sb.append(sb2[k]);
                    k++;
                }
            }
        } else {
            for (char c : sb2) {
                if (c >= 'a' && c <= 'z') {
                    sb.append(c);
                }
                if (sb1[m] >= '0' && sb1[m] <= '9') {
                    sb.append(sb1[m]);
                    m++;
                }
            }
        }
        return sb.toString();
    }

    //题2   5389. 点菜展示表   通过
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ans = new ArrayList<>();
        List<String> headers = new ArrayList<>();
        headers.add("Table");
        List<String> foodName = new ArrayList<>();
        for (List<String> ele : orders) {
            if (!foodName.contains(ele.get(2))) {
                foodName.add(ele.get(2));
            }
        }
        Collections.sort(foodName);  // 按名称排序
        headers.addAll(foodName);
        ans.add(headers);

        Map<Integer, List<String>> tableMap = new TreeMap<>(); // table --- list<cai>  按table 大小 排序
        for (List<String> ele : orders) {

            String table = ele.get(1);
            String thing = ele.get(2);

            List<String> list = tableMap.get(Integer.parseInt(table));
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(thing);
            tableMap.put(Integer.parseInt(table), list);
        }
        for (Integer table : tableMap.keySet()) {
            List<String> list = tableMap.get(table);
            List<String> tableList = new ArrayList<>();
            tableList.add(table + "");
            Map<String, Integer> food = new HashMap<>();//  cai --- num   当前 table 各 菜的个数
            if (list != null) {
                for (String thing : list) {
                    food.put(thing, food.getOrDefault(thing, 0) + 1);
                }
            }
            for (int i = 1; i < headers.size(); i++) {
                tableList.add(food.getOrDefault(headers.get(i), 0) + "");
            }
            ans.add(tableList);
        }
        return ans;
    }

    //题3   5390. 数青蛙  出错
    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0, r = 0, o = 0, a = 0, k = 0;
        int ans = 0;
        for (char x : croakOfFrogs.toCharArray()) {
            switch (x) {
                case 'c':
                    c++;
                    break;
                case 'r':
                    r++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'a':
                    a++;
                    break;
                case 'k':
                    k++;
                    break;
                default:
                    break;
            }
            ans = Math.max(ans, c);
            if (k >a || a > o || o > r || r > c){
                return -1;
            }
            if(k == 1){
                c--;
                r--;
                o--;
                a--;
                k--;
            }
        }
        if(c != 0){ // 没有构成完整的croak 返回 -1
            return -1;
        }
        return  ans;
    }


    //题4   5391. 生成数组  放弃
}
