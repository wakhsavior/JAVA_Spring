package ru.gb.MySpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import ru.gb.MySpringSecurity.model.CustomUserDetails;
import ru.gb.MySpringSecurity.services.MyUserDetailService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    /**
     * Метод преобразования пользователя в подходящий для Java вид. Пользователи создаются вручную,
     * но можно и сделать класс пользователя и хранить его в базе данных
     * InMemoryUserDetailsManager - класс хранения пользователей в памяти
     * @param encoder Используется для шифрования пароля
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService(){
//    public UserDetailsService userDetailsService(PasswordEncoder encoder){
//        UserDetails admin = User.builder().username("admin").password(encoder.encode("admin")).roles("ADMIN").build();
//        UserDetails user = User.builder().username("user").password(encoder.encode("user")).roles("USER").build();
//        UserDetails denis = User.builder().username("denis").password(encoder.encode("password123")).roles("ADMIN","USER").build();
//        return new InMemoryUserDetailsManager(admin,user,denis);
    return new MyUserDetailService();
    }

    /**
     * Создаем цепочку фильтров для контроля доступа к ресурсам. До welcome доступ всем без авторизации,
     * до apps авторизованных пользователей
     * до formlogin доступ всем пользователям
     * @param http
     * @return
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        System.out.println("Hello!");
        return http.csrf().disable().authorizeHttpRequests(auth->auth.requestMatchers("api/welcome","api/new-user").permitAll()
                .requestMatchers("api/**").authenticated())
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }

    /**
     * Необходим для работы аутентификации
     * @return
     */
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    /**
     * Переопределение интерфейса шифрования пароля, используется алгоритм BCrypt является наследником PasswordEncoder
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
