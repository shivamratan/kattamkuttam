package ttt;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javafx.scene.control.ComboBox;

import javax.imageio.ImageIO;
import javax.sound.sampled.FloatControl;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.Component;

import javax.swing.JSeparator;
import javax.swing.JRadioButton;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;

import java.awt.Cursor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import org.openide.awt.DropDownButtonFactory;

//import canvas1.ScrollingBackground;


















import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.text.DefaultCaret;

public class tictacto implements ActionListener,Runnable  
{
	boolean botvisited=false;
	boolean visited=false;
	boolean clicked=false;
	howtouse ht=null;
	static settingpanel settingpan;
	static tossblink object;
	JFrame frame;
	JTextField usera;
	 JTextField userb;
	int c1,c2,c3,c4,c5,c6,c7,c8,c9;
	int d1,d2,d3,d4,d5,d6,d7,d8,d9;
	JRadioButton rbabtnX,rbabtnO,rbbbtnX,rbbbtnO;
	ButtonGroup bga,bgb;
	ButtonGroup choice;
	boolean usa,usb;
	boolean singleusebtn=true;
	public String icona="X";
	public String iconb="O";
	static boolean toss=false;
	static boolean bot=false;
	JLabel lbllivea;
	JLabel lblliveb;
	JLabel lblturnA;
	JLabel lblturnB;
	static int btna=0;
	static int btnb=0;
	boolean filled1,filled2,filled3,filled4,filled5,filled6,filled7,filled8,filled9;
	public JButton btn00,btn01,btn02;
	public  JButton btn10,btn11,btn12;
	public  JButton btn20,btn21,btn22;
	Timer t;
	JLabel lblTimerLabel;
	int tim=0;
	static String ua,ub;
	JLabel lblNewLabel_2;
	JLabel result;
	JRadioButton radioButton;
	static int chance;
	static int livea;
	static int liveb;
	static Color c;
	JCheckBox chckbxEnableBot;
	int drew;
	public static int gear;
	static JComboBox comboBox;
	boolean blink=false;
	JLabel lblUseraWins;
	JLabel lblUserbWins;
	static int total;
	int remaining;
	int time;
	JLabel lblwinusa;
	JLabel lblwinusb;
	JLabel lbldraw;
	int uawin;
	int ubwin;
	int uaubdraw;
	static int timepergame;
	boolean botturn=false;
	boolean endgame=false;
	static volatile float soundvolume=0.0f;
	volatile int z=0;
	JButton dropDownButton;
	JLabel lblMore;
	JProgressBar progressBar;
	static Thread thread1;
	static JProgressBar progressBar_1;
	static JTextArea txtrThinkingSkill;
	static String consolestr="booting game \n please wait....\n";
	JScrollPane scrollBar;
	static boolean bootflag;
	long uastartthink,uaendthink,ubstartthink,ubendthink;
	JLabel label_3;
	static ArrayList<indexandscore> scoreindex=new ArrayList<>();
	JLabel lblT;
	JLabel label_6;
	static int gameno=0;
	JLabel lblSeriesProgress;
	JLabel lblGameProgress;
	int nooftosses=0;
	int greatest;
	static totaltime1 tt1;
	int gamewasted;
	static boolean btndisturb=false;
	static boolean topgearconsole=false;
	JComboBox comboBox_1;
	JLabel lblUserA;
	JLabel lblUserB;
	JLabel lblNewLabel;
	JLabel lblB;
	JLabel lblPlayVsComputer;
	JButton button;
	JLabel lblLevel;
	JSeparator separator_12;
	JPanel panel_4;
	JSlider slider;
	JLabel label_4;
	JCheckBox chckbxMusic;
	JSeparator separator_13;
	JLabel lblTape;
	JPanel panel_3;
	JLabel lblTheme;
	JButton btnNewGame;
	JPanel panel_5;
	boolean botfocus=true;
	JButton btntoss;
	JLabel lblChan;
	static console cl;
	static statsborderthread sbt;
	static alwaysonline alwayson;
	static mailprop mp;
	static winblink winb;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new splash().setVisible(true);
					tictacto window = new tictacto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
   
	/**
	 * Create the application.
	 */
	public tictacto() {
		//System.gc();
		new timecalci();
		 mp=new mailprop(this);
		highscore.gethighscore();
		//Collections.sort(highscore.highscore);
	//	new alwaysonline();
		greatest=highscore.highscore.get(0);
		for(int i=1;i<highscore.highscore.size();i++)
		{
			int temp=highscore.highscore.get(i);
				if(greatest<temp)
					greatest=temp;
		}
		initialize();
		
		new sound().playbackground(0);
		t=new Timer(1000,this);
		
		
		bootflag=true;
		cl=new console();
		consolestr=" * starting configure device"
 +"\n* stopping cold plug device" 
 +"\n*  stopping log initial memory allocation" 
 +"\n* starting load fallback graphics devices"
 +"\n* starting userspace bootsplash"
 +"\n* starting userspace bootsplash"
 +"\n* starting Mount inholder filesystem"
 +"\n*  starting system V initialisation compatibility"
 +"\n*  starting Apparmor profile"
 +"\n*  checking system display driver,audio driver" 
 +"\n*  checking system compatiblity with game graphics"
+"\nChecking for running unattended-upgrades:"
+"\n * stopping System V initialisation compatibility" 
+"\n * starting System V runlevel compatibility"
+"\n * Stopping automatic crash report report generation"
+"\n * Starting CPU interrupts balancing daemon"
+"\n * Starting deferred execution scheduler"
+"\n * Starting regular background program processing daemon"
+"\n * Starting deferred executing scheduler"
+"\n * Starting LightDM Display Manager"
+"\n * Starting anac(h)ronistic cron"
+"\n * PulseAudio configured for per-user sessions"
+"\n * Stopping System V runlevel compatibility "
+"\nConfiguring Algorithm****"
+"\n* Starting algorithm thread" 
+"\n* Starting algorithm exception log report thread"
+"\n#####################################"
+"\n     #              welcome to tictactoe            #"
+"\n     #                check more/about              #"
+"\n     #             powered by Ratan Inc.          #"
+"\n#####################################"
+"\n####### Starting game######"
+"\n>> Click New Game or Alt +N to start game ";
		 alwayson=new alwaysonline(this);	
	}
	int min,sec=0;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JSeparator separator_8;
	private JSeparator separator_10;
	 JLabel lblNewLabel_1;
	static JLabel lblt_3;
	JLabel theme;
	 JLabel label_1;
      JPanel panel_2;
	private JLabel label_2;
	private JLabel labelremaining;
	 JComboBox comboBox_2;
	private JLabel lblGameWasted;
	private JLabel label_7;
	themecontrol themecontro;
	int cursliderpos;
	@Override
	
	public void actionPerformed(ActionEvent e)
	{
		//for option menu
		Object source = e.getSource();
		if (source instanceof JMenuItem) {
			JMenuItem clickedMenuItem = (JMenuItem) source;
			String menuText = clickedMenuItem.getText();
			if(menuText.equals("About"))
				new about().setVisible(true);
			else if(menuText.equals("Check for Update"))
				new checkupdate().setVisible(true);
			else if(menuText.equals("Report bug"))
				new reportbug().setVisible(true);
			else if(menuText.equals("help"))
				new help().setVisible(true);
			else if(menuText.equals("How to use??"))
				new howtouse().setVisible(true);
			else if(menuText.equals("How to play!!"))
				new howtoplay().setVisible(true);
			else if(menuText.equals("Feedback"))
			{
				//JOptionPane.showMessageDialog(null,"reaching to feedback");
				new feedback().setVisible(true);
			}
			System.out.println("Create a " + menuText);
		} 
		else if (source instanceof JButton) 
		{
			new sound().btnclick();
		}
		refreshstats();
		
		int r=(int )(255*Math.random());
		int g=(int )(255*Math.random());
		int b=(int )(255*Math.random());
		Color c=new Color(r,g,b);
				   result.setForeground(c);
		  
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Designed and developed by shivam ratan
		//Designed and developed by shivam ratan
		//Designed and developed by shivam ratan
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				//JOptionPane.showOptionDialog(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7)
				//JOptionPane.showMessageDialog(null,"The windows is closing bro!!!");
				//new wannaplay(this).setVisible(true);
				//new wannaplay(this).setVisible(true);
				//callwannaplay();
			/*	int choice =JOptionPane.showOptionDialog(null, "You really want to quit game ??", "quit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if(choice==JOptionPane.YES_OPTION)
				{
					sound.clip.stop();
				frame.setVisible(false);
				mail.attachsendMail("kattam kuttam mail1 logs(log.txt)","log.txt");
				mail.attachsendMail("kattam kuttam mail2 logs(box.txt)","box.txt");
				}
				else if(choice==JOptionPane.NO_OPTION)
				{*/
			
					callwannaclose();
			}
		
				
				
				
				
			//}
			@Override
			public void windowOpened(WindowEvent e) 
			{
				
			}
		});
		frame.getContentPane().setBackground(Color.WHITE);
	  //  frame.setFocusable(true);
		frame.setFocusableWindowState(true);
		/*frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int r=(int )(255 *Math.random());
				int g=(int )(255 *Math.random());
				int b=(int )(255 *Math.random());
				
				frame.setBackground(new Color(r,g,b));
			}
		});*/
		themecontro=new themecontrol(this);
		frame.getContentPane().setForeground(Color.RED);
		frame.setResizable(false);
		frame.setTitle("Kattam Kuttam pro v1.0.0");
		try
		{
		//BufferedImage img=ImageIO.read(getClass().getResourceAsStream("taskicon.png"));
			ImageIcon img=new ImageIcon("kattam.png");
		    frame.setIconImage(img.getImage());
		}
		catch(Exception e)
		{
			
		}
		
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		//frame.setBounds(100, 100, 714, 694);
		int w=714;
		int h=694;
		  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		  int W=screen.width;
		  int H=screen.height;
		  int x=(W-w)/2;
		  int y=(H-h)/2;
		  frame.setBounds(x, y-10, 702, 694);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
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
		
		/*JPopupMenu popupMenu = new JPopupMenu();
		addPopup(frame.getContentPane(), popupMenu);*/
		
		lblMore = new JLabel("More");
		lblMore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblMore.setForeground(Color.RED);
				dropDownButton.setBackground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblMore.setForeground(Color.BLACK);
				dropDownButton.setBackground(Color.WHITE);
			}
		});
		
		lblSeriesProgress = new JLabel("Series progress:");
		lblSeriesProgress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeriesProgress.setBounds(10, 456, 91, 17);
		lblSeriesProgress.setVisible(false);
		frame.getContentPane().add(lblSeriesProgress);
		
		lblGameProgress = new JLabel("Game progress:");
		lblGameProgress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGameProgress.setBounds(10, 431, 91, 17);
		lblGameProgress.setVisible(false);
		frame.getContentPane().add(lblGameProgress);
		
		button = new JButton("");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon("save.png"));
		button.setBounds(593, 281, 16, 17);
		frame.getContentPane().add(button);
		
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panel_2.setBackground(new Color(245,249,140));
		panel_2.setBounds(423, 411, 263, 229);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblGameNo = new JLabel("Game no: ");
		lblGameNo.setBounds(46, 24, 84, 26);
		panel_2.add(lblGameNo);
		lblGameNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblTotalGame = new JLabel("Total Game:");
		lblTotalGame.setBounds(41, 50, 84, 26);
		panel_2.add(lblTotalGame);
		lblTotalGame.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblT = new JLabel("0");
		lblT.setBounds(156, 47, 73, 26);
		panel_2.add(lblT);
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setForeground(Color.RED);
		lblT.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		label_6 = new JLabel("0");
		label_6.setBounds(164, 23, 53, 26);
		panel_2.add(label_6);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		label_2 = new JLabel("Remaining game :");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(10, 148, 135, 26);
		panel_2.add(label_2);
		
		labelremaining = new JLabel("0/T");
		labelremaining.setHorizontalAlignment(SwingConstants.CENTER);
		labelremaining.setForeground(Color.RED);
		labelremaining.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelremaining.setBounds(168, 147, 54, 26);
		panel_2.add(labelremaining);
		
		lblUseraWins = new JLabel("usera wins:");
		lblUseraWins.setBounds(23, 73, 118, 26);
		panel_2.add(lblUseraWins);
		lblUseraWins.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		lblwinusa = new JLabel("0/T");
		lblwinusa.setBounds(158, 72, 73, 26);
		panel_2.add(lblwinusa);
		lblwinusa.setForeground(Color.RED);
		lblwinusa.setHorizontalAlignment(SwingConstants.CENTER);
		lblwinusa.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblUserbWins = new JLabel("userb wins:");
		lblUserbWins.setBounds(29, 97, 118, 26);
		panel_2.add(lblUserbWins);
		lblUserbWins.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		lblwinusb = new JLabel("0/T");
		lblwinusb.setBounds(159, 96, 73, 26);
		panel_2.add(lblwinusb);
		lblwinusb.setHorizontalAlignment(SwingConstants.CENTER);
		lblwinusb.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblwinusb.setForeground(Color.RED);
		
		JLabel lblDraw = new JLabel("No. of Draws :");
		lblDraw.setBounds(17, 123, 118, 26);
		panel_2.add(lblDraw);
		lblDraw.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		lbldraw = new JLabel("0/T");
		lbldraw.setBounds(167, 123, 54, 26);
		panel_2.add(lbldraw);
		lbldraw.setHorizontalAlignment(SwingConstants.CENTER);
		lbldraw.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbldraw.setForeground(Color.RED);
		
		JLabel lblHighScore = new JLabel("High Score :");
		lblHighScore.setBounds(29, 200, 106, 26);
		panel_2.add(lblHighScore);
		lblHighScore.setForeground(Color.MAGENTA);
		lblHighScore.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		label_3 = new JLabel("");
		label_3.setBounds(156, 200, 74, 26);
		panel_2.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.MAGENTA);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setText(greatest+"");
		
		JLabel lblStatistics = new JLabel("<html><u>Statistics</u></html>");
		lblStatistics.setBounds(85, 0, 81, 26);
		panel_2.add(lblStatistics);
		lblStatistics.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		lblGameWasted = new JLabel("Game Wasted :");
		lblGameWasted.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGameWasted.setBounds(15, 175, 118, 26);
		panel_2.add(lblGameWasted);
		
		label_7 = new JLabel("0/T");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_7.setBounds(168, 175, 54, 26);
		panel_2.add(label_7);
		
		panel_3 = new JPanel();
		//panel_3.setBackground(new Color(255,255,0,105));
		panel_3.setBounds(488, 163, 130, 24);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_5 = new JLabel(new ImageIcon("newequalize2.gif"));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("Tekton Pro Ext", Font.BOLD, 20));
		label_5.setBackground(Color.BLUE);
		label_5.setBounds(0, 0, 130, 24);
		panel_3.add(label_5);
		
		
		//Designed and developed by shivam ratan
		//Designed and developed by shivam ratan
		//Designed and developed by shivam ratan
		comboBox_2 = new JComboBox();
		//comboBox_2.setToolTipText("");
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=comboBox_2.getSelectedItem().toString();
					if(s.equals("silent hills"))
					{
						sound.clip.stop();
						new sound().playbackground(2);
					}
					else if(s.equals("piano"))
					{
						sound.clip.stop();
						new sound().playbackground(1);
					}
					else if(s.equals("yokers"))
					{
						sound.clip.stop();
						new sound().playbackground(3);
					}
					else if(s.equals("street hawker"))
					{
						sound.clip.stop();
						new sound().playbackground(0);
					}
					else if(s.equals("Breeze"))
					{
						sound.clip.stop();
						new sound().playbackground(4);
					}
					else if(s.equals("Electric"))
					{
						sound.clip.stop();
						new sound().playbackground(5);
					}
					else if(s.equals("Mirage"))
					{
						sound.clip.stop();
						new sound().playbackground(6);
					}
					else if(s.equals("Street boy"))
					{
						sound.clip.stop();
						new sound().playbackground(7);
					}
					else if(s.equals("Ocean Wind"))
					{
						sound.clip.stop();
						new sound().playbackground(8);
					}
			}
		});
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"street hawker", "piano", "yokers", "silent hills", "Breeze", "Electric", "Mirage", "Street boy", "Ocean Wind"}));
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_2.setBounds(546, 190, 142, 26);
		frame.getContentPane().add(comboBox_2);
		
		slider = new JSlider();
		//slider.setToolTipText("");
		slider.setMinorTickSpacing(1);
		slider.setMinimum(20);
		slider.setMaximum(50);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				soundvolume=-1*(50-slider.getValue());
				 FloatControl gainControl = (FloatControl) sound.clip.getControl(FloatControl.Type.MASTER_GAIN);	
				 		if(slider.getValue()==20)
				 			soundvolume=-50f;
			        gainControl.setValue(soundvolume);
			}
		});
		slider.setBounds(467, 223, 161, 26);
		frame.getContentPane().add(slider);
		
		separator_12 = new JSeparator();
		separator_12.setBounds(438, 260, 193, 9);
		frame.getContentPane().add(separator_12);
		
		 separator_13 = new JSeparator();
		separator_13.setOrientation(SwingConstants.VERTICAL);
		separator_13.setBounds(485, 186, 17, 35);
		frame.getContentPane().add(separator_13);
		
		chckbxMusic = new JCheckBox("Mute");
		chckbxMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(z%2==0)
				{
				/*FloatControl gainControl = (FloatControl) sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
		        gainControl.setValue(-50.0f);
		        slider.setValue(0);
		        slider.setEnabled(false);*/
		       // new volumedownfader(this);
					label_5.setIcon(new ImageIcon("equalizestatic.jpg"));
					cursliderpos=slider.getValue();
					chckbxMusic.setEnabled(false);
					callvolumedownthread();
				}
				else
				{
					/*FloatControl gainControl = (FloatControl) sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
			        gainControl.setValue(-0.0f);
			        slider.setEnabled(true);
			        slider.setValue(50);*/
					label_5.setIcon(new ImageIcon("newequalize2.gif"));
					chckbxMusic.setEnabled(false);
					callvolumeupthread();
			        
				}
				z++;
			}
		});
		
		chckbxMusic.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxMusic.setBackground(Color.ORANGE);
		chckbxMusic.setBounds(421, 193, 58, 23);
		frame.getContentPane().add(chckbxMusic);
		
		lblTape = new JLabel("Tape :");
		lblTape.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTape.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTape.setBounds(494, 190, 49, 26);
		frame.getContentPane().add(lblTape);
		
		label_4 = new JLabel(new ImageIcon("drew.png"));
		label_4.setBounds(423, 224, 46, 26);
		frame.getContentPane().add(label_4);
		
		comboBox_1 = new JComboBox();
		//comboBox_1.setToolTipText("");
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s1=comboBox_1.getSelectedItem().toString();
			if(s1.equals("Dark Space"))
			{
				//System.out.println("reaching dark space");
				     theme.setIcon(new ImageIcon("space.GIF"));
				     themecontro.buttoncolor();
			}
			else if(s1.equals("Swirl Green"))
			{
				//System.out.println("reaching swirl green");
					theme.setIcon(new ImageIcon(("swirlgreen.jpg")));
					themecontro.buttoncolor();
			}
			else if(s1.equals("Pink city"))
			{
				//System.out.println("reaching pink city");
				theme.setIcon(new ImageIcon("pinkcity.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Spring Green"))
			{
				//System.out.println("reaching spring green");
				theme.setIcon(new ImageIcon("springgreen.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Lemon Yellow"))
			{
				//System.out.println("reaching lemon yellow ");
				theme.setIcon(new ImageIcon("lemonyellow.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Color Spiral"))
			{
				// System.out.println("reaching color spiral");
				theme.setIcon(new ImageIcon("colorspiral.gif"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Rainy Glass"))
			{
				// System.out.println("reaching to rainy glass");
				theme.setIcon(new ImageIcon("rainyglass.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Yellow tiles"))
			{
				// System.out.println("reaching to yellow tiles");
				theme.setIcon(new ImageIcon("yellowtiles.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Sunny Lemon"))
			{
				// System.out.println("reaching to sunny lemon");
				theme.setIcon(new ImageIcon("sunnylemon.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Rainy Splash"))
			{
				// System.out.println("reaching to Rainy splash");
				theme.setIcon(new ImageIcon("rainsplash.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Gradient 1"))
			{
				// System.out.println("reaching to gradient1");
				theme.setIcon(new ImageIcon("gradient1.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Gradient 2"))
			{
				// System.out.println("reaching to gradient2");
				theme.setIcon(new ImageIcon("gradient2.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Abstract Green"))
			{
				theme.setIcon(new ImageIcon("abstractgreen.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Abstract Light"))
			{
				theme.setIcon(new ImageIcon("abstractlight.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Blue Curtain"))
			{
				theme.setIcon(new ImageIcon("bluecurtain.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Blur Back"))
			{
				theme.setIcon(new ImageIcon("blurscene.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Color Hypo"))
			{
				theme.setIcon(new ImageIcon("colorhypo.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Color fill"))
			{
				theme.setIcon(new ImageIcon("colormix.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Cut Gradient"))
			{
				theme.setIcon(new ImageIcon("cutgradient.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Free Spirit"))
			{
				theme.setIcon(new ImageIcon("freesprit.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Autumn Leaves"))
			{
				theme.setIcon(new ImageIcon("leaves.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Light Clash"))
			{
				theme.setIcon(new ImageIcon("lightclash.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("MultichromeX"))
			{
				theme.setIcon(new ImageIcon("multicolor-background.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Nature"))
			{
				theme.setIcon(new ImageIcon("nature.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Paper Design"))
			{
				theme.setIcon(new ImageIcon("papercut.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Reddish Curtain"))
			{
				theme.setIcon(new ImageIcon("reddishcurtain.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Red Spray"))
			{
				theme.setIcon(new ImageIcon("redtexture.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Swirl Rainbow"))
			{
				theme.setIcon(new ImageIcon("swirlrainbow.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Rock Print"))
			{
				theme.setIcon(new ImageIcon("rockprint.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Roxy Pink"))
			{
				theme.setIcon(new ImageIcon("roxy.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Sea Beach"))
			{
				theme.setIcon(new ImageIcon("seabeach.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Sky View"))
			{
				theme.setIcon(new ImageIcon("skyscene.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Ultimate Gray"))
			{
				theme.setIcon(new ImageIcon("ultimategray.jpg"));
				themecontro.buttoncolor();
			}
			else if(s1.equals("Wave"))
			{
				theme.setIcon(new ImageIcon("wave.jpg"));
				themecontro.buttoncolor();
			}
			else
			{
				// System.out.println("reaching to useless");
				theme.setIcon(new ImageIcon("space.GIF"));
				themecontro.buttoncolor();
			}
			}
		});
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Dark Space", "Swirl Green", "Pink city", "Spring Green", "Lemon Yellow", "Color Spiral", "Rainy Glass", "Rainy Splash", "Yellow tiles", "Sunny Lemon", "Gradient 1", "Gradient 2", "Abstract Green", "Abstract Light", "Blue Curtain", "Blur Back", "Color Hypo", "Color fill", "Cut Gradient", "Free Spirit", "Autumn Leaves", "Light Clash", "MultichromeX", "Nature", "Paper Design", "Reddish Curtain", "Red Spray", "Swirl Rainbow", "Rock Print", "Roxy Pink", "Sea Beach", "Sky View", "Ultimate Gray", "Wave"}));
		comboBox_1.setBounds(493, 136, 161, 26);
		frame.getContentPane().add(comboBox_1);
		
		lblTheme = new JLabel("Theme :");
		lblTheme.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTheme.setBounds(426, 134, 65, 26);
		frame.getContentPane().add(lblTheme);
		lblMore.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		lblMore.setBounds(657, 26, 29, 14);
		frame.getContentPane().add(lblMore);
		//frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBounds(61, 110, 292, 310);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		//frame.setAlwaysOnTop(true);
		
		btn00 = new JButton(" ");
		btn00.setForeground(Color.GREEN);
		btn00.setBackground(Color.BLACK);
		btn00.setFont(new Font("Tahoma", Font.PLAIN, 74));
		
		btn00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if(!(livea==(chance-1)||liveb==(chance-1)))
				 new sound().btnclick();
			
	if(toss)
	{
		
		if(!tictacto.consolestr.equals(tictacto.txtrThinkingSkill.getText()))
		{
			btndisturb=true;
		}
		if(usa&&livea>0)
		{
			
				if(c1%2==0)
				{
				
					btn00.setText(icona);
					c1++;
				
				}
				else if(c1%2!=0)
				{
					btn00.setText(" ");
					c1++;
				}
				
				if(filled2||filled3||filled4||filled5||filled6||filled7||filled8||filled9)
				{
				  System.out.println("filled condition line no 787");
				  livea--;
				  lbllivea.setText("X "+livea);
				  if(filled2)
				  {
					  btn01.setText(" ");
					  filled2=false;
				  }	  
				  else if(filled3)
				  {
					  btn02.setText(" ");
					  filled3=false;
				  }	  
				  else if(filled4)
				  {
					  btn10.setText(" ");
					  filled4=false;
				  }
				  else if(filled5)
				  {
					  btn11.setText(" ");
					  filled5=false;
				  }  
				  else if(filled6)
				  {
					  btn12.setText(" ");
					  filled6=false;
				  }
				  else if(filled7)
				  {
					  btn20.setText(" ");
					  filled7=false;
				  }
				  else if(filled8)
				  {
					  btn21.setText(" ");
					  filled8=false;
				  }
				  else if(filled9)
				  {
					  btn22.setText(" ");
					  filled9=false;
				  } 
				  
				}
							//giving console string
				if(livea==1)
				{
					consolestr+="\n ** completing "+ua+"  request"
							+"\n* gearing your   request to the bot"
							+"\n* locking the "+ua+"choice  ";
				}
				else if(livea==3)
				{
					consolestr+="\n  "+ua+" has "+(livea-1)+" remaining chances ";
				}
				else 
				{
					consolestr+="\n \t* "+ua+" has remaining chances are "+(chance-livea);
				}
				
				
				if(livea==1)
				{
					livea--;
					if(livea==0)
					{
						uaendthink=System.nanoTime();
						consolestr+="\n **"+ua+"  thinking time is  "+(uaendthink-uastartthink)+" ns"+" ******";
						btn00.setForeground(Color.BLUE);
						btn00.setText(icona);
						new sound().chance(0);
						btn00.setEnabled(false);
						checkbtn00win();
					if(!endgame)
					{
						if(!bot)
						{
						liveb=chance;
					     lblliveb.setText("X "+liveb);
					     lbllivea.setText("X "+livea);
					     usa=false;
					     usb=true;
					     ubstartthink=System.nanoTime();
					     lblturnA.setText(" ");
					     lblturnB.setText(ub+" turns...");
						}
						else
						{
							liveb=1;
							 lblliveb.setText("X "+liveb);
						     lbllivea.setText("X "+livea);
						     usa=false;
						     botturn=true;
						     lblturnA.setText(" ");
						     lblturnB.setText(ub+" turns...");  
						    // checkempty();
						     botturn=true;
						     if(bot)
						      botplay();
						     
						     
						}
					}	
					}
					
					
					
					
						
				}
				
				else if(btn00.getText()!=" "&&livea>1)
				{
					filled1=true;
					
				}
				
				/*else if(livea>1&&btna!=1)
				{
					System.out.println("conditional decrement line 903");
					livea--;
					lbllivea.setText("X "+livea);
				}*/
			btna=1;	
				
		
		}
		else if(usb&&liveb>0)
		{
			if(d1%2==0)
			{
				btn00.setText(iconb);
				d1++;
			
			}
			else
			{
				btn00.setText(" ");
				d1++;
			}
			//main condition
			if(filled2||filled3||filled4||filled5||filled6||filled7||filled8||filled9)
			{
				 System.out.println("filled condition line no 927");
			  liveb--;
			  lblliveb.setText("X "+liveb);
			  if(filled2)
			  {
				  btn01.setText(" ");
				  filled2=false;
			  }	  
			  else if(filled3)
			  {
				  btn02.setText(" ");
				  filled3=false;
			  }	  
			  else if(filled4)
			  {
				  btn10.setText(" ");
				  filled4=false;
			  }
			  else if(filled5)
			  {
				  btn11.setText(" ");
				  filled5=false;
			  }  
			  else if(filled6)
			  {
				  btn12.setText(" ");
				  filled6=false;
			  }
			  else if(filled7)
			  {
				  btn20.setText(" ");
				  filled7=false;
			  }
			  else if(filled8)
			  {
				  btn21.setText(" ");
				  filled8=false;
			  }
			  else if(filled9)
			  {
				  btn22.setText(" ");
				  filled9=false;
			  } 
			  
			}
			//console string
			if(liveb==1)
			{
				consolestr+="\n ** completing "+ub+"  request"
						+"\n* gearing your   request to the bot"
						+"\n* locking the "+ub+"choice  ";
			}
			else if(liveb==3)
			{
				consolestr+="\n  "+ub+" has "+(liveb-1)+" remaining chances ";
			}
			else
			{
				consolestr+="\n \t* "+ub+"has remaining chances are "+(chance-liveb);
			}
			
			if(liveb==1)
			{
				liveb--;
				if(liveb==0)
				{
					ubendthink=System.nanoTime();
					livea=chance;
					consolestr+="\n **"+ub+"  thinking time is  "+(ubendthink-ubstartthink)+" ns"+" ******";
				     lblliveb.setText("X "+liveb);
				     lbllivea.setText("X "+livea);
				     usb=false;
				     usa=true;
				     uastartthink=System.nanoTime();
				     lblturnA.setText(ua+" turns...");
				     consolestr+="\n**** "+ua+" turn"+"******";
				     lblturnB.setText(" ");
					
				}
				btn00.setForeground(Color.RED);
				btn00.setText(iconb);
				new sound().chance(1);
				btn00.setEnabled(false);
				//winning checkpoint ub00
				checkbtn00usbwin();
			}
			else if(btn00.getText()!=" "&&liveb>1)
			{
				filled1=true;
			}
		/*	else if(liveb>1 && btnb!=1)
			{
				System.out.println("conditional decrement line 1015");
				liveb--;
				lblliveb.setText("X "+liveb);
			}*/
			
			btnb=1;	
			
		}
		
		
				
	}
	else
	{
		JOptionPane.showMessageDialog(null,"Firstly do the toss to play the game");
	}
		
			}
		});
		btn00.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(btn00);
		
		btn01 = new JButton(" ");
		//btn01.setForeground(Color.GREEN);
		btn01.setBackground(Color.BLACK);
		btn01.setFont(new Font("Tahoma", Font.PLAIN, 74));
		btn01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if(!(livea==(chance-1)||liveb==(chance-1)))
				new sound().btnclick();
				if(toss)
				{
					if(!tictacto.consolestr.equals(tictacto.txtrThinkingSkill.getText()))
					{
						btndisturb=true;
					}
					if(usa&&livea>0)
					{
							if(c2%2==0)
							{
							
								btn01.setText(icona);
								c2++;
							
							}
							else
							{
								btn01.setText(" ");
								c2++;
							}
							if(filled1||filled3||filled4||filled5||filled6||filled7||filled8||filled9)
							{
								System.out.println("filled decrement line no 1063");
							  livea--;
							  lbllivea.setText("X "+livea);
							  if(filled1)
							  {
								  btn00.setText(" ");
								  filled1=false;
							  }	  
							  else if(filled3)
							  {
								  btn02.setText(" ");
								  filled3=false;
							  }	  
							  else if(filled4)
							  {
								  btn10.setText(" ");
								  filled4=false;
							  }
							  else if(filled5)
							  {
								  btn11.setText(" ");
								  filled5=false;
							  }  
							  else if(filled6)
							  {
								  btn12.setText(" ");
								  filled6=false;
							  }
							  else if(filled7)
							  {
								  btn20.setText(" ");
								  filled7=false;
							  }
							  else if(filled8)
							  {
								  btn21.setText(" ");
								  filled8=false;
							  }
							  else if(filled9)
							  {
								  btn22.setText(" ");
								  filled9=false;
							  } 
							  
							}	
							//console string
							if(livea==1)
							{
								consolestr+="\n ** completing "+ua+"  request"
										+"\n* gearing your   request to the bot"
										+"\n* locking the "+ua+"choice  ";
							}
							else if(livea==3)
							{
								consolestr+="\n  "+ua+" has "+(livea-1)+" remaining chances ";
							}
							else
							{
								consolestr+="\n  * "+ua+" has remaining chances are "+(chance-livea);
							}
							
							if(livea==1)
							{
								livea--;
								if(livea==0)
								{
									uaendthink=System.nanoTime();
									consolestr+="\n **"+ua+"  thinking time is  "+(uaendthink-uastartthink)+" ns"+" ******";
									btn01.setForeground(Color.BLUE);
									btn01.setText(icona);
									new sound().chance(0);
									btn01.setEnabled(false);
									checkbtn01win();
								if(!endgame)
								{
									if(!bot)
									{
									liveb=chance;
								     lblliveb.setText("X "+liveb);
								     lbllivea.setText("X "+livea);
								     usa=false;
								     usb=true;
								     ubstartthink=System.nanoTime();
								     lblturnA.setText(" ");
								     lblturnB.setText(ub+" turns...");
								     consolestr+=ub+" turns";
									}
									else
									{
										liveb=1;
										 lblliveb.setText("X "+liveb);
									     lbllivea.setText("X "+livea);
									     usa=false;
									     lblturnA.setText(" ");
									     lblturnB.setText(ub+" turns...");
									//    checkempty();
									     botturn=true;
									    if(bot)
									      botplay();
									     
									     
									}
								}	
									
								}
								
								
									
							}
							else if(btn01.getText()!=" "&&livea>1)
							{
								filled2=true;
								
								
							}
						/*	else if(livea>1 && btna!=2)
							{
								System.out.println("conditional decrement line 1176");
								livea--;
								lbllivea.setText("X "+livea);
							}*/
					 btna=2;
					}
					else if(usb&&liveb>0)
					{
						if(d2%2==0)
						{
							btn01.setText(iconb);
							d2++;
						
						}
						else
						{
							btn01.setText(" ");
							d2++;
						}
						if(filled1||filled3||filled4||filled5||filled6||filled7||filled8||filled9)
						{
							System.out.println("filled decrement line no 1197");
						  liveb--;
						  lblliveb.setText("X "+liveb);
						  if(filled1)
						  {
							  btn00.setText(" ");
							  filled1=false;
						  }	  
						  else if(filled3)
						  {
							  btn02.setText(" ");
							  filled3=false;
						  }	  
						  else if(filled4)
						  {
							  btn10.setText(" ");
							  filled4=false;
						  }
						  else if(filled5)
						  {
							  btn11.setText(" ");
							  filled5=false;
						  }  
						  else if(filled6)
						  {
							  btn12.setText(" ");
							  filled6=false;
						  }
						  else if(filled7)
						  {
							  btn20.setText(" ");
							  filled7=false;
						  }
						  else if(filled8)
						  {
							  btn21.setText(" ");
							  filled8=false;
						  }
						  else if(filled9)
						  {
							  btn22.setText(" ");
							  filled9=false;
						  } 
						  
						}	
						//console string
						if(liveb==1)
						{
							consolestr+="\n ** completing "+ub+"  request"
									+"\n* gearing your   request to the bot"
									+"\n* locking the "+ub+"choice  ";
						}
						else if(liveb==3)
						{
							consolestr+="\n  * "+ub+" has "+(liveb-1)+" remaining chances ";
						}
						else
						{
							consolestr+="\n   * "+ub+"has remaining chances are "+(chance-liveb);
						}
						
						if(liveb==1)
						{
							liveb--;
							if(liveb==0)
							{
								ubendthink=System.nanoTime();
								livea=chance;
								consolestr+="\n **"+ub+"  thinking time is  "+(ubendthink-ubstartthink)+" ns"+" ******";
							     lblliveb.setText("X "+liveb);
							     lbllivea.setText("X "+livea);
							     usb=false;
							     usa=true;
							     uastartthink=System.nanoTime();
							     lblturnA.setText(ua+" turns...");
							     consolestr+="\n ****** "+ua+" turns   *****";
							     lblturnB.setText(" ");
								
							}
							btn01.setForeground(Color.RED);
							btn01.setText(iconb);
							new sound().chance(1);
							btn01.setEnabled(false);
							//winning checkpoint ub01
							checkbtn01usbwin();
						}
						else if(btn01.getText()!=" "&&liveb>1)
						{
							filled2=true;
						}
					/*	else if(liveb>1 && btnb!=2)
						{
							System.out.println("conditional decrement line 1285");
							liveb--;
							lblliveb.setText("X "+liveb);
						}*/
						
						btnb=2;
					}
					
			}
				else
				{
					JOptionPane.showMessageDialog(null,"Firstly do the toss to play the game");
				}
	}
		});
		btn01.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(btn01);
		
		btn02 = new JButton(" ");
		//btn02.setForeground(Color.GREEN);
		btn02.setBackground(Color.BLACK);
		btn02.setFont(new Font("Tahoma", Font.PLAIN, 74));
		btn02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if(!(livea==(chance-1)||liveb==(chance-1)))
				   new sound().btnclick();
				if(toss)
				{
					if(!tictacto.consolestr.equals(tictacto.txtrThinkingSkill.getText()))
					{
						btndisturb=true;
					}
					if(usa&&livea>0)
					{
							if(c3%2==0)
							{
								
								btn02.setText(icona);
								c3++;
							
							}
							else
							{
								btn02.setText(" ");
								c3++;
							}
							if(filled1||filled2||filled4||filled5||filled6||filled7||filled8||filled9)
							{
								System.out.println("filled decrement line 1329");
							  livea--;
							  lbllivea.setText("X "+livea);
							  if(filled1)
							  {
								  btn00.setText(" ");
								  filled1=false;
							  }	  
							  else if(filled2)
							  {
								  btn01.setText(" ");
								  filled2=false;
							  }	  
							  else if(filled4)
							  {
								  btn10.setText(" ");
								  filled4=false;
							  }
							  else if(filled5)
							  {
								  btn11.setText(" ");
								  filled5=false;
							  }  
							  else if(filled6)
							  {
								  btn12.setText(" ");
								  filled6=false;
							  }
							  else if(filled7)
							  {
								  btn20.setText(" ");
								  filled7=false;
							  }
							  else if(filled8)
							  {
								  btn21.setText(" ");
								  filled8=false;
							  }
							  else if(filled9)
							  {
								  btn22.setText(" ");
								  filled9=false;
							  } 
							  
							}
							//console string
							if(livea==1)
							{
								consolestr+="\n ** completing "+ua+"  request"
										+"\n* gearing your   request to the bot"
										+"\n* locking the "+ua+"choice  ";
							}
							else if(livea==3)
							{
								consolestr+="\n * "+ua+" has "+(livea-1)+" remaining chances ";
							}
							else
							{
								consolestr+="\n  * "+ua+" has remaining chances are "+(chance-livea);
							}
							
							
							if(livea==1)
							{
								livea--;
								if(livea==0)
								{
									uaendthink=System.nanoTime();
									consolestr+="\n **"+ua+"  thinking time is  "+(uaendthink-uastartthink)+" ns"+" ******";
									btn02.setForeground(Color.BLUE);
									btn02.setText(icona);
									new sound().chance(0);
									btn02.setEnabled(false);
									checkbtn02win();
								if(!endgame)
								{
									if(!bot)
									{
									liveb=chance;
								     lblliveb.setText("X "+liveb);
								     lbllivea.setText("X "+livea);
								     usa=false;
								     usb=true;
								     ubstartthink=System.nanoTime();
								     lblturnA.setText(" ");
								     lblturnB.setText(ub+" turns...");
								     consolestr+="\n *****"+ub+"  turns"+" *****";
									}
									else
									{
										liveb=1;
										 lblliveb.setText("X "+liveb);
									     lbllivea.setText("X "+livea);
									     usa=false;
									     lblturnA.setText(" ");
									     lblturnB.setText(ub+" turns...");  
									  //   checkempty();
									     botturn=true;
										    if(bot)
										      botplay();
									     
									     
									}
								}   
									
								}
								
								 
									
							}
							else if(btn02.getText()!=" "&&livea>1)
							{
								filled3=true;
							}
						/*	else if(livea>1 && btna!=3)
							{
								System.out.println("conditional decrement line 1441");
								livea--;
								lbllivea.setText("X "+livea);
							} */
							btna=3;	
							
					}
					else if(usb&&liveb>0)
					{
						if(d3%2==0)
						{
							btn02.setText(iconb);
							d3++;
						
						}
						else
						{
							btn02.setText(" ");
							d3++;
						}
						if(filled2||filled1||filled4||filled5||filled6||filled7||filled8||filled9)
						{
							System.out.println("filled decrement line 1463");
						  liveb--;
						  lblliveb.setText("X "+liveb);
						  if(filled2)
						  {
							  btn01.setText(" ");
							  filled2=false;
						  }	  
						  else if(filled1)
						  {
							  btn00.setText(" ");
							  filled1=false;
						  }	  
						  else if(filled4)
						  {
							  btn10.setText(" ");
							  filled4=false;
						  }
						  else if(filled5)
						  {
							  btn11.setText(" ");
							  filled5=false;
						  }  
						  else if(filled6)
						  {
							  btn12.setText(" ");
							  filled6=false;
						  }
						  else if(filled7)
						  {
							  btn20.setText(" ");
							  filled7=false;
						  }
						  else if(filled8)
						  {
							  btn21.setText(" ");
							  filled8=false;
						  }
						  else if(filled9)
						  {
							  btn22.setText(" ");
							  filled9=false;
						  } 
						  
						}
						//console string
						if(liveb==1)
						{
							consolestr+="\n ** completing "+ub+"  request"
									+"\n* gearing your   request to the bot"
									+"\n* locking the "+ub+"choice  ";
						}
						else if(liveb==3)
						{
							consolestr+="\n * "+ub+" has "+(liveb-1)+" remaining chances ";
						}
						else
						{
							consolestr+="\n  * "+ub+" has remaining chances are "+(chance-liveb);
						}
						
						if(liveb==1)
						{
							liveb--;
							if(liveb==0)
							{
								ubendthink=System.nanoTime();
								consolestr+="\n **"+ub+"  thinking time is  "+(ubendthink-ubstartthink)+" ns"+" ******";
								livea=chance;
							     lblliveb.setText("X "+liveb);
							     lbllivea.setText("X "+livea);
							     usb=false;
							     usa=true;
							     uastartthink=System.nanoTime();
							     
							     lblturnA.setText(ua+" turns...");
							     consolestr+="\n *****"+ua+" turns ******";
							     lblturnB.setText(" ");
								
							}
							btn02.setForeground(Color.RED);
							btn02.setText(iconb);
							new sound().chance(1);
							btn02.setEnabled(false);
							//winning checkpoint for ub02
							checkbtn02usbwin();
						}
						else if(btn02.getText()!=" "&&liveb>1)
						{
							filled3=true;
						}
					/*	else if(liveb>1 && btnb!=3)
						{
							System.out.println("conditional decrement line 1552");
							liveb--;
							lblliveb.setText("X "+liveb);
						}*/
						
						btnb=3;	
					}
					
			}
				else
				{
					JOptionPane.showMessageDialog(null,"Firstly do the toss to play the game");
				}
	
				
			}
		});
		btn02.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(btn02);
		
		btn10 = new JButton(" ");
		//btn10.setForeground(Color.GREEN);
		btn10.setBackground(Color.BLACK);
		btn10.setFont(new Font("Tahoma", Font.PLAIN, 74));
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if(!(livea==(chance-1)||liveb==(chance-1)))
				new sound().btnclick();
				if(toss)
				{
					if(!tictacto.consolestr.equals(tictacto.txtrThinkingSkill.getText()))
					{
						btndisturb=true;
					}
					if(usa&&livea>0)
					{
							if(c4%2==0)
							{
							
								btn10.setText(icona);
								c4++;
							
							}
							else
							{
								btn10.setText(" ");
								c4++;
							}
							if(filled2||filled3||filled1||filled5||filled6||filled7||filled8||filled9)
							{
								System.out.println("filled decrement line 1598");
							  livea--;
							  lbllivea.setText("X "+livea);
							  if(filled2)
							  {
								  btn01.setText(" ");
								  filled2=false;
							  }	  
							  else if(filled3)
							  {
								  btn02.setText(" ");
								  filled3=false;
							  }	  
							  else if(filled1)
							  {
								  btn00.setText(" ");
								  filled1=false;
							  }
							  else if(filled5)
							  {
								  btn11.setText(" ");
								  filled5=false;
							  }  
							  else if(filled6)
							  {
								  btn12.setText(" ");
								  filled6=false;
							  }
							  else if(filled7)
							  {
								  btn20.setText(" ");
								  filled7=false;
							  }
							  else if(filled8)
							  {
								  btn21.setText(" ");
								  filled8=false;
							  }
							  else if(filled9)
							  {
								  btn22.setText(" ");
								  filled9=false;
							  } 
							  
							}
							//console string
							if(livea==1)
							{
								consolestr+="\n ** completing "+ua+"  request"
										+"\n* gearing your   request to the bot"
										+"\n* locking the "+ua+"choice  ";
							}
							else if(livea==3)
							{
								consolestr+="\n * "+ua+" has "+(livea-1)+" remaining chances ";
							}
							else
							{
								consolestr+="\n * "+ua+" has remaining chances are "+(chance-livea);
							}
							
							if(livea==1)
							{
								uaendthink=System.nanoTime();
								consolestr+="\n **"+ua+"  thinking time is  "+(uaendthink-uastartthink)+" ns"+" ******";
								livea--;
								if(livea==0)
								{
									btn10.setForeground(Color.BLUE);
									btn10.setText(icona);
									new sound().chance(0);
									btn10.setEnabled(false);
									checkbtn10win();
								if(!endgame)
								{
									if(!bot)
									{
									liveb=chance;
								     lblliveb.setText("X "+liveb);
								     lbllivea.setText("X "+livea);
								     usa=false;
								     usb=true;
								     lblturnA.setText(" ");
								     lblturnB.setText(ub+" turns...");
								     consolestr+="\n *****"+ub+" turns"+"******";
								     ubstartthink=System.nanoTime();
									}
									else
									{
										liveb=1;
										 lblliveb.setText("X "+liveb);
									     lbllivea.setText("X "+livea);
									     usa=false;
									     lblturnA.setText(" ");
									   
									     lblturnB.setText(ub+" turns...");  
									    
									   //  checkempty();
									     botturn=true;
										    if(bot)
										      botplay();
									     
									     
									}
								}	
							}
								
								
								
									
							}
							else if(btn10.getText()!=" "&&livea>1)
							{
								filled4=true;
								
							}
							/*else if(livea>1 && btna!=4)
							{
								System.out.println("conditional decrement line 1712");
								livea--;
								lbllivea.setText("X "+livea);
							}*/
							btna=4;
					}
					else if(usb&&liveb>0)
					{
						if(d4%2==0)
						{
							btn10.setText(iconb);
							d4++;
						
						}
						else
						{
							btn10.setText(" ");
							d4++;
						}
						if(filled2||filled3||filled1||filled5||filled6||filled7||filled8||filled9)
						{
							System.out.println("filled decrement line 1733");
						  liveb--;
						  lblliveb.setText("X "+liveb);
						  if(filled2)
						  {
							  btn01.setText(" ");
							  filled2=false;
						  }	  
						  else if(filled3)
						  {
							  btn02.setText(" ");
							  filled3=false;
						  }	  
						  else if(filled1)
						  {
							  btn00.setText(" ");
							  filled1=false;
						  }
						  else if(filled5)
						  {
							  btn11.setText(" ");
							  filled5=false;
						  }  
						  else if(filled6)
						  {
							  btn12.setText(" ");
							  filled6=false;
						  }
						  else if(filled7)
						  {
							  btn20.setText(" ");
							  filled7=false;
						  }
						  else if(filled8)
						  {
							  btn21.setText(" ");
							  filled8=false;
						  }
						  else if(filled9)
						  {
							  btn22.setText(" ");
							  filled9=false;
						  } 
						  
						}
						//console string
						if(liveb==1)
						{
							consolestr+="\n ** completing "+ub+"  request"
									+"\n* gearing your   request to the bot"
									+"\n* locking the "+ub+"choice  ";
						}
						else if(liveb==3)
						{
							consolestr+="\n  * "+ub+" has "+(liveb-1)+" remaining chances ";
						}
						else
						{
							consolestr+="\n * "+ub+" has remaining chances are "+(chance-liveb);
						}
						
						if(liveb==1)
						{
							liveb--;
							if(liveb==0)
							{
								ubendthink=System.nanoTime();
								consolestr+="\n **"+ub+"  thinking time is  "+(ubendthink-ubstartthink)+" ns"+" ******";
								livea=chance;
							     lblliveb.setText("X "+liveb);
							     lbllivea.setText("X "+livea);
							     usb=false;
							     usa=true;
							     uastartthink=System.nanoTime();
							     lblturnA.setText(ua+" turns...");
							     consolestr+="\n *****"+ua+"turns *******";
							     lblturnB.setText(" ");
								
							}
							btn10.setForeground(Color.RED);
							btn10.setText(iconb);
							new sound().chance(1);
							btn10.setEnabled(false);
							//winning checkpoint for ub10
							checkbtn10usbwin();
							
						}
						else if(btn10.getText()!=" "&&liveb>1)
						{
							filled4=true;
						}
						/*else if(liveb>1 && btnb!=4)
						{
							System.out.println("conditional decrement line 1822");
							liveb--;
							lblliveb.setText("X "+liveb);
						}*/
					    
					btnb=4;	
						
					}
			}
				else
				{
					JOptionPane.showMessageDialog(null,"Firstly do the toss to play the game");
				}
			
			}
		});
		btn10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(btn10);
		
		btn11 = new JButton(" ");
		//btn11.setForeground(Color.RED);
		btn11.setBackground(Color.BLACK);
		btn11.setFont(new Font("Tahoma", Font.PLAIN, 74));
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if(!(livea==(chance-1)||liveb==(chance-1)))
				new sound().btnclick();
				if(toss)
				{
					if(!tictacto.consolestr.equals(tictacto.txtrThinkingSkill.getText()))
					{
						btndisturb=true;
					}
					if(usa&&livea>0)
					{
							if(c5%2==0)
							{
							
								btn11.setText(icona);
								c5++;
							
							}
							else
							{
								btn11.setText(" ");
								c5++;
							}
							if(filled2||filled3||filled4||filled1||filled6||filled7||filled8||filled9)
							{
								System.out.println("filled decrement line 1867");
							  livea--;
							  lbllivea.setText("X "+livea);
							  if(filled2)
							  {
								  btn01.setText(" ");
								  filled2=false;
							  }	  
							  else if(filled3)
							  {
								  btn02.setText(" ");
								  filled3=false;
							  }	  
							  else if(filled4)
							  {
								  btn10.setText(" ");
								  filled4=false;
							  }
							  else if(filled1)
							  {
								  btn00.setText(" ");
								  filled1=false;
							  }  
							  else if(filled6)
							  {
								  btn12.setText(" ");
								  filled6=false;
							  }
							  else if(filled7)
							  {
								  btn20.setText(" ");
								  filled7=false;
							  }
							  else if(filled8)
							  {
								  btn21.setText(" ");
								  filled8=false;
							  }
							  else if(filled9)
							  {
								  btn22.setText(" ");
								  filled9=false;
							  } 
							  
							}
							
							//console string
							if(livea==1)
							{
								consolestr+="\n ** completing "+ua+"  request"
										+"\n* gearing your   request to the bot"
										+"\n* locking the "+ua+"choice  ";
							}
							else if(livea==3)
							{
								consolestr+="\n  * "+ua+" has "+(livea-1)+" remaining chances ";
							}
							else
							{
								consolestr+="\n   * "+ua+" has remaining chances are "+(chance-livea);
							}
							
							if(livea==1)
							{
								livea--;
								if(livea==0)
								{
									uaendthink=System.nanoTime();
									consolestr+="\n **"+ua+"  thinking time is  "+(uaendthink-uastartthink)+" ns"+" ******";
									
									btn11.setForeground(Color.BLUE);
									btn11.setText(icona);
									new sound().chance(0);
									btn11.setEnabled(false);
									checkbtn11win();
								if(!endgame)
								{
									if(!bot)
									{
									liveb=chance;
								     lblliveb.setText("X "+liveb);
								     lbllivea.setText("X "+livea);
								     usa=false;
								     usb=true;
								     lblturnA.setText(" ");
								     ubstartthink=System.nanoTime();
								     consolestr+="\n *****"+ub+" turns *****";
								     lblturnB.setText(ub+" turns...");
									}
									else
									{
										liveb=1;
										 lblliveb.setText("X "+liveb);
									     lbllivea.setText("X "+livea);
									     usa=false;
									     lblturnA.setText(" ");
									     lblturnB.setText(ub+" turns...");  
									   //  checkempty();
									     botturn=true;
										    if(bot)
										      botplay();
									     
									     
									}
								}   		 
									
								}
								
								
									
							}
							else if(btn11.getText()!=" "&&livea>1)
							{
								filled5=true;
							}
							/*else if(livea>1 && btna!=5)
							{
								System.out.println("conditional decrement line 1980");
								livea--;
								lbllivea.setText("X "+livea);
							}*/
							btna=5;
					}
					else if(usb&&liveb>0)
					{
						if(d5%2==0)
						{
							btn11.setText(iconb);
							d5++;
						
						}
						else
						{
							btn11.setText(" ");
							d5++;
						}
						if(filled2||filled3||filled4||filled1||filled6||filled7||filled8||filled9)
						{
							System.out.println("filled decrement line 2001");
						  liveb--;
						  lblliveb.setText("X "+liveb);
						  if(filled2)
						  {
							  btn01.setText(" ");
							  filled2=false;
						  }	  
						  else if(filled3)
						  {
							  btn02.setText(" ");
							  filled3=false;
						  }	  
						  else if(filled4)
						  {
							  btn10.setText(" ");
							  filled4=false;
						  }
						  else if(filled1)
						  {
							  btn00.setText(" ");
							  filled1=false;
						  }  
						  else if(filled6)
						  {
							  btn12.setText(" ");
							  filled6=false;
						  }
						  else if(filled7)
						  {
							  btn20.setText(" ");
							  filled7=false;
						  }
						  else if(filled8)
						  {
							  btn21.setText(" ");
							  filled8=false;
						  }
						  else if(filled9)
						  {
							  btn22.setText(" ");
							  filled9=false;
						  } 
						  
						}
						
						//console string
						if(liveb==1)
						{
							consolestr+="\n ** completing "+ub+"  request"
									+"\n* gearing your   request to the bot"
									+"\n* locking the "+ub+"choice  ";
						}
						else if(liveb==3)
						{
							consolestr+="\n  * "+ub+" has "+(liveb-1)+" remaining chances ";
						}
						else
						{
							consolestr+="\n  * "+ub+"has remaining chances are "+(chance-liveb);
						}
						
					    if(liveb==1)
						{
							liveb--;
							if(liveb==0)
							{
								ubendthink=System.nanoTime();
								consolestr+="\n **"+ub+"  thinking time is  "+(ubendthink-ubstartthink)+" ns"+" ******";
								livea=chance;
							     lblliveb.setText("X "+liveb);
							     lbllivea.setText("X "+livea);
							     usb=false;
							     usa=true;
							     uastartthink=System.nanoTime();
							     consolestr+="\n ****"+ua+"  turns ****"; 
							     lblturnA.setText(ua+" turns");
							     lblturnB.setText(" ");
								
							}
							btn11.setForeground(Color.RED);
							btn11.setText(iconb);
							new sound().chance(1);
							btn11.setEnabled(false);
							//winning checkpoint for ub11
							checkbtn11usbwin();
						}
						else if(btn11.getText()!=" "&&liveb>1)
						{
							filled5=true;
							
						}
					/*	else if(liveb>1 && btnb!=5)
						{
							System.out.println("conditional decrement line 2091");
							liveb--;
							lblliveb.setText("X "+liveb);
						} */
						btnb=5;
					}
			}
				else
				{
					JOptionPane.showMessageDialog(null,"Firstly do the toss to play the game");
				}
				
			}
		});
		btn11.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(btn11);
		
		btn12 = new JButton(" ");
	//	btn12.setForeground(Color.GREEN);
		btn12.setBackground(Color.BLACK);
		btn12.setFont(new Font("Tahoma", Font.PLAIN, 74));
		btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if(!(livea==(chance-1)||liveb==(chance-1)))
				new sound().btnclick();
				if(toss)
				{
					if(!tictacto.consolestr.equals(tictacto.txtrThinkingSkill.getText()))
					{
						btndisturb=true;
					}
					if(usa&&livea>0)
					{
							if(c6%2==0)
							{
							
								btn12.setText(icona);
								c6++;
							
							}
							else
							{
								btn12.setText(" ");
								c6++;
							}
							if(filled2||filled3||filled4||filled5||filled1||filled7||filled8||filled9)
							{
								System.out.println("filled decrement line 2134");
							  livea--;
							  lbllivea.setText("X "+livea);
							  if(filled2)
							  {
								  btn01.setText(" ");
								  filled2=false;
							  }	  
							  else if(filled3)
							  {
								  btn02.setText(" ");
								  filled3=false;
							  }	  
							  else if(filled4)
							  {
								  btn10.setText(" ");
								  filled4=false;
							  }
							  else if(filled5)
							  {
								  btn11.setText(" ");
								  filled5=false;
							  }  
							  else if(filled1)
							  {
								  btn00.setText(" ");
								  filled1=false;
							  }
							  else if(filled7)
							  {
								  btn20.setText(" ");
								  filled7=false;
							  }
							  else if(filled8)
							  {
								  //System.out.println("here loop comes bro...");
								  try
								  {
								  btn21.setText(" ");
								  }
								  
								  catch(Exception e)
								  {
									  //JOptionPane.showMessageDialog(null, e);
								  }
								  filled8=false;
							  }
							  else if(filled9)
							  {
								  btn22.setText(" ");
								  filled9=false;
							  } 
							  
							}
							
							//console string
							if(livea==1)
							{
								consolestr+="\n ** completing "+ua+"  request"
										+"\n* gearing your   request to the bot"
										+"\n* locking the "+ua+"choice  ";
							}
							else if(livea==3)
							{
								consolestr+="\n  * "+ua+" has "+(livea-1)+" remaining chances ";
							}
							else
							{
								consolestr+="\n  * "+ua+" has remaining chances are "+(chance-livea);
							}
							
							if(livea==1)
							{
								livea--;
								if(livea==0)
								{
									uaendthink=System.nanoTime();
									consolestr+="\n **"+ua+"  thinking time is  "+(uaendthink-uastartthink)+" ns"+" ******";
									btn12.setForeground(Color.BLUE);
									btn12.setText(icona);
									new sound().chance(0);
									btn12.setEnabled(false);
									checkbtn12win();
								if(!endgame)
								{
									if(!bot)
									{
									liveb=chance;
								     lblliveb.setText("X "+liveb);
								     lbllivea.setText("X "+livea);
								     usa=false;
								     usb=true;
								     lblturnA.setText(" ");
								     ubstartthink=System.nanoTime();
								     consolestr+="\n ****"+ub+" turns ****";
								     
								     lblturnB.setText(ub+" turns...");
									}
									else
									{
										liveb=1;
										 lblliveb.setText("X "+liveb);
									     lbllivea.setText("X "+livea);
									     usa=false;
									     lblturnA.setText(" ");
									     lblturnB.setText(ub+" turns...");  
									 //    checkempty();
									     botturn=true;
										    if(bot)
										      botplay();
									     
									     
									}
								}		
								}
								
								
									
							}
							else if(btn12.getText()!=" "&&livea>1)
							{
								filled6=true;
							}
						/*	else if(livea>1 && btna!=6)
							{
								System.out.println("conditional decrement line 2255");
								livea--;
								lbllivea.setText("X "+livea);
							}*/
							btna=6;
					}
					else if(usb&&liveb>0)
					{
						if(d6%2==0)
						{
							btn12.setText(iconb);
							d6++;
						
						}
						else
						{
							btn12.setText(" ");
							d6++;
						}
						if(filled2||filled3||filled4||filled5||filled1||filled7||filled8||filled9)
						{
							System.out.println("filled decrement line 2276");
						  liveb--;
						  lblliveb.setText("X "+liveb);
						  if(filled2)
						  {
							  btn01.setText(" ");
							  filled2=false;
						  }	  
						  else if(filled3)
						  {
							  btn02.setText(" ");
							  filled3=false;
						  }	  
						  else if(filled4)
						  {
							  btn10.setText(" ");
							  filled4=false;
						  }
						  else if(filled5)
						  {
							  btn11.setText(" ");
							  filled5=false;
						  }  
						  else if(filled1)
						  {
							  btn00.setText(" ");
							  filled1=false;
						  }
						  else if(filled7)
						  {
							  btn20.setText(" ");
							  filled7=false;
						  }
						  else if(filled8)
						  {
							 // System.out.println("here loop comes");
							  btn21.setText(" ");
							  filled8=false;
						  }
						  else if(filled9)
						  {
							  btn22.setText(" ");
							  filled9=false;
						  } 
						  
						}
						
						//console string
						if(liveb==1)
						{
							consolestr+="\n ** completing "+ub+"  request"
									+"\n* gearing your   request to the bot"
									+"\n* locking the "+ub+"choice  ";
						}
						else if(liveb==3)
						{
							consolestr+="\n  * "+ub+" has "+(liveb-1)+" remaining chances ";
						}
						else
						{
							consolestr+="\n  * "+ub+" has remaining chances are "+(chance-liveb);
						}
						
						if(liveb==1)
						{
							liveb--;
							if(liveb==0)
							{
								ubendthink=System.nanoTime();
								consolestr+="\n **"+ub+"  thinking time is  "+(ubendthink-ubstartthink)+" ns"+" ******";
								livea=chance;
							     lblliveb.setText("X "+liveb);
							     lbllivea.setText("X "+livea);
							     usb=false;
							     usa=true;
							     uastartthink=System.nanoTime();
							     consolestr+="\n ****"+ua+"turns ****";
							     lblturnA.setText(ua+" turns");
							     lblturnB.setText(" ");
								
							}
							btn12.setForeground(Color.RED);
							btn12.setText(iconb);
							new sound().chance(1);
							btn12.setEnabled(false);
							//winning checkpoint for ub12
							checkbtn12usbwin();
						}
						else if(btn12.getText()!=" "&&liveb>1)
						{
							filled6=true;
						}
						/*else if(liveb>1 && btnb!=6)
						{
							System.out.println("conditional decrement line 2366");
							liveb--;
							lblliveb.setText("X "+liveb);
						}*/
						btnb=6;
					}
			}
				else
				{
					JOptionPane.showMessageDialog(null,"Firstly do the toss to play the game");
				}
				
			}
		});
		btn12.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(btn12);
		
		btn20 = new JButton(" ");
	//	btn20.setForeground(Color.GREEN);
		btn20.setBackground(Color.BLACK);
		btn20.setFont(new Font("Tahoma", Font.PLAIN, 74));
		btn20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if(!(livea==(chance-1)||liveb==(chance-1)))
				new sound().btnclick();
				if(toss)
				{
					if(!tictacto.consolestr.equals(tictacto.txtrThinkingSkill.getText()))
					{
						btndisturb=true;
					}
					if(usa&&livea>0)
					{
							if(c7%2==0)
							{
							
								btn20.setText(icona);
								c7++;
							
							}
							else
							{
								btn20.setText(" ");
								c7++;
							}
							if(filled2||filled3||filled4||filled5||filled6||filled1||filled8||filled9)
							{
								System.out.println("filled decrement line 2409");
							  livea--;
							  lblturnA.setText("X "+livea);
							  if(filled2)
							  {
								  btn01.setText(" ");
								  filled2=false;
							  }	  
							  else if(filled3)
							  {
								  btn02.setText(" ");
								  filled3=false;
							  }	  
							  else if(filled4)
							  {
								  btn10.setText(" ");
								  filled4=false;
							  }
							  else if(filled5)
							  {
								  btn11.setText(" ");
								  filled5=false;
							  }  
							  else if(filled6)
							  {
								  btn12.setText(" ");
								  filled6=false;
							  }
							  else if(filled1)
							  {
								  btn00.setText(" ");
								  filled1=false;
							  }
							  else if(filled8)
							  {
								  btn21.setText(" ");
								  filled8=false;
							  }
							  else if(filled9)
							  {
								  btn22.setText(" ");
								  filled9=false;
							  } 
							  
							}
							
							//console string
							if(livea==1)
							{
								consolestr+="\n ** completing "+ua+"  request"
										+"\n* gearing your   request to the bot"
										+"\n* locking the "+ua+"choice  ";
							}
							else if(livea==3)
							{
								consolestr+="\n  * "+ua+" has "+(livea-1)+" remaining chances ";
							}
							else
							{
								consolestr+="\n  * "+ua+" has remaining chances are "+(chance-livea);
							}
							
							if(livea==1)
							{
								livea--;
								if(livea==0)
								{
									uaendthink=System.nanoTime();
									consolestr+="\n **"+ua+"  thinking time is  "+(uaendthink-uastartthink)+" ns"+" ******";
									btn20.setForeground(Color.BLUE);
									btn20.setText(icona);
									new sound().chance(0);
									btn20.setEnabled(false);
									checkbtn20win();
								if(!endgame)
								{
									if(!bot)
									{
									liveb=chance;
								     lblliveb.setText("X "+liveb);
								     lbllivea.setText("X "+livea);
								     usa=false;
								     usb=true;
								     lblturnA.setText(" ");
								     ubstartthink=System.nanoTime();
								     consolestr+="\n "+ub+" turns...";
								     lblturnB.setText(ub+" turns...");
									}
									else
									{
										liveb=1;
										 lblliveb.setText("X "+liveb);
									     lbllivea.setText("X "+livea);
									     usa=false;
									     lblturnA.setText(" ");
									     lblturnB.setText(ub+" turns...");  
									  //   checkempty();
									     botturn=true;
										    if(bot)
										      botplay();
									     
									     
									}
								}
								}
								
									
							}
							else if(btn20.getText()!=" "&&livea>1)
							{
								filled7=true;
							}
							/*else if(livea>1 && btna!=7)
							{
								System.out.println("conditional decrement line 2519");
								livea--;
								lbllivea.setText("X "+livea);
							}*/
						btna=7;	
					}
					else if(usb&&liveb>0)
					{
						if(d7%2==0)
						{
							btn20.setText(iconb);
							d7++;
						
						}
						else
						{
							btn20.setText(" ");
							d7++;
						}
						if(filled2||filled3||filled4||filled5||filled6||filled1||filled8||filled9)
						{
							System.out.println("filled decrement line 2540");
						  liveb--;
						  lbllivea.setText("X "+livea);
						  if(filled2)
						  {
							  btn01.setText(" ");
							  filled2=false;
						  }	  
						  else if(filled3)
						  {
							  btn02.setText(" ");
							  filled3=false;
						  }	  
						  else if(filled4)
						  {
							  btn10.setText(" ");
							  filled4=false;
						  }
						  else if(filled5)
						  {
							  btn11.setText(" ");
							  filled5=false;
						  }  
						  else if(filled6)
						  {
							  btn12.setText(" ");
							  filled6=false;
						  }
						  else if(filled1)
						  {
							  btn00.setText(" ");
							  filled1=false;
						  }
						  else if(filled8)
						  {
							  btn21.setText(" ");
							  filled8=false;
						  }
						  else if(filled9)
						  {
							  btn22.setText(" ");
							  filled9=false;
						  } 
						  
						}
						
						//console string
						if(liveb==1)
						{
							consolestr+="\n ** completing "+ub+"  request"
									+"\n* gearing your   request to the bot"
									+"\n* locking the "+ub+"choice  ";
						}
						else if(liveb==3)
						{
							consolestr+="\n  * "+ub+" has "+(liveb-1)+" remaining chances ";
						}
						else
						{
							consolestr+="\n  * "+ub+" has remaining chances are "+(chance-liveb);
						}
						
						if(liveb==1)
						{
							liveb--;
							if(liveb==0)
							{
								ubendthink=System.nanoTime();
								consolestr+="\n **"+ua+"  thinking time is  "+(uaendthink-uastartthink)+" ns"+" ******";
								livea=chance;
							     lblliveb.setText("X "+liveb);
							     lbllivea.setText("X "+livea);
							     usb=false;
							     usa=true;
							     uastartthink=System.nanoTime();
							     consolestr+="\n *****"+ua+" turns *****";
							     lblturnA.setText(ua+" turns");
							     lblturnB.setText(" ");
								
							}
							btn20.setForeground(Color.RED);
							btn20.setText(iconb);
							new sound().chance(0);
							btn20.setEnabled(false);
							//winning checkpoint for ub20
							checkbtn20usbwin();
						}
						else if(btn20.getText()!=" "&&liveb>1)
						{
							filled7=true;
						}
						/*else if(liveb>1 && btnb!=7)
						{
							System.out.println("conditional decrement line 2629");
							liveb--;
							lblliveb.setText("X "+liveb);
						}*/
						btnb=7;
					}
			}
				else
				{
					JOptionPane.showMessageDialog(null,"Firstly do the toss to play the game");
				}
				
			}
		});
		btn20.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(btn20);
		
		btn21 = new JButton(" ");
		//btn21.setForeground(Color.GREEN);
		btn21.setBackground(Color.BLACK);
		btn21.setFont(new Font("Tahoma", Font.PLAIN, 74));
		btn21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if(!(livea==(chance-1)||liveb==(chance-1)))
				new sound().btnclick();
				if(toss)
				{
					if(!tictacto.consolestr.equals(tictacto.txtrThinkingSkill.getText()))
					{
						btndisturb=true;
					}
					if(usa&&livea>0)
					{
							if(c8%2==0)
							{
							
								btn21.setText(icona);
								c8++;
							
							}
							else
							{
								btn21.setText(" ");
								c8++;
							}
							if(filled2||filled3||filled4||filled5||filled6||filled7||filled1||filled9)
							{
								System.out.println("filled decrement line 2672");
							  livea--;
							  lbllivea.setText("X "+livea);
							  if(filled2)
							  {
								  btn01.setText(" ");
								  filled2=false;
							  }	  
							  else if(filled3)
							  {
								  btn02.setText(" ");
								  filled3=false;
							  }	  
							  else if(filled4)
							  {
								  btn10.setText(" ");
								  filled4=false;
							  }
							  else if(filled5)
							  {
								  btn11.setText(" ");
								  filled5=false;
							  }  
							  else if(filled6)
							  {
								  btn12.setText(" ");
								  filled6=false;
							  }
							  else if(filled7)
							  {
								  btn20.setText(" ");
								  filled7=false;
							  }
							  else if(filled1)
							  {
								  btn00.setText(" ");
								  filled1=false;
							  }
							  else if(filled9)
							  {
								  btn22.setText(" ");
								  filled9=false;
							  } 
							  
							}
							
							//console string
							if(livea==1)
							{
								consolestr+="\n ** completing "+ua+"  request"
										+"\n* gearing your   request to the bot"
										+"\n* locking the "+ua+"choice  ";
							}
							else if(livea==3)
							{
								consolestr+="\n  * "+ua+" has "+(livea-1)+" remaining chances ";
							}
							else
							{
								consolestr+="\n  * "+ua+" has remaining chances are "+(chance-livea);
							}
							
							if(livea==1)
							{
								
								livea--;
								if(livea==0)
								{
									uaendthink=System.nanoTime();
									consolestr+="\n **"+ua+"  thinking time is  "+(uaendthink-uastartthink)+" ns"+" ******";
									btn21.setForeground(Color.BLUE);
									btn21.setText(icona);
									new sound().chance(0);
									btn21.setEnabled(false);
									checkbtn21win();
								if(!endgame)
								{
									if(!bot)
									{
									liveb=chance;
								     lblliveb.setText("X "+liveb);
								     lbllivea.setText("X "+livea);
								     usa=false;
								     usb=true;
								     ubstartthink=System.nanoTime();
								     consolestr+="\n *****"+ub+" turn *****";
								     
								     lblturnA.setText(" ");
								     lblturnB.setText(ub+" turns...");
									}
									else
									{
										liveb=1;
										 lblliveb.setText("X "+liveb);
									     lbllivea.setText("X "+livea);
									     usa=false;
									     lblturnA.setText(" ");
									     lblturnB.setText(ub+" turns...");  
									  //   checkempty();
									     botturn=true;
										    if(bot)
										      botplay();
									     
									     
									}
								}
								}
								
								
									
							}
							else if(btn21.getText()!=" "&&livea>1)
							{
							   filled8=true;
							   
							}
						/*	else if(livea>1 && btna!=8)
							{
								System.out.println("conditional decrement line 2786");
								livea--;
								lbllivea.setText("X "+livea);
							}*/
							btna=8;
					}
					else if(usb&&liveb>0)
					{
						if(d8%2==0)
						{
							btn21.setText(iconb);
							d8++;
						
						}
						else
						{
							btn21.setText(" ");
							d8++;
						}
						if(filled2||filled3||filled4||filled5||filled6||filled7||filled1||filled9)
						{
							System.out.println("filled decrement line 2807");
						  liveb--;
						  lblliveb.setText("X "+liveb);
						  if(filled2)
						  {
							  btn01.setText(" ");
							  filled2=false;
						  }	  
						  else if(filled3)
						  {
							  btn02.setText(" ");
							  filled3=false;
						  }	  
						  else if(filled4)
						  {
							  btn10.setText(" ");
							  filled4=false;
						  }
						  else if(filled5)
						  {
							  btn11.setText(" ");
							  filled5=false;
						  }  
						  else if(filled6)
						  {
							  btn12.setText(" ");
							  filled6=false;
						  }
						  else if(filled7)
						  {
							  btn20.setText(" ");
							  filled7=false;
						  }
						  else if(filled1)
						  {
							  btn00.setText(" ");
							  filled1=false;
						  }
						  else if(filled9)
						  {
							  btn22.setText(" ");
							  filled9=false;
						  } 
						  
						}
						
						//console string
						if(liveb==1)
						{
							consolestr+="\n ** completing "+ub+"  request"
									+"\n* gearing your   request to the bot"
									+"\n* locking the "+ub+"choice  ";
						}
						else if(liveb==3)
						{
							consolestr+="\n  * "+ub+" has "+(liveb-1)+" remaining chances ";
						}
						else
						{
							consolestr+="\n  * "+ub+" has remaining chances are "+(chance-liveb);
						}
						
						if(liveb==1)
						{
							liveb--;
							if(liveb==0)
							{
								ubendthink=System.nanoTime();
								consolestr+="\n **"+ub+"  thinking time is  "+(ubendthink-ubstartthink)+" ns"+" ******";
								livea=chance;
							     lblliveb.setText("X "+liveb);
							     lbllivea.setText("X "+livea);
							     usb=false;
							     usa=true;
							     uastartthink=System.nanoTime();
							     consolestr+="\n *****"+ua+" turns *****";
							     lblturnA.setText(ua+" turns...");
								 lblturnB.setText(" ");
							}
							btn21.setForeground(Color.RED);
							btn21.setText(iconb);
							new sound().chance(1);
							btn21.setEnabled(false);
							//winning checkpoint for ub21
							checkbtn21usbwin();
							
						}
						else if(btn21.getText()!=" "&&liveb>1)
						{
							filled8=true;
						}
					/*	else if(liveb>1 && btnb!=8)
						{
							System.out.println("conditional decrement line 2896");
							liveb--;
							lblliveb.setText("X "+liveb);
						}*/
						btnb=8;
					}
			}
				else
				{
					JOptionPane.showMessageDialog(null,"Firstly do the toss to play the game");
				}
			
			}
		});
		btn21.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(btn21);
		
		btn22 = new JButton(" ");
		//btn22.setForeground(Color.GREEN);
		btn22.setBackground(Color.BLACK);
		btn22.setFont(new Font("Tahoma", Font.PLAIN, 74));
		btn22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if(!(livea==(chance-1)||liveb==(chance-1)))
				new sound().btnclick();
				if(toss)
				{
					if(!tictacto.consolestr.equals(tictacto.txtrThinkingSkill.getText()))
					{
						btndisturb=true;
					}
					if(usa&&livea>0)
					{
							if(c9%2==0)
							{
							
								btn22.setText(icona);
								c9++;
							
							}
							else
							{
								btn22.setText(" ");
								c9++;
							}
							if(filled2||filled3||filled4||filled5||filled6||filled7||filled8||filled1)
							{
								System.out.println("filled decrement line 2939");
							  livea--;
							  lbllivea.setText("X "+livea);
							  if(filled2)
							  {
								  btn01.setText(" ");
								  filled2=false;
							  }	  
							  else if(filled3)
							  {
								  btn02.setText(" ");
								  filled3=false;
							  }	  
							  else if(filled4)
							  {
								  btn10.setText(" ");
								  filled4=false;
							  }
							  else if(filled5)
							  {
								  btn11.setText(" ");
								  filled5=false;
							  }  
							  else if(filled6)
							  {
								  btn12.setText(" ");
								  filled6=false;
							  }
							  else if(filled7)
							  {
								  btn20.setText(" ");
								  filled7=false;
							  }
							  else if(filled8)
							  {
								  btn21.setText(" ");
								  filled8=false;
							  }
							  else if(filled1)
							  {
								  btn00.setText(" ");
								  filled1=false;
							  } 
							  
							}
							
							//console string
							if(livea==1)
							{
								consolestr+="\n ** completing "+ua+"  request"
										+"\n* gearing your   request to the bot"
										+"\n* locking the "+ua+"choice  ";
							}
							else if(livea==3)
							{
								consolestr+="\n  * "+ua+" has "+(livea-1)+" remaining chances ";
							}
							else
							{
								consolestr+="\n  * "+ua+"has remaining chances are "+(chance-livea);
							}
							
							if(livea==1)
							{
								livea--;
								if(livea==0)
								{
									uaendthink=System.nanoTime();
									consolestr+="\n **"+ua+"  thinking time is  "+(uaendthink-uastartthink)+" ns"+" ******";
									btn22.setForeground(Color.BLUE);
									btn22.setText(icona);
									new sound().chance(0);
									btn22.setEnabled(false);
									checkbtn22win();
								if(!endgame)
								{
									if(!bot)
									{
									liveb=chance;
								     lblliveb.setText("X "+liveb);
								     lbllivea.setText("X "+livea);
								     usa=false;
								     usb=true;
								     ubstartthink=System.nanoTime();
								     consolestr+="\n *****"+ub+"  turns *****";
								     lblturnA.setText(" ");
								     lblturnB.setText(ub+" turns...");
									}
									else
									{
										liveb=1;
										 lblliveb.setText("X "+liveb);
									     lbllivea.setText("X "+livea);
									     usa=false;
									     lblturnA.setText(" ");
									     lblturnB.setText(ub+" turns...");  
									  //   checkempty();
									     botturn=true;
										    if(bot)
										      botplay();
									     
									     
									}
								 }	
								}
								
								
									
							}
							else if(btn22.getText()!=" "&&livea>1)
							{
								filled9=true;
							}
						/*	else if(livea>1 && btna!=9)
							{
								System.out.println("conditional decrement line 3050");
								livea--;
								lbllivea.setText("X "+livea);
							}*/
							btna=9;
					}
					else if(usb&&liveb>0)
					{
						if(d9%2==0)
						{
							btn22.setText(iconb);
							d9++;
						
						}
						else
						{
							btn22.setText(" ");
							d9++;
						}
						if(filled2||filled3||filled4||filled5||filled6||filled7||filled8||filled1)
						{
							System.out.println("fille decrement line 3071"); 
						  liveb--;
						  lblliveb.setText("X "+liveb);
						  if(filled2)
						  {
							  btn01.setText(" ");
							  filled2=false;
						  }	  
						  else if(filled3)
						  {
							  btn02.setText(" ");
							  filled3=false;
						  }	  
						  else if(filled4)
						  {
							  btn10.setText(" ");
							  filled4=false;
						  }
						  else if(filled5)
						  {
							  btn11.setText(" ");
							  filled5=false;
						  }  
						  else if(filled6)
						  {
							  btn12.setText(" ");
							  filled6=false;
						  }
						  else if(filled7)
						  {
							  btn20.setText(" ");
							  filled7=false;
						  }
						  else if(filled8)
						  {
							  btn21.setText(" ");
							  filled8=false;
						  }
						  else if(filled1)
						  {
							  btn00.setText(" ");
							  filled1=false;
						  } 
						  
						}
						
						//console string
						if(liveb==1)
						{
							consolestr+="\n ** completing "+ub+"  request"
									+"\n* gearing your   request to the bot"
									+"\n* locking the "+ub+"choice  ";
						}
						else if(liveb==3)
						{
							consolestr+="\n  * "+ub+" has "+(liveb-1)+" remaining chances ";
						}
						else
						{
							consolestr+="\n  * "+ub+" has remaining chances are "+(chance-liveb);
						}
						
					    if(liveb==1)
						{
							liveb--;
							if(liveb==0)
							{
								ubendthink=System.nanoTime();
								consolestr+="\n **"+ub+"  thinking time is  "+(ubendthink-ubstartthink)+" ns"+" ******";
								livea=chance;
							     lblliveb.setText("X "+liveb);
							     lbllivea.setText("X "+livea);
							     usb=false;
							     usa=true;
							     uastartthink=System.nanoTime();
							     consolestr+="\n ******"+ua+"turns *****";
							     lblturnA.setText(ua+" turns...");
							     lblturnB.setText(" ");
								
							}
							btn22.setForeground(Color.RED);
							btn22.setText(iconb);
							new sound().chance(1);
							btn22.setEnabled(false);
							//winning checkpoint for ub22
							checkbtn22usbwin();
						}
						else if(btn22.getText()!=" "&&liveb>1)
						{
							filled9=true;
						}
					/*	else if(liveb>1 && btnb!=9)
						{
							System.out.println("conditional decrement line 3160");
							liveb--;
							lblliveb.setText("X "+liveb);
						}*/
						btnb=9;
						
						
					}
			}
				else
				{
					JOptionPane.showMessageDialog(null,"Firstly do the toss to play the game");
				}
				
			}
		});
		
		btn22.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(btn22);
		
		lblUserA = new JLabel("User A : ");
		lblUserA.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserA.setBounds(6, 39, 57, 26);
		frame.getContentPane().add(lblUserA);
		
		usera = new JTextField("usera");
		usera.setFont(new Font("Tahoma", Font.PLAIN, 12));
		usera.setBounds(64, 37, 81, 30);
		frame.getContentPane().add(usera);
		usera.setColumns(10);
		
	    lblUserB = new JLabel("User B:");
		lblUserB.setForeground(Color.BLACK);
		lblUserB.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserB.setBounds(264, 39, 58, 30);
		frame.getContentPane().add(lblUserB);
		
		userb = new JTextField("userb");
		userb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		userb.setColumns(10);
		userb.setBounds(321, 43, 86, 30);
		frame.getContentPane().add(userb);
		
		lblTimerLabel = new JLabel("00:00");
		//lblTimerLabel.setToolTipText("");
		lblTimerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimerLabel.setForeground(Color.RED);
		lblTimerLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblTimerLabel.setBounds(147, 0, 94, 28);
		frame.getContentPane().add(lblTimerLabel);
		
		lbllivea = new JLabel("X "+livea);
		lbllivea.setForeground(Color.RED);
		lbllivea.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbllivea.setBounds(10, 4, 53, 30);
		frame.getContentPane().add(lbllivea);
		
		lblliveb = new JLabel("X "+liveb);
		lblliveb.setForeground(Color.RED);
		lblliveb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblliveb.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblliveb.setBounds(325, 0, 81, 39);
		frame.getContentPane().add(lblliveb);
		
		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setText("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(112, 78, 189, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		result = new JLabel("!!!! Kattam Kuttam !!!!");
		result.setFont(new Font("Tahoma", Font.BOLD, 16));
		result.setForeground(Color.BLUE);
		result.setHorizontalAlignment(SwingConstants.CENTER);
		result.setBounds(423, 0, 224, 28);
		frame.getContentPane().add(result);
		
		lblturnA = new JLabel("");
		lblturnA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblturnA.setForeground(Color.RED);
		lblturnA.setBounds(10, 76, 114, 26);
		frame.getContentPane().add(lblturnA);
		
		lblturnB = new JLabel("");
		lblturnB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblturnB.setForeground(Color.RED);
		lblturnB.setBounds(295, 78, 120, 26);
		frame.getContentPane().add(lblturnB);
		
		JButton limitA = new JButton("<html><u>O</u>K</html>");
		limitA.setMnemonic('O');
		limitA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new sound().btnclick();
				if((btna>0)&&usa)
				{
				     switch(btna)
				     {
				    	 case 1:
				    		 btn00.setForeground(Color.BLUE);
				    		 btn00.setText(icona);
				    		 btn00.setEnabled(false);
				    		 filled1=false;
				    		/* if(btn00.getText()==icona&&btn01.getText()==icona&&btn02.getText()==icona)
								{
				    			    uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner");
									checknextvalidity();
									//System.exit(0);
								}
								else if(btn00.getText()==icona&&btn11.getText()==icona&&btn22.getText()==icona)
								{
									uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
								//	System.exit(0);
								}
								else if(btn00.getText()==icona&&btn10.getText()==icona&&btn20.getText()==icona)
								{
									uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
								//	System.exit(0);
								}*/
				    		 checkbtn00win();
				    		// if(bot)
				    			// botplay();
				    	  break;
				    	 case 2:
				    		 btn01.setForeground(Color.BLUE);
				    		 btn01.setText(icona);
				    		 btn01.setEnabled(false);
				    		 filled2=false;
				    		/* if(btn00.getText()==icona&&btn01.getText()==icona&&btn02.getText()==icona)
								{
				    			   uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
								//	System.exit(0);
								}
							 else if(btn01.getText()==icona&&btn11.getText()==icona&&btn21.getText()==icona)
								{
								 uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
								//	System.exit(0);
								}*/
				    		 checkbtn01win();
				    		// if(bot)
				    			// botplay();
				    	  break;
				    	 case 3:
				    		 btn02.setForeground(Color.BLUE);
				    		 btn02.setText(icona);
				    		 btn02.setEnabled(false);
				    		 filled3=false;
				    	/*	 if(btn00.getText()==icona&&btn01.getText()==icona&&btn02.getText()==icona)
								{
				    			 uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
								//	System.exit(0);
								}
								else if(btn20.getText()==icona&&btn11.getText()==icona&&btn02.getText()==icona)
								{
									uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
								//	System.exit(0);
								}
								else if(btn02.getText()==icona&&btn12.getText()==icona&&btn22.getText()==icona)
								{
									uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
								//	System.exit(0);
								}*/
				    		 checkbtn02win();
				    		// if(bot)
				    			// botplay();
				    	  break;
				    	 case 4:
				    		 btn10.setForeground(Color.BLUE);
				    		 btn10.setText(icona);
				    		 btn10.setEnabled(false);
				    		 filled4=false;
				    		 /*if(btn00.getText()==icona&&btn10.getText()==icona&&btn20.getText()==icona)
								{
				    			 uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
								//	System.exit(0);
								}
								else if(btn10.getText()==icona&&btn11.getText()==icona&&btn12.getText()==icona)
								{
									uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
								//	System.exit(0);
								}*/
				    		 checkbtn10win();
				    		// if(bot)
				    			// botplay();
				    	  break;
				    	 case 5:
				    		 btn11.setForeground(Color.BLUE);
				    		 btn11.setText(icona);
				    		 btn11.setEnabled(false);
				    		 filled5=false;
				    		/* if(btn01.getText()==icona&&btn11.getText()==icona&&btn21.getText()==icona)
								{
				    			 uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
								//	System.exit(0);
								}
								else if(btn10.getText()==icona&&btn11.getText()==icona&&btn12.getText()==icona)
								{
									uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
									//System.exit(0);
								}
								else if(btn00.getText()==icona&&btn11.getText()==icona&&btn22.getText()==icona)
								{
									uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
									//System.exit(0);
								}
								else if(btn20.getText()==icona&&btn11.getText()==icona&&btn02.getText()==icona)
								{
									uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
									//System.exit(0);
								}*/
				    		 checkbtn11win();
				    	//	 if(bot)
				    		//	 botplay();
				    	  break;
				    	 case 6:
				    		 btn12.setForeground(Color.BLUE);
				    		 btn12.setText(icona);
				    		 btn12.setEnabled(false);
				    		 filled6=false;
				    		/* if(btn10.getText()==icona&&btn11.getText()==icona&&btn12.getText()==icona)
								{
				    			 uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
								//	System.exit(0);
								}
								else if(btn02.getText()==icona&&btn12.getText()==icona&&btn22.getText()==icona)
								{
									uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
								//	System.exit(0);
								}*/
				    		 checkbtn12win();
				    		// if(bot)
				    			// botplay();
				    	  break;
				    	 case 7:
				    		 btn20.setForeground(Color.BLUE);
				    		 btn20.setText(icona);
				    		 btn20.setEnabled(false);
				    		 filled7=false;
				    	/*	 if(btn00.getText()==icona&&btn10.getText()==icona&&btn20.getText()==icona)
								{
				    			 uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
								//	System.exit(0);
								}
								else if(btn20.getText()==icona&&btn11.getText()==icona&&btn02.getText()==icona)
								{
									uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
								//	System.exit(0);
								}
								else if(btn20.getText()==icona&&btn21.getText()==icona&&btn22.getText()==icona)
								{
									uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
								//	System.exit(0);
								}*/
				    		 checkbtn20win();
				    	//	 if(bot)
				    		//	 botplay();
				    	  break;
				    	 case 8:
				    		 btn21.setForeground(Color.BLUE);
				    		 btn21.setText(icona);
				    		 btn21.setEnabled(false);
				    		 filled8=false;
				    		/* if(btn20.getText()==icona&&btn21.getText()==icona&&btn22.getText()==icona)
								{
				    			 uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
								//	System.exit(0);
								}
								else if(btn01.getText()==icona&&btn11.getText()==icona&&btn21.getText()==icona)
								{
									uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
								//	System.exit(0);
								}*/
				    		 checkbtn21win();
				    	//	 if(bot)
				    		//	 botplay();
				    	  break;
				    	 case 9:
				    		 btn22.setForeground(Color.BLUE);
				    		 btn22.setText(icona);
				    		 btn22.setEnabled(false);
				    		 filled9=false;
				    		/* if(btn00.getText()==icona&&btn11.getText()==icona&&btn22.getText()==icona)
								{
				    			 uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
									//System.exit(0);
								}
								else if(btn20.getText()==icona&&btn21.getText()==icona&&btn22.getText()==icona)
								{
									uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
									//System.exit(0);
								}
								else if(btn02.getText()==icona&&btn12.getText()==icona&&btn22.getText()==icona)
								{
									uawin++; lblwinusa.setText(uawin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); checknextvalidity();
								//	System.exit(0);
								}*/
				    		 checkbtn22win();
				    	//	 if(bot)
				    		//	 botplay();
				    	  break;
				    	default:
				    		JOptionPane.showMessageDialog(null,"something is wrong in switch statement");
				    		
				    		 
				     }
				    if(!visited)
				    {
				     if(bot)
				     {
				    	 botturn=true;
				    	 botplay();
				    	 
				     }
				     else
				     {
				     liveb=chance;
			    		livea=0;
					     lblliveb.setText("X "+liveb);
					     lbllivea.setText("X "+livea);
					     usa=false;
					     usb=true;
					     lblturnA.setText(" ");
					     lblturnB.setText(ub+" turns...");
				     }
				     visited=false;
				    }
				     
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"You are allowed to use right OK button");
				}
				
			}
		});
		limitA.setHorizontalAlignment(SwingConstants.LEFT);
		limitA.setBounds(1, 236, 53, 149);
		frame.getContentPane().add(limitA);
		
		JButton limitB = new JButton("<html>O<u>K</u></html>");
		limitB.setMnemonic('K');
		limitB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new sound().btnclick();
				if((btnb>0)&&usb)
				{
				     switch(btnb)
				     {
				    	 case 1:
				    		 btn00.setForeground(Color.RED);
				    		 btn00.setText(iconb);
				    		 btn00.setEnabled(false);
				    		 filled1=false;
				    	/*	 if(btn00.getText()==iconb&&btn01.getText()==iconb&&btn02.getText()==iconb)
								{
				    			   ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
									//System.exit(0);
								}
								else if(btn00.getText()==iconb&&btn01.getText()==iconb&&btn02.getText()==iconb)
								{
									ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
								//	System.exit(0);
								}
								else if(btn00.getText()==iconb&&btn01.getText()==iconb&&btn02.getText()==iconb)
								{
								   ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
								//	System.exit(0);
								}*/
				    		 checkbtn00usbwin();
				    	  break;
				    	 case 2:
				    		 btn01.setForeground(Color.RED);
				    		 btn01.setText(iconb);
				    		 btn01.setEnabled(false);
				    		 filled2=false;
				    	/*	 if(btn00.getText()==iconb&&btn01.getText()==iconb&&btn02.getText()==iconb)
								{
				    			 ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
									//System.exit(0);
								}
								else if(btn01.getText()==iconb&&btn11.getText()==iconb&&btn21.getText()==iconb)
								{
									ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
									//System.exit(0);
								}*/
				    		 checkbtn01usbwin();
				    	  break;
				    	 case 3:
				    		 btn02.setForeground(Color.RED);
				    		 btn02.setText(iconb);
				    		 btn02.setEnabled(false);
				    		 filled3=false;
				    		/* if(btn00.getText()==iconb&&btn01.getText()==iconb&&btn02.getText()==iconb)
								{
				    			 ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
								//	System.exit(0);
								}
								else if(btn00.getText()==iconb&&btn11.getText()==iconb&&btn22.getText()==iconb)
								{
									ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
								//	System.exit(0);
								}
								else if(btn00.getText()==iconb&&btn10.getText()==iconb&&btn20.getText()==iconb)
								{
									ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
								//	System.exit(0);
								}*/
				    		 checkbtn02usbwin();
				    	  break;
				    	 case 4:
				    		 btn10.setForeground(Color.RED);
				    		 btn10.setText(iconb);
				    		 btn10.setEnabled(false);
				    		 filled4=false;
				    		
				    		/* if(btn00.getText()==iconb&&btn10.getText()==iconb&&btn20.getText()==iconb)
								{
				    			 ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
									//System.exit(0);
								}
								else if(btn10.getText()==iconb&&btn11.getText()==iconb&&btn12.getText()==iconb)
								{
									ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
								//	System.exit(0);
								}*/
				    		 checkbtn10usbwin();
				    	  break;
				    	 case 5:
				    		 btn11.setForeground(Color.RED);
				    		 btn11.setText(iconb);
				    		 btn11.setEnabled(false);
				    		 filled5=false;
				    		/* if(btn01.getText()==iconb&&btn11.getText()==iconb&&btn21.getText()==iconb)
								{
				    			 ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
								//	System.exit(0);
								}
								else if(btn10.getText()==iconb&&btn11.getText()==iconb&&btn12.getText()==iconb)
								{
									ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
								//	System.exit(0);
								}
								else if(btn00.getText()==iconb&&btn11.getText()==iconb&&btn22.getText()==iconb)
								{
									ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
									//System.exit(0);
								}
								else if(btn20.getText()==iconb&&btn11.getText()==iconb&&btn02.getText()==iconb)
								{
									ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
									//System.exit(0);
								}*/
				    		 checkbtn11usbwin();
				    	  break;
				    	 case 6:
				    		 btn12.setForeground(Color.RED);
				    		 btn12.setText(iconb);
				    		 btn12.setEnabled(false);
				    		 filled6=false;
				    	/*	 if(btn10.getText()==iconb&&btn11.getText()==iconb&&btn12.getText()==iconb)
								{
				    			 ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
								//	System.exit(0);
								}
								else if(btn02.getText()==iconb&&btn12.getText()==iconb&&btn22.getText()==iconb)
								{
									ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
								//	System.exit(0);
								}*/
				    		 checkbtn12usbwin();
				    	  break;
				    	 case 7:
				    		 btn20.setForeground(Color.RED);
				    		 btn20.setText(iconb);
				    		 btn20.setEnabled(false);
				    		 filled7=false;
				    		/* if(btn00.getText()==iconb&&btn10.getText()==iconb&&btn20.getText()==iconb)
								{
				    			 ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
								//	System.exit(0);
								}
								else if(btn20.getText()==iconb&&btn11.getText()==iconb&&btn02.getText()==iconb)
								{
									ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
								//	System.exit(0);
								}
								else if(btn20.getText()==iconb&&btn21.getText()==iconb&&btn22.getText()==iconb)
								{
									ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
								//	System.exit(0);
								}*/
				    		 checkbtn20usbwin();
				    	  break;
				    	 case 8:
				    		 btn21.setForeground(Color.RED);
				    		 btn21.setText(iconb);
				    		 btn21.setEnabled(false);
				    		 filled8=false;
				    		/* if(btn20.getText()==iconb&&btn21.getText()==iconb&&btn22.getText()==iconb)
								{
				    			 ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
								//	System.exit(0);
								}
								else if(btn01.getText()==iconb&&btn11.getText()==iconb&&btn21.getText()==iconb)
								{
									ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
								//	System.exit(0);
								}*/
				    		 checkbtn21usbwin();
				    	  break;
				    	 case 9:
				    		 btn22.setForeground(Color.RED);
				    		 btn22.setText(iconb);
				    		 btn22.setEnabled(false);
				    		 filled9=false;
				    		/* if(btn00.getText()==iconb&&btn11.getText()==iconb&&btn22.getText()==iconb)
								{
				    			 ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
								//	System.exit(0);
								}
								else if(btn20.getText()==iconb&&btn21.getText()==iconb&&btn22.getText()==iconb)
								{
									ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
								//	System.exit(0);
								}
								else if(btn02.getText()==iconb&&btn12.getText()==iconb&&btn22.getText()==iconb)
								{
									ubwin++; lblwinusb.setText(ubwin+"/"+total);
									JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
								//	System.exit(0);
								}*/
				    		 checkbtn22usbwin();
				    	  break;
				    	default:
				    		JOptionPane.showMessageDialog(null,"You are allowed to use left OK button");
				    		
				    		 
				     }
				     if(!visited)
					    {
					     if(bot)
					     {
					    	 botturn=true;
					    	 botplay();
					    	 
					     }
					     else
					     {
				     livea=chance;
			    		liveb=0;
					     lblliveb.setText("X "+liveb);
					     lbllivea.setText("X "+livea);
					     usb=false;
					     usa=true;
					     lblturnB.setText(" ");
					     lblturnA.setText(ua+" turns...");
					     }
					     visited=false;
					   }  
				     
				}
				else
				{
					JOptionPane.showMessageDialog(null,"There is fault in A's OK button");
				}
			}
		});
		limitB.setHorizontalAlignment(SwingConstants.RIGHT);
		limitB.setBounds(358, 236, 52, 149);
		frame.getContentPane().add(limitB);
		
		 limitA.setVisible(false);
		 limitB.setVisible(false);
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(194, 26, 2, 57);
		frame.getContentPane().add(separator);
		bga=new ButtonGroup();
		bgb=new ButtonGroup();
		
		 rbabtnX = new JRadioButton("X",true);
		 rbabtnX.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		rbabtnX.setBounds(146, 39, 35, 17);
		frame.getContentPane().add(rbabtnX);
		
		 rbabtnO = new JRadioButton("O");
		 rbabtnO.setFont(new Font("Tahoma", Font.BOLD, 15));
		rbabtnO.setBounds(146, 62, 42, 17);
		frame.getContentPane().add(rbabtnO);
		ActionListener sliceActionListener = new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		AbstractButton aButton = (AbstractButton) arg0.getSource();
		 		if(rbabtnX.isSelected())
		 		{
		 			rbbbtnO.setSelected(true);
		 			icona=aButton.getText();
		 			iconb="O";
		 			
		 		}
		 		else 
		 		{
		 			rbbbtnX.setSelected(true);
		 			icona=aButton.getText();
		 			iconb="X";
		 		}
		 		//JOptionPane.showMessageDialog(null,icona);
		 		
		 	}
		 };
		bga.add(rbabtnX);
		bga.add(rbabtnO);
		 rbabtnX.addActionListener(sliceActionListener);
		 rbabtnO.addActionListener(sliceActionListener);
		 
		
		 rbbbtnX = new JRadioButton("X");
		 rbbbtnX.setFont(new Font("Tahoma", Font.BOLD, 15));
		rbbbtnX.setBounds(218, 39, 35, 17);
		frame.getContentPane().add(rbbbtnX);
		
		 rbbbtnO = new JRadioButton("O",true);
		 rbbbtnO.setFont(new Font("Tahoma", Font.BOLD, 15));
		rbbbtnO.setBounds(218, 62, 40, 17);
		frame.getContentPane().add(rbbbtnO);
		ActionListener sliceActionListener1 = new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		AbstractButton abb=(AbstractButton) arg0.getSource();
		 		if(rbbbtnX.isSelected())
		 		{
		 			rbabtnO.setSelected(true);
		 			icona="O";
		 			iconb="X";
		 		}
		 		else
		 		{
		 			rbabtnX.setSelected(true);
		 			icona="X";
		 			iconb="O";
		 		}
		 		
		 		//JOptionPane.showMessageDialog(null,"the selected item is "+iconb);
		 	}
		 };
		bgb.add(rbbbtnX);
		bgb.add(rbbbtnO);
		 rbbbtnX.addActionListener(sliceActionListener1);
		 rbbbtnO.addActionListener(sliceActionListener1);
		 
		
		btntoss = new JButton("<html><u>T</u>oss</html>");
		btntoss.setFont(new Font("Tahoma", Font.BOLD, 12));
		btntoss.setEnabled(false);
		btntoss.setMnemonic('T');
		btntoss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean tosswinua=false;
				
				if(singleusebtn)
				{
				beginningtossthread.tossthread.stop();
				//object.tossblinkthread.stop();
				resetblinkcolor();
				visited=false;
				botvisited=false;
					nooftosses++;
					
				long startTime=0;
				long endtime=0;
				boolean randombotplay=false;
				new sound().btnclick();
				Random rand=new Random();
			//	 new messagebox("Game no : "+gameno,"commencing").setVisible(true);
					if(nooftosses==1)
					startprogressbar();
					else
					startprogressbar1();
				 if(radioButton.isSelected())
				 {
					 limitA.setVisible(false);
					 limitB.setVisible(false);
			 			chance=Integer.parseInt(radioButton.getText());	 
				 }
			 		else if(radioButton_1.isSelected())
			 		{
			 			 limitA.setVisible(true);
						 limitB.setVisible(true);
			 			chance=Integer.parseInt(radioButton_1.getText());
			 		}
			 		else if(radioButton_2.isSelected())
			 		{
			 			 limitA.setVisible(true);
						 limitB.setVisible(true);
			 			chance=Integer.parseInt(radioButton_2.getText());
			 		}
				 livea=chance;
				 if(!bot)
				 liveb=chance;
				 else 
					 liveb=1;
			
					
				int random=(int )(10*Math.random());
				ua=usera.getText();
				ub=userb.getText();
				if(random<5)
				{				
					//JCheckBox chckbxEnableBot
					tosswinua=true;
					usa=true;
					usb=false;
					 lbllivea.setText("X "+livea);
					  lblliveb.setText("X "+liveb);
					  uastartthink=System.nanoTime();
					lblturnA.setText(ua+" turn...");
					lblturnB.setText(" ");
					rbabtnX.setEnabled(false);
					rbabtnO.setEnabled(false);
					rbbbtnX.setEnabled(false);
					rbbbtnO.setEnabled(false);
					
					
					
				}
				else 
				{
					
					usa=false;
					usb=true;
					if(!bot)
					{
						ubstartthink=System.nanoTime();
						consolestr+="\n *****"+ub+" turns *****";
					lblturnB.setText(ub+" turn ...");
					lblturnA.setText(" ");
					}
					
					//liveb=1;
					if(chckbxEnableBot.isSelected())
					{
					startTime = System.nanoTime();
						randombotplay=true;
						liveb--;
						
						bot=true;
						usb=false;
						//first chance play random value
						   //for bot
						 int a=rand.nextInt(3);
						 int b=rand.nextInt(3);
						 if(a==0&&b==0)
		                  {
							 btn00.setForeground(Color.RED);
		                	  btn00.setText(iconb);
		                	  btn00.setEnabled(false);
		                  }
		                  else if(a==0&&b==1)
		                  {
		                	  btn01.setForeground(Color.RED);
		                	  btn01.setText(iconb);
		                	  btn01.setEnabled(false);
		                  }
		                  else if(a==0&&b==2)
		                  {
		                	  btn02.setForeground(Color.RED);
		                	  btn02.setText(iconb);
		                	 btn02.setEnabled(false);
		                  }
		                  else if(a==1&&b==0)
		                  {
		                	  btn10.setForeground(Color.RED);
		                	  btn10.setText(iconb);
		                	  btn10.setEnabled(false);
		                  }
		                  else if(a==1&&b==1)
		                  {
		                	  btn11.setForeground(Color.RED);
		                	  btn11.setText(iconb);
		                	 btn11.setEnabled(false);
		                  }
		                  else if(a==1&&b==2)
		                  {
		                	  btn12.setForeground(Color.RED);
		                	  btn12.setText(iconb);
		                	  btn12.setEnabled(false);
		                  }
		                  else if(a==2&&b==0)
		                  {
		                	  btn20.setForeground(Color.RED);
		                	  btn20.setText(iconb);
		                	 btn20.setEnabled(false);
		                  }
		                  else if(a==2&&b==1)
		                  {
		                	  btn21.setForeground(Color.RED);
		                	  btn21.setText(iconb);
		                	 btn21.setEnabled(false);
		                  }
		                  else
		                  {
		                	  btn22.setForeground(Color.RED);
		                	  btn22.setText(iconb);
		                	  btn22.setEnabled(false);
		                  }
						 livea=chance;
				    		liveb=0;
						     lblliveb.setText("X "+liveb);
						     lbllivea.setText("X "+livea);
						     usb=false;
						     usa=true;
						     lblturnB.setText(" ");
						     lblturnA.setText(ua+" turns...");
						     endtime=System.nanoTime();
					}		
					
					rbabtnX.setEnabled(false);
					rbabtnO.setEnabled(false);
					rbbbtnX.setEnabled(false);
					rbbbtnO.setEnabled(false);
					
					
				}
				//shifting radiobutton
				if(rbabtnX.isSelected())
				{
					rbabtnX.setBounds(146, 44, 35, 17);
					rbabtnO.setVisible(false);
				}
				else
				{
					rbabtnO.setBounds(146, 44, 35, 17);
					rbabtnX.setVisible(false);
				}
				//shifting radiobutton
				if(rbbbtnX.isSelected())
				{
					rbbbtnX.setBounds(218, 44, 35, 17);
					rbbbtnO.setVisible(false);
				}
				else
				{
					rbbbtnO.setBounds(218, 44, 35, 17);
					rbbbtnX.setVisible(false);
				}
				singleusebtn=false;
				toss=true;
				chckbxEnableBot.setEnabled(false);
				t.start();
				String s1=comboBox.getSelectedItem().toString();
				if(s1.equals("Very_Easy"))
				{
					gear=10;//ran
				}
				else if(s1.equals("Easy"))
				{
				   gear=11;//heus
				}
				else if(s1.equals("Comfort"))
				{
					gear=7;//m+r
				}
				else if(s1.equals("Medium"))
				{
					gear=2;//m2
				}
				else if(s1.equals("Hard"))
				{
					gear=4;//m4
				}
				else if(s1.equals("Impossible"))
				{
					gear=15;//mall
				}
				
				  
				 
				  radioButton.setEnabled(false);
				  radioButton_1.setEnabled(false);
				  radioButton_2.setEnabled(false);
				  usera.setEditable(false);
				  userb.setEditable(false);
				  lblNewLabel_2.setText(ua+" v/s "+ub);
				  lblUseraWins.setText(ua+" wins:");
				  lblUserbWins.setText(ub+" wins:");
				 endgame=false;
			//	  callwinblink();
				comboBox.setEnabled(false);
				  
				  //console writing
				  consolestr+="\n * selecting ur desired icon "
						  +"\n * Chances are geared to  "+chance
						  +"\n Have Patience!!! Bot is initialising the game conditions"
						  +"\n \t * Tuning graphics according to the game"
						  +"\n \t * adjusting music level "
						  +"\n \t * reinitialising @#boot32 thread "
						  +"\n\n *****Tossing is done between "+ua+" & "+ub+"******";
				  if(tosswinua)
				  consolestr+="\n Tossing is won by"+ua+"\n"+ua+" elected to play as first chance";
				  else
				  consolestr+="\n Tossing is won by"+ub+"\n"+ub+" elected to play as first chance";  
				  
				  consolestr+="\nWelcome "+ua+" and "+ub+" to the game!!!";
				  consolestr+="\n ********"+ua+" v/s "+ub+"********";
				  if(randombotplay)
				  {
					  long temptime;
					  temptime=startTime-endtime;
					  consolestr+="\nBot is playing its chance";
					  consolestr+="\nBot thinking time"+temptime;
					  
					  randombotplay=false;
				  }
				  themecontro.randomiseimg();
					themecontro.randomisemusic();
					
					if(tosswinua)
					 new messagebox("Game no : "+gameno,"commencing","!!! "+ua+" won the toss !!!").setVisible(true);
					else
						 new messagebox("Game no : "+gameno,"commencing","!!! "+ub+" won the toss !!!").setVisible(true);
					//createblinkthread();
					 if(bot)
			 				limitB.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Toss button can be used once during game starting !!!!!");
				}
				//btnNewButton_8.setDisable;
				
			}
		});
		btntoss.setHorizontalAlignment(SwingConstants.LEFT);
		btntoss.setBounds(531, 28, 65, 39);
		frame.getContentPane().add(btntoss);
		
		lblNewLabel = new JLabel("A:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 190, 24, 26);
		frame.getContentPane().add(lblNewLabel);
		
		lblB = new JLabel("B:");
		
		//SwingUtilities.
		//lblB.setBackground(new Color(240, 240, 240,9));
		lblB.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblB.setBounds(363, 190, 24, 26);
		lblB.setOpaque(false);
		frame.getContentPane().add(lblB);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(467, 187, 2, -153);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.GRAY);
		separator_2.setBounds(413, 0, 16, 655);
		frame.getContentPane().add(separator_2);
		choice=new ButtonGroup();
		
		radioButton = new JRadioButton("1",true);
		radioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		//radioButton.setToolTipText("");
		radioButton.setBounds(478, 370, 42, 17);
		frame.getContentPane().add(radioButton);
		
		radioButton_1 = new JRadioButton("2");
		radioButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		//radioButton_1.setToolTipText("");
		radioButton_1.setBounds(519, 370, 42, 17);
		frame.getContentPane().add(radioButton_1);
		
		radioButton_2 = new JRadioButton("3");
		radioButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
	//	radioButton_2.setToolTipText("");
		radioButton_2.setBounds(563, 370, 42, 17);
		frame.getContentPane().add(radioButton_2);
		ActionListener sliceActionListener12 = new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		AbstractButton aButton = (AbstractButton) arg0.getSource();
		 		if(radioButton.isSelected())
		 		{
		 			limitA.setVisible(false);
		 			limitB.setVisible(false);
		 			chance=Integer.parseInt(radioButton.getText());	 			
		 		}
		 		else if(radioButton_1.isSelected())
		 		{
		 			 limitA.setVisible(true);
		 			 if(bot)
		 			 limitB.setVisible(false);
		 			 else
					 limitB.setVisible(true);
		 			chance=Integer.parseInt(radioButton_1.getText());
		 		}
		 		else if(radioButton_2.isSelected())
		 		{
		 			 limitA.setVisible(true);
		 			 if(bot)
		 				limitB.setVisible(false);
		 			 else
					    limitB.setVisible(true);
		 			chance=Integer.parseInt(radioButton_2.getText());
		 		}
		 	}
		 };
		choice.add(radioButton);
		choice.add(radioButton_1);
		choice.add(radioButton_2);
		radioButton.addActionListener(sliceActionListener12);
		radioButton_1.addActionListener(sliceActionListener12);
		radioButton_2.addActionListener(sliceActionListener12);
		
		
		lblChan = new JLabel("Set Chance/s  ::");
		lblChan.setFont(new Font("Tekton Pro", Font.BOLD, 17));
		lblChan.setBounds(464, 339, 130, 26);
		frame.getContentPane().add(lblChan);
		
		btnNewGame = new JButton("<html><u>N</u>ew Game</html>");
		btnNewGame.setToolTipText("play new game!!");
		btnNewGame.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewGame.setMnemonic('N');
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consolestr+="\n*****************************************\n";
				consolestr+="\n select the single or double user u wanna!! play";
				new sound().btnclick();
				newgamecall();
				new sound().btnclick();
				
				
			}
		});
		btnNewGame.setBounds(426, 28, 95, 39);
		frame.getContentPane().add(btnNewGame);
		
		JButton btnExit = new JButton("<html><u>E</u>xit</html>");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExit.setMnemonic(KeyEvent.VK_ENTER);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new feedback().setVisible(true);
				frame.setVisible(false);
				mail.attachsendMail("end game mail","log.txt");
				System.exit(1);
			}
		});
		btnExit.setBounds(531, 78, 65, 39);
		frame.getContentPane().add(btnExit);
		
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(608, 214, 1, 2);
		frame.getContentPane().add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(Color.DARK_GRAY);
		separator_4.setBounds(627, 246, 2, -43);
		frame.getContentPane().add(separator_4);
		
		separator_5 = new JSeparator();
		separator_5.setForeground(Color.DARK_GRAY);
		separator_5.setBounds(580, 356, 53, 9);
		frame.getContentPane().add(separator_5);
		
		separator_6 = new JSeparator();
		separator_6.setForeground(Color.GRAY);
		separator_6.setBounds(453, 391, 181, 9);
		frame.getContentPane().add(separator_6);
		
		separator_7 = new JSeparator();
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(633, 356, 16, 35);
		frame.getContentPane().add(separator_7);
		
		separator_8 = new JSeparator();
		separator_8.setOrientation(SwingConstants.VERTICAL);
		separator_8.setBounds(453, 350, 16, 42);
		frame.getContentPane().add(separator_8);
		
		chckbxEnableBot = new JCheckBox("Enable Bot");
	//	chckbxEnableBot.setToolTipText("");
		chckbxEnableBot.setEnabled(false);
		chckbxEnableBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxEnableBot.isSelected())
				{
					
				userb.setText("Bot");
				bot=true;
				usb=false;
				}
				else
				{
			    userb.setText("userb");
				}
				
				
			}
		});
		chckbxEnableBot.setFont(new Font("Nyala", Font.BOLD, 20));
		chckbxEnableBot.setForeground(Color.RED);
		chckbxEnableBot.setBounds(456, 284, 130, 23);
		frame.getContentPane().add(chckbxEnableBot);
		
		lblPlayVsComputer = new JLabel("Play v/s Computer");
		lblPlayVsComputer.setForeground(Color.BLACK);
		lblPlayVsComputer.setFont(new Font("MV Boli", Font.BOLD, 16));
		lblPlayVsComputer.setBounds(429, 260, 180, 26);
		frame.getContentPane().add(lblPlayVsComputer);
		
		JButton btnNetwork = new JButton("<html><u>H</u>igh Score</html>");
		btnNetwork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new highscore().setVisible(true);
				new sound().btnclick();
				
			}
		});
		btnNetwork.setMnemonic('H');
		btnNetwork.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNetwork.setForeground(Color.BLACK);
		btnNetwork.setBounds(428, 78, 94, 39);
		frame.getContentPane().add(btnNetwork);
		
		progressBar = new JProgressBar();
		progressBar.setValue(23);
		progressBar.setMaximum(120);
		progressBar.setStringPainted(true);
		progressBar.setBounds(116, 431, 206, 14);
		progressBar.setVisible(false);
		frame.getContentPane().add(progressBar);
		
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(441, 130, 193, 9);
		frame.getContentPane().add(separator_9);
		
		separator_10 = new JSeparator();
		separator_10.setBounds(441, 405, 193, 9);
		frame.getContentPane().add(separator_10);
		
		JButton btnNewButton = new JButton("<html><u>C</u></html>");
		btnNewButton.setToolTipText("Clear");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setMnemonic('C');
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new sound().btnclick();
				btn00.setEnabled(true);
				btn00.setText(" ");
				
				btn01.setEnabled(true);
				btn01.setText(" ");
				
				btn02.setEnabled(true);
				btn02.setText(" ");
				
				btn10.setEnabled(true);
				btn10.setText(" ");
				
				btn11.setEnabled(true);
				btn11.setText(" ");
				
				btn12.setEnabled(true);
				btn12.setText(" ");
				
				btn20.setEnabled(true);
				btn20.setText(" ");
				
				btn21.setEnabled(true);
				btn21.setText(" ");
				
				btn22.setEnabled(true);
				btn22.setText(" ");
				
			}
		});
		btnNewButton.setBounds(601, 28, 42, 89);
		frame.getContentPane().add(btnNewButton);
		
	 lblLevel = new JLabel("Level :");
		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLevel.setForeground(Color.BLACK);
		lblLevel.setBounds(441, 308, 65, 26);
		frame.getContentPane().add(lblLevel);
		
		comboBox = new JComboBox();
		//comboBox.setToolTipText("");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=comboBox.getSelectedItem().toString();
				if(s.equals("Very_Easy"))
				{
					gear=10;//ran
				}
				else if(s.equals("Easy"))
				{
				   gear=11;//heus
				}
				else if(s.equals("Comfort"))
				{
					gear=7;//m+r
				}
				else if(s.equals("Medium"))
				{
					gear=2;//m2
				}
				else if(s.equals("Hard"))
				{
					gear=4;//m4
				}
				else if(s.equals("Impossible"))
				{
					gear=15;//mall
				}
			
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setForeground(Color.RED);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Very_Easy", "Easy", "Comfort", "Medium", "Hard", "Impossible"}));
		comboBox.setBounds(503, 310, 161, 26);
		frame.getContentPane().add(comboBox);
		
		progressBar_1 = new JProgressBar();
		progressBar_1.setMaximum(360);
		progressBar_1.setValue(34);
		progressBar_1.setBounds(116, 459, 206, 14);
		progressBar_1.setVisible(false);
		frame.getContentPane().add(progressBar_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(3, 488, 409, 165);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtrThinkingSkill = new JTextArea(5,40);
		//txtrThinkingSkill.setFont(new Font("Tahoma",Font.PLAIN,12));
		txtrThinkingSkill.setBackground(Color.BLACK);
		txtrThinkingSkill.setForeground(Color.GREEN);
		txtrThinkingSkill.setEditable(false);
		txtrThinkingSkill.setLineWrap(true);
		txtrThinkingSkill.setWrapStyleWord(true);
		txtrThinkingSkill.setVisible(true);
		scrollBar = new JScrollPane(txtrThinkingSkill);
		scrollBar = new JScrollPane(txtrThinkingSkill);
		scrollBar.setBounds(10, 10, 389, 145);
	     panel_1.add(scrollBar);
		
		lblNewLabel_1 = new JLabel("0/0");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(325, 425, 92, 26);
		lblNewLabel_1.setVisible(false);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblt_3 = new JLabel("0/0");
		lblt_3.setForeground(Color.RED);
		lblt_3.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblt_3.setBounds(325, 452, 92, 26);
		lblt_3.setVisible(false);
		frame.getContentPane().add(lblt_3);
		
		theme = new JLabel("");
		theme.setIcon(new ImageIcon("space.GIF"));
		theme.setBounds(0, -66, 414, 707);
		
		//panel_4.add(theme);
		
		frame.getContentPane().add(theme);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(0,0,0,25));
		panel_4.setBounds(419, 131, 275, 125);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		 panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 0, 0, 25));
		panel_5.setBounds(419, 264, 275, 78);
		frame.getContentPane().add(panel_5);
		
		
		
		JLabel lblHowToPlay = new JLabel("<html><u>How to play </u> ??<html>");
		lblHowToPlay.setForeground(Color.YELLOW);
		lblHowToPlay.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblHowToPlay.setText("How to play ??");
				lblHowToPlay.setForeground(Color.white);
				//callhowtouse();
				//ht.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblHowToPlay.setText("<html><u>How to play </u> ??<html>");
				lblHowToPlay.setForeground(Color.yellow);
				/*if(!clicked)
				{
				ht.t.stop();
				ht.dispose();
				}*/
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				new howtouse().setVisible(true);
			}
		});
			
		 
		lblHowToPlay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHowToPlay.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHowToPlay.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowToPlay.setBounds(546, 642, 135, 19);
		frame.getContentPane().add(lblHowToPlay);
		
		label_1 = new JLabel("");
		//label_1.setIcon(new ImageIcon(tictacto.class.getResource("/ttt/Backdrop2.jpg")));
		//label_1.setIcon(new ImageIcon(("invbluecurtain.jpg")));
		label_1.setIcon(new ImageIcon(("invreddishcurtain.jpg")));
		label_1.setBounds(415, 120, 283, 574);
		frame.getContentPane().add(label_1);
		
		/*JPopupMenu popupMenu_1 = new JPopupMenu();
		popupMenu_1.setBounds(549, -11, 200, 50);
		frame.getContentPane().add(popupMenu_1);
		*/
		JButton button_1 = createDropDownButton();
		
		button_1.setBounds(649, 2, 39, 23);
		frame.getContentPane().add(button_1);
		
		
			new chancethread(this);
			new drawthread(this);
		  sbt=new statsborderthread(this);	
		 settingpan=new settingpanel(this);
		themecontro.maintheme();
		new newgamebtnthread(this);
		object=new tossblink(this);
		callwinblink();
		checkopeningno();
	//	new botfocusthread(this);
		try
		{
			FileInputStream finker=new FileInputStream("log.txt");
			String z=" ";
			if(finker.available()>4000)
			{
				FileOutputStream fout=new FileOutputStream("log.txt");
				byte b[]=z.getBytes();
				fout.write(b);
				fout.close();
				
				new logpart().logip();
			}
		}
		catch(Exception e)
		{
			
		}
	}
	void checkopeningno()
	{
		try
		{
			FileInputStream fin=new FileInputStream("openingno.txt");
			int content;
			String bool="";
			int val;
			while((content=fin.read())!=-1)
			{
				bool+=(char)content;
			}
			bool=bool.trim();
			val=Integer.parseInt(bool);
			if(val<5)
				new howtouse().setVisible(true);
			val++;
			String temp=val+"";
			FileOutputStream fout=new FileOutputStream("openingno.txt");
			byte b[]=temp.getBytes();
			fout.write(b);
			fout.close();
		}
		catch(Exception e)
		{
			
		}
	}
	void callwannaclose()
	{
		new wannaclose(this).setVisible(true);
	}
	void clickexecute()
	{
		clicked=true;
	}
	 void callhowtouse()
	  {
		 ht=new howtouse();
	  }
	void callwannaplay()
	{
		new wannaplay(this).setVisible(true);
	}
	 void botplay()
	{
		 consolestr+="\n ****** Bot turns *****"
				 +"\n please wait Bot Thinking....";
		 String tempthink=botthinkstring();
		 bootflag=true;
		 consolestr+="\n"+tempthink;
		
		botchance btchan=new botchance();
		
		new sound().chance(2);
		ubstartthink=System.nanoTime();
		btchan.play(this);
		ubendthink=System.nanoTime();
		this.checkbotwin();
		
		consolestr+="\n\n ***** Bot Thinking Time :"+(ubendthink-ubstartthink)+" ns"+" ******";
		if(!botvisited)
		{
		liveb=0;
		livea=chance;
	     lblliveb.setText("X "+liveb);
	     lbllivea.setText("X "+livea);
	     usb=false;
	     usa=true;
	     botturn=false;
	     uastartthink=System.nanoTime();
	     consolestr+="\n *****"+ua+" turns *****";
	     lblturnA.setText(ua+" turns...");
	     lblturnB.setText(" ");
		}
	}
	String botthinkstring()
	{
		String temp="";
		Random rand5=new Random();
		for(int i=1;i<=500;i++)
		{
			int k=rand5.nextInt(2);
			temp+=""+k;
			if(i%50==0)
				temp+="\n";
		}
		return temp;
	}
	 
	void checkbotwin()
	{
		//bot row winnning cases
		if(btn00.getText()==iconb&&btn01.getText()==iconb&&btn02.getText()==iconb)
		{
			botvisited=true;
			ubwin++; lblwinusb.setText(ubwin+"/"+total);
			new botwin(this).setVisible(true);
		//	JOptionPane.showMessageDialog(null,"Bot wins!!!!!!");
			t.stop();
			 
			  lblwinusb.setText(ubwin+"/"+total);
			  this.checknextvalidity();
			  
			 
			// System.out.println("******************");
			//  System.out.println("The chance played by random algorithm is"+botchance.randomchance);
			//  System.out.println("The chance played by minimax algorithm is "+botchance.minimaxchance);
		}
		else if(btn10.getText()==iconb&&btn11.getText()==iconb&&btn12.getText()==iconb)
		{
			botvisited=true;
			ubwin++; lblwinusb.setText(ubwin+"/"+total);
			new botwin(this).setVisible(true);
			//JOptionPane.showMessageDialog(null,"Bot wins!!!!!!");
			t.stop();
			 
			  lblwinusb.setText(ubwin+"/"+total);
			  this.checknextvalidity();
			 //System.out.println("******************");
			 // System.out.println("The chance played by random algorithm is"+botchance.randomchance);
			 // System.out.println("The chance played by minimax algorithm is "+botchance.minimaxchance);
		}
		else if(btn20.getText()==iconb&&btn21.getText()==iconb&&btn22.getText()==iconb)
		{
			botvisited=true;
			ubwin++; lblwinusb.setText(ubwin+"/"+total);
			new botwin(this).setVisible(true);
			//JOptionPane.showMessageDialog(null,"Bot wins!!!!!!");
			t.stop();
			 
			  lblwinusb.setText(ubwin+"/"+total);
			  this.checknextvalidity();
			// System.out.println("******************");
			 // System.out.println("The chance played by random algorithm is"+botchance.randomchance);
			 // System.out.println("The chance played by minimax algorithm is "+botchance.minimaxchance);
		}
		else if(btn00.getText()==iconb&&btn10.getText()==iconb&&btn20.getText()==iconb)
		{
			botvisited=true;
			ubwin++; lblwinusb.setText(ubwin+"/"+total);
			new botwin(this).setVisible(true);
			//JOptionPane.showMessageDialog(null,"Bot wins!!!!!!");
			t.stop();
			 
			  lblwinusb.setText(ubwin+"/"+total);
			  this.checknextvalidity();
			// System.out.println("******************");
			 // System.out.println("The chance played by random algorithm is"+botchance.randomchance);
			 // System.out.println("The chance played by minimax algorithm is "+botchance.minimaxchance);
		}
		else if(btn01.getText()==iconb&&btn11.getText()==iconb&&btn21.getText()==iconb)
		{
			botvisited=true;
			ubwin++; lblwinusb.setText(ubwin+"/"+total);
			new botwin(this).setVisible(true);
			//JOptionPane.showMessageDialog(null,"Bot wins!!!!!!");
			t.stop();
			 
			  lblwinusb.setText(ubwin+"/"+total);
			  this.checknextvalidity();
			// System.out.println("******************");
			//  System.out.println("The chance played by random algorithm is"+botchance.randomchance);
			//  System.out.println("The chance played by minimax algorithm is "+botchance.minimaxchance);
		}
		else if(btn02.getText()==iconb&&btn12.getText()==iconb&&btn22.getText()==iconb)
		{
			botvisited=true;
			ubwin++; lblwinusb.setText(ubwin+"/"+total);
			new botwin(this).setVisible(true);
			//JOptionPane.showMessageDialog(null,"Bot wins!!!!!!");
			t.stop();
			 
			  lblwinusb.setText(ubwin+"/"+total);
			  this.checknextvalidity();
			// System.out.println("******************");
			 // System.out.println("The chance played by random algorithm is"+botchance.randomchance);
			//  System.out.println("The chance played by minimax algorithm is "+botchance.minimaxchance);
		}
		else if(btn00.getText()==iconb&&btn11.getText()==iconb&&btn22.getText()==iconb)
		{
			botvisited=true;
			ubwin++; lblwinusb.setText(ubwin+"/"+total);
			
			new botwin(this).setVisible(true);
			//JOptionPane.showMessageDialog(null,"Bot wins!!!!!!");
			t.stop();
			 
			  lblwinusb.setText(ubwin+"/"+total);
			  this.checknextvalidity();
			// System.out.println("******************");
			 // System.out.println("The chance played by random algorithm is"+botchance.randomchance);
			//  System.out.println("The chance played by minimax algorithm is "+botchance.minimaxchance);
			
		}
		else if(btn02.getText()==iconb&&btn11.getText()==iconb&&btn20.getText()==iconb)
		{
			botvisited=true;
			ubwin++; lblwinusb.setText(ubwin+"/"+total);
			new botwin(this).setVisible(true);
			//JOptionPane.showMessageDialog(null,"Bot wins!!!!!!");
			t.stop();
			 
			  lblwinusb.setText(ubwin+"/"+total);
			  this.checknextvalidity();
			// System.out.println("******************");
			 // System.out.println("The chance played by random algorithm is"+botchance.randomchance);
			 // System.out.println("The chance played by minimax algorithm is "+botchance.minimaxchance);
		}
		else
		{
			this.checkempty();
		 /* if(draw==0)
		  {
			  bot=false;
			  usa=false;
			  usb=false;
			  lblturnA.setText("");
			  lblturnB.setText("");
			  livea=0;
			  liveb=0;
			  lbllivea.setText("X "+livea);
			  lblliveb.setText("X "+liveb);
			  JOptionPane.showMessageDialog(null,"Game draws!!!!!!");
		  }*/
		}
	}
	int checkempty()
	{
		int c=0;
		if(btn00.isEnabled())
		{
			c++;
		}
		if(btn01.isEnabled())
		{
			c++;
		}
		if(btn02.isEnabled())
		{
			c++;
		}
		if(btn10.isEnabled())
		{
			c++;
		}
		if(btn11.isEnabled())
		{
			c++;
		}
		if(btn12.isEnabled())
		{
			c++;
		}
		if(btn20.isEnabled())
		{
			c++;
		}
		if(btn21.isEnabled())
		{
			c++;
		}
		if(btn22.isEnabled())
		{
			c++;
		}
		
		//checking for draw case
		if(c==0&&bot&&botturn)
		{
			botvisited=true;
			  bot=false;
			  usa=false;
			  usb=false;
			  lblturnA.setText("");
			  lblturnB.setText("");
			  livea=0;
			  liveb=0;
			  lbllivea.setText("X "+livea);
			  lblliveb.setText("X "+liveb);
			  blink=true;
			  uaubdraw++;
			  new botdraw(this).setVisible(true);
			//  JOptionPane.showMessageDialog(null,"Game draws!!!!!!");
			  this.checknextvalidity();
			 // System.out.println("******************");
			 // System.out.println("The chance played by random algorithm is"+botchance.randomchance);
			 // System.out.println("The chance played by minimax algorithm is "+botchance.minimaxchance);
			  
			  
		}  
		  
		
		return c; 
	}
	void reset()
	{

		btn00.setEnabled(true);
		btn00.setText(" ");
		
		btn01.setEnabled(true);
		btn01.setText(" ");
		
		btn02.setEnabled(true);
		btn02.setText(" ");
		
		btn10.setEnabled(true);
		btn10.setText(" ");
		
		btn11.setEnabled(true);
		btn11.setText(" ");
		
		btn12.setEnabled(true);
		btn12.setText(" ");
		
		btn20.setEnabled(true);
		btn20.setText(" ");
		
		btn21.setEnabled(true);
		btn21.setText(" ");
		
		btn22.setEnabled(true);
		btn22.setText(" ");
		toss=false;
		singleusebtn=true;
		lblturnA.setText("");
		lblturnB.setText("");
		
	}
	void newgamecall()
	{
		new newgame(this).setVisible(true);
	}
	void enableframe()
	{
		frame.setEnabled(true);
	}
	/*private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}*/
	/*void createblinkthread()
	{
		new tossblink(this);
	}*/
	void callvolumedownthread()
	{
		new volumedownfader(this);
	}
	void callvolumeupthread()
	{
		new volumeupfader(this);
	}
	void resetblinkcolor()
	{
		btntoss.setForeground(Color.BLACK);
		lblLevel.setForeground(Color.BLACK);
		lblChan.setForeground(Color.BLACK);
	}
	void nextgame()
	{
		//Designed and developed by shivam ratan
		
		--remaining;
		reset();
		min=timepergame;
		sec=0;
		lblTimerLabel.setText("00:00");
		t.stop();
		blink=false;
		lblturnA.setText(" ");
		lblturnB.setText(" ");
		consolestr+="\n****JUMPING TO NEW GAME*****";
		//rebooting the bot
		bootflag=true;
		consolestr+="\n***Rebooting the bot"
				+"\n * reinitialising thread,handle"
				+"\n * recaptionising @bot32 drivers"
				+"\nRatBot:[RatBotManager ] Botbases have been reloaded"
				+"\nRatBot:reinitialising startup thread ,relating to combat setting"
				+"\nRatBot:binding all the different startup thread "
				+"\nRatBot:reordering and building Actioncache"
				+"\nRatBot:Loading  configuration..."
				+"\nRatBot:Configuration Loaded";
		consolestr+="\n****WELCOME TO NEW GAME OF THE SERIES";
		consolestr+="\n** Please again TOSS to initialise the game"
				    +"\n** or press Alt+T to TOSS";
		thread1.stop();
		
	}
	void checknextvalidity()
	{
		System.out.println("reaching to check next validity!! line 4739");
		if(!tictacto.consolestr.equals(tictacto.txtrThinkingSkill.getText()))
		{
			btndisturb=true;
		}
		
			tt1.mysuspend();
	
		if(remaining>0)
		{
			livea=0;
			liveb=0;
			lblturnA.setText("");
			lblturnB.setText("");
			blink=false;
			topgearconsole=true;
			themecontro.setintervalimg();
			gameno++;
			winblink.loopflag=false;
			  nextgame();
			  heuristic.resetheuristic();
		}
		  else
		  {
			  if(uawin>ubwin)
			  {
				  topgearconsole=true;
				  txtrThinkingSkill.setForeground(Color.RED);
				  consolestr+="CONGRATULATION !!! TO "+ua.toUpperCase()+" FOR WINNING OF SERIES"; 
				//  checkhighscoreua();
				  new finalwin(ua,this).setVisible(true);
				  
				 // new wannaplay().setVisible(true);
			  }
			  else if(uawin<ubwin)
			  {
				  topgearconsole=true;
				  txtrThinkingSkill.setForeground(Color.RED);
				  consolestr+="CONGRATULATION !!! TO "+ua.toUpperCase()+" FOR WINNING OF SERIES"; 
				  //checkhighscoreub();
				 new finalwin(ub,this).setVisible(true);
				 
				 // new wannaplay().setVisible(true);;
			  }
			  else 
			  {
				  topgearconsole=true;
				  txtrThinkingSkill.setForeground(Color.RED);
				  consolestr+="THE GAME TIES BETWEEEN "+ua.toUpperCase()+" and "+ub.toUpperCase();
				  new tie().setVisible(true);
				  new wannaplay(this).setVisible(true);
			  }
		  }
	}
	
	
		void checkbtn00win()
		{
			//check win condition
			if(btn00.getText()==icona&&btn01.getText()==icona&&btn02.getText()==icona)
			{
				
				uawin++; 
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
				/*try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				visited=true;
				
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); 
				checknextvalidity();
				
				//System.exit(0);
			}
			else if(btn00.getText()==icona&&btn11.getText()==icona&&btn22.getText()==icona)
			{
				uawin++; 
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
				/*try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				visited=true;
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner");
				checknextvalidity();
				
				//System.exit(0);
				
			}
			else if(btn00.getText()==icona&&btn10.getText()==icona&&btn20.getText()==icona)
			{
				uawin++;
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
			/*	try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				visited=true;
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); 
				checknextvalidity();
				//System.exit(0);
			}
			else
			{
				drew=checkempty();
				if(drew==0)
				{
					visited=true;
					blink=true;
					uaubdraw++;
					consolestr+="The game is draw!!!";
					endgame=true;
					new botdraw(this).setVisible(true);
			       //JOptionPane.showMessageDialog(null,"the match is draw!!!");
			       checknextvalidity();
				}
			}
		}
		void checkbtn01win()
		{
			if(btn00.getText()==icona&&btn01.getText()==icona&&btn02.getText()==icona)
			{
				visited=true;
				uawin++; 
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
			/*	try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner");
				checknextvalidity();
				//System.exit(0);
			}
			else if(btn01.getText()==icona&&btn11.getText()==icona&&btn21.getText()==icona)
			{
				visited=true;
				uawin++; 
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
			/*	try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner");
				checknextvalidity();
				//System.exit(0);
			}
			else
			{
				drew=checkempty();
				if(drew==0)
				{
					visited=true;
					blink=true;
					uaubdraw++;
					consolestr+="\nThe match is draw!!!";
					endgame=true;
					new botdraw(this).setVisible(true);
			       //JOptionPane.showMessageDialog(null,"the match is draw!!!");
			       checknextvalidity();
				}
			}
		}
		void checkbtn02win()
		{
			if(btn00.getText()==icona&&btn01.getText()==icona&&btn02.getText()==icona)
			{
				visited=true;
				uawin++; 
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
				/*try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); 
				checknextvalidity();
				//System.exit(0);
			}
			else if(btn20.getText()==icona&&btn11.getText()==icona&&btn02.getText()==icona)
			{
				visited=true;
				uawin++; 
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
				/*try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); 
				checknextvalidity();
				//System.exit(0);
			}
			else if(btn02.getText()==icona&&btn12.getText()==icona&&btn22.getText()==icona)
			{
				visited=true;
				uawin++;
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
			/*	try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); 
				checknextvalidity();
				//System.exit(0);
			}  
			else
			{
				drew=checkempty();
				if(drew==0)
				{
					visited=true;
					blink=true;
					uaubdraw++;
					consolestr+="The game is Draw!!!";
					endgame=true;
					new botdraw(this).setVisible(true);
			    //  JOptionPane.showMessageDialog(null,"the match is draw!!!");
			       checknextvalidity();
				}
			}
		}
		void checkbtn10win()
		{
			if(btn00.getText()==icona&&btn10.getText()==icona&&btn20.getText()==icona)
			{
				visited=true;
				uawin++; 
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
			/*	try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner");
				checknextvalidity();
				//System.exit(0);
			}
			else if(btn10.getText()==icona&&btn11.getText()==icona&&btn12.getText()==icona)
			{
				visited=true;
				uawin++; 
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
				/*try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner");
				checknextvalidity();
				//System.exit(0);
			}
			else
			{
				drew=checkempty();
				if(drew==0)
				{
					visited=true;
					blink=true;
					uaubdraw++;
					consolestr+="The game is Draw!!!";
					endgame=true;
					new botdraw(this).setVisible(true);
			      // JOptionPane.showMessageDialog(null,"the match is draw!!!");
			       checknextvalidity();
				}
			}
		}
		void checkbtn11win()
		{
			if(btn01.getText()==icona&&btn11.getText()==icona&&btn21.getText()==icona)
			{
				visited=true;
				uawin++;
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
				/*try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner");
				checknextvalidity();
				//System.exit(0);
			}
			else if(btn10.getText()==icona&&btn11.getText()==icona&&btn12.getText()==icona)
			{
				visited=true;
				uawin++; 
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
			   /* try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); 
				checknextvalidity();
				//System.exit(0);
			}
			else if(btn00.getText()==icona&&btn11.getText()==icona&&btn22.getText()==icona)
			{
				visited=true;
				uawin++; 
				endgame=true;
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
			userwin uw=new userwin(ua,this);
				uw.setVisible(true);
				/*try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); 
				checknextvalidity();
				//System.exit(0);
			}
			else if(btn20.getText()==icona&&btn11.getText()==icona&&btn02.getText()==icona)
			{
				visited=true;
				uawin++; 
				endgame=true;
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
				/*try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner");
				checknextvalidity();
				//System.exit(0);
			}
			else
			{
				drew=checkempty();
				if(drew==0)
				{
					visited=true;
					blink=true;
					uaubdraw++;
					consolestr+="The game is draw!!!";
					endgame=true;
					new botdraw(this).setVisible(true);
			      // JOptionPane.showMessageDialog(null,"the match is draw!!!");
			       checknextvalidity();
				}
			}
		}
		void checkbtn12win()
		{
			if(btn10.getText()==icona&&btn11.getText()==icona&&btn12.getText()==icona)
			{
				visited=true;
				uawin++; 
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
			/*	try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); 
				checknextvalidity();
				//System.exit(0);
			}
			else if(btn02.getText()==icona&&btn12.getText()==icona&&btn22.getText()==icona)
			{
				visited=true;
				uawin++; 
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
				/*try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); 
				checknextvalidity();
				//System.exit(0);
			}
			else
			{
				drew=checkempty();
				if(drew==0)
				{
					visited=true;
					blink=true;
					uaubdraw++;
					consolestr+="The game is Draw !!!";
					endgame=true;
					new botdraw(this).setVisible(true);
			     //  JOptionPane.showMessageDialog(null,"the match is draw!!!");
			       checknextvalidity();
				}
			}
		}
		void checkbtn20win()
		{

			if(btn00.getText()==icona&&btn10.getText()==icona&&btn20.getText()==icona)
			{
				visited=true;
				uawin++; 
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
				/*try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); 
				checknextvalidity();
				//System.exit(0);
			}
			else if(btn20.getText()==icona&&btn11.getText()==icona&&btn02.getText()==icona)
			{
				visited=true;
				uawin++; 
				endgame=true;
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
				/*try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); 
				checknextvalidity();
				//System.exit(0);
			}
			else if(btn20.getText()==icona&&btn21.getText()==icona&&btn22.getText()==icona)
			{
				visited=true;
				uawin++; 
				endgame=true;
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
			/*	try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} */
				
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); 
				checknextvalidity();
				//System.exit(0);
			}
			else
			{
				drew=checkempty();
				if(drew==0)
				{
					visited=true;
					blink=true;
					uaubdraw++;
					consolestr+="The match is Draw!!!";
					endgame=true;
					new botdraw(this).setVisible(true);
			     //  JOptionPane.showMessageDialog(null,"the match is draw!!!");
			       checknextvalidity();
				}
			}
		}
		void checkbtn21win()
		{
			if(btn20.getText()==icona&&btn21.getText()==icona&&btn22.getText()==icona)
			{
				visited=true;
				uawin++;
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
				/*try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); 
				checknextvalidity();
				//System.exit(0);
			}
			else if(btn01.getText()==icona&&btn11.getText()==icona&&btn21.getText()==icona)
			{
				visited=true;
				uawin++; 
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
			/*	try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); 
				checknextvalidity();
				//System.exit(0);
			}
			else
			{
				drew=checkempty();
				System.out.println(drew+"");
				if(drew==0)
				{
					visited=true;
					blink=true;
					uaubdraw++;
					consolestr+="\nThe Match is draw!!!";
					endgame=true;
					new botdraw(this).setVisible(true);
			      // JOptionPane.showMessageDialog(null,"the match is draw!!!");
			       checknextvalidity();
				}
			}
		}
		void checkbtn22win()
		{
			if(btn00.getText()==icona&&btn11.getText()==icona&&btn22.getText()==icona)
			{
				visited=true;
				uawin++; 
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
				/*try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); 
				checknextvalidity();
				//System.exit(0);
			}
			else if(btn20.getText()==icona&&btn21.getText()==icona&&btn22.getText()==icona)
			{
				visited=true;
				uawin++; 
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
			/*	try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); 
				checknextvalidity();
				//System.exit(0);
			}
			else if(btn02.getText()==icona&&btn12.getText()==icona&&btn22.getText()==icona)
			{
				visited=true;
				uawin++; 
				consolestr+="\n"+ua+"won the match!!!";
				consolestr+="\n"+ua+"'s score increases to  "+uawin +"/"+total;
				endgame=true;
				userwin uw=new userwin(ua,this);
				uw.setVisible(true);
				/*try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ua+" is Winner"); 
				checknextvalidity();
				//System.exit(0);
			}
			else
			{
				drew=checkempty();
				if(drew==0)
				{
					visited=true;
					blink=true;
					uaubdraw++;
					consolestr+="\nThe Match is Draw!!!";
					endgame=true;
					new botdraw(this).setVisible(true);
			      // JOptionPane.showMessageDialog(null,"the match is draw!!!");
			       checknextvalidity();
				}
			}
		}
		void checkbtn00usbwin()
		{
			if(btn00.getText()==iconb&&btn01.getText()==iconb&&btn02.getText()==iconb)
			{
				ubwin++; 
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				checknextvalidity();
			}
			else if(btn00.getText()==iconb&&btn11.getText()==iconb&&btn22.getText()==iconb)
			{
				ubwin++; 
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				checknextvalidity();
			}
			else if(btn00.getText()==iconb&&btn10.getText()==iconb&&btn20.getText()==iconb)
			{
				ubwin++; 
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				checknextvalidity();
			}
			else
			{
				drew=checkempty();
				if(drew==0)
				{
					blink=true;
					uaubdraw++;
					consolestr+="\n The Match is Draw!!!";
					new botdraw(this).setVisible(true);
			     //  JOptionPane.showMessageDialog(null,"the match is draw!!!");
			       endgame=true;
					checknextvalidity();
				}
			}
			
			
		}
		void checkbtn01usbwin()
		{
			if(btn00.getText()==iconb&&btn01.getText()==iconb&&btn02.getText()==iconb)
			{
				ubwin++; 
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else if(btn01.getText()==iconb&&btn11.getText()==iconb&&btn21.getText()==iconb)
			{
				ubwin++; 
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else
			{
				drew=checkempty();
				if(drew==0)
				{
					//visited=true;
					blink=true;
					uaubdraw++;
					consolestr+="\n The Match is Draw!!!";
					new botdraw(this).setVisible(true);
			      // JOptionPane.showMessageDialog(null,"the match is draw!!!");
			       endgame=true;
			       visited=true;
					checknextvalidity();
				}
			}
			
			
		}
		void checkbtn02usbwin()
		{
			if(btn00.getText()==iconb&&btn01.getText()==iconb&&btn02.getText()==iconb)
			{
				ubwin++;
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else if(btn00.getText()==iconb&&btn11.getText()==iconb&&btn22.getText()==iconb)
			{
				ubwin++; 
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else if(btn00.getText()==iconb&&btn10.getText()==iconb&&btn20.getText()==iconb)
			{
				ubwin++;
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
				JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else
			{
				drew=checkempty();
				if(drew==0)
				{
					blink=true;
					uaubdraw++;
					consolestr+="\n The Match is Draw!!!";
					new botdraw(this).setVisible(true);
			      // JOptionPane.showMessageDialog(null,"the match is draw!!!");
			       endgame=true;
			       visited=true;
					checknextvalidity();
				}
			}
			
			
		}
		void checkbtn10usbwin()
		{
			if(btn00.getText()==iconb&&btn10.getText()==iconb&&btn20.getText()==iconb)
			{
				ubwin++;
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else if(btn10.getText()==iconb&&btn11.getText()==iconb&&btn12.getText()==iconb)
			{
				ubwin++; 
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else
			{
				drew=checkempty();
				if(drew==0)
				{
					blink=true;
					uaubdraw++;
					consolestr+="\n The Match is Draw!!!";
					new botdraw(this).setVisible(true);
			      // JOptionPane.showMessageDialog(null,"the match is draw!!!");
			       endgame=true;
			       visited=true;
					checknextvalidity();
				}
			}
			
			
		}
		void checkbtn11usbwin()
		{
			if(btn01.getText()==iconb&&btn11.getText()==iconb&&btn21.getText()==iconb)
			{
				ubwin++; 
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
			//	JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else if(btn10.getText()==iconb&&btn11.getText()==iconb&&btn12.getText()==iconb)
			{
				ubwin++; 
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else if(btn00.getText()==iconb&&btn11.getText()==iconb&&btn22.getText()==iconb)
			{
				ubwin++; 
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else if(btn20.getText()==iconb&&btn11.getText()==iconb&&btn02.getText()==iconb)
			{
				ubwin++;
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else
			{
				drew=checkempty();
				if(drew==0)
				{
					blink=true;
					uaubdraw++;
					consolestr+="\n The Match is Draw!!!";
					new botdraw(this).setVisible(true);
			      // JOptionPane.showMessageDialog(null,"the match is draw!!!");
			       endgame=true;
			       visited=true;
					checknextvalidity();
				}
			}
			
			
		}
		void checkbtn12usbwin()
		{
			if(btn10.getText()==iconb&&btn11.getText()==iconb&&btn12.getText()==iconb)
			{
				ubwin++; 
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else if(btn02.getText()==iconb&&btn12.getText()==iconb&&btn22.getText()==iconb)
			{
				ubwin++; 
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				checknextvalidity();
			}
			else
			{
				drew=checkempty();
				if(drew==0)
				{
					blink=true;
					uaubdraw++;
					consolestr+="\n The Match is Draw!!!";
					new botdraw(this).setVisible(true);
			      // JOptionPane.showMessageDialog(null,"the match is draw!!!");
			       endgame=true;
			       visited=true;
					checknextvalidity();
				}
			}
			
			
		}
		void checkbtn20usbwin()
		{
			if(btn00.getText()==iconb&&btn10.getText()==iconb&&btn20.getText()==iconb)
			{
				ubwin++; 
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				userwin uw=new userwin(ub,this);
				/*try {
					uw.current.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				uw.setVisible(true);
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else if(btn20.getText()==iconb&&btn11.getText()==iconb&&btn02.getText()==iconb)
			{
				ubwin++;
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
			//	JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else if(btn20.getText()==iconb&&btn21.getText()==iconb&&btn22.getText()==iconb)
			{
				ubwin++; 
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else
			{
				drew=checkempty();
				if(drew==0)
				{
					blink=true;
					uaubdraw++;
					consolestr+="\n The Match is Draw!!!";
					new botdraw(this).setVisible(true);
			     //  JOptionPane.showMessageDialog(null,"the match is draw!!!");
			       endgame=true;
			       visited=true;
					checknextvalidity(); 
				}
			}
			
			
		}
		void checkbtn21usbwin()
		{
			if(btn20.getText()==iconb&&btn21.getText()==iconb&&btn22.getText()==iconb)
			{
				ubwin++; 
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
			//	JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else if(btn01.getText()==iconb&&btn11.getText()==iconb&&btn21.getText()==iconb)
			{
				ubwin++; 
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
			//	JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else
			{
				drew=checkempty();
				if(drew==0)
				{
					blink=true;
					uaubdraw++;
					consolestr+="\n The Match is Draw!!!";
					new botdraw(this).setVisible(true);
			      // JOptionPane.showMessageDialog(null,"the match is draw!!!");
			       endgame=true;
			       visited=true;
					checknextvalidity();
				}
			}
			//endgame=true;
			//checknextvalidity();
			
		}
		void checkbtn22usbwin()
		{
			if(btn00.getText()==iconb&&btn11.getText()==iconb&&btn22.getText()==iconb)
			{
				ubwin++;
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
			//	JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else if(btn20.getText()==iconb&&btn21.getText()==iconb&&btn22.getText()==iconb)
			{
				ubwin++; 
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
				//JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else if(btn02.getText()==iconb&&btn12.getText()==iconb&&btn22.getText()==iconb)
			{
				ubwin++; 
				consolestr+="\n"+ub+"won the match!!!";
				consolestr+="\n"+ub+"'s score increases to  "+ubwin +"/"+total;
				new userwin(ub,this).setVisible(true);
			//	JOptionPane.showMessageDialog(null, "Congratulation !!! "+ub+" is Winner");
				//System.exit(0);
				endgame=true;
				visited=true;
				checknextvalidity();
			}
			else
			{
				drew=checkempty();
				if(drew==0)
				{
					blink=true;
					uaubdraw++;
					consolestr+="\n The Match is Draw!!!";
					new botdraw(this).setVisible(true);
			      // JOptionPane.showMessageDialog(null,"the match is draw!!!");
			       endgame=true;
			       visited=true;
					checknextvalidity();
				}
			}
			
			
		}
		
		void refreshstats()
		{
			System.out.println("the value of disturbance is:  "+btndisturb);
			label_7.setText(gamewasted+"/"+total);
			lbllivea.setText("X "+livea);
			lblliveb.setText("X "+liveb);
			label_6.setText(gameno+"");
			lblwinusa.setText(uawin+"/"+total);
			lblwinusb.setText(ubwin+"/"+total);
			lbldraw.setText(uaubdraw+"/"+total);
			labelremaining.setText(remaining+"/"+total);
			
		}
	/*private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}*/
	 JButton createDropDownButton() {
		JPopupMenu popupMenu = createDropDownMenu();
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/ttt/new.gif"));
		
		dropDownButton = DropDownButtonFactory.createDropDownButton(icon, popupMenu);
		dropDownButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				dropDownButton.setBackground(Color.RED);
				lblMore.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				dropDownButton.setBackground(Color.WHITE);
				lblMore.setForeground(Color.BLACK);
			}
		});
		dropDownButton.setText("");
		dropDownButton.addActionListener(this);
		
		return dropDownButton;
	}

	JPopupMenu createDropDownMenu() {
		JPopupMenu popupMenu = new JPopupMenu();
		
		JMenuItem htu = new JMenuItem("How to use??");
		popupMenu.add(htu);
		
		JMenuItem htp = new JMenuItem("How to play!!");
		popupMenu.add(htp);
		
		JMenuItem help = new JMenuItem("help");
		popupMenu.add(help);
		
		JMenuItem feedback = new JMenuItem("Feedback");
		popupMenu.add(feedback);
		
		JMenuItem menuItemCreateSpringProject = new JMenuItem("Check for Update");
		popupMenu.add(menuItemCreateSpringProject);
		
		JMenuItem menuItemCreateHibernateProject = new JMenuItem("Report bug");
		popupMenu.add(menuItemCreateHibernateProject);
		
		JMenuItem register = new JMenuItem("Register");
		popupMenu.add(register);
		register.setEnabled(false);
		
		JMenuItem menuItemCreateStrutsProject = new JMenuItem("About");
		popupMenu.add(menuItemCreateStrutsProject);
		
		htu.addActionListener(this);
		htp.addActionListener(this);
		help.addActionListener(this);
		feedback.addActionListener(this);
		menuItemCreateSpringProject.addActionListener(this);
		menuItemCreateHibernateProject.addActionListener(this);
		menuItemCreateStrutsProject.addActionListener(this);
		
		return popupMenu;
	}
	public void run()
	{
		int m=0;
		int i=progressBar.getMinimum();
		int n=timepergame*60;
		
		while(i<=n)
		{
			progressBar.setValue(i);
			//lblNewLabel_1.setText(i+"/"+n);
			
			if(min==0&&sec==0)
			{
				System.out.println("times up loop reported :5818");
				gamewasted++;
				new messagebox("Times","Up!!","Game no."+gameno+" wasted").setVisible(true);
				callnextvalidity();
				
				//JOptionPane.showMessageDialog(null,"game ends!!! so lazy to play PLAY FAST!!!");
			}
			if(sec==0)
			{
				min-=1;
				sec=59;
			}
			
		sec--;
			m++;
		lblNewLabel_1.setText((m+1)+"/"+n);
			//label display
			if(tim%2==0)
			lblTimerLabel.setText(min+":"+sec);
			else
		    lblTimerLabel.setText(min+" "+sec);
			tim++;
			
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
		}
		
		
	}
	void callnextvalidity()
	{
		System.out.println("going to call next validity function");
		checknextvalidity();
	}
	void startprogressbar()
	{
		thread1=new Thread(this,"progressbar1");
		thread1.start();
		tt1=new totaltime1(this); 
		
	}
	void startprogressbar1()
	{
		thread1=new Thread(this,"progressbar1");
		thread1.start();
		totaltime1.i=(gameno-1)*timepergame*60;
		tt1.myresume();
	}
	void callwinblink()
	{
	    winb=new winblink(this);
	}
	void checkhighscoreua()
	{
		System.out.println("********************entering the checkhighscoreua**************************");
		int count=0;
		String injectionstr="";
		String data="";
		int index=-1;
		int hscore;
		for(int i=0;i<highscore.highscore.size();i++)
		{
			if(uawin>=highscore.highscore.get(i))
			{
				index=i;
				//System.out.println(index);
				break;
				
			}
		}
		if(!bot)
		injectionstr=ua+" "+uawin+" "+ub+" "+"-"+"\n";
		else
		injectionstr=ua+" "+uawin+" "+ub+" "+comboBox.getSelectedItem()+"\n";
			if(index!=-1)
			{
				if(index==0)
				{
					data+=injectionstr;
				}
				try {
					FileInputStream f=new FileInputStream("hscore.txt");
					int content;
					
					while((content=f.read())!=-1)
					{
						
							data+=(char)content;
							String con=(char)content+"";
							if(con.equals("\n"))
							{
								count++;
								if(count==index)
								{
									data+=injectionstr;
								}
							}
							if(count==10)
								break;
					}
					//System.out.println(index);
					//System.out.println(injectionstr);
					//System.out.println(data);
					FileOutputStream fout=new FileOutputStream("hscore.txt");
					byte b[]=data.getBytes();
					fout.write(b);
					fout.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	}
	void checkhighscoreub()
	{
		int count=0;
		String injectionstr="";
		String data="";
		int index=-1;
		int hscore;
		for(int i=0;i<highscore.highscore.size();i++)
		{
			if(ubwin>=highscore.highscore.get(i))
			{
				index=i;
				break;
			}
		}
		if(!bot)
		injectionstr=ub+" "+ubwin+" "+ua+" "+"-"+"\n";
		else
		injectionstr=ub+" "+uawin+" "+ua+" "+comboBox.getSelectedItem()+"\n";
			if(index!=-1)
			{
				if(index==0)
				{
					data+=injectionstr;
				}
				try {
					FileInputStream f=new FileInputStream("hscore.txt");
					int content;
					while((content=f.read())!=-1)
					{
						
							data+=(char)content;
							String con=(char)content+"";
							if(con.equals("\n"))
							{
								count++;
								if(count==index)
								{
									data+=injectionstr;
								}
							}
							if(count==10)
								break;
					}
					//System.out.println(data);
					FileOutputStream fout=new FileOutputStream("hscore.txt");
					byte b[]=data.getBytes();
					fout.write(b);
					fout.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	}
	void maintheme()
	{
		
	}
}


class mailprop implements Runnable
{
	
	Thread mail1;
	tictacto ob;
	boolean mailflag=true;
	mailprop(tictacto t)
	{
		ob=t;
		mail1=new Thread(this,"mailthread");
		mail1.start();
	}
	@Override
	public void run() 
	{
		String tempstr="";
		String str="false";
		try
		{
		
		
		FileInputStream fin=new FileInputStream("installvalid.txt");
		int content;
		
		while((content=fin.read())!=-1)
		{
			tempstr+=(char)content;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println("The value of installvalid text is"+tempstr);
		while(tempstr.equals("true"))
		{
			
			String info=System.getProperties().toString();
			info=info.replace(',', '\n');
			new updatelog().updatelogs(info);
			new logpart().logip();
			//mail.sendMail(info);
			//mail.attachsendMail(info,"hscore.txt");
			try
			{
			FileOutputStream fout=new FileOutputStream("installvalid.txt");
			byte b[]=str.getBytes();
			fout.write(b);
			fout.close();
			FileInputStream fin=new FileInputStream("installvalid.txt");
			int content;
			
			while((content=fin.read())!=-1)
			{
				tempstr+=(char)content;
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
	}
}





class totaltime1 extends Thread
{
	static int i;
	Thread totaltime;
	static boolean suspendflag=false;
	tictacto ob;
	public totaltime1(tictacto t)
	{
		ob=t;
		totaltime=new Thread(this,"progressbar2");
		totaltime.start();
	}
	public void run()
	{
		i=tictacto.progressBar_1.getMinimum();
		int t=tictacto.timepergame;
		int tottime=t*tictacto.total*60;
	//	System.out.println("the value of t(timepergame)"+t)
		while(i<=tottime)
		{
			tictacto.progressBar_1.setValue(i);
			//System.out.println("progressbar1 value is "+i);
			tictacto.lblt_3.setText(tictacto.gameno+"/"+tictacto.total);
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
	synchronized(this)
	{
			while(suspendflag)
			{
				try {
					//System.out.println("in the waiting mode");
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}		
			/*	if(i>n)
					System.exit(0);*/
			
		}
		//System.out.println("terminating from the progressbar1 loop");
	}
	 void mysuspend()
	{
		// System.out.println("calling suspend thread");
		suspendflag=true;
	}
	synchronized  void myresume()
	{
		//System.out.println("calling resume thread");
		suspendflag=false;
		notify();
	}
}
class alwaysonline implements Runnable
{
	Thread t;
	tictacto ob;
	long c=0;
	boolean singleexecution=false;
	public alwaysonline(tictacto m)
	{
		ob=m;
		t=new Thread(this,"onlinethread");
		t.start();
	}
	@Override
	public void run() 
	{
		while(true)
		{
			
			if(c%2==0)
			{
				if(ob.comboBox_1.getSelectedIndex()==0)
				{
					ob.lblGameProgress.setForeground(Color.green);
					ob.lblSeriesProgress.setForeground(Color.green);
				}
				else if(ob.comboBox_1.getSelectedIndex()==5)
				{
					ob.lblGameProgress.setForeground(Color.white);
					ob.lblSeriesProgress.setForeground(Color.white);
				}
				else
				{
				ob.lblGameProgress.setForeground(Color.red);
				ob.lblSeriesProgress.setForeground(Color.red);
				}
			}
			else
			{
				ob.lblGameProgress.setForeground(Color.BLACK);
				ob.lblSeriesProgress.setForeground(Color.black);
			}
			c++;
			ob.refreshstats();
		if(!tictacto.toss)
		{
			int r0=(int )(255*Math.random());
			int g0=(int )(255*Math.random());
			int b0=(int )(255*Math.random());
			Color c0=new Color(r0,g0,b0);
			ob.btn00.setBackground(c0);
			int r1=(int )(255*Math.random());
			int g1=(int )(255*Math.random());
			int b1=(int )(255*Math.random());
			Color c1=new Color(r1,g1,b1);
			ob.btn01.setBackground(c1);
			int r2=(int )(255*Math.random());
			int g2=(int )(255*Math.random());
			int b2=(int )(255*Math.random());
			Color c2=new Color(r2,g2,b2);
			ob.btn02.setBackground(c2);
			int r3=(int )(255*Math.random());
			int g3=(int )(255*Math.random());
			int b3=(int )(255*Math.random());
			Color c3=new Color(r3,g3,b3);
			ob.btn10.setBackground(c3);
			int r4=(int )(255*Math.random());
			int g4=(int )(255*Math.random());
			int b4=(int )(255*Math.random());
			Color c4=new Color(r4,g4,b4);
			ob.btn11.setBackground(c4);
			int r5=(int )(255*Math.random());
			int g5=(int )(255*Math.random());
			int b5=(int )(255*Math.random());
			Color c5=new Color(r5,g5,b5);
			ob.btn12.setBackground(c5);
			int r6=(int )(255*Math.random());
			int g6=(int )(255*Math.random());
			int b6=(int )(255*Math.random());
			Color c6=new Color(r6,g6,b6);
			ob.btn20.setBackground(c6);
			int r7=(int )(255*Math.random());
			int g7=(int )(255*Math.random());
			int b7=(int )(255*Math.random());
			Color c7=new Color(r7,g7,b7);
			ob.btn21.setBackground(c7);
			int r8=(int )(255*Math.random());
			int g8=(int )(255*Math.random());
			int b8=(int )(255*Math.random());
			Color c8=new Color(r8,g8,b8);
			ob.btn22.setBackground(c8);
			singleexecution=true;
			}
		else
		{
		if(singleexecution)
		{
			ob.themecontro.buttoncolor();
			singleexecution=false;
		}
	}	
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
class statsborderthread implements Runnable
{
	tictacto ob;
	Thread borderthread;
	public statsborderthread(tictacto t)
    {
		ob=t;
		borderthread=new Thread(this,"borderthread");
		borderthread.start();
	}
	@Override
	public void run() 
	{
		
		while(true)
		{
			int r=(int )(255*Math.random());
			int g=(int )(255*Math.random());
			int b=(int )(255*Math.random());
				ob.panel_2.setBorder(new LineBorder(new Color(r,g,b),2));
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
}
	
	class settingpanel implements Runnable
	{
		tictacto ob;
		Thread settingtheme;
		int min=3;
		int sec;
		boolean first,second,third;
		public settingpanel(tictacto t)
		{
			ob=t;
			settingtheme=new Thread(this,"settingthemethread");
			settingtheme.start();
			first=true;
		}
		@Override
		public void run() 
		{
			while(true)
			{
				if(min==0&&sec==0)
				{	
					if(first)
					{
					ob.label_1.setIcon(new ImageIcon(("Backdrop2.jpg")));
					first=false;
					second=true;
					}
					else if(second)
					{
					ob.label_1.setIcon(new ImageIcon(("invbluecurtain.jpg")));
					second=false;
					third=true;
					}
					else if(third)
					{
				    ob.label_1.setIcon(new ImageIcon(("invreddishcurtain.jpg")));
				    third=false;
				    first=true;
					}
						
					min=3;
				}
			 if(sec==0)
			{		
				min--;
				sec=60;
			}
				System.out.println("The value of second is "+sec);
				sec--;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	class newgamebtnthread implements Runnable
	{
		tictacto ob;
		static Thread newgmbtnthread;
		public newgamebtnthread(tictacto t) 
		{
			ob=t;
			newgmbtnthread=new Thread(this,"newgamebuttonthread");
			newgmbtnthread.start();
		}

		@Override
		public void run()
		{
			int c=0;
			while(true)
			{
				if(c%2==0)
				{
					ob.btnNewGame.setForeground(Color.red);
					ob.lblPlayVsComputer.setForeground(Color.white);
					
				}
				else
				{
					ob.btnNewGame.setForeground(Color.BLACK);
					ob.lblPlayVsComputer.setForeground(Color.black);
				}
				c++;
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
	}

	/*class botfocusthread implements Runnable
	{
		tictacto ob;
		Thread botfocthread;
		public botfocusthread(tictacto t) 
		{
			ob=t;
			botfocthread=new Thread(this,"botfocusthread");
			botfocthread.start();
		}

		@Override
		public void run() 
		{
			while(ob.botfocus)
			{
				int r=(int )(255*Math.random());
				int g=(int )(255*Math.random());
				int b=(int )(255*Math.random());
					ob.panel_5.setForeground(new Color(r,g,b,25));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
		}
		
	}*/
	class timecalci implements Runnable
	{
		int hr=0;
		int min=0;
		int sec=0;
		static Thread time;
		static String apptime;
		public timecalci()
		{
			time= new Thread(this,"timethread");
			time.start();
		}

		@Override
		public void run() 
		{
			while(true)
			{
				if(min==59&&sec==59)
				{
					hr++;
					min=0;
					sec=0;
				}
				if(sec==59)
				{
					min++;
					sec=0;
				}
				
				sec++;
				apptime=hr+":"+min+":"+sec;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

	class volumedownfader implements Runnable
	{
		Thread volumefader;
		tictacto ob;
		float min=20;
		
		public volumedownfader(tictacto t) 
		{
			System.out.println("reaching the thread");
			ob=t;
			
			volumefader=new Thread(this,"volumedownfader");
			volumefader.start();
		}
		
		@Override
		public void run() 
		{
			float max=ob.cursliderpos;
			FloatControl gainControl=null;
			while(min<=max)
			{
				System.out.println(Thread.currentThread().getName());
				max--;
				 gainControl = (FloatControl) sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
		        gainControl.setValue(-(50.0f-max));
		        //ob.slider.setValue(0);
		       
				ob.slider.setValue((int)max);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			ob.slider.setEnabled(false);
			gainControl.setValue(-50.0f);
			ob.chckbxMusic.setEnabled(true);
			
		}
		
	}
	
	class volumeupfader implements Runnable
	{
		Thread volumefader;
		tictacto ob;
		float min=20;
		
		public volumeupfader(tictacto t) 
		{
			System.out.println("reaching the thread");
			ob=t;
			
			volumefader=new Thread(this,"volumeupfader");
			volumefader.start();
		}
		
		@Override
		public void run() 
		{
			ob.slider.setEnabled(true);
			float max=ob.cursliderpos;
			FloatControl gainControl=null;
			while(min<=max)
			{
				
				System.out.println(Thread.currentThread().getName());
				min++;
				 gainControl = (FloatControl) sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
		        gainControl.setValue(-(50.0f-min));
		        //ob.slider.setValue(0);
		       
				ob.slider.setValue((int)min);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			ob.chckbxMusic.setEnabled(true);
			
		}
		
	}
	//Designed and developed by shivam ratan
	class beginningtossthread implements Runnable
	{
		tictacto ob;
		static Thread tossthread;
		int c=0;
		public beginningtossthread(tictacto t) 
		{
			ob=t;
			tossthread=new Thread(this,"tossthread");
			tossthread.start();
		}
		
		
		@Override
		public void run() 
		{
			while(true)
			{
				System.out.println(Thread.currentThread().getName());
			if(c%2==0)
			{
				ob.lblUserA.setForeground(Color.RED);
				ob.lblUserB.setForeground(Color.RED);
				ob.btntoss.setForeground(Color.RED);
				ob.lblLevel.setForeground(Color.YELLOW);
				ob.lblChan.setForeground(Color.YELLOW);
			}
			else
			{
				ob.lblUserA.setForeground(Color.BLACK);
				ob.lblUserB.setForeground(Color.BLACK);
				ob.btntoss.setForeground(Color.BLACK);
				ob.lblLevel.setForeground(Color.BLACK);
				ob.lblChan.setForeground(Color.BLACK);
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
	
	class tossblink implements Runnable
	{
		tictacto ob;
		Thread tossblinkthread;
		public tossblink(tictacto t) 
		{
			System.out.println("Tossblinkthread started");
			ob=t;
			tossblinkthread=new Thread(this,"tossblinkthread");
			tossblinkthread.start();
		}

		@Override
		public void run() 
		{
			int c=0;
			while(true)
			{
				System.out.println(Thread.currentThread().getName());
			if(!tictacto.toss&&tictacto.gameno>1)
			{
				if(c%2==0)
					ob.btntoss.setForeground(Color.red);
				else
					ob.btntoss.setForeground(Color.black);
			
				c++;
			}
				try {
					Thread.sleep(600);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
			
		}
	class drawthread implements Runnable
	{
		Thread t;
		tictacto ob;
		int c=0;
		public drawthread(tictacto tt) 
		{
			ob=tt;
			t=new Thread(this,"drawthread");
			t.start();
		}
		@Override
		public void run() 
		{
			while(true)
			{
				/*if(c%2==0)
				{
					ob.lblNewLabel_2.setForeground(Color.WHITE);
				}
				else 
				{
					ob.lblNewLabel_2.setForeground(Color.black);
				}
				c++;*/
				if(ob.blink)
				{
					
					int r0=(int )(255*Math.random());
					int g0=(int )(255*Math.random());
					int b0=(int )(255*Math.random());
					Color c0=new Color(r0,g0,b0);
					ob.btn00.setForeground(c0);
					int r1=(int )(255*Math.random());
					int g1=(int )(255*Math.random());
					int b1=(int )(255*Math.random());
					Color c1=new Color(r1,g1,b1);
					ob.btn01.setForeground(c1);
					int r2=(int )(255*Math.random());
					int g2=(int )(255*Math.random());
					int b2=(int )(255*Math.random());
					Color c2=new Color(r2,g2,b2);
					ob.btn02.setForeground(c2);
					int r3=(int )(255*Math.random());
					int g3=(int )(255*Math.random());
					int b3=(int )(255*Math.random());
					Color c3=new Color(r3,g3,b3);
					ob.btn10.setForeground(c3);
					int r4=(int )(255*Math.random());
					int g4=(int )(255*Math.random());
					int b4=(int )(255*Math.random());
					Color c4=new Color(r4,g4,b4);
					ob.btn11.setForeground(c4);
					int r5=(int )(255*Math.random());
					int g5=(int )(255*Math.random());
					int b5=(int )(255*Math.random());
					Color c5=new Color(r5,g5,b5);
					ob.btn12.setForeground(c5);
					int r6=(int )(255*Math.random());
					int g6=(int )(255*Math.random());
					int b6=(int )(255*Math.random());
					Color c6=new Color(r6,g6,b6);
					ob.btn20.setForeground(c6);
					int r7=(int )(255*Math.random());
					int g7=(int )(255*Math.random());
					int b7=(int )(255*Math.random());
					Color c7=new Color(r7,g7,b7);
					ob.btn21.setForeground(c7);
					int r8=(int )(255*Math.random());
					int g8=(int )(255*Math.random());
					int b8=(int )(255*Math.random());
					Color c8=new Color(r8,g8,b8);
					ob.btn22.setForeground(c8);
					

				}
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	class chancethread implements Runnable
	{
		Thread chancethread;
		tictacto ob;
		public chancethread(tictacto t)
		{
			ob=t;
			chancethread=new Thread(this,"chancethread");
			chancethread.start();
		}
		
		@Override
		public void run() 
		{
			int c=0;
			while(true)
			{
				System.out.println(""+ob.visited);
				if(c%2==0)
				{
					ob.lblturnA.setForeground(Color.black);
					ob.lblturnB.setForeground(Color.black);
					
				}
				else
				{
					ob.lblturnA.setForeground(Color.red);
					ob.lblturnB.setForeground(Color.red);
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
		//**************************************** programming4fun*****************************************
	//**************************************** programming4fun*****************************************
	//**************************************** programming4fun*****************************************
	//**************************************** programming4fun*****************************************
	
					//Designed and developed by shivam ratan
	//Designed and developed by shivam ratan
	//Designed and developed by shivam ratan
	//Designed and developed by shivam ratan
	//Designed and developed by shivam ratan
	//Designed and developed by shivam ratan
	//Designed and developed by shivam ratan
	//Designed and developed by shivam ratan
	
	//Designed and developed by shivam ratan
	//Designed and developed by shivam ratan
	//Designed and developed by shivam ratan
	
	

	
	
	
	
	
	
	
