package com.javayh.leetcode;

/**
 * <p>
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-11-25
 */
public class 合并两个有序链表 {

    public static class ListNode {
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    public static void main(String[] args) {
        //[1,3,4]
        //[1,2,4]
        ListNode listNode1 = new ListNode(4,null);
        ListNode listNode2 = new ListNode(3,listNode1);
        ListNode listNode3 = new ListNode(1,listNode2);

        ListNode listNode4 = new ListNode(4,null);
        ListNode listNode5 = new ListNode(2,listNode4);
        ListNode listNode6 = new ListNode(1,listNode5);

        System.out.println(mergeTwoLists(listNode3,listNode6));
    }
}
