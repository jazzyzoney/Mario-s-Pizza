import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class UI{
   
   static JFrame aFrame;
   static JFrame mFrame;
   static JFrame sFrame;
   static JFrame dFrame;
   
   public UI(){      
      Dimension size = new Dimension();
      size = Toolkit.getDefaultToolkit().getScreenSize(); 
      int width = (int)size.getWidth(); 
      int height = (int)size.getHeight();
        //hmmm :/
      alfonsoFrame(width, height);
      marioFrame(width, height);
      //testFrame(width, height);
   }
   
   public static void testFrame(int width, int height){
      JFrame tFrame = new JFrame();
      tFrame.setVisible(true);
      tFrame.setSize(width,height);
   }
   
   public static void alfonsoFrame(int width, int height){
      aFrame = new JFrame();
      aFrame.setSize(width/2, height-36);
      aFrame.setLocation(-10,0);
      aFrame.setTitle("Håndter Ordrer");//temporary name
      aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      aFrame.setVisible(true);
      
      JPanel aPanel = new JPanel();
      aPanel.setBackground(new Color(70,70,70));
      
      
      JButton addButton = new JButton("Ny ordre");
      addButton.setBackground(new Color(200,200,255));
      aPanel.add(addButton);
      
      JButton deleteButton = new JButton("slet");
      deleteButton.addActionListener(e ->{
         deleteOrderFrame();
      });
      aPanel.add(deleteButton);
      
      JButton completeButton = new JButton ("færdig");
      aPanel.add(completeButton);
      
      aFrame.add(aPanel);
   }

   public static void deleteOrderFrame(){
      dFrame = new JFrame();
      dFrame.setSize(400,150);
      dFrame.setVisible(true);
      dFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      dFrame.setLocationRelativeTo(aFrame);
      
      JPanel dPanel = new JPanel();
      JButton yButton = new JButton ("ja");
      yButton.addActionListener(e -> {
         //yes button pressed:
      });
      dPanel.add(yButton);
      
      JButton nButton = new JButton ("nej");
      nButton.addActionListener(e -> {
         //no button pressed:
      });
      dPanel.add(nButton);
      
      dFrame.add(dPanel);
   }
   
   public static void marioFrame(int width, int height){
      mFrame = new JFrame();
      mFrame.setSize(width/2, height-36);
      mFrame.setTitle("Ordrer");//temporary name
      mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mFrame.setVisible(true);
      mFrame.setLocation(width/2,0);
      
      JPanel mPanel = new JPanel();
      JButton statisticsButton = new JButton("Statistik");
      statisticsButton.addActionListener(e ->{
         statisticsFrame();
      });
      
      mPanel.add(statisticsButton);
      mFrame.add(mPanel);
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