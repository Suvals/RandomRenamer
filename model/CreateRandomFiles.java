package model;

import model.CreateTestingFiles.SimpleRandomFileCreator;
import model.CreateTestingFiles.SimpleFileFactory;

import java.io.File;
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
    private HashSet<Path> pathSet = new HashSet<Path>();
    private List<SimpleFileFactory> fileCreatorsList = new ArrayList<SimpleFileFactory>();

    private int amountOfFiles = 50;


    public CreateRandomFiles(File directory) {
        this.directory = directory;
        pathForCreate = Paths.get(directory.getAbsolutePath());
        pathSet.add(pathForCreate);
        fileCreatorsList.add(new SimpleRandomFileCreator());
    }

    public String makeFiles() {

        Path tmpPath = null;

        for(int i = 0; i < amountOfFiles; i++){
            ArrayList<Path> tempListPaths = new ArrayList<Path>(pathSet);
             fileFactory = fileCreatorsList.get(getRandomNumber(fileCreatorsList.size()));
           tmpPath =  fileFactory.createFile(tempListPaths.get(getRandomNumber(tempListPaths.size())));
            System.out.println(fileFactory.getFinalMessage());
            pathSet.add(tmpPath.getParent());
        }

        System.out.println(pathSet);



      /*  if(directory.isDirectory()){
              for(int i = 0; i < 50; i++){
                  path = Paths.get(directory.getAbsolutePath() + "\\" + i + ".txt");
                  path1 = Paths.get(directory.getAbsolutePath() + "\\" + i);
                  try {
                      if(!Files.exists(path) || !Files.exists(path1)) {
                         Files.createFile(path);
                          Files.createDirectory(path1);
                      }
                  } catch (IOException e) {
                      e.printStackTrace();
                      return e.getMessage();
                  }
              }
            return "Файлы успешно созданы";
        }
        return "Вы не выбрали директорию " + directory.getAbsolutePath();  */
        return null;
    }


    private int getRandomNumber(int i){
        return  (int) Math.random() * i;
    }

}
