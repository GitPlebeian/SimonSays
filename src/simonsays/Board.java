
package simonsays;
import java.awt.*;
import java.util.ArrayList;

public class Board {
    private final static int NUM_CONNECT_WIN = 4;    
    

    private static int NUM_ROWS = 5;
    private static int NUM_COLUMNS = 5;      
    private static int NUM_CLICKS = 0;
    private static boolean gameOver = false;
    
    private static ArrayList<Piece[]> PlayerBoard = new ArrayList<Piece[]>(); 
    private static ArrayList<boolean[]> Player1Board = new ArrayList<boolean[]>(); 
    private static ArrayList<boolean[]> Player2Board = new ArrayList<boolean[]>(); 

    private static Player winner = null;
    
    public static void Reset() {
        NUM_ROWS = 3;
        NUM_COLUMNS = 3;
        w.w("RESETING BOARD!");
        NUM_CLICKS = 0;
        winner = null;
        ChangeBoardSize(NUM_ROWS);
        ChangePlayerBoard(NUM_ROWS);
        Player1Board.clear();
        Player2Board.clear();
        
    }
        public static void ChangePlayerBoard(int size){
            Player1Board.clear();
            Player2Board.clear();
            for(int i = 0;i < NUM_ROWS;i++)
            {   
                PlayerADD(NUM_COLUMNS);
            }
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
              w.w("Adding row");
              AddRow(NUM_COLUMNS);
          }
    }
    public static void AddRow(int size){
        Piece[] obj = new Piece[size];
        w.w("Adding Column");
        PlayerBoard.add(obj);
    }
    public static void AddPiecePixel(int xpixel,int ypixel) {
        
        if (winner != null)
            return;
        
        
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
            w.w("");
            w.w("Rows = " + zrow);
            w.w("Columns = " + zcol);
            
            w.w("PlayerBoard row size = " + PlayerBoard.size());
            if (PlayerBoard.get(zrow)[zcol] == null)
            { 
               // w.w("MADE IT");
                    NUM_CLICKS++;
                    PlayerBoard.get(zrow)[zcol] = new Piece(Player.getCurrentPlayer().getColor());
                    
                    if(NUM_CLICKS >= NUM_ROWS)
                    {
                        Player.switchTurn();
                        NUM_CLICKS = 0;
                       // NUM_ROWS++;
                       // NUM_COLUMNS++;
                        ChangeBoardSize(NUM_ROWS);
                        ChangePlayerBoard(NUM_ROWS);
                        w.w("Rows " + NUM_ROWS);
                        w.w("Columns " + NUM_COLUMNS);
                    }
                         
            }
            
        }
    }

    public static void Draw(Graphics2D g) {
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
                    PlayerBoard.get(zi)[zx].draw(g,zi,zx,xdelta,ydelta);
                }
            }
        } 
        
//        g.setFont(new Font("Arial",Font.PLAIN,20));
//        g.setColor(Player.getPlayer1().getColor());
//        g.drawString("Player1 = " + Player.getPlayer1().getPoints(), 25,70);              
//        g.setColor(Player.getPlayer2().getColor());
//        g.drawString("Player2 = " + Player.getPlayer2().getPoints(), 520,70);              
//        
//        if (winner == Player.getPlayer1()) {
//            g.setColor(Player.getPlayer1().getColor());
//            g.setFont(new Font("Arial",Font.PLAIN,30));
//            g.drawString("Player 1 has Won", 200,70);              
//        }
//        else if (winner == Player.getPlayer2()) {
//            g.setColor(Player.getPlayer2().getColor());
//            g.setFont(new Font("Arial",Font.PLAIN,30));
//            g.drawString("Player 2 has Won", 200,70);              
//        }
//        else {
            g.setColor(Player.getCurrentPlayer().getColor());
            g.setFont(new Font("Arial",Font.PLAIN,30));
            if (Player.getCurrentPlayer() == Player.getPlayer1())
                g.drawString("Player 1's turn", 200,70);              
            else
                g.drawString("Player 2's turn", 200,70);              
//        }
        
    }
}
