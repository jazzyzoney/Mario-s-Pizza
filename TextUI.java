import java.util.*;

public class TextUI{
   static Scanner scanner = new Scanner (System.in);
   public static void textUI (){
   
      Menu.addPizzamenu();
   
      String Letters = ""; 
      
      System.out.print("Mamma mia velkommen til Mario's pizza order system!\n");
      do {
         System.out.print("\nDu har nu syv valgmuligheder:");
         System.out.println("");
         System.out.println("Du kan nu skrive [add] for at addere en ordre,");
         System.out.println("eller skrive [done] for at afslutte ordreren,");
         System.out.println("[delete] vil fjerne ordreren fra systemet,");
         System.out.println("[view] vil lade dig se alle ordrerne,");
         System.out.println("[menu] vil vise de 30 pizzaer man kan bestille,");
         System.out.println("[statistik] giver et overblik over statistikken,");
         System.out.println("[q] afslutter programmet.");
      
         Letters = scanner.next();
         switch (Letters){
         
            case "add":
               System.out.println("Du skal nu skrive hvor mange pizzaer ordreren skal indeholde: ");
               int ordernumber = scanner.nextInt();
               OrderList.addOrder(ordernumber);
               break; 
               
            case "done":
               System.out.println("Hvilken ordrer er done?");
               int sletnummer = scanner.nextInt();
               OrderList.completeOrder(sletnummer);
               System.out.println("Ordreren " + "" + sletnummer + "" + " er nu blevet markeret som done og gemt til statistikken");
               break; 
               
            case "delete":
               System.out.println("Hvilken ordrer skal slettes?");
               int deletenumber = scanner.nextInt();
               OrderList.deleteOrder(deletenumber);
               System.out.println("Ordren " + deletenumber + " er nu blevet markeret som slettet og er fjernet fra dell computeren");
               break;
               
            case "view":         
               OrderList.printOrders(OrderList.orderList, false);
               break;
               
            case "menu":
               int menuChoice;
               //loop in menu case
               do {
                  System.out.println("\nHvilken side af menuen vil du se? (1, 2, eller 3)");
                  menuChoice = scanner.nextInt();
                  Menu.addPizzamenu();
                  Menu.pizzaMenuCard(menuChoice);
               
                  System.out.println("\nVil du se en anden side? (y/n)");
               } while (scanner.next().equalsIgnoreCase("y"));
               break;
               
            case "statistik":
               Statistics.loadsavefile();
               if (Statistics.fileDoesNotExist == true){
                  System.out.println("Der er ikke nogen gemte ordre.");
                  Statistics.fileDoesNotExist = false;
                  break;
               }else{
               
                  System.out.println("Vil du se 1: omsaetningen, eller 2: mest populaere pizza");
                  stats();
                  break;
               }
            
            case "q":
               System.out.println("Tak for idag :)");
               System.exit(0);        
         }
      } while(true);
   }
   
   public static void stats(){
      int Numbers = 0;
      Numbers = scanner.nextInt();
      Statistics.mostSold();
      switch (Numbers){
                  
         case 1:
            do {
               System.out.println(Statistics.totalTurnover());
            
               System.out.println("\nVil du tilbage? (y/n)");
            } while (scanner.next().equalsIgnoreCase("n"));
            break;
            
         case 2:
            do {
               System.out.println(Menu.menu.get(Statistics.mostSoldPizza).name + " (" + Statistics.maxSold + ") ");
                     
               System.out.println("\nVil du tilbage? (y/n)");
            } while (scanner.next().equalsIgnoreCase("n"));
            break;
      }
   }
}