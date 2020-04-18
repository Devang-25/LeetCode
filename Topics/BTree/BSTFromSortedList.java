package Topics.BTree;

import Libs.ListNode;
import Libs.TreeNode;

public class BSTFromSortedList {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        pre.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }

    private ListNode head;

    public TreeNode sortedListToBSTII(ListNode head) {
        int len = findLen(head);
        this.head = head;
        return helper(0, len-1);
    }

    private TreeNode helper(int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + (r-l)/2;
        TreeNode left = helper(l, m-1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;

        head = head.next; // !!!!

        root.right = helper(m+1, r);
        return root;
    }

    private int findLen(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
