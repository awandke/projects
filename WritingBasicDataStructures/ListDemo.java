/**
   A program that demonstrates the LinkedList class
*/
public class ListDemo
{
   public static void main(String[] args)
   {
      //create LinkedList and add to it
      LinkedList staff = new LinkedList();
      staff.addFirst("HI");
      staff.addFirst("Hello");
      staff.addFirst("Hola");
      staff.addFirst("ayyy");
      

      // | in the comments indicates the iterator position
      ListIterator iter = staff.listIterator(); //starts at 0 by default |1234
      iter.next(); //1|234
      iter.next(); //12|34
      

      // Add more elements after second element
      iter.add("Another1"); //12A|34]
      iter.add("Somemore"); //12AS|34


       iter.next();//12AS3|4
      // Remove last traversed element
      iter.remove(); //12AS|4


      // Print all elements

      iter = staff.listIterator();
      while (iter.hasNext())
      {
         System.out.print(iter.next() + " ");
      }
      System.out.println();
      
      System.out.println(staff.size());
      
      System.out.println(staff.contains("Hola"));
      
      staff.set(3,"fluffy seal");
      System.out.println(staff.get(3));
      
      
      iter = staff.listIterator();
      while (iter.hasNext())
      {
         System.out.print(iter.next() + " ");
      }
    } 
   
}
