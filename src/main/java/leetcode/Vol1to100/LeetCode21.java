package leetcode.Vol1to100;

import common_structure.leetcode.ListNode;

public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode dummyNode = new ListNode();
        ListNode ptr = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                ptr.next = list1;
                ptr = ptr.next;
                list1 = list1.next;
            } else {
                ptr.next = list2;
                ptr = ptr.next;
                list2 = list2.next;
            }
        }
        ptr.next = list1 == null ? list2 : list1;

        return dummyNode.next;
    }
}
