public class Main{
   public static void main(String[] args){
      Menu.addPizzamenu();
      
      Menu.printMenu();
      Orders.addOrder(1);
      
      Orders.printOrders();
   }
}