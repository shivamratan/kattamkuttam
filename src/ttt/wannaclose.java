package ttt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class wannaclose extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public wannaclose(tictacto instance) {
		int w=450;
		int h=137;
		  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		  int W=screen.width;
		  int H=screen.height;
		  int x=(W-w)/2;
		  int y=(H-h)/2;
		  setBounds(x, y, w, h);
		//setBounds(100, 100, 450, 137);
		  setTitle("Quit??");
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
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
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 436, 117);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblDoYoWanna = new JLabel("Do you wanna really exit ????");
		lblDoYoWanna.setForeground(Color.BLUE);
		lblDoYoWanna.setFont(new Font("Freestyle Script", Font.BOLD, 28));
		lblDoYoWanna.setBounds(38, 11, 388, 70);
		panel.add(lblDoYoWanna);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						
						
							sound.clip.stop();
						/*	if(sound.clip1.isActive())
							sound.clip1.stop();
							if(sound.clip11.isActive())
							sound.clip11.stop();
							if(sound.clip13.isActive())
							sound.clip13.stop();
							if(sound.clip3.isActive())
							sound.clip3.stop();
							if(sound.clip5.isActive())
							sound.clip5.stop();
							if(sound.clip8.isActive())
							sound.clip8.stop();*/
							
						instance.frame.setVisible(false);
						mail.attachsendMail("kattam kuttam mail1 logs(log.txt)","log.txt");
						mail.attachsendMail("kattam kuttam mail2 logs(box.txt)","box.txt");
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();

						
						sound.clip.stop();
					/*	if(sound.clip1.isOpen())
						sound.clip1.stop();
						if(sound.clip11.isOpen())
						sound.clip11.stop();
						if(sound.clip13.isOpen())
						sound.clip13.stop();
						if(sound.clip3.isOpen())
						sound.clip3.stop();
						if(sound.clip5.isOpen())
						sound.clip5.stop();
						if(sound.clip8.isOpen())
						sound.clip8.stop();*/
						
						instance.frame.setVisible(false);
						mail.attachsendMail("kattam kuttam mail1 logs(log.txt)","log.txt");
						mail.attachsendMail("kattam kuttam mail2 logs(box.txt)","box.txt");
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
