import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class UI{
   
   static JFrame frame;
   static JFrame mFrame;
   static JFrame sFrame;
   static JFrame dFrame;
   static JPanel aPanel;
   static JPanel mPanel;
   public UI(){      
      frame();
   }
   
   public static void frame(){
      frame = new JFrame();
      frame.setSize(1920,1080);
      frame.setLocation(-10,0);
      frame.setTitle("Ordresystem");//temporary name
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      frame.setLayout(new GridLayout(1,Menu.menu.size()));
      
            
      
      //alfonsos panel
      aPanel = new JPanel();
      aPanel.setBackground(new Color(255,220,230));
      
      JButton addButton = new JButton("Ny ordre");
      addButton.setBackground(new Color(200,200,255));
      aPanel.add(addButton);
      
      //menu panel:  
      JPanel menuPanel = new JPanel();
      menuPanel.setBackground(Color.PINK);
      
      Menu.addPizzamenu();
      menuPanel.setLayout(new GridLayout(Menu.menu.size(), 1));
      for (int i = 0; i < Menu.menu.size(); i++){
         JButton button = new JButton((i + 1) + ". " + Menu.menu.get(i).name + ", " + Menu.menu.get(i).price + " kr");
         button.addActionListener(e ->{
            
         });
         menuPanel.add(button);
      }      
      

      
      //Marios panel            
      mPanel = new JPanel();
      mPanel.setBackground(new Color(255, 230, 220));
     
      JButton deleteButton = new JButton("slet");
      deleteButton.addActionListener(
         e ->{
            deleteOrderFrame();
         });
      mPanel.add(deleteButton);
     
      //Complete order button:
      JButton completeButton = new JButton ("færdig");
      mPanel.add(completeButton);
     
      //Statistics window button:
      JButton statisticsButton = new JButton("Statistik");
      statisticsButton.addActionListener(
         e ->{
            statisticsFrame();
         });
      
      mPanel.add(statisticsButton);
      //JSplitPane splitpane = new JSplitPane(SwingConstants.VERTICAL, aPanel, mPanel );
      //Dimension size = new Dimension();
      //int width = (int)size.getWidth();
      //splitpane.setDividerLocation(800);
      //frame.add(splitpane); 
      
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
   
   /*@Override   
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      //Rectangle rect = new Rectangle(700, 500);
      g.setColor(Color.WHITE);
      g.fillRect(100, 580, 100, 100);
   }*/
}