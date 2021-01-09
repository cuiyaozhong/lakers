package com.microservice.cyz.util;

import java.util.Arrays;

/**
 * @author 崔耀中
 * @since 2020-12-24
 */
public class SoutUtil {

    /**
     * @Description 冒泡排序
     * @Param [array]
     */
    public static void bubbleSort(int array[]){
        for (int i = 0;i<array.length-1 ;i++){
            for (int j=i;j<array.length-i-1; j++){
                if (array[j]>array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * @Description 冒泡排序优化
     * @Param [array]
     */
    public static void optimizeBubbleSortV1(int array[]){
        for (int i = 0;i<array.length-1 ;i++){
            //有序标记，每一轮的初始值都是true
            Boolean isSorted = true;
            for (int j=i;j<array.length-i-1; j++){
                if (array[j]>array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;

                    //有元素进行交换，所以不是有序的
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
        }
    }

    /**
     * @Description 冒泡排序再优化
     * @Param [args]
     */
    public static void optimizeBubbleSortV2(int array[]){

        //记录最后一次交换的位置
        int lastExchangeIndex = 0;

        //无序数列的边界，每次比较到这里就可以
        int sortBorder = array.length - 1;
        for (int i = 0;i<array.length - 1 ;i++){
            //有序标记，每一轮的初始值都是true
            Boolean isSorted = true;
            for (int j=i;j<sortBorder; j++){
                if (array[j]>array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;

                    //有元素进行交换，所以不是有序的
                    isSorted = false;

                    // 更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted){
                break;
            }
        }

    }

    /**
     * @Description 鸡尾酒排序（双向冒泡排序）
     * @Param [array]
     */
    public static void cocktailSort(int array[]){
        for (int i=0;i<array.length/2;i++){

            //有序标记，每一轮的初始值都是true
            Boolean isSorted = true;

            //奇数轮，从左向右比较和交换
            for (int j = i;j<array.length-i-1;j++){
                if (array[j]>array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;

                    //有元素进行交换，所以不是有序的
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }

            //偶数轮初始值都是true
            isSorted = true;

            //偶数轮，从右向左比较和交换
            for (int j =array.length-i-1;j>i;j--){
                if (array[j]<array[j-1]){
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;

                    //有元素进行交换，所以不是有序的
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{5,8,6,3,9,2,1,7};
//        bubbleSort(array);
//        optimizeBubbleSortV1(array);
//        optimizeBubbleSortV2(array);
        cocktailSort(array);
        System.out.println(Arrays.toString(array));
    }
}
