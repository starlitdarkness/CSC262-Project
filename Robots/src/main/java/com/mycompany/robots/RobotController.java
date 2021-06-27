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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
//import javax.swing.*;

public class RobotController{
GraphicsContext qc;
private TextField getX;
private TextField getY;

    @FXML
    private GridPane robotGUI;
    @FXML
    private Pane pane;
    @FXML
    private TextArea grid;
    
    @FXML 
    public void init (){
    Robot R1 = new Robot();
    Grid g = new Grid (25,25);
    g.setLoad (10,8, 'B');
    g.setLoad (22,4,'C');
    g.print2D();
    R1.setGrid(g);
    printTextField(Robot.getX() + ", " + Robot.getY());
    
    
       
    }
    
    @FXML
    void dropOffButtonPressed(ActionEvent event) {
      Robot.dropOff();
      printTextField(Robot.getX() + ", " + Robot.getY());

    }

    @FXML
    void moveDownButtonPressed(ActionEvent event) {
         Robot.moveDown();
         printTextField(Robot.getX() + ", " + Robot.getY());

    }

    @FXML
    void moveLeftButtonPressed(ActionEvent event) {
        
        Robot.moveLeft();
        printTextField(Robot.getX() + ", " + Robot.getY());
    }

    @FXML
    void moveRightButtonPressed(ActionEvent event) {
        
        Robot.moveRight();
        printTextField(Robot.getX() + ", " + Robot.getY());
    }

    @FXML
    void moveToButtonPressed(ActionEvent event) {
        Robot.moveTo(Integer.parseInt(getX.getText()),Integer.parseInt(getY.getText()));
        printTextField(Robot.getX() + ", " + Robot.getY());
    }

    @FXML
    void moveUpButtonPressed(ActionEvent event) {
        
        Robot.moveUp();
        printTextField(Robot.getX() + ", " + Robot.getY());
    }
    
        @FXML
        void pickUpButtonPressed(ActionEvent event) {
        Robot.pickUp();
        printTextField(Robot.getX() + ", " + Robot.getY());
        
    }
   
    @FXML
    void printXY(ActionEvent event) {
        
        Robot.print();
        printTextField(Robot.getX() + ", " + Robot.getY());

    }

     public void printTextField(String text) {
        grid.setText(text + "\n");
    }
     
    


}