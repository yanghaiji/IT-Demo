package com.javayh.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-11-21
 */
public class 链表反转 {
    public static class ListNode {
        private Integer data;
        private ListNode next;

        public ListNode(Integer data, ListNode next) {
            this.data = data;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(3,null);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        //ListNode listNode = reversal_re(listNode1);
        ListNode listNode = reversal(listNode1);
        System.out.println(listNode);
    }

    /**
     * 1 > 2 > 3 > 4 > 5
     *
     * @param listNode
     * @return
     */
    public static ListNode reversal(ListNode listNode) {
        ListNode prev = null, next = null;
        ListNode current = listNode;
        while (current != null) {
            next = current.next;    //保存下一个及其所有
            current.next = prev;    //当前连接上一个
            prev = current;         //将上一个后移
            current = next;         //将当前后移
        }
        return prev;
    }

    /**
     * 1 > 2 > 3 > 4 > 5
     *
     * @param listNode
     * @return
     */
    public static ListNode reversal_re(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode new_node = reversal_re(listNode.next);
        listNode.next.next = listNode;
        listNode.next = null;
        return new_node;
    }
}
