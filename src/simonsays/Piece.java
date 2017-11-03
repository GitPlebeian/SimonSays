package simonsays;
import java.awt.*;
import java.util.ArrayList;

public class Piece {
    private Color color;
    private int value;
    private int done = 10000;
    private boolean draw = true;

    Piece(Color _color)
    {
        color = _color;
        SimonSays.timeCount = 0;
    }
    public Color getColor()
    {
        return (color);
    }
    
    
    public void draw(Graphics2D g,int row,int column,
    int xdelta,int ydelta,int timeCount) {
        g.setColor(color); 
        int count;
        if(draw)
        g.fillRect(Window.getX(column*xdelta),Window.getY(row*ydelta),xdelta,ydelta);
        w.w("Timecount = " + timeCount);
        if(timeCount % 10 == 9 && draw == true)
        {
            
            w.w("ENTERING");
            draw = false;
        }
            
            
           
        
             
               
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.PLAIN,30));             
    }
    
}
