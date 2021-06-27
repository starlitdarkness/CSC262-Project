/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robots;

/**
 *
 * @author sergi
 */
public class Robot {
    
    private static int x;
    private static int y;
    private static char payload;
    private static Grid grid;


    public Robot() {

        x = 0;

        y = 0;

        payload = ' ';

    }


    public Robot(int x, int y, char payload) {

        Robot.x = x;

        Robot.y = y;

        Robot.payload = payload;

    }
    
    public void setGrid(Grid grid) {

        Robot.grid = grid;

    }


    public static int getX() {

        return x;

    }


    public static void setX(int x) {

        Robot.x = x;

    }


    public static int getY() {

        return y;

    }


    public static void setY(int y) {

        Robot.y = y;

    }


    public static char getPayload() {

        return payload;

    }


    public static void setPayload(char payload) {

        Robot.payload = payload;
        

    }


    public static void print() {

        System.out.println("X: " + x + " Y: " + y + " Payload: " + payload + "\n");

    }


    public static boolean pickUp() {

        if (payload != '.' ) {

            System.out.println("Not at (" + Robot.getX() + "," + Robot.getY() + ")");

            return false;

        }


        char locationPayload = grid.getLoad(x, y);

        if (locationPayload == '.') {

            System.out.println("No load at this location");

            return false;

        } else {

            if (payload == '.') {

                payload = locationPayload;

                grid.setLoad(x, y, payload);

                return true;

            }

        }


        return false;

    }


    public static boolean dropOff( ) {

        if (payload != '.') {

            System.out.println("Not at (" + x + "," + y + ")");

            return false;

        }


        if (payload != '.') {

            grid.setLoad(x,y,payload);

            payload = '.';

            return true;

        }


        return false;

    }


    // move 1 right
    public static void moveRight() {
        if (getX() >= 25) {
            System.out.println("Right boundary reached!");
        }
        else {
            setX(x + 1);
        }

    }

    // move 1 left
    public static void moveLeft() {
        if (getX() <= 0) {
            System.out.println("Left boundary reached!");
        }
        else {
            setX(x - 1);
        }
    }

    // move 1 up
    public static void moveUp() {
        if (getY() <= 0) {
            System.out.println("Top boundary reached!");
        }
        else {
            setY(y - 1);
        }
    }

    // move 1 down
    public static void moveDown() {
        if (getY() >= 25) {
            System.out.println("Bottom boundary reached!");
        }
        else {
            setY(y + 1);
        }
    }

    public static boolean moveTo(int lx, int ly) {
        if ((lx <= 25 && lx >= 0) && (ly <= 25 && ly >= 0)) { //check to see if coordinate is within grid boundary
            // change x coordinate, if needed
            while (x != lx) {
                // move right if needed
                if (x < lx) {
                    moveRight();
                }
                // move left if needed
                else {
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
                else {
                    moveUp();
                }
            }
            return true;

        } else
            return false;
    }
    
  }
    

