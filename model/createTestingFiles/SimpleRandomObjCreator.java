package model.createTestingFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author  Khyzhniak Slava (Slavus@i.ua)
 * @version 1
 */
public class SimpleRandomObjCreator implements SimpleObjFactory {

    private boolean state;
    private String finalMessage;
    private String endOfFile = ".txt";

    public SimpleRandomObjCreator() {
        state = false;
        finalMessage = "The file didn`t create now";
    }

    @Override
    public boolean getState() {
        return state;
    }

    @Override
    public Path createFile(Path path) {
        state = false;
        if (path == null) {
            finalMessage = "The path is null. File can`t be create";
            return  path;
        }

        Path tmpPath = path;

        if (Files.exists(tmpPath)) {
            try {
                tmpPath = Files.createFile(path.resolve((int) (Math.random() * hashCode()) + endOfFile));
                state = true;
                finalMessage = "Creating new file " + tmpPath;
            } catch (IOException e) {
                finalMessage = e.toString();
            }
        } else {
            finalMessage = "The path isn`t exist. Trying parent directory of path";
            createFile(path.getParent());
        }
        return tmpPath.getParent();
    }

    @Override
    public String getFinalMessage() {
        return finalMessage;
    }
}
