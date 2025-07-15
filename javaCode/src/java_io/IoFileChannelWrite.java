package java_io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class IoFileChannelWrite {
    public static void main(String[] args) {

        try (FileChannel fc = (FileChannel) Files.newByteChannel(Path.of("test1.txt"),
                StandardOpenOption.WRITE, StandardOpenOption.CREATE
                )) {
            ByteBuffer bf = ByteBuffer.allocate(26);
            for (int i=0;i<26;i++) bf.put((byte)('A'+i));
            bf.rewind();
            fc.write(bf);

        } catch (IOException e) {
            System.out.println("Error input-output");
        }
    }
}
