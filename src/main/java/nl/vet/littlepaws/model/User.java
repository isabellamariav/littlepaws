//package nl.vet.littlepaws.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.HashSet;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class User extends Base{
//
//    @Column(nullable = false, unique = true)
//    private String username;
//
//    @Column(nullable = false, length = 255)
//    private String password;
//
//    @Column(nullable = false)
//    private boolean enabled = true;
//
//    @Column
//    private String email;
//
//    @ManyToOne(
//            targetEntity = Authority.class,
//            mappedBy = "username",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.EAGER)
//    private Set<Authority> authorities = new HashSet<>();
//
//    public String getUsername() { return username; }
//    public void setUsername(String username) {
//        this.username = username;
//    }
//    public String getPassword() {
//        return password;
//    }
//    public void setPassword(String password) {
//        this.password = password;
//    }
//    public boolean isEnabled() { return enabled;}
//    public void setEnabled(boolean enabled) { this.enabled = enabled; }
//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email;}
//
//    public Set<Authority> getAuthorities() { return authorities; }
//    public void addAuthority(Authority authority) {
//        this.authorities.add(authority);
//    }
//    public void removeAuthority(Authority authority) {
//        this.authorities.remove(authority);
//    }
//    }
