package dataccess;

import dataccess.domain.Teammate;
import dataccess.repository.TeammateRepository;
import dataccess.service.DatabaseLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired(required = false)
    private DatabaseLoader databaseLoader;

    @Autowired
    private TeammateRepository teammateRepository;

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    private void seeTheRoster(){
        for (Teammate teammate : teammateRepository.findAll()) {
            log.info(teammate.toString());
        }
    }
}
