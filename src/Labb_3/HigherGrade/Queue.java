package Labb_3.HigherGrade;
// code taken from Robert Sedgewick's and Kevin Wayne's booksite Algorithms 4th edition
import java.util.Iterator;
// simple queue class used to iterate through a sequential search symbol table
public class Queue<Item> implements Iterable<Item>
{
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue

    // helper linked list class
    private static class Node<Item>
    {
        private Item item;
        private Node<Item> next;
    }

    public Queue()
    {
        first = null;
        last  = null;
        n = 0;
    }
    public boolean isEmpty()
    {
        return first == null;
    }
    public int size()
    {
        return n;
    }
    public void enqueue(Item item)
    {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    public Iterator<Item> iterator()
    {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item>
    {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first)
        {
            current = first;
        }


        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
