
package simonsays;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class SimonSays extends JFrame implements Runnable {
    boolean animateFirstTime = true;
    Image image;
    Graphics2D g;
    static int timeCount=0;

    static boolean clicked = false;
    private boolean drawBoard = false;
    private boolean drawInstruction =false;
    private boolean drawDifficulty =false;
//
    public static void main(String[] args) {
        SimonSays frame = new SimonSays();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Instructions m = new Instructions();
    }

    public SimonSays() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                if (e.BUTTON1 == e.getButton() ) {
                    
                    if(clicked == false && drawBoard)
                    {
                        
                        //w.w("Clicking");
                        
                        Board.AddPiecePixel(e.getX(),e.getY(),g);
                        
                        clicked = true;
                        timeCount = 0;
                    }
                    if(!drawBoard && !drawInstruction){
                    Menu.AddPiecePixel(e.getX(),e.getY());
                    Menu.AddPiecePixelDifficulty(e.getX(),e.getY());
                    }
                    if(Menu.AddPiecePixelDifficulty(e.getX(),e.getY()) && !drawBoard){                                      
                        drawDifficulty = true;
                        drawInstruction=false;
                        drawBoard = false;
                    }
                    if(Menu.AddPiecePixel(e.getX(),e.getY()) && !drawBoard && !drawInstruction){
                        drawBoard = true;
                        drawInstruction=false;
                    }
                    Menu.changeColor = false;
                    
                }

                if (e.BUTTON3 == e.getButton()) {

                }
                repaint();
            }
        });
            

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {

        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.VK_UP == e.getKeyCode()) {
//                } else if (e.VK_ENTER == e.getKeyCode()) {
//                    drawBoard=true;
//                    drawInstruction=false;
                    
                } else if (e.VK_I == e.getKeyCode()) {
                    drawInstruction = true;
                    drawBoard=false;
//                } else if (e.VK_Q == e.getKeyCode()) {
//                          drawInstruction = false;
//                    drawBoard=false;
//                    drawDifficulty = false;
                    
                } else if (e.VK_ESCAPE == e.getKeyCode()) {
                    drawInstruction = false;
                    drawBoard=false;
                    drawDifficulty = false;
                    reset();
                }
                else if (e.VK_3 == e.getKeyCode()) {
                    if(drawDifficulty){
                      Board.NUM_ROWS = 3;
                      System.out.println(Board.NUM_ROWS);
                      Board.NUM_COLUMNS = 3;         
                    Board.Reset2();
                      drawBoard = true;
                      drawDifficulty = false;
                    }
                }
                else if (e.VK_4 == e.getKeyCode()) {
                    if(drawDifficulty){
                    Board.NUM_ROWS = 4;
                    Board.NUM_COLUMNS = 4;         
                    Board.Reset2();
                      drawBoard = true;
                      drawDifficulty = false;
                    }
                }
                else if (e.VK_5 == e.getKeyCode()) {
                    if(drawDifficulty){
                    Board.NUM_ROWS = 5;
                    Board.NUM_COLUMNS = 5;         
                    Board.Reset2();
                      drawBoard = true;
                      drawDifficulty = false;
                    }
                }
                else if (e.VK_6 == e.getKeyCode()) {
                    if(drawDifficulty){
                    Board.NUM_ROWS = 6;
                      Board.NUM_COLUMNS = 6;         
                    Board.Reset2();
                    drawBoard = true;
                      drawDifficulty = false;
                    }
                }
                else if (e.VK_7 == e.getKeyCode()) {
                    if(drawDifficulty){
                    Board.NUM_ROWS = 7;
                    Board.NUM_COLUMNS = 7;         
                    Board.Reset2();
                      drawBoard = true;
                      drawDifficulty = false;
                    }
                }
                else if (e.VK_8 == e.getKeyCode()) {
                    if(drawDifficulty){
                    Board.NUM_ROWS = 8;
                    Board.NUM_COLUMNS = 8;         
                    Board.Reset2();
                    
                      drawBoard = true;
                      drawDifficulty = false;
                    }
                }
                else if (e.VK_9 == e.getKeyCode()) {
                    if(drawDifficulty){
                    Board.NUM_ROWS = 9;
                    Board.NUM_COLUMNS = 9;         
                    Board.Reset2();
                      drawBoard = true;
                      drawDifficulty = false;
                    }
                }
                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }
////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
if(drawBoard){       
//fill background
        
        g.setColor(Player.getCurrentPlayer().getColor());
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.white);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.red);
        g.drawPolyline(x, y, 5);
}
        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        
        if(!drawBoard && !drawInstruction)
            Menu.draw(g);
        
        if(drawInstruction)
            Menu.drawInstruction(g);
            
        if(!drawInstruction && !drawBoard && drawDifficulty)
            Menu.drawDifficulty(g);
        
        if(drawBoard)     
           Board.Draw(g,timeCount);
        
        if(!drawBoard && !drawInstruction && !drawDifficulty){
            Instructions m = new Instructions();
            Instructions.Draw(g);
        }

        gOld.drawImage(image, 0, 0, null);
    }

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = .1;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
    
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        Player.Reset();
        Board.Reset();
        timeCount = 0;
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {

        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }

            reset();

            
        }
    timeCount++;

    if(timeCount % 5 == 4)
    {
         //w.w("Destorying Board");
        clicked = false;
        Board.Destroy();
    }
    if(timeCount % 12 == 11)
    {
        Board.p1p = false;
        Board.p2p = false;
    }

       
    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }

}




