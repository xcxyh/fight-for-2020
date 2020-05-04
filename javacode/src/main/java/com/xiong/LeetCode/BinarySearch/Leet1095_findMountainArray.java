package com.xiong.LeetCode.BinarySearch;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/29 18:18
 * @description：
 * @modified By：
 * @version: $
 */

class MountainArray {

    private int[] arr;
    private int size;

    public MountainArray(int[] arr) {
        this.arr = arr;
        this.size = this.arr.length;
    }

    public int get(int index) {
        return this.arr[index];
    }

    public int length() {
        return this.size;
    }

}

public class Leet1095_findMountainArray {

    //length= 10000  对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。
    // logn 复杂度  二分查找
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // 查找 i
        int index = findTop(mountainArr, 0, mountainArr.length() - 1);
        //在i 的左边找
        int before = findFromLeft(mountainArr, 0, index, target);
        if (before != -1) {
            return before;
        }
        // 在i 的右边 找
        return findFromRight(mountainArr, index, mountainArr.length() - 1, target);


    }

    //找到 山峰  我这里用遍历查找所以没通过   应该也用二分查找
    private int findTop(MountainArray mountainArr, int left, int right) {

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return left;

    }

    //  山峰左边找
    private int findFromLeft(MountainArray mountainArr, int left, int right, int target) {

        // 在前有序且升序数组中找 target 所在的索引
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        if (mountainArr.get(left) == target) {
            return left;
        }

        return -1;

    }

    //  山峰右边找
    private int findFromRight(MountainArray mountainArr, int left, int right, int target) {

        // 在前有序且升序数组中找 target 所在的索引
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > target) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        if (mountainArr.get(left) == target) {
            return left;
        }

        return -1;

    }
}
