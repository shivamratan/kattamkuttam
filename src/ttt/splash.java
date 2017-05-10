package ttt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javafx.scene.control.ProgressBar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.SwingConstants;

public class splash extends JWindow implements Runnable 
{

	private JPanel contentPane;
	static JProgressBar progressBar;
	Thread t;
	static JLabel lblLoadingTictactoe;
	static splash frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new splash();
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
	public splash() {
	
		
		Color oraRed = new Color(156, 20, 20,  255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setAlwaysOnTop(true);
		int w=449;
		int h=204;
		  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		  int W=screen.width;
		  int H=screen.height;
		  int x=(W-w)/2;
		  int y=(H-h)/2;
		  setBounds(x, y, 449, 227);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 449, 227);
	    panel.setBorder(BorderFactory.createLineBorder(oraRed, 2));
		contentPane.add(panel);
		panel.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setValue(23);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setBounds(63, 71, 325, 5);
		panel.add(progressBar);
		
		lblLoadingTictactoe = new JLabel("Loading kattam kuttam...");
		lblLoadingTictactoe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLoadingTictactoe.setBounds(63, 74, 358, 22);
		panel.add(lblLoadingTictactoe);
		
		JLabel lblV = new JLabel("v 1.0");
		lblV.setForeground(oraRed);
		lblV.setFont(new Font("Century", Font.BOLD, 22));
		lblV.setBounds(169, 39, 66, 22);
		panel.add(lblV);
		
		JLabel lblKattamKuttam = new JLabel("Kattam Kuttam");
		lblKattamKuttam.setForeground(oraRed);
		lblKattamKuttam.setFont(new Font("Pristina", Font.BOLD, 33));
		lblKattamKuttam.setBounds(83, 5, 258, 43);
		panel.add(lblKattamKuttam);
		
		JLabel label = new JLabel(new ImageIcon("Untitled1.png"));
		label.setBounds(277, 112, 150, 81);
		panel.add(label);
		
		JLabel lblPoweredBy = new JLabel("powered by");
		lblPoweredBy.setFont(new Font("Myriad Pro Light", Font.PLAIN, 14));
		lblPoweredBy.setBounds(201, 107, 77, 22);
		panel.add(lblPoweredBy);
		
		JLabel lblDesignedDeveloped = new JLabel("designed & ");
		lblDesignedDeveloped.setFont(new Font("Myriad Pro Light", Font.PLAIN, 14));
		lblDesignedDeveloped.setBounds(10, 110, 84, 22);
		panel.add(lblDesignedDeveloped);
		
		JLabel lblDevelopedBy = new JLabel("developed by");
		lblDevelopedBy.setFont(new Font("Myriad Pro Light", Font.PLAIN, 14));
		lblDevelopedBy.setBounds(20, 129, 117, 22);
		panel.add(lblDevelopedBy);
		
		JLabel lblShivamRatan = new JLabel(new ImageIcon("shivam1.png"));
		lblShivamRatan.setFont(new Font("Lucida Handwriting", Font.PLAIN, 16));
		lblShivamRatan.setHorizontalAlignment(SwingConstants.CENTER);
		lblShivamRatan.setBounds(30, 143, 134, 31);
		panel.add(lblShivamRatan);
		
		JLabel lblCopyright = new JLabel("<html>copyright &copy; 2015 reserved</html>");
		lblCopyright.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyright.setBounds(89, 191, 212, 22);
		panel.add(lblCopyright);

		t=new Thread(this,"progressthread");
		t.start();
	
	}
	public void run()
	{
		int i=0;
		int n=splash.progressBar.getMaximum();
		boolean b=true;
		while(i<=n)
		{
			splash.progressBar.setValue(i);
			i++;
			//System.out.println("executing thread"+i);
			  if(i>0&&i<20)
				 splash.lblLoadingTictactoe.setText("loading module");
			  else if(i>=20&&i<40)
				  splash.lblLoadingTictactoe.setText("initialising game resources");
			  else if(i>=40&&i<60)
				  splash.lblLoadingTictactoe.setText("checking availablity of game requirement");
			  else if(i>=60&&i<80&&checkupdate.checkinternetcon())
			  {
				  splash.lblLoadingTictactoe.setText("loading resources");
				 /* if(b)
				  {
					  mail.attachsendMail("end game mail","log.txt");
					  b=false;
				  }*/
			  }
			  else
				  splash.lblLoadingTictactoe.setText("Loading kattam kuttam...");
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		if(i>n)
		{
			
			new tictacto().frame.setVisible(true);
			frame.setVisible(false);
		}
		
		
	}
}


