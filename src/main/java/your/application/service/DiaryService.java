package your.application.service;

import your.application.endpoint.model.AddDiaryEntryRequest;
import your.application.endpoint.model.DiaryEntry;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface DiaryService {
    void saveEntry(AddDiaryEntryRequest diaryEntry);
    List<DiaryEntry> getEntry(LocalDate entryDate);
    List<DiaryEntry> getAll();
}
