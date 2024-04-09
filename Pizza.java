public class Pizza{
   int price =0; 
   int number; 
   String name=""; 
   
   public Pizza(String name, int price, int number){
      this.name = name;
      this.price = price;
      this.number = number;
   }
   
   public void printPizzas(){
   System.out.println(number + ". " + name + " " + price + ",-");
}
}