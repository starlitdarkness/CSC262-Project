/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robot;

/**
 *
 * @author sergi
 */
public class Robot {
    
    private int x;

    private int y;

    private char payload;


    private char grid[][];


    public Robot() {

        x = 0;

        y = 0;

        payload = ' ';

    }


    public Robot(int x, int y, char payload) {

        this.x = x;

        this.y = y;

        this.payload = payload;

    }


    public void setGrid(char grid[][]) {

        this.grid = grid;

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


    public boolean pickup(int lx, int ly) {

        if (lx != x && ly != y) {

            System.out.println("Not at (" + lx + "," + ly + ")");

            return false;

        }


        char locationPayload = grid[lx][ly];

        if (locationPayload == ' ') {

            System.out.println("No load at this location");

            return false;

        } else {

            if (payload == ' ') {

                payload = locationPayload;

                grid[lx][ly] = ' ';

                return true;

            }

        }


        return false;

    }


    public boolean dropOff(int lx, int ly) {

        if (lx != x && ly != y) {

            System.out.println("Not at (" + lx + "," + ly + ")");

            return false;

        }


        if (payload != ' ') {

            grid[lx][ly] = payload;

            payload = ' ';

            return true;

        }


        return false;

    }


    // move 1 right
    public void moveRight() {
        if (getX() >= 25) {
            System.out.println("Right boundary reached!");
        }
        else if (getX() < 25) {
            setX(x + 1);
        }

    }

    // move 1 left
    public void moveLeft() {
        if (getX() <= 0) {
            System.out.println("Left boundary reached!");
        }
        else if (getX() > 0) {
            setX(x - 1);
        }
    }

    // move 1 up
    public void moveUp() {
        if (getY() <= 0) {
            System.out.println("Top boundary reached!");
        }
        else if (getY() > 0) {
            setY(y - 1);
        }
    }

    // move 1 down
    public void moveDown() {
        if (getY() >= 25) {
            System.out.println("Bottom boundary reached!");
        }
        else if (getY() < 25) {
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

      
  
 /* public void grid(int rowX, int columnY)
  {
      char [][] grid = new char [rowX][columnY];
  }*/
    
  public void  print2D(char[][]grid)
  {
      for(int row =0; row < grid.length; row++)
      {
          for( int column = 0;column < grid[row].length; column++)
          {
              System.out.printf("%s", grid[row][column]);
          }
      
      }
        
  }
    
  
  public static void main(String [] args)
  {
      char [][] grid = new char [26][26];
      Robot R1 = new Robot (0,0,' ');
      Robot R2 = new Robot ();
       
      R1.print2D(grid);
      R1.print();
      R2.print();
      R1.moveTo(23,24);
      R2.moveTo(15,3);
      R1.print();
      R2.print();
      
      R1.moveTo(10,8);
      R1.pickup(10,8);
      R1.moveTo(20,20);
      R1.dropOff(20,20);      
      R2.moveTo(22,4);
      R2.pickup(22,4);
      R2.moveTo(0,0);
      R2.dropOff(0,0);
  
  
  }
  
}

