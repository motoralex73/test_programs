package java_io;

import java.io.File;
import java.io.FilenameFilter;

public class IoFile {

    static void fileFunction() {
        File f = new File("/");
        if (f.isDirectory()) {
            String[] s = f.list();
            for (int i = 0; i < f.length(); i++) {
                File ff = new File("/" + s[i]);
                if (ff.isDirectory()) System.out.println(s[i] + " - каталог");
                else System.out.println(s[i] + " - файл");
            }
        }
        else System.out.println("здесь отсутствуют каталоги");
    }

    static public class OnlyExt implements FilenameFilter {
        String ext;
        public OnlyExt(String ext) {
            this.ext = "." + ext;
        }
        public boolean accept(File dir, String name) {
            return name.endsWith(ext);
        }
    }

    static void dirListOnly() {
        String dirname = "java";
        File f = new File(dirname);
        FilenameFilter only = new OnlyExt("html");
        String[] s = f.list(only);
        assert s != null;
        for (String string : s) System.out.println(string);
    }

    public static void main(String[] args) {
        fileFunction();
        //dirListOnly();
    }
}
