package com.config.auth;

import com.model.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 시큐리티 설정에서 loginProcessingUrl("/login");
// login 요청이 들어오면 자동으로 UserDetailsService 타입으로 IoC되어 있는 loadUserByUsername 함수 실행
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // Security Session <- Authentication <- UserDetails
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username);

        if (userEntity != null) {
            return new PrincipalDetails(userEntity);
        }

        return null;
    }
}
