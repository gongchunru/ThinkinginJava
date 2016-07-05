package com.java.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gongchunru
 * @Package com.java.algorithm
 * @date 16/7/1 14:37
 */
public class Day01 {

    public static int[] twoSum(int[] nums,int target){
        int[] result = new int[2];
        int start = nums[0];
        int end = nums[nums.length-1];

        for (int i=0;i<nums.length;i++){
            start = nums[i];
            for (int j=nums.length-1;j>i;j--){
                end = nums[j];
                if ((start+end)==target){
                    result[0] = i;
                    result[1] = j;
                   return result;
                }
            }
        }
        return result;
    }

    // 遍历所有方法,时间复杂度O(n2)
    public static int[] twoSum2(int[] nums ,int target){
        int numsLength = nums.length;
        int start=0 ,end =0;
        while (start<numsLength-1){
            end = start+1;//这里只是为了保证
            int stepLength = numsLength - end;
            for (int i=0;i<stepLength;i++){
                if ((nums[start]+nums[end])==target){
                    return new int[]{start,end};
                }else {
                    end++;
                }
            }
            start++;
        }
        return null;
    }

    /**
     * 利用hashmap , 时间复杂度O(n)
     * @param
     */

    public  static int[] twoSum3(int[] nums,int target){

        int numsLength = nums.length;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i=0;i<numsLength;i++){
            map.put(nums[i],i);
        }

        for (int i=0;i<numsLength;i++){
            int search = target - nums[i];
            if (map.containsKey(search) && map.get(search)!=i){//查询匹配的值是否存在,并且匹配的值不能是他自己
                return new int[]{i,map.get(search)};
            }
        }
        return null;
    }

    /**
     * 优化了hashmap
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum4(int[] nums,int target){
        int numsLength = nums.length;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i=0;i<numsLength;i++){
            int search = target-nums[i];
            if (map.containsKey(search)&&map.get(search)!=i){
                return new int[]{i,map.get(search)};
            }
            map.put(nums[i],i);
        }
        return null;
    }



    public static void main(String[] args) {
        int[] a = {2,5,8,7,12};
        int b = 9;
        int[] re = twoSum(a,b);
        System.out.println(Arrays.toString(re));
    }
}
