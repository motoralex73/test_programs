package com.user.restuser.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    private long id;
    private String name;
    private String surname;
    private String email;
    private String imageUrl;
    private String status;
}
