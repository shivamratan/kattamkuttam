package ttt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;

public class newgame extends JDialog implements Runnable {

	private final JPanel contentPanel = new JPanel();
	JPanel panel_1;
	JButton btnDoublePlayer;
	static String usertype;
	static boolean botboot=false;
	Thread blinkthread;
	JLabel lblNewGame;
	JButton okButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//tictacto m=null;
		try {
			newgame dialog = new newgame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public newgame()
	{
		
	}
	public newgame(tictacto k) 
	{
		
		//setBounds(100, 100, 450, 300);
		setModal(true);
		setAlwaysOnTop(true);
		setResizable(false);
		//setSize(424, 226);
		
		try
		{
		//BufferedImage img=ImageIO.read(getClass().getResourceAsStream("taskicon.png"));
			ImageIcon img=new ImageIcon("kattam.png");
		    setIconImage(img.getImage());
		}
		catch(Exception e)
		{
			
		}
		
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		int w=430;
		int h=290;
		  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		  int W=screen.width;
		  int H=screen.height;
		  int x=(W-w)/2;
		  int y=(H-h)/2-150;
		  setBounds(x, y, w, h);
		//setUndecorated(true);
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
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, 430, 290);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JButton btnSinglePlayer = new JButton("Single Player");
		btnSinglePlayer.setToolTipText("Click to play against Bot!!!");
	//	btnSinglePlayer.setBackground(new Color(255,255,0,210));
		btnSinglePlayer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSinglePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new sound().btnclick();
				tictacto.consolestr+="\n ##Single player selection confirmed";
				tictacto.consolestr+="\n 1.select the no of game to play against Bot \n 2.select the duration to play against Bot";
				panel_1.setVisible(true);
				btnSinglePlayer.setEnabled(false);
				btnDoublePlayer.setEnabled(false);
				btnSinglePlayer.setForeground(Color.MAGENTA);
				btnDoublePlayer.setVisible(false);
				k.chckbxEnableBot.setSelected(true);
				//k.lblUserbWins.setText(k.ub+" wins:");
				 k.userb.setText("Bot");
					k.bot=true;
					k.usb=false;
					usertype=btnSinglePlayer.getText();
					okButton.setEnabled(true);
					
			}
		});
		btnSinglePlayer.setBounds(117, 57, 258, 41);
		panel.add(btnSinglePlayer);
		
		lblNewGame = new JLabel("New Game");
		lblNewGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewGame.setForeground(Color.MAGENTA);
		lblNewGame.setFont(new Font("Freestyle Script", Font.BOLD, 49));
		lblNewGame.setBounds(10, 0, 258, 57);
		panel.add(lblNewGame);
		
		btnDoublePlayer = new JButton("Double Player");
		btnDoublePlayer.setToolTipText("Click to play with your friend!!");
		btnDoublePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new sound().btnclick();
				tictacto.consolestr+="\n ##Double player selection confirmed";
				tictacto.consolestr+="\n 1.select the no of game to play against Other player \n 2.select the duration to play against Other player";
				panel_1.setVisible(true);
				btnSinglePlayer.setEnabled(false);
				btnDoublePlayer.setEnabled(false);
				btnDoublePlayer.setForeground(Color.MAGENTA);
				btnSinglePlayer.setVisible(false);
				btnDoublePlayer.setBounds(117, 70, 258, 41);
				k.chckbxEnableBot.setSelected(false);
				k.chckbxEnableBot.setEnabled(false);
				k.bot=false;
				k.botturn=false;
				usertype=btnDoublePlayer.getText();
				okButton.setEnabled(true);
				
				
			}
		});
		btnDoublePlayer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDoublePlayer.setBounds(117, 119, 258, 41);
		panel.add(btnDoublePlayer);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_1.setBackground(new Color(0,255,0,150));
		panel_1.setBounds(28, 171, 379, 46);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_2 = new JLabel("Total game :");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setForeground(Color.BLACK);
		label_2.setBounds(10, 11, 76, 21);
		panel_1.add(label_2);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 60, 1));
		spinner_1.setBounds(96, 11, 51, 24);
		
		panel_1.add(spinner_1);
		
		JLabel lblDurationPerGame = new JLabel("Duration per Game: ");
		lblDurationPerGame.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDurationPerGame.setBounds(187, 14, 131, 21);
		panel_1.add(lblDurationPerGame);
		
		panel_1.setVisible(false);
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner_2.setBounds(310, 11, 59, 24);
		panel_1.add(spinner_2);
		
			//JPanel buttonPane = new JPanel();
			//buttonPane.setBackground(Color.ORANGE);
			//buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			//getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
				okButton = new JButton("OK");
				okButton.setBackground(new Color(255,255,0,150));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object o = spinner_1.getValue();
						Number n = (Number) o;
						int i = n.intValue();
						Object o1 = spinner_2.getValue();
						Number n1 = (Number) o1;
						int j = n1.intValue();
						//System.out.println(" "+i+" "+j);
						k.total=i;
						k.time=j;
						 k.lblwinusa.setText("0/"+i);
						 k.lblwinusb.setText("0/"+i);
						 k.lbldraw.setText("0/"+i);
						 k.min=j;
						 k.timepergame=j;
						 k.total=i;
						 k.remaining=i-1;
						 k.lblT.setText(i+"");
						 k.lblSeriesProgress.setVisible(true);
						 k.lblGameProgress.setVisible(true);
						 k.lblt_3.setVisible(true);
						 k.lblNewLabel_1.setVisible(true);
						 k.progressBar.setVisible(true);
						 k.progressBar_1.setVisible(true);
						 k.label_6.setText(k.gameno+"");
						 k.lblNewLabel_1.setText("0/"+j*60);
						 k.progressBar.setMaximum(j*60);
						 k.progressBar_1.setMaximum(i*j*60);
						 newgamebtnthread.newgmbtnthread.stop();
						 k.gameno++;
						tictacto.consolestr+="\n\n\t******* status*******"
								+"\n \tusertype:  "+usertype
								+"\n \tno of game:  "+i
								+"\n \tduration per game:   "+j;
						if(usertype.equals("Single Player"))
						{
							//booting the bot
							botboot=true;
						tictacto.consolestr+="\n\n"
								+"*****Rebooting the bot******"
								+"\nRatBot:reinitialising all the algorithm reinforced capable threads "
								+"\nRatBot:fetching algorithm thread for bot engine"
								+"\nRatBot:booting bot with Trusted Platform Module(TPM)"
								+"\nRatBot:checking secure boot policy for bot"
								+"\nRatBot:fixing the driver violating game security policy"
								+"\nRatBot:loopback: send reliable stream overflow"
								+"\nRatBot:Loading  configuration..."
								+"\nRatBot:Configuration Loaded"
								+"\nRatBot:bot is detecting language en_US"
								+"\nRatBot:Enabling Open #@bot32.ssl condition"
								+"\nRatBot:Reloading AssemblyLoader<ff14bot.AClasses.BotBase>- iniitializing"
								+"\nRatBot:[RatBotManager ] Botbases have been reloaded"
								+"\nRatBot:reinitialising startup thread ,relating to combat setting"
								+"\nRatBot:binding all the different startup thread "
								+"\nRatBot:reordering and building Actioncache"
								+"\nRatBot:bot is active !!"
								+"\nRatBot:bot is ready to play!!";
						
						tictacto.consolestr+="\n\n\n"
								+"\n * set your name"
								+"\n* set no of chances"
								+"\n set desired X or O icon you wanna choose!"
								+"\n SET LEVEL OF THE BOT*****";
						tictacto.consolestr+="\n\nWARNING: NAME ,CHANCES,LEVELS ARE LOCKED AFTER TOSS\n";
						}
						else
						{	
							tictacto.consolestr+="\n\n"
									+"\n* set your name"
									+"\n* set no of chances"
									+"\n* set desired X or O icon you wanna choose!";
							tictacto.consolestr+="\n\nWARNING: NAME ,CHANCES,LEVELS ARE LOCKED AFTER TOSS\n";
						}
						if(!(k.bot))
						{
							k.lblPlayVsComputer.setVisible(false);
							k.chckbxEnableBot.setVisible(false);
							k.button.setVisible(false);
							k.lblLevel.setVisible(false);
							k.comboBox.setVisible(false);
							k.separator_12.setBounds(438, 300, 193, 9);
							k.panel_4.setBounds(419, 131, 275, 193);
							k.chckbxMusic.setBounds(421, 230, 58, 23);
							k.separator_13.setBounds(485, 220, 17, 35);
							k.lblTape.setBounds(494, 227, 49, 26);
							k.comboBox_2.setBounds(546, 227, 142, 26);
							k.slider.setBounds(467,270, 193, 16);
							k.label_4.setBounds(423,270, 46, 26);
							k.panel_3.setBounds(488,195, 130, 22);
							k.lblTheme.setBounds(426,159, 65, 26);
							k.comboBox_1.setBounds(493, 159, 161, 26);
							k.panel_5.setVisible(false);
						}
						k.btnNewGame.setEnabled(false);
						Date d=new Date();
						String temp="Date ::  "+d.toString(); 
						 temp+="\n Game type = "+usertype+"\n"
								+"no of game= "+i
								+"\nduration of game="+j;
						temp+="\nGameno  usera  userb chances  level  result";
						new updatelog().updatelogs(temp);
						new beginningtossthread(k);
						k.btntoss.setEnabled(true);
						setVisible(false);
						
					//  k.enableframe();
					}
				});
				okButton.setActionCommand("OK");
			//	buttonPane.add(okButton);
				okButton.setEnabled(false);
				getRootPane().setDefaultButton(okButton);
			okButton.setBounds(260,230,80,27);
			panel.add(okButton);
				
				
			
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(new Color(255,255,0,130));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tictacto.consolestr+="\n\nnew game exit reported #6749FUI";
						tictacto.consolestr+="\nTo play !!! game please enter Alt+N or click New game\n";
						setVisible(false);
						//k.lblPlayVsComputer.setVisible(true);
						//k.chckbxEnableBot.setVisible(true);
						//k.button.setVisible(true);
						//k.lblLevel.setVisible(true);
						//k.comboBox.setVisible(true);
					}
				});
				cancelButton.setActionCommand("Cancel");
				cancelButton.setBounds(350,230,70,27);
				panel.add(cancelButton);
				//buttonPane.add(cancelButton);
			   
			
			//buttonPane.setVisible(false);
			JLabel bg=new JLabel(new ImageIcon("flamed_vector_background_5597.jpg"));
			   bg.setBounds(0, 0, 430, 260);
			   panel.add(bg);
		
		blinkthread=new Thread(this,"myblinkthread");
		blinkthread.start();
	}

	@Override
	public void run() 
	{
		int c=0;
		while(true)
		{
			//System.out.println("executing sir "+c);
			if(c%2==0)
			{
				lblNewGame.setForeground(Color.blue);
			}
			else
			{
				lblNewGame.setForeground(Color.BLACK);
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
