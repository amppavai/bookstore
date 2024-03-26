package hh.sof03.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)

public class WebSecurityConfig {

        @Autowired
        private UserDetailsService userDetailsService;

        @Bean
        public SecurityFilterChain configure(HttpSecurity http) throws Exception {

                http
                                .authorizeHttpRequests(authorize -> authorize
                                                .requestMatchers("/", "/booklist").permitAll()
                                                .anyRequest().authenticated())
                                .formLogin(formlogin -> formlogin
                                                //.loginPage("/login")
                                                .defaultSuccessUrl("/booklist", true)
                                                .permitAll())
                                .logout(logout -> logout
                                                .permitAll());

                return http.build();
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        }

        /*
         * @Bean
         * public UserDetailsService userDetailsService() {
         * BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
         * UserDetails user = User.builder()
         * .username("user")
         * .password(encoder.encode("password"))
         * .roles("USER")
         * .build();
         * List<UserDetails> users = new ArrayList<UserDetails>();
         * users.add(user);
         * return new InMemoryUserDetailsManager(users);
         * }
         */
}