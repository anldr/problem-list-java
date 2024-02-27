package leetcode.Vol1to100;

import commonutils.leetcode.ListNode;

import java.util.PriorityQueue;

public class LeetCode23_3 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        }

        if (l == r) {
            return lists[l];
        }

        int mid = (l + r) >> 1;
        return mergeList(mergeKLists(lists, l, mid), mergeKLists(lists, mid + 1, r));
    }

    public ListNode mergeList(ListNode link1, ListNode link2) {
        if (link1 == null || link2 == null) {
            return link1 == null ? link2 : link1;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        while (link1 != null && link2 != null) {
            if (link1.val <= link2.val) {
                curNode.next = link1;
                curNode = curNode.next;
                link1 = link1.next;
            } else {
                curNode.next = link2;
                curNode = curNode.next;
                link2 = link2.next;
            }
        }
        curNode.next = link1 != null ? link1 : link2;

        return dummyNode.next;
    }
}
