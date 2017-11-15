
package simonsays;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Instructions extends Menu {
    
    static String title = "";
    static String on = "";
    static String off = "";
    static int xPos;
    static int yPos;
    static boolean onOrOff = false;
    
    
    Instructions(){
        super(title,on,off,xPos,yPos);
        //w.w("here");
    }
    public static void changeOnOff(){
        
    }
    public static void Draw(Graphics2D g){
        g.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 18));
        g.setColor(Color.white);
        g.drawString(title,xPos,yPos);
        //w.w("" + xPos);
        //w.w("" + yPos);
      //  System.out.println("INNNNNN");
    }
}
