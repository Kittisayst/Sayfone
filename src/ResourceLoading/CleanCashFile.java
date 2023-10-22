package ResourceLoading;

import Tools.JoFileSystem;

public class CleanCashFile {

    public boolean clearFile() {
        JoFileSystem fileSystem = new JoFileSystem();
        String path = fileSystem.getCurrentPath() + "/ResizeImage";
        fileSystem.DeleteFolder(path);
        fileSystem.CreateFolder(fileSystem.getCurrentPath(), "ResizeImage");
        return true;
    }

}
