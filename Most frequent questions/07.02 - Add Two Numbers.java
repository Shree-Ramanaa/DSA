class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry  = 0;
        
        ListNode result = new ListNode(0);
        ListNode temp = result;
        
        while(l1 != null || l2 != null){
            int sum = carry;
            if(l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
           
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        
        if(carry != 0)temp.next = new ListNode(carry);
        
        return result.next;
    }
}
