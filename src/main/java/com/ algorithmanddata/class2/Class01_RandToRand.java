package com.algorithmanddata.class2;


/**
 * @className: Class01_Num
 * @description: 概率
 * @author: sw
 * @date: 2021/9/4
 **/
public class Class01_RandToRand {
    /**
     * 得到固定范围内整数
     */
    public static int getFixedNum(){
        return (int) (Math.random() * 7) + 1;

    }

    /**
     * 在start-end之间等概率得到0和1
     * 小公式=end-start=n 计算0-n的等概率+start 既是start-end的等概率 所以是以平均数来进行分割的
     * 即2的整数倍 如 5 分成3组 1,2一组，3 一组 4，5一组
     * 小细节n 需要多少个二进制位
     */

    public static  int getProbability(){
        int anser=0;
        do {
            anser=getFixedNum();
        }while (anser==0);
        return (anser<5 && anser>0)?0:1;
    }

    /**
     * 0和1的等概率，等概率得到0-6中的数字
     * @return
     */
    public static int getNumByProbability(){
        int ans=0;
        do {
            ans=(getProbability()<<2)+(getProbability()<<1)+getProbability();
        }while (ans==8);
        return ans+1;
    }


    // 你只能知道，x会以固定概率返回0和1，但是x的内容，你看不到！
    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    // 等概率返回0和1
    public static int y() {
        int ans = 0;
        do {
            ans = x();
        } while (ans == x());
        return ans;
    }




    public static void main(String[] args) {
        int testTimes = 1000;
        int count = 0;
        //等概率0.75
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.75) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("=========");
        int [] arr=new int [9];
        for (int i=0;i<testTimes;i++){
            int num=getNumByProbability();
            if(num==0){
                System.out.println("出现了0");
            }
            //System.out.println(num);
            arr[num]++;

        }
        for (int i=1;i<arr.length ;i++) {
            System.out.println("num:" + i + "出现了:" +(double) arr[i] / testTimes);
        }
    }



}
