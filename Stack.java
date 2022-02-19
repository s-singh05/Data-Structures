import java.util.Iterator;

public class Stack <T> implements Iterable<T>{
    
    private T[] stack; 
    private int currPosition;
    
    public Stack(int size){
        stack = (T[])new Object[size];
        currPosition = 0;
    }
    
    private T[] resize(){
        // doubles array size if too small
        if(currPosition == stack.length-1){
            T[] newTStack; 
            newTStack = (T[])new Object[stack.length * 2];
            for(int i = 0; i <= currPosition; i++){
                newTStack[i] = stack[i];
            }
            stack = newTStack;
            System.out.println("Increasing size");
        }
        
        else if(currPosition <= stack.length/4){
            T[] newTStack; 
            newTStack = (T[])new Object[stack.length/2];
            for(int i = 0; i <= currPosition; i++){
                newTStack[i] = stack[i];
            }
            stack = newTStack;
            System.out.println("Decreasing size");
        }
        
        return stack;

    }
    
    public void push(T str){
        stack = this.resize();
        stack[currPosition] = str;
        currPosition++;
    }

    public T pop(){
        T returnThis = this.stack[currPosition];
        // deals with loitering
        this.stack[currPosition] = null;
        currPosition--;
        this.resize();
        return returnThis;
    }

    public int size(){
        return currPosition;
    }

    public boolean isEmpty(){
        return currPosition == 0;
    }
    
    public boolean isPalindrome(Stack<Integer> other)
    {
      Stack<Integer> reverse = new Stack<>(other.size());
      for(int i = 0; i < reverse.size(); i++)
      {
         reverse.set(i, other.size()-i-1);
      }
      
      for(int i = 0; i < reverse.size(); i++)
      {
         if(reverse.get(i) != other.get(i))
         {
            return false;
         }
      }
      return true;
    }
    
    public T get(int i){
        return stack[i];
     }
     
    public void set(int index, T value){
        stack[index] = value;
     }
     
    public void switchPairs(Stack<Integer> s) {
        if(s.size() % 2 == 0){
            Integer value;
            for(int i = 0; i < s.size()-1; i++){
               value = s.get(i);
               s.set(i,s.get(i+1));
               s.set(i+1,value);
               i++;
            }
        }
        
        else{
            Integer value;
            for(int i = 0; i < s.size()-2; i++){
               value = s.get(i);
               s.set(i,s.get(i+1));
               s.set(i+1,value);
               i++;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {return new Stackerator();}

    private class Stackerator implements Iterator<T>{
        private int i = 0; 
        @Override
        public boolean hasNext() {
            return i < currPosition;
        }

        public T next() {
            return stack[i++];
        }
    }

    public String toString()
    {
      String s = "[";
      for(int i = 0; i < currPosition; i++)
      {
         if(i != currPosition-1)
         {
            s += stack[i] + ", ";
         }
         else
         {
            s+= stack[i];
         }
      }
      return s + "]";
    }
}
