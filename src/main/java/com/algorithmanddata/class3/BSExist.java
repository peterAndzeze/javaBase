package com.algorithmanddata.class3;

/**
 * @className: BSExist
 * @description: 二分查找数是否存在
 * @author: sw
 * @date: 2021/9/8
 **/
public class BSExist {
    /**
     *
     * @param array 有序数组
     * @param num
     * @return
     */
    public static boolean exits(int [] array,int num){
        if(null==array || array.length==0){
            return false;
        }
        int l=0;
        int r=array.length-1;

        while (l<=r){
            int mid=(l+r)/2;
            if(array[mid]==num){
                return true;
            }else if(array[mid]<num){
                l=mid+1;
            }else if(array[mid]>num){
                r=mid-1;
            }
        }
        return false;
    }

    /**
     * 数据验证
     * @param array
     * @param num
     * @return
     */
    public static boolean existTest(int [] array,int num){
        for(int t:array){
            if(t==num){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
      int [] array={1,3,34,37,48};
      boolean flag=exits(array,2);
      System.out.println("flag:"+flag);
    }

}
