/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Skrzypek
 */
public final class GomokuFrame extends javax.swing.JFrame {

    /**
     * Creates new form GomokuFrame
     */
    public int[][] tab;
    int player;
    boolean started;

    public GomokuFrame() {
        initComponents();
        tab = new int[19][19];
        player = 1;
        started = false;
        board.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (started) {
                    Point b = e.getPoint();
                    int x = (int) b.getX();
                    int y = (int) b.getY();
                    x /= 30;
                    y /= 30;
                    if (tab[x][y] == 0) {
                        tab[x][y] = player;
                        player = (player == 1) ? -1 : 1;
                        drawBoard();
                        System.out.println(checkBoard(x, y));

                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        board = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        board.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout boardLayout = new javax.swing.GroupLayout(board);
        board.setLayout(boardLayout);
        boardLayout.setHorizontalGroup(
            boardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );
        boardLayout.setVerticalGroup(
            boardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("test");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(board, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jButton2)
                        .addGap(143, 143, 143)
                        .addComponent(jButton1)))
                .addContainerGap(339, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(board, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        drawBoard();
        started = true;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tab[0][0] = 1;
        tab[1][2] = -1;
        tab[5][5] = 1;
        tab[18][18] = -1;
        tab[10][10] = 1;
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GomokuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GomokuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GomokuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GomokuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GomokuFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel board;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables

    public void drawBoard() {
        drawLines();
        drawPawns();
    }

    private void drawLines() {
        int act = 0;
        Graphics g = board.getGraphics();
        for (int i = 0; i < 20; i++) {
            g.drawLine(0, act, 570, act);
            g.drawLine(act, 0, act, 570);
            act += 30;
        }
    }

    private void drawPawns() {
        Graphics g = board.getGraphics();
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (tab[i][j] == 1) {
                    g.setColor(Color.red);
                    g.fillOval(i * 30, j * 30, 30, 30);
                }
                if (tab[i][j] == -1) {
                    g.setColor(Color.blue);
                    g.fillOval(i * 30, j * 30, 30, 30);
                }
            }
        }
    }

    private boolean checkBoard(int x, int y) {
        int p = tab[x][y];
        int counter = 0;
        int cx = x;
        int cy = y;

        //poziomo
        counter = 1;
        x--;
        while (x >= 0 && tab[x][y] == p) {
            counter++;
            x--;
        }
        x = cx;
        x++;
        while (x < 19 && tab[x][y] == p) {
            counter++;
            x++;
        }

        if (counter == 5) {
            return true;
        }
        x = cx;
        counter = 0;
        
        
        //pionowo
        counter = 1;
        y--;
        while (y >= 0 && tab[x][y] == p) {
            counter++;
            y--;
        }
        y = cy;
        y++;
        while (y < 19 && tab[x][y] == p) {
            counter++;
            y++;
        }

        if (counter == 5) {
            return true;
        }
        y = cy;
        counter = 0;
        
        
//        //skoks 1
        counter = 1;
        x--;
        y--;
        while (x >= 0 && y >= 0 && tab[x][y] == p) {
            counter++;
            x--;
            y--;
        }
        x = cx;
        y = cy;
        x++;
        y++;
        while (x < 19 && y < 19 && tab[x][y] == p) {
            counter++;
            x++;
            y++;
        }
        x = cx;
        y = cy;

        if (counter == 5) {
            return true;
        }
        counter = 0;
        
        
//        //skoks 2
        counter = 1;
        x--;
        y++;
        while (x >= 0 && y < 19 && tab[x][y] == p) {
            counter++;
            x--;
            y++;
        }
        x = cx;
        y = cy;
        x++;
        y--;
        while (x < 19 && y >= 0 && tab[x][y] == p) {
            counter++;
            x++;
            y--;
        }

        if (counter == 5) {
            return true;
        }


        return false;
    }
}
