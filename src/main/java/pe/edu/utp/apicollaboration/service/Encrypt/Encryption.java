package pe.edu.utp.apicollaboration.service.Encrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encryption {
    public static String passwordEncription(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

}
