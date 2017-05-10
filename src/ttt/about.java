package ttt;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.LineBorder;

public class about extends JDialog implements Runnable
{

	/**
	 * Launch the application.
	 */
	JPanel panel_1;
	JPanel panel;
	Thread t;
	public static void main(String[] args) {
		try {
			about dialog = new about();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public about() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				t.stop();
			}
		});
		setBounds(100, 100, 546, 527);
		getContentPane().setLayout(null);
		setModal(true);
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
		
		
		try
		{
		//BufferedImage img=ImageIO.read(getClass().getResourceAsStream("taskicon.png"));
			ImageIcon img=new ImageIcon("kattam.png");
		   setIconImage(img.getImage());
		}
		catch(Exception e)
		{
			
		}
		JLabel lbldev = new JLabel("<html>The Product is designed & developed by &nbsp;<a href=\"\">Shivam Ratan</a><html>");
		lbldev.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbldev.setBounds(87, 439, 350, 23);
		getContentPane().add(lbldev);
		lbldev.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					Runtime.getRuntime().exec("\"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe\" \"http:\\\\www.facebook.com\\shivamsinghratan\"");
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null,"BROWSER CHROME NOT FOUND FIRSTLY PLEASE INSTALL THE CHROME TO VIEW FULL PROFILE");
				}
			      }
				   });
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t.stop();
			//	setVisible(false);
				dispose();
			}
		});
		btnNewButton.setBounds(389, 461, 95, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblLbl = new JLabel("Kattam kuttam");
		lblLbl.setBounds(72, 334, 183, 14);
		getContentPane().add(lblLbl);
		
		JLabel lblNewLabel = new JLabel("version 1.0");
		lblNewLabel.setBounds(71, 350, 291, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblcopyFreeware = new JLabel("<html>&copy;<html> 2015 Ratan Inc. All right reserved.");
		lblcopyFreeware.setBounds(71, 370, 291, 14);
		getContentPane().add(lblcopyFreeware);
		
		JLabel lblTheVpadSoftware = new JLabel("The Game and its user interface are protected by trademark ");
		lblTheVpadSoftware.setBounds(71, 387, 416, 14);
		getContentPane().add(lblTheVpadSoftware);
		
		JLabel lblStatesAndOther = new JLabel(" and other countries/regions.");
		lblStatesAndOther.setBounds(70, 419, 405, 14);
		getContentPane().add(lblStatesAndOther);
		
		JLabel lblAndOtherPending = new JLabel("and other pending or existing intellectual property rights in the India");
		lblAndOtherPending.setBounds(70, 402, 417, 14);
		getContentPane().add(lblAndOtherPending);
		
		 panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 152, 510, 180);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		 panel_1 = new JPanel();
		panel_1.setBounds(57, -153, 358, 488);
		panel_1.setBackground(Color.BLACK);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMusicDirecition = new JLabel("Music Direction:");
		lblMusicDirecition.setBounds(95, 0, 134, 14);
		panel_1.add(lblMusicDirecition);
		lblMusicDirecition.setForeground(Color.WHITE);
		
		JLabel lblGraphicsDirection = new JLabel("Graphics direction ::");
		lblGraphicsDirection.setBounds(78, 55, 162, 14);
		panel_1.add(lblGraphicsDirection);
		lblGraphicsDirection.setForeground(Color.WHITE);
		
		JLabel lblManager = new JLabel("Testing Manager : ");
		lblManager.setBounds(92, 109, 148, 14);
		panel_1.add(lblManager);
		lblManager.setForeground(Color.WHITE);
		lblManager.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTechnicalDirector = new JLabel("Technical director :");
		lblTechnicalDirector.setBounds(78, 157, 151, 14);
		panel_1.add(lblTechnicalDirector);
		lblTechnicalDirector.setForeground(Color.WHITE);
		lblTechnicalDirector.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblSubjectMatterExperts = new JLabel("Subject Matter Experts : ");
		lblSubjectMatterExperts.setBounds(78, 198, 162, 14);
		panel_1.add(lblSubjectMatterExperts);
		lblSubjectMatterExperts.setForeground(Color.WHITE);
		lblSubjectMatterExperts.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblDesigner = new JLabel("designer :");
		lblDesigner.setBounds(96, 288, 140, 14);
		panel_1.add(lblDesigner);
		lblDesigner.setForeground(Color.WHITE);
		lblDesigner.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblDeveloper = new JLabel("developer :");
		lblDeveloper.setBounds(124, 414, 69, 14);
		panel_1.add(lblDeveloper);
		lblDeveloper.setForeground(Color.WHITE);
		lblDeveloper.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblProducer = new JLabel("producer:");
		lblProducer.setBounds(100, 375, 84, 14);
		panel_1.add(lblProducer);
		lblProducer.setForeground(Color.WHITE);
		lblProducer.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblMarketingExpert = new JLabel("Marketing expert :");
		lblMarketingExpert.setBounds(78, 333, 134, 14);
		panel_1.add(lblMarketingExpert);
		lblMarketingExpert.setForeground(Color.WHITE);
		lblMarketingExpert.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblAnalyticAndTechnical = new JLabel("Analytic and technical mapper :");
		lblAnalyticAndTechnical.setBounds(59, 237, 206, 14);
		panel_1.add(lblAnalyticAndTechnical);
		lblAnalyticAndTechnical.setForeground(Color.WHITE);
		lblAnalyticAndTechnical.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblSpecialThanksTo = new JLabel("special thanks to !!");
		lblSpecialThanksTo.setBounds(-38, 308, 132, 14);
		panel_1.add(lblSpecialThanksTo);
		
		JLabel lblShivamRatan = new JLabel("Shivam Ratan");
		lblShivamRatan.setForeground(Color.WHITE);
		lblShivamRatan.setBounds(129, 18, 100, 14);
		panel_1.add(lblShivamRatan);
		
		JLabel label = new JLabel("Shivam Ratan");
		label.setForeground(Color.WHITE);
		label.setBounds(127, 71, 113, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Shivam Ratan");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(127, 128, 113, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Shivam Ratan");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(138, 174, 113, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Shivam Ratan");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(152, 214, 113, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Shivam Ratan");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(152, 256, 113, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Shivam Ratan");
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(168, 304, 113, 14);
		panel_1.add(label_5);
		
		JLabel lblDirectedBy = new JLabel("Directed by");
		lblDirectedBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblDirectedBy.setForeground(Color.WHITE);
		lblDirectedBy.setBounds(100, 447, 151, 14);
		panel_1.add(lblDirectedBy);
		
		JLabel label_6 = new JLabel("Shivam Ratan");
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(168, 347, 113, 14);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("Shivam Ratan");
		label_7.setForeground(Color.WHITE);
		label_7.setBounds(170, 390, 113, 14);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("Shivam Ratan");
		label_8.setForeground(Color.WHITE);
		label_8.setBounds(171, 428, 113, 14);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("Shivam Ratan");
		label_9.setForeground(Color.WHITE);
		label_9.setBounds(172, 465, 113, 14);
		panel_1.add(label_9);
		
		JLabel lblImg = new JLabel(new ImageIcon("kattam.png"));
		
		lblImg.setBounds(181, 11, 142, 134);
		getContentPane().add(lblImg);
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(38, 148, 449, 9);
		getContentPane().add(separator_1);
		t=new Thread(this,"scrollthread");
		t.start();
	}

	@Override
	public void run() 
	{
		
		int h=panel_1.getHeight();
		//int v=panel_1.getY()+panel.getHeight();
		int v=0;
		int temp=v;
		while(true)
		{
			System.out.println("executing...");
			if(v==(-h))
				v=panel.getHeight();
			//System.out.println("The value of v is"+v);
			panel_1.setBounds(57, v, 358, 488);
				v--;
			
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
