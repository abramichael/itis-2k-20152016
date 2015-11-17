import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * Created by ma on 17.11.2015.
 */
public class Saper extends JFrame {
    private int size;
    private int minesNumber;
    private int buttonSize = 50;
    private int[][] field;

    public Saper(int s, int i1) {

        size = s;
        minesNumber = i1;

        setLayout(new GroupLayout(getContentPane()));
        generateField();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton jb = new JButton();
                jb.setBounds(j * buttonSize, i * buttonSize, buttonSize, buttonSize);
                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton jb1 = (JButton) e.getSource();
                        int x = jb1.getX() / buttonSize;
                        int y = jb1.getY() / buttonSize;
                        if (field[y][x] == 1) {
                            jb1.setText("X");
                        } else {
                            int count = countMinesAround(y, x);
                            jb1.setText(count + "");
                        }
                        jb1.setEnabled(false);
                    }
                });
                jb.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            JButton jb1 = (JButton) e.getSource();
                            if (jb1.getText().equals("P"))
                                jb1.setText("");
                            else
                                jb1.setText("P");


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
                add(jb);
            }
        }

        setBounds(0, 0, buttonSize * size + 50, buttonSize * size + 50);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private int countMinesAround(int x, int y) {
        int s = 0;
        for (int i = -1; i <= 1; i++) {
            if (x + i >= 0 && x + i < size) {
                for (int j = -1; j <= 1; j++) {
                    if (y + j >= 0 && y + j < size)
                        s += field[x + i][y + j];
                }
            }
        }
        return s;
    }

    private void generateField() {
        field = new int[size][size];
        Random r = new Random();
        int k = 0;
        while (k < minesNumber) {
            int i = r.nextInt(size);
            int j = r.nextInt(size);
            if (field[i][j] == 0) {
                field[i][j] = 1;
                k++;
            }
        }
    }

    public static void main(String[] args) {

        new Saper(10, 10);
    }
}
