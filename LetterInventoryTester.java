
public class LetterInventoryTester {
    public static void main(String args[]){
        LetterInventory washington = new LetterInventory("Washington");
        LetterInventory state = new LetterInventory("a");
        System.out.println(washington.size());
        System.out.println(washington.isEmpty());
        System.out.println(washington.get('a'));
        System.out.println(washington.toString());
        washington.set('a',4);
        System.out.println(washington.toString());
        System.out.println(washington.subtract(state));
    }
}
