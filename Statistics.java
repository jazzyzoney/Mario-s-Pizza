import java.util.*;

public class Statistics{

   //variable to store the total turnover of the store
   private static int totalTurnover = 0;

   //variable to store the name of the most popular pizza
   private static String mostPopularPizza = null;
   
   //variable to store the number of times the most popular pizza was sold
   private static int mostPopularPizzaCount = 0;

   //method to calculate the total turnover from all orders
   public static int turnover() {
      return totalTurnover;
   }

   //method to update the statistics for a new order
   public static void updateStatistics(ArrayList<Pizza> order) {
      //calculate the order total
      int orderTotal = 0;
      for (Pizza pizza : order) {
         orderTotal += pizza.price;
         
         //update most popular pizza statistics (simplified)
         if (pizza.number == mostPopularPizzaCount || mostPopularPizza == null) {
            mostPopularPizza = pizza.name;
            mostPopularPizzaCount++;
         } else if (pizza.number > mostPopularPizzaCount) {
            mostPopularPizza = pizza.name;
            mostPopularPizzaCount = pizza.number;
         }
      }
      //adding order total to the overall turnover
      totalTurnover += orderTotal;
   }
   
   //method to help find how many times a specific pizza appears in all orders
   private static int countPizzaInOrders(Pizza pizza) {
      int count = 0;
      for (ArrayList<Pizza> order : Orders.orderList) {
         for (Pizza p : order) {
            if (p.name.equals(pizza.name)) {
               count++;
            }
         }
      }
      return count;
   }

   //method that returns the name of the most popular pizza
   public static String favoritePizza() {
      if (mostPopularPizza == null) {
         return "No orders placed yet."; //ved ikke om den her metode er noget vi vil inkludere
      } else {
         return mostPopularPizza;
      }
   }
}