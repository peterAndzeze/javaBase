package datastructurealgorithm;

/**
 * @className: Code01_Sort
 * @description: 简单排序
 * @author: sw
 * @date: 2021/9/1
 **/
public class Code01_Sort {

    public static void main(String[] args) {
        int [] array={3,12,3,4,5,1,5,2,5,6,8};
        printArray(array);
        //selectSort(array);
        //bubbleSort(array);
        //inertSort1(array);
        inertSort2(array);
        printArray(array);
    }

    /**
     * 选择排序
     * @param array
     */
    public static void selectSort(int[] array){
        if(null==array || array.length<2){
            return;
        }
        /**
         * 执行顺序
         * 0~n-1
         * 1~n-1
         *
         */
        int length=array.length;
        for (int i=0;i<length;i++){
            int minValueIndex=i;
            for(int j=i+1;j<length;j++){
                minValueIndex=array[j]>array[minValueIndex]?j:minValueIndex;
            }
            swapData(array,i,minValueIndex);
        }
    }

    /**
     * 冒泡
     * @param array
     */
    public static void bubbleSort(int [] array){
        if(null==array || array.length<2){
            return;
        }
        int length=array.length;
        for (int i = length-1; i >=0; i--) {
            for(int j=1;j<=i;j++){
                if(array[j-1]>array[j]) {
                    swapData(array, j - 1, j);
                }

            }
        }
    }

    /**
     * 插入排序
     * @param array
     */
    public static void inertSort1(int [] array){
        int length = array.length;
        for (int i=0;i<length;i++){
            int index=i;
            while ((index-1)>=0 && array[index-1]>array[index]){
                swapData(array,index-1,index);
                index--;
            }
        }
    }


    public static void inertSort2(int [] array){
        int length = array.length;
        for (int i=0;i<length;i++){
            for(int pre=i-1;pre>=0 && array[pre]>array[pre+1];pre-- ){
                swapData(array,pre,pre+1);
            }
        }
    }


    /**
     * 交换数据
     * @param array
     * @param i
     * @param temp
     */
    private static void swapData(int[] array, int i, int temp) {
        int a=array[i];
        array[i]=array[temp];
        array[temp]=a;
    }


    /**
     * 打印
     * @param array
     */
    public static void printArray(int [] array){
        for(int i:array){
            System.out.print(i+" ");
        }
        System.out.println();
    }



}
