package cloud.zzzfit.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringDocConfig {
    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI()
            .info(Info().title("zzzfit api"))
    }

    @Bean
    fun publicApi(): GroupedOpenApi {
        return GroupedOpenApi.builder().group("brand").pathsToMatch("/brand/**")
            .build()
    }
}