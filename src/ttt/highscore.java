package ttt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class indexandscore
{
	int index;
	int score;
		public indexandscore(int index,int score) 
		{
			this.index=index;
			this.score=score;
		}
}

public class highscore extends JDialog implements Runnable {

	JLabel label;
	private JPanel contentPane;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	static JLabel label_14;
	private JLabel label_21;
	private JLabel label_22;
	private JLabel label_23;
	static JLabel label_24;
	private JLabel label_31;
	private JLabel label_32;
	private JLabel label_33;
	 static JLabel label_34;
	private JLabel label_41;
	private JLabel label_42;
	private JLabel label_43;
	static JLabel label_44;
	private JLabel label_17;
	private JLabel label_81;
	private JLabel label_82;
	private JLabel label_83;
	 static JLabel label_84;
	private JLabel label_71;
	private JLabel label_72;
	private JLabel label_73;
	 static JLabel    label_74;
	 static JLabel label_64;
	private JLabel label_63;
	private JLabel label_62;
	private JLabel label_61;
	private JLabel label_51;
	private JLabel label_52;
	private JLabel label_53;
	 static JLabel label_54;
	private JLabel label_35;
	private JLabel label_36;
	private JLabel label_37;
	private JLabel label_91;
	private JLabel label_92;
	private JLabel label_93;
	 static JLabel label_94;
	private JLabel label_101;
	private JLabel label_102;
	private JLabel label_103;
	 static JLabel label_104;
	static int[] a=new int[10];
	static ArrayList<Integer> highscore=new ArrayList<>();
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	JLabel lblHighScore;
	Thread t;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					highscore frame = new highscore();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public highscore() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				t.stop();
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 703, 592);
		setModal(true);
		int w=703;
		int h=592;
		  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		  int W=screen.width;
		  int H=screen.height;
		  int x=(W-w)/2;
		  int y=(H-h)/2;
		  setBounds(x-250, y, w, h);
		contentPane = new JPanel();
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
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
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 697, 563);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 lblHighScore = new JLabel("High Score");
		lblHighScore.setForeground(new Color(255, 255, 0));
		lblHighScore.setFont(new Font("Rage Italic", Font.BOLD, 62));
		lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighScore.setBounds(139, 10, 367, 73);
		panel.add(lblHighScore);
		
		JLabel lblName = new JLabel("Winner");
		lblName.setFont(new Font("Snap ITC", Font.PLAIN, 30));
		lblName.setBounds(25, 78, 144, 42);
		panel.add(lblName);
		
		JLabel lblAgainst = new JLabel("Against");
		lblAgainst.setForeground(new Color(255, 99, 71));
		lblAgainst.setFont(new Font("Snap ITC", Font.PLAIN, 30));
		lblAgainst.setBounds(358, 78, 144, 42);
		panel.add(lblAgainst);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setForeground(Color.MAGENTA);
		lblScore.setBackground(Color.MAGENTA);
		lblScore.setFont(new Font("Snap ITC", Font.PLAIN, 30));
		lblScore.setBounds(197, 78, 124, 42);
		panel.add(lblScore);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setForeground(new Color(255, 0, 0));
		lblLevel.setFont(new Font("Snap ITC", Font.PLAIN, 30));
		lblLevel.setBackground(new Color(255, 0, 0));
		lblLevel.setBounds(553, 78, 124, 42);
		panel.add(lblLevel);
		
		label_11 = new JLabel("Shivam");
		label_11.setForeground(Color.YELLOW);
		label_11.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(34, 130, 109, 50);
		panel.add(label_11);
		
		 label = new JLabel("1.");
		label.setFont(new Font("Snap ITC", Font.PLAIN, 21));
		label.setBounds(10, 130, 22, 50);
		panel.add(label);
		
		label_12 = new JLabel("Impossible");
		label_12.setForeground(Color.YELLOW);
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_12.setBounds(187, 130, 154, 50);
		panel.add(label_12);
		
		label_13 = new JLabel("Bot");
		label_13.setForeground(Color.YELLOW);
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_13.setBounds(358, 130, 154, 50);
		panel.add(label_13);
		
		 label_14 = new JLabel("50");
		 label_14.setForeground(Color.YELLOW);
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_14.setBounds(523, 130, 154, 50);
		panel.add(label_14);
		
		JLabel label_2 = new JLabel("2.");
		label_2.setFont(new Font("Snap ITC", Font.PLAIN, 21));
		label_2.setBounds(6, 171, 35, 50);
		panel.add(label_2);
		
	label_21 = new JLabel("");
//	label_21.setForeground(Color.WHITE);
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_21.setBounds(41, 171, 112, 50);
		panel.add(label_21);
		
		 label_22 = new JLabel("");
		// label_22.setForeground(Color.WHITE);
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_22.setBounds(184, 171, 154, 50);
		panel.add(label_22);
		
		 label_23 = new JLabel("");
	//	 label_23.setForeground(Color.WHITE);
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_23.setBounds(355, 171, 154, 50);
		panel.add(label_23);
		
	 label_24 = new JLabel("");
//	 label_24.setForeground(Color.WHITE);
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_24.setBounds(520, 171, 154, 50);
		panel.add(label_24);
		
		JLabel label_7 = new JLabel("3.");
		label_7.setFont(new Font("Snap ITC", Font.PLAIN, 21));
		label_7.setBounds(7, 212, 35, 50);
		panel.add(label_7);
		
		 label_31 = new JLabel("");
		// label_31.setForeground(Color.WHITE);
		label_31.setHorizontalAlignment(SwingConstants.CENTER);
		label_31.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_31.setBounds(31, 212, 124, 50);
		panel.add(label_31);
		
		 label_32 = new JLabel("");
		label_32.setHorizontalAlignment(SwingConstants.CENTER);
	//	label_32.setForeground(Color.WHITE);
		label_32.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_32.setBounds(184, 212, 154, 50);
		panel.add(label_32);
		
		label_33 = new JLabel("");
		label_33.setHorizontalAlignment(SwingConstants.CENTER);
	//	label_33.setForeground(Color.WHITE);
		label_33.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_33.setBounds(355, 212, 154, 50);
		panel.add(label_33);
		
		label_34 = new JLabel("");
		label_34.setHorizontalAlignment(SwingConstants.CENTER);
		//label_34.setForeground(Color.WHITE);
		label_34.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_34.setBounds(520, 212, 154, 50);
		panel.add(label_34);
		
		JLabel label_1002 = new JLabel("4.");
		label_1002.setFont(new Font("Snap ITC", Font.PLAIN, 21));
		label_1002.setBounds(7, 251, 37, 50);
		panel.add(label_1002);
		
		label_41 = new JLabel("");
		label_41.setHorizontalAlignment(SwingConstants.CENTER);
	//	label_41.setForeground(Color.WHITE);
		label_41.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_41.setBounds(31, 251, 134, 50);
		panel.add(label_41);
		
		label_42 = new JLabel("");
		label_42.setHorizontalAlignment(SwingConstants.CENTER);
	//	label_42.setForeground(Color.WHITE);
		label_42.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_42.setBounds(184, 251, 154, 50);
		panel.add(label_42);
		
		label_43 = new JLabel("");
		label_43.setHorizontalAlignment(SwingConstants.CENTER);
	//	label_43.setForeground(Color.WHITE);
		label_43.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_43.setBounds(355, 251, 154, 50);
		panel.add(label_43);
		
		label_44 = new JLabel("");
		label_44.setHorizontalAlignment(SwingConstants.CENTER);
	//	label_44.setForeground(Color.WHITE);
		label_44.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_44.setBounds(520, 251, 154, 50);
		panel.add(label_44);
		
		 label_17 = new JLabel("8.");
		label_17.setFont(new Font("Snap ITC", Font.PLAIN, 21));
		label_17.setBounds(4, 417, 34, 50);
		panel.add(label_17);
		
		label_81 = new JLabel("");
	//	label_81.setForeground(Color.WHITE);
		label_81.setHorizontalAlignment(SwingConstants.CENTER);
		label_81.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_81.setBounds(28, 417, 137, 50);
		panel.add(label_81);
		
	 label_82 = new JLabel("");
	// label_82.setForeground(Color.WHITE);
		label_82.setHorizontalAlignment(SwingConstants.CENTER);
		label_82.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_82.setBounds(181, 417, 154, 50);
		panel.add(label_82);
		
		label_83 = new JLabel("");
	//	label_83.setForeground(Color.WHITE);
		label_83.setHorizontalAlignment(SwingConstants.CENTER);
		label_83.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_83.setBounds(352, 417, 154, 50);
		panel.add(label_83);
		
		label_84 = new JLabel("");
	//	label_84.setForeground(Color.WHITE);
		label_84.setHorizontalAlignment(SwingConstants.CENTER);
		label_84.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_84.setBounds(517, 417, 154, 50);
		panel.add(label_84);
		
		JLabel label_202 = new JLabel("7.");
		label_202.setFont(new Font("Snap ITC", Font.PLAIN, 21));
		label_202.setBounds(4, 378, 34, 50);
		panel.add(label_202);
		
		label_71 = new JLabel("");
	//	label_71.setForeground(Color.WHITE);
		label_71.setHorizontalAlignment(SwingConstants.CENTER);
		label_71.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_71.setBounds(28, 378, 137, 50);
		panel.add(label_71);
		
		label_72 = new JLabel("");
	//	label_72.setForeground(Color.WHITE);
		label_72.setHorizontalAlignment(SwingConstants.CENTER);
		label_72.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_72.setBounds(181, 378, 154, 50);
		panel.add(label_72);
		
		 label_73 = new JLabel("");
	//	 label_73.setForeground(Color.WHITE);
		label_73.setHorizontalAlignment(SwingConstants.CENTER);
		label_73.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_73.setBounds(352, 378, 154, 50);
		panel.add(label_73);
		
	   label_74 = new JLabel("");
	//   label_74.setForeground(Color.WHITE);
		label_74.setHorizontalAlignment(SwingConstants.CENTER);
		label_74.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_74.setBounds(517, 378, 154, 50);
		panel.add(label_74);
		
		label_64 = new JLabel("");
	//	label_64.setForeground(Color.WHITE);
		label_64.setHorizontalAlignment(SwingConstants.CENTER);
		label_64.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_64.setBounds(517, 337, 154, 50);
		panel.add(label_64);
		
		label_63 = new JLabel("");
	//	label_63.setForeground(Color.WHITE);
		label_63.setHorizontalAlignment(SwingConstants.CENTER);
		label_63.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_63.setBounds(352, 337, 154, 50);
		panel.add(label_63);
		
		label_62 = new JLabel("");
	//	label_62.setForeground(Color.WHITE);
		label_62.setHorizontalAlignment(SwingConstants.CENTER);
		label_62.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_62.setBounds(181, 337, 154, 50);
		panel.add(label_62);
		
	label_61 = new JLabel("");
//	label_61.setForeground(Color.WHITE);
		label_61.setHorizontalAlignment(SwingConstants.CENTER);
		label_61.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_61.setBounds(28, 337, 137, 50);
		panel.add(label_61);
		
		 label_51 = new JLabel("");
		label_51.setHorizontalAlignment(SwingConstants.CENTER);
	//	label_51.setForeground(Color.WHITE);
		label_51.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_51.setBounds(31, 296, 124, 50);
		panel.add(label_51);
		
		 label_52 = new JLabel("");
		label_52.setHorizontalAlignment(SwingConstants.CENTER);
		//label_52.setForeground(Color.WHITE);
		label_52.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_52.setBounds(184, 296, 154, 50);
		panel.add(label_52);
		
		 label_53 = new JLabel("");
		label_53.setHorizontalAlignment(SwingConstants.CENTER);
	//	label_53.setForeground(Color.WHITE);
		label_53.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_53.setBounds(355, 296, 154, 50);
		panel.add(label_53);
		
		 label_54 = new JLabel("");
		label_54.setHorizontalAlignment(SwingConstants.CENTER);
	//	label_54.setForeground(Color.WHITE);
		label_54.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_54.setBounds(520, 296, 154, 50);
		panel.add(label_54);
		
		 label_35 = new JLabel("5.");
		label_35.setFont(new Font("Snap ITC", Font.PLAIN, 21));
		label_35.setBounds(9, 296, 33, 50);
		panel.add(label_35);
		
		 label_36 = new JLabel("6.");
		label_36.setFont(new Font("Snap ITC", Font.PLAIN, 21));
		label_36.setBounds(7, 337, 35, 50);
		panel.add(label_36);
		
		 label_37 = new JLabel("9.");
		label_37.setFont(new Font("Snap ITC", Font.PLAIN, 21));
		label_37.setBounds(7, 454, 32, 50);
		panel.add(label_37);
		
		 label_91 = new JLabel("");
		// label_91.setForeground(Color.WHITE);
		label_91.setHorizontalAlignment(SwingConstants.CENTER);
		label_91.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_91.setBounds(31, 454, 134, 50);
		panel.add(label_91);
		
		 label_92 = new JLabel("");
	//	 label_92.setForeground(Color.WHITE);
		label_92.setHorizontalAlignment(SwingConstants.CENTER);
		label_92.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_92.setBounds(184, 454, 154, 50);
		panel.add(label_92);
		
		 label_93 = new JLabel("");
		// label_93.setForeground(Color.WHITE);
		label_93.setHorizontalAlignment(SwingConstants.CENTER);
		label_93.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_93.setBounds(355, 454, 154, 50);
		panel.add(label_93);
		
		 label_94 = new JLabel("");
	//	 label_94.setForeground(Color.WHITE);
		label_94.setHorizontalAlignment(SwingConstants.CENTER);
		label_94.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_94.setBounds(520, 454, 154, 50);
		panel.add(label_94);
		
		JLabel label_402 = new JLabel("10.");
		label_402.setFont(new Font("Snap ITC", Font.PLAIN, 21));
		label_402.setBounds(7, 493, 50, 50);
		panel.add(label_402);
		 
		  label_101 = new JLabel("");
		//  label_101.setForeground(Color.WHITE);
		  label_101.setBounds(31, 493, 122, 50);
		  panel.add(label_101);
		  label_101.setHorizontalAlignment(SwingConstants.CENTER);
		  label_101.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		
		 label_102 = new JLabel("");
	//	 label_102.setForeground(Color.WHITE);
		label_102.setHorizontalAlignment(SwingConstants.CENTER);
		label_102.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_102.setBounds(184, 493, 154, 50);
		panel.add(label_102);
		
		 label_103 = new JLabel("");
	//	 label_103.setForeground(Color.WHITE);
		label_103.setHorizontalAlignment(SwingConstants.CENTER);
		label_103.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_103.setBounds(355, 493, 154, 50);
		panel.add(label_103);
		
		label_104 = new JLabel("");
		//label_104.setForeground(Color.WHITE);
		label_104.setHorizontalAlignment(SwingConstants.CENTER);
		label_104.setFont(new Font("Tekton Pro Ext", Font.BOLD, 25));
		label_104.setBounds(520, 493, 154, 50);
		panel.add(label_104);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("trophy7.png"));
		
		lblNewLabel.setBounds(197, 131, 409, 398);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0,0,0,80));
		panel_1.setBounds(6, 501, 681, 33);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 255, 255,130));
		panel_2.setBounds(6, 464, 681, 33);
		panel.add(panel_2);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0, 0, 0, 80));
		panel_3.setBounds(6, 426, 681, 33);
		panel.add(panel_3);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(0, 0, 255, 80));
		panel_4.setBounds(5, 387, 682, 33);
		panel.add(panel_4);
		
		panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(0, 0, 0, 80));
		panel_5.setBounds(5, 346, 682, 33);
		panel.add(panel_5);
		
		panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(0, 0, 0, 80));
		panel_6.setBounds(7, 305, 680, 35);
		panel.add(panel_6);
		
		panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(255, 105, 180));
		panel_7.setBounds(7, 262, 680, 35);
		panel.add(panel_7);
		
		panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(255, 0, 0, 80));
		panel_8.setBounds(7, 220, 680, 35);
		panel.add(panel_8);
		
		panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(0, 0, 0, 80));
		panel_9.setBounds(6, 178, 681, 35);
		panel.add(panel_9);
		
		panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(255, 0, 0, 80));
		panel_10.setBounds(6, 133, 681, 38);
		panel.add(panel_10);
		/*panel_1.setVisible(false);
		panel_2.setVisible(false);
		panel_3.setVisible(false);
		panel_4.setVisible(false);
		panel_5.setVisible(false);
		panel_6.setVisible(false);
		panel_7.setVisible(false);
		panel_8.setVisible(false);
		panel_9.setVisible(false);*/
		
		JLabel label_47 = new JLabel("");
		label_47.setIcon(new ImageIcon("highbg.jpg"));
		label_47.setBackground(new Color(240, 230, 140));
		label_47.setBounds(0, 0, 697, 563);
		panel.add(label_47);
		setlabel();
		t=new Thread(this,"mythread");
		t.start();
	}
	static String takeoutdata()
	{
		String data="";
		try
		{
		FileInputStream fin=new FileInputStream("hscore.txt");
		int content;
		while((content=fin.read())!=-1)
		{
			data+=(char)content;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return data;
	}
	void setlabel()
	{
		String temp=takeoutdata();
		String scoreinfo[]=temp.split("\n");
			for(int i=0;i<scoreinfo.length;i++)
			{
				String info[]=scoreinfo[i].split(" ");
				
					if(i==0)
					{
						label_11.setText(info[0]);
						label_12.setText(info[1]);
						label_13.setText(info[2]);
						label_14.setText(info[3]);
						
					}
					else if(i==1)
					{
						label_21.setText(info[0]);
						label_22.setText(info[1]);
						label_23.setText(info[2]);
						label_24.setText(info[3]);
					}
					else if(i==2)
					{
						label_31.setText(info[0]);
						label_32.setText(info[1]);
						label_33.setText(info[2]);
						label_34.setText(info[3]);
					}
					else if(i==3)
					{
						label_41.setText(info[0]);
						label_42.setText(info[1]);
						label_43.setText(info[2]);
						label_44.setText(info[3]);
					}
					else if(i==4)
					{
						label_51.setText(info[0]);
						label_52.setText(info[1]);
						label_53.setText(info[2]);
						label_54.setText(info[3]);
					}
					else if(i==5)
					{
						label_61.setText(info[0]);
						label_62.setText(info[1]);
						label_63.setText(info[2]);
						label_64.setText(info[3]);
					}
					else if(i==6)
					{
						label_71.setText(info[0]);
						label_72.setText(info[1]);
						label_73.setText(info[2]);
						label_74.setText(info[3]);
					}
					else if(i==7)
					{
						label_81.setText(info[0]);
						label_82.setText(info[1]);
						label_83.setText(info[2]);
						label_84.setText(info[3]);
					}
					else if(i==8)
					{
						label_91.setText(info[0]);
						label_92.setText(info[1]);
						label_93.setText(info[2]);
						label_94.setText(info[3]);
					}
					else if(i==9)
					{
						label_101.setText(info[0]);
						label_102.setText(info[1]);
						label_103.setText(info[2]);
						label_104.setText(info[3]);
					}
					else
					{
						System.out.println("error occured highscore.java:544");
					}
					
					
				
			}
		
	}
	static void gethighscore()
	{
		String temp=takeoutdata();
		String scoreinfo[]=temp.split("\n");
		
		for(int i=0;i<scoreinfo.length;i++)
		{
			String info[]=scoreinfo[i].split(" ");
			//System.out.println(":::::"+info[3]+":::::");
			highscore.add(Integer.parseInt(info[1]));
		}
		
	/*	if(!label_14.getText().equals(""))
		{
			highscore.add(Integer.parseInt(label_14.getText()));
		}
		if(!label_24.getText().equals(""))
		{
			highscore.add(Integer.parseInt(label_24.getText()));
		}
		if(!label_34.getText().equals(""))
		{
			highscore.add(Integer.parseInt(label_34.getText()));
		}
		if(!label_44.getText().equals(""))
		{
			highscore.add(Integer.parseInt(label_44.getText()));
		}
		if(!label_54.getText().equals(""))
		{
			highscore.add(Integer.parseInt(label_54.getText()));
		}
		if(!label_64.getText().equals(""))
		{
			highscore.add(Integer.parseInt(label_64.getText()));
		}
		if(!label_74.getText().equals(""))
		{
			highscore.add(Integer.parseInt(label_74.getText()));
		}
		if(!label_84.getText().equals(""))
		{
			highscore.add(Integer.parseInt(label_84.getText()));
		}
		if(!label_94.getText().equals(""))
		{
			highscore.add(Integer.parseInt(label_94.getText()));
		}
		if(!label_104.getText().equals(""))
		{
			highscore.add(Integer.parseInt(label_104.getText()));
		}
		for(int i=0;i<highscore.size();i++)
		{
			System.out.println(highscore.get(i));
		}*/
	}

	@Override
	public void run() 
	{
		int c=0;
		while(true)
		{
	/*int r=(int )(255*Math.random());
	int g=(int )(255*Math.random());
	int b=(int )(255*Math.random());
	
	*/
	System.out.println("running thread "+c);
			if(c%2==0)
			{
				label.setForeground(Color.black);
				label_11.setForeground(Color.black);
				label_12.setForeground(Color.black);
				label_13.setForeground(Color.black);
				label_14.setForeground(Color.black);
//	lblHighScore.setForeground(Color.BLACK);
			}
			else
			{
				label.setForeground(Color.YELLOW);
				label_11.setForeground(Color.YELLOW);
				label_12.setForeground(Color.YELLOW);
				label_13.setForeground(Color.YELLOW);
				label_14.setForeground(Color.YELLOW);
				lblHighScore.setForeground(Color.RED);
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
