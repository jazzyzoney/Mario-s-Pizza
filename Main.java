public class Main{
   public static void main(String[] args){
      Menu.addPizzamenu();
      
      Menu.printMenu();
      Orders.addOrder(2);
      
      Orders.printOrders();
   }
}