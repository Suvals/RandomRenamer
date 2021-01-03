package model.createTestingFiles;

import java.nio.file.Path;

/**
 * @author  Khyzhniak Slava (Slavus@i.ua)
 * @version 1
 *
 * Main interface of any objects, that can create file/directory using some rules.
 *
 */
public interface SimpleObjFactory {


    /**
     * Main interface, for creators(files/folders/disks etc.)
      * @return  {@code true}  if file/directory success created
     */
   boolean getState();

   Path createFile(Path path);

   String getFinalMessage();
}
