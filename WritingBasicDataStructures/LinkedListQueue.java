/**
   Add a method firstToLast to this implementation of a queue.
   The method moves the element at the head of the queue to
   the tail of the queue. The element that was second in line
   will now be at the head.
*/
public class LinkedListQueue
{
    //data
    private Node head; 
    private Node tail; // wasn't sure if this was absolutely necessary 


   /**
      Constructs an empty queue.
   */
  public LinkedListQueue()
  {
      head = null;
      tail = null;
  }

   /**
      Checks whether this queue is empty.
      @return true if this queue is empty
   */
  public boolean empty()
  {
      return (head == null);
  }

   /**
      Adds an element to the tail of this queue.
      @param newElement the element to add
   */
   public void add(Object element)
   {
       Node newNode = new Node(); 
       newNode.data = element;
       if (empty())
       {
           tail = newNode; 
           head = newNode;
       }
       else
       {
           tail.next = newNode;
           tail = newNode;
       }
       tail.next = null;//happens automatically
   }


   /**
      Removes an element from the head of this queue.
      @return the removed element
   */
   public Object remove()
   {
       if (empty())
            return null; 
       Object data = head.data;
       head = head.next; 
       // what if last node is removed -- didn't think about tail
       if (head == null)
            tail = null; 
       
       return data; 
   }
   
   public void firstToLast()
   {
       add(remove());
       /*
          tail.next = head; 
          tail = tail.next;
          head = head.next;
          tail.next = null;
          */
   }
   
   public void lastToFirst()
   {
       tail.next = head; 
         
       Node anode = head; 
       while(!anode.next.equals(tail))
       {
           anode = anode.next; 
       }
       
       tail = anode;
       head = anode.next;
       tail.next = null; 
   }
   
   public String toString()
   {
       String data = "";
       Node temp = head; 
       
       while (temp != null)
       {
           data += temp.data+ "\n";
           temp = temp.next;
       }
       
       
       return data;
   }


   class Node
   {
      public Object data;
      public Node next;
   }
}
