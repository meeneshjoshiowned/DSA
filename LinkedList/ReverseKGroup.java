class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        if (count < k) return head;

        ListNode prev = null;
        curr = head;
        ListNode next = null;
        count = 0;

        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k=2;
        System.out.println("Original list:");
        printList(head);

        head = reverseKGroup(head, k);

        System.out.println("Reversed in groups of " + k + ":");
        printList(head);
    }
}
