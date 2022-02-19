import java.util.Scanner;
import java.io.*;

public class dateConverter {
    private int month;
    private int day;
    private int year;
      
    /**
    * 
    * @param fileName
    * @throws FileNotFoundException
    */
    
    public dateConverter(String fileName) throws FileNotFoundException {
        Scanner line = new Scanner(new File(fileName));
        month = line.nextInt();
        day = line.nextInt();
        year = line.nextInt();
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public int getYear(){
        return year;
    }

    public String dayOfTheWeek(){
        // worked with Max P on this method
        String[] days = new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        int[] numDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int []numDaysLeap = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int[] monthshift = new int[]{0, 13, 14, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        if(year >= 2000)
        {   int newyear = year;
            if(month == 1 )
            {
                newyear--;
            }
            else if (month == 2)
            {
                newyear--;
            }
            int y = newyear % 100;
            int c = newyear / 100;
            int newmonth = monthshift[month];
            int temp = ((13*(newmonth + 1))/5 + (y/4) + (c/4) + (day) + (y) - (2*c))%7;
            //System.out.println(days[temp]);
            //days = days[temp];
            return days[temp];
        }
        else
        {
            days = null;
        }

        // check for illegal dates
        if(year%4 == 0)
        {
            if(numDays[month-1] < day)
            {
                //throw exception
            }
        }
        else if(year%4 != 0)
        {
            if(numDaysLeap[month-1] < day)
            {
                //throw exception
            }
        }
        if(month > 12)
        {
            //  throw excpetion
        }
        return null;
    }

    public Boolean isBefore(dateConverter d2){
        if(year < d2.getYear()){
            return true;
        }
        
        else if(year == d2.getYear()){
            if(month < d2.getMonth()){
                return true;
            }
            else if(month == d2.getMonth()){
                if(day < d2.getDay()){
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public Boolean isAfter(dateConverter d2){
        if(year > d2.getYear()){
            return true;
        }
        
        else if(year == d2.getYear()){
            if(month > d2.getMonth()){
                return true;
            }
            else if(month == d2.getMonth()){
                if(day > d2.getDay()){
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
    
    public String toString(){
        return "" + month + "/" + day + "/" + year;
    }
}
