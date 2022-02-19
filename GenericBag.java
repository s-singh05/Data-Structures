import java.util.Iterator;

public class GenericBag <T> implements Iterable<T>{

   int currPos;
   T[] genBag;
   
   public GenericBag(){
      currPos = 0;
      genBag = (T[]) new Object[10];
   } 
   
   public void add(T item){
      if(genBag.length > currPos){
         genBag[currPos] = item;
         currPos++;
      }
         
   }
   
   @Override
   public Iterator<T> iterator() {
      return null;
   }

}