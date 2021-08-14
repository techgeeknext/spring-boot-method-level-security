package com.techgeeknext.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users_auth_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "user_name", nullable = false)
    String userName;
    String password;
    boolean active;
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    List<Role> roles;
}
