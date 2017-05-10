package ttt;


public class heuristic
{
int i,j,ii,jj,x,y,yesnull; 
static int a[][]={{10,1,2,3,11},{10,1,4,7,11},{10,1,5,9,11},{10,2,5,8,11},
                {10,3,5,7,11},{10,3,6,9,11},{10,4,5,6,11},{10,7,8,9,11} };
static int a1[][]={{10,1,2,3,11},{10,1,4,7,11},{10,1,5,9,11},{10,2,5,8,11},
                {10,3,5,7,11},{10,3,6,9,11},{10,4,5,6,11},{10,7,8,9,11} };
				
boolean set;
int newboard[]=new int[9];
int finalchance;




public  void check(int num1)
{
for(ii=0;ii<=7;ii++)
{
   for(jj=1;jj<=3;jj++)
   {
        if(a[ii][jj]==num1)
          { 
            a[ii][4]=11; 
           }

   }

  }
}



public int complogic(int num)
{
	int temp=-1;

 for(i=0;i<=7;i++)
 {
   for(j=1;j<=3;j++)
   {
      if(a[i][j]==num+1)
        { 
         a[i][0]=11; 
         a[i][4]=10;   
         }
	  }
  }
 
   for(i=0;i<=7;i++)
   {                                // for 1
     set=true;  		   
      if(a[i][4]==10)
     {                                 //if 1 
       int count=0;
       for(j=1;j<=3;j++)
       {                                                //for 2 
           if(newboard[(a[i][j]-1)]!=0)
           {                               //if 2
             count++;
               }                                                                   //eof if 2
            else
              {
               yesnull=a[i][j]; 
             }
        }                                                                         //eof for 2
          if(count==2)
          {                                                        //if 2
        
         this.check(yesnull);
          set=false;
          temp=(yesnull-1);
           }                                                                     //eof if 2
      }                                                                     //eof if 1
      else if(a[i][0]==10)
      {
                for(j=1;j<=3;j++)
                {                                            //for2
                    if(newboard[(a[i][j]-1)]==0)
                    { 
                    	 this.check(a[i][j]);
                         set=false;
                      temp=(a[i][j]-1);
                       
						           
                    }                                                    //eof if1
                } 
                                                                             //eof for 2
                if(set==false)
                      break; 

            }

    if(set==false)
         break;    
 }
   return temp;

}



public int easylevelbot(botchance b,Board m)
{
	System.out.println("reaching inside the heuristic");
	int z=0;
	set=true;
       for(int d=0;d<3;d++)
       {
    	   for(int e=0;e<3;e++)
    	   {
    		   newboard[z]=m.board[d][e];
    		   z++;
    	   }
       } 
    		   
        
     
            for(i=0;i<=8;i++)
            {
              
                  if(newboard[i]==0)
                  { 
                        // m.displayBoard();
                            if(newboard[4]==0)
                            {
						                
							                this.check(5);
							                finalchance=4;
							                break;
							               }
                              else
                              {
						                finalchance=this.complogic(i);
						                break;
								             }
                    }
                 
             }
          System.out.println("the final chance is"+finalchance);
          return finalchance;  
        }
   public static void resetheuristic()
   {
	   for(int i=0;i<7;i++)
	   {
		   for(int j=0;j<4;j++)
		   {
			   a[i][j]=a1[i][j];
		   }
	   }
   }




}













