package app.entity;


import javax.persistence.*;

@Entity
@Table(name = "translations")
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String translation;

    public Translation() {
    }

    public Translation(String translation) {
        this.translation = translation;
    }

    public Long getId() {
        return id;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
