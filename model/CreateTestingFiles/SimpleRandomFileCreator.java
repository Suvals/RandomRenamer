package model.CreateTestingFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * User: Main
 * Date: 10.07.2018
 */
public class SimpleRandomFileCreator implements SimpleFileFactory {

    private boolean state;
    private String finalMessage;
    private String endOfFile = ".txt";
    private static int i = 0;

    public SimpleRandomFileCreator(){
        state = false;
        finalMessage = "The file didn`t create now";
    }

    @Override
    public boolean getState() {

        return state;
    }

    @Override
    public Path createFile(Path path) {
        Path tempNewPath = path;
        if(Files.exists(path)){
             try {
              tempNewPath  =  Files.createFile(path.resolve((int)(Math.random() * hashCode())  + endOfFile));
                 state = true;
                 finalMessage = "Creating new file " + tempNewPath;
             } catch (IOException e) {
                 finalMessage = e.toString();
             }
         } else {
            finalMessage = "Root directory is wrong";
            state = false;
        }
        return tempNewPath;
    }

    @Override
    public String getFinalMessage() {
        return finalMessage;
    }
}
