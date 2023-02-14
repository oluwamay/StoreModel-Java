package StoreXmodel.Users;




public abstract class User {
    private String name;
    private int userID;
    public User(String name, int userID){
        this.name = name;
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public int getUserID() {
        return userID;
    }
}