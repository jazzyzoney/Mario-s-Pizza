import java.util.Scanner;

public class TextUI{
   static Scanner scanner = new Scanner (System.in);
   public static void textUI (){
      String Letters = ""; 
      System.out.print("Mamma mia velkommen til Mario's pizza order system");
      Menu.addPizzamenu();
      Menu.addPizzamenu();
      do {
         System.out.print("\nDu har nu fire valgmuligheder:");
         System.out.println("");
         System.out.println("Du kan nu skrive" + " add " + "for at addere en ordre,");
         System.out.println("eller skrive" + " done " + "for at afslutte ordreren,");
         System.out.println("delete " + "vil fjerne ordreren fra systemet,");
         System.out.println("view " + "vil lade dig se alle ordrerne,");
         System.out.println("q " + "afslutter programmet.");
      
         Letters = scanner.next();
         switch (Letters){
         
            case "add":
               System.out.println("Du skal nu skrive hvor mange pizzaer ordreren skal indeholde");
               int ordernumber = scanner.nextInt();
               OrderList.addOrder(ordernumber);
               break; 
         
            case "done":
               System.out.println("Hvilken ordrer er done?");
               int sletnummer = scanner.nextInt();
               OrderList.completeOrder(sletnummer);
               System.out.println("Ordreren"+ ""+ sletnummer+""+ "er nu blevet markeret som done og gemt til statestikken");
               break; 
         
            case "delete":
               System.out.println("Hvilken ordrer skal slettes?");
               int deletenumber = scanner.nextInt();
               OrderList.deleteOrder(deletenumber);
               System.out.println("Ordreren"+ ""+ deletenumber+""+ "er nu blevet markeret som slettet og er fjernet fra dell computeren");
               break;
         
            case "view":         
               OrderList.printOrders();
               break;
         
            case "q":
               System.out.println("Tak for idag");
               System.exit(0);        
         }
      } while(true);
   }
}