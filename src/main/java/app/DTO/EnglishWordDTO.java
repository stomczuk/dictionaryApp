package app.DTO;

public class EnglishWordDTO {

    private Long id;
    private String word;
    private String translation;

    public EnglishWordDTO() {
    }

    public EnglishWordDTO(Long id, String word, String translation) {
        this.id = id;
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
}
