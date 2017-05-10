package ttt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.sound.sampled.FloatControl;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.Icon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

import java.awt.Color;

public class tie extends JDialog implements Runnable {

	private JPanel contentPane;
	JLabel lbltieGame;
	Thread blink;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tie frame = new tie();
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
	public tie() 
	{
		
		setModal(true);
	FloatControl gainControl = (FloatControl) sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(tictacto.soundvolume-20.0f);
		setUndecorated(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int w=399;
		int h=178;
		  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		  int W=screen.width;
		  int H=screen.height;
		  int x=(W-w)/2;
		  int y=(H-h)/2;
		  setBounds(x, y, 412, 346);
		//setBounds(100, 100, 399, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 255), 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton(new ImageIcon("close_button.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				blink.stop();
				sound.clip5.stop();
				setVisible(false);
				//FloatControl gainControl = (FloatControl) sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
		        //gainControl.setValue(tictacto.soundvolume);
			}
		});
		button.setBounds(388, 1, 24, 26);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 410, 6);
		contentPane.add(panel);
		
		lbltieGame = new JLabel("!!! Tie Game !!!");
		lbltieGame.setHorizontalAlignment(SwingConstants.CENTER);
		lbltieGame.setFont(new Font("Showcard Gothic", Font.PLAIN, 37));
		lbltieGame.setBounds(62, 273, 288, 41);
		contentPane.add(lbltieGame);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("tiegame.png"));
		label.setBounds(20, 6, 369, 329);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("appearing-picture1.gif"));
		label_1.setBounds(6, -130, 406, 356);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("appearing-picture1.gif"));
		lblNewLabel.setBounds(6, 75, 400, 265);
		contentPane.add(lblNewLabel);
		new sound().draw();
		blink=new Thread(this,"blinkthread");
		blink.start();
	//	new borderblink(this);
		String str="*************************** The match is tie ******************";
		 str+="\n----------------------------------------------------------------------------------------------";
		 new updatelog().updatelogs(str);
	}

	@Override
	public void run() 
	{
		int c=0;
		while(true)
		{
			if(c%2==0)
			{
				lbltieGame.setForeground(Color.BLACK);
			}
			else
			{
				lbltieGame.setForeground(Color.RED);
			}
			c++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

class borderblink implements Runnable
{
	Thread bdrblink;
	tie ob;
	public borderblink(tie t) {
		ob=t;
		bdrblink=new Thread(this,"borderblink");
		bdrblink.start();
	}

	@Override
	public void run() 
	{
		while(true)
		{
		int r=(int )(255*Math.random());
		int b=(int )(255*Math.random());
		int g=(int )(255*Math.random());
			
		}
		
		
	}
	
}
