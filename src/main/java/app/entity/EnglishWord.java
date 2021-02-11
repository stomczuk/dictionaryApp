package app.entity;


import javax.persistence.*;

@Entity
@Table(name = "eng_words")
public class EnglishWord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String word;

    private String translation;

//    @ManyToMany(mappedBy = "englishWords")
//    private Set<User> users = new HashSet<>();

    public EnglishWord() {
    }

    public EnglishWord(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

//    public Set<User> getUsers() {
//        return users;
//    }
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
}
