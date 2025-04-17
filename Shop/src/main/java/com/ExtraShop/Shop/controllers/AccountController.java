package com.ExtraShop.Shop.controllers;

//import com.ExtraShop.Shop.data.entities.User;
//import com.ExtraShop.Shop.data.repositories.UserRepository;
import com.ExtraShop.Shop.Services.JwtTokenService;
import com.ExtraShop.Shop.data.repositories.UserRepository;
import com.ExtraShop.Shop.models.LoginRequest;
import com.ExtraShop.Shop.models.LoginResponse;
import com.ExtraShop.Shop.models.RegisterRequest;
import com.ExtraShop.Shop.utils.DbUtils;
import com.ExtraShop.Shop.utils.PasswordHandler;
import io.jsonwebtoken.security.Password;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController extends ControllerBase {
    private final JwtTokenService jwtTokenService;
    private final UserRepository userRepository;

    public AccountController(
            JwtTokenService tokenService,
            UserRepository userRepository) {
        this.jwtTokenService = tokenService;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")

    public ResponseEntity login(@RequestBody LoginRequest account) {


        return Handler(connection -> {
            var user = userRepository.getByUsername(account.getUsername(),connection);
            var roles = userRepository.getRolesByUserId(user.getId(),connection);

        if (PasswordHandler.checkPassword(user.getPasswordhash(), user.getSalt(), account.getPassword())) {
            var token = jwtTokenService.generateToken(user);
            return ResponseEntity.ok(new LoginResponse(token, roles));
        }


        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    });
    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest register){

           return Handler (connection->{
               var hashResult = PasswordHandler.hashPassword(register.getPassword());
               userRepository.add(
                       register.getUsername(),
                       register.getPhone(),
                       register.getEmail(),
                       hashResult.getHash(),
                       hashResult.getSalt()
               );
               return new ResponseEntity<>(HttpStatus.OK);
           });

    }

}
