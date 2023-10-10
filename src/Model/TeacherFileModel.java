package Model;

import java.io.File;

public class TeacherFileModel extends FileModel {

    public TeacherFileModel() {
    }

//======== Extented========
    public TeacherFileModel(int FileID, int ID, String FlieName, String Comments, File file) {
        super(FileID, ID, FlieName, Comments, file);
    }
}
