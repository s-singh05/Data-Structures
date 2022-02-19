public class QueueTester {
    public static void main(String args[]){
        Queue<String> bag1 = new Queue<>(1);
        bag1.enqueue("item");
        for(String s:bag1){
            System.out.println(s);
        }
        System.out.println(bag1.size());
        bag1.enqueue("item2");
        System.out.println(bag1.dequeue());
        System.out.println(bag1.dequeue());
        System.out.println(bag1.isEmpty());
        
        Queue<Integer> bag2 = new Queue<>(1);
        bag2.enqueue(5);
        System.out.println(bag2.size());
        bag2.enqueue(2);
        System.out.println(bag2.dequeue());
        System.out.println(bag2.dequeue());
        System.out.println(bag2.isEmpty());
    }
    
}
