package com.algorithmanddata.class1;

/**
 * @className: Code2_SumOfFactorial
 * @description: 阶乘和计算
 * @author: sw
 * @date: 2021/9/3
 **/
public class Code2_SumOfFactorial {


    public static long f1(int n ){
        long ans=0l;
        for(int i=1;i<=n;i++){
            ans+=factorial(i);
        }
        return ans;
    }
    public static long factorial(int n ){
        long ans=1;
        for (int i = 1; i <=n ; i++) {
            ans*=i;
        }
        return ans;
    }

    public static long f2(int N) {
        long ans = 0;
        long cur = 1;
        for (int i = 1; i <= N; i++) {
            cur = cur * i;
            ans += cur;
        }
        return ans;
    }


    public static long f3(int N) {
        long cur = 1;
        for (int i = 1; i <= N; i++) {
            cur = cur * i;
        }
        return cur;
    }


    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            System.out.println(f1(i));
            System.out.println(f2(i));
            System.out.println(f3(i));
            System.out.println("********");


        }
    }
}
