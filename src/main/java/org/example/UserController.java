package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public String registerUser(@RequestBody User user) {
        if(!user.getUserName().isEmpty()){
            user.setUserPass(passwordEncoder.encode(user.getUserPass()));
            userRepository.save(user);
            return "Registration complete";
        }
        else{
            return "Missing user data";
        }
    }

}
