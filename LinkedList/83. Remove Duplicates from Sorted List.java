class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ret = head;
        while(head!=null && head.next!=null){
            if(head.val == head.next.val)head.next = head.next.next;
            else head = head.next;
        }
        return ret;
    }
}
