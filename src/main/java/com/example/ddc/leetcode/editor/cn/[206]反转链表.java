package com.example.ddc.leetcode.editor.cn;//反转一个单链表。
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1447 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution206 {
    public static ListNode reverseList(ListNode head) {
        //首先需要明确的是,获取了head就获取到了整个链表
        //反转链表要做的就是,顺序遍历的过程中,对每一个节点的next指针进行操作,让它由后面的指向前面的
        //所以我们需要记录前一个指针是什么,来完成指向
//        ListNode present = head;
//        ListNode prev = null;
//        while (present!=null){
//            //记录顺序遍历的下一个节点
//            ListNode listNext = present.next;
//            //反转操作
//            present.next = prev;
//            //移动两个指针来保证遍历进行
//            prev = present;
//            present = listNext;
//            //此过程只是需要present和prev即完成了功能 ,记录listNext是为了完成遍历
//        }
//        return prev;
        /*****************************************************************/
        //递归
        //递归就是多次调用方法,既然这个reverseList给的是头指针,我们递归的话就要一直找到尾指针,这样就保证所有的都操作完成了
        //如果是尾指针的话那就返回
        if (head ==null || head.next ==null) {
            return head;
        }
        //这个头指针是最后需要返回的结果
        ListNode newHead = reverseList(head.next);
        //那么哪一个节点是我们需要当前进行操作的present?当然是head,
        //哪个是present的下一个?不是newHead,因为newHead要进行返回,所以这个不能使用,要用present.next
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        //创建一个单向链表
        ArrayList<ListNode> linked = new ArrayList<>();
        for (int i=0;i<5;i++){
            ListNode listNode = new ListNode(i + 1);
            linked.add(listNode);
            if (i!=0) {
                linked.get(i-1).next = listNode;
            }
        }
        ListNode listNode = reverseList(linked.get(0));
        System.out.println(1);
    }
}

