package controller;

import view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author  Khyzhniak Slava (Slavus@i.ua)
 * @version 1
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
