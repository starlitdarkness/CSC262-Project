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
public class Grid {
    private static char [][] grid;
    static int numRows = 25;
    static int numCol = 25;
    
    public Grid (){
      intitialize ();
    }
    public Grid (int row, int col){
       numRows = row;
       numCol = col;
       intitialize ();

    }
    
    private static void intitialize(){
        
        grid = new char[numRows][numCol];
        for(int i =0; i < numRows;i++){
           for (int j = 0; j< numCol;j++){
             grid [i][j] = '.';
            }
        }
    
    }
    
    public void setLoad (int row, int col, char load)
    {
        grid [row][col]= load;
    }
    
    public char getLoad (int x, int y){ return grid[x][y]; }
    
    public static void print2D()
  {
      for(int row =0; row < grid.length; row++)
      {
          for( int column = 0;column < grid[row].length; column++)
          {
              System.out.printf("%s", grid[row][column]);
          }
      System.out.println();
      }
        
  }
}
