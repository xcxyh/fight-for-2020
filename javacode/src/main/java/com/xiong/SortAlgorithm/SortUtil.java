package com.xiong.SortAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: SortUtil.java
 * @Package:utils
 * @Description:(作用)
 * @author: xcc
 * @date:2019年4月1日
 * @version:V1.0
 */
public class SortUtil {

	/**
	 * 冒泡排序 时间复杂度O(n^2)
	 * 
	 * @param arr
	 */
	public static int[] bubbleSort(int[] arr) {
		int temp;

		int ischanged;
		// 第一层循环表明比较的轮数, 比如 length 个元素,比较轮数为 length-1 次（不需和自己比）
		for (int i = 0; i < arr.length - 1; i++) {
			// 每次置0
			ischanged = 0;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// 交换
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					// 状态位
					ischanged = 1;
				}
			}
			if (ischanged == 0) {
				return arr;
			}
		}
		return arr;
	}

	/**
	 * 选择排序，先找出最小的元素放到新数组中， 然后更新原数组，即去掉原数组中的这个最小元素。循环 时间复杂度 O(n^2)
	 * 
	 * @param arr
	 * @return
	 */
	public static List<Integer> selectionSort(List<Integer> arr) {
		List<Integer> list = new ArrayList<Integer>(arr.size());

		int size = arr.size();// ***将原始大小保存，使序列大小保持不变***
		for (int i = 0; i < size; i++) {
			int smallest_index = findSmallest(arr);
			list.add(arr.get(smallest_index));
			arr.remove(smallest_index);
		}
		return list;
	}

	/**
	 * 输入数组和某一元素的角标，完成去掉该元素的功能，返回去掉该元素后的数组
	 * 
	 * @param arr
	 * @return
	 */
	public static int findSmallest(List<Integer> arr) {
		int smallest = arr.get(0);
		int index = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) < smallest) {
				smallest = arr.get(i);
				index = i;
			}
		}
		return index;
	}

	/**
	 * 快速排序，在平均情况下，时间复杂度为 O(n*logn)，在最糟糕情况下，复杂度为O(n^2),因其栈长不定， 栈长最短为O(log
	 * n),最长为O(n), 每一层元素固定为O(n), 大O表示法中的常量有时候事关重大，这就是快速排序比合并排序快的原因所在。
	 * 
	 * @param arr
	 * @return
	 */
	public static List<Integer> quickSort(List<Integer> arr) {
		List<Integer> newarr = new ArrayList<Integer>(arr.size());
		if (arr.size() < 2)// 基线条件
			return arr;
		else {
			int pivot = arr.get(0);// 基准值arr.size()/2

			List<Integer> less_arr = new ArrayList<Integer>();
			List<Integer> greater_arr = new ArrayList<Integer>();
			// 小的放左边，大的放右边
			for (int i = 0; i < arr.size(); i++) {

				if (arr.get(i) < pivot) {
					less_arr.add(arr.get(i));

				} else if (arr.get(i) > pivot) {
					greater_arr.add(arr.get(i));
				}
			}
			// 重新组合起来
			newarr.addAll(quickSort(less_arr));
			newarr.add(pivot);
			newarr.addAll(quickSort(greater_arr));
			return newarr;
		}
	}

	/**
	 * 直接插入排序的基本操作就是将一个数据插入到已经排好序的有序数据中，从而得到一个新的、个数加一的有序数据，
	 * 算法适用于少量数据的排序，时间复杂度为O(n^2)。是稳定的排序方法。
	 * 
	 * @param arrays
	 */
	public static int[] insertSort(int[] arrays) {

		// 临时变量
		int temp;

		// 外层循环控制需要排序的趟数(从1开始因为将第0位看成了有序数据)
		for (int i = 1; i < arrays.length; i++) {
			temp = arrays[i];
			// 如果前一位(已排序的数据)比当前数据要大，那么就进入循环比较[参考第二趟排序]
			int j = i - 1;

			while (j >= 0 && arrays[j] > temp) {
				// 往后退一个位置，让当前数据与之前前位进行比较
				arrays[j + 1] = arrays[j];

				// 不断往前，直到退出循环
				j--;
			}
			arrays[j + 1] = temp;
			// 退出了循环说明找到了合适的位置了，将当前数据插入合适的位置中
		}
		System.out.println(":" + arrays);
		return arrays;
	}

	/**
	 * 希尔排序(Shell's Sort)是插入排序的一种又称“缩小增量排序”（Diminishing Increment Sort），
	 * 是直接插入排序算法的一种更高效的改进版本。希尔排序是非稳定排序算法。该方法因D.L.Shell于1959年提出而得名。
	 * 
	 * @param arrays
	 */
	public static int[] shellSort(int[] arrays) {
		// 增量每次都/2
		for (int step = arrays.length / 2; step > 0; step /= 2) {

			// 从增量那组开始进行插入排序，直至完毕
			/**********************每组都进行插入排序****************/
			for (int i = step; i < arrays.length; i++) {

				int j = i;
				int temp = arrays[j];

				// j - step 就是代表与它同组隔壁的元素
				while (j - step >= 0 && arrays[j - step] > temp) {
					arrays[j] = arrays[j - step];
					j = j - step;
				}
				arrays[j] = temp;
			}
			/*******************************************/
		}
		return arrays;
	}
	/**
     * 归并排序（MERGE-SORT）是建立在归并操作上的一种有效的排序算法,
     * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
     * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
     * 若将两个有序表合并成一个有序表，称为二路归并。
     *
     * @param arrays
     * @param L      指向数组第一个元素
     * @param R      指向数组最后一个元素
     */
	public static int[] mergeSort(int[] arrays, int L, int R) {

        //如果只有一个元素，那就不用排序了
        if (L == R) {//基线条件
            return arrays;
        } else {

            //取中间的数，进行拆分
            int M = (L + R) / 2;

            //左边的数不断进行拆分
            mergeSort(arrays, L, M);

            //右边的数不断进行拆分
            mergeSort(arrays, M + 1, R);

            //合并
            merge(arrays, L, M + 1, R);

        }
        return arrays;
    }
    /**
     * 合并数组
     *
     * @param arrays
     * @param L      指向数组第一个元素
     * @param M      指向数组分隔的元素
     * @param R      指向数组最后的元素
     */
    public static void merge(int[] arrays, int L, int M, int R) {

        //左边的数组的大小
        int[] leftArray = new int[M - L];

        //右边的数组大小
        int[] rightArray = new int[R - M + 1];

        //往这两个数组填充数据
        for (int i = L; i < M; i++) {
            leftArray[i - L] = arrays[i];
        }
        for (int i = M; i <= R; i++) {
            rightArray[i - M] = arrays[i];
        }


        int i = 0, j = 0;
        // arrays数组的第一个元素
        int  k = L;


        //比较这两个数组的值，哪个小，就往数组上放
        while (i < leftArray.length && j < rightArray.length) {

            //谁比较小，谁将元素放入大数组中,移动指针，继续比较下一个
            if (leftArray[i] < rightArray[j]) {
                arrays[k] = leftArray[i];

                i++;
                k++;
            } else {
                arrays[k] = rightArray[j];
                j++;
                k++;
            }
        }

        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < leftArray.length) {
            arrays[k] = leftArray[i];

            i++;
            k++;
        }
        //如果右边的数组还没比较完，左边的数都已经完了，那么将右边的数抄到大数组中(剩下的都是大数字)
        while (j < rightArray.length) {
            arrays[k] = rightArray[j];

            k++;
            j++;
        }
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/9/19 14:49
     *  @Description: 桶排序 简易版
     */

    public static void bucketSort(int[] arr, int max){
		int[] result = new int[arr.length];
    	int[] bucket = new int[max+1];//最大值加1 因为数组下标是从0 开始的
		//统计每个元素出现的个数
		for (int i = 0; i <arr.length ; i++) {
			bucket[arr[i]]++;
		}
		//打印
		int j=0;
		for (int i = 0; i < max+1; i++) {
			while(bucket[i]>0){
				result[j++]=i;
				bucket[i]--;
			}
		}

		System.out.println(Arrays.toString(result));

	}
    /**
     *  @author: xiongcong
     *  @Date: 2019/9/19 15:20
     *  @Description:  堆排序   不稳定的排序算法  堆排序的平均时间复杂度为 Ο(nlogn)。
	 *  完全二叉树有个特性：左边子节点位置 = 当前父节点的两倍 + 1，右边子节点位置 = 当前父节点的两倍 + 2
	 *
	 *  堆是具有以下性质的完全二叉树：
	 *  每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；
	 *  或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆。
	 *  大顶堆：每个节点的值都大于或等于其子节点的值，在堆排序算法中用于升序排列；
	 *  小顶堆：每个节点的值都小于或等于其子节点的值，在堆排序算法中用于降序排列；
	 *
	 *
     */
    public static void heapSort(int[] arr,int size){

    	int[] array = Arrays.copyOf(arr, size);
    	//将这个数组改造成大顶堆  大顶堆则为升序排列
		maxHeapify(array,size);

		for (int i = 0; i <size ; i++) {
			//交换数组中的头尾元素
			swap(array,0,size-1-i);
			//对剩余元素再次建堆i
			heapify(array,0,size-1-i);
		}
		System.out.println(Arrays.toString(array));

	}

	/**
	 *  @Description:  建堆，这个建堆，适用于在交换数组中的头尾元素之后，对 堆的调整
	 *  而将一个数组完全改造成一个堆 则是maxHeapify(int[] arr,int size) 函数
	 */
	public static void heapify(int[] array , int currentRootNode , int size){
    	//计算当前根节点的左右节点位置，利用完全二叉树的特性
    	int left = currentRootNode * 2 + 1;
		int right = currentRootNode * 2 + 2;

		//记录下值最大的节点的位置，暂时为 currentRootNode
		int maxPosition = currentRootNode;
		//当前位置不能大于size
		if(currentRootNode<size){

			//判断 左节点值是否大于最大值
			if(left<size){
				//判断
				if(array[maxPosition]<array[left]){
					maxPosition = left;
				}
			}
			//判断 右节点值是否大于最大值
			if(right<size){
				//判断
				if(array[maxPosition]<array[right]){
					maxPosition = right;
				}
			}
			//如果 根节点有变化 就交换 使根节点的值为最大
			if(maxPosition != currentRootNode){
				swap(array,maxPosition,currentRootNode);
				//然后对这个以 maxPosition为根节点的子树建堆
				heapify(array,maxPosition,size);
			}
		}
	}

	/**
	 * 将一个数组改造成堆  从数组最后一个元素开始
	 * @param arr
	 * @param size
	 */
	public static void maxHeapify(int[] arr, int size){
		//倒着遍历这个数组
		for (int i = size-1; i >=0; i--) {
			heapify(arr,i,size);
		}

	}
	/**
	* @Description 交换数组中的下标为 i 和 j 两个元素
	*/
	public static void swap(int[] arr,int i, int j){
    	int temp ;
    	temp = arr[i];
    	arr[i]=arr[j];
    	arr[j]=temp;
	}

	/**
	 * 主函数   
	 * 稳定是指序列中   相同元素的前后位置 在排序前后是不变的 
	 * 保证排序前2个相等的数其在序列的前后位置顺序和排序后它们两个的前后位置顺序相同。在简单形式化一下，如果Ai = Aj，Ai原来在位置前，排序后Ai还是要在Aj位置前。
	 * 1冒泡排序、基数排序、直接插入排序、折半插入排序、归并排序、桶排序、二叉树排序等都是稳定的排序算法
	 * 2直接选择排序，希尔排序，堆排序，快速排序等都是不稳定的排序算法
	 * @param args
	 */
    public static void main(String[] args) {
        int[] arrays = {9, 2, 1, 3, 5, 9, 2, 1, 8};
		heapSort(arrays,arrays.length);
        //System.out.println(":" + Arrays.toString(mergeSort(arrays, 0, arrays.length - 1)));
    }



	
}
