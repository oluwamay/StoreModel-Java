package StoreXmodel.Users;

import StoreXmodel.Product;
import StoreXmodel.Store;

public class Manager extends User {

    private Store store;
    double totalWagesPaid = 0;

    public Manager(String name, int userId, Store store) {
        super(name, userId);
        this.store = store;
        System.out.println(store.getName() + " Manager: \n" + name + " ID: " + userId + " Store: " + store.getName());
    }

    public Store getStore() {
        return store;
    }

    public void hireCashier(Applicant applicant) {
        if (applicant.getQualification() == true && applicant.getAge() >= 18 && applicant.getAge() <= 30) {
            //Checks if applicant has a WASSCE and is between the ages of 18 & 30
            System.out.println("Congratulations " + applicant.getName() + " you have been hired");
            applicant.setStatus(true);

        } else {
            System.out.println("Sorry, " + applicant.getName() + " you are not qualified");
            applicant.setStatus(false);
        }
    }

    public void addToCashierList(Cashier cashier) {
        //Add successful applicant to cashier list
        store.setCashiersList(cashier);
        System.out.println("Employee name: " + cashier.getName() + "\n User ID: " + cashier.getUserID()
                + "\nYou have been assigned to: " + cashier.getStore().getName());
    }


    public void fireCashier(Cashier cashier) {

        //Remove cashier from Cashier List
        for (Cashier staff : store.getCashiersList()) {
            if (staff.getUserID() == cashier.getUserID()) {
                if (cashier.getSales() < 1) {
                    System.out.println("Sadly, we have to let you go " + staff.getName() + ". Your performance is below par, all the best.");
                    store.getCashiersList().remove(staff);
                    break;
                }
            }
        }
    }

    public void payWage(Cashier cashier) {

        if (store.getStoreBalance() > cashier.getSalary()) {
            /**
             * Deduct wages from store balance
             *
             */
            for (int i = 0; i < store.getCashiersList().size(); i++) {
                if (store.getCashiersList().get(i).getUserID() == cashier.getUserID()) {
                    //Increment Cashier wage by cashier's set salary
                    store.getCashiersList().get(i).setWageBalance(store.getCashiersList().get(i).getSalary());
                    System.out.println(store.getCashiersList().get(i).getName() + " "+store.getCashiersList().get(i).getSalary()+" successfully paid.");
                    totalWagesPaid += store.getCashiersList().get(i).getSalary();
                    //deducts Cashier's wage from store balance
                    store.setStoreBalanceAfterWagePayment(store.getCashiersList().get(i).getSalary());
                    break;
                }
            }
            System.out.println(String.format("Total amount of Wage paid: %.2f Store Balance is: %.2f", totalWagesPaid, store.getStoreBalance()));
        } else {
            System.out.println("Insufficient funds, bare with us while we make arrangements to pay you.");
        }

            }
}