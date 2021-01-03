package model;

import model.createTestingFiles.SimpleRandomDirectoryCreator;
import model.createTestingFiles.SimpleRandomObjCreator;
import model.createTestingFiles.SimpleObjFactory;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author  Khyzhniak Slava (Slavus@i.ua)
 * @version 1
 */
public class CreateRandomFiles {

    private File directory;
    private Path pathForCreate;
    private SimpleObjFactory fileFactory;
    private Set<Path> pathList = new HashSet<Path>();
    private List<SimpleObjFactory> fileCreatorsList = new ArrayList<SimpleObjFactory>();
    private int amountOfFiles = 100;


    public CreateRandomFiles(File directory) {
        this.directory = directory;
        pathForCreate = Paths.get(this.directory.getAbsolutePath());
        pathList.add(pathForCreate);


    }

    public String makeFiles() {

        setListCreators();
        for (int i = 0; i < amountOfFiles; i++) {
            Path tmpPath;
            if(Files.exists(pathForCreate)) {
                ArrayList<Path> tempListPaths = new ArrayList<Path>(pathList);
                fileFactory = fileCreatorsList.get(getRandomNumber(fileCreatorsList.size()));
                tmpPath = fileFactory.createFile(tempListPaths.get(getRandomNumber(tempListPaths.size())));
                System.out.println(fileFactory.getFinalMessage());
                System.out.println(tmpPath);
                if (!(tmpPath == null) & fileFactory.getState()) {
                    pathList.add(tmpPath);
                }
            } else {
                return "The start Path doesn`t exist no more";
            }
        }

        for(Path p: pathList) {
            System.out.println(p);
        }
        pathList.clear();

        return "The files/directories success created";
    }


    private int getRandomNumber(int i) {
        return (int) (Math.random() * i);
    }

    private void setListCreators() {

        fileCreatorsList.add(new SimpleRandomObjCreator());
        fileCreatorsList.add(new SimpleRandomDirectoryCreator());
    }
}
