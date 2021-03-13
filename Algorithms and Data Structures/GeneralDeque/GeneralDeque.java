/**PROBLEM DESCRIPTION: A double-ended queue or deque is a collection that is acombination of a stack and a queue. Your task is to implement a generalized deque structure called GeneralDequethat uses linked list as internal structure.
 * api:
 *      public class GeneralDeque<Item> implements Iterable<Item>
 *      {
 *          public GeneralDeque(); // create an empty deque 
 *          public boolean isEmpty(); // is it empty? 
 *          public int size(); // get size 
 *          public void push(Item i); // add item to beginning 
 *          public void enqueue(Item i); // add item to end 
 *          public Item pop(); // remove item from beginning and ret 
 *          public Item dequeue(); // remove item from end and return
 *          public Item peek(); // return the item at the beginning 
 *          public Item top(); // return the item at the end 
 *          public Iterator<Item> iterator(); // iterator method
 *      }
 * Requirements:
 *      1. When any get/delete method (pop, dequeue, peek, top) are called on anempty deque, you should throw an RuntimeException with the followingstatement:
 *          "get/delete method called on empty deque"
 *      2. iterator() must work regardless of the deque is empty or not
 *      3. all of the above operation must be done in O(1) time (including iterator())
 *      4. You are free to implement any helper private fields and functions.
 * 
 * DEPENDENCIES: ST.java, StdIn.java, StdOut.java, Stack.java
 * 
 * EXAMPLE:
 * Input: 
 *      See Input.txt file      
 * Output:
 *      size: 0 
        Exception(top): java.lang.RuntimeException
        empty: true 
        size: 0 
        empty: true 
        pop: -641 
        peek: 671 
        top:671 
        empty: false 
        dequeue: 671 
        Exception(push): java.util.NoSuchElementException: Stack und
        Exception(pop): java.lang.RuntimeException
        Exception(peek): java.lang.RuntimeException
        Exception(peek): java.lang.RuntimeException
        size: 0
        ...
        exit: [ -870 -83 -152 -303 -519 160 687 31 -629 -849 ]
 */

import java.util.*;

public class GeneralDeque<Item> implements Iterable<Item>
{
    private int N;
    private ListNode front;
    private ListNode end;
    
    private class ListNode
    {
        private Item item;
        private ListNode prev;
        private ListNode next;
    }    

    public GeneralDeque() {
    	N = 0;
        front = null;
        end = null;
    }
    
    // Methods
    public boolean isEmpty()
    {
	    return N == 0;
    }

    public int size()
    {
    	return N;
    }

    public void push(Item item)
    {   
        if (item == null)
            throw new NullPointerException();
        ListNode newFront = front;
        front = new ListNode();
        front.prev = null;
        front.item = item;
        if (isEmpty()) {
            front.next = null;
            end = front;
        } else {
            front.next = newFront;
            newFront.prev = front;
        }
        N++;
    }

    public void enqueue(Item item)
    {
        if (item == null)
            throw new NullPointerException();
        ListNode newEnd = end;
        end = new ListNode();
        end.next = null;
        end.item = item;
        if (isEmpty()) {
            end.prev = null;
            front = end;
        } else {
            newEnd.next = end;
            end.prev = newEnd;
        }
        N++;
    }

    public Item pop()
    {
        if (isEmpty())
            throw new RuntimeException("get/delete method called on empty deque");
        Item item = front.item;
        if (N == 1) {
            front = null;
            end = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        N--;
        return item;
    }

    public Item dequeue()
    {
        if (isEmpty())
            throw new RuntimeException("get/delete method called on empty deque");
        Item item = end.item;
        if (N == 1) {
            front = null;
            end = null;
        } else {
            end = end.prev;
            end.next = null;
        }
        N--;
	    return item;
    }

    public Item peek()
    {
        if (front == null)
            throw new RuntimeException("get/delete method called on empty deque");
        return front.item;
    }

    public Item top()
    {
        if (end == null)
            throw new RuntimeException("get/delete method called on empty deque");
	    return end.item;
    }

    // deque iterator
    private class DIter implements Iterator<Item>
    {
    	private ListNode current;

        public DIter() {
        	this.current = front;
        }
        
        // Methods
        public boolean hasNext() {
            return current != null;
        }
        
        public Item next()
        {
            if (current == null)
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public Iterator<Item> iterator()
    {      
        return new DIter();   
    }

    public static void main(String[] args)
    {

        GeneralDeque<Integer> gd = new GeneralDeque<Integer>();
        Stack<String> stack = new Stack<String> () ;
        while (!StdIn.isEmpty()){
            String op = StdIn.readString();
            if (op.equals("empty"))
                StdOut.println("empty: " + gd.isEmpty());
            else if (op.equals("size"))
                StdOut.println("size: " + gd.size());
            else if (op.equals("push")){ 
                try { 
                    gd.push(Integer.parseInt(stack.pop()));
                } catch (RuntimeException e) {StdOut.println("Exception(push): " + e);}
                
            } else if (op.equals("enqueue")) { 
                try { 
                    gd.enqueue(Integer.parseInt(stack.pop()));
                } catch (RuntimeException e) {StdOut.println("Exception(enqueue): " + e);}
            } else if (op.equals("pop"))
            {
                try {StdOut.println("pop: " + gd.pop());}
                catch (RuntimeException e) {StdOut.println("Exception(pop): " + e);}
            }
            else if (op.equals("dequeue"))
            {
                try {StdOut.println("dequeue: " +  gd.dequeue());}
                catch (RuntimeException e) {StdOut.println("Exception(dequeue): " + e);}
            }
            else if (op.equals("peek"))
            {
                try {StdOut.println("peek: " + gd.peek());}
                catch (RuntimeException e) {StdOut.println("Exception(peek): " + e);}
            }
            else if (op.equals("top"))
            {
                try {StdOut.println("top:" + gd.top());}
                catch (RuntimeException e) {StdOut.println("Exception(top): " + e);}
            }
            else if (op.equals("show")){
                StdOut.print("show: [ ");
                for (int ele : gd) StdOut.print(ele + " ");
                StdOut.println("]");
            } else {
                stack.push(op);
            }  
        }
        StdOut.print("exit: [ ");
        for (int ele : gd) StdOut.print(ele + " ");
        StdOut.println("]");
    }
}
