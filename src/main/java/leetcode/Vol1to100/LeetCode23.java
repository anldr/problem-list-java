package leetcode.Vol1to100;

import commonutils.leetcode.ListNode;

public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode moveNode = dummyNode;
        while (!isAllListNull(lists)) {
            moveNode.next = findMinValNode(lists);
            moveNode = moveNode.next;
        }

        return dummyNode.next;
    }

    public Boolean isAllListNull(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                return false;
            }
        }
        return true;
    }

    public ListNode findMinValNode(ListNode[] lists) {
        int pos = -1;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (minVal > lists[i].val) {
                pos = i;
                minVal = lists[i].val;
            }
        }

        ListNode result = lists[pos];
        lists[pos] = lists[pos].next;

        return result;
    }
}
