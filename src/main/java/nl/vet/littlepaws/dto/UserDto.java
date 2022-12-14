//package nl.vet.littlepaws.dto;
//
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import lombok.*;
//import nl.vet.littlepaws.model.Authority;
//
//import java.util.Set;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class UserDto {
//
//    public String username;
//    public String password;
//    public Boolean enabled;
//    public String email;
//    @JsonSerialize
//    public Set<Authority> authorities;
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public Boolean getEnabled() {
//        return enabled;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public Set<Authority> getAuthorities() {
//        return authorities;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setEnabled(Boolean enabled) {
//        this.enabled = enabled;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setAuthorities(Set<Authority> authorities) {
//        this.authorities = authorities;
//    }
//
//}
