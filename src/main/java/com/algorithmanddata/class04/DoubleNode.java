package com.algorithmanddata.class04;

import java.util.LinkedList;

/**
 * @className: DoubleNode
 * @description: 双向链表
 * @author: sw
 * @date: 2021/10/11
 **/
public class DoubleNode {

    private int value;
    private DoubleNode last;
    private DoubleNode next;

    public DoubleNode(int value) {
        this.value = value;
    }

    public static DoubleNode generalDoubleNode(int length,int value){
        int size=(int)(Math.random()*(length+1));
        if(size==0){
            generalDoubleNode(length,value);
        }
        size--;
        DoubleNode head = new DoubleNode((int) (Math.random() * (value + 1)));
        DoubleNode pre = head;
        while (size != 0) {
            DoubleNode cur = new DoubleNode((int) (Math.random() * (value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }

    public static void main(String[] args) {
        int length=10;
        int value=5;
        DoubleNode doubleNode = generalDoubleNode(length, value);
        LinkedList<Integer> linkedList= convertList(doubleNode);
        doubleNode=revertDoubleNode(doubleNode);
        if(!checkresult(linkedList,doubleNode)){
            System.out.println("失败");
        }else {
            System.out.println("成功");
        }
    }

    /**
     * 检测转换结果
     * @param linkedList 集合
     * @param head 双向链表
     * @return 结果
     */
    private static boolean checkresult(LinkedList<Integer> linkedList, DoubleNode head) {
        int length=linkedList.size()-1;
        DoubleNode end=null;
        //正向转换验证
        for(int i=length;i>=0;i--){
            if(linkedList.get(i)!=head.value){
                return false;
            }
            end=head;
            head=head.next;
        }
        //反向转换验证
        for(int i=0;i<=length;i++){
            if(linkedList.get(i)!=end.value){
                return false;
            }
            end=end.last;
        }
        return true;



    }

    /**
     * 反转双向链表
     * @param head 双向链表
     * @return 结果
     */
    private static DoubleNode revertDoubleNode(DoubleNode head) {
        DoubleNode next=null;
        DoubleNode pre=null;
        while (head!=null){
            next=head.next;
            head.last=next;
            head.next=pre;
            pre=head;
            head=next;

        }
        return pre;
    }

    /**
     * 转为数组
     * @param doubleNode 双向链表
     * @return 结果
     */
    private static LinkedList<Integer> convertList(DoubleNode doubleNode) {
        LinkedList<Integer> linkedList=new LinkedList<>();
        DoubleNode pre=doubleNode;
        while (pre!=null){
            linkedList.add(pre.value);
            pre=pre.next;
        }
        return linkedList;
    }

}
