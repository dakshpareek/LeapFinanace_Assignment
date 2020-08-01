package com.assignment.project.security;

import com.assignment.project.entity.DAOUser;
import com.assignment.project.repository.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    //@Autowired
    private UserDao userDao;

    //@Autowired
    private PasswordEncoder bcryptEncoder;

    //@Autowired
    public JwtUserDetailsService(UserDao userDao,PasswordEncoder bcryptEncoder) {
        this.userDao = userDao;
        this.bcryptEncoder = bcryptEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Searching User For Authentication");
        return userDao.findOneWithAuthoritiesByEmail(email)
                .map(user -> createSpringSecurityUser(user))
                .orElseThrow(() -> new UsernameNotFoundException(email + " was not found in the database"));

    }

    private User createSpringSecurityUser(DAOUser user) {

        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());

        return new User(user.getEmail(),
                user.getPassword(),
                grantedAuthorities);
    }

}