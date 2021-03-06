package medium;

/*
    Sort a linked list using insertion sort.
 */
public class InsertionSortList {

    public static void main(String... args) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        InsertionSortList insertionSortList = new InsertionSortList();
        System.out.println(insertionSortList.insertionSortList(head));
    }

    static class ListNode {

        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private ListNode find(ListNode node, ListNode head) {

        ListNode root = node;
        ListNode node1 = new ListNode(head.val);

        while (node.val < head.val) {

            if (node.next == null) {
                node.next = node1;
                return root;
            }

            if (node.next.val >= head.val) {
                node1.next = node.next;
                node.next = node1;
                return root;
            }

            node = node.next;
        }

        node1.next = root;
        return node1;
    }

    public ListNode insertionSortList(ListNode head) {

        if (head == null) return null;
        ListNode node = new ListNode(head.val);
        while ((head = head.next) != null) node = find(node, head);
        return node;
    }

}
