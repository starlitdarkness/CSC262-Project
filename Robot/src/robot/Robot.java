/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

/**
 *
 * @author frede
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

  

   public void setGrid(char grid[][])

   {

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

       if(lx != x && ly != y) {

           System.out.println("Not at (" + lx + "," + ly + ")");

           return false;

       }

      

       char locationPayload = grid[lx][ly];

       if(locationPayload == ' ') {

           System.out.println("No load at this location");

           return false;

       } else {

           if(payload == ' ') {

               payload = locationPayload;

               grid[lx][ly] = ' ';

               return true;

           }

       }

      

       return false;

   }

  

   public boolean dropOff(int lx, int ly) {

       if(lx != x && ly != y) {

           System.out.println("Not at (" + lx + "," + ly + ")");

           return false;

       }

                      

       if(payload != ' ') {          

           grid[lx][ly] = payload;

           payload = ' ';

           return true;

       }      

      

       return false;

   }

  
