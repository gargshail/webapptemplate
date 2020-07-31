package your.application.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class DiaryEntry {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private LocalDate entryDate;
    private String content;

    protected DiaryEntry() {}

    public DiaryEntry (String title, LocalDate entryDate, String content) {
        this.title = title;
        this.entryDate = entryDate;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public String getContent() {
        return content;
    }
}
