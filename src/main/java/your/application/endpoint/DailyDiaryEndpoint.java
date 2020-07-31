package your.application.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import your.application.endpoint.model.AddDiaryEntryRequest;
import your.application.endpoint.model.DiaryEntry;
import your.application.endpoint.model.PageResponse;
import your.application.service.DiaryService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/diary")

public class DailyDiaryEndpoint {

    private static Logger LOG = LoggerFactory.getLogger(DailyDiaryEndpoint.class);
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
    @Autowired
    private DiaryService diaryService;

    @GetMapping
    public List<DiaryEntry> getPage() {
        return diaryService.getAll();

    }

    @GetMapping("/{entrydate}")
    public List<DiaryEntry> getPage(@PathVariable("entrydate") String entryDate) {
        LocalDate d =LocalDate.parse(entryDate, DateTimeFormatter.ISO_LOCAL_DATE);
        return diaryService.getEntry(d);

    }

    @PostMapping
    public ResponseEntity addEntry(@RequestBody AddDiaryEntryRequest diaryEntryRequest) {
        diaryService.saveEntry(diaryEntryRequest);
        LOG.info("Received add entry request {}", diaryEntryRequest.getTitle());
        return ResponseEntity.noContent().build();
    }
}
