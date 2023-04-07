package kz.raskaliyev.locationsystem.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NonNull
    @NotBlank(message = "Username is required")
    private String userName;
    
    @NonNull 
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    private String email;
    @NonNull
    @NotBlank(message = "Password is required")
    private String password;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LocationUser> locationUsers;
    
}
