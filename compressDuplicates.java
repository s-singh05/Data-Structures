public void compressDuplicates(Stack<Integer> s) {
    
    if(s.size() == 0){
        return void;
    }

    Queue<Integer> intQueue = new Queue<Integer>();
    int topVal = s.pop();
    int dupeCount = 1;
    
    while(!s.isEmpty()) {
        int num = s.pop();
        
        if(num == topVal) {
            dupeCount++;
        } 
        
        else {
            intQueue.enqueue(topVal);
            intQueue.enqueue(dupeCount);
            dupeCount = 1;
            topVal = num;
        }
    }
    
    intQueue.enqueue(topVal);
    intQueue.enqueue(dupeCount);
    
    while(intQueue.size() != 0){
        s.push(intQueue.dequeue());
    }
        
    while(s.size()!= 0){
        intQueue.enqueue(s.pop());
    }
    while(intQueue.size()!= 0){
        s.push(intQueue.dequeue());
    }

}
}