package ttt;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Icon;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class howtoplay extends JDialog implements Runnable
{
	
	JLabel lblHowToPlay;
	Thread t;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					howtoplay dialog = new howtoplay();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public howtoplay() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				t.stop();
			}
		});
		setBounds(100, 100, 667, 549);
		getContentPane().setLayout(null);
		setModal(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 650, 510);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		try
		{
		//BufferedImage img=ImageIO.read(getClass().getResourceAsStream("taskicon.png"));
			ImageIcon img=new ImageIcon("kattam.png");
		    setIconImage(img.getImage());
		}
		catch(Exception e)
		{
			
		}
		/*JLabel label_2 = new JLabel(new ImageIcon("whitebg.png"));
		label_2.setBounds(213, 56, 201, 91);
		panel.add(label_2);
		label_2.setBackground(Color.white);
		
		JLabel label_3 = new JLabel(new ImageIcon("whitebg.png"));
		label_3.setBounds(210, 0, 204, 33);
		panel.add(label_3);
		label_3.setBackground(Color.white);*/
		
		lblHowToPlay = new JLabel("How to play Kattam kuttam");
		lblHowToPlay.setFont(new Font("Myriad Pro Light", Font.PLAIN, 17));
		lblHowToPlay.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowToPlay.setBounds(211, 34, 204, 22);
		panel.add(lblHowToPlay);
		
		JTextArea textArea = new JTextArea();
		JScrollPane scroll =new JScrollPane(textArea);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		scroll.setBounds(10, 148, 630, 320);
		panel.add(scroll);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t.stop();
				dispose();
			}
		});
		btnOk.setBounds(519, 479, 89, 23);
		panel.add(btnOk);
		
		
		String s="    Kattam kuttam is a fun game that you can play any time and anywhere as long as you have a piece of paper, a pencil, and an opponent. Tic-tac-toe is a zero sum game, which means that if both players are playing their best, that neither player will win. However, if you learn how to play tic-tac-toe and master some simple strategies, then you'll be able to not only play, but to win the majority of the time. If you want to know how to play tic-tac-toe, then see Step 1 to get started."
				+"\n ************************************** Double Player***********************************"+
				"\n1.Have the first player go first.Though traditionally, the first player goes with 'X', you can allow the first player to decide whether he wants to go with 'X's or 'O's. These symbols will be placed on the table, in the attempt to have three of them in a row."
				+"\n\n  2. If you're going first, then the best move you can make is to move into the center. This will maximize your chances of winning, since you'll be able to create a row of three 'X's or 'O's in more combinations (4) this way than if you chose a different square."
				+"\n\n  3. Have the second player go second.After the first player goes, then the second player should put down his symbol, which will be different from the symbol of the first player. "
				+"\n\n  4. The second player can either try to block the first player from creating a row of three, or focus on creating his or her own row of three. Ideally, the player can do both."
				+"\n\n  5. Keep alternating moves until one of the players has drawn a row of three symbols or until no one can win. The first player to draw three of his or her symbols in a row, whether it is horizontal, vertical, or diagonal, has won tic-tac-toe."
				+"\n\n  6. However, if both players are playing with optimal strategy, then there's a good chance that no one will win because you will have blocked all of each other's opportunities to create a row of three."
				+"\n\n\n\n    ************************************** Single Player***********************************  "
				+"\n\n1. There are six level in the game i.e. very easy, easy, comfort ,medium ,hard & impossible level. the level are according to the name "
				+"\n\n2. if toss is won by bot the the best move is mapped to the game pallete. After the first player goes, then the second player should put down his symbol , which will be different from the symbol of the first player.  "
				+"\n\n3. the chance of computer is played by a bot which thinks all steps according to the selected level by user of the game and then played so play seriously by thinking few steps in mind "
				+"\n\n4. The computer can either try to block the you from creating a row of three, or focus on creating its own row of three. Ideally, the player can do both."
				+"\n\n5. Keep alternating moves until one of the players has drawn a row of three symbols or until no one can win. The first player to draw three of his or her symbols in a row, whether it is horizontal, vertical, or diagonal, has won tic-tac-toe."
				+"\n\n6. However, if both players are playing with optimal strategy, then there's a good chance that no one will win because you will have blocked all of each other's opportunities to create a row of three."
				+"\n\n\n     ************************************** Tips to Becoming Expert*********************************** "
				+"\n\n #1. Make the best first move. The best move, if you go first, is to go in the center. There are no ifs, ands, or buts about it. If you go in the middle, you will have the highest chance of winning the game."
				+"\n\n #2. if you let your opponent go there, you will have the highest chance of losing. And you don't want that, do you?If you don't go in the center, your next best move is to go in one of the four corners. That way, if your opponent does not choose the center (and a novice player may not), then you have a highchance of winning."
				+"\n\n #3. Avoid the edges as a first move. The edges are the four boxes that are neither the center or the corner. If you go here first, you will have the smallest chance of winning."
				+"\n\n #4. React appropriately if the other player goes first."
				+"\n\n #5. If the other player goes first and does not go in the center, then you should go in the center. But if the other player does go in the center, then your best bet is to place your symbol on one of the corner squares."
				+"\n\n #6. Follow the right, left, above, and below strategy."
				+"\n\n #7. This is another sure-fire strategy that will help you win the game. When your opponent makes a mark, see if you can place your symbol to the right of his symbol. If you can't, then see if you can place it to the left. If you can't, then move it above your opponent's symbol. And finally, if that doesn't work, see if you can move your mark below your opponent's. This strategy ensures that you'll be most successful at optimizing your position and blocking your opponent from scoring"
				+"\n\n #8. Use the three-corner strategy."
				+"\n\n #9. Another strategy for winning the game of tic-tac-toe is to place your symbols in three of the four corners of the board. This can optimize your chances of getting three in a row because you'll be able to create a diagonal row or rows along the sides of the grid. This will work if your opponent does not completely thwart you, of course."
				+"\n\n #10. Play maximum time against a computer with moving towards more difficult level. "
				+"\n\n #11.If you really want to up your strategy and make sure that you never lose, then it's best to play as much as you can instead of memorizing a list of strategies. You can find computer's IMPOSSIBLE LEVEL that can play against you and will quickly be able to play a game where you never lose (even if you can't win) WHICH WILL MAKE YOU A STRONGER AND TERRIFIC PLAYER";
				
		textArea.setText(s);
		
		JLabel label = new JLabel(new ImageIcon("Tic_Tac_Toe.gif"));
		label.setBounds(414, 0, 228, 150);
		panel.add(label);
		
		JLabel label_1 = new JLabel(new ImageIcon("Tic_Tac_Toe.gif"));
		label_1.setBounds(5, 0, 209, 150);
		panel.add(label_1);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(118, 483, 46, 14);
		panel.add(label_4);
	
		t=new Thread(this,"blinkthread");
		t.start();
		
		
		

	}

	@Override
	public void run() 
	{
		long c=0;
		while(true)
		{
			if(c%2==0)
			 lblHowToPlay.setForeground(Color.RED);
			else
			 lblHowToPlay.setForeground(Color.BLACK);
			c++;
			try 
			{
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
