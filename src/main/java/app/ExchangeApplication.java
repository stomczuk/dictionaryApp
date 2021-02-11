package app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;

import static app.constant.FileConstant.USER_FOLDER;

@SpringBootApplication
public class ExchangeApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExchangeApplication.class, args);
        new File(USER_FOLDER).mkdirs();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
