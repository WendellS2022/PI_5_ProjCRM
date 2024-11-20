package br.com.ProjetoCRM.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/js/**").permitAll()
                        .requestMatchers("/img/**").permitAll()
                        .requestMatchers("/formulario/**").permitAll()
                        .requestMatchers("/Sobre/**").permitAll()
                        .requestMatchers("/termos/**").permitAll()
                        .requestMatchers("/criarSolicitacao").permitAll()
                        .requestMatchers("/protocolo/**").permitAll()
                        .requestMatchers("/js/formulario.js/**").permitAll()
                        .requestMatchers("/SendEmail").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/user/**").hasRole("USER")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/gerenciamento")
                        .permitAll()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails user1 = User.withUsername("admin@devs.com")
                .password(encoder.encode("password"))
                .roles("Admin")
                .build();

        UserDetails user2 = User.withUsername("ambulatorio@devs.com")
                .password(encoder.encode("senha"))
                .roles("ambulatorio")
                .build();

        UserDetails user3 = User.withUsername("financeiro@devs.com")
                .password(encoder.encode("senha"))
                .roles("financiero")
                .build();

        UserDetails user4 = User.withUsername("exames@devs.com")
                .password(encoder.encode("senha"))
                .roles("exames")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3, user4);
    }
}
