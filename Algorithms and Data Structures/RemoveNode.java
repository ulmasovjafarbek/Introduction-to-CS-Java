/* PROBLEM DESCRIPTION: Write a method remove() that takes a linked-list Node and a string key as itsarguments and removes every node in the list whose item field(instance variable value) is equal to key.
 * 
 * DEPENDENCIES: Stack.java, StdIn.java, StdOut.java
 * 
 * EXAMPLE:
 * Input:
 *      java Remove
 *      10 2
 *      yellow pink orange pink orange orange orange yellow pink yellow
 * Ouput:
 *      yellow pink pink yellow pink yellow
 */

public class Remove
{
    public static void main(String[] args)
    {
        int n = StdIn.readInt(), k = StdIn.readInt();
        String str = StdIn.readString();
        LinkNode head, q;
        head = q = new LinkNode(str, null);
        for (int i = 1; i < n; ++i)
            {
                String a = StdIn.readString();
                q.next = new LinkNode(a, null);
                q = q.next;
            }
        for (q = head; q != null; q = q.next)
            StdOut.print(q.value + " ");
        StdOut.println();
        q = head;
        for (int i = 1; i <= k; ++i) q = q.next;
	        
        LinkNode head2 = remove(head, q.value);
        
        for (LinkNode r = head2; r != null; r = r.next)
            StdOut.print(r.value + " ");
        StdOut.println();
    }

    private static class LinkNode
    {
        public String value;
        public LinkNode next;
        public LinkNode(String v, LinkNode n)
        {
            value = v; next = n;
        }
    }

    public static LinkNode remove(LinkNode head, String key)
    {	
        LinkNode currentNode = head;
        while (currentNode != null && currentNode.next != null) {
            boolean check = currentNode.next.value.equals(key);
            if (check) {
                currentNode.next = currentNode.next.next;
            }
            else currentNode = currentNode.next;
        }
        return head;
    }
}
