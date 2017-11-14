
package simonsays;
import java.awt.*;
import java.util.ArrayList;

public class Board {
    private final static int NUM_CONNECT_WIN = 4;    
    

    public static int NUM_ROWS = 3;
    public static int NUM_COLUMNS = 3;      
    private static int NUM_CLICKS = 0;
    private static boolean gameOver = false;
    public static boolean resetBoard;
    
    private static ArrayList<Piece[]> PlayerBoard = new ArrayList<Piece[]>(); 
    private static ArrayList<boolean[]> Player1Board = new ArrayList<boolean[]>(); 
    private static ArrayList<boolean[]> Player2Board = new ArrayList<boolean[]>(); 
     
    private static int[][][] Player1Ints = new int[1][1][1];
    private static int[][][] Player2Ints = new int[1][1][1];
    public static boolean p1p = false;
    public static boolean p2p = false;
    private static Player winner = null;
    
    public static void Reset() {
        NUM_ROWS = 4;
        NUM_COLUMNS = 4;
        //w.w("RESETING BOARD!");
        NUM_CLICKS = 0;
        //winner = null;
        Player1Ints = new int[NUM_ROWS][NUM_ROWS][NUM_ROWS];
        Player1Ints = new int[NUM_ROWS][NUM_ROWS][NUM_ROWS];
        ChangeBoardSize(NUM_ROWS);
        ChangePlayerBoard(NUM_ROWS);
        Player.getCurrentPlayer().setInSelection(true);
                        Player.getOtherPlayer().setInSelection(true);
                        Player.getCurrentPlayer().setAllDone(false);
                        Player.getOtherPlayer().setAllDone(false);
        
        
    }
        public static void Reset2() {

        //w.w("RESETING BOARD!");
        NUM_CLICKS = 0;
        //winner = null;
        Player1Ints = new int[NUM_ROWS][NUM_ROWS][NUM_ROWS];
        Player1Ints = new int[NUM_ROWS][NUM_ROWS][NUM_ROWS];
        ChangeBoardSize(NUM_ROWS);
        ChangePlayerBoard(NUM_ROWS);
        Player.getCurrentPlayer().setInSelection(true);
                        Player.getOtherPlayer().setInSelection(true);
                        Player.getCurrentPlayer().setAllDone(false);
                        Player.getOtherPlayer().setAllDone(false);
        
        
    }
    
        public static void ChangePlayerBoard(int size){
            Player1Board.clear();
            Player2Board.clear();
            for(int i = 0;i < size;i++)
            {   
               
                PlayerADD(size);
            }
            Player1Ints = new int[size][size][size];
            Player2Ints = new int[size][size][size];
        }
        private static void PlayerADD(int size){
            boolean[] obj = new boolean[size];
            Player1Board.add(obj);
            boolean[] ptr = new boolean[size];
            Player2Board.add(ptr);
        }
    public static void ChangeBoardSize(int size){
        
        PlayerBoard.clear();
          for(int i = 0;i < NUM_ROWS;i++)
          {
            //  w.w("Adding row");
              AddRow(NUM_COLUMNS);
          }
    }
    public static void AddRow(int size){
        Piece[] obj = new Piece[size];
       // w.w("Adding Column");
        PlayerBoard.add(obj);
    }
    public static void AddPiecePixel(int xpixel,int ypixel,Graphics2D g) {
        
        if (winner != null)
            return;
        NUM_CLICKS++;
        //w.w("");
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;

        int zcol = 0;
        int zrow = 0;
 
        if (xpixel-Window.getX(0) > 0 &&
            ypixel-Window.getY(0) > 0 &&
            xpixel-Window.getX(0) < xdelta*NUM_COLUMNS &&
            ypixel-Window.getY(0) < ydelta*NUM_ROWS)
        {
            zcol = (xpixel-Window.getX(0))/xdelta;
            zrow = (ypixel-Window.getY(0))/ydelta;

            Color currentColor = Player.getCurrentPlayer().getColor();
            //w.w("");
            //w.w("Rows = " + zrow);
            //w.w("Columns = " + zcol);
            
            //w.w("PlayerBoard row size = " + PlayerBoard.size());
            if (Player.getCurrentPlayer().getInSelection() && Player.getCurrentPlayer().getColor() == Color.BLACK)
            { 
               // w.w("MADE IT");
                    w.w("Zrow: "+zrow+" Zcol: "+zcol);
                    w.w(""+PlayerBoard.size());
                    PlayerBoard.get(zrow)[zcol] = new Piece(Player.getCurrentPlayer().getColor());
                    if(Player.getCurrentPlayer().getColor() == Color.BLACK)
                    {
                        w.w("Setting Player 1 at: "+zrow+zcol+"  Clicks: "+NUM_CLICKS);
                        //w.w("Storing into Player 1");
                        Player1Ints[zrow][zcol][NUM_CLICKS - 1] = NUM_CLICKS;       
                        Player1Board.get(zrow)[zcol] = true;
                    }
                    
            }
            //w.w(""+Player.getCurrentPlayer().getInSelection());
            if(Player.getCurrentPlayer().getInSelection() && Player.getCurrentPlayer().getColor() == Color.RED)
            { 
               // w.w("MADE IT");
                    
                    PlayerBoard.get(zrow)[zcol] = new Piece(Player.getCurrentPlayer().getColor());
                    
                    
                    {
                        w.w("Setting Player 2 at: "+zrow+zcol+"  Clicks: "+NUM_CLICKS);
                        //w.w("Storing into Player 2");
                        Player2Ints[zrow][zcol][NUM_CLICKS - 1] = NUM_CLICKS; 
                        Player2Board.get(zrow)[zcol] = true;
                    }
            }
            if(!Player.getCurrentPlayer().getInSelection() && !Player.getOtherPlayer().getInSelection())
            {
                if(Player.getCurrentPlayer().getColor() == Color.BLACK)
                {
                    PlayerBoard.get(zrow)[zcol] = new Piece(Player.getCurrentPlayer().getColor());
                    w.w("Player 1 guess int at: "+zrow+zcol+" " + Player2Ints[zrow][zcol][NUM_CLICKS - 1]);
                    if((Player2Ints[zrow][zcol][NUM_CLICKS - 1] != NUM_CLICKS))
                    {
                        w.w("Player 1 has lost this round.");
                        p1p = true;
                        Player.getOtherPlayer().addPoints(1);
                        Player.setCurrentTurn();
                        //Player.switchTurn();
                        if(Player.getCurrentPlayer().getPoints() == 5)
                winner = Player.getCurrentPlayer();
                        
                          
                        Board.Reset();
                        return;
                        //w.w("Printing a LOOOOOOOSE!!!!!!!!!!!! for Black");
                    }
                }
                if(Player.getCurrentPlayer().getColor() == Color.RED)
                {
                    PlayerBoard.get(zrow)[zcol] = new Piece(Player.getCurrentPlayer().getColor());
                    if(Player1Ints[zrow][zcol][NUM_CLICKS - 1] != NUM_CLICKS)
                    {
                       w.w("Player 2 has lost this round.");
                       p2p = true;
                       Player.getOtherPlayer().addPoints(1);
                        Player.setCurrentTurn();
                       //Player.switchTurn();
                       if(Player.getOtherPlayer().getPoints() == 5)
                winner = Player.getOtherPlayer();
                       Board.Reset();
                       return;
                        //w.w("Printing a LOOOOOOOSE!!!!!!!!!!!! for RED");
                    }
                }
                
                if(NUM_CLICKS >= NUM_ROWS)
                {
                    Player.getCurrentPlayer().setAllDone(true);
                }
            }
            
            
                    if(NUM_CLICKS >= NUM_ROWS)
                    { 
                      
                        w.w("");
                       Player.getCurrentPlayer().setInSelection(false); 
                       
                      // NUM_ROWS++;
                        //NUM_COLUMNS++;
                       /// resetBoard = true;
                       
//                       if(Player.getCurrentPlayer().getAllDone() && Player.getOtherPlayer().getAllDone())
//                       {NUM_ROWS++;
//                        NUM_COLUMNS++;
//                        Player.getCurrentPlayer().setInSelection(true);
//                        Player.getOtherPlayer().setInSelection(true);
//                        Player.getCurrentPlayer().setAllDone(false);
//                        Player.getOtherPlayer().setAllDone(false);
//                        ChangePlayerBoard(NUM_ROWS);
//                       }
                        
                        
                        {
                            //ChangeBoardSize(NUM_ROWS);
                            //w.w("reseting board");
                        }
                        
                        
                       // w.w("Rows " + NUM_ROWS);
                       // w.w("Columns " + NUM_COLUMNS);
                        Piece.delay = true;
                    }
                         
            
            
        }
    }
    public static void Destroy(){
        for(int i = 0; i<PlayerBoard.size();i++)
        {
            for(int k = 0;k<PlayerBoard.get(i).length;k++)
            {
                PlayerBoard.get(i)[k] = null;
            }
        }
        if(NUM_CLICKS >= NUM_ROWS)
        {
            Player.switchTurn();
            NUM_CLICKS = 0;
            if(Player.getCurrentPlayer().getAllDone() && Player.getOtherPlayer().getAllDone())
                       {
                           NUM_ROWS++;
                        NUM_COLUMNS++;
                        Player.getCurrentPlayer().setInSelection(true);
                        Player.getOtherPlayer().setInSelection(true);
                        Player.getCurrentPlayer().setAllDone(false);
                        Player.getOtherPlayer().setAllDone(false);
                        w.w("Changing Board Size: " + NUM_ROWS);
                        ChangePlayerBoard(NUM_ROWS);
                        ChangeBoardSize(NUM_ROWS);
                       }
        }
    }

    public static void Draw(Graphics2D g,int timeCount) {
//Calculate the width and height of each board square.
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
 //draw grid
        g.setColor(Color.black);
        for (int zi = 1;zi<NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
        
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),
                    Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }
                
        for (int zi = 0;zi<PlayerBoard.size();zi++)
        {
            for (int zx = 0;zx<PlayerBoard.get(zi).length;zx++)
            {
                if (PlayerBoard.get(zi)[zx] != null)
                {
   
                    PlayerBoard.get(zi)[zx].draw(g,zi,zx,xdelta,ydelta,timeCount);
                }
            }
        } 
        
        g.setFont(new Font("Arial",Font.PLAIN,20));
        g.setColor(Color.LIGHT_GRAY);
        g.drawString("Player1 = " + Player.getPlayer1().getPoints(), 25,60);              
        g.setColor(Color.LIGHT_GRAY);
        g.drawString("Player2 = " + Player.getPlayer2().getPoints(), 520,60);              
        if(p1p)
        {
            g.setColor(Player.getPlayer2().getColor());
            g.setFont(new Font("Arial",Font.BOLD,60));
            g.drawString("Player 2 Won Round", 40,400);              

        }
        if(p2p)
        {
            g.setColor(Player.getPlayer1().getColor());
            g.setFont(new Font("Arial",Font.BOLD,60));
            g.drawString("Player 1 Won Round", 40,400);              

        }
        if (winner == Player.getPlayer1()) {
            g.setColor(Color.LIGHT_GRAY);
            g.setFont(new Font("Arial",Font.PLAIN,30));
            g.drawString("Player 1 has Won", 200,70);              
        }
        else if (winner == Player.getPlayer2()) {
            g.setColor(Color.LIGHT_GRAY);
            g.setFont(new Font("Arial",Font.PLAIN,30));
            g.drawString("Player 2 has Won", 200,70);              
        }
        else {
            g.setColor(Color.LIGHT_GRAY);
            g.setFont(new Font("Arial",Font.PLAIN,30));
            if (Player.getCurrentPlayer() == Player.getPlayer1() && Player.getPlayer1().getInSelection())
                g.drawString("Player 1's Selection", 200,60);              
            else if(Player.getCurrentPlayer() == Player.getPlayer2() && Player.getPlayer2().getInSelection())
                g.drawString("Player 2's Selection", 200,60);
            else if(Player.getCurrentPlayer() == Player.getPlayer1() && !Player.getPlayer1().getInSelection())
                g.drawString("Player 1's Guessing", 200,60); 
            else if(Player.getCurrentPlayer() == Player.getPlayer2() && !Player.getPlayer2().getInSelection())
                g.drawString("Player 2's Guessing", 200,60); 
            
      }
        
    }
}
