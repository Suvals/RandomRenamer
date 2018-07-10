package model.CreateTestingFiles;

import javax.naming.spi.DirStateFactory;
import java.nio.file.Path;

/**
 * User: Main
 * Date: 10.07.2018
 */
public interface SimpleFileFactory {

 public boolean getState();

  public Path createFile(Path path);

  public String getFinalMessage();
}
