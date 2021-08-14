package com.techgeeknext.service;

import com.techgeeknext.entity.CustomUserDetails;
import com.techgeeknext.entity.User;
import com.techgeeknext.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    /**
     * Load User by userName
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
        final Optional<User> optionalUser = userRepository.findByUserName(userName);
        return optionalUser.map(CustomUserDetails::new).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User = %s does not exists", userName)));
    }
}
