package your.application.endpoint.model;

import java.util.Date;

public class PageResponse {
    private Date entryDate;
    private String content;

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
