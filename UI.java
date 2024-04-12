import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class UI{
   
   static JFrame frame;
   static JPanel aPanel;
   static JPanel mPanel;
   
   static JFrame sFrame;
   static JFrame dFrame;

   
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

      //alfonsos panel
      aPanel = new JPanel();
      aPanel.setLayout(new BorderLayout());
      
      JPanel aHeaderPanel = new JPanel ();
      
      JLabel aLabel = new JLabel();
      aLabel.setText("Ny ordre");
      aHeaderPanel.add(aLabel);
      
      aPanel.add(aHeaderPanel, BorderLayout.NORTH);
      
      JButton addButton = new JButton("Godkend ordre");
      addButton.setBackground(new Color(200,200,255));
      aPanel.add(addButton, BorderLayout.SOUTH);
      
      JPanel textPanel = new JPanel();
      textPanel.setBackground(new Color(189,201,165));
      textPanel.setLayout(new GridLayout(20, 1));
      
      JLabel instrLabel1 = new JLabel(" 1. Tryk på menukortet, for at tilføje pizzaer.");
      JLabel instrLabel2 = new JLabel(" 2. Tryk på [Godkend ordre]-knappen for at godkende ordren");
      JLabel instrLabel3 = new JLabel(" 3. Tryk på [Færdiggør ordre] for at fjerne ordren fra ordrelisten."); 
      JLabel instrLabel4 = new JLabel(" 4. Tryk på [Annuller] for at anullere ordren");
      
      textPanel.add(instrLabel1);
      textPanel.add(instrLabel2);
      textPanel.add(instrLabel3);
      textPanel.add(instrLabel4);
      
      aPanel.add(textPanel, BorderLayout.CENTER);
      
      //menu panel:  
      JPanel menuPanel = new JPanel();
      menuPanel.setBackground(Color.WHITE);
      
      Menu.addPizzamenu();
      menuPanel.setLayout(new GridLayout(Menu.menu.size(), 1));
      for (int i = 0; i < Menu.menu.size(); i++){
         JButton button = new JButton((i + 1) + ". " + Menu.menu.get(i).name + ", " + Menu.menu.get(i).price + " kr");
         
         if (i % 2 == 1){
            button.setBackground(Color.WHITE);
         }else{
            button.setBackground(new Color(250,245,240));
         }//mvc : model view controller.
         //implements serializable
         //scroller: lave en container.
         
         button.addActionListener(e ->{
            //add addPizza-action.
         });
         menuPanel.add(button);
      }      
      
      //Marios panel            
      mPanel = new JPanel();
      mPanel.setBackground(new Color(237,165,145));//find en bedre grøn.
      mPanel.setLayout(new GridLayout(10,1));
      
      //mario panel header:
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
      
      mPanel.add(mHeaderPanel);
      
      Orders order = new Orders("pizzaa");
      order.pizzaList.add(Menu.menu.get(1));
         
      //add Order panels:
      for (int i = 0; i < OrderList.orderList.size(); i++){         
         JPanel panel = new JPanel();
         panel.setBackground(Color.PINK);
         panel.setLayout(new BorderLayout());
         
         JLabel label = new JLabel();
         label.setText(order.name);
         
         panel.add(label);
         mPanel.add(panel);
         
         JPanel orderButtonPanel = new JPanel ();
         orderButtonPanel.setLayout(new GridLayout(2, 1));
         
         JButton deleteButton = new JButton("Anuller");
         deleteButton.addActionListener(e ->{
            deleteOrderFrame();
         });
         orderButtonPanel.add(deleteButton);
     
         JButton completeButton = new JButton ("Færdiggør ordre");
         orderButtonPanel.add(completeButton);
         panel.add(orderButtonPanel, BorderLayout.EAST);
      }
      
      frame.add(aPanel);
      frame.add(menuPanel);
      frame.add(mPanel);
   }

   public static void deleteOrderFrame(){
      dFrame = new JFrame();
      dFrame.setSize(400,150);
      dFrame.setVisible(true);
      dFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      dFrame.setLocationRelativeTo(frame);
      
      JPanel dPanel = new JPanel();
      JButton yButton = new JButton ("ja");
      yButton.addActionListener(
         e -> {
         //yes button pressed:
         });
      dPanel.add(yButton);
      
      JButton nButton = new JButton ("nej");
      nButton.addActionListener(
         e -> {
         //no button pressed:
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