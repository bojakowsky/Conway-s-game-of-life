package my.game.applet;

import java.awt.*;


import javax.swing.*;
 
// Swing Program Template
@SuppressWarnings("serial")
public class GameOfLife_JPanel extends JPanel {
   // Name-constants
   public static final int CANVAS_WIDTH = 640;
   public static final int CANVAS_HEIGHT = 480;
   public static final String TITLE = "...Title...";
   GameOfLife map = new GameOfLife();
   ///////////////////////////////
   private Image dbImage;
   private Graphics dbg;
   ////////////////////////////
 
   /** Constructor to setup the GUI components */
   public GameOfLife_JPanel() {
      setPreferredSize(new Dimension(map.getWidth()+25, map.getHeight()+25));
     
      map.RandomMap();
  
   }
 
   /** Custom painting codes on this JPanel */
   public void drawGame(Graphics g){
	   setBackground(Color.WHITE);
	   for (int i = 0 ; i < map.getWidth(); i++){
		   for (int j = 0 ; j < map.getHeight();j++){
			   if (map.getArray()[i][j] == Boolean.TRUE)
				   g.drawString(".", i, j);	
		   }
	   }
	    
   }
	     
   public void paintComponent(Graphics g) {
	   ///super.paintComponent(g);  
	   dbImage = createImage(map.getWidth(),map.getHeight());
	   dbg = dbImage.getGraphics();
	   ///if(dbg==g)System.out.println("check");
	   drawGame(dbg);
	   map.GameStart();
	   g.drawImage(dbImage, 0,0,this);
	   repaint(2);
	    
	   }
   /** The entry main() method */
   
  /* public static void main(String[] args) {
      // Run GUI codes in the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            JFrame frame = new JFrame("Game of Life retarded");
            frame.setContentPane(new GameOfLife_JPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();             // "this" JFrame packs its components
            frame.setLocationRelativeTo(null); // center the application window
            frame.setVisible(true);            // show it
            RepaintManager.currentManager(null).setDoubleBufferingEnabled(true);
         }
      });
   } */
}