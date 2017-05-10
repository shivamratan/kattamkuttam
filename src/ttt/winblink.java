package ttt;

public class winblink implements Runnable
{
	Thread t3;
	tictacto ob;
	String icon;
	static boolean loopflag=false;
	public winblink(tictacto i) 
	{
		ob=i;
		t3=new Thread(this,"winblinkthread");
		t3.start();
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			System.out.println("winblink thread executing  PLEASE PLEASE!!!!!!");
			//System.out.println("outer loop executing ");
		int condition=0;
		int c=0;
		
			if(((ob.btn00.getText().equals(ob.icona)&&ob.btn01.getText().equals(ob.icona)&&ob.btn02.getText().equals(ob.icona)))||
					(ob.btn00.getText().equals(ob.iconb)&&ob.btn01.getText().equals(ob.iconb)&&ob.btn02.getText().equals(ob.iconb)))
			{
				if((!ob.btn00.isEnabled()&&!ob.btn01.isEnabled()&&!ob.btn02.isEnabled()))
				{
				//1
				condition=1;
				loopflag=true;
				if((ob.btn00.getText().equals(ob.icona)&&ob.btn01.getText().equals(ob.icona)&&ob.btn02.getText().equals(ob.icona)))
				    icon=ob.icona;
				else
					icon=ob.iconb;
				}
			}
			else if((ob.btn10.getText().equals(ob.icona)&&ob.btn11.getText().equals(ob.icona)&&ob.btn12.getText().equals(ob.icona))||
					(ob.btn10.getText().equals(ob.iconb)&&ob.btn11.getText().equals(ob.iconb)&&ob.btn12.getText().equals(ob.iconb)))
			{
				if((!ob.btn10.isEnabled()&&!ob.btn11.isEnabled()&&!ob.btn12.isEnabled()))
				{
				//2
				condition=2;
				loopflag=true;
				if((ob.btn10.getText().equals(ob.icona)&&ob.btn11.getText().equals(ob.icona)&&ob.btn12.getText().equals(ob.icona)))
					icon=ob.icona;
				else
					icon=ob.iconb;
				}
			}
			else if((ob.btn20.getText().equals(ob.icona)&&ob.btn21.getText().equals(ob.icona)&&ob.btn22.getText().equals(ob.icona))||
					(ob.btn20.getText().equals(ob.iconb)&&ob.btn21.getText().equals(ob.iconb)&&ob.btn22.getText().equals(ob.iconb)))
			{
				if((!ob.btn20.isEnabled()&&!ob.btn21.isEnabled()&&!ob.btn22.isEnabled()))
				{
				//3
				condition=3;
				loopflag=true;
				if((ob.btn20.getText().equals(ob.icona)&&ob.btn21.getText().equals(ob.icona)&&ob.btn22.getText().equals(ob.icona)))
					icon=ob.icona;
				else
					icon=ob.iconb;
				}
			}
			else if((ob.btn00.getText().equals(ob.icona)&&ob.btn10.getText().equals(ob.icona)&&ob.btn20.getText().equals(ob.icona))||
					(ob.btn00.getText().equals(ob.iconb)&&ob.btn10.getText().equals(ob.iconb)&&ob.btn20.getText().equals(ob.iconb)))
			{
				if((!ob.btn00.isEnabled()&&!ob.btn10.isEnabled()&&!ob.btn20.isEnabled()))
				{
					//4
				condition=4;
				loopflag=true;
				if((ob.btn00.getText().equals(ob.icona)&&ob.btn10.getText().equals(ob.icona)&&ob.btn20.getText().equals(ob.icona)))
					icon=ob.icona;
				else
					icon=ob.iconb;
				}
			}
			else if((ob.btn01.getText().equals(ob.icona)&&ob.btn11.getText().equals(ob.icona)&&ob.btn21.getText().equals(ob.icona))||
					(ob.btn01.getText().equals(ob.iconb)&&ob.btn11.getText().equals(ob.iconb)&&ob.btn21.getText().equals(ob.iconb)))
			{
				if((!ob.btn01.isEnabled()&&!ob.btn11.isEnabled()&&!ob.btn21.isEnabled()))
				
				{//5
				condition=5;
				loopflag=true;
				if((ob.btn01.getText().equals(ob.icona)&&ob.btn11.getText().equals(ob.icona)&&ob.btn21.getText().equals(ob.icona)))
					icon=ob.icona;
				else
					icon=ob.iconb;
				}
			}
			else if((ob.btn02.getText().equals(ob.icona)&&ob.btn12.getText().equals(ob.icona)&&ob.btn22.getText().equals(ob.icona))||
					(ob.btn02.getText().equals(ob.iconb)&&ob.btn12.getText().equals(ob.iconb)&&ob.btn22.getText().equals(ob.iconb)))
			{
				if((!ob.btn02.isEnabled()&&!ob.btn12.isEnabled()&&!ob.btn22.isEnabled()))
				{
				//6
				condition=6;
				loopflag=true;
				if((ob.btn02.getText().equals(ob.icona)&&ob.btn12.getText().equals(ob.icona)&&ob.btn22.getText().equals(ob.icona)))
					icon=ob.icona;
				else
					icon=ob.iconb;
				}
			}
			else if((ob.btn00.getText().equals(ob.icona)&&ob.btn11.getText().equals(ob.icona)&&ob.btn22.getText().equals(ob.icona))||
					(ob.btn00.getText().equals(ob.iconb)&&ob.btn11.getText().equals(ob.iconb)&&ob.btn22.getText().equals(ob.iconb)))
			{
				if((!ob.btn00.isEnabled()&&!ob.btn11.isEnabled()&&!ob.btn22.isEnabled()))			
				{//7
				condition=7;
				loopflag=true;
				if((ob.btn00.getText().equals(ob.icona)&&ob.btn11.getText().equals(ob.icona)&&ob.btn22.getText().equals(ob.icona)))
					icon=ob.icona;
				else
					icon=ob.iconb;
				}
			}
			else if((ob.btn20.getText().equals(ob.icona)&&ob.btn11.getText().equals(ob.icona)&&ob.btn02.getText().equals(ob.icona))||
					(ob.btn20.getText().equals(ob.iconb)&&ob.btn11.getText().equals(ob.iconb)&&ob.btn02.getText().equals(ob.iconb)))
			{
				if((!ob.btn20.isEnabled()&&!ob.btn11.isEnabled()&&!ob.btn02.isEnabled()))
				{
					//8
				condition=8;
				loopflag=true;
				if((ob.btn20.getText().equals(ob.icona)&&ob.btn11.getText().equals(ob.icona)&&ob.btn02.getText().equals(ob.icona)))
					icon=ob.icona;
				else
					icon=ob.iconb;
				}
			}
			while(loopflag)
			{
				System.out.println(" PLEASE PLEASE!!!!!! inner loop executing ....");
				switch(condition)
				{
				case 1:
					
					if(c%2==0)
					{
						ob.btn00.setText(" ");
						ob.btn01.setText(" ");
						ob.btn02.setText(" ");
					}
					else
					{
						ob.btn00.setText(icon);
						ob.btn01.setText(icon);
						ob.btn02.setText(icon);
					}
					break;
				case 2:
					if(c%2==0)
					{
						ob.btn10.setText(" ");
						ob.btn11.setText(" ");
						ob.btn12.setText(" ");
					}
					else
					{
						ob.btn10.setText(icon);
						ob.btn11.setText(icon);
						ob.btn12.setText(icon);
					}
					break;
				case 3:
					if(c%2==0)
					{
						ob.btn20.setText(" ");
						ob.btn21.setText(" ");
						ob.btn22.setText(" ");
					}
					else
					{
						ob.btn20.setText(icon);
						ob.btn21.setText(icon);
						ob.btn22.setText(icon);
					}
					break;
				case 4:
					if(c%2==0)
					{
						ob.btn00.setText(" ");
						ob.btn10.setText(" ");
						ob.btn20.setText(" ");
					}
					else
					{
						ob.btn00.setText(icon);
						ob.btn10.setText(icon);
						ob.btn20.setText(icon);
					}
					break;
				case 5:
					if(c%2==0)
					{
						ob.btn01.setText(" ");
						ob.btn11.setText(" ");
						ob.btn21.setText(" ");
					}
					else
					{
						ob.btn01.setText(icon);
						ob.btn11.setText(icon);
						ob.btn21.setText(icon);
					}
					break;
				case 6:
					if(c%2==0)
					{
						ob.btn02.setText(" ");
						ob.btn12.setText(" ");
						ob.btn22.setText(" ");
					}
					else
					{
						ob.btn02.setText(icon);
						ob.btn12.setText(icon);
						ob.btn22.setText(icon);
					}
					break;
				case 7:
					if(c%2==0)
					{
						ob.btn00.setText(" ");
						ob.btn11.setText(" ");
						ob.btn22.setText(" ");
					}
					else
					{
						ob.btn00.setText(icon);
						ob.btn11.setText(icon);
						ob.btn22.setText(icon);
					}
					break;
				case 8:
					if(c%2==0)
					{
						ob.btn20.setText(" ");
						ob.btn11.setText(" ");
						ob.btn02.setText(" ");
					}
					else
					{
						ob.btn20.setText(icon);
						ob.btn11.setText(icon);
						ob.btn02.setText(icon);
					}
					break;
				
				}
				c++;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     }
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
