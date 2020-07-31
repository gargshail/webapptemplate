package your.application.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import your.application.endpoint.model.AddDiaryEntryRequest;
import your.application.endpoint.model.DiaryEntry;
import your.application.repository.model.DiaryEntryEntity;
import your.application.repository.DiaryRepository;
import your.application.service.DiaryService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DiaryServiceImpl implements DiaryService {

    private static Logger LOG = LoggerFactory.getLogger(DiaryServiceImpl.class);
    @Autowired
    private DiaryRepository diaryRepository;


    @Override
    public void saveEntry(AddDiaryEntryRequest diaryEntryRequest) {
        DiaryEntryEntity diaryEntryEntity = new DiaryEntryEntity(diaryEntryRequest.getTitle(), LocalDate.now(), diaryEntryRequest.getContent());
        diaryRepository.save(diaryEntryEntity);
        LOG.info("Saved entry {}", diaryEntryEntity.getTitle());
    }

    @Override
    public List<your.application.endpoint.model.DiaryEntry> getAll() {

        List<your.application.endpoint.model.DiaryEntry> entries = new ArrayList<>();

        for (DiaryEntryEntity entry : diaryRepository.findAll()) {
            DiaryEntry diaryEntry = new DiaryEntry();

            diaryEntry.setEntryDate(entry.getEntryDate());
            diaryEntry.setContent(entry.getContent());
            diaryEntry.setTitle(entry.getTitle());
            entries.add(diaryEntry);
        }
        LOG.info("Found {} entries", entries.size());

        return entries;
    }

    @Override
    public List<your.application.endpoint.model.DiaryEntry> getEntry(LocalDate entryDate) {

        List<your.application.endpoint.model.DiaryEntry> entries = new ArrayList<>();

        for (DiaryEntryEntity entry : diaryRepository.findByEntryDate(entryDate)) {
            your.application.endpoint.model.DiaryEntry diaryEntry = new your.application.endpoint.model.DiaryEntry();

            diaryEntry.setEntryDate(entry.getEntryDate());
            diaryEntry.setContent(entry.getContent());
            diaryEntry.setTitle(entry.getTitle());
            entries.add(diaryEntry);
        }
        LOG.info("Found {} entries", entries.size());

        return entries;
    }
}
