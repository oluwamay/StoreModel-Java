package StoreXmodel.Services.Interfaces;

import StoreXmodel.Users.Applicant;
import StoreXmodel.Users.Cashier;

public interface ManagerService {
    void hireCashier(Applicant applicant);
    void addToCashierList(Cashier cashier);
    void fireCashier(Cashier cashier);
    void payWage(Cashier cashier);
}
