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
public class AccountController {
    private final JwtTokenService jwtTokenService;
    private final UserRepository userRepository;

    public AccountController(
            JwtTokenService tokenService,
            UserRepository userRepository){
        this.jwtTokenService = tokenService;
        this.userRepository = userRepository;
    }
    @PostMapping("/login")

    public ResponseEntity login(@RequestBody LoginRequest account){

        try{
            var user = userRepository.getByUsername(account.getUsername());
            var roles userRepository.getRolesByUserId(user.getId());
            if(PasswordHandler.checkPassword( user.getPasswordhash(), user.getSalt(), account.getPassword())){
                var token = jwtTokenService.generateToken(user);
                return ResponseEntity.ok(new LoginResponse(token));
            }
        }
        catch(Exception ex){
            System.out.println(ex);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest register){
        try {
            var hashResult = PasswordHandler.hashPassword(register.getPassword());
        userRepository.add(
                register.getUsername(),
                register.getPhone(),
                register.getEmail(),
                hashResult.getHash(),
                hashResult.getSalt()
                );
        }catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
