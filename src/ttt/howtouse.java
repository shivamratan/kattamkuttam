package ttt;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JCheckBox;

public class howtouse extends JDialog implements Runnable {

	/**
	 * Launch the application.
	 */
	Thread t;
	JLabel lblClickMoreButton;
	private JLabel lblStep;
	private JLabel lblClickTheNew;
	private JLabel lblPlayerGame;
	private JLabel lblStep_1;
	private JLabel lblThenChooseThe;
	private JLabel lblStep_2;
	private JLabel lblThenEnterThe;
	private JLabel lblChooseNo;
	private JLabel lblStep_3;
	private JLabel lblatLastToss;
	private JLabel lblStep_4;
	private JLabel lblInTheInterval;
	private JLabel lblTheGameTo;
	morefocus mf;
	 JLabel lblForMoreInformation;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					howtouse dialog = new howtouse();
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
	public howtouse() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				mf.fc.stop();
				t.stop();
			}
		});
		setBounds(800, 200, 482, 341);
		//setBounds(ob.frame.getX()+320,ob.frame.getY()+200,482,331);
		getContentPane().setLayout(null);
		setAlwaysOnTop(true);
		try {
			 UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try
		{
		//BufferedImage img=ImageIO.read(getClass().getResourceAsStream("taskicon.png"));
			ImageIcon img=new ImageIcon("kattam.png");
		    setIconImage(img.getImage());
		}
		catch(Exception e)
		{
			
		}
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 466, 305);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblHowToPlay = new JLabel("How to use???");
		lblHowToPlay.setForeground(new Color(153, 0, 0));
		lblHowToPlay.setFont(new Font("Papyrus", Font.BOLD, 21));
		lblHowToPlay.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowToPlay.setBounds(137, 25, 150, 26);
		panel.add(lblHowToPlay);
		
		lblStep = new JLabel("step 1: .");
		lblStep.setForeground(Color.BLUE);
		lblStep.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStep.setBounds(10, 63, 64, 20);
		panel.add(lblStep);
		
		lblClickTheNew = new JLabel("click! the new game to start new game then choose single/ double");
		lblClickTheNew.setBounds(77, 62, 384, 21);
		panel.add(lblClickTheNew);
		
		lblPlayerGame = new JLabel(" player game");
		lblPlayerGame.setBounds(75, 81, 74, 14);
		panel.add(lblPlayerGame);
		
		lblStep_1 = new JLabel("step 2 :.");
		lblStep_1.setForeground(Color.BLUE);
		lblStep_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStep_1.setBounds(10, 105, 64, 20);
		panel.add(lblStep_1);
		
		lblThenChooseThe = new JLabel("then choose the no. of game and game duration you wanna play!!");
		lblThenChooseThe.setBounds(72, 104, 393, 21);
		panel.add(lblThenChooseThe);
		
		lblStep_2 = new JLabel("step 3 :.");
		lblStep_2.setForeground(Color.BLUE);
		lblStep_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStep_2.setBounds(10, 132, 64, 20);
		panel.add(lblStep_2);
		
		lblThenEnterThe = new JLabel("then, enter the name of player A and player B in usera and userb field\r\n\t");
		lblThenEnterThe.setBounds(76, 131, 387, 21);
		panel.add(lblThenEnterThe);
		
		lblChooseNo = new JLabel(", choose no. of chance/s , Level if you have chosen for single player.");
		lblChooseNo.setBounds(82, 151, 381, 21);
		panel.add(lblChooseNo);
		
		lblStep_3 = new JLabel("step 4: .");
		lblStep_3.setForeground(Color.BLUE);
		lblStep_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStep_3.setBounds(11, 183, 64, 20);
		panel.add(lblStep_3);
		
		lblatLastToss = new JLabel("<html>at last <u> toss </u> to start the first game of the series ");
		lblatLastToss.setBounds(72, 182, 347, 21);
		panel.add(lblatLastToss);
		
		lblStep_4 = new JLabel("step 5: .");
		lblStep_4.setForeground(Color.BLUE);
		lblStep_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStep_4.setBounds(10, 214, 64, 20);
		panel.add(lblStep_4);
		
		lblInTheInterval = new JLabel("In the interval of every game of the series you have to toss");
		lblInTheInterval.setBounds(84, 214, 347, 21);
		panel.add(lblInTheInterval);
		
		lblTheGameTo = new JLabel("the game to start the respective game of series");
		lblTheGameTo.setBounds(66, 232, 347, 21);
		panel.add(lblTheGameTo);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mf.fc.stop();
				t.stop();
				dispose();
			}
		});
		btnOk.setBounds(360, 269, 89, 23);
		panel.add(btnOk);
		
		lblClickMoreButton = new JLabel("Click!! more button(plus sign at top-right corner)");
		lblClickMoreButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClickMoreButton.setBounds(10, 255, 332, 20);
		panel.add(lblClickMoreButton);
		
		lblForMoreInformation = new JLabel("for more information");
		lblForMoreInformation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblForMoreInformation.setBounds(10, 273, 332, 14);
		panel.add(lblForMoreInformation);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 55, 451, 198);
		panel_1.setBackground(new Color(0,0,0,15));
		panel.add(panel_1);
		t=new Thread(this,"focusthread");
		t.start();
		mf=new morefocus(this);
		
	}

	@Override
	public void run() 
	{
		int i=0;
		while(true)
		{
			if(i==0)
			{
				lblStep_4.setForeground(Color.blue);
				lblInTheInterval.setForeground(Color.black);
				lblTheGameTo.setForeground(Color.black);
				lblStep.setForeground(Color.RED);
				lblClickTheNew.setForeground(Color.RED);
				lblPlayerGame.setForeground(Color.red);
			}
			else if(i==1)
			{
				lblStep.setForeground(Color.blue);
				lblClickTheNew.setForeground(Color.black);
				lblPlayerGame.setForeground(Color.black);
				lblStep_1.setForeground(Color.RED);
				lblThenChooseThe.setForeground(Color.RED);
			}
			else if(i==2)
			{
				lblStep_1.setForeground(Color.blue);
				lblThenChooseThe.setForeground(Color.black);
				lblStep_2.setForeground(Color.RED);
				lblThenEnterThe.setForeground(Color.RED);
				lblChooseNo.setForeground(Color.RED);
				
			}
			else if(i==3)
			{
				lblStep_2.setForeground(Color.blue);
				lblThenEnterThe.setForeground(Color.black);
				lblChooseNo.setForeground(Color.black);
				lblStep_3.setForeground(Color.red);
				lblatLastToss.setForeground(Color.red);
				
			}
			else if(i==4)
			{
				lblStep_3.setForeground(Color.blue);
				lblatLastToss.setForeground(Color.black);
				lblStep_4.setForeground(Color.red);
				lblInTheInterval.setForeground(Color.red);
				lblTheGameTo.setForeground(Color.red);
			}
			if(i>4)
				i=0;
			else
			    i++;
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
class morefocus implements Runnable
{
	howtouse ob;
	Thread fc;
	int c=0;
	public morefocus(howtouse h)
	{
		ob=h;
		fc=new Thread(this,"focusthread");
		fc.start();
	}
	@Override
	public void run() 
	{
		while(true)
		{
			if(c%2==0)
			{
				ob.lblClickMoreButton.setForeground(Color.GREEN);	
				ob.lblForMoreInformation.setForeground(Color.GREEN);
			}
			else
			{
				ob.lblClickMoreButton.setForeground(Color.BLACK);
				ob.lblForMoreInformation.setForeground(Color.BLACK);
			}
			c++;
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
