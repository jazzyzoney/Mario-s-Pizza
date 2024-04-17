import java.util.*;
import java.io.*;
import java.io.EOFException;

public class Statistics{

   static public void loadsavefile(){
      try {
         OrderList.file = new File("Pizza Info.txt");
         Scanner scan = new Scanner(OrderList.file);
         while (scan.hasNext()){
            while (scan.hasNextInt()) {
               int i = scan.nextInt();
               System.out.println(i);
            }
            System.out.println("ny ordre.");
         //System.out.println(scan.next());
         }
         scan.close();
      } 
      catch (Exception e) {
         e.printStackTrace();
      }  
   }   
    
   ArrayList<Integer> pizzaNumbers = new ArrayList<>();
   ArrayList<Integer> prices = new ArrayList<>();

}