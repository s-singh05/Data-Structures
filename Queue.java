import java.util.Iterator;

public class Queue <T> implements Iterable<T>{
    private T[] queue;
    private int currPosition;
    
    public Queue(int size){
        queue = (T[])new Object[size];
        currPosition = 0;
    }

    private T[] resize(){
        // doubles array size if too small
        if(currPosition == queue.length-1){
            T[] newTQueue; 
            newTQueue = (T[])new Object[queue.length * 2];
            for(int i = 0; i <= currPosition; i++){
                newTQueue[i] = queue[i];
            }
            queue = newTQueue;
            System.out.println("Increasing size");
        }
        
        else if(currPosition <= queue.length/4){
            T[] newTQueue; 
            newTQueue = (T[])new Object[queue.length/2];
            for(int i = 0; i <= currPosition; i++){
                newTQueue[i] = queue[i];
            }
            queue = newTQueue;
            System.out.println("Decreasing size");
        }
        
        return queue;

    }

    public void enqueue(T str){
        queue = this.resize();
        queue[currPosition] = str;
        currPosition++;
    }

    public T dequeue(){
        queue = this.resize();
        T[] queue1 = (T[]) new Object[queue.length];
        T returnThis = queue[0];
        for(int i = 1; i < queue.length; i++){
            queue1[i-1] = queue[i];
        }
        queue = queue1;
        currPosition--;
        return returnThis;
    }

    public int size(){
        return currPosition;
    }

    public boolean isEmpty(){
        return currPosition == 0;
    }
    
    @Override
    public Iterator<T> iterator() {return new Queuerator();}

    private class Queuerator implements Iterator<T>{
        private int i = 0; 
        @Override
        public boolean hasNext() {
            return i < currPosition;
        }

        public T next() {
            return queue[i++];
        }
    }

    public String toString()
    {
      String s = "[";
      for(int i = 0; i < currPosition; i++)
      {
         if(i != currPosition-1)
         {
            s += queue[i] + ", ";
         }
         else
         {
            s+= queue[i];
         }
      }
      return s + "]";
    }
}
