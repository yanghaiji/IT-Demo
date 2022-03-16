package com.javayh.leetbook.linked;

/**
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.leetbook.linked → RemoveNthFromEnd
 * @since 2022-02-15
 */
public class RemoveNthFromEnd {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //求链表的长度
    private int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newNode = head;
        // 一定要先减n ，以防止只有一个元素时null
        int len = length(head) - n;
        if (len == 0) {
            return head.next;
        }
        // 找到前一个元素
        int end = len - 1;
        for (int i = 0; i < end; i++) {
            newNode = newNode.next;
        }
        // 进行位移复制
        newNode.next = newNode.next.next;
        return head;
    }
}
