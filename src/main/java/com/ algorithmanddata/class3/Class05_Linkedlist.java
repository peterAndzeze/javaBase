package com.algorithmanddata.class3;

/**
 * @className: Class05_Linkedlist
 * @description: 链表操作
 * @author: sw
 * @date: 2021/9/14
 **/
public class Class05_Linkedlist {


    static class Node {
        private int value;
        private Node next;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 输出
     *
     * @param node
     */
    public static void printNode(Node node) {
        while (null != node) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }


    /**
     * 链表反
     *
     * @param head
     * @return
     */
    public static Node revertLinkedList(Node head) {

        Node next = null;
        //节点的记录
        Node pre = null;
        while (null != head) {
            //1 记录head的next;
            next = head.next;
            //2 将head 指向pre 既是反向指向的开始
            head.next = pre;
            //3、占据head
            pre = head;
            //3、将原来的head值变更为next值
            head = next;
        }
        return pre;
    }

    /**
     * 单向链表测试
     */
    public static void singleLinked(){
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        printNode(node);
        Node node1 = revertLinkedList(node);
        printNode(node1);
    }

    public static void main(String[] args) {

        //singleLinked();

        DoubleNode doubleNode=createDoubleLink(5,6);

    }

    /**
     * 双向链表 改变指向
     * @param head 头部
     * @return 结果
     */
    public static DoubleNode reversDoubleLink(DoubleNode head){
        DoubleNode next=null;
        DoubleNode pre=null;
        while (head!=null){
            next=head.next;
            head.next=pre;
            head.last=next;
            pre=head;
            head=next;
        }
        return pre;
    }

    static  class DoubleNode{
        private int value;
        /**
         * 正向指向
         */
        private DoubleNode next;
        /**
         * 反向指向
         */
        private DoubleNode last;

        public DoubleNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    /**
     * 双向链表测试
     */
    public static DoubleNode createDoubleLink(int length,int value){
       int size=(int)(Math.random()*(length+1));
       if(size==0){
           return null;
       }

       size--;
       DoubleNode head=new DoubleNode((int)(Math.random()*(value+1)));
       DoubleNode pre=head;
       while (size!=0){
           DoubleNode cur=new DoubleNode((int)(Math.random()*(value+1)));
           pre.next=cur;
           cur.last=pre;
           pre=cur;
           size--;
       }
       return head;



    }


}
