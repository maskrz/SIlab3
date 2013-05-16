/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Skrzypek
 */
public class Node implements Comparable {

    private ArrayList<Node> children;
    private int eval;
    private int depth;
    private int[][] board;
    private int x;
    private int y;

    public Node(int e, int[][] b) {
        children = new ArrayList();
        eval = e;
        depth = 0;
        board = b;
    }

    public Node(int e, int d) {
        children = new ArrayList();
        eval = e;
        depth = d;
    }

    public void addNode(Node n, int x, int y) {
        n.setDepth(depth + 1);
        n.setX(x);
        n.setY(y);
        children.add(n);
    }

    /**
     * @return the children
     */
    public ArrayList<Node> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    /**
     * @return the eval
     */
    public void calcEval(int a) {

        switch (a) {
            case 0:
                if (!children.isEmpty()) {
                    if (depth % 2 == 0) {
                        int e = Integer.MAX_VALUE;
                        for (Node n : children) {
                            n.calcEval(a);
                            if (n.getEval() < e) {
                                e = n.getEval();
                            }
                        }
                    } else {
                        int e = Integer.MIN_VALUE;
                        for (Node n : children) {
                            n.calcEval(a);
                            if (n.getEval() > e) {
                                e = n.getEval();
                            }
                        }
                    }
                }
            case 1:
                if (!children.isEmpty()) {
                    eval = 0;
                    for (Node n : children) {
                        n.calcEval(a);
                        eval += n.getEval();
                    }
                }
            case 2:
                if (!children.isEmpty()) {
                    for (Node n : children) {
                        n.calcEval(a);
                    }
                    Collections.sort(children);
                    if (depth % 2 == 1) {
                        eval = children.get(children.size() - 1).getEval();
                    } else {
                        eval = children.get(0).getEval();
                    }
                }
            default:
                if (!children.isEmpty()) {
                    eval = 0;
                    for (Node n : children) {
                        n.calcEval(a);
                        eval += n.getEval();
                    }
                }
        }
    }

    public int alphabeta(int alp, int bet, boolean max) {
        if (children.isEmpty()) {
            return this.getEval();
        }
        if (!max) {
            for (Node n : children) {
                alp = Math.max(alp, n.alphabeta(alp, bet, !max));
                if (bet <= alp) {
                    break;
                } 
            }
            return alp;
        }
        else {
            for (Node n : children) {
                bet = Math.max(bet, n.alphabeta(alp, bet, !max));
                if (bet <= alp) {
                    break;
                }
            }
            return bet;
        }
    }

    public void reduceDepth() {
        depth--;
        if (!children.isEmpty()) {
            for (Node n : children) {
                n.reduceDepth();
            }
        }
    }

    public Node getChoosenNode(int x, int y) {
        for (Node n : children) {
            if (n.getX() == x && n.getY() == y) {
                return n;
            }
        }
        return null;
    }

    public String paths() {
        String s = "";
        for (Node n : children) {
            s += n;
        }
        return s;
    }

    public String bestPath(int p) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int ev;
        String smin = "";
        String smax = "";
//        System.out.println(this);
        for (Node n : children) {
            ev = n.getEval();
//            System.out.println(n);
            if (ev < min) {
                min = ev;
                smin = n.getX() + " " + n.getY() + " ";
            }
            if (ev > max) {
                max = ev;
                smax = n.getX() + " " + n.getY() + " ";
            }
        }
//        System.out.println("min: " +smin + " max : "+smax);
        if (p > 0) {
            return smax + max;
        } else {
            return smin + min;
        }
    }

    /**
     * @param eval the eval to set
     */
    public void setEval(int eval) {
        this.eval = eval;
    }

    /**
     * @return the eval
     */
    public int getEval() {
        return eval;
    }

    /**
     * @return the depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * @param depth the depth to set
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * @return the board
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(int[][] board) {
        this.board = board;
    }

    @Override
    public String toString() {
        String res = "";
        res += "children: " + children.size() + ", eval: " + eval + ", depth: " + depth + ", x: " + x + ", y: " + y + " | ";

        return res;
    }

    public void printTree() {

        if (!children.isEmpty()) {
            System.out.println("");
            for (Node node : children) {
                System.out.print(node);
            }
            for (Node node : children) {
                node.printTree();
            }
        }
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {
        if (eval > ((Node) o).getEval()) {
            return 1;
        }
        if (eval < ((Node) o).getEval()) {
            return -1;
        }
        return 0;
    }
}
