package com.customer.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class StreamApi {

    private enum Status{
        OPEN,CLOSED
    }
    private static  class TestTask{
        private final Status status;
        private final Integer points;

        private TestTask(Status status,Integer points) {
            this.status=status;
            this.points=points;
        }

        public Status getStatus() {
            return status;
        }

        public Integer getPoints() {
            return points;
        }

        @Override
        public String toString() {
            return String.format("[%s,%d]",status,points);
        }
    }

    final List<TestTask> tasks=Arrays.asList(
            new TestTask(Status.OPEN,10),
            new TestTask(Status.CLOSED,2),
            new TestTask(Status.OPEN,2)
    ) ;
    //状态数据总数
    long totalOpentasks=tasks.stream().filter(task->task.getStatus()== Status.OPEN)
            .mapToLong(TestTask::getPoints).sum();
    //对应对象实例总数
    long skip=tasks.stream().filter(task->task.getStatus()== Status.OPEN)
            .mapToLong(TestTask::getPoints).count();

   //还有其它方法

    List<Integer> numbers=Arrays.asList(1,2,3,2,3,4,6,3);

    Long numberCount=numbers.stream().filter(i-> i%2==0).count();

    /**
     * 运行task的得分总和
     */
    public void operationPoints() {
        int taskPoints = tasks.stream().parallel().map(task -> task.getPoints()).reduce(0, Integer::sum);
        System.out.println("task total points:"+taskPoints);
    }

    /**
     * 去掉重复的数据
     */
    public void filterNumbers(){
        List<String> strs=Arrays.asList("a","c","a","k");
        strs.stream().map(String::toLowerCase).distinct().forEach(System.out::println);
    }

    /**
     * 的到相关数据
     */
    public void getMaxOrMinNumber(){
        int maxnumber=numbers.stream().mapToInt(Integer::intValue).max().getAsInt();
        System.out.println(maxnumber);
        int minnumber=numbers.stream().mapToInt(Integer::intValue).min().getAsInt();
        System.out.println("最小值××××"+minnumber);
    }




}


