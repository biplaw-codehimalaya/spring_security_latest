package com.spring.securitypractice.entity;


import com.spring.securitypractice.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String username;
    private String password;

    private String address;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role_table",
            joinColumns = @JoinColumn(name = "user_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "FK_USER")),
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", foreignKey =
    @ForeignKey(name = "FK_role")))
    private List<Roles> role;

}
