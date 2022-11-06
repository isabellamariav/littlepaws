package nl.vet.littlepaws.service;

import nl.vet.littlepaws.exception.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserDetailsService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
