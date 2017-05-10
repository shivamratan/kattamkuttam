package ttt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.sound.sampled.FloatControl;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class finalwin extends JDialog implements Runnable {

	private JPanel contentPane;
	JLabel lblSeries;
	Thread t;
	JLabel lblIs;
	JLabel lblUsera;
	JPanel panel;
	borderthread12 b;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				String s="to you";
				try {
					finalwin frame = new finalwin(s);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	
	public finalwin(String s,tictacto instance) {
		
		FloatControl gainControl = (FloatControl) sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(tictacto.soundvolume-20.0f);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 637, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		setModal(true);
		contentPane.setLayout(null);
		setResizable(false);
		int w=637;
		int h=410;
		  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		  int W=screen.width;
		  int H=screen.height;
		  int x=(W-w)/2;
		  int y=(H-h)/2;
		  setBounds(x+200, y-50, 637, 379);
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 0, 0), 7));
		panel.setBounds(0, 0, 637, 378);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton(new ImageIcon("close_button.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				//stopping all threads
				sound.clip13.stop();
				t.stop();
				b.t1.stop();
				FloatControl gainControl = (FloatControl) sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
		        gainControl.setValue(tictacto.soundvolume);
				new wannaplay(instance).setVisible(true);
			}
		});
		button.setBounds(614, 0, 22, 22);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(239, 8, 381, 88);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblUsera = new JLabel("Congrats!!!");
		lblUsera.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 68));
		lblUsera.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsera.setBounds(23, -17, 348, 101);
		panel_1.add(lblUsera);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("orange-and-yellow-abstract-paper-background-nattapon-wongwean.jpg"));
		label.setBounds(0, 0, 381, 88);
		panel_1.add(label);
		
		lblIs = new JLabel(s);
		lblIs.setForeground(Color.BLACK);
		lblIs.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
		lblIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblIs.setBounds(239, 115, 372, 76);
		panel.add(lblIs);
		
	 lblSeries = new JLabel("series");
		lblSeries.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
		lblSeries.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeries.setBounds(256, 204, 318, 68);
		panel.add(lblSeries);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("userwin.jpg"));
		lblNewLabel.setBounds(8, 8, 622, 361);
		panel.add(lblNewLabel);
		new sound().finalwinning();
		t=new Thread(this,"finalwinthread");
		t.start();
		b=new borderthread12(this);
		String temp=timecalci.apptime;
		timecalci.time.stop();
		
		String str="*************************** \tFinal Winner is "+s+"******************";
		str+="\nApplication work time:"+temp;
		 str+="\n----------------------------------------------------------------------------------------------";
		 new updatelog().updatelogs(str);
		 
		if(s.equals(instance.ua))
		{
			instance.checkhighscoreua();
		}
		else if(s.equals(instance.ub))
		{
			instance.checkhighscoreub();
		}
	}

	@Override
	public void run() 
	{
		int k=0;
		while(true)
		{
		/*	int r=(int )(255*Math.random());
			int g=(int )(255*Math.random());
			int b=(int )(255*Math.random());
				Color c=new Color(r,g,b);*/
				 
				 if(k%2==0)
				 {
					 lblUsera.setForeground(Color.RED);
					 lblSeries.setForeground(Color.RED);
					 lblIs.setForeground(Color.RED);
				 }
				 else 
				 {
					 lblUsera.setForeground(Color.BLACK);
					 lblSeries.setForeground(Color.BLACK);
					 lblIs.setForeground(Color.BLACK);
				 }
				 try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 k++;
		}
		
	}
}

class borderthread12 implements Runnable
{
	Thread t1;
	finalwin ob;
	public borderthread12(finalwin f) 
	{
		ob=f;
		t1=new Thread(this,"borderthread");
		t1.start();
	}
	@Override
	public void run() 
	{
		while(true)
		{
			int r=(int )(255*Math.random());
			int g=(int )(255*Math.random());
			int b=(int )(255*Math.random());
				Color c=new Color(r,g,b);
				ob.panel.setBorder(new LineBorder(c, 7));
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
}