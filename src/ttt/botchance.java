package ttt;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Point 
{

    int x, y;

    public Point(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() 
    {
        return "[" + x + ", " + y + "]";
    }
}

class PointsAndScores 
{

    int score;
    Point point;

    PointsAndScores(int score, Point point) 
    {
        this.score = score;
        this.point = point;
    }
}

class Board 
{

    List<Point> availablePoints;
    Scanner scan = new Scanner(System.in);
    int[][] board = new int[3][3]; 

    List<PointsAndScores> rootsChildrenScore = new ArrayList<>();

    public int evaluateBoard() 
    {
        int score = 0;

        //Check all rows
        for (int i = 0; i < 3; ++i) 
        {
            int blank = 0;
            int X = 0;
            int O = 0;
            for (int j = 0; j < 3; ++j) 
            {
                if (board[i][j] == 0) 
                {
                    blank++;
                } 
                else if (board[i][j] == 1) 
                {
                    X++;
                } 
                else 
                {
                    O++;
                }

            } 
            score+=changeInScore(X, O); 
        }

        //Check all columns
        for (int j = 0; j < 3; ++j) 
        {
            int blank = 0;
            int X = 0;
            int O = 0;
            for (int i = 0; i < 3; ++i) 
            {
                if (board[i][j] == 0) 
                {
                    blank++;
                } 
                else if (board[i][j] == 1) 
                {
                    X++;
                } 
                else 
                {
                    O++;
                } 
            }
            score+=changeInScore(X, O);
        }

        int blank = 0;
        int X = 0;
        int O = 0;

        //Check diagonal (first)
        for (int i = 0, j = 0; i < 3; ++i, ++j) 
        {
            if (board[i][j] == 1) 
            {
                X++;
            } 
            else if (board[i][j] == 2) 
            {
                O++;
            } 
            else 
            {
                blank++;
            }
        }

        score+=changeInScore(X, O);

        blank = 0;
        X = 0;
        O = 0;

        //Check Diagonal (Second)
        for (int i = 2, j = 0; i > -1; --i, ++j) 
        {
            if (board[i][j] == 1) 
            {
                X++;
            } 
            else if (board[i][j] == 2) 
            {
                O++;
            }
            else 
            {
                blank++;
            }
        }

        score+=changeInScore(X, O);

        return score;
    }
    private int changeInScore(int X, int O)
    {
        int change;
        if (X == 3) 
        {
            change = 100;
        } 
        else if (X == 2 && O == 0) 
        {
            change = 10;
        } 
        else if (X == 1 && O == 0) 
        {
            change = 1;
        } 
        else if (O == 3) 
        {
            change = -100;
        } 
        else if (O == 2 && X == 0) 
        {
            change = -10;
        } 
        else if (O == 1 && X == 0) 
        {
            change = -1;
        } 
        else 
        {
            change = 0;
        } 
        return change;
    }
    
    
    
    public int alphaBetaMinimax(int alpha, int beta, int depth, int turn)
    {
    	//System.out.println("reaching to  algorithm");
    	//System.out.println("reporting sir");
        
        if(beta<=alpha)
        { 
        	System.out.println("Pruning at depth = "+depth);
        	if(turn == 1)
        		return Integer.MAX_VALUE;
        	else 
        		return Integer.MIN_VALUE; 
        }
        
       // System.out.println("reporting sir [200]");
        if(depth ==tictacto.gear || isGameOver())
        {
        	System.out.println("terminating at gear level "+tictacto.gear);
        	//System.out.println("reaching to last point of branch");
        	//System.out.println(isGameOver());
        	//System.out.println(depth+" "+tictacto.gear);
        	//System.out.println(depth==tictacto.gear);
        	return evaluateBoard();
        }
      //  System.out.println("reporting sir[203]");
        List<Point> pointsAvailable = getAvailableStates();
        for(int j=0;j<pointsAvailable.size();j++)
        {
        	//System.out.println("reaching points available");
        	System.out.println(pointsAvailable.get(j).x+" "+pointsAvailable.get(j).y);
        }
        
        if(pointsAvailable.isEmpty())
        {
        	//System.out.println("reporting error sir[211]");
        	return 0;
        }
        
        if(depth==0) 
        	rootsChildrenScore.clear(); 
        
        int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
        
        for(int i=0;i<pointsAvailable.size(); ++i)
        {
        	//System.out.println("reaching to minimax loop");
            Point point = pointsAvailable.get(i);
            
            int currentScore = 0;
            
            if(turn == 1)
            {
                placeAMove(point, 1); 
                currentScore = alphaBetaMinimax(alpha, beta, depth+1, 2);
                maxValue = Math.max(maxValue, currentScore); 
                
                //Set alpha
                alpha = Math.max(currentScore, alpha);
                
                if(depth == 0)
                    rootsChildrenScore.add(new PointsAndScores(currentScore, point)); 
            }
            else if(turn == 2)
            {
                placeAMove(point, 2);
                currentScore = alphaBetaMinimax(alpha, beta, depth+1, 1); 
                minValue = Math.min(minValue, currentScore);
                
                //Set beta
                beta = Math.min(currentScore, beta);
            }
            //reset board
            board[point.x][point.y] = 0; 
            
            //If a pruning has been done, don't evaluate the rest of the sibling states
            if(currentScore == Integer.MAX_VALUE || currentScore == Integer.MIN_VALUE) 
            	break;
        }
        return turn == 1 ? maxValue : minValue;
    }  

    public boolean isGameOver() 
    {
        //Game is over is someone has won, or board is full (draw)
        return (hasXWon() || hasOWon() || getAvailableStates().isEmpty());
    }

    public boolean hasXWon() 
    {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 1) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 1)) 
        {
            //System.out.println("X Diagonal Win");
            return true;
        }
        for (int i = 0; i < 3; ++i) 
        {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 1)
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 1))) 
            {
                // System.out.println("X Row or Column win");
                return true;
            }
        }
        return false;
    }

    public boolean hasOWon() {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 2) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 2)) 
        {
            // System.out.println("O Diagonal Win");
            return true;
        }
        for (int i = 0; i < 3; ++i) 
        {
            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 2)
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 2)) 
            {
                //  System.out.println("O Row or Column win");
                return true;
            }
        }

        return false;
    }
  
    public List<Point> getAvailableStates() 
    {
    	//System.out.println("reaching to available states");
        availablePoints = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) 
            {
                if (board[i][j] == 0) 
                {
                	//System.out.println("ok sir reporting...[getAvailableStates]");
                    availablePoints.add(new Point(i, j));
                }
            }
        }
        return availablePoints;
    }

    public void placeAMove(Point point, int player) 
    {
        board[point.x][point.y] = player;   //player = 1 for X, 2 for O
    }

    public Point returnBestMove() 
    {
    	
        int MAX = -100000;
        int best = -1;
        
    
        for (int i = 0; i < rootsChildrenScore.size(); ++i) 
        {
            if (MAX < rootsChildrenScore.get(i).score) 
            {
                MAX = rootsChildrenScore.get(i).score;
                best = i;
            }
        }
          
        return rootsChildrenScore.get(best).point;
     
    }

 
    public void displayBoard() {
        System.out.println();

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();

        }
    } 
  
  
}


public class botchance 
{
	static int randomchance=0;
	static int minimaxchance=0;
	int enabled;
	int xwin,ywin;
	int fill[]=new int[9];
	Random rand1=new Random();
	List<Point> emptypoint=new ArrayList<>();
	List<PointsAndScores> emptypointnum = new ArrayList<>();
	//tictacto t;
    void play(tictacto m) 
    { 
    	
        Board b = new Board();
         int c=0;
        for (int i = 0; i < 3; ++i) 
        {
            for (int j = 0; j < 3; ++j) 
            {
                b.board[i][j]=0;
                
            }
        }
       
         
        if(!(m.btn00.isEnabled()))
        {
      	  if(m.btn00.getText().equals(m.icona))
      			  {
      		        b.board[0][0]=2;
      		        
      			  }
      	  else
      	  {
      		  b.board[0][0]=1;
      	  }
      	  c++;
        }
        if(!m.btn01.isEnabled())
        {
        	if(m.btn01.getText().equals(m.icona))
			  {
		        b.board[0][1]=2;
			  }
	  else
	  {
		  b.board[0][1]=1;
	  }
      	  c++;
        }
        if(!m.btn02.isEnabled())
        {
        	if(m.btn02.getText().equals(m.icona))
			  {
		        b.board[0][2]=2;
			  }
	  else
	  {
		  b.board[0][2]=1;
	  }
        	c++;
        }
        if(!m.btn10.isEnabled())
        {
        	if(m.btn10.getText().equals(m.icona))
			  {
		        b.board[1][0]=2;
			  }
	  else
	  {
		  b.board[1][0]=1;
	  }
        	c++;
        }
        if(!m.btn11.isEnabled())
        {
        	if(m.btn11.getText().equals(m.icona))
			  {
		        b.board[1][1]=2;
			  }
	  else
	  {
		  b.board[1][1]=1;
	  }
        	c++;
        }
        if(!m.btn12.isEnabled())
        {
        	if(m.btn12.getText().equals(m.icona))
			  {
		        b.board[1][2]=2;
			  }
	  else
	  {
		  b.board[1][2]=1;
	  }
        	c++;
        }
        if(!m.btn20.isEnabled())
        {
        	if(m.btn20.getText().equals(m.icona))
			  {
		        b.board[2][0]=2;
			  }
	  else
	  {
		  b.board[2][0]=1;
	  }
        	c++;
        }
        if(!m.btn21.isEnabled())
        {
        	if(m.btn21.getText().equals(m.icona))
			  {
		        b.board[2][1]=2;
			  }
	  else
	  {
		  b.board[2][1]=1;
	  }
        	c++;
        }
        if(!m.btn22.isEnabled())
        {
        	if(m.btn22.getText().equals(m.icona))
			  {
		        b.board[2][2]=2;
			  }
	  else
	  {
		  b.board[2][2]=1;
	  }
        	c++;
        }	  
        
        
        
      //strategy for different levels  
      
         if(tictacto.gear==10)//applying random algorithm or "easy level"
        {
        	btnenabled(m);
        	int t=rand1.nextInt((enabled));
        	randomchance++; 
            int index=emptypointnum.get(t).score;
   		  Point p1=emptypoint.get(index);
   		    xwin=p1.x;
   		    ywin=p1.y;
        	
        }
        else if(tictacto.gear==11) //applying heuristic algorithm or "medium level"
            {
            	System.out.println("reaching to heuristic");
            	heuristic h=new heuristic();
            	
            	int botheuristic=h.easylevelbot(this,b);
            	
            	switch(botheuristic)
            	{
            	case 0:
            		xwin=0;
            		ywin=0;
            	   break;
            	case 1:
            		xwin=0;
            		ywin=1;
            	   break;
            	case 2:
            		xwin=0;
            		ywin=2;
            	   break;
            	case 3:
            		xwin=1;
            		ywin=0;
            	   break;
            	case 4:
            		xwin=1;
            		ywin=1;
            	   break;
            	case 5:
            		xwin=1;
            		ywin=2;
            	   break;
            	case 6:
            		xwin=2;
            		ywin=0;
            	   break;
            	case 7:
            		xwin=2;
            		ywin=1;
            	   break;
            	case 8:
            		xwin=2;
            		ywin=2;
            	   break;
            	 default:
            		 System.out.println("There is some fault in heuristic algorithm");
            	}
            }
        else if(tictacto.gear==2)
        {
        	btnenabled(m);
        	//System.out.println("the enabled buttons are "+enabled);
        	int t=rand1.nextInt((enabled));
        	//int k=enabled;
        	//System.out.println("The buttons enabled are "+enabled+" and the value of t is :"+t);
        	if(t<((int)(enabled)/2))
        	{
        	    randomchance++; 
                 int index=emptypointnum.get(t).score;
        		  Point p1=emptypoint.get(index);
        		  xwin=p1.x;
        		  ywin=p1.y;
        		//  System.out.println(xwin+" "+ywin);
        	}
        	else
        	{
        		minimaxchance++;
        b.alphaBetaMinimax(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 1);

       for (PointsAndScores pas : b.rootsChildrenScore) 
            System.out.println("Point: " + pas.point + " Score: " + pas.score);
      b.displayBoard();
        Point pwin=b.returnBestMove();
         xwin=pwin.x;
         ywin=pwin.y;   
          // System.out.println("the best move is   "+xwin+" "+ywin);
           //System.out.println("The total button's disabled are"+c);
        	}
        }
            else if(tictacto.gear==7)// apply minimax +randomisation algorithm  "or hard level"
            {
            	
            	btnenabled(m);
            	//System.out.println("the enabled buttons are "+enabled);
            	int t=rand1.nextInt((enabled));
            	//int k=enabled;
            	//System.out.println("The buttons enabled are "+enabled+" and the value of t is :"+t);
            	if(t<((int)(enabled)/3))
            	{
            	    randomchance++; 
                     int index=emptypointnum.get(t).score;
            		  Point p1=emptypoint.get(index);
            		  xwin=p1.x;
            		  ywin=p1.y;
            		//  System.out.println(xwin+" "+ywin);
            	}
            	else
            	{
            		minimaxchance++;
            b.alphaBetaMinimax(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 1);
   
           for (PointsAndScores pas : b.rootsChildrenScore) 
                System.out.println("Point: " + pas.point + " Score: " + pas.score);
          b.displayBoard();
            Point pwin=b.returnBestMove();
             xwin=pwin.x;
             ywin=pwin.y;   
              // System.out.println("the best move is   "+xwin+" "+ywin);
               //System.out.println("The total button's disabled are"+c);
            	}
            }  
            else  //applying complete minimax algorithm for very hard level
            {
            	b.alphaBetaMinimax(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 1);
            	  Point pwin=b.returnBestMove();
                  xwin=pwin.x;
                  ywin=pwin.y;
            }
            
            //condition for setting of next turn of bot
                  if(xwin==0&&ywin==0)
                  {
                	  m.btn00.setForeground(Color.RED);
                	  m.btn00.setText(m.iconb);
                	  m.btn00.setEnabled(false);
                  }
                  else if(xwin==0&&ywin==1)
                  {
                	  m.btn01.setForeground(Color.RED);
                	  m.btn01.setText(m.iconb);
                	  m.btn01.setEnabled(false);
                  }
                  else if(xwin==0&&ywin==2)
                  {
                	  m.btn02.setForeground(Color.RED);
                	  m.btn02.setText(m.iconb);
                	  m.btn02.setEnabled(false);
                  }
                  else if(xwin==1&&ywin==0)
                  {
                	  m.btn10.setForeground(Color.RED);
                	  m.btn10.setText(m.iconb);
                	  m.btn10.setEnabled(false);
                  }
                  else if(xwin==1&&ywin==1)
                  {
                	  m.btn11.setForeground(Color.RED);
                	  m.btn11.setText(m.iconb);
                	  m.btn11.setEnabled(false);
                  }
                  else if(xwin==1&&ywin==2)
                  {
                	  m.btn12.setForeground(Color.RED);
                	  m.btn12.setText(m.iconb);
                	  m.btn12.setEnabled(false);
                  }
                  else if(xwin==2&&ywin==0)
                  {
                	  m.btn20.setForeground(Color.RED);
                	  m.btn20.setText(m.iconb);
                	  m.btn20.setEnabled(false);
                  }
                  else if(xwin==2&&ywin==1)
                  {
                	  m.btn21.setForeground(Color.RED);
                	  m.btn21.setText(m.iconb);
                	  m.btn21.setEnabled(false);
                  }
                  else if(xwin==2&&ywin==2)
                  {
                	  m.btn22.setForeground(Color.RED);
                	  m.btn22.setText(m.iconb);
                	  m.btn22.setEnabled(false);
                  }
                  
        
    }
    void btnenabled(tictacto u)
    {
    	
    	if(u.btn00.isEnabled())
    	{
    		
    		emptypoint.add(new Point(0,0));
    	    Point p1=emptypoint.get(enabled);
    		emptypointnum.add(new PointsAndScores(enabled,p1));
    		enabled++;
    	}
    	if(u.btn01.isEnabled())
    	{
    	  
    		emptypoint.add(new Point(0,1));
    		 Point p1=emptypoint.get(enabled);
     		emptypointnum.add(new PointsAndScores(enabled,p1));
     		 enabled++;
    	}
    	if(u.btn02.isEnabled())
    	{
    		
    		emptypoint.add(new Point(0,2));
    		 Point p1=emptypoint.get(enabled);
     		emptypointnum.add(new PointsAndScores(enabled,p1));
     		 enabled++;
    	}
    	if(u.btn10.isEnabled())
    	{
    		
    		emptypoint.add(new Point(1,0));
    		 Point p1=emptypoint.get(enabled);
     		emptypointnum.add(new PointsAndScores(enabled,p1));
     		 enabled++;
    	}
    	if(u.btn11.isEnabled())
    	{
    		
    		emptypoint.add(new Point(1,1));
    		 Point p1=emptypoint.get(enabled);
     		emptypointnum.add(new PointsAndScores(enabled,p1));
     		 enabled++;
    	}
    	if(u.btn12.isEnabled())
    	{
    		
    		emptypoint.add(new Point(1,2));
    		 Point p1=emptypoint.get(enabled);
     		emptypointnum.add(new PointsAndScores(enabled,p1));
     		 enabled++;
    	}
    	if(u.btn20.isEnabled())
    	{
    		
    		emptypoint.add(new Point(2,0));
    		 Point p1=emptypoint.get(enabled);
     		emptypointnum.add(new PointsAndScores(enabled,p1));
     		 enabled++;
    		
    	}
    	if(u.btn21.isEnabled())
    	{
    		
    		emptypoint.add(new Point(2,1));
    		 Point p1=emptypoint.get(enabled);
     		emptypointnum.add(new PointsAndScores(enabled,p1));
     		 enabled++;
    	}
    	if(u.btn22.isEnabled())
    	{
    		
    		emptypoint.add(new Point(2,2));
    		 Point p1=emptypoint.get(enabled);
     		emptypointnum.add(new PointsAndScores(enabled,p1));
     		 enabled++;
    	}
    	
    }
   
    
   /* Point randomthrow()
    {
    	List<Point> enabledpoint=new ArrayList<>();
    	if(t.btn00.isEnabled())
    	{
    		enabledpoint.add(new Point(0,0));
    		
    	}
    	else if(t.btn01.isEnabled())
    	{
    		enabledpoint.add(new Point(0,1));
    		
    	}
    	else if(t.btn02.isEnabled())
    	{
    		enabledpoint.add(new Point(0,2));
    		
    	}
    	else if(t.btn10.isEnabled())
    	{
    		enabledpoint.add(new Point(1,0));
    	}
    	else if(t.btn11.isEnabled())
    	{
    		enabledpoint.add(new Point(1,1));
    	}
    	else if(t.btn12.isEnabled())
    	{
    		enabledpoint.add(new Point(1,2));
    	}
    	else if(t.btn20.isEnabled())
    	{
    		enabledpoint.add(new Point(2,0));
    	}
    	else if(t.btn21.isEnabled())
    	{
    		enabledpoint.add(new Point(2,1));
    	}
    	else if(t.btn22.isEnabled())
    	{
    		enabledpoint.add(new Point(2,2));
    	}
    	Point p=enabledpoint.get(0);
    	return p;
    }
    */
}