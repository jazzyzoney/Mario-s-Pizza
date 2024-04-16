import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

import java.util.ArrayList;

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
            for (int i = 0; i< pizzaList.size(); i ++){
               order.pizzaList.add(Menu.menu.get(pizzaList.get(i)));
            }
            OrderList.orderList.add(order);         
            pizzaList.clear();
         }
         
         frame.removeAll();//refresh
         frame();
      });
            
      aPanel.add(addButton, BorderLayout.SOUTH);
      
      JPanel textPanel = new JPanel();
      textPanel.setBackground(new Color(189,201,165));
      textPanel.setLayout(new GridLayout(20, 1));
      
      JLabel instrLabel1 = new JLabel("     1. Tryk på menukortet, for at tilføje pizzaer.");
      JLabel instrLabel2 = new JLabel("     2. Tryk på [Godkend ordre]-knappen for at godkende ordren");
      JLabel instrLabel3 = new JLabel("     3. Tryk på [Færdiggør ordre] for at fjerne ordren fra ordrelisten."); 
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
      mPanel.setBackground(new Color(237,165,145));//find en bedre grøn.
      mPanel.setLayout(new BorderLayout());//new GridLayout(10,1));
      
      //mario orderPanel header:
      JPanel mHeaderPanel = new JPanel();
      mHeaderPanel.setLayout(new BorderLayout());
      
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
         
      //add Order orderPanels:
      for (int i = 0; i < OrderList.orderList.size(); i++){         
         JPanel orderPanel = new JPanel();//Contains an order.
         orderPanel.setBackground(Color.PINK);
         orderPanel.setLayout(new BorderLayout());
         
         JLabel orderNameLabel = new JLabel();
         orderNameLabel.setText("" + OrderList.orderList.get(i).name);
         orderPanel.add(orderNameLabel, BorderLayout.NORTH);
         
         JPanel pizzaPanel = new JPanel();//Contains a list of pizzas.
         pizzaPanel.setLayout(new BoxLayout(pizzaPanel, BoxLayout.Y_AXIS));
         
         for (int j = 0; j< OrderList.orderList.get(i).pizzaList.size(); j++){
            JLabel pizzaLabel = new JLabel(OrderList.orderList.get(i).pizzaList.get(j).name);
            pizzaPanel.add(pizzaLabel, BorderLayout.CENTER);
         }
         
         orderPanel.add(pizzaPanel);

         JPanel orderButtonPanel = new JPanel ();//contains complete and delete buttons
         orderButtonPanel.setLayout(new BorderLayout());
         
         JPanel orderButtonNorthPanel = new JPanel();
         orderButtonNorthPanel.setLayout(new GridLayout(2,1));
         
         //Delete order button:
         JButton deleteButton = new JButton("Anuller");
         final int finalpanelNo = i;
         deleteButton.addActionListener(
            e ->{
               deleteOrderFrame();
               panelNo = finalpanelNo;//order panel number = i.
            });
         orderButtonNorthPanel.add(deleteButton);
         
         
         JButton completeButton = new JButton ("Færdig");
         completeButton.addActionListener(e-> {
            OrderList.completeOrder(OrderList.orderCounter);
            frame.removeAll();
            frame();
         });
         orderButtonNorthPanel.add(completeButton);
         
         orderButtonPanel.add(orderButtonNorthPanel, BorderLayout.NORTH);
         orderPanel.add(orderButtonPanel, BorderLayout.EAST);
         displayOrdersPanel.add(orderPanel);
      }//end of for loop. Order panels added.
      
      mPanel.add(displayOrdersPanel);
   }

   public static void deleteOrderFrame(){
      dFrame = new JFrame();
      dFrame.setSize(400,150);
      dFrame.setVisible(true);
      dFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      dFrame.setLocationRelativeTo(frame);
      
      JPanel dPanel = new JPanel();
      JButton yButton = new JButton ("ja");
      
      //yes-button pressed. Order removed from orderList.
      yButton.addActionListener(
         e -> {
            OrderList.orderList.remove(panelNo);//Fejl heromkring!! Noget med index. 
            frame.removeAll();
            frame();
         });
      dPanel.add(yButton);
      
      
      JButton nButton = new JButton ("nej");
      //"nej"-button pressed:
      nButton.addActionListener(
         e -> {
            dFrame.dispose();
         });
      dPanel.add(nButton);
      
      dFrame.add(dPanel);
   }
   
   
   public static void statisticsFrame(){
      sFrame = new JFrame();
      sFrame.setSize(1000,800);
      sFrame.setVisible(true);
      sFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      sFrame.setLocationRelativeTo(null);
      sFrame.setTitle("Statistik");
   }
}