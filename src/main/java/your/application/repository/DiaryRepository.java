package your.application.repository;

import org.springframework.data.repository.CrudRepository;
import your.application.repository.model.DiaryEntry;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface DiaryRepository  extends CrudRepository<DiaryEntry, Long> {
    Iterable<DiaryEntry> findByEntryDate(LocalDate date);
    DiaryEntry findById(long id);
}
