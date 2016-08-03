package com.github.jisaw.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileService {

  private final static Logger LOGGER = LoggerFactory.getLogger(FileService.class);

  public static String getFileContents(Path path) {
    try {
      final byte[] encoded = Files.readAllBytes(path);
      return new String(encoded, Charset.defaultCharset());
    } catch (final Exception e) {
      LOGGER.error(e.getMessage());
      return null;
    }
  }

  public static String getFileContents(File file) {
    return getFileContents(file.toPath());
  }

  public static String getFileContents(Path path, Charset charset) {
    try {
      final byte[] encoded = Files.readAllBytes(path);
      return new String(encoded, charset);
    } catch (final Exception e) {
      LOGGER.error(e.getMessage());
      return null;
    }
  }

  public static String getFileContents(File file, Charset charset) {
    return getFileContents(file.toPath(), charset);
  }

  public File getFileFromResources(String fileName) {
    final ClassLoader classLoader = getClass().getClassLoader();
    return new File(classLoader.getResource(fileName).getFile());
  }

}
