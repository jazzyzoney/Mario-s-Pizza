import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

import java.util.ArrayList;
import java.util.Date;

public class UI{
   
   static JFrame frame;
   static JFrame sFrame;
   static JFrame dFrame;
   
   static JPanel aPanel;
   static JPanel menuPanel;
   static JPanel mPanel;

   static ArrayList <Integer> pizzaList = new ArrayList <Integer>();
   static int panelNo;
   
   public UI(){      
      frame();
   }
   
   public static void frame(){     
      frame = new JFrame();
      Dimension size = new Dimension();
      int width = (int)size.getWidth();
      int height = (int) size.getHeight();
      
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame.setTitle("Ordresystem");//temporary name
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      frame.setLayout(new GridLayout(1,Menu.menu.size()));
      
      aPanel();
      menuPanel();
      mPanel(); 
            
      frame.add(aPanel);
      frame.add(menuPanel);
      frame.add(mPanel);
   }
   
   public static void aPanel(){
      aPanel = new JPanel();
      aPanel.setLayout(new BorderLayout());
      
      JPanel aHeaderPanel = new JPanel ();
      
      JLabel aLabel = new JLabel();
      aLabel.setText("Ny ordre");
      aHeaderPanel.add(aLabel);
      
      aPanel.add(aHeaderPanel, BorderLayout.NORTH);
      
      JButton addButton = new JButton("Godkend ordre");
      addButton.setBackground(Color.WHITE);
      
      //Add order:
      addButton.addActionListener(e ->{
         if(pizzaList.size() != 0){
            OrderList.orderCounter ++;
            Orders order = new Orders(OrderList.orderCounter);
            OrderList.currentDate = new Date();
            order.startTime = ("" + OrderList.date.format(OrderList.currentDate));
            
            for (int i = 0; i< pizzaList.size(); i ++){
               order.pizzaList.add(Menu.menu.get(pizzaList.get(i)));
            }
            OrderList.orderList.add(order);         
            pizzaList.clear();
         }
         
         frame.dispose();
         frame();
         
      });
            
      aPanel.add(addButton, BorderLayout.SOUTH);
      
      JPanel textPanel = new JPanel();
      //textPanel.setBackground(new Color(189,201,165));
      textPanel.setBackground(new Color(204,235,197));
      textPanel.setBackground(new Color(191, 223, 217));
      textPanel.setLayout(new GridLayout(20, 1));
      
      JLabel instrLabel1 = new JLabel("     1. Tryk på menukortet, for at tilføje pizzaer.");
      JLabel instrLabel2 = new JLabel("     2. Tryk på [Godkend ordre]-knappen for at godkende ordren");
      JLabel instrLabel3 = new JLabel("     3. Tryk på [Færdig] for at fjerne ordren fra ordrelisten. Ordren gemmes i statistikken."); 
      JLabel instrLabel4 = new JLabel("     4. Tryk på [Annuller] for at anullere ordren");
      
      textPanel.add(instrLabel1);
      textPanel.add(instrLabel2);
      textPanel.add(instrLabel3);
      textPanel.add(instrLabel4);
      
      aPanel.add(textPanel, BorderLayout.CENTER);
   }
   
   public static void menuPanel(){
      menuPanel = new JPanel();
      menuPanel.setBackground(Color.WHITE);
      
      //Menu.addPizzamenu();
      menuPanel.setLayout(new GridLayout(Menu.menu.size(), 1));
      menuPanel.setBackground(Color.WHITE);
      for (int i = 0; i < Menu.menu.size(); i++){
         JButton button = new JButton((i + 1) + ". " + Menu.menu.get(i).name + ", " + Menu.menu.get(i).price + " kr");
         
         if (i % 2 == 1){
            button.setBackground(Color.WHITE);
         }else{
            button.setBackground(new Color(250,245,240));
         }
         
         final int pizzaNo = i;
         button.addActionListener(
            e ->{
                pizzaList.add(pizzaNo);
            });
         menuPanel.add(button);
      }    
   }
   
   public static void mPanel(){
      //Marios orderPanel            
      mPanel = new JPanel();
      mPanel.setBackground(new Color(237,165,145));
      mPanel.setLayout(new BorderLayout());//new GridLayout(10,1));
      
      //mario orderPanel header:
      JPanel mHeaderPanel = new JPanel();
      mHeaderPanel.setLayout(new BorderLayout());
      mHeaderPanel.setBackground(Color.WHITE);
      
      JButton statisticsButton = new JButton("Statistik");
      statisticsButton.addActionListener(
         e ->{
            statisticsFrame();
         });
      mHeaderPanel.add(statisticsButton, BorderLayout.EAST);
      
      JPanel gapPanel = new JPanel();
      gapPanel.setBackground(Color.BLACK);
      mHeaderPanel.add(gapPanel, BorderLayout.SOUTH);
      
      JLabel orderLabel = new JLabel("ORDRER: ");
      mHeaderPanel.add(orderLabel);
      
      mPanel.add(mHeaderPanel, BorderLayout.NORTH);
      
      JPanel displayOrdersPanel = new JPanel();
      displayOrdersPanel.setLayout(new BoxLayout(displayOrdersPanel, BoxLayout.Y_AXIS));//panel which contains all order panels.
      displayOrdersPanel.setBackground(Color.WHITE);
      
      //add Order orderPanels:
      for (int i = 0; i < OrderList.orderList.size(); i++){         
         JPanel orderPanel = new JPanel();//Contains an order.
         orderPanel.setBackground(Color.PINK);
         orderPanel.setLayout(new BorderLayout());
         
         //contains order number and time.
         JPanel orderHeaderPanel = new JPanel();
         orderHeaderPanel.setLayout(new BorderLayout());
         orderHeaderPanel.setBackground(Color.PINK);
         
         JLabel orderNameLabel = new JLabel();
         orderNameLabel.setText("" + OrderList.orderList.get(i).name);
         orderHeaderPanel.add(orderNameLabel, BorderLayout.WEST);
         
         JLabel orderTimeLabel = new JLabel();
         orderTimeLabel.setText(OrderList.orderList.get(i).startTime + "         ");
         orderHeaderPanel.add(orderTimeLabel, BorderLayout.EAST);
         
         orderPanel.add(orderHeaderPanel, BorderLayout.NORTH);
         
         JPanel pizzaPanel = new JPanel();//Contains a list of pizzas.
         pizzaPanel.setLayout(new BoxLayout(pizzaPanel, BoxLayout.Y_AXIS));
         pizzaPanel.setBackground(Color.WHITE);
         
         for (int j = 0; j< OrderList.orderList.get(i).pizzaList.size(); j++){
            JLabel pizzaLabel = new JLabel(OrderList.orderList.get(i).pizzaList.get(j).name);
            pizzaPanel.add(pizzaLabel, BorderLayout.CENTER);
         }
         
         orderPanel.add(pizzaPanel);

         JPanel orderButtonPanel = new JPanel ();//contains complete and delete buttons
         orderButtonPanel.setLayout(new BorderLayout());
         orderButtonPanel.setBackground(Color.WHITE);
         
         JPanel orderButtonNorthPanel = new JPanel();
         orderButtonNorthPanel.setLayout(new GridLayout(2,1));
         orderButtonNorthPanel.setBackground(Color.WHITE);
         
         //Delete order button:
         JButton deleteButton = new JButton("Anuller");
         final int finalpanelNo = i;
         deleteButton.addActionListener(
            e ->{
               deleteOrderFrame();
               panelNo = finalpanelNo;//order panel number = i.
            });
         orderButtonNorthPanel.add(deleteButton);
         
         // complete order button:
         JButton completeButton = new JButton ("Færdig");
         completeButton.addActionListener(e-> {
            panelNo = finalpanelNo + 1;
            OrderList.completeOrder(panelNo);
            //frame.removeAll();
            frame.dispose();
            frame();
         });
         orderButtonNorthPanel.add(completeButton);
         
         orderButtonPanel.add(orderButtonNorthPanel, BorderLayout.NORTH);
         orderPanel.add(orderButtonPanel, BorderLayout.EAST);
         displayOrdersPanel.add(orderPanel);
      }//end of for loop. Order panels added.
      
      JScrollPane scrollPane = new JScrollPane(displayOrdersPanel);
      
      mPanel.add(scrollPane);
   }

   public static void deleteOrderFrame(){
      dFrame = new JFrame();
      dFrame.setSize(400,150);
      dFrame.setVisible(true);
      dFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      dFrame.setLocationRelativeTo(frame);
      
      JPanel dPanel = new JPanel();
      dPanel.setLayout(new GridLayout(2,1));
      dPanel.setBackground(Color.WHITE);
      
      
      JPanel labelPanel = new JPanel();
      labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
      labelPanel.setBackground(Color.WHITE);
      
      JLabel deleteLabel = new JLabel();
      JLabel deleteLabel2= new JLabel();

      deleteLabel.setText("        Vil du slette ordren?");
      deleteLabel2.setText("        Den vil ikke blive gemt.");
      labelPanel.add(deleteLabel);
      labelPanel.add(deleteLabel2);
      
      dPanel.add(labelPanel);
      
      JPanel buttonPanel = new JPanel();
      buttonPanel.setBackground(Color.WHITE);
      
      JButton yButton = new JButton ("ja");
      
      //yes-button pressed. Order removed from orderList.
      yButton.addActionListener(
         e -> {
            OrderList.orderList.remove(panelNo);
            frame.removeAll();
            frame();
         });
      buttonPanel.add(yButton);
      
      
      JButton nButton = new JButton ("nej");
      //"nej"-button pressed:
      nButton.addActionListener(
         e -> {
            dFrame.dispose();
         });
      buttonPanel.add(nButton);
      
      dPanel.add(buttonPanel);
      dFrame.add(dPanel);
   }
   
   
   public static void statisticsFrame(){
      sFrame = new JFrame();
      sFrame.setSize(1000,800);
      sFrame.setVisible(true);
      sFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      sFrame.setLocationRelativeTo(null);
      sFrame.setTitle("Statistik");
      
      JPanel sPanel = new JPanel();
      sPanel.setLayout(new GridLayout(1,2));
      sPanel.setBackground(Color.RED);
      
      //load save file
      Statistics.loadsavefile();
      Statistics.mostSold();

      
      JPanel statisticsPanel = new JPanel();
      statisticsPanel.setLayout(new GridLayout(20,1));
      statisticsPanel.setBackground(Color.WHITE);
      
      //dato (fra - til)
      JLabel datesLabel1 = new JLabel();
      JLabel datesLabel2 = new JLabel();
      datesLabel1.setText("   Fra: " + Statistics.completedOrders.get(0).completedTime);
      datesLabel2.setText("   Til: " + Statistics.completedOrders.get(Statistics.completedOrders.size() - 1).completedTime);
      
      statisticsPanel.add(datesLabel1);
      statisticsPanel.add(datesLabel2);
      
      //total turnover
      JLabel turnoverLabel = new JLabel("   Omsætning: " + Statistics.totalTurnover());
      statisticsPanel.add(turnoverLabel);
      //pizzas sold
      JLabel totalSoldLabel = new JLabel("   Pizzaer solgt i alt: " + Statistics.totalSold);
      statisticsPanel.add(totalSoldLabel);
      
      //mest populære
      JLabel mostSoldLabel = new JLabel("   Mest solgte pizza: " + Menu.menu.get(Statistics.mostSoldPizza).name);
      sPanel.add(statisticsPanel);
      
      
      
      //Viser menukort, og hvor mange, som er blevet solgt.
      JPanel menuPanel = new JPanel ();
      menuPanel.setLayout(new GridLayout(Menu.menu.size(), 1));
      menuPanel.setBackground(Color.PINK);
            
      //menu is printed.
      for (int i = 0 ; i < Menu.menu.size() ; i++){
         JPanel menuLabelPanel = new JPanel();
         menuLabelPanel.setLayout(new BorderLayout());
         
         if (i % 2 == 1){
            menuLabelPanel.setBackground(Color.WHITE);
         }else{
            menuLabelPanel.setBackground(new Color(250,245,240));
         }
         
         //how many of each item on the menu has been sold:
         JLabel soldLabel = new JLabel();
         soldLabel.setText(Statistics.mostSoldList[i] + "      ");
         menuLabelPanel.add(soldLabel, BorderLayout.EAST);
         
         JLabel menuLabel = new JLabel("  " + (i + 1) + ". " + Menu.menu.get(i).name + ", " + Menu.menu.get(i).price + " kr");
         menuLabelPanel.add(menuLabel, BorderLayout.WEST);
         menuPanel.add(menuLabelPanel);
      }
      
      sPanel.add(menuPanel);
      sFrame.add(sPanel);
      
   }
}