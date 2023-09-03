package cloud.zzzfit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


@Service
class DbInitService {

}

class DbInitRunner implements ApplicationRunner {

    @Autowired
    private DbInitService dbInitService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}