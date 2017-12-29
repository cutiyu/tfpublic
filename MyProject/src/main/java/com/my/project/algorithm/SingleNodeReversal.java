package com.my.project.algorithm;

/**
 * Created by tangfeng on 2017/9/19.
 * 单向链表反转算法
 */
public class SingleNodeReversal {


    public static void main(String[] args) {
        SingleNodeReversal snr = new SingleNodeReversal();
        Node node = snr.createNode();
        System.out.println(node.toString());

        //非递归实现
        Node reNode = snr.reversalNode(node);
        System.out.println(reNode);

        //递归实现
        Node node2 = snr.createNode();
        Node reNode2 = snr.reversalNode(node2);
        System.out.println(reNode2);


    }


    /**
     * 创建一个单向链表
     * @return
     */
    public  Node createNode(){
        Node head = new Node(0);
        Node node1 = new Node(1,new Node());
        Node node2 = new Node(2,new Node());
        Node node3 = new Node(3,new Node());
        Node node4 = new Node(4,null);

        head.setNextNode(node1);
        node1.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node4);

        return head;
    }

    /**
     * 非递归 单向链表反转
     * @param head
     * @return
     *
     *结点组成：  数据区，和下一个节点指向head(0  nextNode1 )
     *
     * head(0  nextNode1 )     nextNode1(1 nextNode2)    nextNode2(2 nextNode3)
     * nextNode3(3 nextNode4)   nextNode4(4 null)
     */
    public Node reversalNode(Node head){
        Node pre = null;
        while (head!=null){
            Node nextTemp = head.nextNode;
            head.nextNode = pre;
            pre = head;
            head = nextTemp;

        }
        return pre;
    }


    /**
     * 递归实现反转
     * @param head
     * @return
     */
    public Node reverseList(Node head) {
        if(head==null||head.nextNode ==null)
            return head;
        Node prev = reverseList(head.nextNode);
        head.nextNode.nextNode = head;
        head.nextNode = null;
        return prev;
    }


    class Node{
        private Object data;//结点的数据区
        private Node nextNode; //当前结点指向下一个结点

        public Node() {
            super();
        }

        public Node(Object data) {
            this.data = data;
        }

        public Node(Object data, Node nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", nextNode=" + nextNode +
                    '}';
        }
    }

}
