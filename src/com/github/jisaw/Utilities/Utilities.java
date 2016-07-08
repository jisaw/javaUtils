package com.github.jisaw.Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;


public class Utilities {

  // NUMBER OF LINES
  public static int numberOfLines(final String pathStr) {
    return numberOfLines(new File(pathStr));
  }

  public static int numberOfLines(final Path path) {
    return numberOfLines(path.toFile());
  }

  /**
   * Counts the number of lines in a file
   * 
   * @param file
   * @return INTEGER - Number of lines in the given file
   */
  public static int numberOfLines(final File file) {
    BufferedReader reader = null;
    int lines = 0;
    try {
      reader = new BufferedReader(new FileReader(file));
      while (reader.readLine() != null) {
        lines++;
      }
    } catch (final IOException e) {
      // LOGGER.error(e.getMessage()); --- DO SOMETHING WITH YOUR ERROR
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (final IOException e) {
          // LOGGER.error(e.getMessage()); --- DO SOMETHING WITH YOUR ERROR
        }
      }
    }
    return lines;
  }
  // NUMBER OF LINES
}
