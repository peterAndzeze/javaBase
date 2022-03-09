package com.algorithmanddata.class04;

import java.util.LinkedList;

/**
 * @className: Node
 * @description: 单向链表
 * @author: sw
 * @date: 2021/10/11
 **/
public class Node {
    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 随机生成单向链表
     *
     * @param length 长度
     * @param value  最大值
     * @return
     */
    public static Node generalCreateList(int length, int value) {
        int size = (int) (Math.random() * (length + 1));
        Node head = new Node((int) (Math.random() * (value + 1)));
        size--;
        Node pre = head;
        while (size != 0) {
            Node cur = new Node((int) (Math.random() * (value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;

    }

    /**
     * 倒转
     * @param head
     * @return
     */
    public static Node revertList(Node head){
        Node pre=null;
        Node next=null;
        //next 是一个中间值承接数
        //head 是指针后移
        //pre 是head 的下一节点指向的标识位
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    public static LinkedList<Integer> convertList(Node head){
        LinkedList<Integer> linkedList=new LinkedList<>();
        while (head!=null){
            linkedList.add(head.value);
            head=head.next;
        }
        return linkedList;
    }

    /**
     * 检查倒置结果
     * @return
     */
    private static boolean checkRevertListResult(LinkedList<Integer> linkedList, Node node){
        int length= linkedList.size()- 1;
        Node pre=node;
        for(int i=length;i>0;i--){
            if(linkedList.get(i)!=pre.value){
                System.out.println(pre.value);
                return false;
            }
            pre=pre.next;
        }
        return true;
    }


    public static void main(String[] args) {
        int length = 10;
        int value = 10;
        Node node = generalCreateList(length, value);
        LinkedList<Integer> resultLinked=convertList(node);
        node = revertList(node);

        if(!checkRevertListResult(resultLinked,node)){
            System.out.println("失败");
        }else {
            System.out.println("成功");
        }
    }

}
