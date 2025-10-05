package com.example.ev_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Data // Lombok annotation to create getters, setters, etc.
@Builder // Lombok annotation to help build objects
@NoArgsConstructor
@AllArgsConstructor
@Entity // Marks this class as a JPA entity (a database table)
@Table(name = "_user") // We name the table "_user" because "user" is a reserved word in SQL
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;

    // These methods are required by the UserDetails interface for Spring Security
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Returns a list containing one permission: "ROLE_USER"
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return this.email; // We will use the email to log in
    }
    // ... other required UserDetails methods
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}