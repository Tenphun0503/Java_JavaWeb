package myjava.practices.basic.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class MainFrame extends JFrame implements KeyListener {
    private int[][] data = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    private final int[][] dataV = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    private int zeroX = 3, zeroY = 3;
    private int step = 0;

    public MainFrame() throws HeadlessException {
        // first this is MainFrame extends JFrame, can be omitted
        // second this is MainFrame implements KeyListener
        this.addKeyListener(this);

        // init the frame
        initFrame();
        // init the data;
        initData();
        // paint the frame
        paintFrame();
        // render frame
        setVisible(true);
    }

    /**
     * This method is used to initialize the frame
     */
    private void initFrame() {
        // set frame size
        setSize(514, 595);
        // set frame close mode
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // set title
        setTitle("Game_V0.1");
        // frame always on the top
        setAlwaysOnTop(true);
        // create frame at the center
        setLocationRelativeTo(null);
        // cancel default layout
        setLayout(null);
    }

    /**
     * This method initialize and randomize data
     */
    private void initData() {
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int randomX = r.nextInt(4);
                int randomY = r.nextInt(4);
                swap(i, j, randomX, randomY);
            }
        }
        // record the coordination of 0
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (data[i][j] == 0) {
                    zeroX = i;
                    zeroY = j;
                }
            }
        }
    }

    /**
     * Paint Components
     */
    private void paintFrame() {
        getContentPane().removeAll();

        if(victory()){
            JLabel jWin = new JLabel("YOU WIN!!!");
            jWin.setBounds(180,250,270, 88);
            getContentPane().add(jWin);
        }

        JLabel jSteps = new JLabel("Steps: " + step);
        jSteps.setBounds(25,45, 100, 20);
        getContentPane().add(jSteps);

        JButton button = new JButton("Restart Game");
        button.setBounds(300, 45, 125, 20);
        button.setFocusable(false);
        button.addActionListener(e -> restart());
        getContentPane().add(button);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel jl = new JLabel(String.valueOf(data[i][j]));
                jl.setBounds(j * 100 + 50, i * 100 + 90, 100, 100);
                getContentPane().add(jl);
            }
        }
        getContentPane().repaint();
    }

    /**
     * restart the game
     */
    private void restart(){
        step = 0;
        initData();
        paintFrame();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        move(keyCode);
        paintFrame();
    }

    private void swap(int a, int b, int i, int j) {
        int tmp = data[a][b];
        data[a][b] = data[i][j];
        data[i][j] = tmp;
    }

    // Move function
    private void move(int keyCode) {
        if(victory())return;
        switch (keyCode) {
            case 37 -> {
                if (zeroY > 0) {
                    swap(zeroX, zeroY, zeroX, --zeroY);
                    step++;
                }
            }
            case 38 -> {
                if (zeroX > 0) {
                    swap(zeroX, zeroY, --zeroX, zeroY);
                    step++;
                }
            }
            case 39 -> {
                if (zeroY < 3) {
                    swap(zeroX, zeroY, zeroX, ++zeroY);
                    step++;
                }
            }
            case 40 -> {
                if (zeroX < 3) {
                    swap(zeroX, zeroY, ++zeroX, zeroY);
                    step++;
                }
            }
            case 90 -> {
                data = new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 0}
                };
            }
        }
    }

    // Check if win
    public boolean victory(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(data[i][j]!=dataV[i][j])return false;
            }
        }
        return true;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
