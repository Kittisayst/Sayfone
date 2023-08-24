package Controller;

import DAOSevervice.WithdrawService;
import Model.WithdrawModel;
import View.HomeView;
import View.WithDrawView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawController implements JoMVC, ActionListener {

    private WithDrawView view;
    private WithdrawModel model;

    public WithdrawController(WithDrawView view, WithdrawModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        view.showWithdraw(new WithdrawService().getWithdrawAll());
    }

    @Override
    public void AddEvent() {
        
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
