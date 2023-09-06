package cloud.zzzfit

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }
}

//@Service
//internal class DbInitService
//internal class DbInitRunner : ApplicationRunner {
//    @Autowired
//    private val dbInitService: DbInitService? = null
//    @Throws(Exception::class)
//    override fun run(args: ApplicationArguments) {
//    }
//}