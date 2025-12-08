package 전체문제2025.December.Second;

import org.w3c.dom.Node;

public class LC_AddTwoNumbers_Medium {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();

        l1.val = 2;
        l1.next = new ListNode();
        l1.next.val = 4;
        l1.next.next = new ListNode();
        l1.next.next.val = 3;

        l2.val = 5;
        l2.next = new ListNode();
        l2.next.val = 6;
        l2.next.next = new ListNode();
        l2.next.next.val = 4;

        int fir = 0;
        int gop = 1;
        ListNode listNode = l1;
        while (true) {
            if (listNode == null) break;
            fir += (listNode.val * gop);
            gop *= 10;
            listNode = listNode.next;
        }
        int sec = 0;
        gop = 1;
        listNode = l2;
        while (true) {
            if (listNode == null) break;
            sec += (listNode.val * gop);
            gop *= 10;
            listNode = listNode.next;
        }
        int sum = (fir + sec);
        String str = String.valueOf(sum);
        ListNode answer = new ListNode();
        ListNode cur = answer;
        for(int i=str.length()-1;-1<i;i--){
            cur.next = new ListNode(str.charAt(i) - '0');
            cur = cur.next;
        }

    }
}
