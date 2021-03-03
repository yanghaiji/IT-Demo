package com.javayh.leetcode.divideconquer;

/**
 * <p>
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-01
 */
public class HeListNode {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //是否为null判断
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //新建头结点
        ListNode head = null;
        //如果l1.val <= l2.val，那么头结点的值为l1.head的值，然后开始递归
        if(l1.val <= l2.val){
            head = new ListNode(l1.val);
            head.next = mergeTwoLists(l1.next, l2);
        }
        //否则，头结点的值为l2.head的值，然后开始递归
        else{
            head = new ListNode(l2.val);
            head.next = mergeTwoLists(l1, l2.next);
        }
        //返回该链表
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
