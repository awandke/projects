import java.util.NoSuchElementException;

/**
   An implementation of a queue as a circular array.
*/
public class CircularArrayQueue
{
   private Object[] elements;
   //private data
   private int currentSize;
   private int head;
   private int tail;
   
   /**
      Constructs an empty queue.
   */
   public CircularArrayQueue()
   {
       final int INITIAL_SIZE = 10;
       elements = new Object[INITIAL_SIZE];
       currentSize = head = tail = 0; 
   }

   /**
      Checks whether this queue is empty.
      @return true if this queue is empty
   */
   public boolean empty() {return currentSize == 0;}

   /**
      Adds an element to the tail of this queue.
      @param newElement the element to add
   */
   public void add(Object newElement)
   {
       growIfNecessary(); 
       currentSize ++;
       elements[tail] = newElement;
       tail = (tail+1)%elements.length;
   }

   /**
      Removes an element from the head of this queue.
      @return the removed element
   */
   public Object remove()
   {
       if (empty())
            throw new NoSuchElementException();
       currentSize --;
       Object removed = elements[head];
       elements[head] = null; //saves memory 
       head = (head+1)%elements.length; //wrap around to start of list 
       return removed;
   }

   public Object removeLast()
   {
       if (empty())
            throw new NoSuchElementException();
       currentSize--; 
       if (tail == 0)
            tail = elements.length-1;
       else
       {
           tail--;
       }
       Object removed = elements[tail]; 
       return removed; 
       
   }
   
   public void addFirst(Object e)
   {
       growIfNecessary();
       currentSize++;
       if (head == 0)
            head = elements.length-1;
       else
       {
           head--;
       }
            
       elements[head] = e; 
       
   }
   
   public void firstToLast()
   {
       elements[tail] = elements[head];
       tail = (tail+1)%elements.length;
       head = (head+1)%elements.length;
   }
   
   public void lastToFirst()
   {
       if (head == 0)
            head = elements.length-1;
       else
       {
           head--;
       }
       elements[head] = elements[tail];
       tail = (tail+1)%elements.length;
   }
   
   public int size()
   {
       return currentSize;
   }
   
   
   /**
      Grows the element array if the current size equals the capacity.
   */
   private void growIfNecessary()
   {
       if(currentSize == elements.length)
       {
           Object[] newArray = new Object[elements.length*2];
           
           for (int a = head, b = 0; a !=tail; a = (a+1)%elements.length, b++)
           {
               newArray[b] = elements[a];
               
           }
           elements = newArray;
           head = 0;
           tail = currentSize; 
       }
   }




}//CircularArrayQueue
