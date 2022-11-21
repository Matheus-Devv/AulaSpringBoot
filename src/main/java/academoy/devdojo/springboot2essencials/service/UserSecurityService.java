package academoy.devdojo.springboot2essencials.service;

import academoy.devdojo.springboot2essencials.domain.UserModel;
import academoy.devdojo.springboot2essencials.repository.UserRepository;
import academoy.devdojo.springboot2essencials.requests.UserPostRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSecurityService {

    private final UserRepository userRepository;

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public UserModel save(UserPostRequestBody userPostRequestBody) {
        UserModel userModel = UserModel.builder()
                .username(userPostRequestBody.getUsername())
                .password(passwordEncoder().encode(userPostRequestBody.getPassword()))
                .role("ROLE_USER")
                .build();

        return userRepository.save(userModel);
    }

}
