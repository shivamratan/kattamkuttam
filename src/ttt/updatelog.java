package ttt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class updatelog
{
	void updatelogs(String s)
	{
		
		try
		{		
		FileInputStream fin=new FileInputStream("log.txt");
		int temp;
		String s1="\n";
		while((temp=fin.read())!=-1)
		{
			s1+=(char)temp;
		}
		s1+=s+"\n";
		FileOutputStream fout=new FileOutputStream("log.txt");
		byte b[]=s1.getBytes();
		fout.write(b);
		fout.close();
		}
		catch(Exception e)
		{
			
		}
		
	}
	void updatebox(String s)
	{
		
		try
		{
			
		FileInputStream fin=new FileInputStream("log.txt");
		int temp;
		String s1="\n";
		while((temp=fin.read())!=-1)
		{
			s1+=(char)temp;
		}
		s1+=s+"\n";
		FileOutputStream fout=new FileOutputStream("log.txt");
		byte b[]=s1.getBytes();
		fout.write(b);
		fout.close();
		}
		catch(Exception e)
		{
			
		}
		
	}
	
}
