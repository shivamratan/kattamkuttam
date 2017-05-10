package ttt;

public class resetstaticvar 
{
	void resetstatic()
	{
		
		//tictacto.java
		 tictacto.toss=false;
		 tictacto.bot=false;
		 tictacto.btna=0;
		 tictacto.btnb=0;
		 tictacto.ua=null;
		 tictacto.ub=null;
		 tictacto.chance=0;
		 tictacto.livea=0;
			tictacto.liveb=0;
			tictacto.c=null;
			tictacto.gear=0;
			tictacto.comboBox=null;
			tictacto.total=0;
			tictacto.timepergame=0;
			tictacto.soundvolume=0.0f;
			tictacto.progressBar_1=null;
			tictacto.txtrThinkingSkill=null;
			tictacto.consolestr=null;
			tictacto.bootflag=false;
			tictacto.scoreindex=null;
			tictacto.gameno=0;
			tictacto.btndisturb=false;
			tictacto.topgearconsole=false;
			tictacto.lblt_3=null;
			tictacto.thread1=null;
			tictacto.cl=null;
		//	tictacto.frame=null;
			//totaltime1 class
			totaltime1.i=0;
			totaltime1.suspendflag=false;
			//newgamebtnthread class
			newgamebtnthread.newgmbtnthread=null;
			//timecalci class
			timecalci.apptime=null;
			timecalci.time=null;
			//beginningtossthread class
			beginningtossthread.tossthread=null;
			
			//tictacto.java
			
			//botchance.java
			botchance.randomchance=0;
			botchance.minimaxchance=0;
			
			//heuristic.java
			heuristic.a=heuristic.a1;
			//highscore.java
			highscore.label_14=null;
			highscore.label_24=null;
			highscore.label_34=null;
			highscore.label_44=null;
			highscore.label_54=null;
			highscore.label_64=null;
			highscore.label_74=null;
			highscore.label_84=null;
			highscore.label_94=null;
			highscore.label_104=null;
			highscore.a=null;
			//highscore.highscore=null;
				//newgame.java
			newgame.usertype=null;
			newgame.botboot=false;
				//sound.java
			sound.clip=null;
			sound.clip1=null;
			sound.clip11=null;
			sound.clip13=null;
			sound.clip3=null;
			sound.clip5=null;
			sound.clip8=null;
				//splash.java
			splash.progressBar=null;
			splash.lblLoadingTictactoe=null;
			splash.frame=null;
				//themecontrol.java
			themecontrol.c=0;
			themecontrol.m=0;
			themecontrol.num=0;
				//winblink.java
			winblink.loopflag=false;
			tictacto.object=null;
			tictacto.settingpan=null;
			tictacto.sbt=null;
			tictacto.alwayson=null;
			tictacto.tt1=null;
			tictacto.mp=null;
			tictacto.winb=null;
	}
	void stopallthread()
	{
		tictacto.thread1.stop();
		tictacto.cl.th.stop();
		tictacto.object.tossblinkthread.stop();
		tictacto.settingpan.settingtheme.stop();
		tictacto.sbt.borderthread.stop();
		tictacto.alwayson.t.stop();
		tictacto.tt1.totaltime.stop();
		tictacto.mp.mail1.stop();
		sound.clip.stop();
		tictacto.winb.t3.stop();
		
	}
}
