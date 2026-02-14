//spliting of an arry k times...


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

public class SplitOfLinkedList{
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        ListNode temp = head;
        int length = 0;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        int n = length/k;
        int l = length%k;

        ListNode [] result = new ListNode[k];
        ListNode current = head;
        for(int i = 0;i < k;i++) {
            result[i] = current;
            int partsize = n;
            if(l > 0) {
                partsize++;
                l--;
            }

            for(int j = 0;j < partsize -1  && current != null;j++) {
                current  = current.next;
            }

            if(current != null) {
                ListNode newnode = current.next;
                current.next = null;
                current = newnode;
            }
        }
        return result;
    }
}
