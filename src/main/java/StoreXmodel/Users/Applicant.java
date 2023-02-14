package StoreXmodel.Users;


public class Applicant extends User {

    boolean SSCE;
    int age;
    private boolean isHired;
    public Applicant(String name, int userId, boolean SSCE, int age){
        super(name, userId);
        this.SSCE = SSCE;
        this.age = age;
    }

    public void setStatus(boolean hired) {
        isHired = hired;
    }

    public boolean getQualification(){
        return SSCE;
    }
    public int getAge(){return age;}

    public boolean getStatus(){return isHired;}

}

