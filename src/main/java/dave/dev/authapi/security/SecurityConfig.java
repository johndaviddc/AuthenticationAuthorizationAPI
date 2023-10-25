package dave.dev.authapi.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
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
    protected void 

}
