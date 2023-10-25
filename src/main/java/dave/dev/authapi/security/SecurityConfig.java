package dave.dev.authapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurer {

   private final UserDetailsService userDetailsService;
   private final PasswordEncoder passwordEncoder;

   public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
       this.userDetailsService = userDetailsService;
       this.passwordEncoder = passwordEncoder;
   }

   @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .authorizeRequests()
               .antMatchers("/api/auth/**").permitAll()
               .antMatchers("/api/roles**").hasRole("ADMIN")
               .anyRequest().authenticated()
               .and()
               .httpBasic();

       http.csrf().disable();
       http.cors();
   }

   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
   }

   @Bean
    public JwtTokenFilter jwtTokenFilter() {
       return new JwtTokenFilter();
   }

}
