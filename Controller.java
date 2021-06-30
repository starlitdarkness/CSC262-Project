package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    private TextArea displayPane;


    private int x;

    private int y;

    private char payload;

    private static char[][] grid = {{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}};

    public Controller() {

        x = 0;

        y = 0;

        payload = '.';

    }


    public Controller(int x, int y, char payload) {

        this.x = x;

        this.y = y;

        this.payload = payload;

    }


    public void setGrid(char[][] grid) {

        Controller.grid = grid;

    }


    public int getX() {

        return x;

    }


    public void setX(int x) {

        this.x = x;

    }


    public int getY() {

        return y;

    }


    public void setY(int y) {

        this.y = y;

    }


    public char getPayload() {

        return payload;

    }


    public void setPayload(char payload) {

        this.payload = payload;

    }


    public void print() {

        System.out.println("X: " + x + " Y: " + y + " Payload: " + payload + "\n");

    }

    public char getLoad (int x, int y){
        return grid[x][y]; }

    public void setLoad (int row, int col, char load)

    {

        grid [row][col]= load;

    }

    public boolean pickUp() {

        if (payload != '.' ) {

            // System.out.println("Not at (" + Robot.getX() + "," + Robot.getY() + ")");

            return false;

        }

        char locationPayload = this.getLoad(x, y);

        if (locationPayload == '.') {

            System.out.println("No load at this location");

            return false;

        } else {

            if (payload == '.') {

                payload = locationPayload;

                this.setLoad(x, y, payload);

                return true;

            }

        }

        return false;

    }


    public  boolean dropOff( ) {


        if (payload != '.') {

            this.setLoad(x,y,payload);

            payload = '.';

            return true;

        }
        else
            return false;

    }


    // move 1 right
    public void moveRight() {
        if (getX() >= 25) {
            System.out.println("Right boundary reached!");
        } else if (getX() < 25) {
            setX(x + 1);
        }

    }

    // move 1 left
    public void moveLeft() {
        if (getX() <= 0) {
            System.out.println("Left boundary reached!");
        } else if (getX() > 0) {
            setX(x - 1);
        }
    }

    // move 1 up
    public void moveUp() {
        if (getY() <= 0) {
            System.out.println("Top boundary reached!");
        } else if (getY() > 0) {
            setY(y - 1);
        }
    }

    // move 1 down
    public void moveDown() {
        if (getY() >= 25) {
            System.out.println("Bottom boundary reached!");
        } else if (getY() < 25) {
            setY(y + 1);
        }
    }

    public boolean moveTo(int lx, int ly) {
        if ((lx <= 25 && lx >= 0) && (ly <= 25 && ly >= 0)) { //check to see if coordinate is within grid boundary

            // change x coordinate, if needed
            while (x != lx) {

                // move right if needed

                if (x < lx) {

                    moveRight();

                }

                // move left if needed

                else if (x > lx) {
                    moveLeft();
                }
            }

// change y coordinate

            while (y != ly) {
                // move down if needed
                if (y < ly) {
                    moveDown();
                }
// move up if needed
                else if (y > ly) {
                    moveUp();
                }
            }
            return true;

        } else
            return false;
    }




    @FXML
    private Button pickUp;

    @FXML
    public void pickUp(ActionEvent event) {
        pickUp();
        displayPane.clear();
        displayPane.setWrapText(true);
        displayPane.setText(String.valueOf(grid[0]) + "\n");
        displayPane.appendText(String.valueOf(grid[1]) + "\n");
        displayPane.appendText(String.valueOf(grid[2]) + "\n");
        displayPane.appendText(String.valueOf(grid[3]) + "\n");
        displayPane.appendText(String.valueOf(grid[4]) + "\n");
        displayPane.appendText(String.valueOf(grid[5]) + "\n");
        displayPane.appendText(String.valueOf(grid[6]) + "\n");
        displayPane.appendText(String.valueOf(grid[7]) + "\n");
        displayPane.appendText(String.valueOf(grid[8]) + "\n");
        displayPane.appendText(String.valueOf(grid[9]) + "\n");
        displayPane.appendText(String.valueOf(grid[10]) + "\n");
        displayPane.appendText(String.valueOf(grid[11]) + "\n");
        displayPane.appendText(String.valueOf(grid[12]) + "\n");
        displayPane.appendText(String.valueOf(grid[13]) + "\n");
        displayPane.appendText(String.valueOf(grid[14]) + "\n");
        displayPane.appendText(String.valueOf(grid[15]) + "\n");
        displayPane.appendText(String.valueOf(grid[16]) + "\n");
        displayPane.appendText(String.valueOf(grid[17]) + "\n");
        displayPane.appendText(String.valueOf(grid[18]) + "\n");
        displayPane.appendText(String.valueOf(grid[19]) + "\n");
        displayPane.appendText(String.valueOf(grid[20]) + "\n");
        displayPane.appendText(String.valueOf(grid[21]) + "\n");
        displayPane.appendText(String.valueOf(grid[22]) + "\n");
        displayPane.appendText(String.valueOf(grid[23]) + "\n");
        displayPane.appendText(String.valueOf(grid[24]) + "\n");
    }


    @FXML
    private Button dropOff;

    @FXML
    protected void dropOff(ActionEvent event) {
        dropOff();
        displayPane.setWrapText(true);
        displayPane.clear();
        displayPane.setText(String.valueOf(grid[0]) + "\n");
        displayPane.appendText(String.valueOf(grid[1]) + "\n");
        displayPane.appendText(String.valueOf(grid[2]) + "\n");
        displayPane.appendText(String.valueOf(grid[3]) + "\n");
        displayPane.appendText(String.valueOf(grid[4]) + "\n");
        displayPane.appendText(String.valueOf(grid[5]) + "\n");
        displayPane.appendText(String.valueOf(grid[6]) + "\n");
        displayPane.appendText(String.valueOf(grid[7]) + "\n");
        displayPane.appendText(String.valueOf(grid[8]) + "\n");
        displayPane.appendText(String.valueOf(grid[9]) + "\n");
        displayPane.appendText(String.valueOf(grid[10]) + "\n");
        displayPane.appendText(String.valueOf(grid[11]) + "\n");
        displayPane.appendText(String.valueOf(grid[12]) + "\n");
        displayPane.appendText(String.valueOf(grid[13]) + "\n");
        displayPane.appendText(String.valueOf(grid[14]) + "\n");
        displayPane.appendText(String.valueOf(grid[15]) + "\n");
        displayPane.appendText(String.valueOf(grid[16]) + "\n");
        displayPane.appendText(String.valueOf(grid[17]) + "\n");
        displayPane.appendText(String.valueOf(grid[18]) + "\n");
        displayPane.appendText(String.valueOf(grid[19]) + "\n");
        displayPane.appendText(String.valueOf(grid[20]) + "\n");
        displayPane.appendText(String.valueOf(grid[21]) + "\n");
        displayPane.appendText(String.valueOf(grid[22]) + "\n");
        displayPane.appendText(String.valueOf(grid[23]) + "\n");
        displayPane.appendText(String.valueOf(grid[24]) + "\n");
    }

    @FXML
    private Button mUP;

    @FXML
    protected void moveUp(ActionEvent event) {
        moveUp();
        displayPane.setWrapText(true);
        displayPane.clear();
        displayPane.setText(String.valueOf(grid[0]) + "\n");
        displayPane.appendText(String.valueOf(grid[1]) + "\n");
        displayPane.appendText(String.valueOf(grid[2]) + "\n");
        displayPane.appendText(String.valueOf(grid[3]) + "\n");
        displayPane.appendText(String.valueOf(grid[4]) + "\n");
        displayPane.appendText(String.valueOf(grid[5]) + "\n");
        displayPane.appendText(String.valueOf(grid[6]) + "\n");
        displayPane.appendText(String.valueOf(grid[7]) + "\n");
        displayPane.appendText(String.valueOf(grid[8]) + "\n");
        displayPane.appendText(String.valueOf(grid[9]) + "\n");
        displayPane.appendText(String.valueOf(grid[10]) + "\n");
        displayPane.appendText(String.valueOf(grid[11]) + "\n");
        displayPane.appendText(String.valueOf(grid[12]) + "\n");
        displayPane.appendText(String.valueOf(grid[13]) + "\n");
        displayPane.appendText(String.valueOf(grid[14]) + "\n");
        displayPane.appendText(String.valueOf(grid[15]) + "\n");
        displayPane.appendText(String.valueOf(grid[16]) + "\n");
        displayPane.appendText(String.valueOf(grid[17]) + "\n");
        displayPane.appendText(String.valueOf(grid[18]) + "\n");
        displayPane.appendText(String.valueOf(grid[19]) + "\n");
        displayPane.appendText(String.valueOf(grid[20]) + "\n");
        displayPane.appendText(String.valueOf(grid[21]) + "\n");
        displayPane.appendText(String.valueOf(grid[22]) + "\n");
        displayPane.appendText(String.valueOf(grid[23]) + "\n");
        displayPane.appendText(String.valueOf(grid[24]) + "\n");

    }

    @FXML
    private Button mL;

    @FXML
    protected void moveL(ActionEvent event) {
        moveLeft();
        displayPane.setWrapText(true);
        displayPane.clear();
        displayPane.setText(String.valueOf(grid[0]) + "\n");
        displayPane.appendText(String.valueOf(grid[1]) + "\n");
        displayPane.appendText(String.valueOf(grid[2]) + "\n");
        displayPane.appendText(String.valueOf(grid[3]) + "\n");
        displayPane.appendText(String.valueOf(grid[4]) + "\n");
        displayPane.appendText(String.valueOf(grid[5]) + "\n");
        displayPane.appendText(String.valueOf(grid[6]) + "\n");
        displayPane.appendText(String.valueOf(grid[7]) + "\n");
        displayPane.appendText(String.valueOf(grid[8]) + "\n");
        displayPane.appendText(String.valueOf(grid[9]) + "\n");
        displayPane.appendText(String.valueOf(grid[10]) + "\n");
        displayPane.appendText(String.valueOf(grid[11]) + "\n");
        displayPane.appendText(String.valueOf(grid[12]) + "\n");
        displayPane.appendText(String.valueOf(grid[13]) + "\n");
        displayPane.appendText(String.valueOf(grid[14]) + "\n");
        displayPane.appendText(String.valueOf(grid[15]) + "\n");
        displayPane.appendText(String.valueOf(grid[16]) + "\n");
        displayPane.appendText(String.valueOf(grid[17]) + "\n");
        displayPane.appendText(String.valueOf(grid[18]) + "\n");
        displayPane.appendText(String.valueOf(grid[19]) + "\n");
        displayPane.appendText(String.valueOf(grid[20]) + "\n");
        displayPane.appendText(String.valueOf(grid[21]) + "\n");
        displayPane.appendText(String.valueOf(grid[22]) + "\n");
        displayPane.appendText(String.valueOf(grid[23]) + "\n");
        displayPane.appendText(String.valueOf(grid[24]) + "\n");
    }

    @FXML
    private Button mR;

    @FXML
    protected void moveR(ActionEvent event) {
        moveRight();
        displayPane.setWrapText(true);
        displayPane.clear();
        displayPane.setText(String.valueOf(grid[0]) + "\n");
        displayPane.appendText(String.valueOf(grid[1]) + "\n");
        displayPane.appendText(String.valueOf(grid[2]) + "\n");
        displayPane.appendText(String.valueOf(grid[3]) + "\n");
        displayPane.appendText(String.valueOf(grid[4]) + "\n");
        displayPane.appendText(String.valueOf(grid[5]) + "\n");
        displayPane.appendText(String.valueOf(grid[6]) + "\n");
        displayPane.appendText(String.valueOf(grid[7]) + "\n");
        displayPane.appendText(String.valueOf(grid[8]) + "\n");
        displayPane.appendText(String.valueOf(grid[9]) + "\n");
        displayPane.appendText(String.valueOf(grid[10]) + "\n");
        displayPane.appendText(String.valueOf(grid[11]) + "\n");
        displayPane.appendText(String.valueOf(grid[12]) + "\n");
        displayPane.appendText(String.valueOf(grid[13]) + "\n");
        displayPane.appendText(String.valueOf(grid[14]) + "\n");
        displayPane.appendText(String.valueOf(grid[15]) + "\n");
        displayPane.appendText(String.valueOf(grid[16]) + "\n");
        displayPane.appendText(String.valueOf(grid[17]) + "\n");
        displayPane.appendText(String.valueOf(grid[18]) + "\n");
        displayPane.appendText(String.valueOf(grid[19]) + "\n");
        displayPane.appendText(String.valueOf(grid[20]) + "\n");
        displayPane.appendText(String.valueOf(grid[21]) + "\n");
        displayPane.appendText(String.valueOf(grid[22]) + "\n");
        displayPane.appendText(String.valueOf(grid[23]) + "\n");
        displayPane.appendText(String.valueOf(grid[24]) + "\n");
    }

    @FXML
    private Button mD;

    @FXML
    protected void moveD(ActionEvent event) {
        moveDown();
        displayPane.setWrapText(true);
        displayPane.clear();
        displayPane.setText(String.valueOf(grid[0]) + "\n");
        displayPane.appendText(String.valueOf(grid[1]) + "\n");
        displayPane.appendText(String.valueOf(grid[2]) + "\n");
        displayPane.appendText(String.valueOf(grid[3]) + "\n");
        displayPane.appendText(String.valueOf(grid[4]) + "\n");
        displayPane.appendText(String.valueOf(grid[5]) + "\n");
        displayPane.appendText(String.valueOf(grid[6]) + "\n");
        displayPane.appendText(String.valueOf(grid[7]) + "\n");
        displayPane.appendText(String.valueOf(grid[8]) + "\n");
        displayPane.appendText(String.valueOf(grid[9]) + "\n");
        displayPane.appendText(String.valueOf(grid[10]) + "\n");
        displayPane.appendText(String.valueOf(grid[11]) + "\n");
        displayPane.appendText(String.valueOf(grid[12]) + "\n");
        displayPane.appendText(String.valueOf(grid[13]) + "\n");
        displayPane.appendText(String.valueOf(grid[14]) + "\n");
        displayPane.appendText(String.valueOf(grid[15]) + "\n");
        displayPane.appendText(String.valueOf(grid[16]) + "\n");
        displayPane.appendText(String.valueOf(grid[17]) + "\n");
        displayPane.appendText(String.valueOf(grid[18]) + "\n");
        displayPane.appendText(String.valueOf(grid[19]) + "\n");
        displayPane.appendText(String.valueOf(grid[20]) + "\n");
        displayPane.appendText(String.valueOf(grid[21]) + "\n");
        displayPane.appendText(String.valueOf(grid[22]) + "\n");
        displayPane.appendText(String.valueOf(grid[23]) + "\n");
        displayPane.appendText(String.valueOf(grid[24]) + "\n");
    }

}




