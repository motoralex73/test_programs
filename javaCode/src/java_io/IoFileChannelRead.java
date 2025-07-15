package java_io;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;

public class IoFileChannelRead {
    public static void main(String[] args) {
        try (FileChannel fc = (FileChannel) Files.newByteChannel(Path.of("test.txt"))) {
            long fSize = fc.size();
            System.out.println(fSize);
            MappedByteBuffer mBuf = fc.map(FileChannel.MapMode.READ_ONLY, 0, fSize);
            for (int i = 0; i < fSize; i++) System.out.print((char)mBuf.get());

        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
