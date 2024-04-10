public class Main{
   public static void main(String[] args){
      Menu.addPizzamenu();
      
      Menu.printMenu();
      Orders.addOrder(2);
      Orders.addOrder(2);
      
      Orders.printOrders();
      Orders.completeOrder(1);
      Orders.printOrders();
   }
}