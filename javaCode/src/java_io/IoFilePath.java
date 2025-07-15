package java_io;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class IoFilePath {

    public static void main(String[] args) {
        Path p = Path.of("test.txt");
        System.out.println("Abs way: " + p.toAbsolutePath());
        System.out.println("File name: " + p.getFileName());
        System.out.println("Get parent: " + p.getParent());

        Files.isWritable(p);
        Files.isReadable(p);

        try
        {
            BasicFileAttributes att = Files.readAttributes(p, BasicFileAttributes.class);
            System.out.println(att.lastModifiedTime());
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }
}
