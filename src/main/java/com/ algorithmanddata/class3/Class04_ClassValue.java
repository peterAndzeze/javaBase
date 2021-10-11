package com.algorithmanddata.class3;

/**
 * @className: Class04_ClassValue
 * @description: 值传递测试
 * @author: sw
 * @date: 2021/9/14
 **/
public class Class04_ClassValue {


    static class NodeTest{
        private String name;

        private NodeTest next;

        public NodeTest getNext() {
            return next;
        }

        public void setNext(NodeTest next) {
            this.next = next;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void resetNode(NodeTest node){
        node.setName("账单");
        System.out.println(node.hashCode());
        node=node.next;
        System.out.println(node.hashCode());
    }
    public static void main(String[] args) {
        NodeTest node=new NodeTest();
        node.next=new NodeTest();
        node.setName("里斯");
        node.next.setName("怕安排");
        System.out.println(node.hashCode());
        resetNode(node);
        System.out.println(node.hashCode());
        System.out.println(node.getName());
    }



}
