package simonsays;
import java.awt.*;
import java.util.ArrayList;

public class Piece {
    private Color color;
    private int value;
    

    Piece(Color _color)
    {
        color = _color;
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
