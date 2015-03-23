package my.game.applet;

import javax.swing.JApplet;
import javax.swing.SwingUtilities;

public class GameOfLife_Applet extends JApplet {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private GameOfLife_JPanel panel;
		@Override
		public void init() {
			setSize(800,620);
			super.init();
			SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run(){
					initGUI();
				}
			});
			stop();
			destroy();
		}
		private void initGUI(){
			//addComponentListener(this);
			panel = new GameOfLife_JPanel();
			add(panel);

			}
}

