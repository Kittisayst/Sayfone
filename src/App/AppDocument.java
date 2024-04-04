package App;

import Controller.DocumentController;
import View.DocumentView;

public class AppDocument {

    private DocumentController controller;

    public AppDocument() {
        controller = new DocumentController(new DocumentView("ເອກະສານ"));
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
