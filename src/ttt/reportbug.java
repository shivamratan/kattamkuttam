package ttt;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class reportbug extends JDialog {

	JLabel lblNewLabel;
	JButton btnExit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reportbug dialog = new reportbug();
					
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
	public reportbug() {
		setBounds(100, 100, 450, 326);
		getContentPane().setLayout(null);
		setModal(true);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 287);
		getContentPane().add(panel);
		panel.setLayout(null);
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
		
		JTextArea textArea = new JTextArea();
		//textArea.setBounds();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane scroll=new JScrollPane(textArea);
		scroll.setBounds(64, 37, 306, 164);
		panel.add(scroll);
		
		JButton btnSendReport = new JButton("Send Report");
		btnSendReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				feedback.logip();
				try
				{
				FileInputStream fin=new FileInputStream("box.txt");
				int temp;
				String s1="";
				while((temp=fin.read())!=-1)
				{
					s1+=(char)temp;
				}
				s1+="\n ******Report Bug::*****\n"+textArea.getText();
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
				
				lblNewLabel.setText("Your Bug has been reported to the server of Ratan Inc");
			
				}
				else
				{
					btnSendReport.setVisible(false);
					lblNewLabel.setText("Sorry!!! Internet Connection not Found");
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
			}
		});
		btnExit.setBounds(320, 212, 89, 23);
		panel.add(btnExit);
		
		JLabel lblReportingBugOf = new JLabel("Reporting bug! of kattam kuttam makes game bug free so please report bug !!!!");
		lblReportingBugOf.setBounds(10, 14, 414, 14);
		panel.add(lblReportingBugOf);

	}
}
