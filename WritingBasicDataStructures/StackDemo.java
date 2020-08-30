public class StackDemo
{
   public static void main(String[] args)
   {
      LinkedListStack s = new LinkedListStack();
      //s.pop();
      
      //.push()
      s.push("a");
      s.push("b");
      s.push("c");
      

      //while !empty .pop()
      while (!s.empty())
      {
          System.out.println(s.pop());
      }

   }
}
