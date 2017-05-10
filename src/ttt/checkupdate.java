package ttt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.swing.SwingConstants;

public class checkupdate extends JFrame implements Runnable {

	private JPanel contentPane;
	JProgressBar progressBar;
	JLabel label;
	private JLabel status;
	Thread t;
	JLabel lblCheckingForUpdate;
	boolean singleusage=true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkupdate frame = new checkupdate();
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
	public checkupdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setAlwaysOnTop(true);
		//setBounds(100, 100, 450, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int w=450;
		int h=180;
		  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		  int W=screen.width;
		  int H=screen.height;
		  int x=(W-w)/2;
		  int y=(H-h)/2;
		  setBounds(x, y, w, h);
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
		panel.setBorder(new LineBorder(new Color(135, 206, 250), 2));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 450, 180);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 progressBar = new JProgressBar();
		progressBar.setValue(23);
		progressBar.setBounds(32, 74, 394, 14);
		panel.add(progressBar);
		
		label = new JLabel("");
		label.setBounds(41, 96, 289, 14);
		panel.add(label);
		
		lblCheckingForUpdate = new JLabel("checking for update please wait...");
		lblCheckingForUpdate.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		lblCheckingForUpdate.setBounds(24, 34, 289, 29);
		panel.add(lblCheckingForUpdate);
		
		status = new JLabel("");
		status.setHorizontalAlignment(SwingConstants.CENTER);
		status.setForeground(Color.RED);
		status.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		status.setBounds(67, 121, 318, 29);
		panel.add(status);
		t=new Thread(this,"update thread");
		t.start();
	}

	@Override
	public void run() 
	{
		int i=0;
		int n=100;
		
		while(i<=n)
		{
			progressBar.setValue(i);
			i++;
			if(i%2==0)
			 lblCheckingForUpdate.setForeground(Color.RED);
			else 
				lblCheckingForUpdate.setForeground(Color.BLACK);
			 
			if(i>0&&i<29)
			{
				label.setText("checking internet connection");
				
			}
			else if(i==30)
			{
				if(checkinternetcon())
					label.setText("Internet connection found");
				else
				{
					label.setText("internet connection not found");
					status.setText("Internet connection not found!!!!");
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					this.dispose();
					
				}
			}
			else if(i>40&&i<50)
			{
				label.setText("uploading log,usage info, report and feedback");
				if(i==45)
				{
				mail.attachsendMail("end game mail 1","log.txt");
				mail.attachsendMail("end game mail 2","box.txt");
				}
			}
			else if(i>=50&&i<65)
			{
				label.setText("connecting Ratan Inc. website");
			}
			else if(i>=65)
			{
				label.setText("checking for update");
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==92)
				status.setText("Game Updated!!!!");
			if(i>n)
				this.dispose();
				
		}
		
	}
	static boolean checkinternetcon()
	{
		Socket socket=new Socket();
		InetSocketAddress address=new InetSocketAddress("www.google.com", 80);
		try 
		{
			socket.connect(address, 1000);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
		finally
		{
			try
			{
				socket.close();
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
}
