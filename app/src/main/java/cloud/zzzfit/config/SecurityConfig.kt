package cloud.zzzfit.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class  SecurityConfig {

    @Bean
    @Throws(Exception::class)
    fun  filterChain( http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { csrf -> csrf.disable() }
        return http.build()


//      return  http.csrf().disable().authorizeRequests()
            //...
//            .antMatchers(
//                HttpMethod.GET,
//                "/index*", "/static/**", "/*.js", "/*.json", "/*.ico")
//            .permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .formLogin().loginPage("/index.html")
//            .loginProcessingUrl("/perform_login")
//            .defaultSuccessUrl("/homepage.html",true)
//            .failureUrl("/index.html?error=true")

    }

}