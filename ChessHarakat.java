
import java.util.Scanner;
import java.util.function.BiConsumer;


public class ChessHarakat{

    public static void toString(int res[])
    {
    for (int x : res)
    System.out.println(x);
    }

    public static class Mohre{
        
        public char type , color;
        public Mohre(){

        }
        public Mohre(char color , char type ){

            this.color=color;
            this.type=type;
            
        }
        public String toString()
        {
            return color + "" +type;
        }
        static int c1 , c2 , n1 , n2;
        public static void place(String s)
        {
            c1 = s.charAt(0) - 'A';
            c2 = s.charAt(2) - 'A';
            n1 = s.charAt(1) - '0';
            n2 = s.charAt(3) - '0';
        }
       
    }
    public static void main (String [ ] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Mohre [][]board = new Mohre[9][9];
        String s;
        int np , cp;
        for (int i=0 ; i<n ; i++)
        {
           s=in.next();
           char color = s.charAt(0);
           char type  = s.charAt(1);
           int nplace = s.charAt(3) - '0';
           int cplace = s.charAt(2) -'A';
          
           board[nplace][cplace] = new Mohre(color , type );

        }
        n = in.nextInt();
        int res[] = new int [n];
    for (int i=0 ; i<n ; i++)
     {
        s=in.next();
        np=s.charAt(1) - '0';
        cp=s.charAt(0) - 'A';
        char type = board[np][cp].type;
        char color = board[np][cp].color;
        int count=0;
       
        if ( type == 'P' )
        {
            if( color == 'W' )
            {
               
                if (np +1 <= 8 )
                {
                    if (board[np+1][cp] == null )
                    count++;
                }
                if (np + 1 <= 8 && cp +1 <= 7 )
                {
                    if (board[np+1][cp+1] != null && board[np+1][cp+1].color != board[np][cp].color )
                    count++;
                }
                if ( np + 1 <= 8 && cp - 1 >= 0 )
                {

                    if (board[np+1][cp-1] != null && board[np+1][cp-1].color != board[np][cp].color )
                    count++;
                }
                if (np == 2 )
                {
                    if ( board[np+1][cp ] == null && board[np+2][cp] == null )
                    count++;
                    if ( np + 2 <= 8 && cp+2 <= 7)
                    {
                    if (board[np+2][cp+2] != null && board[np+2][cp+2].color != board[np][cp].color  )
                    count++;
                    }
                    if (np +2 <= 8 && cp-2 >= 0)
                    {
                        if (board[np+2][cp+2] != null && board[np+2][cp-2].color != board[np][cp].color )
                        count++;
                    }
                }
                
            }
            if (color == 'B' )
            {
                
                if ( np - 1 >= 1 )
                {
                    if (board[np-1][cp] == null )
                    count++;
                }
                if ( np -1 >=1 && cp + 1 <= 7 )
                {
                    if (board[np-1][cp+1] != null && board[np-1][cp+1].color != board[np][cp].color )
                    count ++;
                }
                if ( np - 1 >= 1 && cp - 1 >= 0 )
                {
                    if (board[np-1][cp-1] != null && board[np-1][cp-1].color != board[np][cp].color )
                    count++;
                }

                if ( np == 7 )
                {
                    if (board[np-2][cp] == null && board[np-1][cp] == null )
                    count++;

                    if ( cp + 2 <= 7 )
                    {
                        if (board[np-2][cp+2] != null && board[np-2][cp+2].color != board[np][cp].color )
                        count++;
                    }
                    if ( cp -2 >= 0 )
                    {
                        if (board[np-2][cp-2] != null && board[np-2][cp-2].color != board[np][cp].color )
                        count++;
                    }
                }
               
            }
           
        }
        if ( type == 'R' )
        {
            // move lft horiz
            for (int p=0 , l=0 ; p < cp ; p++ , l--)
            {
                if (board[np][cp-1+l] == null )
                count++;
                else
                {
                    if (board[np][cp-1+l].color != board[np][cp].color )
                    count++;
                    break;
                }
            }
            // move horiz rihht
            for (int p=1 ; p<= 7 - cp ; p++ )
            {
                if (board[np][cp+p] == null )
                count++;
                else
                {
                    if (board[np][cp+p].color != board[np][cp].color )
                    count++;
                    break;
                }
            }
            // move up 
            for (int p=1 ; p<= 8 - np ; p++)
            {
                if (board[np+p][cp] == null)
                count++;
                else
                {
                    if (board[np+p][cp].color != board[np][cp ].color )
                    count++;
                    break;
                }
            }
            // move down 
            for (int p=0 ,l=0; p < np-1 ; p++, l--)
            {
                if (board[np-1+l][cp] == null )
                count++;
                else
                {
                    if (board[np-1+l][cp].color != board[np][cp].color )
                    count++;
                    break;
                }
            }

        }

        if (  type == 'B' )
        { //

            // up right
            for (int p=1 ; cp + p <= 7 && np +p <= 8 ; p++)
            {
                if (board[np+p][cp+p] == null )
               count++;
               else
               {
                if (board[np+p][cp+p].color != board[np][cp].color )
                {
                    count++; 
                }
                break;
               }
            }
            // down right
            for (int p=1 ,l=-1 ; cp+p <= 7 && np + l >= 1 ; p++ , l--)
            {
                if (board[np+l][cp+p] == null)
                count++;
                else
                {
                    if (board[np+l][cp+p].color != board[np][cp].color )
                    count++;
                    break;

                }
            }
           
            
        
        // left up 
        for(int p=1 , l =-1 ; cp + l >= 0 && np + p <= 8 ; p++ , l-- )
        {
            if(board[np+p][cp+l] == null )
            count++;
            else
            {
                if(board[np+p][cp+l].color != board[np][cp].color )
                count++;
                break;
            }

        }
        // left doen
        for (int  l=-1 ; cp + l >= 0 && np +l >= 1 ; l-- )
        {
            if (board[np+l][cp+l] == null )
                    count++;
                    else
                    {
                        if (board[np+l][cp+l].color != board[np][cp].color )
                        count++;
                        break;
                    }
        }
        
        }
    
    
    
        if (type == 'N')
        {
           // right
            if ( cp+2 <= 7) 
            {
                if (np-1 >= 1)
                {
                if (board[np-1][cp+2] == null )
                count++;
                else
                {
                    if (board[np-1][cp+2].color != board[np][cp].color )
                    count++;
                }
                }
                if ( np +1 <= 8)
                {
                    if (board[np+1][cp+2] == null )
                count++;
                else
                {
                    if (board[np+1][cp+2].color != board[np][cp].color )
                    count++;
                }
                }

                

            }
            // move left
            if ( cp -2 >= 0)
            {
                // down
                if (np - 1 >= 1)
                {
                if (board[np-1][cp-2] == null )
                count++;
                else
                {
                    if (board[np-1][cp-2].color != board[np][cp].color )
                    count++;
                }
                }
                // up
                if ( np + 1 <= 8)
                {
                
                        if (board[np+1][cp-2] == null )
                        count++;
                        else
                        {
                            if (board[np+1][cp-2].color != board[np][cp].color )
                            count++;
                        }
                }
            }
            // down vertcal
            if ( np - 2 >= 1 )
            {
                // left
                if ( cp -1 >= 0) 
                {
                    if (board[np-2][cp-1] == null )
                    count++;
                    else
                    {
                        if (board[np-2][cp-1].color != board[np][cp].color )
                        count++;
                    }
                }
                // right
                if (cp+1 <= 7 )
                {
                    if (board[np-2 ][cp+1] == null )
                    count++;
                    else
                    {
                        if(board[np-2 ][cp+1].color != board[np][cp].color )
                        count++;
                    }
                }
            }
            // up 
            if (np+2 <= 8 )
            {
                // left
                if (cp-1 >= 0 )
                {
                    if(board[np+2][cp-1] == null )
                    count++;
                    else
                    {
                        if (board[np+2][cp-1].color != board[np][cp].color )
                        count++;
                    }
                }
                // right
                if ( cp+1 <= 7 )
                {
                    if (board[np+2][cp+1] == null )
                    count++;
                    else
                    {
                        if (board[np+2][cp+1].color != board[np][cp].color )
                        count++;
                    }
                }
            }
        }

        if ( type == 'Q')
       
        {
        // from bishop
        // up right 
        for (int p=1 ; cp + p <= 7 && np +p <= 8 ; p++)
        {
            if (board[np+p][cp+p] == null )
           count++;
           else
           {
            if (board[np+p][cp+p].color != board[np][cp].color )
            {
                count++; 
            }
            break;
           }
        }
        // down right
        for (int p=1 ,l=-1 ; cp+p <= 7 && np + l >= 1 ; p++ , l--)
        {
            if (board[np+l][cp+p] == null)
            count++;
            else
            {
                if (board[np+l][cp+p].color != board[np][cp].color )
                count++;
                break;

            }
        }
       
        
    
    // left up 
    for(int p=1 , l =-1 ; cp + l >= 0 && np + p <= 8 ; p++ , l-- )
    {
        if(board[np+p][cp+l] == null )
        count++;
        else
        {
            if(board[np+p][cp+l].color != board[np][cp].color )
            count++;
            break;
        }

    }
    // left doen
    for (int  l=-1 ; cp + l >= 0 && np +l >= 1 ; l-- )
    {
        if (board[np+l][cp+l] == null )
                count++;
                else
                {
                    if (board[np+l][cp+l].color != board[np][cp].color )
                    count++;
                    break;
                }
    }
        //from bishop till here 


        // form rock
        // move lft horiz
        for (int p=0 , l=0 ; p < cp ; p++ , l--)
        {
            if (board[np][cp-1+l] == null )
            count++;
            else
            {
                if (board[np][cp-1+l].color != board[np][cp].color )
                count++;
                break;
            }
        }
        // move horiz rihht
        for (int p=0 ; p< 7 - cp ; p++ )
        {
            if (board[np][cp+1+p] == null )
            count++;
            else
            {
                if (board[np][cp+1+p].color != board[np][cp ].color )
                count++;
                break;
            }
        }
        // move up 
        for (int p=0 ; p< 8 - np ; p++)
        {
            if (board[np+1+p][cp] == null)
            count++;
            else
            {
                if (board[np+1+p][cp].color != board[np][cp ].color )
                count++;
                break;
            }
        }
        // move down 
        for (int p=0 ,l=0; p < np -1  ; p++, l--)
        {
            if (board[np-1+l][cp] == null )
            count++;
            else
            {
                if (board[np-1+l][cp].color != board[np][cp].color )
                count++;
                break;
            }
        }
        // till here rock 
       
    
    
    
    }
        if ( type == 'K' )
        {
            // move down 
           if ( np - 1 >= 1 )
           {
            if (board[np-1][cp] == null )
            count++;
            else
            {
                if (board[np-1][cp].color != board[np][cp].color )
                count++;
            }
            if (cp + 1 <= 7 )
            {
                if (board[np-1][cp+1] == null )
                count++;
                else
                {
                    if (board[np-1][cp+1].color != board[np][cp].color )
                    count++;
                }
            }
            if ( cp -1 >= 0)
            {
                if (board[np-1][cp-1] == null )
                count++;
                else
                {
                    if (board[np-1][cp-1].color != board[np][cp].color )
                    count++;
                }
            }
            // move up 
            if (np + 1 <= 8)
            {
                if (board[np+1][cp] == null )
            count++;
            else
            {
                if (board[np+1][cp].color != board[np][cp].color )
                count++;
            }
            if (cp + 1 <= 7 )
            {
                if (board[np+1][cp+1] == null )
                count++;
                else
                {
                    if (board[np+1][cp+1].color != board[np][cp].color )
                    count++;
                }
            }
            if ( cp -1 >= 0)
            {
                if (board[np+1][cp-1] == null )
                count++;
                else
                {
                    if (board[np+1][cp-1].color != board[np][cp].color )
                    count++;
                }
            }

           }
           // move right left -  horiz 
           if (cp+1 <= 7 )
           {
            if (board[np][cp+1] == null )
            count++;
            else{
                if (board[np][cp+1].color != board[np][cp].color )
                count++;
            }
           }
           if ( cp -1 >= 0 )
           {
            if (board[np][cp-1] == null )
            count++;
            else{
                if (board[np][cp-1].color != board[np][cp].color )
                count++;
            }
           }

           
        }
    }
    
    res[i]=count;
     }

     toString(res);

    }
    
}