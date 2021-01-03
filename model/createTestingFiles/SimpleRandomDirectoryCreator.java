package model.createTestingFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author  Khyzhniak Slava (Slavus@i.ua)
 * @version 1
 */
public class SimpleRandomDirectoryCreator implements SimpleObjFactory {

    private boolean state;
    private String finalMessage;

    public SimpleRandomDirectoryCreator(){
        state = false;
        finalMessage = "The directory isn`t create now";
    }

    @Override
    public boolean getState() {
        return state;
    }
    @Override
    public Path createFile(Path path) {

        state = false;
        if(path == null){
            finalMessage = "The path is null. Directory can`t be create";
            return  path;
        }
        Path tmpPath = path;
        if(Files.exists(tmpPath)){
            try {
               // tmpPath = Files.createDirectory(tmpPath.resolve(String.valueOf(Math.random() * hashCode())));
                 tmpPath = Files.createDirectory(tmpPath.resolve("1"));
                state = true;
                finalMessage = "Creating new directory " + tmpPath;
            } catch (IOException e) {
                finalMessage = e.toString();
            }
        } else {
            finalMessage = "The path isn`t exist. Trying parent directory of path";
            createFile(path.getParent());
        }


        return tmpPath;
    }

    @Override
    public String getFinalMessage() {
        return finalMessage;
    }
}
