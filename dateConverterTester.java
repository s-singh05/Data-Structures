import java.io.*;

public class dateConverterTester {
    public static void main(String args[]) throws FileNotFoundException{
        dateConverter d = new dateConverter("data.txt");
        System.out.println(d.toString());
        System.out.println(d.dayOfTheWeek());
    }
}