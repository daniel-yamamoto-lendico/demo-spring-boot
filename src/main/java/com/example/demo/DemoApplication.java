package com.example.demo;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.models.Name;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            Role admin = roleRepository.save(new Role("SYSTEM_ADMIN"));
            Role manager = roleRepository.save(new Role("MANAGER"));
            Role sales = roleRepository.save(new Role("SALES"));
            Role support = roleRepository.save(new Role("SUPPORT"));
            Role customer = roleRepository.save(new Role("CUSTOMER"));
            List<Role> roles = Arrays.asList(admin, manager, sales, support, customer);
            userRepository.save(new User(new Name("Daniel", "All"), roles));
            userRepository.save(new User(new Name("Daniel", "Admin"), roles.subList(0, 1)));
            userRepository.save(new User(new Name("Daniel", "Manager"), roles.subList(1, 2)));
            userRepository.save(new User(new Name("Daniel", "Sales"), roles.subList(2, 3)));
            userRepository.save(new User(new Name("Daniel", "Support"), roles.subList(3, 4)));
            userRepository.save(new User(new Name("Daniel", "Customer"), roles.subList(4, 5)));
        };
    }
}