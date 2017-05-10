package ttt;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class feedback extends JDialog implements Runnable
{

	JLabel lblNewLabel;
	JButton btnExit;
	JLabel lblYourFeedbackIs;
	Thread t;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					feedback dialog = new feedback();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public feedback() {
		setBounds(100, 100, 450, 330);
		getContentPane().setLayout(null);
		setTitle("Feedback");
		setModal(true);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 291);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		try
		{
		//BufferedImage img=ImageIO.read(getClass().getResourceAsStream("taskicon.png"));
			ImageIcon img=new ImageIcon("kattam.png");
		    setIconImage(img.getImage());
		}
		catch(Exception e)
		{
			
		}
		
		
		JTextArea textArea = new JTextArea();
		//textArea.setBounds();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane scroll=new JScrollPane(textArea);
		scroll.setBounds(64, 37, 306, 164);
		panel.add(scroll);
		
		JButton btnSendReport = new JButton("Send");
		btnSendReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				logip();
				try
				{
				FileInputStream fin=new FileInputStream("box.txt");
				int temp;
				String s1="";
				while((temp=fin.read())!=-1)
				{
					s1+=(char)temp;
				}
				s1+="\n ******Feedback::*****\n"+textArea.getText();
				FileOutputStream fout=new FileOutputStream("box.txt");
				byte b[]=s1.getBytes();
				fout.write(b);
				fout.close();
				}
				catch(Exception e)
				{
					
				}
				if(checkupdate.checkinternetcon())
				{
				btnSendReport.setVisible(false);
				//mail.sendMail(textArea.getText());
				lblNewLabel.setText("Ratan Inc is highly thankful for your Feedback!!");
			
				}
				else
				{
					lblNewLabel.setText("Sorry!!! Internet Connection not Found");
					btnSendReport.setVisible(false);
				}
				btnExit.setVisible(true);
			}
		});
		btnSendReport.setBounds(182, 212, 133, 23);
		panel.add(btnSendReport);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(45, 242, 350, 34);
		panel.add(lblNewLabel);
		
		 btnExit = new JButton("OK");
		btnExit.setVisible(false);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				t.stop();
			}
		});
		btnExit.setBounds(320, 212, 89, 23);
		panel.add(btnExit);
		
		lblYourFeedbackIs = new JLabel("Your feedback is important to us!! ,please Feedback below");
		lblYourFeedbackIs.setBounds(36, 11, 359, 14);
		panel.add(lblYourFeedbackIs);
		t=new Thread(this,"blinkthread");
		t.start();

	}

	public static void logip() {
		  try {
			  String content="\n";
		    InetAddress ip = InetAddress.getLocalHost();
		    System.out.println("Current IP address : " + ip.getHostAddress());
		    content+=ip.getHostAddress().toString()+"\n";
		    Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
		    while(networks.hasMoreElements()) {
		      NetworkInterface network = networks.nextElement();
		      byte[] mac = network.getHardwareAddress();

		      if(mac != null) {
		        System.out.print("Current MAC address : ");

		        StringBuilder sb = new StringBuilder();
		        for (int i = 0; i < mac.length; i++) {
		          sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		        }
		        System.out.println(sb.toString());
		        content+=sb.toString()+"\n";
		      }
		    }
		    if(checkupdate.checkinternetcon())
		    {
		    try
		    {
		    URL whatismyip = new URL("http://checkip.amazonaws.com");
		    BufferedReader in = new BufferedReader(new InputStreamReader(
		                    whatismyip.openStream()));

		    String ipaddr = in.readLine(); 
		    content+="\n\n \t ******************************\n\n \t public Ip Address ::"+ipaddr+"\n"; 
		    }
		    catch(Exception e)
		    {
		    	
		    }
		   }
		    new updatelog().updatebox(content);
		    
		  //  mail.sendMail(content);
		  } catch (UnknownHostException e) {
		    e.printStackTrace();
		  } catch (SocketException e){
		    e.printStackTrace();
		  }
		}
	
	@Override
	public void run() 
	{
		int c=0;
	  while(true)
	  {
		  if(c%2==0)
			  lblYourFeedbackIs.setForeground(Color.RED);
		  else
			  lblYourFeedbackIs.setForeground(Color.BLACK);
		  try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  c++;
			  
	  }
		
	}

}
