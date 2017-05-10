package ttt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.sound.sampled.FloatControl;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.Icon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

public class botwin extends JDialog implements Runnable,ActionListener {

	private JPanel contentPane;
	Thread t;
	JLabel lblBotWins;
	private JButton button;
	JPanel panel;
	Timer timer;
	int seconds=7;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					botwin frame = new botwin();
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
	public botwin(tictacto ob) {
		FloatControl gainControl = (FloatControl) sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(tictacto.soundvolume-20.0f);
        setModal(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 425, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		int w=425;
		int h=260;
		/*  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		  int W=screen.width;
		  int H=screen.height;
		  int x=(W-w)/2;
		  int y=(H-h)/2;*/
		  setBounds(ob.frame.getX()+320,ob.frame.getY()+200,w,h);
		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK, 4));
		panel.setBounds(0, 0, 425, 260);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		 lblBotWins = new JLabel("!!! Bot wins !!!");
		lblBotWins.setForeground(Color.GREEN);
		lblBotWins.setFont(new Font("Tekton Pro", Font.BOLD, 48));
		lblBotWins.setBounds(69, 179, 294, 71);
		panel.add(lblBotWins);
		
		button = new JButton(new ImageIcon("close_button.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				sound.clip8.stop();
				FloatControl gainControl = (FloatControl) sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
		        gainControl.setValue(tictacto.soundvolume);
			}
		});
		button.setBounds(402, 0, 22, 22);
		panel.add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("24563892-happy-businessman-with-a-personal-computer-monitor-head-and-a-smiley-face.jpg"));
		label.setBounds(5, 5, 414, 250);
		panel.add(label);
		t=new Thread(this,"botthread");
		t.start();
		new sound().botwin();
		timer=new Timer(1000,this);
		timer.start();
		String updatetemp=tictacto.gameno+"  "+tictacto.ua+"  "+tictacto.ub+"  "+tictacto.chance+"  "+tictacto.comboBox.getSelectedItem().toString()+"  "+"bot"+" wins";
		new updatelog().updatelogs(updatetemp);
	}

	@Override
	public void run() 
	{
		String s="!!! Bot wins !!!";
		String temp="";
		for(int i=0;i<s.length();i++)
		{
			temp+=s.charAt(i);
			lblBotWins.setText(temp);
			int r=(int )(255* Math.random());
			int g=(int )(255* Math.random());
			int b=(int )(255* Math.random());
			Color c=new Color(5,r,g,b);
			panel.setBorder(new LineBorder(c, 4));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==s.length()-1)
			{
				//System.out.println("reaching the point");
				temp="";
				i=0;
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		seconds--;
		if(seconds==0)
		{
			this.dispose();
			sound.clip8.stop();
			t.stop();
			FloatControl gainControl = (FloatControl) sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
	        gainControl.setValue(tictacto.soundvolume);
		}
		
	}
	
	
}

