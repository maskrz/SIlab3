/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import structures.Node;

/**
 *
 * @author Skrzypek
 */
public class Reversi extends Game {

    boolean moves1;
    boolean pawnAmount1;
    boolean pawnPositions1;
    boolean pawnAmount2;
    boolean moves2;
    boolean pawnPositions2;

    public Reversi(boolean m1, boolean pa1, boolean pp1, boolean m2, boolean pa2, boolean pp2) {
        moves1 = m1;
        pawnAmount1 = pa1;
        pawnPositions1 = pp1;
        moves2 = m2;
        pawnAmount2 = pa2;
        pawnPositions2 = pp2;
    }

    @Override
    public int boardRating(int[][] t, int p) {
        int eval = 0;
        int[][] c = copy(t);
        boolean[] td = new boolean[8];
        if (p == 1) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (moves1 && canSetPawn(i, j, 1, c, td)) {
                        eval++;
                    }
                    if (moves1 && canSetPawn(i, j, -1, c, td)) {
                        eval--;
                    }
                    if (pawnAmount1) {
                        eval += t[i][j] * 5;
                    }
                    if (pawnPositions1 && t[i][j] != 0) {
                        int pl = t[i][j];
                        if (i == 0 || i == 7) {
                            if (j == 0 || j == 7) {
                                //rogi
                                eval = eval + (pl * 50);
                            } else if (j == 1 || j == 6) {
                                //przy rogach
                                eval = eval + (pl * (-10));
                            } else {
                                //boki
                                eval = eval + (pl * 12);
                            }
                        } else if (i == 1 || i == 6) {
                            if (j < 2 || j > 5) {
                                //przy rogach
                                eval = eval + (pl * (-10));
                            } else {
                                eval = eval + (pl * (-3));
                            }
                        } else {
                            if (j == 0 || j == 7) {
                                eval = eval + (pl * 12);
                            } else if (j == 1 || j == 6) {
                                eval = eval + (pl * (-3));
                            } else {
                                eval = eval + (pl * 3);
                            }
                        }
                    }
                }
            }
        }
        else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (moves2 && canSetPawn(i, j, 1, c, td)) {
                        eval++;
                    }
                    if (moves2 && canSetPawn(i, j, -1, c, td)) {
                        eval--;
                    }
                    if (pawnAmount2) {
                        eval += t[i][j] * 5;
                    }
                    if (pawnPositions2 && t[i][j] != 0) {
                        int pl = t[i][j];
                        if (i == 0 || i == 7) {
                            if (j == 0 || j == 7) {
                                //rogi
                                eval = eval + (pl * 50);
                            } else if (j == 1 || j == 6) {
                                //przy rogach
                                eval = eval + (pl * (-10));
                            } else {
                                //boki
                                eval = eval + (pl * 12);
                            }
                        } else if (i == 1 || i == 6) {
                            if (j < 2 || j > 5) {
                                //przy rogach
                                eval = eval + (pl * (-10));
                            } else {
                                eval = eval + (pl * (-3));
                            }
                        } else {
                            if (j == 0 || j == 7) {
                                eval = eval + (pl * 12);
                            } else if (j == 1 || j == 6) {
                                eval = eval + (pl * (-3));
                            } else {
                                eval = eval + (pl * 3);
                            }
                        }
                    }
                }
            }
        }

        if (isFinished(t)) {
            eval = eval + (getWinner(t) * 1000);
        }

        return eval;
    }

    public boolean canSetPawn(int x, int y, int p, int[][] t, boolean[] td) {
        boolean result = false;
        if (t[x][y] != 0) {
            return false;
        }
        int cx = x;
        int cy = y;
        int np = (p == 1) ? -1 : 1;

        // lewo
        x--;
        while (x >= 0 && t[x][y] == np) {
            x--;
        }
        x++;
        if (x != cx && x != 0 && t[x - 1][y] == p) {
            result = true;
            td[0] = true;
        }
        x = cx;


        //prawo
        x++;
        while (x < 8 && t[x][y] == np) {
            x++;
        }
        x--;
        if (x != cx && x != 7 && t[x + 1][y] == p) {
            result = true;
            td[1] = true;
        }
        x = cx;


        //gora
        y--;
        while (y >= 0 && t[x][y] == np) {
            y--;
        }
        y++;
        if (y != cy && y != 0 && t[x][y - 1] == p) {
            result = true;
            td[2] = true;
        }
        y = cy;


        //dol
        y++;
        while (y < 8 && t[x][y] == np) {
            y++;
        }
        y--;
        if (y != cy && y != 7 && t[x][y + 1] == p) {
            result = true;
            td[3] = true;
        }
        y = cy;



        //skos1
        x--;
        y--;
        while (x >= 0 && y >= 0 && t[x][y] == np) {
            x--;
            y--;
        }
        x++;
        y++;
        if (x != cx && y != cy && x != 0 && y != 0 && t[x - 1][y - 1] == p) {
            result = true;
            td[4] = true;
        }
        x = cx;
        y = cy;



        //skos2
        x++;
        y++;
        while (x < 8 && y < 8 && t[x][y] == np) {
            x++;
            y++;
        }
        x--;
        y--;
        if (x != cx && y != cy && x != 7 && y != 7 && t[x + 1][y + 1] == p) {
            result = true;
            td[5] = true;
        }
        x = cx;
        y = cy;



        //skos3
        x--;
        y++;
        while (x >= 0 && y < 8 && t[x][y] == np) {
            x--;
            y++;
        }
        x++;
        y--;
        if (x != cx && y != cy && y != 7 && x != 0 && t[x - 1][y + 1] == p) {
            result = true;
            td[6] = true;
        }
        x = cx;
        y = cy;



        //skos4
        x++;
        y--;
        while (x < 8 && y >= 0 && t[x][y] == np) {
            x++;
            y--;
        }
        x--;
        y++;
        if (x != cx && y != cy && x != 7 && y != 0 && t[x + 1][y - 1] == p) {
            result = true;
            td[7] = true;
        }

        return result;
    }

    @Override
    public void setPawn(int x, int y, int p, int[][] t, boolean[] td) {
        t[x][y] = p;
        recalcBoard(x, y, p, t, td);
    }

    public void recalcBoard(int x, int y, int player1, int[][] t, boolean[] td) {
        int cx = x;
        int cy = y;
//        for(int i = 0; i < 8; i++) System.out.print(td[i]);
        if (td[0]) {
            x--;
            while (t[x][y] != player1) {
                t[x][y] = player1;
                x--;
            }
            x = cx;
        }

        if (td[1]) {
            x++;
            while (t[x][y] != player1) {
                t[x][y] = player1;
                x++;
            }
            x = cx;
        }

        if (td[2]) {
            y--;
            while (t[x][y] != player1) {
                t[x][y] = player1;
                y--;
            }
            y = cy;
        }

        if (td[3]) {
            y++;
            while (t[x][y] != player1) {
                t[x][y] = player1;
                y++;
            }
            y = cy;
        }

        if (td[4]) {
            x--;
            y--;
            while (t[x][y] != player1) {
                t[x][y] = player1;
                x--;
                y--;
            }
            x = cx;
            y = cy;
        }

        if (td[5]) {
            x++;
            y++;
            while (t[x][y] != player1) {
                t[x][y] = player1;
                x++;
                y++;
            }
            x = cx;
            y = cy;
        }

        if (td[6]) {
            x--;
            y++;
            while (t[x][y] != player1) {
                t[x][y] = player1;
                x--;
                y++;
            }
            x = cx;
            y = cy;
        }

        if (td[7]) {
            x++;
            y--;
            while (t[x][y] != player1) {
                t[x][y] = player1;
                x++;
                y--;
            }
        }

    }

    @Override
    public void addTreeLevel(Node n, int pl) {
        int[][] c = copy(n.getBoard());
        ArrayList<Node> children = n.getChildren();
        if (children.isEmpty()) {
            boolean[] td = new boolean[8];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (canSetPawn(i, j, pl, c, td)) {
                        setPawn(i, j, pl, c, td);
                        recalcBoard(i, j, pl, c, td);
                        Node node = new Node(boardRating(c, pl), c);
                        n.addNode(node, i, j);
                        resetTd(td);
                        c = copy(n.getBoard());
                    }
                }
            }
        } else {
            pl*=-1;
            for (Node node : children) {
//                System.out.println("siema");
                addTreeLevel(node, pl);
            }
        }
    }

    public void resetTd(boolean[] td) {
        for (int i = 0; i < 8; i++) {
            td[i] = false;
        }
    }

    public int[] result(int[][] t) {
        int[] res = new int[2];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (t[i][j] == 1) {
                    res[0]++;
                }
                if (t[i][j] == -1) {
                    res[1]++;
                }
            }
        }


        return res;
    }

    public boolean isFinished(int[][] t) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (t[i][j] == 0) {
//                    System.out.println(i + " "+ j +" "+canSetPawn(j, i, -1, t, new boolean[8]));
                    return false;
                }
            }
        }
//        System.out.println("tak");
        return true;
    }

    public int getWinner(int[][] t) {
        int w = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                w += t[i][j];
            }
        }
        if (w > 0) {
            return 1;
        } else if (w < 0) {
            return -1;
        } else {
            return 0;
        }

    }
}
