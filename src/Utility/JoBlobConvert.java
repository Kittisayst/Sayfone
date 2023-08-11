package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

public class JoBlobConvert {

    private File file;

    public JoBlobConvert() {
    }

    public JoBlobConvert(File file) {
        this.file = file;
    }

    public InputStream getFileInput() throws Exception {
        InputStream stream = new FileInputStream(file);
        System.out.println("stream " + stream);
        return stream;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
