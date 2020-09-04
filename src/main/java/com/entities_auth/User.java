package com.entities_auth;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.audit.Auditable;
import lombok.Data;
@Entity
@Data
@Table (name = "auth_user")

public class User extends Auditable {
    private String email;
    private String username;
    private String password;
}
