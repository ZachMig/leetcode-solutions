//Given the head of a linked list, remove the nth node from the end of the list and return its head.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {    
    
    private class LNHelper { 
        
        private boolean done;
        private int countdown;
        
        
        LNHelper (int n) {
            done = false;
            countdown = n;
        }
        
        public int getCounter() {
            return countdown;
        }
        
        public void decCounter() {
            countdown--;
        }
        
        public boolean isDone() {
            return done;
        }
        
        public void allDone() {
            done = true;
        }
    }
    
    
    public void tryAgain(ListNode prev, ListNode cur, LNHelper tracker) {
        if (cur == null) {
            tracker.decCounter();
            return;
        }
        
        tryAgain(prev.next, cur.next, tracker);
                
        if (!tracker.isDone() && tracker.getCounter() == 0) {
            tracker.allDone();
            prev.next = cur.next;                
        }
        tracker.decCounter();        
    }
    
    
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if (head.next == null) 
            return null;
        
        LNHelper tracker = new LNHelper(n);
        
        tryAgain(head, head.next, tracker);
        
        if (!tracker.isDone()) {
            return head.next;
        }
        
        return head;
        
    }
}
