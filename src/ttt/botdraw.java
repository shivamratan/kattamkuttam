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
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.Icon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

import jdk.nashorn.internal.ir.LiteralNode;

public class botdraw extends JDialog implements Runnable,ActionListener {

	 JPanel contentPane;
	JLabel lblGameIs;
	Thread t;
	private JButton button;
	private JLabel label_1;
	Timer m;
	int seconds=4;
	JPanel panel;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					botdraw frame = new botdraw();
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
	public botdraw(tictacto ob) {
		FloatControl gainControl = (FloatControl) sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(tictacto.soundvolume-20.0f);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 451, 222);
		setModal(true);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		m=new Timer(1000,this);
		int w=451;
		int h=222;
		 /* Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		  int W=screen.width;
		  int H=screen.height;
		  int x=(W-w)/2;
		  int y=(H-h)/2;*/
		//  setBounds(x+200, y-50, w, h);
		  setBounds(ob.frame.getX()+320,ob.frame.getY()+200,w,h);
		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.RED, 5));
		panel.setBounds(0, 0, 451, 222);
		contentPane.add(panel);
		panel.setLayout(null);
		lblGameIs = new JLabel("!!!!! Game is draw !!!!!");
		lblGameIs.setBounds(15, 128, 427, 61);
		panel.add(lblGameIs);
		lblGameIs.setForeground(Color.RED);
		lblGameIs.setFont(new Font("Ravie", Font.PLAIN, 30));
		lblGameIs.setHorizontalAlignment(SwingConstants.CENTER);
		
		button = new JButton(new ImageIcon("close_button.png"));
		button.setBounds(418, 14, 22, 22);
		panel.add(button);
		
		label_1 = new JLabel("");
		label_1.setBounds(100, 11, 268, 122);
		panel.add(label_1);
		label_1.setIcon(new ImageIcon("Angry_man_2.gif"));
		
		JLabel label = new JLabel("");
		label.setBounds(6, 6, 439, 210);
		panel.add(label);
		label.setIcon(new ImageIcon("gradient.jpg"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sound.clip11.stop();
				setVisible(false);
				FloatControl gainControl = (FloatControl) sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
		        gainControl.setValue(tictacto.soundvolume);
			}
		});
		t=new Thread(this,"drawthread");
		t.start();
		new sound().botdraw();
		m.start();
		String updatetemp;
		if(tictacto.bot)
		updatetemp=tictacto.gameno+"  "+tictacto.ua+"  "+tictacto.ub+"  "+tictacto.chance+"  "+tictacto.comboBox.getSelectedItem().toString()+"  "+"draw";
		else 
		updatetemp=tictacto.gameno+"  "+tictacto.ua+"  "+tictacto.ub+"  "+tictacto.chance+"  "+"-"+"  "+"draw";	
		new updatelog().updatelogs(updatetemp);
	}
	public void run()
	{
		String s="!!!!! Game is draw !!!!!";
		String temp="";
	 for(int i=0;i<=s.length();i++)
	 {
		 temp+=s.charAt(i);
		 lblGameIs.setText(temp);

			int r=(int )(255 * Math.random());
			int b=(int )(255 * Math.random());
			int g=(int )(255* Math.random());
			Color c=new Color(r,g,b);
			panel.setBorder(new LineBorder(c,5));
		 try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(i==s.length()-1)
		 {
			
			new colorthread(this); 
			 t.stop();
		 }
	 }
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(seconds==0)
		{
			System.out.println(""+seconds);
			this.dispose();
			sound.clip11.stop();
			m.stop();
			FloatControl gainControl = (FloatControl) sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
	        gainControl.setValue(tictacto.soundvolume);
			
		}
		seconds--;
	}
}
class colorthread implements Runnable
{
	Thread t1;
	botdraw ob;
	public colorthread(botdraw b) 
	{
	t1=new Thread(this,"colorthread");
	t1.start();
	ob=b;
	}

	@Override
	public void run() 
	{
		while(true)
		{
			int r=(int )(255 * Math.random());
			int b=(int )(255 * Math.random());
			int g=(int )(255* Math.random());
			Color c=new Color(r,g,b);

			int r1=(int )(255 * Math.random());
			int b1=(int )(255 * Math.random());
			int g1=(int )(255* Math.random());
			Color c1=new Color(r1,g1,b1);
			
			ob.panel.setBorder(new LineBorder(c1,5));
			ob.lblGameIs.setForeground(c);
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
