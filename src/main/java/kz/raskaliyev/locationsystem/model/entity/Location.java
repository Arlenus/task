package kz.raskaliyev.locationsystem.model.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "locations")
public class Location {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotBlank(message = "Name is required")
    private String name;

    @NonNull
    @NotBlank(message = "Address is required")
    private String address;
    
    @OneToMany(mappedBy = "location")
    private List<LocationUser> locationUsers;
  
}
