/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import structures.Node;

/**
 *
 * @author Skrzypek
 */
public abstract class Game {
    
    int player;
    int DEPTH = 2;
    
    public abstract int boardRating(int[][] t, int p);
    
    public abstract void setPawn(int x, int y, int p, int[][] t, boolean[] td);
    
    public abstract void addTreeLevel(Node n, int pl);

    public void printTab(int[][] t) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    protected int[][] copy(int[][] tab) {
        int[][] c = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                c[i][j] = tab[i][j];
            }
        }
        return c;
    }
}
