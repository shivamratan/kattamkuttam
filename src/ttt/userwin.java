package ttt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.sound.sampled.FloatControl;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class userwin extends JDialog implements Runnable,ActionListener {

	private JPanel contentPane;
	Thread t;
	JPanel panel_1;
	JPanel panel;
	Timer timer;
	int seconds=7;
	borderthread c;
	JLabel lblCongratulation;
	JLabel label_1;
	JLabel lblIs;
	JLabel lblWinner;
	Thread current;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				String s="you";
				try {
					userwin frame = new userwin(s);
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
	public userwin(String s,tictacto ob) {
		current=Thread.currentThread();
		setFocusable(true);
		setModal(true);
		
		FloatControl gainControl = (FloatControl) sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(tictacto.soundvolume-20.0f);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		int w=428;
		int h=252;
		 /* Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		  int W=screen.width;
		  int H=screen.height;
		  int x=(W-w)/2;
		  int y=(H-h)/2;*/
	     // setBounds(x+200, y-50, w, h);
	      setBounds(ob.frame.getX()+320,ob.frame.getY()+200,w,h);
	      
		timer=new Timer(1000,this);
		timer.start();
		 contentPane.setLayout(null);
		 panel = new JPanel();
		 panel.setBounds(0, 0, 427, 252);
		panel.setBorder(new LineBorder(Color.RED, 5));
		contentPane.add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(6, 6, 416, 241);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblCongratulation = new JLabel("Congrats!!!");
		lblCongratulation.setBounds(61, 12, 333, 68);
		panel_1.add(lblCongratulation);
		lblCongratulation.setForeground(Color.black);
		lblCongratulation.setFont(new Font("Showcard Gothic", Font.BOLD, 42));
		
		JButton button = new JButton(new ImageIcon("close_button.png"));
		button.setBounds(396, -2, 22, 22);
		panel_1.add(button);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				t.stop();
				c.t.stop();
				sound.clip3.stop();
				FloatControl gainControl = (FloatControl) sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
		        gainControl.setValue(tictacto.soundvolume);
			}
		});
		
		label_1 = new JLabel(s);
		label_1.setBounds(4, 76, 317, 68);
		panel_1.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Vivaldi", Font.BOLD, 71));
		
		lblIs = new JLabel("is");
		lblIs.setBounds(336, 79, 72, 68);
		panel_1.add(lblIs);
		lblIs.setFont(new Font("Vivaldi", Font.BOLD, 71));
		
		lblWinner = new JLabel("Winner");
		lblWinner.setBounds(79, 153, 294, 62);
		panel_1.add(lblWinner);
		lblWinner.setFont(new Font("Vivaldi", Font.BOLD, 71));
		lblWinner.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("sb1.jpg"));
		label.setBounds(0, 0, 418, 241);
		panel_1.add(label);
		//setVisible(true);
		new sound().userawin();
		t=new Thread(this,"panelthread");
		t.start();
		c=new borderthread(this);
		String updatetemp;
		if(tictacto.bot)
		 updatetemp=tictacto.gameno+"  "+tictacto.ua+"  "+tictacto.ub+"  "+tictacto.chance+"  "+tictacto.comboBox.getSelectedItem().toString()+"  "+s+" wins";
		else
		 updatetemp=tictacto.gameno+"  "+tictacto.ua+"  "+tictacto.ub+"  "+tictacto.chance+"  "+"-"+"  "+s+" wins";   
		new updatelog().updatelogs(updatetemp);
		
	}

	@Override
	public void run() 
	{
		int c=0;
		while(true)
		{
			if(c%2==0)
			{
				//lblCongratulation.setForeground(Color.RED);
				label_1.setForeground(Color.RED);
				lblWinner.setForeground(Color.RED);
				lblIs.setForeground(Color.RED);
			}
			else
			{
				//lblCongratulation.setForeground(Color.BLACK);
				label_1.setForeground(Color.BLACK);
				lblWinner.setForeground(Color.black);
				lblIs.setForeground(Color.black);
			}
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c++;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(seconds==0)
		{
			dispose();
			t.stop();
			c.t.stop();
			sound.clip3.stop();
			FloatControl gainControl = (FloatControl) sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
	        gainControl.setValue(tictacto.soundvolume);
		}
		seconds--;
		
	}
}
 class borderthread implements Runnable
 {
	 Thread t;
	 userwin ob;
	 public borderthread(userwin u) 
	 {
		 ob=u;
		t=new Thread(this,"borderthread1");
		t.start();
	 }

	@Override
	public void run() 
	{
		while(true)
		{
		int r=(int )(255*Math.random());
		int g=(int )(255*Math.random());
		int b=(int )(255*Math.random());
		ob.panel.setBorder(new LineBorder(new Color(r,g,b), 5));
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
 }
