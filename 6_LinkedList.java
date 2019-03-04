/* 6. Linked List */

class ListNode {
	int val; 
	ListNode next;
	ListNode (int val) {
		this.val = val;
		next = null;
	}
}

// 1. cut half using 2 pointers :: faster & slower => slower pointer will point the mid element
ListNode slower = head, faster = head;
while(faster.next != null && faster.next.next != null) {
	faster = faster.next.next;
	slower = slower.next;
}
/* 
 even number of list :: 1 - (2) - 3 - 4
                             s   f
 odd number of list :: 1 - 2 - (3) - 4 - 5
                                s       f
*/


// 2. reverse the linked list in place
ListNode reverse (ListNode head) {
	ListNode prev = null;
	while(head != null) {
		ListNode next = head.next;
		head.next = prev;
		prev = head;
		head = next;
	}
	return prev;
}

// 3. reverse the part of the list 
ListNode reverse2 (ListNode head, int start, int num) {

	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode prev = dummy;
	for(int i = 0; i < start - 1; i++) {
		prev = prev.next;
	}

	ListNode cur = prev.next;
	for(int i = 0; i < num; i++) {
		ListNode next = cur.next.next;
		cur.next.next = prev.next;
		prev.next = cur.next;
		cur.next = next;
	}

	return dummy.next;
}









