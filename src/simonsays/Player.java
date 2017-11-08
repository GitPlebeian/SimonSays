
package simonsays;

import java.awt.Color;
public class Player {
    private static Player currentTurn;
    private static Player players[] = new Player[2];
    private int points;
    private Color color;
    private boolean inSelection;
    private boolean allDone;
    public static int startingTurn = 0;

       

    public static void Reset() {
        if (players[0] == null) {
            players[0] = new Player(Color.black);
            players[1] = new Player(Color.red);
        }
        currentTurn = players[startingTurn];
    }
    Player(Color _color) {
        points = 0;
        color = _color;
        inSelection = true;
        allDone = false;
    }
    public static void setCurrentTurn(){
        if(startingTurn == 0)
            startingTurn = 1;
        if(startingTurn == 1)
            startingTurn = 0;
        currentTurn = players[startingTurn];
    }
    public void setInSelection(boolean bool){
        inSelection = bool;
    }
    public void setAllDone(boolean bool){
        allDone = bool;
    }
    public Color getColor() {
        return (color);
    }
    public boolean getInSelection(){
        return inSelection;
    }
    public boolean getAllDone(){
        return allDone;
    }
    public void addPoints(int value) {
        points += value;
    }
    public int getPoints() {
        return (points);
    }
    public static Player getPlayer1() {
        return (players[0]);
    }
    public static Player getPlayer2() {
        return (players[1]);
    }
    public static Player getCurrentPlayer() {
        return(currentTurn);
    }   
    public static Player getOtherPlayer() {
        if (currentTurn == players[0])
            return (players[1]);
        return(players[0]);
    }   
    public static void switchTurn() {
        if (currentTurn == players[0])
            currentTurn = players[1];
        else
            currentTurn = players[0];
    }
}
