public class BagTester {
    public static void main(String args[]){
        Bag<String> bag1 = new Bag<>(1);
        bag1.addItem("item");
        for(String s:bag1){
            System.out.println(s);
        }
        System.out.println(bag1.size());
        bag1.addItem("item2");
        System.out.println(bag1.isEmpty());

        Bag<Integer> bag2 = new Bag<>(1);
        bag2.addItem(3);
        System.out.println(bag2.size());
        bag2.addItem(5);
        System.out.println(bag2.isEmpty());        
            
            
            }
}
