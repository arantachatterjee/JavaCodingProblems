import java.util.PriorityQueue;

public class MergeKLists {

      //Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static void main (String[] args) {
      //Create Linked List 1
        ListNode list1 = new ListNode(-1);
        ListNode node = list1;
        list1.next = new ListNode(1);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(5);

        ListNode head1 = list1.next;

        while (head1 != null) {
            System.out.print(head1.val);
            head1 = head1.next;
            if (head1 != null)
                System.out.print("--> ");
        }

        //Create Linked List 2
        ListNode list2 = new ListNode(-1);
        ListNode node2 = list2;
        list2.next = new ListNode(1);
        node2 = node2.next;
        node2.next = new ListNode(3);
        node2 = node2.next;
        node2.next = new ListNode(4);

        ListNode head2 = list2.next;
        System.out.println();

        while (head2 != null) {
            System.out.print(head2.val);
            head2 = head2.next;
            if (head2 != null)
                System.out.print("--> ");
        }

        //Create Linked List 3
        ListNode list3 = new ListNode(-1);
        ListNode node3 = list3;
        list3.next = new ListNode(2);
        node3 = node3.next;
        node3.next = new ListNode(6);
        node3 = node3.next;
        node3.next = new ListNode(19);

        ListNode head3 = list3.next;
        System.out.println();

        while (head3 != null) {
            System.out.print(head3.val);
            head3 = head3.next;
            if (head3 != null)
                System.out.print("--> ");
        }

        ListNode[] list = {list1.next, list2.next, list3.next};
        System.out.println();
        //Print merged list
        ListNode head = mergeKLists(list);
        System.out.println("Merged List:");
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null)
                System.out.print("--> ");
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
          // Merged list
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        ListNode res = new ListNode(-1);
        ListNode resCurr = res;

        for (ListNode head : lists) {
            ListNode curr = head;
            while (curr != null) {
                minHeap.add(curr.val);
                curr = curr.next;
            }
        }

        while (!minHeap.isEmpty()) {
            res.next = new ListNode(minHeap.remove());
            res = res.next;
        }

        return resCurr.next;
    }
}