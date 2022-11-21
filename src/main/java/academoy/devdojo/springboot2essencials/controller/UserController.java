package academoy.devdojo.springboot2essencials.controller;

import academoy.devdojo.springboot2essencials.requests.UserPostRequestBody;
import academoy.devdojo.springboot2essencials.service.UserSecurityService;
import academoy.devdojo.springboot2essencials.domain.UserModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "user")
@Log4j2
@RequiredArgsConstructor
public class UserController {

    private final UserSecurityService userSecurityService;

    @PostMapping(path = "/register")
    public ResponseEntity<UserModel> save(@RequestBody @Valid UserPostRequestBody userPostRequestBody) {
        return new ResponseEntity<>(userSecurityService.save(userPostRequestBody), HttpStatus.CREATED);
    }

//    @DeleteMapping
//    public ResponseEntity<UserModel> delete(@RequestBody @Valid UserPostRequestBody userPostRequestBody) {
//        return new ResponseEntity<>(userSecurityService.save(userPostRequestBody), HttpStatus.CREATED);
//    }
}
