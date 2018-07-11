package view;

import model.CreateRandomFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author  Hizhnyak Slava (Slavus@i.ua)
 * @version 1
 * Date: 15.03.2018
 *
 */
public class MainFrame extends JFrame {

    public static final String NAME_PROGRAM = "\"Random Renamer ";
    public static final String VERSION = "v.1\"   ";

    private static int default_width;
    private static int default_height;
    private String windowName = "Main window";
    private String fileName;
    private File testingDirectory;
    private JFileChooser chooser;
    private CreateRandomFiles createRandomFiles;

    static {

        Dimension window_size = Toolkit.getDefaultToolkit().getScreenSize();
        default_width = window_size.width / 4;
        default_height = window_size.height / 4;
    }

    public MainFrame() {

        setTitle(NAME_PROGRAM + VERSION + windowName);
        setSize(default_width, default_height);


        JMenu fileMenu = new JMenu("File");
        JMenuItem fileOpen = new JMenuItem("Open Directory");
        fileOpen.addActionListener(new FileOpenListener());
        fileMenu.add(fileOpen);

        JMenuItem exitButton = new JMenuItem("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitButton);
        chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        JMenuBar bar = new JMenuBar();
        bar.add(fileMenu);
        setJMenuBar(bar);


    }


    private class FileOpenListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            chooser.setCurrentDirectory(new File("."));
            int result = chooser.showOpenDialog(MainFrame.this);
            if(result == JFileChooser.APPROVE_OPTION){
                fileName = chooser.getSelectedFile().getAbsolutePath();
                testingDirectory = chooser.getSelectedFile();
                if(testingDirectory.isDirectory()) {
                    createRandomFiles = new CreateRandomFiles(testingDirectory);
                    alert(createRandomFiles.makeFiles());
                } else {
                    alert("You select isn`t directory. Please, reselect!!!");
                }
            }
        }
    }

    private void alert(String message){
         JOptionPane.showMessageDialog(this, message);
    }
}