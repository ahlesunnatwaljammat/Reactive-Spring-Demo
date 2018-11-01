package edu.learn.springboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Slf4j
@SpringBootApplication
public class SpringbootApplication {

    @Bean
    public CommandLineRunner addSampleData(UserRepo userRepo){
        return args -> {
          userRepo.save(new User("nabbasi", "x"));
          userRepo.save(new User("fabbasi", "x"));
          userRepo.save(new User("aabbasi", "x"));
          log.info("Sample users have been added ...");
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}

@RequestMapping(path = "users")
@RestController
class UserRest {
    private UserRepo userRepo;

    public UserRest(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @GetMapping
    public Iterable<User> hello(){
        return this.userRepo.findAll();
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "password")
@Entity
class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

interface UserRepo extends CrudRepository<User, Long> {}