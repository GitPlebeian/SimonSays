package simonsays;
import java.awt.*;
import java.util.ArrayList;

public class Piece {
    private Color color;
    private int value;
    private static ArrayList<Piece> Player1Peices = new ArrayList<Piece>(); 
    private static ArrayList<Piece> Player2Peices = new ArrayList<Piece>();

    Piece(Color _color)
    {
        color = _color;
    }
    public static void addToPlayer1Peices(Color col) {
         Piece obj = new Piece(col);
         Player1Peices.add(obj);
    }
    public static void addToPlayer2Peices(Color col) {
         Piece obj = new Piece(col);
         Player2Peices.add(obj);
    }
    public static void ClearPeices() {
        Player1Peices.clear();
        Player2Peices.clear();
    }
    public Color getColor()
    {
        return (color);
    }

    public void draw(Graphics2D g,int row,int column,
    int xdelta,int ydelta) {
        g.setColor(color); 
            g.fillRect(Window.getX(column*xdelta),
        Window.getY(row*ydelta),xdelta,ydelta);
        
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.PLAIN,30));             
    }
    
}
