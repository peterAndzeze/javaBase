package datastructurealgorithm;

/**
 * @className: Code06_PrintB
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/8/31
 **/
public class Code06_PrintB {


    private static void print(int num){
        for(int i=31 ;i>=0;i--){
            System.out.print((num&(1<<i))==0?"0":"1");
        }
    }



    public static void main(String[] args) {
        //整型底层有32位信息组成 以二进制为基础运算
        int num=8328328;
        /**
         *
         * 整数取值范围 -2(31次方)～2(31次方-1)
         * 负数的最小值的绝对值比正数最大值大1 原因是0归属在了非负区域，占用了一个数
         * java里的整数是无符号的，最高位留给了符号（正/负 标识） 0 代表非负数，1是负数，当表示负数的时候，
         * 除最高位后的位数取反 如：1(最高位)1111--》1(最高位)0000），为什么要取反，底层都是用二进制的
         * 位运算进行与运算
         * 在二进制里，每位的值可以用2的(n-1)次方表示，值=：每位是1的 2的(n-1)次方的数加在一起
         * 右移时使用负号位补（>>带负号右移）(>>> 不带负号右移动)
         * 一个数 的相反数就是对一个数取反+1 既是：n=（～n+1)
         * 为什么要取反+1 底层各类运算走一套逻辑（+ - * /），最小的负数取反是:他自己，1000000000***--取反》011111111111***+1 ==10000000000*** 最大值
         */

        //print(1);
        print(2);
        System.out.println("*****");
        print(1+2);
    }
}
