class Solution {
    public boolean isPalindrome(ListNode head) {
        StringBuilder s = new StringBuilder();
        int len = -1;
        while(head!=null){
            s.append((char)((head.val)+48));
            head=head.next;
            len+=1;
        }
        int l=0;
        while(l<len){
            if(s.charAt(l)!=s.charAt(len))return false;
            l+=1;
            len-=1;
        }
        return true;
    }
}
