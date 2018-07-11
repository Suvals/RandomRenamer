package model.createTestingFiles;

import java.nio.file.Path;

/**
 * User: Main
 * Date: 10.07.2018
 *
 * Main interface of any objects, that can create file/directory using some rules.
 *
 */
public interface SimpleFileFactory {


    /**
      * @return  {@code true}  if file/directory success created
     */
   boolean getState();

   Path createFile(Path path);

   String getFinalMessage();
}
