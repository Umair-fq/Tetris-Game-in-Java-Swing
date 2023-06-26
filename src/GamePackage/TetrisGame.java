package GamePackage;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

public class TetrisGame 
{
	private static WelcomeScreen welcome;
	private static TetrisFrame tetrisFrame;
	private static AudioSounds audioSounds = new AudioSounds();
	
	public static void start() 
	{
		tetrisFrame.setVisible(true);
		tetrisFrame.startGame();
	}
	

	
	public static void showStartUp() {
		welcome.setVisible(true);
	}
	
	public static void gameOver() {
		playGameOver();
		JOptionPane.showMessageDialog(tetrisFrame, "Game Over!");
	}
	
	public static void playClearLineSound() {
		audioSounds.playClearLine();
	}
	
	public static void playGameOver() {
		audioSounds.playGameOver();
	}
	
	public static void main(String[] args) 
	{
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tetrisFrame = new TetrisFrame();
					welcome = new WelcomeScreen();
					
					welcome.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	}
