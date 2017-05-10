package ttt;

import java.awt.Color;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class themecontrol 
{
	 static int m;
	static int c;
	static int num;
	tictacto ob;
	public themecontrol(tictacto t)
	{
		ob=t;
		Random rand=new Random();
		   m=rand.nextInt(9);
		   num=rand.nextInt(34);
	}
	void setintervalimg()
	{
		ob.theme.setIcon(new ImageIcon("colormix.jpg"));
		ob.comboBox_1.setSelectedIndex(22);
	}
	void randomiseimg()
	{
		//Random rd=new Random();
		//int num=rd.nextInt(34);
		
			switch(num)
			{
			case 1:
				ob.theme.setIcon(new ImageIcon("space.GIF"));
				ob.comboBox_1.setSelectedIndex(0);
				break;
			case 2:
				ob.theme.setIcon(new ImageIcon(("swirlgreen.jpg")));
				ob.comboBox_1.setSelectedIndex(1);
				break;
			case 3:
				ob.theme.setIcon(new ImageIcon("pinkcity.jpg"));
				ob.comboBox_1.setSelectedIndex(2);
				break;
             case 4:
            	ob.theme.setIcon(new ImageIcon("springgreen.jpg"));
            	ob.comboBox_1.setSelectedIndex(3);
				break;
             case 5:
            	 ob.theme.setIcon(new ImageIcon("lemonyellow.jpg"));
            	 ob.comboBox_1.setSelectedIndex(4);
            	break;
             case 6:
            	 ob.theme.setIcon(new ImageIcon("colorspiral.gif"));
            	 ob.comboBox_1.setSelectedIndex(5);
            	 break;
             case 7:
            	 ob.theme.setIcon(new ImageIcon("rainyglass.jpg"));
            	 ob.comboBox_1.setSelectedIndex(6);
            	 break;
             case 8:
            	 ob.theme.setIcon(new ImageIcon("yellowtiles.jpg"));
            	 ob.comboBox_1.setSelectedIndex(8);
            	 break;
             case 9:
            	 ob.theme.setIcon(new ImageIcon("sunnylemon.jpg"));
            	 ob.comboBox_1.setSelectedIndex(9);
            	 break;
             case 10:
            	 ob.theme.setIcon(new ImageIcon("rainsplash.jpg"));
            	 ob.comboBox_1.setSelectedIndex(7);
            	 break;
             case 11:
            	 ob.theme.setIcon(new ImageIcon("gradient1.jpg"));
            	 ob.comboBox_1.setSelectedIndex(10);
            	 break;
             case 12:
            	 ob.theme.setIcon(new ImageIcon("gradient2.jpg"));
            	 ob.comboBox_1.setSelectedIndex(11);
            	 break;
             case 13:
            	 ob.theme.setIcon(new ImageIcon("abstractgreen.jpg"));
            	 ob.comboBox_1.setSelectedIndex(12);
            	 break;
             case 14:
            	 ob.theme.setIcon(new ImageIcon("abstractlight.jpg"));
            	 ob.comboBox_1.setSelectedIndex(13);
            	 break;
             case 15:
            	 ob.theme.setIcon(new ImageIcon("bluecurtain.jpg"));
            	 ob.comboBox_1.setSelectedIndex(14);
            	 break;
             case 16:
            	 ob.theme.setIcon(new ImageIcon("blurscene.jpg"));
            	 ob.comboBox_1.setSelectedIndex(15);
            	 break;
             case 17:
            	 ob.theme.setIcon(new ImageIcon("colorhypo.jpg"));
            	 ob.comboBox_1.setSelectedIndex(16);
            	 break;
             case 18:
            	 ob.theme.setIcon(new ImageIcon("colormix.jpg"));
            	 ob.comboBox_1.setSelectedIndex(17);
            	 break;
             case 19:
            	 ob.theme.setIcon(new ImageIcon("cutgradient.jpg"));
            	 ob.comboBox_1.setSelectedIndex(18);
            	 break;
             case 20:
            	 ob.theme.setIcon(new ImageIcon("freesprit.jpg"));
            	 ob.comboBox_1.setSelectedIndex(19);
            	 break;
             case 21:
            	 ob.theme.setIcon(new ImageIcon("leaves.jpg"));
            	 ob.comboBox_1.setSelectedIndex(20);
            	 break;
             case 22:
            	 ob.theme.setIcon(new ImageIcon("lightclash.jpg"));
            	 ob.comboBox_1.setSelectedIndex(21);
            	 break;
             case 23:
            	 ob.theme.setIcon(new ImageIcon("nature.jpg"));
            	 ob.comboBox_1.setSelectedIndex(23);
            	 break;
             case 24:
            	 ob.theme.setIcon(new ImageIcon("papercut.jpg"));
            	 ob.comboBox_1.setSelectedIndex(24);
            	 break;
             case 25:
            	 ob.theme.setIcon(new ImageIcon("reddishcurtain.jpg"));
            	 ob.comboBox_1.setSelectedIndex(25);
            	 break;
             case 26:
            	 ob.theme.setIcon(new ImageIcon("redtexture.jpg"));
            	 ob.comboBox_1.setSelectedIndex(26);
            	 break;
             case 27:
            	 ob.theme.setIcon(new ImageIcon("swirlrainbow.jpg"));
            	 ob.comboBox_1.setSelectedIndex(27);
            	 break;
             case 28:
            	 ob.theme.setIcon(new ImageIcon("rockprint.jpg"));
            	 ob.comboBox_1.setSelectedIndex(28);
            	 break;
             case 29:
            	 ob.theme.setIcon(new ImageIcon("roxy.jpg"));
            	 ob.comboBox_1.setSelectedIndex(29);
            	 break;
             case 30:
            	 ob.theme.setIcon(new ImageIcon("seabeach.jpg"));
            	 ob.comboBox_1.setSelectedIndex(30);
            	 break;
             case 31:
            	 ob.theme.setIcon(new ImageIcon("skyscene.jpg"));
            	 ob.comboBox_1.setSelectedIndex(31);
            	 break;
             case 32:
            	 ob.theme.setIcon(new ImageIcon("ultimategray.jpg"));
            	 ob.comboBox_1.setSelectedIndex(32);
            	 break;
             case 33:
            	 ob.theme.setIcon(new ImageIcon("wave.jpg"));
            	 ob.comboBox_1.setSelectedIndex(33);
            	 break;
            default:
            	ob.theme.setIcon(new ImageIcon("space.GIF"));
				ob.comboBox_1.setSelectedIndex(0);
            	
			}
			if(num==33)
				num=-1;
			num++;
	}
	void randomisemusic()
	{
		sound.clip.stop();
		 
		 new sound().playbackground(m);
		  switch(m)
		  {
		  case 0:
			  ob.comboBox_2.setSelectedIndex(3);
			  break;
		  case 1:
			  ob.comboBox_2.setSelectedIndex(1);
			  break;
		  case 2:
			  ob.comboBox_2.setSelectedIndex(0);
			  break;
		  case 3:
			  ob.comboBox_2.setSelectedIndex(2);
			  break;
		  case 4:
			  ob.comboBox_2.setSelectedIndex(4);
			  break;
		  case 5:
			  ob.comboBox_2.setSelectedIndex(5);
			  break;
		  case 6:
			  ob.comboBox_2.setSelectedIndex(6);
			  break;
		  case 7:
			  ob.comboBox_2.setSelectedIndex(7);
			  break;
		  case 8:
			  ob.comboBox_2.setSelectedIndex(8);
			  m=0;
			  break;
		   
		  
		  }
		  m++;  	
		    
	}
	void buttoncolor()
	{
		if(ob.comboBox_1.getSelectedIndex()==0)
		{
		ob.btn00.setBackground(Color.black);
		ob.btn01.setBackground(Color.black);
		ob.btn02.setBackground(Color.black);
		ob.btn10.setBackground(Color.black);
		ob.btn11.setBackground(Color.black);
		ob.btn12.setBackground(Color.black);
		ob.btn20.setBackground(Color.black);
		ob.btn21.setBackground(Color.black);
		ob.btn22.setBackground(Color.black);
		//change font color accordingly
			ob.lbllivea.setForeground(Color.GREEN);
			ob.lblliveb.setForeground(Color.GREEN);
			ob.lblUserA.setForeground(Color.GREEN);
			ob.lblUserB.setForeground(Color.GREEN);
			ob.lblNewLabel.setForeground(Color.GREEN);
			ob.lblTimerLabel.setForeground(Color.GREEN);
			ob.lblB.setForeground(Color.GREEN);
			ob.rbabtnX.setForeground(Color.GREEN);
			ob.rbbbtnX.setForeground(Color.GREEN);
			ob.rbabtnO.setForeground(Color.GREEN);
			ob.rbbbtnO.setForeground(Color.GREEN);
			ob.lblNewLabel_2.setForeground(Color.white);
		}
		if(ob.comboBox_1.getSelectedIndex()==1)
		{
		ob.btn00.setBackground(Color.decode("#b6d947"));
		ob.btn01.setBackground(Color.decode("#b6d947"));
		ob.btn02.setBackground(Color.decode("#b6d947"));
		ob.btn10.setBackground(Color.decode("#b6d947"));
		ob.btn11.setBackground(Color.decode("#b6d947"));
		ob.btn12.setBackground(Color.decode("#b6d947"));
		ob.btn20.setBackground(Color.decode("#b6d947"));
		ob.btn21.setBackground(Color.decode("#b6d947"));
		ob.btn22.setBackground(Color.decode("#b6d947"));
		//change theme font color accondingly
		 defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==2)
		{
		ob.btn00.setBackground(Color.pink);
		ob.btn01.setBackground(Color.pink);
		ob.btn02.setBackground(Color.pink);
		ob.btn10.setBackground(Color.pink);
		ob.btn11.setBackground(Color.pink);
		ob.btn12.setBackground(Color.pink);
		ob.btn20.setBackground(Color.pink);
		ob.btn21.setBackground(Color.pink);
		ob.btn22.setBackground(Color.pink);
		//change theme font color accondingly
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==3)
		{
			//change theme font color accondingly
		ob.btn00.setBackground(Color.decode("#268503"));
		ob.btn01.setBackground(Color.decode("#268503"));
		ob.btn02.setBackground(Color.decode("#268503"));
		ob.btn10.setBackground(Color.decode("#268503"));
		ob.btn11.setBackground(Color.decode("#268503"));
		ob.btn12.setBackground(Color.decode("#268503"));
		ob.btn20.setBackground(Color.decode("#268503"));
		ob.btn21.setBackground(Color.decode("#268503"));
		ob.btn22.setBackground(Color.decode("#268503"));
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==4)
		{
			//change theme font color accondingly
		ob.btn00.setBackground(Color.decode("#EFBD00"));
		ob.btn01.setBackground(Color.decode("#EFBD00"));
		ob.btn02.setBackground(Color.decode("#EFBD00"));
		ob.btn10.setBackground(Color.decode("#EFBD00"));
		ob.btn11.setBackground(Color.decode("#EFBD00"));
		ob.btn12.setBackground(Color.decode("#EFBD00"));
		ob.btn20.setBackground(Color.decode("#EFBD00"));
		ob.btn21.setBackground(Color.decode("#EFBD00"));
		ob.btn22.setBackground(Color.decode("#EFBD00"));
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==5)
		{
			//change theme font color accondingly
		ob.btn00.setBackground(Color.decode("#268503"));
		ob.btn01.setBackground(Color.decode("#268503"));
		ob.btn02.setBackground(Color.decode("#268503"));
		ob.btn10.setBackground(Color.decode("#268503"));
		ob.btn11.setBackground(Color.decode("#268503"));
		ob.btn12.setBackground(Color.decode("#268503"));
		ob.btn20.setBackground(Color.decode("#268503"));
		ob.btn21.setBackground(Color.decode("#268503"));
		ob.btn22.setBackground(Color.decode("#268503"));
		ob.lbllivea.setForeground(Color.white);
		ob.lblliveb.setForeground(Color.white);
		ob.lblUserA.setForeground(Color.white);
		ob.lblUserB.setForeground(Color.white);
		ob.lblNewLabel.setForeground(Color.white);
		ob.lblTimerLabel.setForeground(Color.white);
		ob.lblB.setForeground(Color.white);
		ob.rbabtnX.setForeground(Color.white);
		ob.rbbbtnX.setForeground(Color.white);
		ob.rbabtnO.setForeground(Color.white);
		ob.rbbbtnO.setForeground(Color.white);
		ob.lblNewLabel_2.setForeground(Color.WHITE);
		}
		if(ob.comboBox_1.getSelectedIndex()==6)
		{
			//change theme font color accondingly
		ob.btn00.setBackground(Color.blue);
		ob.btn01.setBackground(Color.blue);
		ob.btn02.setBackground(Color.blue);
		ob.btn10.setBackground(Color.blue);
		ob.btn11.setBackground(Color.blue);
		ob.btn12.setBackground(Color.blue);
		ob.btn20.setBackground(Color.blue);
		ob.btn21.setBackground(Color.blue);
		ob.btn22.setBackground(Color.blue);
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==7)
		{
			//change theme font color accondingly
		ob.btn00.setBackground(Color.blue);
		ob.btn01.setBackground(Color.blue);
		ob.btn02.setBackground(Color.blue);
		ob.btn10.setBackground(Color.blue);
		ob.btn11.setBackground(Color.blue);
		ob.btn12.setBackground(Color.blue);
		ob.btn20.setBackground(Color.blue);
		ob.btn21.setBackground(Color.blue);
		ob.btn22.setBackground(Color.blue);
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==8)
		{
			//change theme font color accondingly
		ob.btn00.setBackground(Color.red);
		ob.btn01.setBackground(Color.red);
		ob.btn02.setBackground(Color.red);
		ob.btn10.setBackground(Color.red);
		ob.btn11.setBackground(Color.red);
		ob.btn12.setBackground(Color.red);
		ob.btn20.setBackground(Color.red);
		ob.btn21.setBackground(Color.red);
		ob.btn22.setBackground(Color.red);
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==9)
		{
			//change theme font color accondingly
		ob.btn00.setBackground(Color.ORANGE);
		ob.btn01.setBackground(Color.ORANGE);
		ob.btn02.setBackground(Color.ORANGE);
		ob.btn10.setBackground(Color.ORANGE);
		ob.btn11.setBackground(Color.ORANGE);
		ob.btn12.setBackground(Color.ORANGE);
		ob.btn20.setBackground(Color.ORANGE);
		ob.btn21.setBackground(Color.ORANGE);
		ob.btn22.setBackground(Color.ORANGE);
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==10)
		{
			//change theme font color accondingly
		ob.btn00.setBackground(Color.gray);
		ob.btn01.setBackground(Color.gray);
		ob.btn02.setBackground(Color.gray);
		ob.btn10.setBackground(Color.gray);
		ob.btn11.setBackground(Color.gray);
		ob.btn12.setBackground(Color.gray);
		ob.btn20.setBackground(Color.gray);
		ob.btn21.setBackground(Color.gray);
		ob.btn22.setBackground(Color.gray);
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==11)
		{
		ob.btn00.setBackground(Color.decode("#786051"));
		ob.btn01.setBackground(Color.decode("#786051"));
		ob.btn02.setBackground(Color.decode("#786051"));
		ob.btn10.setBackground(Color.decode("#786051"));
		ob.btn11.setBackground(Color.decode("#786051"));
		ob.btn12.setBackground(Color.decode("#786051"));
		ob.btn20.setBackground(Color.decode("#786051"));
		ob.btn21.setBackground(Color.decode("#786051"));
		ob.btn22.setBackground(Color.decode("#786051"));
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==12)
		{
		ob.btn00.setBackground(Color.decode("#022902"));
		ob.btn01.setBackground(Color.decode("#022902"));
		ob.btn02.setBackground(Color.decode("#022902"));
		ob.btn10.setBackground(Color.decode("#022902"));
		ob.btn11.setBackground(Color.decode("#022902"));
		ob.btn12.setBackground(Color.decode("#022902"));
		ob.btn20.setBackground(Color.decode("#022902"));
		ob.btn21.setBackground(Color.decode("#022902"));
		ob.btn22.setBackground(Color.decode("#022902"));
		ob.lbllivea.setForeground(Color.yellow);
		ob.lblliveb.setForeground(Color.yellow);
		ob.lblUserA.setForeground(Color.yellow);
		ob.lblUserB.setForeground(Color.yellow);
		ob.lblNewLabel.setForeground(Color.yellow);
		ob.lblTimerLabel.setForeground(Color.yellow);
		ob.lblB.setForeground(Color.yellow);
		ob.rbabtnX.setForeground(Color.yellow);
		ob.rbbbtnX.setForeground(Color.yellow);
		ob.rbabtnO.setForeground(Color.yellow);
		ob.rbbbtnO.setForeground(Color.yellow);
		
		}
		if(ob.comboBox_1.getSelectedIndex()==13)
		{
		ob.btn00.setBackground(Color.blue);
		ob.btn01.setBackground(Color.BLUE);
		ob.btn02.setBackground(Color.BLUE);
		ob.btn10.setBackground(Color.BLUE);
		ob.btn11.setBackground(Color.BLUE);
		ob.btn12.setBackground(Color.BLUE);
		ob.btn20.setBackground(Color.BLUE);
		ob.btn21.setBackground(Color.BLUE);
		ob.btn22.setBackground(Color.BLUE);
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==14)
		{
		ob.btn00.setBackground(Color.black);
		ob.btn01.setBackground(Color.black);
		ob.btn02.setBackground(Color.black);
		ob.btn10.setBackground(Color.black);
		ob.btn11.setBackground(Color.black);
		ob.btn12.setBackground(Color.black);
		ob.btn20.setBackground(Color.black);
		ob.btn21.setBackground(Color.black);
		ob.btn22.setBackground(Color.black);
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==15)
		{
		ob.btn00.setBackground(Color.WHITE);
		ob.btn01.setBackground(Color.WHITE);
		ob.btn02.setBackground(Color.WHITE);
		ob.btn10.setBackground(Color.WHITE);
		ob.btn11.setBackground(Color.WHITE);
		ob.btn12.setBackground(Color.WHITE);
		ob.btn20.setBackground(Color.WHITE);
		ob.btn21.setBackground(Color.WHITE);
		ob.btn22.setBackground(Color.WHITE);
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==16)
		{
		ob.btn00.setBackground(Color.MAGENTA);
		ob.btn01.setBackground(Color.MAGENTA);
		ob.btn02.setBackground(Color.MAGENTA);
		ob.btn10.setBackground(Color.MAGENTA);
		ob.btn11.setBackground(Color.MAGENTA);
		ob.btn12.setBackground(Color.MAGENTA);
		ob.btn20.setBackground(Color.MAGENTA);
		ob.btn21.setBackground(Color.MAGENTA);
		ob.btn22.setBackground(Color.MAGENTA);
		ob.lbllivea.setForeground(Color.GREEN);
		ob.lblliveb.setForeground(Color.GREEN);
		ob.lblUserA.setForeground(Color.GREEN);
		ob.lblUserB.setForeground(Color.GREEN);
		ob.lblNewLabel.setForeground(Color.GREEN);
		ob.lblTimerLabel.setForeground(Color.GREEN);
		ob.lblB.setForeground(Color.GREEN);
		ob.rbabtnX.setForeground(Color.GREEN);
		ob.rbbbtnX.setForeground(Color.GREEN);
		ob.rbabtnO.setForeground(Color.GREEN);
		ob.rbbbtnO.setForeground(Color.GREEN);
		}
		if(ob.comboBox_1.getSelectedIndex()==17)
		{
		ob.btn00.setBackground(Color.DARK_GRAY);
		ob.btn01.setBackground(Color.DARK_GRAY);
		ob.btn02.setBackground(Color.DARK_GRAY);
		ob.btn10.setBackground(Color.DARK_GRAY);
		ob.btn11.setBackground(Color.DARK_GRAY);
		ob.btn12.setBackground(Color.DARK_GRAY);
		ob.btn20.setBackground(Color.DARK_GRAY);
		ob.btn21.setBackground(Color.DARK_GRAY);
		ob.btn22.setBackground(Color.DARK_GRAY);
		defaultfontcolor();
		
		}
		if(ob.comboBox_1.getSelectedIndex()==18)
		{
		ob.btn00.setBackground(Color.decode("#0D1C31"));
		ob.btn01.setBackground(Color.decode("#0D1C31"));
		ob.btn02.setBackground(Color.decode("#0D1C31"));
		ob.btn10.setBackground(Color.decode("#0D1C31"));
		ob.btn11.setBackground(Color.decode("#0D1C31"));
		ob.btn12.setBackground(Color.decode("#0D1C31"));
		ob.btn20.setBackground(Color.decode("#0D1C31"));
		ob.btn21.setBackground(Color.decode("#0D1C31"));
		ob.btn22.setBackground(Color.decode("#0D1C31"));
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==19)
		{
		ob.btn00.setBackground(Color.decode("#5A1E52"));
		ob.btn01.setBackground(Color.decode("#5A1E52"));
		ob.btn02.setBackground(Color.decode("#5A1E52"));
		ob.btn10.setBackground(Color.decode("#5A1E52"));
		ob.btn11.setBackground(Color.decode("#5A1E52"));
		ob.btn12.setBackground(Color.decode("#5A1E52"));
		ob.btn20.setBackground(Color.decode("#5A1E52"));
		ob.btn21.setBackground(Color.decode("#5A1E52"));
		ob.btn22.setBackground(Color.decode("#5A1E52"));
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==20)
		{
		ob.btn00.setBackground(Color.BLACK);
		ob.btn01.setBackground(Color.BLACK);
		ob.btn02.setBackground(Color.BLACK);
		ob.btn10.setBackground(Color.BLACK);
		ob.btn11.setBackground(Color.BLACK);
		ob.btn12.setBackground(Color.BLACK);
		ob.btn20.setBackground(Color.BLACK);
		ob.btn21.setBackground(Color.BLACK);
		ob.btn22.setBackground(Color.BLACK);
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==21)
		{
		ob.btn00.setBackground(Color.BLACK);
		ob.btn01.setBackground(Color.BLACK);
		ob.btn02.setBackground(Color.BLACK);
		ob.btn10.setBackground(Color.BLACK);
		ob.btn11.setBackground(Color.BLACK);
		ob.btn12.setBackground(Color.BLACK);
		ob.btn20.setBackground(Color.BLACK);
		ob.btn21.setBackground(Color.BLACK);
		ob.btn22.setBackground(Color.BLACK);
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==22)
		{
			int r0=(int )(255*Math.random());
			int g0=(int )(255*Math.random());
			int b0=(int )(255*Math.random());
		ob.btn00.setBackground(new Color(r0,g0,b0));
		int r1=(int )(255*Math.random());
		int g1=(int )(255*Math.random());
		int b1=(int )(255*Math.random());
		ob.btn01.setBackground(new Color(r1,g1,b1));
		int r2=(int )(255*Math.random());
		int g2=(int )(255*Math.random());
		int b2=(int )(255*Math.random());
		ob.btn02.setBackground(new Color(r2,g2,b2));
		int r3=(int )(255*Math.random());
		int g3=(int )(255*Math.random());
		int b3=(int )(255*Math.random());
		ob.btn10.setBackground(new Color(r3,g3,b3));
		int r4=(int )(255*Math.random());
		int g4=(int )(255*Math.random());
		int b4=(int )(255*Math.random());
		ob.btn11.setBackground(new Color(r4,g4,b4));
		int r5=(int )(255*Math.random());
		int g5=(int )(255*Math.random());
		int b5=(int )(255*Math.random());
		ob.btn12.setBackground(new Color(r5,g5,b5));
		int r6=(int )(255*Math.random());
		int g6=(int )(255*Math.random());
		int b6=(int )(255*Math.random());
		ob.btn20.setBackground(new Color(r6,g6,b6));
		int r7=(int )(255*Math.random());
		int g7=(int )(255*Math.random());
		int b7=(int )(255*Math.random());
		ob.btn21.setBackground(new Color(r7,g7,b7));
		int r8=(int )(255*Math.random());
		int g8=(int )(255*Math.random());
		int b8=(int )(255*Math.random());
		ob.btn22.setBackground(new Color(r8,g8,b8));
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==23)
		{
		ob.btn00.setBackground(Color.decode("#9FA507"));
		ob.btn01.setBackground(Color.decode("#9FA507"));
		ob.btn02.setBackground(Color.decode("#9FA507"));
		ob.btn10.setBackground(Color.decode("#9FA507"));
		ob.btn11.setBackground(Color.decode("#9FA507"));
		ob.btn12.setBackground(Color.decode("#9FA507"));
		ob.btn20.setBackground(Color.decode("#9FA507"));
		ob.btn21.setBackground(Color.decode("#9FA507"));
		ob.btn22.setBackground(Color.decode("#9FA507"));
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==24)
		{
		ob.btn00.setBackground(Color.decode("#FB4D28"));
		ob.btn01.setBackground(Color.decode("#FB4D28"));
		ob.btn02.setBackground(Color.decode("#FB4D28"));
		ob.btn10.setBackground(Color.decode("#FB4D28"));
		ob.btn11.setBackground(Color.decode("#FB4D28"));
		ob.btn12.setBackground(Color.decode("#FB4D28"));
		ob.btn20.setBackground(Color.decode("#FB4D28"));
		ob.btn21.setBackground(Color.decode("#FB4D28"));
		ob.btn22.setBackground(Color.decode("#FB4D28"));
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==25)
		{
		ob.btn00.setBackground(Color.BLACK);
		ob.btn01.setBackground(Color.BLACK);
		ob.btn02.setBackground(Color.BLACK);
		ob.btn10.setBackground(Color.BLACK);
		ob.btn11.setBackground(Color.BLACK);
		ob.btn12.setBackground(Color.BLACK);
		ob.btn20.setBackground(Color.BLACK);
		ob.btn21.setBackground(Color.BLACK);
		ob.btn22.setBackground(Color.BLACK);
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==26)
		{
		ob.btn00.setBackground(Color.BLACK);
		ob.btn01.setBackground(Color.BLACK);
		ob.btn02.setBackground(Color.BLACK);
		ob.btn10.setBackground(Color.BLACK);
		ob.btn11.setBackground(Color.BLACK);
		ob.btn12.setBackground(Color.BLACK);
		ob.btn20.setBackground(Color.BLACK);
		ob.btn21.setBackground(Color.BLACK);
		ob.btn22.setBackground(Color.BLACK);
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==27)
		{

			int r0=(int )(255*Math.random());
			int g0=(int )(255*Math.random());
			int b0=(int )(255*Math.random());
		ob.btn00.setBackground(new Color(r0,g0,b0));
		int r1=(int )(255*Math.random());
		int g1=(int )(255*Math.random());
		int b1=(int )(255*Math.random());
		ob.btn01.setBackground(new Color(r1,g1,b1));
		int r2=(int )(255*Math.random());
		int g2=(int )(255*Math.random());
		int b2=(int )(255*Math.random());
		ob.btn02.setBackground(new Color(r2,g2,b2));
		int r3=(int )(255*Math.random());
		int g3=(int )(255*Math.random());
		int b3=(int )(255*Math.random());
		ob.btn10.setBackground(new Color(r3,g3,b3));
		int r4=(int )(255*Math.random());
		int g4=(int )(255*Math.random());
		int b4=(int )(255*Math.random());
		ob.btn11.setBackground(new Color(r4,g4,b4));
		int r5=(int )(255*Math.random());
		int g5=(int )(255*Math.random());
		int b5=(int )(255*Math.random());
		ob.btn12.setBackground(new Color(r5,g5,b5));
		int r6=(int )(255*Math.random());
		int g6=(int )(255*Math.random());
		int b6=(int )(255*Math.random());
		ob.btn20.setBackground(new Color(r6,g6,b6));
		int r7=(int )(255*Math.random());
		int g7=(int )(255*Math.random());
		int b7=(int )(255*Math.random());
		ob.btn21.setBackground(new Color(r7,g7,b7));
		int r8=(int )(255*Math.random());
		int g8=(int )(255*Math.random());
		int b8=(int )(255*Math.random());
		ob.btn22.setBackground(new Color(r8,g8,b8));
		maintheme();
		}
		if(ob.comboBox_1.getSelectedIndex()==28)
		{
		ob.btn00.setBackground(Color.BLACK);
		ob.btn01.setBackground(Color.BLACK);
		ob.btn02.setBackground(Color.BLACK);
		ob.btn10.setBackground(Color.BLACK);
		ob.btn11.setBackground(Color.BLACK);
		ob.btn12.setBackground(Color.BLACK);
		ob.btn20.setBackground(Color.BLACK);
		ob.btn21.setBackground(Color.BLACK);
		ob.btn22.setBackground(Color.BLACK);
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==29)
		{
		ob.btn00.setBackground(Color.decode("#BB2B60"));
		ob.btn01.setBackground(Color.decode("#BB2B60"));
		ob.btn02.setBackground(Color.decode("#BB2B60"));
		ob.btn10.setBackground(Color.decode("#BB2B60"));
		ob.btn11.setBackground(Color.decode("#BB2B60"));
		ob.btn12.setBackground(Color.decode("#BB2B60"));
		ob.btn20.setBackground(Color.decode("#BB2B60"));
		ob.btn21.setBackground(Color.decode("#BB2B60"));
		ob.btn22.setBackground(Color.decode("#BB2B60"));
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==30)
		{
		ob.btn00.setBackground(Color.decode("#2AA19B"));
		ob.btn01.setBackground(Color.decode("#2AA19B"));
		ob.btn02.setBackground(Color.decode("#2AA19B"));
		ob.btn10.setBackground(Color.decode("#2AA19B"));
		ob.btn11.setBackground(Color.decode("#2AA19B"));
		ob.btn12.setBackground(Color.decode("#2AA19B"));
		ob.btn20.setBackground(Color.decode("#2AA19B"));
		ob.btn21.setBackground(Color.decode("#2AA19B"));
		ob.btn22.setBackground(Color.decode("#2AA19B"));
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==31)
		{
		ob.btn00.setBackground(Color.decode("#B2D614"));
		ob.btn01.setBackground(Color.decode("#B2D614"));
		ob.btn02.setBackground(Color.decode("#B2D614"));
		ob.btn10.setBackground(Color.decode("#B2D614"));
		ob.btn11.setBackground(Color.decode("#B2D614"));
		ob.btn12.setBackground(Color.decode("#B2D614"));
		ob.btn20.setBackground(Color.decode("#B2D614"));
		ob.btn21.setBackground(Color.decode("#B2D614"));
		ob.btn22.setBackground(Color.decode("#B2D614"));
		defaultfontcolor();
		}
		if(ob.comboBox_1.getSelectedIndex()==32)
		{
		ob.btn00.setBackground(Color.BLACK);
		ob.btn01.setBackground(Color.BLACK);
		ob.btn02.setBackground(Color.BLACK);
		ob.btn10.setBackground(Color.BLACK);
		ob.btn11.setBackground(Color.BLACK);
		ob.btn12.setBackground(Color.BLACK);
		ob.btn20.setBackground(Color.BLACK);
		ob.btn21.setBackground(Color.BLACK);
		ob.btn22.setBackground(Color.BLACK);
		maintheme();
		}
		if(ob.comboBox_1.getSelectedIndex()==33)
		{
		ob.btn00.setBackground(Color.BLACK);
		ob.btn01.setBackground(Color.BLACK);
		ob.btn02.setBackground(Color.BLACK);
		ob.btn10.setBackground(Color.BLACK);
		ob.btn11.setBackground(Color.BLACK);
		ob.btn12.setBackground(Color.BLACK);
		ob.btn20.setBackground(Color.BLACK);
		ob.btn21.setBackground(Color.BLACK);
		ob.btn22.setBackground(Color.BLACK);
		defaultfontcolor();
		}
		
	}
	void defaultfontcolor()
	{
		ob.lbllivea.setForeground(Color.black);
		ob.lblliveb.setForeground(Color.black);
		ob.lblUserA.setForeground(Color.black);
		ob.lblUserB.setForeground(Color.black);
		ob.lblNewLabel.setForeground(Color.black);
		ob.lblTimerLabel.setForeground(Color.black);
		ob.lblB.setForeground(Color.black);
		ob.rbabtnX.setForeground(Color.black);
		ob.rbbbtnX.setForeground(Color.black);
		ob.rbabtnO.setForeground(Color.black);
		ob.rbbbtnO.setForeground(Color.black);
		ob.lblNewLabel_2.setForeground(Color.BLACK);
	}
	void maintheme()
	{
		ob.lbllivea.setForeground(Color.GREEN);
		ob.lblliveb.setForeground(Color.GREEN);
		ob.lblUserA.setForeground(Color.GREEN);
		ob.lblUserB.setForeground(Color.GREEN);
		ob.lblNewLabel.setForeground(Color.GREEN);
		ob.lblTimerLabel.setForeground(Color.GREEN);
		ob.lblB.setForeground(Color.GREEN);
		ob.rbabtnX.setForeground(Color.GREEN);
		ob.rbbbtnX.setForeground(Color.GREEN);
		ob.rbabtnO.setForeground(Color.GREEN);
		ob.rbbbtnO.setForeground(Color.GREEN);
		ob.lblNewLabel_2.setForeground(Color.white);
	}
	

}
