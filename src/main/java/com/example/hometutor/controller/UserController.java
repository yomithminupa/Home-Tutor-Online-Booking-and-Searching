package com.example.hometutor.controller;

import com.example.hometutor.model.User;
import com.example.hometutor.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // Marks this class as a Spring MVC controller
@RequestMapping("/users") // Base URL mapping for user operations
public class UserController {
    // service layer object for user oparations
    private final UserService userService;

    //constructer injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // display all user and search resalt
    @GetMapping
    public String list(@RequestParam(required = false) String keyword, Model model) {
        //add user list to model
        model.addAttribute("users", userService.search(keyword));
        //add search keyword to model
        model.addAttribute("keyword", keyword == null ? "" : keyword);
        // return users.html page
        return "users";
    }

    //display new user registation form
    @GetMapping("/new")
    public String newForm() {
        return "user-form";
    }
    
    // create a new user

    @PostMapping
    public String create(@RequestParam String type, @RequestParam String id, @RequestParam String name,
                         @RequestParam String email, @RequestParam String phone, @RequestParam String password,
                         @RequestParam(required = false) String grade, @RequestParam(required = false) String address,
                         @RequestParam(required = false) String childName,
                         @RequestParam(required = false) String permissionLevel) {
        // builds user object according to type
        User user = userService.buildUser(type, id, name, email, phone, password, grade, address, childName, permissionLevel);
        //saves user
        userService.create(user);
        //redirects to user list page
        return "redirect:/users";
        
    }
//display edit form for selected user
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
         // Finds user by ID and adds to model
        model.addAttribute("user", userService.findById(id).orElse(null));
        return "user-form";
    }

    //updates exiting user details
    @PostMapping("/edit/{id}")
    public String update(@PathVariable String id, @RequestParam String type, @RequestParam String name,
                         @RequestParam String email, @RequestParam String phone, @RequestParam String password,
                         @RequestParam(required = false) String grade, @RequestParam(required = false) String address,
                         @RequestParam(required = false) String childName,
          
                         @RequestParam(required = false) String permissionLevel) {
        // builds updated user object
        User user = userService.buildUser(type, id, name, email, phone, password, grade, address, childName, permissionLevel);
        //updates user
        userService.update(user);
         // Redirects to user list page
        return "redirect:/users";
    }

    // delete user by id
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        //delete selected user
        userService.delete(id);
        // // Redirects to user list page
        return "redirect:/users";
    }
}
