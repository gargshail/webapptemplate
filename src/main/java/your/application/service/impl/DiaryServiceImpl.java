package your.application.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import your.application.endpoint.model.AddDiaryEntryRequest;
import your.application.repository.model.DiaryEntry;
import your.application.repository.DiaryRepository;
import your.application.service.DiaryService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DiaryServiceImpl implements DiaryService {

    private static Logger LOG = LoggerFactory.getLogger(DiaryServiceImpl.class);
    @Autowired
    private DiaryRepository diaryRepository;


    @Override
    public void saveEntry(AddDiaryEntryRequest diaryEntryRequest) {
        DiaryEntry diaryEntry = new DiaryEntry(diaryEntryRequest.getTitle(), LocalDate.now(), diaryEntryRequest.getContent());
        diaryRepository.save(diaryEntry);
        LOG.info("Saved entry {}", diaryEntry.getTitle());
    }

    @Override
    public List<your.application.endpoint.model.DiaryEntry> getAll() {

        List<your.application.endpoint.model.DiaryEntry> entries = new ArrayList<>();

        for (DiaryEntry entry : diaryRepository.findAll()) {
            your.application.endpoint.model.DiaryEntry diaryEntry = new your.application.endpoint.model.DiaryEntry();

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

        for (DiaryEntry entry : diaryRepository.findByEntryDate(entryDate)) {
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
