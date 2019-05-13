
package com.mycompany.fake;

import com.mycompany.models.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FakeStorage 
{
    private static final FakeStorage storage;
    static{
        storage=new FakeStorage();
    }
    private List<User> users;

    private FakeStorage() 
    {
        this.users = new ArrayList<User>();
        User U1=new User("Kirill", "222", LocalDate.parse("1975-02-02")); this.users.add(U1);
        User U2=new User("Trofim", "222", LocalDate.parse("1975-02-02")); this.users.add(U2);
        User U3=new User("Valentina", "222", LocalDate.parse("1975-02-02")); this.users.add(U3);
    }
    
    public static FakeStorage storage() {return storage;}
    public List<User> users() { return users;}
}
