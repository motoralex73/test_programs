package java_io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;

public class IoInputOutputChannel {
    public static void main(String[] args) {
        int count = 0;
        try (SeekableByteChannel sch = Files.newByteChannel(Path.of("test.txt"))) {
            ByteBuffer bf = ByteBuffer.allocate(128);
            do {
                count = sch.read(bf);
                if (count != -1) {
                    bf.rewind();
                    for (int i = 0; i < count; i++) System.out.print((char)bf.get());
                }
            }
            while (count != -1);
        }
        catch (IOException e) {
            System.out.println("Error input-output");
        }
    }
}
