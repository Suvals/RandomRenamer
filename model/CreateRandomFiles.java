package model;

import model.createTestingFiles.SimpleRandomDirectoryCreator;
import model.createTestingFiles.SimpleRandomFileCreator;
import model.createTestingFiles.SimpleFileFactory;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * User: Main
 * Date: 07.07.2018
 */
public class CreateRandomFiles {

    private File directory;
    private Path pathForCreate;
    private SimpleFileFactory fileFactory;
    private Set<Path> pathList = new HashSet<Path>();
    private List<SimpleFileFactory> fileCreatorsList = new ArrayList<SimpleFileFactory>();


    private int amountOfFiles = 100;


    public CreateRandomFiles(File directory) {
        this.directory = directory;
        pathForCreate = Paths.get(directory.getAbsolutePath());
        pathList.add(pathForCreate);


    }

    public String makeFiles() {

        setListCreators();
        Path tmpPath;
        for (int i = 0; i < amountOfFiles; i++) {
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

        return "The files/directories created success";
    }


    private int getRandomNumber(int i) {
        return (int) (Math.random() * i);
    }

    private void setListCreators() {

        fileCreatorsList.add(new SimpleRandomFileCreator());
        fileCreatorsList.add(new SimpleRandomDirectoryCreator());
    }
}
