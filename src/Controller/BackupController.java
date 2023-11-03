package Controller;

import Database.JoProperties;
import Model.GlobalDataModel;
import Tools.JoAlert;
import Tools.JoFileSystem;
import Tools.JoFilechooser;
import Tools.JoHookEvent;
import Utility.MyFormat;
import View.BackupView;
import View.PnLoading;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

public class BackupController implements JoMVC, ActionListener {

    private BackupView view;
    private JoFilechooser filechooser;
    private JoFileSystem fileSystem;
    private JoProperties property = new JoProperties("/info/About.properties");
    private JoProperties sqlproperty = new JoProperties("/JoConfig/config.properties");
    private String user = sqlproperty.getValueAt("db.user");
    private String password = sqlproperty.getValueAt("db.password");
    private String database = sqlproperty.getValueAt("db.database");
    private String server = sqlproperty.getValueAt("db.Server");
    private String location = property.getValueAt("backup");
    private PnLoading loading;
    private static int totalFiles;
    private static int copiedFiles = 0;

    public BackupController(BackupView view) {
        this.view = view;
        filechooser = new JoFilechooser();
        fileSystem = new JoFileSystem();
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(view);
        view.setLocationBackup(location);
        loading = new PnLoading();
        loading.setTitle("ກຳລັງສຳຮອງຂໍ້ມູນ");
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtnBackup().addActionListener(this);
        view.getBtnBrowse().addActionListener(this);
    }

    @Override
    public void Create() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean emptyData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_back())) {
            GlobalDataModel.rootView.showDashbord();
        } else if (event.isEvent(view.getBtnBrowse())) {
            filechooser.setMode(JoFilechooser.Mode.Directories);
            boolean isOpen = filechooser.showOpenDialog(GlobalDataModel.rootView);
            if (isOpen) {
                location = filechooser.getSelectedFile().getPath();
                view.setLocationBackup(location);
                property.addValue("backup", location);
            }
        } else if (event.isEvent(view.getBtnBackup())) {
            GlobalDataModel.rootView.setView(loading);
            Thread thread = new Thread(() -> {
                backup();
            });
            thread.start();
        }
    }

    private void backup() {
        if (fileSystem.isEmptyFile(location)) {
            try {
                String backupFilePath = location + "/backup " + new MyFormat().getDateCustom(new Date(), "dd-MM-yyyy") + ".sql";
                System.out.println(backupFilePath);
                String dumpCommand = "C:/wamp64/bin/mariadb/mariadb10.10.2/bin/mysqldump";
                String[] command = {dumpCommand, "--user=" + user, "--password=" + password, "--host=" + server, database, "-r", backupFilePath};

                ProcessBuilder processBuilder = new ProcessBuilder(command);
                Process process = processBuilder.start();

                int exitCode = process.waitFor();

                if (exitCode == 0) {
                    copyData();
                } else {
                    new JoAlert().messages("ສຳຮອງຂໍ້ມູນ", "ສຳຮອງຂໍ້ມູນຜິດພາດ", JoAlert.Icons.error);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                loading.close();
                GlobalDataModel.rootView.setView(view);
                new JoAlert().messages("ສຳຮອງຂໍ້ມູນ", "ສຳຮອງຂໍ້ມູນສຳເລັດ", JoAlert.Icons.success);
            }
        } else {
            new JoAlert().messages("ບ່ອນຈັດເກັບ", "ບໍ່ສາມາດເປີດ: " + location + " ກະລຸນາກວດສອບບ່ອນຈັດເກັບໃໝ່", JoAlert.Icons.info);
        }
    }

    private void copyData() {
        Path source = Path.of("C:/wamp64/www/sayfone");
        Path destination = Path.of("D:/sayfone backup/API "+new MyFormat().getDateCustom(new Date(), "dd-MM-yyyy"));
        try {
            // Copy the source folder to the destination folder
            totalFiles = countFiles(source);
            copyFolder(source, destination);
            System.out.println("Folder copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyFolder(Path source, Path destination) throws IOException {
        Files.walkFileTree(source, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path targetDir = destination.resolve(source.relativize(dir));
                Files.createDirectories(targetDir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.copy(file, destination.resolve(source.relativize(file)), StandardCopyOption.REPLACE_EXISTING);
                copiedFiles++;
//                double progress = (double) copiedFiles / totalFiles * 100;
                loading.StartProgress(totalFiles, 10);
//                System.out.printf("Progress: %.2f%%\n", progress);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static int countFiles(Path directory) throws IOException {
        int count = 0;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path file : stream) {
                if (Files.isDirectory(file)) {
                    count += countFiles(file);
                } else {
                    count++;
                }
            }
        }
        return count;
    }

}
