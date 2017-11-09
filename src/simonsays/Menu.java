package simonsays;

import java.awt.Color;
import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu {
    private String play;
    private String start;
    private static int xPos;
    private int yPos;
    private Color buttonColor;
    private Color backGroundColor;

    public static void drawButton(Graphics2D g){
        double xscale = 0.0;
        double yscale = 0.0;
        //g.fillRect(Window.WINDOW_WIDTH/2-60, Window.WINDOW_HEIGHT/2 + 60, 150, 50);
        g.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 18));
        g.setColor(Color.red);
        g.drawString("Click here to play!", Window.WINDOW_WIDTH/2-105, Window.WINDOW_HEIGHT/2+30);
    }
     public static void drawHelpButton(Graphics2D g){
        g.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 18));
        g.setColor(Color.red);
        g.drawString("Instructions!", Window.WINDOW_WIDTH/4-Window.WINDOW_WIDTH/10, Window.WINDOW_HEIGHT-Window.WINDOW_HEIGHT/4);
     }
     public static void drawStartButton(Graphics2D g){
        g.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 18));
        g.setColor(Color.red);
        g.drawString("Choose difficulty!", Window.WINDOW_WIDTH-Window.WINDOW_WIDTH/2+Window.WINDOW_WIDTH/10, Window.WINDOW_HEIGHT-Window.WINDOW_HEIGHT/4);
     }

    
    public static void draw(Graphics2D g){
        g.setColor(Color.white);
        
//fill background
        g.setColor(Color.red);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.black);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.red);
        g.drawPolyline(x, y, 5);
        
        g.setColor(Color.white);
        g.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 40));
        g.drawString("SIMON SAYS", Window.WINDOW_WIDTH/2-140, Window.WINDOW_HEIGHT/4+20);
        
        
        g.setColor(Color.white);
        drawButton(g);
        drawHelpButton(g);
        drawStartButton(g);
    }
    public static void drawInstruction(Graphics2D g){

        
//fill background
        g.setColor(Color.white);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.black);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.white);
        g.drawPolyline(x, y, 5);
        

        
        

    }

}
