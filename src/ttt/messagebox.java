package ttt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.border.LineBorder;
import javax.swing.Icon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;


public class messagebox extends JDialog implements Runnable
{

	 JPanel contentPanel;
	Timer t;
	Thread thread;
	JLabel label1,label2;
	blinking b;
	terminate tm;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			messagebox dialog = new messagebox("Game no: 1","commencing !!");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	
	public messagebox(String s1,String s2,String toss) 
	{
		
		thread=new Thread(this,"borderthread");
		thread.start();
		//setBounds(100, 100, 446, 275);
		setUndecorated(true);
		setModal(true);
		int w=446;
		int h=275;
		  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		  int W=screen.width;
		  int H=screen.height;
		  int x=(W-w)/2;
		  int y=(H-h)/2;
	      setBounds(x, y, w, h);
	      contentPanel = new JPanel();		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		//contentPanel.setBackground(new Color(0,0,0,125));
		
		contentPanel.setBorder(new LineBorder(new Color(255, 0, 0), 6));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JButton button = new JButton(new ImageIcon("close_button.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		button.setBounds(424, 0, 22, 22);
		contentPanel.add(button);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,0,0));
		panel.setBounds(46, 27, 358, 222);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		label1 = new JLabel(s1);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Tekton Pro", Font.PLAIN, 50));
		label1.setForeground(Color.WHITE);
		label1.setBounds(10, 27, 338, 70);
		panel.add(label1);
		
		label2 = new JLabel(s2);
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font("Tekton Pro", Font.PLAIN, 50));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(10, 107, 338, 70);
		panel.add(label2);
		
		JLabel lblUseraWonThe = new JLabel(toss);
		lblUseraWonThe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUseraWonThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblUseraWonThe.setForeground(Color.WHITE);
		lblUseraWonThe.setBounds(20, 188, 313, 23);
		panel.add(lblUseraWonThe);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("orange-and-yellow-abstract-paper-background-nattapon-wongwean.jpg"));
		label.setBounds(6, 6, 434, 263);
		contentPanel.add(label);
		new sound().buzzer();
		b=new blinking(this);
		tm=new terminate(this);
		
	}

	
	
	@Override
	public void run() 
	{
		
				int sec=1,n=2;
				while(sec<=n)
				{
					//System.out.println(sec);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					sec++;
			
				}
				//System.out.println("dispposing the messagebox!!");
				dispose();
				tm.t.stop();
				b.th.stop();
				
			}

		
		
	
}

 class terminate implements Runnable
 {
	 Thread t;
	 messagebox ob;
	 public terminate(messagebox m)
	 {
		 ob=m;
		 t=new Thread(this,"terminate thread");
		 t.start();
	 }
	 public void run()
	 {
	 while(true)
		{
			int r=(int )(255*Math.random());
			int b=(int )(255*Math.random());
			int g=(int )(255*Math.random());
			ob.contentPanel.setBorder(new LineBorder(new Color(r,g,b),6));
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 }
	
 }

	class blinking implements Runnable
	{
		Thread th;
		messagebox ob;
		int c=0;
		public blinking(messagebox mg) 
		{
			ob=mg;
			th=new Thread(this,"blinkingthread");
			th.start();
		}
		@Override
		public void run() 
		{
			while(true)
			{
				if(c%2==0)
				{
					ob.label1.setForeground(Color.red);
					ob.label2.setForeground(Color.red);
					//System.out.println("going to red colour");
				}
				else
				{
					ob.label1.setForeground(Color.white);
					ob.label2.setForeground(Color.white);
					//System.out.println("going to white coloru");
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
