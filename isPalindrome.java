public boolean isPalindrome(Queue<Integer> other)
    {
      Stack<Integer> reverse = new Stack<Integer>(other.size());
      for(int i = 0; i < reverse.size(); i++)
      {
         Integer temp = other.dequeue();
         reverse.pop();
         other.enqueue(temp);
      }
      for(int i = 0; i < reverse.size(); i++)
      {  
         Integer temp = other.dequeue();
         other.enqueue(temp);
      }
      
      for(int i = 0; i < reverse.size(); i++)
      {
         if(reverse.pop() != other.dequeue())
         {
            return false;
         }
      }
      return true;
    }
