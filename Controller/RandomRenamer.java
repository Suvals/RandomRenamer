package Controller;

import View.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * User: Main
 * Date: 24.08.2017
 */
public class RandomRenamer {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);

            }
        });
    }
}
