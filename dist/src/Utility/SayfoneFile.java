package Utility;

import Tools.JoFileSystem;

public class SayfoneFile {

    public static String TeacherFolder = "TeacherFile";
    public static String TeacherFile = new JoFileSystem().getCurrentPath() + "/TeacherFile/example.pdf";

    public SayfoneFile() {
        JoFileSystem fileSystem = new JoFileSystem();
        if (fileSystem.isFile(TeacherFolder)) {
            fileSystem.CreateFolder(fileSystem.getCurrentPath(), TeacherFolder);
        }
    }

}
