package com.example.thymeLeaf20200208.service;

import com.example.thymeLeaf20200208.model.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class newPacjentService {

    @Component
    public class PacjentService {


        private Map<Integer, User> userMap = new HashMap<>();

        public User createPacjent (String name, String nazwisko, int wiek){
            int id = new Random().nextInt();
            User user = new User(id, name, nazwisko, wiek);
            userMap.put(id, user);
            return Pacjent;
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
}
