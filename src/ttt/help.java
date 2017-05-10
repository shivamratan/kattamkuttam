package ttt;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;

import javax.swing.SwingConstants;

public class help extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					help dialog = new help();
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
	public help() {
		setBounds(100, 0, 711, 732);
		//setBounds(100, 100, 648, 500);
		getContentPane().setLayout(null);
		//setModal(true);
		setTitle("Help");
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
		panel.setForeground(Color.BLUE);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 695, 693);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblFields = new JLabel("1.   Playing Panel");
		lblFields.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFields.setForeground(Color.RED);
		lblFields.setBounds(20, 8, 129, 21);
		panel.add(lblFields);
		
		JLabel label = new JLabel("*");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(51, 38, 30, 21);
		panel.add(label);
		
		JLabel lblX = new JLabel("X 0");
		lblX.setForeground(Color.BLUE);
		lblX.setBounds(91, 38, 46, 14);
		panel.add(lblX);
		
		JLabel lblReprene = new JLabel("represents no. of current chances ");
		lblReprene.setBounds(255, 38, 232, 14);
		panel.add(lblReprene);
		
		JLabel label_1 = new JLabel("*");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(51, 54, 30, 21);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("00:00");
		label_2.setForeground(Color.BLUE);
		label_2.setBounds(91, 54, 46, 14);
		panel.add(label_2);
		
		JLabel lblTimerOfCurrent = new JLabel("timer of current game");
		lblTimerOfCurrent.setBounds(255, 54, 258, 14);
		panel.add(lblTimerOfCurrent);
		
		JLabel label_3 = new JLabel("*");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(51, 70, 30, 21);
		panel.add(label_3);
		
		JLabel lblUserA = new JLabel("User A");
		lblUserA.setForeground(Color.BLUE);
		lblUserA.setBounds(91, 70, 46, 14);
		panel.add(lblUserA);
		
		JLabel lblNameOfUser = new JLabel("Name of User A player(to be entered blank textfield)");
		lblNameOfUser.setBounds(227, 70, 300, 14);
		panel.add(lblNameOfUser);
		
		JLabel lblUserB = new JLabel("User B");
		lblUserB.setForeground(Color.BLUE);
		lblUserB.setBounds(91, 86, 46, 14);
		panel.add(lblUserB);
		
		JLabel label_5 = new JLabel("*");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(51, 86, 30, 21);
		panel.add(label_5);
		
		JLabel lblNameOfUser_1 = new JLabel("Name of User B player(to be entered blank textfield)");
		lblNameOfUser_1.setBounds(224, 86, 303, 14);
		panel.add(lblNameOfUser_1);
		
		JLabel label_4 = new JLabel("*");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(56, 106, 20, 14);
		panel.add(label_4);
		
		JLabel lblRadiobuttonOfX = new JLabel("Radiobutton of X & O");
		lblRadiobuttonOfX.setForeground(Color.BLUE);
		lblRadiobuttonOfX.setBounds(86, 102, 136, 14);
		panel.add(lblRadiobuttonOfX);
		
		JLabel lblPlayingIconFor = new JLabel("playing Icon for correspponding player");
		lblPlayingIconFor.setBounds(275, 102, 238, 14);
		panel.add(lblPlayingIconFor);
		
		JLabel label_6 = new JLabel("*");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(51, 120, 30, 21);
		panel.add(label_6);
		
		JLabel lblok = new JLabel("<html><u>O</u>K</html>");
		lblok.setForeground(Color.BLUE);
		lblok.setBounds(91, 120, 46, 14);
		panel.add(lblok);
		
		JLabel lblComesOnScreen = new JLabel("comes on screen if chance >1,used for locking your choice of filling");
		lblComesOnScreen.setBounds(249, 120, 374, 14);
		panel.add(lblComesOnScreen);
		
		JLabel lblOfCorrespondingPlayer = new JLabel("of corresponding player side of User A");
		lblOfCorrespondingPlayer.setBounds(252, 134, 219, 14);
		panel.add(lblOfCorrespondingPlayer);
		
		JLabel lblOfCorrespondingPlayer_1 = new JLabel("of corresponding player side of User B");
		lblOfCorrespondingPlayer_1.setBounds(252, 162, 219, 14);
		panel.add(lblOfCorrespondingPlayer_1);
		
		JLabel label_8 = new JLabel("comes on screen if chance >1,used for locking your choice of filling");
		label_8.setBounds(249, 148, 374, 14);
		panel.add(label_8);
		
		JLabel lblok_1 = new JLabel("<html>O<u>K</u></html>");
		lblok_1.setForeground(Color.BLUE);
		lblok_1.setBounds(91, 148, 46, 14);
		panel.add(lblok_1);
		
		JLabel label_10 = new JLabel("*");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(51, 148, 30, 21);
		panel.add(label_10);
		
		JLabel label_7 = new JLabel("*");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(51, 182, 29, 14);
		panel.add(label_7);
		
		JLabel lblGameProgress = new JLabel("Game Progress");
		lblGameProgress.setForeground(Color.BLUE);
		lblGameProgress.setBounds(86, 180, 93, 14);
		panel.add(lblGameProgress);
		
		JLabel lblItIsVisible = new JLabel("It is visible only  when new game is done ,however it displays the");
		lblItIsVisible.setBounds(249, 183, 320, 14);
		panel.add(lblItIsVisible);
		
		JLabel lblCurrentProgressOf = new JLabel("current progress of the single game");
		lblCurrentProgressOf.setBounds(249, 198, 219, 14);
		panel.add(lblCurrentProgressOf);
		
		JLabel lblSeriesProgressOf = new JLabel("series progress of the whole game");
		lblSeriesProgressOf.setBounds(247, 234, 219, 14);
		panel.add(lblSeriesProgressOf);
		
		JLabel label_11 = new JLabel("It is visible only  when new game is done ,however it displays the");
		label_11.setBounds(247, 219, 320, 14);
		panel.add(label_11);
		
		JLabel lblSeriesProgress = new JLabel("series Progress");
		lblSeriesProgress.setForeground(Color.BLUE);
		lblSeriesProgress.setBounds(84, 216, 93, 14);
		panel.add(lblSeriesProgress);
		
		JLabel label_13 = new JLabel("*");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBounds(49, 218, 29, 14);
		panel.add(label_13);
		
		JLabel label_9 = new JLabel("*");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(46, 261, 37, 14);
		panel.add(label_9);
		
		JLabel lblConsole = new JLabel("Console");
		lblConsole.setForeground(Color.BLUE);
		lblConsole.setBounds(91, 261, 86, 14);
		panel.add(lblConsole);
		
		JLabel lblLine = new JLabel("renders the preparation of bot engine for any event,displays the users current action ,");
		lblLine.setBounds(198, 259, 463, 14);
		panel.add(lblLine);
		
		JLabel lblLine_1 = new JLabel(",INSTANTANEOUS HELP for current event , toss won, chance remaining ,event warning");
		lblLine_1.setBounds(198, 275, 497, 14);
		panel.add(lblLine_1);
		
		JLabel lblLine_2 = new JLabel(", player thinking time , current event reported , all bot actions & players reaction ");
		lblLine_2.setBounds(198, 291, 425, 14);
		panel.add(lblLine_2);
		
		JLabel lblLine_3 = new JLabel(",highscore  and much more");
		lblLine_3.setBounds(198, 307, 425, 14);
		panel.add(lblLine_3);
		
		JLabel lblPlayingPanel = new JLabel("2.   Setting Panel");
		lblPlayingPanel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlayingPanel.setForeground(Color.RED);
		lblPlayingPanel.setBounds(30, 312, 129, 21);
		panel.add(lblPlayingPanel);
		
		JLabel label_12 = new JLabel("*");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(62, 335, 30, 14);
		panel.add(label_12);
		
		JLabel lblNewGame = new JLabel("New Game");
		lblNewGame.setForeground(Color.BLUE);
		lblNewGame.setBounds(95, 335, 79, 14);
		panel.add(lblNewGame);
		
		JLabel lblInitiateTheNew = new JLabel("initiate the new game for single player or double player & choose the option to ");
		lblInitiateTheNew.setBounds(203, 335, 401, 14);
		panel.add(lblInitiateTheNew);
		
		JLabel lblChooseTheNo = new JLabel("choose the no. of game & duration per game");
		lblChooseTheNo.setBounds(203, 350, 281, 14);
		panel.add(lblChooseTheNo);
		
		JLabel label_14 = new JLabel("*");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(62, 369, 30, 14);
		panel.add(label_14);
		
		JLabel lblToss = new JLabel("Toss");
		lblToss.setForeground(Color.BLUE);
		lblToss.setBounds(95, 367, 46, 14);
		panel.add(lblToss);
		
		JLabel lblTossTheGame = new JLabel("toss the game ");
		lblTossTheGame.setBounds(203, 368, 393, 14);
		panel.add(lblTossTheGame);
		
		JLabel label_15 = new JLabel("*");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setBounds(62, 388, 30, 14);
		panel.add(label_15);
		
		JLabel lblC = new JLabel("C");
		lblC.setForeground(Color.BLUE);
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setBounds(86, 387, 46, 14);
		panel.add(lblC);
		
		JLabel lblClearsTheBoard = new JLabel("Clears the board of game ");
		lblClearsTheBoard.setBounds(200, 387, 284, 14);
		panel.add(lblClearsTheBoard);
		
		JLabel label_16 = new JLabel("*");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setBounds(63, 406, 30, 14);
		panel.add(label_16);
		
		JLabel lblMore = new JLabel("More");
		lblMore.setForeground(Color.BLUE);
		lblMore.setHorizontalAlignment(SwingConstants.CENTER);
		lblMore.setBounds(89, 403, 46, 14);
		panel.add(lblMore);
		
		JLabel lblDisplaysTheDropdownlist = new JLabel("displays the dropdownlist having following options :----");
		lblDisplaysTheDropdownlist.setBounds(195, 406, 425, 14);
		panel.add(lblDisplaysTheDropdownlist);
		
		JLabel lbla = new JLabel("(a)");
		lbla.setHorizontalAlignment(SwingConstants.CENTER);
		lbla.setBounds(229, 425, 30, 14);
		panel.add(lbla);
		
		JLabel lblHowToPlay = new JLabel("How to play!!");
		lblHowToPlay.setBounds(266, 425, 79, 14);
		panel.add(lblHowToPlay);
		
		JLabel lblThisContainsDialog = new JLabel("this contains dialog box which tells you how to play ");
		lblThisContainsDialog.setBounds(369, 425, 292, 14);
		panel.add(lblThisContainsDialog);
		
		JLabel lblb = new JLabel("(b)");
		lblb.setHorizontalAlignment(SwingConstants.CENTER);
		lblb.setBounds(229, 448, 30, 14);
		panel.add(lblb);
		
		JLabel lblHelp = new JLabel("help");
		lblHelp.setBounds(266, 448, 79, 14);
		panel.add(lblHelp);
		
		JLabel lblDescriptionOfAll = new JLabel("description of all controls of game");
		lblDescriptionOfAll.setBounds(369, 448, 251, 14);
		panel.add(lblDescriptionOfAll);
		
		JLabel lblFeedback = new JLabel("Feedback");
		lblFeedback.setBounds(266, 467, 79, 14);
		panel.add(lblFeedback);
		
		JLabel lblc = new JLabel("(c)");
		lblc.setHorizontalAlignment(SwingConstants.CENTER);
		lblc.setBounds(229, 467, 30, 14);
		panel.add(lblc);
		
		JLabel lblShareYourExperience = new JLabel("share your experience of game with Ratan Inc.");
		lblShareYourExperience.setBounds(369, 467, 292, 14);
		panel.add(lblShareYourExperience);
		
		JLabel lbld = new JLabel("(d)");
		lbld.setHorizontalAlignment(SwingConstants.CENTER);
		lbld.setBounds(229, 488, 30, 14);
		panel.add(lbld);
		
		JLabel lblCheckForUpdate = new JLabel("Check for Update");
		lblCheckForUpdate.setBounds(266, 488, 101, 14);
		panel.add(lblCheckForUpdate);
		
		JLabel lblUpdateYourGame = new JLabel("Update your game to recent version of game");
		lblUpdateYourGame.setBounds(379, 488, 282, 14);
		panel.add(lblUpdateYourGame);
		
		JLabel lble = new JLabel("(e)");
		lble.setHorizontalAlignment(SwingConstants.CENTER);
		lble.setBounds(229, 507, 30, 14);
		panel.add(lble);
		
		JLabel lblReportBug = new JLabel("Report Bug");
		lblReportBug.setBounds(266, 507, 101, 14);
		panel.add(lblReportBug);
		
		JLabel lblReportBugTo = new JLabel("report bug to Ratan Inc. & win exciting cash prizes");
		lblReportBugTo.setBounds(369, 507, 251, 14);
		panel.add(lblReportBugTo);
		
		JLabel lblf = new JLabel("(f)");
		lblf.setHorizontalAlignment(SwingConstants.CENTER);
		lblf.setBounds(229, 527, 30, 14);
		panel.add(lblf);
		
		JLabel lblRegister = new JLabel("About");
		lblRegister.setBounds(266, 527, 85, 14);
		panel.add(lblRegister);
		
		JLabel lblGameIsFreeware = new JLabel("Contains information about game developer");
		lblGameIsFreeware.setBounds(369, 527, 251, 14);
		panel.add(lblGameIsFreeware);
		
		JLabel lblHighScore = new JLabel("High score");
		lblHighScore.setForeground(Color.BLUE);
		lblHighScore.setBounds(106, 546, 79, 14);
		panel.add(lblHighScore);
		
		JLabel label_17 = new JLabel("*");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setBounds(60, 546, 46, 14);
		panel.add(label_17);
		
		JLabel lblDisplaysTheTop = new JLabel("displays the top 10 high score of game");
		lblDisplaysTheTop.setBounds(207, 546, 340, 14);
		panel.add(lblDisplaysTheTop);
		
		JLabel label_18 = new JLabel("*");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setBounds(70, 567, 24, 14);
		panel.add(label_18);
		
		JLabel lblTheme = new JLabel("Theme");
		lblTheme.setForeground(Color.BLUE);
		lblTheme.setBounds(104, 565, 58, 14);
		panel.add(lblTheme);
		
		JLabel lblChooseDifferentExciting = new JLabel("choose different exciting theme  for the game");
		lblChooseDifferentExciting.setBounds(207, 566, 340, 14);
		panel.add(lblChooseDifferentExciting);
		
		JLabel lblTape = new JLabel("Tape");
		lblTape.setForeground(Color.BLUE);
		lblTape.setBounds(104, 587, 58, 14);
		panel.add(lblTape);
		
		JLabel label_20 = new JLabel("*");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setBounds(70, 589, 24, 14);
		panel.add(label_20);
		
		JLabel lblChooseDifferentMusic = new JLabel("choose different music you enjoy  for the game");
		lblChooseDifferentMusic.setBounds(207, 588, 340, 14);
		panel.add(lblChooseDifferentMusic);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setForeground(Color.BLUE);
		lblLevel.setBounds(104, 606, 58, 14);
		panel.add(lblLevel);
		
		JLabel label_21 = new JLabel("*");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setBounds(70, 608, 24, 14);
		panel.add(label_21);
		
		JLabel lblGearsYouTo = new JLabel("gears you to different level against computer");
		lblGearsYouTo.setBounds(207, 607, 340, 14);
		panel.add(lblGearsYouTo);
		
		JLabel lblSetChances = new JLabel("Set Chance/s ");
		lblSetChances.setForeground(Color.BLUE);
		lblSetChances.setBounds(104, 624, 93, 14);
		panel.add(lblSetChances);
		
		JLabel label_22 = new JLabel("*");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setBounds(70, 626, 24, 14);
		panel.add(label_22);
		
		JLabel lblSetYourNo = new JLabel("set your no of turns of playing against another player or computer");
		lblSetYourNo.setBounds(207, 625, 413, 14);
		panel.add(lblSetYourNo);
		
		JLabel lblEnableBot = new JLabel("Enable Bot");
		lblEnableBot.setForeground(Color.BLUE);
		lblEnableBot.setBounds(106, 646, 73, 14);
		panel.add(lblEnableBot);
		
		JLabel label_19 = new JLabel("*");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setBounds(68, 646, 24, 14);
		panel.add(label_19);
		
		JLabel lblThisOptionCan = new JLabel("this activates the bot and can be enabled by playing against computer or single game");
		lblThisOptionCan.setBounds(198, 646, 497, 14);
		panel.add(lblThisOptionCan);
		
		JLabel label_23 = new JLabel("*");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setBounds(68, 668, 24, 14);
		panel.add(label_23);
		
		JLabel lblStatistics = new JLabel("Statistics");
		lblStatistics.setForeground(Color.BLUE);
		lblStatistics.setBounds(106, 668, 73, 14);
		panel.add(lblStatistics);
		
		JLabel lblDisplaysTheGame = new JLabel("Displays the game no. , game won , game draw ,game wasted(due to time),remaining game");
		lblDisplaysTheGame.setBounds(177, 668, 518, 14);
		panel.add(lblDisplaysTheGame);

	}
}
