
package com.example.hometutor.service;

import com.example.hometutor.model.AdminUser;
import com.example.hometutor.model.ParentUser;
import com.example.hometutor.model.StudentUser;
import com.example.hometutor.model.User;
import com.example.hometutor.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

//Handles user creation and searching functionality, service class response managing user oparations.

@Service
public class UserService extends AbstractCrudService<User> {
    //Constructor injection for UserRepository

    public UserService(UserRepository userRepository) {
        super(userRepository);
    }

    public User buildUser(String type, String id, String name, String email, String phone, String password,
                          String grade, String address, String childName, String permissionLevel) {
        // create parentuser object
        if ("PARENT".equalsIgnoreCase(type)) {
            return new ParentUser(id, name, email, phone, password, childName, address);
        }
        //create admin user object
        if ("ADMIN".equalsIgnoreCase(type)) {
            return new AdminUser(id, name, email, phone, password, permissionLevel);
        }
        //defalt user type. student user
        return new StudentUser(id, name, email, phone, password, grade, address);
    }

    @Override
    public List<User> search(String keyword) {
        // if keyword is empty, return the all users
        if (keyword == null || keyword.isBlank()) {
            return findAll();
        }
        String query = keyword.toLowerCase(Locale.ROOT);

        //filter the matching users
        return findAll().stream()
                .filter(user -> contains(user.getId(), query)
                        || contains(user.getName(), query)
                        || contains(user.getEmail(), query)
                        || contains(user.getPhone(), query)
                        || contains(user.getUserType(), query))
                .toList();
    }

    private static boolean contains(String value, String query) {
        return value != null && value.toLowerCase(Locale.ROOT).contains(query);
    }
}
