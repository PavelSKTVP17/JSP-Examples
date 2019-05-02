package com.mycompany.repositories;

import com.mycompany.models.User;
import java.util.List;

public interface UsersRepository 
{
    List<User> findAll();
    void save(User user);
    boolean isExist( String name, String password);
}
