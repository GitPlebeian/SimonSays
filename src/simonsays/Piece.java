package simonsays;
import java.awt.*;
import java.util.ArrayList;

public class Piece {
    private Color color;
    private int value;
    private boolean draw = true;


    private boolean clicked = false;

    Piece(Color _color)
    {
       SimonSays.timeCount = 0;
        color = _color;
        
    }

    public Color getColor()
    {
        return (color);
    }

    
    
    public void draw(Graphics2D g,int row,int column,
    int xdelta,int ydelta,int timeCount) {
        g.setColor(color); 
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
