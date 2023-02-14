package StoreXmodel.Services.ServiceImplementations;

import StoreXmodel.Services.Interfaces.ManagerService;
import StoreXmodel.Users.Applicant;
import StoreXmodel.Users.Cashier;
import StoreXmodel.Users.Manager;

public class ManagerServiceImpl implements ManagerService {

    private Manager manager;
    public ManagerServiceImpl (Manager manager){
        this.manager = manager;
    }

    @Override
    public void hireCashier(Applicant applicant){
        manager.hireCashier(applicant);
    }
    @Override
    public void addToCashierList(Cashier cashier){
        manager.addToCashierList(cashier);
    }
    @Override
    public void fireCashier(Cashier cashier){
        manager.fireCashier(cashier);
    }
    @Override
    public void payWage(Cashier cashier){
        manager.payWage(cashier);
    }
}
