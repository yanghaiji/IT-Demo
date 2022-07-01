package com.javayh.algorithm;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2022-06-30
 */
public class LinkReversal {
    public static void main(String[] args) {
        Node node3 = new Node(3);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);

        Node reversal = reversal(node1);
        System.out.println(reversal);

    }

    public static Node reversal(Node root){
        Node pre = null;
        Node next = null;
        while (root != null){
            next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }
        return pre;
    }


    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
