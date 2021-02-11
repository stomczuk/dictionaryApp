package app.service;

import app.entity.User;
import app.exception.domain.EmailExistException;
import app.exception.domain.EmailNotFoundException;
import app.exception.domain.UsernameExistException;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface UserService {

    void save(User user);
    User register(String firstName, String lastName,String username, String email) throws UsernameExistException, EmailExistException, MessagingException;
    List<User>getUsers();
    User findByUsername(String username);
    User findByEmail(String email);
    User addNewUser(String firstName, String lastName, String username, String email, String role,
                    boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UsernameExistException, EmailExistException, IOException;
    User updateUser(String currentUsername,String newFirstName, String newLastName, String newUsername, String newEmail, String role,
                    boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UsernameExistException, EmailExistException, IOException;
    void deleteUser(Long id);
    void resetPassword(String email) throws EmailNotFoundException, MessagingException;
    User updateProfileImage(String username, MultipartFile profileImage) throws UsernameExistException, EmailExistException, IOException;

}
