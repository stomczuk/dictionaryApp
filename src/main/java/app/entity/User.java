package app.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
//@PasswordMatches(message = "Password doesn't match")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //    @NotBlank(message = "Name cannot be blank")
    private String firstName;

    private String lastName;

    //    @NotBlank(message = "Username cannot be blank")
//    @UniqueUsername
    private String username;

    //    @Email
//    @UniqueEmail
    private String email;

    //    @Password
    private String password;

    @Transient
    private String passwordConfirm;

    private Date lastLoginDate;

    private Date lastLoginDateDisplay;

    private Date joinDate;

    private String role;

    private String[] authorities;
    private boolean isActive;
    private boolean isNonLocked;

    private String profileImageUrl;


    public User() {
    }

    public User(Long id, String firstName, String lastName, String username, String email, String password, String passwordConfirm, Date lastLoginDate, Date lastLoginDateDisplay, Date joinDate, String role, String[] authorities, boolean isActive, boolean isNonLocked, String profileImageUrl) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.lastLoginDate = lastLoginDate;
        this.lastLoginDateDisplay = lastLoginDateDisplay;
        this.joinDate = joinDate;
        this.role = role;
        this.authorities = authorities;
        this.isActive = isActive;
        this.isNonLocked = isNonLocked;
        this.profileImageUrl = profileImageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getLastLoginDateDisplay() {
        return lastLoginDateDisplay;
    }

    public void setLastLoginDateDisplay(Date lastLoginDateDisplay) {
        this.lastLoginDateDisplay = lastLoginDateDisplay;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getRoles() {
        return role;
    }

    public void setRoles(String roles) {
        this.role = role;
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String[] authorities) {
        this.authorities = authorities;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isNonLocked() {
        return isNonLocked;
    }

    public void setNonLocked(boolean nonLocked) {
        isNonLocked = nonLocked;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    /*do zrobienia jak bede robil userow*/

//    public Set<EnglishWord> getEnglishWords() {
//        return englishWords;
//    }
//
//    public void setEnglishWords(Set<EnglishWord> englishWords) {
//        this.englishWords = englishWords;
//    }

//    public void addGroup(EnglishWord englishWord) {
//        this.englishWords.add(englishWord);
//        englishWord.getUsers().add(this);
//    }
//
//    public void removeGroup(EnglishWord englishWord) {
//        this.englishWords.remove(englishWord);
//        englishWord.getUsers().remove(this);
//        List test = new ArrayList<>();
//
//    }
}
