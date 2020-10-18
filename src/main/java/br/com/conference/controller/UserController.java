package br.com.conference.controller;

import br.com.conference.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser(
            @RequestParam(name = "firstname", defaultValue = "Paulo") String firstname,
            @RequestParam(name = "lastname", defaultValue = "Ricardo") String lastname,
            @RequestParam(name = "age", defaultValue = "18") int age
    ) {
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setAge(age);
        return user;
    }
}
