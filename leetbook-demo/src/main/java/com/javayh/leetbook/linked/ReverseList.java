package com.javayh.leetbook.linked;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.leetbook.linked → ReverseList
 * @since 2022-02-17
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(3,null);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        //ListNode listNode = reversal_re(listNode1);
        ListNode listNode = reversal(listNode1);
    }

    private static ListNode reversal(ListNode listNode) {
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


    public static ListNode reverseList(ListNode head) {
        //新链表
        ListNode newHead = null;
        while (head != null) {
            //先保存访问的节点的下一个节点，保存起来
            //留着下一步访问的
            ListNode temp = head.next;
            //每次访问的原链表节点都会成为新链表的头结点，
            //其实就是把新链表挂到访问的原链表节点的
            //后面就行了
            head.next = newHead;
            //更新新链表
            newHead = head;
            //重新赋值，继续访问
            head = temp;
        }
        //返回新链表
        return newHead;
    }

    private static ListNode reverse(ListNode head) {
        ListNode newNode = null;
        while (head != null) {
            if (head.next == null) {
                newNode = head;
            }
        }
        return newNode;
    }
}

class ListNode {
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
