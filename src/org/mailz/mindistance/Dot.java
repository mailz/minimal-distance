/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mailz.mindistance;

/**
 *
 * @author ubick
 */
public class Dot {

    private int x, y;



    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Dot() {
  this.x = 0;
        this.y = 0;
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
    
    @Override
    public String toString(){
        return ("X: " + x + " Y: " + y);
    }

}
