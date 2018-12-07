

/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class Demo02 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode nextHead = new ListNode(0);
        ListNode p = l1, q = l2, nextNode = nextHead;
        int carry = 0;
        while (p != null || q != null) {
            int pVal = (p !=null) ? p.val : 0;
            int qVal = (q !=null) ? q.val : 0;
            int sum = pVal + qVal + carry;
            carry = sum / 10;
            nextNode.next = new ListNode(sum % 10);
            nextNode = nextNode.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            nextNode.next = new ListNode(carry);
        }

        return nextHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers(l1, l2);
        System.out.println(res.val);
        System.out.println(res.next.val);
        System.out.println(res.next.next.val);
    }
}
