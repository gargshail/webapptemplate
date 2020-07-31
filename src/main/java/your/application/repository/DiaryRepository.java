package your.application.repository;

import org.springframework.data.repository.CrudRepository;
import your.application.repository.model.DiaryEntryEntity;

import java.time.LocalDate;

public interface DiaryRepository  extends CrudRepository<DiaryEntryEntity, Long> {
    Iterable<DiaryEntryEntity> findByEntryDate(LocalDate date);
    DiaryEntryEntity findById(long id);
}
