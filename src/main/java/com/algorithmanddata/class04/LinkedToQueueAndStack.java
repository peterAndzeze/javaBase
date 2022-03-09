package com.algorithmanddata.class04;

/**
 * @className: LinkedToQueueAndStack
 * @description: 链表转队列或栈
 * 队列 ：先进先出
 * 栈：先进后出
 * @author: sw
 * @date: 2021/10/11
 **/
public class LinkedToQueueAndStack {

    /**
     * 链表结构
     * @param <V>
     */
    public static class Node<V>{
        private V value;
        private Node<V> next;

        public Node(V value) {
            this.value = value;
            next = null;
        }
    }

    /**
     * 自定义队列
     * 满足先进先出   java 各类队列实现
     */
    public static class MyQueue<V>{
        //头部
        private Node<V> head;
        //尾部
        private Node<V> tail;
        private int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }
        public boolean isEmpty(){
           return size==0;
        }

        public int size(){
            return size;
        }

        /**
         * 放入数据
         * @param value 值
         */
        public void offer(V value){
            Node<V> cur=new Node<>(value);
            if(head==null){
                head=cur;
                tail=cur;
            }else {
                tail.next=cur;
                //末级节点向后移动
                tail=cur;
            }
            size++;
        }

        /**
         * 取出
         * @return 结果
         */
        public V poll(){
            V ans=null;
            if(head!=null){
                ans=head.value;
                head=head.next;
                size--;
            }
            //末级置为空
            if(head==null){
                tail=null;
            }
            return ans;
        }

    }



}
