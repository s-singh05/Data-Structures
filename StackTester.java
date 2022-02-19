public class StackTester {
    public static void main(String args[]){
        Stack<String> bag1 = new Stack<>(1);
        bag1.push("item");
        System.out.println(bag1.size());
        System.out.println("for each loop");
        for(String s:bag1){
            System.out.println(s);
        }
        System.out.println(bag1.pop());
        bag1.push("item2");
        System.out.println(bag1.pop());
        System.out.println(bag1.pop());
        System.out.println(bag1.isEmpty());
        
        Stack<Integer> bag2 = new Stack<>(1);
        bag2.push(4);
        System.out.println(bag2.size());
        System.out.println(bag2.pop());
        bag2.push(7);
        //System.out.println(bag2.pop());
        //System.out.println(bag2.pop());
        System.out.println(bag2.isEmpty());
        bag1.switchPairs(bag2);

        for(String s:bag1){
            System.out.println(s);
        }

    }
}
