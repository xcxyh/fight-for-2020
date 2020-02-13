package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/12/14 14:29
 * @description：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 解：二分查找，数组折半分解，判断最小元素在哪部分
 *
 * 当 nums[m] <= nums[h] 时，表示 [m, h] 区间内的数组是非递减数组，[l, m] 区间内的数组是旋转数组，此时令 h = m；
 * 否则 [m + 1, h] 区间内的数组是旋转数组，令 l = m + 1。
 * @modified By：
 * @version: $
 */
public class J11_minNumInRotateArray {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,1,0,1};
        System.out.println(minNumberInRotateArray_dup(array));
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/12/14 15:18
     *  @Description:  数组中没有重复元素 二分查找
     */
    public int minNumberInRotateArray(int[] array){

        if (array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length-1;

        while(left < right){
            //中间位置index
            int mid = left + (right - left) / 2;
            //右半部分有序
            if (array[mid] <= array[right]) {
                //说明最小元素在左半部分
                right = mid;
            }else {
                left = mid + 1;
            }
        }

    return array[left];
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/12/14 15:18
     *  @Description:  数组中有重复元素 二分查找,出现 无法判断的情况，改用顺序查找
     */
    public static int minNumberInRotateArray_dup(int[] array){

        if (array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length-1;

        while(left < right){
            //中间位置index
            int mid = left + (right - left) / 2;
            if(array[left] == array[mid] && array[mid] == array[right]){
                return minNumber(array, left, right);
            }

            //右半部分有序
            if (array[mid] <= array[right]) {
                //说明最小元素在左半部分
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return array[left];
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/12/14 15:38
     *  @Description: 顺序查找 一个数组中的 最小元素
     */
    private static int minNumber(int[] array, int left, int right) {
        int min = array[left];
        for (int i = left; i <right ; i++) {
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

}
