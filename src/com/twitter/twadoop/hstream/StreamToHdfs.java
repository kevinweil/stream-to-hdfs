package com.twitter.twadoop.hstream;

import java.io.BufferedInputStream;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class StreamToHdfs {
  public static void main(String[] args) throws IOException {
    if (args.length != 1) {
      System.err.println("Usage: " + StreamToHdfs.class + " <hdfs file to write>");
      System.exit(1);
    }

    FileSystem fs = FileSystem.get(new Configuration());
    Path outputPath = new Path(args[0]);

    if (fs.exists(outputPath)) {
      System.err.println("Given path " + outputPath + " exists already in HDFS.");
      System.exit(1);
    }

    BufferedInputStream is = new BufferedInputStream(System.in);
    FSDataOutputStream os = fs.create(outputPath);
    IOUtils.copyBytes(is, os, 4096, true);
    System.out.println("Created file " + outputPath + " of length " + 
                       fs.getFileStatus(outputPath).getLen() + " bytes.");
  }
}
