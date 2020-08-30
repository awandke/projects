import java.util.NoSuchElementException;

/**
A linked list is a sequence of nodes with efficient
element insertion and removal. This class
contains a subset of the methods of the standard
java.util.LinkedList class.
 */
public class LinkedList
{
    private Node first; 

    /**
    Constructs an empty linked list.
     */
    public LinkedList()
    {
        first = null;

    }

    /**
    Returns the first element in the linked list.
    @return the first element in the linked list
     */
    public Object getFirst()
    {
        if (first  == null)
        {throw new NoSuchElementException();}
        return first.data;                  
    }

    /**
    Removes the first element in the linked list.
    @return the removed element
     */
    public Object removeFirst()
    {
        try{
            Object element =first.data;
            first = first.next;
            return element; 
        }
        catch(NullPointerException e)
        {
            throw new NoSuchElementException();
        }

    }

    /**
    Adds an element to the front of the linked list.
    @param element the element to add
     */
    public void addFirst(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        first = newNode;

    }

    public Object get(int n)
    {
        if (getNode(n) == null)
            throw new NoSuchElementException();
        return getNode(n).data;
    }

    public void set(int n, Object o)
    {
        if (getNode(n) == null)
            throw new NoSuchElementException();
        getNode(n).data = o;
    }
    
    private Node getNode(int n)
    {
        Node place = first;
        for(int i = n; i>0 && place!= null; i--)
            place = place.next; 
        return place;
    }

    public boolean contains(Object o)
    {
        Node anode = first;
        while (anode != null && !anode.data.equals(o))
        {
            anode = anode.next;
        }
        
        return anode != null; 
    }
    
    /**
    Returns an iterator for iterating through this list.
    @return an iterator for iterating through this list
     */
    public ListIterator listIterator()
    {
        return new LinkedListIterator();

    }

    /**
     * computes the size of the linked list
     * @return int the size of the linked list
     */
    public int size()
    {
        return size(first);

        /*
        int count = 0;
        ListIterator iter = this.listIterator();

        while(iter.hasNext())
        {
        count++;
        iter.next();
        }

        return count;
         */
    }

    private int size(Node start)
    {
        if (start!= null)
            return 1+ size(start.next);
        else 
            return 0; 
    }
    /*
    possible implementation 
    Node current = first; 
    while current != null;
    count ++
    current = current.next
     */

    /**
     * class node
     */
    class Node 
    {
        public Object data; // this object 
        public Node next;

    }    
    class LinkedListIterator implements ListIterator
    {
        //private data
        private Node position;
        private Node previous;
        private boolean isAfterNext; 

        /**
        Constructs an iterator that points to the front
        of the linked list.
         */
        LinkedListIterator()
        {
            position = null;
            previous = null;
            isAfterNext = false;
        }

        /**
        Moves the iterator past the next element.
        @return the traversed element
         */
        public Object next()
        {
            if (!this.hasNext()){
                throw new NoSuchElementException();
            }

            previous = position; // remember for remove 
            isAfterNext = true; 
            if (position == null)
            {
                position = first; // true if you are at the first position 
            }
            else 
            {
                position = position.next; 
            }

            return position.data; 
        }

        /**
        Tests if there is an element after the iterator position.
        @return true if there is an element after the iterator position
         */
        public boolean hasNext()
        {
            if (position == null)
                return first != null; 
            else 
                return position.next != null;
        }

        /**
        Adds an element before the iterator position
        and moves the iterator past the inserted element.
        @param element the element to add
         */
        public void add(Object element)
        {
            if(position == null)// LL is empty 
            {
                addFirst(element);
                position = first; 
            }
            else
            {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                position.next = newNode;
            }
            isAfterNext = false; 
        }

        /**
        Removes the last traversed element. This method may
        only be called after a call to the next() method.
         */
        public void remove()
        {
            if (!isAfterNext)//if next has not been called
            {
                throw new IllegalStateException();
            }
            if (position == first)
            {
                removeFirst(); // why rewite code if you don't have to?
            }
            else
            {
                previous.next = position.next; //moves reference to skip position
            }
            position = previous; 
            isAfterNext = false;

            // first call to move current posiiont reverts to predecessor 
            // of the removed element --> predecessor is no longer known

        }

        /**
        Sets the last traversed element to a different value.
        @param element the element to set
         */
        public void set(Object element)
        {
            if (!isAfterNext)
            {
                throw new IllegalStateException();
            }
            position.data = element;  

        }

    }//LinkedListIterator
}//LinkedList
