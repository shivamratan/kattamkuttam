package ttt;

import java.awt.image.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
public class Background
{
	BufferedImage image;
	private int x;
	private int y;
	public Background()
	{
		this(0,0);
	}
	public Background(int x,int y)
	{
		this.x=x;
		this.y=y;
		try
		{
		image=ImageIO.read(new File("back.png"));
		}catch(Exception e)
		{}
	}
	public void draw(Graphics window) 
	{
        	window.drawImage(image, getX(), getY(), image.getWidth(), image.getHeight(), null);
	        this.x -= 1;
	       if (this.x <= -1 * image.getWidth()) 
	       {
	            this.x = this.x + image.getWidth() * 2;
        	}
 
    	}	
	public void setX(int x)
	{
		this.x=x;
	}
	public int getX() 
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}
	public int getImageWidth()
	{
		return image.getWidth();
	}
	
}