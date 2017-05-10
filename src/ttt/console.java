package ttt;

public class console implements Runnable
{
	Thread th;
	String s_old;
	boolean idletime=false;
	public console()
	{
		th=new Thread(this,"consolethread");
		th.start();
	}
    
	public void run()
	{
		int var=0;
		while(true)
		{
			//System.out.println("executing main console thread");
			if(!tictacto.consolestr.equals(tictacto.txtrThinkingSkill.getText()))
			{
				//System.out.println(tictacto.consolestr.equals(tictacto.txtrThinkingSkill.getText()));
				//System.out.println("var is howing zero");
				
				s_old=tictacto.txtrThinkingSkill.getText();
				String s_new=tictacto.consolestr;
				int min=s_old.length();
				int max=s_new.length();
				
				if(idletime)   //not predefined for higher digit number
					min-=2;
				
		      for(int i=min;i<max;i++)
		       {
		    	  var=0;
		    	  s_old+=s_new.charAt(i);
		            tictacto.txtrThinkingSkill.setText(s_old);
		           tictacto.txtrThinkingSkill.setCaretPosition(tictacto.txtrThinkingSkill.getDocument().getLength());
		           if(tictacto.topgearconsole)
		           {
		        	   try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		           }
		           else if(tictacto.btndisturb)
		           {
		        	   try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		           }
		           else if(tictacto.bootflag||newgame.botboot)
		            {
		            	try {
				            Thread.sleep(5);
			                 } catch (InterruptedException e) {
				              // TODO Auto-generated catch block
				              e.printStackTrace();
			                 }
		            	
		            }
		            else
		            {
	             	try {
			            Thread.sleep(20);
		                 } catch (InterruptedException e) {
			              // TODO Auto-generated catch block
			              e.printStackTrace();
		                 }
		            }
		        }
		      tictacto.btndisturb=false;
		      tictacto.bootflag=false;
		      tictacto.topgearconsole=false;
				newgame.botboot=false;
			}
			
				var++;
				//System.out.println("The value is"+var);
					if(var>80)
					{
			//System.out.println("executing idletime thread");
						idletime id=new idletime(this);
						try {
							id.idlethread.join();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					//System.out.println("console thread executing");
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
class idletime implements Runnable
{
	 Thread idlethread;
	console ob;
	public idletime(console c)
	{
		ob=c;
		idlethread=new Thread(this,"idlethread");
		idlethread.start();
	}
	
	@Override
	public void run() 
	{
		String temp;
		//System.out.println("in the run method of idletime");
		//System.out.println(tictacto.consolestr.equals(ob.s_old));
		//;System.out.println("the consolethread is alive or not?"+ob.th.isAlive());
		int n=0;
		tictacto.consolestr+="\n\n##Waiting for your response";
		String localstr=tictacto.consolestr;
	//System.out.println(tictacto.consolestr.equals(ob.s_old));
		while(tictacto.consolestr.equals(localstr))
		{
			//System.out.println("in the while loop of console string ");
		
			tictacto.txtrThinkingSkill.setText(tictacto.consolestr+": "+n);
			tictacto.txtrThinkingSkill.setCaretPosition(tictacto.txtrThinkingSkill.getDocument().getLength());
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ob.idletime=true;
		
	
		
	}
	
}

