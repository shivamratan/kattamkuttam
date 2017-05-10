package ttt;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import com.sun.javafx.tk.Toolkit;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class sound 
{
	InputStream in;
//	static AudioStream audioStream;
	static Clip clip;
	static Clip clip1;
	static Clip clip3;
	static Clip clip8;
	static Clip clip11;
	static Clip clip5;
	static Clip clip13;
	public void playtheme()
	{
		 try
		 {
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("musictheme.wav"));
        clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(tictacto.soundvolume);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	}
	public void playbackground(int i)
	{
		String music[]={"musictheme.wav","bgmusic1.wav","bgmusic2.wav","bgmusic3.wav","breeze.wav","Electric.wav","mirage.wav","streetboy.wav","oceanwind.wav"};
	try
		{
		/*
	 String gongFile = "3.mp3";
	    in = new FileInputStream(gongFile);
	   // Clip clip = AudioSystem.getClip();
	    // create an audiostream from the inputstream
	    audioStream = new AudioStream(in);
	   // AudioData data = audioStream.getData();
	   //ContinuousAudioDataStream cas = new ContinuousAudioDataStream (data);
	    // play the audio clip with the audioplayer class
	    AudioPlayer.player.start(audioStream);*/
	    
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(music[i]));
        clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(tictacto.soundvolume);
        
      // System.out.println(tictacto.soundvolume);
       // Thread.sleep(300); // looping as long as this thread is alive
      
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void userawin()
	{
		
		 try
		 {
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("userwin.wav"));
        clip3 = AudioSystem.getClip();
        clip3.open(inputStream);
        clip3.loop(2);
        FloatControl gainControl = (FloatControl) clip3.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(tictacto.soundvolume);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
        
	}
	public void userbwin()
	{
		Clip clip4;
		 try
		 {
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("userwin.wav"));
        clip4 = AudioSystem.getClip();
        clip4.open(inputStream);
        clip4.loop(0);
        FloatControl gainControl = (FloatControl) clip4.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(tictacto.soundvolume);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	}
	public void userlose()
	{
		 try
		 {
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("userloses.wav"));
        clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(tictacto.soundvolume);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	}
	public void user()
	{
		 try
		 {
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("userloses.wav"));
        clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(tictacto.soundvolume);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	}
	public void chance(int i)
	{
		Clip clip2;
		String s[]={"userachance.wav","userachance.wav","robochance.wav"};
		 try
		 {
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(s[i]));
        clip2 = AudioSystem.getClip();
        clip2.open(inputStream);
        clip2.loop(0);
        FloatControl gainControl = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(tictacto.soundvolume);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	}
	public void draw()
	{
		
		 try
		 {
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("draw.wav"));
        clip5 = AudioSystem.getClip();
        clip5.open(inputStream);
        clip5.loop(clip5.LOOP_CONTINUOUSLY);
        FloatControl gainControl = (FloatControl) clip5.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(tictacto.soundvolume);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	}
	public void finalwinning()
	{
		
		 try
		 {
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("userfinalwinning.wav"));
        clip13 = AudioSystem.getClip();
        clip13.open(inputStream);
        clip13.loop(Clip.LOOP_CONTINUOUSLY);
        FloatControl gainControl = (FloatControl) clip13.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(tictacto.soundvolume);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	}
	public void tie()
	{

		 try
		 {
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("ties.wav"));
       clip = AudioSystem.getClip();
       clip.open(inputStream);
       clip.loop(Clip.LOOP_CONTINUOUSLY);
       FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl.setValue(tictacto.soundvolume);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	}
	public void botdraw()
	{
		
		 try
		 {
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("userfinalloses.wav"));
       clip11 = AudioSystem.getClip();
       clip11.open(inputStream);
       clip11.loop(Clip.LOOP_CONTINUOUSLY);
       FloatControl gainControl = (FloatControl) clip11.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl.setValue(tictacto.soundvolume);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	}
	public void btnclick()
	{
		
		 try
		 {
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("buttonclick.wav"));
       clip1 = AudioSystem.getClip();
       clip1.open(inputStream);
       clip1.loop(0);
       FloatControl gainControl1 = (FloatControl) sound.clip1.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl1.setValue(tictacto.soundvolume-15.0f);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	}
	public void botwin()
	{

		
		 try
		 {
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("botwin.wav"));
        clip8 = AudioSystem.getClip();
        clip8.open(inputStream);
        clip8.loop(Clip.LOOP_CONTINUOUSLY);
        FloatControl gainControl = (FloatControl) clip8.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(tictacto.soundvolume);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	}
	public void buzzer()
	{
		
		 try
		 {
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("buzzer.wav"));
        clip3 = AudioSystem.getClip();
        clip3.open(inputStream);
        clip3.loop(0);
        FloatControl gainControl = (FloatControl) clip3.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(tictacto.soundvolume);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
        
	}
}
