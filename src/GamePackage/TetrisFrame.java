package GamePackage;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;

public class TetrisFrame extends JFrame {

	private JPanel contentPane;
	JLabel lblScore, lblLevel;
	JButton btnMainMenu;
	

	private GamePlay gamePlay;
	private TetrisThreads thread;
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TetrisFrame frame = new TetrisFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	

	public TetrisFrame() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("Tetris Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 30, 773, 634);
		getContentPane().setLayout(null);
		contentPane = new JPanel();

		
		JPanel panel = new JPanel();
		panel.setBounds(261, 11, 250, 520);
		getContentPane().add(panel);
		gamePlay = new GamePlay(panel, 10);
		
		 btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.interrupt();
				setVisible(false);
				TetrisGame.showStartUp();
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMainMenu.setBackground(new Color(153, 50, 204));
		btnMainMenu.setBounds(10, 11, 135, 33);
		getContentPane().add(btnMainMenu);
		btnMainMenu.setFocusable(false);

		
		lblScore = new JLabel("Score: 0");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblScore.setBounds(590, 43, 137, 31);
		getContentPane().add(lblScore);
		
		lblLevel = new JLabel("Level: 1");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLevel.setBounds(590, 124, 150, 31);
		getContentPane().add(lblLevel);
		this.add(gamePlay);
		gamePlay.setSize(250, 520);
		gamePlay.setLocation(236, 36);
		
		
		getContentPane().add(gamePlay);
		controls() ;
		
	}
	
	public void startGame() {
		gamePlay.background();
		thread = new TetrisThreads(gamePlay, this);
		thread.start();
	}
	
	private void controls() 
	{
		InputMap input = this.getRootPane().getInputMap();
		ActionMap action = this.getRootPane().getActionMap();
		
		input.put(KeyStroke.getKeyStroke("RIGHT"), "right");
		input.put(KeyStroke.getKeyStroke("LEFT"), "left");
		input.put(KeyStroke.getKeyStroke("UP"), "up");
		input.put(KeyStroke.getKeyStroke("DOWN"), "down");
		
		action.put("right", new AbstractAction() 
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gamePlay.rightMovement();
			}
			
		}
		);
		
		action.put("left", new AbstractAction() 
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gamePlay.leftMovement();
			}
			
		}
		);
		
		action.put("up", new AbstractAction() 
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gamePlay.doRotation();
			}
			
		}
		);
		
		action.put("down", new AbstractAction() 
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gamePlay.downMovement();
			}
			
		}
		);
	}
	
	public void maintainScore(int score) 
	{
		lblScore.setText("Score: "+ score);
	}
	
	public void maintainLevel(int level) 
	{
		lblLevel.setText("Level: "+ level);
	}
}
