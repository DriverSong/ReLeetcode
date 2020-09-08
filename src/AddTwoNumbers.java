
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode end = head;
        int plus = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while(temp1 != null && temp2 != null){
            end.next = new ListNode((temp1.val + temp2.val + plus)% 10);
            plus = Math.abs((temp1.val + temp2.val + plus) / 10);
            temp1 = temp1.next;
            temp2 = temp2.next;
            end = end.next;
        }
        while(temp1 != null){
            end.next = new ListNode((temp1.val + plus) % 10);
            plus = Math.abs((temp1.val + plus)/10);
            temp1 = temp1.next;
            end = end.next;
        }
        while(temp2 != null){
            end.next = new ListNode((temp2.val + plus) % 10);
            plus = Math.abs((temp2.val + plus)/10);
            temp2 = temp2.next;
            end = end.next;
        }
        if(plus != 0){
            end.next = new ListNode( plus );
        }
        return head.next;
    }
}
