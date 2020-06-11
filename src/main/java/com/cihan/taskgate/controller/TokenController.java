package com.cihan.taskgate.controller;

import com.cihan.taskgate.auth.JwtTokenUtil;
import com.cihan.taskgate.auth.LoginRequest;
import com.cihan.taskgate.auth.TokenResponse;
import com.cihan.taskgate.model.User;
import com.cihan.taskgate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/taskgate/token")
@RestController
public class TokenController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<TokenResponse> getToken(@RequestBody LoginRequest request) throws AuthenticationServiceException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User theUser = userService.findByUsername(request.getUsername());
        String token = jwtTokenUtil.generateToken(theUser);
        return ResponseEntity.ok(new TokenResponse(theUser.getUsername(), token));
    }

}
