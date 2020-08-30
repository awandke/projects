public class QueueDemo
{
   public static void main(String[] args)
   {
      LinkedListQueue q = new LinkedListQueue();

      //add to q
      q.add("hi");
      q.add("hola");
      q.add("hi there");
      q.add("minecraft");
      System.out.println(q);
      
      q.firstToLast();
      q.firstToLast();
      q.lastToFirst();
      q.lastToFirst();
      q.lastToFirst();
     
      

      while (!q.empty())
      {
         System.out.println(q.remove());
      }
   }
}
