package simonsays;
import java.awt.*;

public class Piece {
    private Color color;
    private int value;
    
    Piece(Color _color)
    {
        color = _color;
        value = (int)(Math.random()*4+1);
    }
    public Color getColor()
    {
        return (color);
    }
    public int getValue()
    {
        return (value);
    }

    public void draw(Graphics2D g,int row,int column,
    int xdelta,int ydelta) {
        g.setColor(color); 
        g.fillOval(Window.getX(column*xdelta),
        Window.getY(row*ydelta),xdelta,ydelta);
        
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.PLAIN,30));
        g.drawString("" + value,Window.getX(column*xdelta)+30,
        Window.getY(row*ydelta)+40);           
    }
    
}
