public class oddAndEvenIndexSortOfLinkedList  {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddStart = null, oddEnd = null;
        ListNode evenStart = null, evenEnd = null;

        ListNode temp = head;
        int pos = 1;   // position counter

        while (temp != null) {

            if (pos % 2 != 0) {   // odd position

                if (oddStart == null) {
                    oddStart = temp;
                    oddEnd = temp;
                } else {
                    oddEnd.next = temp;
                    oddEnd = temp;
                }

            } else {   // even position

                if (evenStart == null) {
                    evenStart = temp;
                    evenEnd = temp;
                } else {
                    evenEnd.next = temp;
                    evenEnd = temp;
                }
            }

            temp = temp.next;
            pos++;
        }

        if (oddStart == null) return evenStart;
        if (evenStart == null) return oddStart;

        oddEnd.next = evenStart;
        evenEnd.next = null;

        return oddStart;
    }
}