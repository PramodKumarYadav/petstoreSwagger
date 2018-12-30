package domainentitites;

public class CreateUser {

    private String username;
    private String password;

    public CreateUser()  {
        // This is the default username and password provided by petstore.swagger.io
        this("user1", "pass@123" );
    }
    public CreateUser(String username, String password)  {
        this.username = username;
        setPassword(password);
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password)  {
            // No restrictions specified on swagger. If I found any during testing, uncomment and customize below.
//        if (password.length() < 7) {
//            throw new IllegalArgumentException("Password must be > 6 chars");
//        }
        this.password = password;
    }
}
