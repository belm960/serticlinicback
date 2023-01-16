package com.HospitalMangagmentSystem.demo.controller;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
        import javax.validation.Valid;

import com.HospitalMangagmentSystem.demo.Security.jwt.JwtProvider;
import com.HospitalMangagmentSystem.demo.Service.UserService;
import com.HospitalMangagmentSystem.demo.domain.Role;
import com.HospitalMangagmentSystem.demo.domain.Rolename;
import com.HospitalMangagmentSystem.demo.domain.User;
import com.HospitalMangagmentSystem.demo.Security.jwt.message.request.LoginForm;
import com.HospitalMangagmentSystem.demo.Security.jwt.message.request.SignUpForm;
import com.HospitalMangagmentSystem.demo.Security.jwt.message.response.JwtResponse;
import com.HospitalMangagmentSystem.demo.Security.jwt.message.response.ResponseMessage;
import com.HospitalMangagmentSystem.demo.repository.RoleRepository;
import com.HospitalMangagmentSystem.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.security.authentication.AuthenticationManager;

        import
        org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

        import org.springframework.security.core.Authentication;
        import org.springframework.security.core.context.SecurityContextHolder;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.security.crypto.password.PasswordEncoder;
        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class
AuthRestAPIs {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    UserService useservice;
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
        Authentication authentication = authenticationManager.authenticate(

        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), useservice.getoneuserdType(loginRequest.getUsername()),
                useservice.getoneuserid(loginRequest.getUsername()),useservice.getoneuserStatus(loginRequest.getUsername()),userDetails.getAuthorities()));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("Fail	->	Username	is	already	taken!"),
                    HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Fail	->	Email	is	already	in	use!"),
                    HttpStatus.BAD_REQUEST);
        }
        //	Creating	user's	account
        User user = new User(signUpRequest.getId(),signUpRequest.getUsername(),
                signUpRequest.getEmail(),signUpRequest.getFirst(),signUpRequest.getLast(),signUpRequest.getEnrolldate(),
                signUpRequest.getMobile(),signUpRequest.getDesignation(),signUpRequest.getAddress(), signUpRequest.getAge(),
                signUpRequest.getdType(),signUpRequest.getGender() , signUpRequest.getDepartment(),signUpRequest.getdType(),
                encoder.encode(signUpRequest.getPassword()),true);
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleRepository.findByName(Rolename.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail!	->	Cause:	User	Role	not	find."));
                    roles.add(adminRole);
                    break;

                case "doctor":
                    Role doctorRole = roleRepository.findByName(Rolename.ROLE_DOCTOR).
                            orElseThrow(() -> new RuntimeException("Fail!	->	Cause:	User	Role	not	find."));
                    roles.add(doctorRole);
                    break;

                case "patient":
                    Role patientRole = roleRepository.findByName(Rolename.ROLE_PATIENT).orElseThrow(() -> new RuntimeException("Fail!	->	Cause:	User	Role	not	find."));
                    roles.add(patientRole);
                    break;
                case "reception":
                    Role receptionRole = roleRepository.findByName(Rolename.ROLE_RECEPTION).orElseThrow(() -> new RuntimeException("Fail!	->	Cause:	User	Role	not	find."));
                    roles.add(receptionRole);
                    break;
                case "opd":
                    Role opdRole = roleRepository.findByName(Rolename.ROLE_OPD).orElseThrow(() -> new RuntimeException("Fail!	->	Cause:	User	Role	not	find."));
                    roles.add(opdRole);
                    break;
                case "lab":
                    Role labRole = roleRepository.findByName(Rolename.ROLE_LAB).orElseThrow(() -> new RuntimeException("Fail!	->	Cause:	User	Role	not	find."));
                    roles.add(labRole);
                    break;
                case "rad":
                    Role radRole = roleRepository.findByName(Rolename.ROLE_RAD).orElseThrow(() -> new RuntimeException("Fail!	->	Cause:	User	Role	not	find."));
                    roles.add(radRole);
                    break;
                case "room":
                    Role roomRole = roleRepository.findByName(Rolename.ROLE_ROOM).orElseThrow(() -> new RuntimeException("Fail!	->	Cause:	User	Role	not	find."));
                    roles.add(roomRole);
                    break;
                default:
                    Role userRole = roleRepository.findByName(Rolename.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail!	->	Cause:	User	Role	not	find."));
                    roles.add(userRole);
            }
        });

        user.setRoles(roles);
        userRepository.save(user);
        return new ResponseEntity<>(new ResponseMessage("User	registered	successfully!"),
                HttpStatus.OK);
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/addRole")
    public List<Role> createUserRole() {
        ArrayList<Role> array = new ArrayList<>();
        Role rr = new Role();
        rr.setName(Rolename.ROLE_ADMIN);
        array.add(rr);
        Role rr1 = new Role();
        rr1.setName(Rolename.ROLE_USER);
        array.add(rr1);
        Role rr2 = new Role();
        rr2.setName(Rolename.ROLE_DOCTOR);
        array.add(rr2);
        Role rr3 = new Role();
        rr3.setName(Rolename.ROLE_PATIENT);
        array.add(rr3);
        Role rr4 = new Role();
        rr4.setName(Rolename.ROLE_RECEPTION);
        array.add(rr4);
        Role rr5 = new Role();
        rr5.setName(Rolename.ROLE_LAB);
        array.add(rr5);
        Role rr6 = new Role();
        rr6.setName(Rolename.ROLE_RAD);
        array.add(rr6);
        Role rr7 = new Role();
        rr7.setName(Rolename.ROLE_OPD);
        array.add(rr7);
        Role rr8 = new Role();
        rr8.setName(Rolename.ROLE_ROOM);
        array.add(rr8);
        return roleRepository.saveAll(array);
    }
}