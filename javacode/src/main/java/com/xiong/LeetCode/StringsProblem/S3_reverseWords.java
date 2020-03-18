package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/17 11:26
 * @description：
 * s = "I am a student"
 * Return "student a am I"
 *  将每个单词翻转，然后将整个字符串翻转。
 * @modified By：
 * @version: $
 */
public class S3_reverseWords {

    public static void main(String[] args) {
        System.out.println(swapWords("I am     a       students"));
    }

    public static String reverseWords(String words){
        StringBuilder stringBuilder = new StringBuilder();
        String[] strs = words.split("\\s+");
        for (int i = 0; i <strs.length ; i++) {
            strs[i] = reverseStr(strs[i]);
            if (i == strs.length - 1){
                stringBuilder.append(strs[i]);
            }else{
                stringBuilder.append(strs[i] + " ");
            }
        }
        return reverseStr(stringBuilder.toString());
        
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/3/17 11:32
     *  @Description: 翻转字符串
     */
    private static String reverseStr(String str){

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = str.length() - 1; i >= 0 ; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/3/17 11:50
     *  @Description: 别人的答案  可以有多个空格  "I am     a       student"
     */
    public static String swapWords(String s) {
        if (s == null) {
            return null;
        }
        String ret = "";
        if (!s.endsWith(" ")) {
            s += " ";
        }
        char[] charArr = s.toCharArray();
        int begin = 0;

        int i = 0;
        while (i < charArr.length) {
            while (charArr[i] == ' ') {
                i++;
            }
            begin = i; // 获取单词的第一个字母对应的位置
            while (charArr[i] != ' ') { // 找到单词后第一个空格对应的位置
                i++;
            }
            reverseString(charArr, begin, i - 1);
            i++;
        }
        //因为前面多加了一个空格 这里 charArr.length -2
        reverseString(charArr,0,charArr.length - 2);
        ret = new String(charArr);
        return ret;
    }
    /**
     * @author: xiongcong
     * @Date: 2020/3/17 11:13
     * @Description: 翻转一个char数组中的部分元素
     */
    private static void reverseString(char[] chars, int left, int right) {
        if (chars.length <= 1) {
            return;
        }
        while (left < right) {
            //交换
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
