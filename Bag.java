import java.util.Iterator;

public class Bag <T> implements Iterable<T>{

    private T[] bag;
    private int currPosition;

    public Bag(int size){
        bag = (T[]) new Object[size];
        currPosition = 0;
    }

    private T[] resize(){
        // doubles array size if too small
        if(currPosition == bag.length-1){
            T[] newTStack; 
            newTStack = (T[])new Object[bag.length * 2];
            for(int i = 0; i <= currPosition; i++){
                newTStack[i] = bag[i];
            }
            bag = newTStack;
            System.out.println("Increasing size");
        }
        
        else if(currPosition < bag.length/4){
            T[] newTStack; 
            newTStack = (T[])new Object[bag.length/2];
            for(int i = 0; i <= currPosition; i++){
                newTStack[i] = bag[i];
            }
            bag = newTStack;
            System.out.println("Decreasing size");
        }
        
        return bag;

    }
    public void addItem(T str){
        bag = this.resize();
        bag[currPosition] = str;
        currPosition++;
    }


    public int size(){
        return currPosition;
    }

    public boolean isEmpty(){
        return currPosition == 0;
    }

    @Override
    public Iterator<T> iterator() {return new Bagerator();}

    private class Bagerator implements Iterator<T>{
        private int i = 0; 
        @Override
        public boolean hasNext() {
            return i < currPosition;
        }

        public T next() {
            return bag[i++];
        }
    }

    public String toString()
    {
      String s = "[";
      for(int i = 0; i < currPosition; i++)
      {
         if(i != currPosition-1)
         {
            s += bag[i] + ", ";
         }
         else
         {
            s+= bag[i];
         }
      }
      return s + "]";
    }
}