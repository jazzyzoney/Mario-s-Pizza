import java.io.*;

public class Pizza implements Serializable{
   int price =0; 
   int number = Menu.menu.size(); 
   String name=""; 
   
   public Pizza(String name, int price){
      this.name = name;
      this.price = price;
   }
   
   public void printPizzas(){
      System.out.println(number + ". " + name + " " + price + ",-");
   }
   public String toString(){
      return this.name + this.price;
   }
}