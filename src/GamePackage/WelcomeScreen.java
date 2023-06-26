package GamePackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class WelcomeScreen extends JFrame {

	private JPanel contentPane;


	public WelcomeScreen() {
		getContentPane().setBackground(new Color(153, 50, 204));
		setTitle("Welcome to Tetris Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Tetris Game");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(111, 11, 261, 30);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Start Game");
		btnNewButton.setBackground(new Color(105, 105, 105));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TetrisGame.start();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(166, 80, 145, 30);
		getContentPane().add(btnNewButton);
		
		JButton btnQuitGame = new JButton("Quit Game");
		btnQuitGame.setBackground(new Color(105, 105, 105));
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitGame.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnQuitGame.setBounds(166, 159, 145, 30);
		getContentPane().add(btnQuitGame);
	}

}
