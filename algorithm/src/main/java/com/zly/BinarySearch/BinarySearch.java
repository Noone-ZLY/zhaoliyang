package com.zly.BinarySearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/7/14 18:41
 **/
public class BinarySearch {
    public static int res = 0;
    /**
     * @descriptions 实现无重复数字的升序数组的二分查找
     * @author zhaoliyang9
     * @date 2023/7/14 18:42
     * @param [nums, target]
     * @return int
     **/
    public static int search (int[] nums, int target) {
        // write code here
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
//            System.out.println(mid);
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
    /**
     * @descriptions 二维数组中的查找
     * @author zhaoliyang9
     * @date 2023/7/14 19:00
     * @param [target, array]
     * @return boolean
     **/
    public static boolean Find (int target, int[][] array) {
        // write code here
        if(array.length == 0){
            return false;
        }
        int rows = array.length;
        int cols = array[0].length;
        int i = 0;
        int j = cols-1;
        while(i < rows && j >= 0){
            if(array[i][j] == target){
                return true;
            }
            int k = array[i][j] < target ? ++i : --j;
        }
        return false;
    }
    
    /**
     * @descriptions 寻找峰值
     * @author zhaoliyang9
     * @date 2023/7/14 19:51
     * @param [nums]
     * @return int
     **/
    public static int findPeakElement (int[] nums) {
        // write code here
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1]){
                left = mid;
            }else {
                right = mid;
            }
        }
        return right;
    }
    /**
     * @descriptions 寻找逆序对的数量
     * @author zhaoliyang9
     * @date 2023/7/23 14:25
     * @param [nums]
     * @return int
     **/
    public static int InversePairs (int[] nums) {
        // write code here
        int[] temp = new int[nums.length];
        for(int i = 0; i < temp.length; i++){
            temp[i] = nums[i];
        }
        mergeSort(0, nums.length-1, nums, temp);
        return res;
    }
    public static int mergeSort(int left, int right, int[] nums, int[] temp){
        if(left >= right){
            return 0;
        }
        res = (res % 1000000007);
        int mid = left + (right - left) / 2;
        mergeSort(left, mid, nums, temp);
        mergeSort(mid+1, right, nums, temp);
        int i = left, j = mid + 1, k = left;
        while(i <= mid && j <= right){
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
                res += (mid - i + 1);
                res %= 1000000007;
            }
        }
        while(i <= mid){
            temp[k++] = nums[i++];
        }
        while(j <= right){
            temp[k++] = nums[j++];
        }
        for(i = left; i <= right; i++){
            nums[i] = temp[i];
        }
        return res;
    }
    /**
     * @descriptions 旋转数组的最小数字
     * @author zhaoliyang9
     * @date 2023/7/23 16:13
     * @param [nums]
     * @return int
     **/
    public static int minNumberInRotateArray (int[] nums) {
        // write code here
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
            if(nums[mid] > nums[nums.length - 1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
    /**
     * @descriptions 比较版本号
     * @author zhaoliyang9
     * @date 2023/7/23 16:32
     * @param [version1, version2]
     * @return int
     **/
    public static int compare (String version1, String version2) {
        // write code here
        String[] versionOne = version1.split("\\.");
        String[] versionTwo = version2.split("\\.");
        int i = 0, j = 0;
        while(i < versionOne.length && j < versionTwo.length){
            int valOne = Integer.valueOf(versionOne[i]);
            int valTwo = Integer.valueOf(versionTwo[j]);
            if(valOne < valTwo){
                return -1;
            } else if(valOne > valTwo){
                return 1;
            }else {
                ++i;++j;
            }
        }
        if(i != versionOne.length){
            while( i < versionOne.length){
                if(Integer.valueOf(versionOne[i]) == 0){
                    ++i;
                }else{
                    return 1;
                }
            }
            return 0;
        } else if (j != versionTwo.length) {
            while( j < versionTwo.length){
                if(Integer.valueOf(versionTwo[i]) == 0){
                    ++j;
                }else{
                    return -1;
                }
            }
            return 0;
        }
        return 0;
    }
    public static void main(String[] args) {
        String version1 = "1.1";
        String version2 = "2.1";
        int compare = compare(version1, version2);
        System.out.println(compare);
    }
}
