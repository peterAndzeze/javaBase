package com.algorithmanddata.class2;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: Class02_Probability
 * @description: 等概率得到区间数字
 * @author: sw
 * @date: 2021/9/6
 **/
public class Class02_Probability {
    /**
     * 唯一数据结构
     */
    class RandomBox{
        private int min;
        private int max;
        public RandomBox(int min,int max){
            this.min=min;
            this.max=max;
        }
        public int random(){
            return min+(int)(Math.random()*(max-min-1));
        }
    }

    public static void main(String[] args) {
        int [] nums={-2,1,-3,4,-1,2,1,-5,4};
        int startIndex=2;
        int length = nums.length;
        if(length<2){
            return;
        }
        int tempSum=0;
        //key 是下标 value 是值
        Map<Integer,Integer> index=new HashMap<>();
        for(int i=startIndex;i<length;i++){
            if(i+1>=length || i+2>=length){
                return;
            }
            if(nums[i]>nums[i+1]+nums[i]){
                tempSum=nums[i];
                index.put(i,tempSum);
            }

            if(nums[i+1]+nums[i]>nums[i+2]+nums[i+1]){
                tempSum=nums[i+1]+nums[i];
                index.put(i+1,tempSum);
                startIndex=i+1;
            }
        }

        for (Map.Entry<Integer,Integer> entry:index.entrySet()){
            System.out.println("value:"+entry.getValue()+"endInex:"+entry.getKey()+"start:"+startIndex);
        }

    }



    public static void getNum(int startIndex,int length,int [] nums, Map<Integer,Integer> index){

    }
    public  static class Sum{
        private int maxValue;
        private int startIndex;
        private int endIndex;

        public int getMaxValue() {
            return maxValue;
        }

        public Sum(int maxValue, int startIndex, int endIndex) {
            this.maxValue = maxValue;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public void setMaxValue(int maxValue) {
            this.maxValue = maxValue;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public void setEndIndex(int endIndex) {
            this.endIndex = endIndex;
        }
    }
    public  static int sum(int index){
        return  0;
    }
}
