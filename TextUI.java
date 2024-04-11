import java.util.Scanner;

public class TextUI{
   static Scanner scanner = new Scanner (System.in);
   public static void textUI (){
      String Letters = ""; 
      System.out.print("Mamma mia velkommen til Mario's pizza order system");
      Menu.addPizzamenu();
      Menu.printMenu();
       do {
      System.out.print("du har nu fire valgmuligheder");
            System.out.println("");
            System.out.println("du kan nu skrive add for at addere en ordre");
             System.out.println("eller skrive done for at afsluttet orderen");
             System.out.println("Delete vil fjerne orderen fra systemet");
             System.out.println("view vil lade dig se alle ordrene");
             System.out.println("q afslutter programmet");
      
      
      Letters = scanner.next();
      switch (Letters){
      
         case "add":
         System.out.println("du skal nu skrive hvor mange pizzer orderen skal indeholde");
            int ordernumber = scanner.nextInt();
            OrderList.addOrder(ordernumber);
            break; 
         
         case "done":
         System.out.println("hvilken order er done?");
            int sletnummer = scanner.nextInt();
            OrderList.completeOrder(sletnummer);
            System.out.println("orderen"+ ""+ sletnummer+""+ "er nu blevet makeret som done og gemt til statestikken når jasmin er færdig");
            break; 
         
         case "delete":
         System.out.println("hvilken order er skal deletes?");
            int deletenumber = scanner.nextInt();
            OrderList.deleteOrder(deletenumber);
            System.out.println("orderen"+ ""+ deletenumber+""+ "er nu blevet makeret som deleted og fjernet fra dell computeren");
            break;
         
         case "view":         
            OrderList.printOrders();
            break;

         case "Q":
         System.out.println("tak for idag hej hej");
            System.exit(0);        
      }
   } while(true);
   }
}