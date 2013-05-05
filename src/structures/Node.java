/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import java.util.ArrayList;

/**
 *
 * @author Skrzypek
 */
public class Node {

    private ArrayList<Node> children;
    private int eval;

    public Node(int e) {
        children = new ArrayList();
        eval = e;
    }
    
    public void addNode(Node n) {
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
    public void calcEval() {
        if (!children.isEmpty()) {
            eval = 0;
            for (Node n : children) {
                n.calcEval();
                eval += n.getEval();
            }
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
}
