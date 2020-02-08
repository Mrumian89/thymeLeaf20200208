package com.example.thymeLeaf20200208.service;

import com.example.thymeLeaf20200208.model.User;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserService {


    private Map<Integer, User> userMap = new HashMap<>();

    public User createUser(String name, String nazwisko, int wiek){
        int id = new Random().nextInt();
        User user = new User(id, name, nazwisko, wiek);
        userMap.put(id, user);
        return user;
    }

    public void deleteUser(int id){
        userMap.remove(id);
    }

    public Collection<User> listUsers(){
        return userMap.values();
    }

    public User getUser(int id) {
        return userMap.get(id);
    }
}
