
import java.util.*;


// board [adad ] [E , A ...]
// 100 but knite has chess logical problem

public class Chess {
   
    public static void toString(String a[]){
        for (int i=0 ; i<a.length ; i++)
        System.out.println(a[i]);
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
    public static class Pawn extends Mohre{
        
       public static boolean moveW(String s ){
        place(s);
        
        
            if (n2-n1 == 1 && (c1 == c2 || c1 - c2 ==1 || c2 - c1 ==1 ))
            return true;

                if ( (n2-n1 == 2 && ( c1 == c2 || c1 - c2 ==2  ||  c2 - c1 ==2 )))
                if ( n1 == 2)
                return true;
                else return false ;
            
        
        return false;
    
        }
        public static boolean moveB(String s )
        {
            place(s);
           
            if ( n1 - n2 == 1 && ( c1==c2 || c2 - c1 == 1 || c1 - c2 == 1 ))
            return true;

            
                if ( n1 - n2 == 2 && ( c1 == c2 || c2 - c1 == 2 || c1 - c2  == 2 ) )
                {
                if ( n1 == 7 )
                return true;
                else
                return false;
                }

                return false;
        
        }
    }
    public static class Rock extends Mohre{

        public static boolean move (String s){
            place(s);
           if ( n2>= 9 || n1 <= 0 )
           return false ;
           return ( c2-c1== 0 || n2-n1== 0 ) ;
            
        }

    }
    public static class Knight extends Mohre{
        public static boolean move(String s){
            place(s);
            // gives no every time
             // if ( c2 > 'H' || c2<'A' || n1 > 8 || n1 < 0 )
             // return false;
            if(  ((n2-n1 == 2 || n1 - n2 ==2 ) && (c2 - c1 == 1 || c1 - c2 == 1 )) 
            || ((c2-c1==2 || c1 -c2 == 2) && (n2-n1 == 1 || n1-n2 == 1))  )
            return true ;
            else 
            return false;
    
            }
    }
// extend and use place to intilize c1 c2 n1 n2 
    public static class Bishop extends Mohre{
        public static boolean move(String s){

            place(s);
            if(n2-n1 == c2-c1 )
            return true;
            if (c2 - c1 == n2 - n1 || c1 - c2 == n1 - n2 || c1 - c2 == n2 - n1 || c2  - c1 == n1 - n2)
             return true ;
             else
             return false;
        }
    }

    public static class Queen extends Mohre{
        public static boolean move(String s){
            place(s);
            // straight
             if ( c2 - c1 == 0 || c1 - c2 == 0 || n2 - n1 == 0 || n1 - n2 == 0 )
             return true;
             // morabaei 
             /* 
             else if (n2 - n1 == 1 || n1 - n2 == 1 )
             return true;
             else if (c2 - c1 == 1 || c1 - c2 == 1 )
             return true;
             */
             // cross
             else if (c2 - c1 == n2 - n1 || c1 - c2 == n1 - n2 || c1 - c2 == n2 - n1 || c2  - c1 == n1 - n2)
             return true ;
             else
             return false;
     

        }
    }

    public static class King extends Mohre{
        public static boolean move(String s){
            place(s);
            if
            (
             (( n2 - n1 == 1 || n1 - n2 == 1) && c1 == c2 ) 
            || ((c1 - c2 == 1 || c2 - c1 == 1 ) && n1 == n2  ) 
            || ( (n2 - n1 == 1 && ( c2 - c1== 1 || c1 - c2 == 1) ) )
            || ( ( n1 - n2 == 1 && (c2 - c1 == 1  ||  c1-c2== 1 ) ))
            )
            return true;
            else return false;
        }

    }
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Mohre board[][] = new Mohre[9][9];
        String s;
        int c1 ;
        int c2 ;
        int  n1 ;
        int  n2 ;
        for (int i=0 ; i<n ; i++)
        {
            s = in.next();
           

           int horizantal = s.charAt(2)-'A';
           int vertical = s.charAt(3) -'0';
           board[vertical][horizantal] = new Mohre(s.charAt(0) , s.charAt(1));
        }
        // questions
        
        n = in.nextInt();
        
        String res[] = new String[n];
        for (int i=0 ; i<n ; i++)
{
            s = in.next();
            c1 = s.charAt(0) - 'A';
            c2 = s.charAt(2) - 'A';
            n1 = s.charAt(1) - '0';
            n2 = s.charAt(3) - '0';
            char type = board[n1][c1].type;
            char color = board[n1][c1].color;
// if Pawn
    if( type == 'P' )
        {
                if (color == 'W')
                {
                    if (Pawn.moveW( s ) == true)
                    {
                        if (n2 - n1 == 2)
                        {

                         if (c1 == c2 )
                         {
                            if (board[n1+1][c1] == null)
                            {
                                if(board[n2][c2] == null )
                                    res[i]="YES";
                                
                                else
                                res[i]="NO";
                            }
                            else
                            res[i]="NO";
                         }
                         if( c2 - c1 == 2)
                         {
                            if (board[n1+1 ][c1+1] == null )
                            {
                                if(board[n2][c2] == null)
                                    res[i]="NO";
                                
                                else
                                {
                                    if (board[n2][c2].color != board[n1][c1].color)
                                    res[i]="TAKE";
                                    else 
                                    res[i]="NO";
                                }
                            }
                            else
                            res[i]="NO";
                         }
                        if( c1 - c2 == 2){
                            if (board[n1+1][c1 - 1] == null )
                            {
                                if (board[n2][c2] == null)
                                    res[i]="NO";
                                
                                else
                                {
                                    if (board[n2][c2].color != board[n1][c1].color)
                                    res[i]="TAKE";
                                    else
                                    res[i]="NO";
                                }
                            }
                            else
                            res[i]="NO";
                        }
                        
                        }

                        if ( n2 - n1 == 1)
                        {
                            if ( c2 == c1 )
                            {
                            if (board[n2][c2] == null)
                            
                                res[i]="YES";
                            
                                else
                                res[i]="NO";
                            }
                            else if (Math.abs(c2-c1) == 1)
                            {
                                if (board[n2][c2] == null )
                                res[i]="NO";
                                else
                                {
                                    if (board[n2][c2].color != board[n1][c1].color )
                                    res[i]="TAKE";
                                    else
                                    res[i]="NO";
                                }
                            }
                        }
                    }
                    else
                    res[i]="NO";
                }

                if (color == 'B')
                {
                    if(Pawn.moveB( s ) == true)
                    {
                        if ( n1 - n2 == 2 )
                        {
                            if ( c1 == c2 )
                            {
                                if (board[n1-1][c1] == null)
                                {
                                    if ( board[n2][c2] == null)
                                    res[i]="YES";
                                    else
                                    res[i]="NO";
                                    
                                }
                                else
                                res[i]="NO";
                            }
                            else if ( c2 - c1 == 2)
                            {
                                if (board[n1-1][c1+1] == null)
                                {
                                    if (board[n2][c2] == null)
                                    res[i]="NO";
                                    else
                                    {
                                    if (board[n2][c2].color != board[n1][c1].color)
                                        res[i]="TAKE";
                                        else
                                        res[i]="NO";
                                    }

                                }
                                else
                                res[i]="NO";
                            } 
                        else if ( c1 - c2 == 2)
                        {
                            if (board[n1-1][c1-1] == null )
                            {
                                if ( board [n2][c2] == null)
                                {
                                    if (board[n2][c2] == null)
                                    res[i]="NO";
                                    else
                                    {
                                    if (board[n2][c2].color != board[n1][c1].color)
                                        res[i]="TAKE";
                                        else
                                        res[i]="NO";
                                    }
                                }
                                else
                                res[i]="NO";
                            }
                            else
                            res[i]="NO";
                        }
                        
                        }
                    if (n1-n2 == 1 )
                    {
                        if ( c2 == c1 )
                        {
                    if(board[n2][c2] == null)
                        res[i]="YES";
                    
                    else
                    {
                        res[i]="NO"; 
                    }
                    }
                    else
                    {
                        if (board[n2][c2] == null )
                        res[i]="NO";
                        else
                        {
                            if (board[n2][c2].color != board[n1][c1].color)
                            res[i]="TAKE";
                            else
                            res[i]="NO";
                        }
                    }
                   }
                    
                    }
                    else
                    res[i]="NO";
                }


            }
                       
//if Rock
    if ( type == 'R' )
        { 
                
            if ( Rock.move(s)== true )
            {
                int find=0;
                
                
                if ( c1 == c2 )
                {
               // to right side in vertical
                 if ( n2 > n1 )
                { 
                for(int p=0 ; p < n2-n1 -1 ; p++){
                    
                   if ( board[n1+1 + p ][c1] != null )
                   {
                    find=1;
                    res[i]="NO";
                    break;
                   }
                }
              
            
                if (find == 0){
                    // System.out.println( board[ s.charAt(3) -'0'][s.charAt(2)-'A'] );
            if ( board[ n2 ][c2] == null )
                    res[i]="YES";
                    else
                    {
                        if (board[n2][c2].color != board[n1][c1].color )
                            res[i]="TAKE";
                        else
                        res[i]="NO";
                    }
                }
            
            }
               else if ( n2 < n1){
                find =0;
                for (int p=0 , l=0 ; p< n1-n2 -1 ; p++ , l--){
                    if ( board[ n1 -1 + l ][ c1 ] != null )
                    {   find=1;
                        res[i]="NO";
                        break;
                    }
                }
                if (find == 0){
                    if (board[n2][ c2 ] == null )
                    res[i]="YES";
                    else 
                    {
                    if ( board[n1][c1].color != board[n2][c1].color ) 
                    res[i]="TAKE";
                    else 
                    res[i]="NO";
                    }
                }
            }


            }
                else if ( n1 == n2 )
            {
        
                 // right side
            if ( c2 > c1 )
            {
                find =0;
                for (int p=0 ; p< c2-c1 -1 ; p++){
                    if ( board[n1][ c1+1+ p] != null )
                    {   find=1;
                        res[i]="NO";
                        break;
                    }
                }
                if (find == 0){
                    if (board[n2][c2] == null )
                    res[i]="YES";
                    else 
                    {
                    if(board[n2][c2].color != board[n1][c1].color) 
                    res[i]="TAKE";
                    else
                    res[i]="NO";
                    }
                }
            }
            
            // left side move
            else if (c1 > c2 )
            {
                find=0;
               for (int p=0 , l=0 ; p < c1 - c2 -1 ; p++ , l-- ){
                if ( board[n1][ c1-1 + l ] != null )
                {
                    
                    find=1;
                    res[i]="NO";
                    break;
                }
               }
               
               if (find == 0){
                if ( board[n2][c2] == null )
                res[i]="YES";
                else 
                {
                if ( board[n2][c2].color != board[n1][c1].color )  
                res[i]="TAKE";
                else 
                res[i]="NO";
                }

               }
            }
 
            }
        } 
          
            else 
            res[i] ="NO";
    }

//

// if Knight
    if ( type == 'N')
        {
                if (Knight.move(s) == true)
                {
                    int find=0;
                    
                    // move up both left nd right 
                    if ( n2 - n1 == 2 )
                    {
                        // move up
                        for (int p=0 ; p< n2-n1 ; p++)
                        {
                            if (board[n1+1+p][c1] != null)
                            {
                                find=1;
                                res[i]="NO";
                                break;
                            }
                        }
                        if ( find == 0)
                        {
                            if(board[n2][c2] == null )
                            {
                                res[i]="YES";
                            }
                            else
                            {
                                if (board[n2][c2].color != board[n1][c1].color )
                                res[i]="TAKE";
                                else
                                res[i]="NO";
                            }
                        }
                          
                    }
                    // move down both left nd right
                    else if (n1 > n2 && n1 - n2 == 2 )
                    {
                        // move down 
                        for (int p=0 ,l=0; p< n1-n2 ; p++ , l--)
                        {
                            if (board[n1-1+l][c1] != null)
                            {
                                find=1;
                                res[i]="NO";
                                break;
                            }
                        }
                        if ( find == 0)
                        {
                            if(board[n2][c2] == null )
                            {
                                res[i]="YES";
                            }
                            else
                            {
                                if (board[n2][c2].color != board[n1][c1].color )
                                res[i]="TAKE";
                                else
                                res[i]="NO";
                            }
                        }
                    }
                    // move right - both up down
                    if ( c2 - c1 == 2 )
                    {
                        find=0;
                        if (board[n2][c1] != null )
                            {
                                find =1;
                                res[i]="NO";
                            }
                            if ( find == 0 )
                            {
                                for (int p=0 ; p<c2-c1-1 ; p++)
                                {
                                    if (board[n2][c1+1+p] != null )
                                    {
                                        res[i]="NO";
                                        find =1;
                                        break;
                                    }
                                }
                            }
                            if (find == 0)
                            {
                                if (board[n2][c2] == null )
                                    res[i]="YES";
                                else 
                                {
                                    if (board[n1][c1].color != board[n2][c2].color)
                                        res[i]="TAKE";
                                    
                                    else
                                    res[i]="NO";
                                } 
                            }
                    
                }
                // move left - both up down 
                    else if (c1 > c2 && c1 - c2 == 2)
                    {

                        if (board[n2][c1] != null )
                        {
                            find =1;
                            res[i]="NO";
                        }
                        if ( find == 0 )
                        {
                            for (int p=0 , l=0 ; p<c1-c2-1 ; p++ , l-- )
                            {
                                if (board[n2][c1-1+l] != null )
                                {
                                    res[i]="NO";
                                    find =1;
                                    break;
                                }
                            }
                        }
                        if (find == 0)
                        {
                            if (board[n2][c2] == null )
                                res[i]="YES";
                            else 
                            {
                                if (board[n1][c1].color != board[n2][c2].color)
                                    res[i]="TAKE";
                                
                                else
                                res[i]="NO";
                            } 
                        }
                    }
                }
                else if (Knight.move(s) == false )
                res[i]="NO";
            }
            

// if Bishop
    if ( type == 'B')
        {
                int find=0;
          if (Bishop.move(s) == true)
            {
                // cross up right
                if(c2 - c1 == n2 - n1 )
                {
                    for (int p=0 ; p<n2-n1 -1 ; p++)
                    {
                        if ( board[n1+1+p][c1+1+p] != null)
                        {
                            find=1;
                            res[i]="NO";
                            break;
                        }
                    }
                    if (find == 0)
                    {
                        if (board[n2][c2] == null)
                        res[i]="YES";
                        else
                        {
                            if (board[n2][c2].color != board[n1][c1].color)
                            {
                                res[i]="TAKE";
                            }
                            else
                            res[i]="NO";
                        }
                    }
                }
                // up left
                if (c1 > c2 && n2 > n1 && n2-n1 == c1 - c2)
                {
                for(int p=0 ,l=0; p <n2-n1-1 ; p++ , l--)
                {
                    if (board[n1 +1 +p][c1-1 + l] != null)
                    {
                        res[i]="NO";
                        find=1;
                        break;
                    } 
                }
                if ( find == 0 )
                {
                    if (find == 0)
                    {
                        if (board[n2][c2] == null)
                        res[i]="YES";
                        else
                        {
                            if (board[n2][c2].color != board[n1][c1].color)
                            {
                                res[i]="TAKE";
                            }
                            else
                            res[i]="NO";
                        }
                    }
                }
            }
                // down right
                if ( n1 > n2 && c2 > c1 && n1 - n2 == c2 - c1 )
                {
                    for ( int p=0 , l=0 ; p< c2 - c1 -1 ; p++ , l--)
                    {
                        if (board[n1-1+l][c1+1+p] != null)
                        {
                            find=1;
                            res[i]="NO";
                            break;
                        }
                    }

                    if (find == 0)
                    {
                        if (find == 0)
                    {
                        if (board[n2][c2] == null)
                        res[i]="YES";
                        else
                        {
                            if (board[n2][c2].color != board[n1][c1].color)
                            {
                                res[i]="TAKE";
                            }
                            else
                            res[i]="NO";
                        }
                    }
                    }
                } 
                // down left
                 if ( n1>n2 && c1 > c2 && n1 - n2 == c1 - c2 )
                 {
                    for (int p=0 , l=0 ; p<Math.abs(n1- n2 ) -1 ; p++ , l--)
                    {
                        if (board[n1-1+l][c1-1+l] != null ){
                            find=1;
                            res[i]="NO";
                            break;
                        }
                    }
                    
                        if (find == 0)
                    {
                        if (board[n2][c2] == null)
                        res[i]="YES";
                        else
                        {
                            if (board[n2][c2].color != board[n1][c1].color)
                            {
                                res[i]="TAKE";
                            }
                            else
                            res[i]="NO";
                        }
                    
                    }

            }
            }
            else if (Bishop.move(s) == false )
            res[i]="NO";

            }
        

// if Queen monde
    if (type == 'Q')
    {
            int find=0;
            // vertical
            if (Queen.move(s) == true)
            {

            
            if (c1 == c2)
            {
                   if ( n2 > n1 )
                   {

                    for (int p= 0 ; p < n2-n1-1 ; p++ )
                    {
                        if (board[n1 +1 +p][c1] != null )
                        {
                            find=1;
                            res[i]="NO";
                            break;

                        }
                    }
                    if (find == 0 ){
                        if (board[n2][c2 ] == null )
                        res[i]="YES";
                        else 
                        {
                            if(board[n2][c2] != null ){
                            if (board[n2][c2].color != board[n1][c1].color)
                            res[i]="TAKE";
                            else 
                            res[i]="NO";
                            }
                            else 
                            res[i]="YES";
                        }
                    }
                   }
                   else if (n2 < n1 )
                   {
                    find=0;
                    for (int p=0 , l=0 ; p< n1 - n2 -1 ; p++ , l--)
                    {
                        if (board[n1-1 +l ][c1] != null){
                            res[i]="NO";
                            find=1;
                            break;
                        }
                    }
                    if (find == 0){
                        if (board[n2][c2] != null ){
                        if(board[n2][c2].color != board[n1][c1].color){
                            res[i]="TAKE";
                        }
                        else{
                            res[i]="NO";
                        }
                    }
                    else
                    res[i]="YES";
                    }
                   }
            }
            //horiz
            else if ( n1 == n2 ){
                find =0 ;
                if ( c2 > c1 ){
                    for (int p=0 ; p < c2 - c1 -1 ; p++)
                    {
                        if (board[n1][c1 + 1 + p] != null)
                        {
                            find =1 ;
                            res[i]="NO";
                            break;
                        }
                    }
                    if ( find == 0 )
                    {
                        if ( board[n2][c2 ] != null ){
                            if (board[n2][c2].color != board[n1][c1].color )
                            res[i]="TAKE";
                            else 
                            res[i]="NO";
                        }
                        else
                        res[i]="YES";
                    }
                }
                else if ( c2 < c1 ){
                    find=0;
                    for (int p=0 , l=0 ; p<c1 - c2 -1 ; p++ , l--)
                    {
                        if (board[n1][c1 -1 + l] != null )
                        {
                            res[i]="NO";
                            find=1;
                            break;
                        }
                    }
                    if ( find == 0 ){
                        if ( board[n2][c2] != null ){
                            if (board[n2][c2].color != board[n1][c1].color)
                            res[i]="TAKE";
                            else
                            res[i]="NO";
                        }
                        else res[i]="YES";
                    }
                }
                

            }
            // cross  up right
            else if ( n2 > n1 && c2 > c1 && n2 - n1 == c2 - c1 ){
                find =0 ;
                for (int p=0 ; p < c2 - c1 -1 ; p++)
                {
                    if ( board[n1+1+p][c1+1+p] != null )
                    {
                        find=1;
                        res[i]="NO";
                        break;
                    }
                }
                if (find == 0){
                    if ( board[n2][c2] != null ){
                        if(board[n2][c2].color != board[n1][c1].color)
                        {
                            res[i]="TAKE";
                        }
                        else
                        res[i]="NO";
                        
                    }
                    else 
                    res[i]="YES";
                }

            }
            // cross down right
            if ( n1 > n2 && c2 > c1 && n1 - n2 == c2 - c1 ){
                find =0 ;
                for (int p=0 , l=0 ; p<c2-c1 -1 ; p++ , l--){
                    if (board[n1-1+l][c1+1+p] != null){
                        find=1;
                        res[i]="NO";
                        break;
                    }
                 }
                    if ( find == 0){
                        if (board[n2][c2] != null ){
                            if (board[n2][c2].color != board[n1][c1].color)
                            res[i]="TAKE";
                            else
                            res[i]="NO";
                        }
                        else 
                        res[i] = "YES";
                    }
                }

            

            // cross up left 

              // up left from mishop
              if ( n2 > n1 && c1 > c2 && n2-n1 == c1 - c2)
              {
              for(int p=0 ,l=0; p <n2-n1-1 ; p++ , l--)
              {
                  if (board[n1 +1 +p][c1-1 + l] != null)
                  {
                      res[i]="NO";
                      find=1;
                      break;
                  } 
              }
              if ( find == 0 )
              {
                  if (find == 0)
                  {
                      if (board[n2][c2] == null)
                      res[i]="YES";
                      else
                      {
                          if (board[n2][c2].color != board[n1][c1].color)
                          {
                              res[i]="TAKE";
                          }
                          else
                          res[i]="NO";
                      }
                  }
              }
          }



            // cross down left
            // 
             // down left from mishiop copy
             if (n1 > n2 && c1 > c2 && n1 - n2 == c1 - c2 )
             {
                for (int p=0 , l=0 ; p<Math.abs(n1- n2 ) -1 ; p++ , l--)
                {
                    if (board[n1-1+l][c1-1+l] != null ){
                        find=1;
                        res[i]="NO";
                        break;
                    }
                }
                
                    if (find == 0)
                {
                    if (board[n2][c2] == null)
                    res[i]="YES";
                    else
                    {
                        if (board[n2][c2].color != board[n1][c1].color)
                        {
                            res[i]="TAKE";
                        }
                        else
                        res[i]="NO";
                    }
                
                }


             }
            }
            else
            res[i]="NO";
   

   
   
    }

// if King 
    if (type == 'K')
    {
        if (King.move(s) )
        {
           if (board[n2][c2] == null )
           res[i]="YES";
           else
           {
            if (board[n2][c2].color != board[n1][c1].color)
            res[i]="TAKE";
            else
            res[i]="NO";
           }
        }
        else if (King.move(s)== false)
        
            res[i]="NO";
        
    }

}




// out of loope 



        toString(res);
        
        
    } 
    
}

