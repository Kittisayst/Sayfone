package Controller;

import App.AppDashboard;
import App.AppHome;
import Component.DialogTutorial;
import Model.TutorialModel;
import Tools.JoFileSystem;
import Tools.JoHookEvent;
import View.HomeView;
import View.TutorialView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TutorialController implements JoMVC, ActionListener {

    private final TutorialView view;

    public TutorialController(TutorialView view) {
        this.view = view;
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        view.showTutorial(ReadFileTutorial());

    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
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
            AppDashboard dashboard = new AppDashboard();
        }
    }

    private List<TutorialModel> ReadFileTutorial() {
        List<TutorialModel> models = new ArrayList<>();
        JoFileSystem fileSystem = new JoFileSystem();
        String folderPath = fileSystem.getCurrentPath() + "/Tutorial";
        File folder = new File(folderPath);

        // Get a list of files in the folder
        File[] files = folder.listFiles();

        // Check if the folder is empty
        if (files == null || files.length == 0) {
            models.add(new TutorialModel("ບໍ່ພົບຂໍ້ມູນ", "ບໍ່ມີໄຟລ໌ໃນ" + folderPath, "null", folder, new MouseAdapter() {
            }));
        }

        Arrays.sort(files, (File f1, File f2) -> {
            long modTime1 = f1.lastModified();
            long modTime2 = f2.lastModified();
            return Long.compare(modTime1, modTime2);
        });

        int no = 1;
        for (File file : files) {
            if (file.isFile()) {
                models.add(new TutorialModel("ວິທີການ", no++ +" "+file.getName(), "0", file, new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        DialogTutorial tutorial = new DialogTutorial(AppHome.viewParent, true, file.getName(), file);
                        tutorial.setVisible(true);
                        super.mousePressed(e);
                    }
                }));
            }
        }
        return models;
    }

}
