package LinkedLists;

import java.util.Stack;

/**
 * Given a singly linked list, modify the value of first half nodes such that :

 1st node’s new value = the last node’s value - first node’s current value
 2nd node’s new value = the second last node’s value - 2nd node’s current value,
 and so on …

 NOTE :
 * If the length L of linked list is odd, then the first half implies at first floor(L/2) nodes. So, if L = 5, the first half refers to first 2 nodes.
 * If the length L of linked list is even, then the first half implies at first L/2 nodes. So, if L = 4, the first half refers to first 2 nodes.
 Example :

 Given linked list 1 -> 2 -> 3 -> 4 -> 5,

 You should return 4 -> 2 -> 3 -> 4 -> 5
 as

 for first node, 5 - 1 = 4
 for second node, 4 - 2 = 2
 Try to solve the problem using constant extra space.

 Solved using slow & fast pointer technique, if fast != null then the list is odd numbered and skip one node to get center. Use a stack to push remaining
 numbers while you find the middle of the list. Then pop and subtract the values
 */
public class SubtractValWithinList {

    public ListNode subtract(ListNode a) {
        ListNode slow = a;
        ListNode fast = a;
        Stack<ListNode> s = new Stack<>();
        if(a == null || a.next == null) return a;


        while(fast !=null &&  fast.next !=null ){
            //slow.val = fast.val - slow.val;
            s.push(slow);
            //System.out.print("pushed val is:" +  slow.val + "****");
            slow = slow.next;
            fast = fast.next.next;

        }

        System.out.print("mid:" +  slow.val + "**");

        if(fast != null){
            slow =slow.next;
        }

        ListNode half = slow;

        while(half != null && s.peek() != null){
            ListNode temp = (ListNode) s.pop();
            //System.out.print("newval = " + half.val  +  " - "+ temp.val +  "****");
            temp.val = half.val - temp.val;
            half = half.next;

        }

        return a;


    }

}
