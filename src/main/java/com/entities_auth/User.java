package com.entities_auth;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "auth_user")

public class User extends Auditable {
    @Id
    private Long id;
    private String email;
    private String username;
    private String password;
}
