package your.application.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import your.application.service.DiaryService;
import your.application.service.impl.DiaryServiceImpl;

@Configuration
public class Config {

    @Bean
    public DiaryService diaryService(){
        return new DiaryServiceImpl();
    }

}
