package lk.learners.karunadasa.config;


import lk.learners.karunadasa.general.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//* @EnableGlobalMethodSecurity(prePostEnabled = true)
//* using this we can manage method access
//*   @PreAuthorize("hasAnyRole('ADMIN')") ..........like
//*/*    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }*/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Autowired
    public UserDetailsServiceImpl userDetailsService;*/

    @Bean
    public UserDetailsServiceImpl userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }


/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
/*        http.csrf().disable();
        http.authorizeRequests().antMatchers("/").permitAll();*/

        //for developing easy to give permission all link

        http.
                authorizeRequests()
                //Always users can access without login
                .antMatchers(
                        "/index",
                        "/favicon.ico",
                        "/img/**",
                        "/css/**",
                        "/js/**",
                        "/fonts/**",
                        "/divTool/**",
                        "/fontawesome/**").permitAll()
                .antMatchers("/login", "/select/**").permitAll()

                //Need to login for access those are
                .antMatchers("/employee/**").hasRole("MANAGER")
                .antMatchers("/employee/**").hasRole("MANAGER")
                .antMatchers("/user/**").hasRole("MANAGER")
                .antMatchers("/invoiceProcess/add").hasRole("CASHIER")
                .anyRequest()
                .authenticated()
                .and()
                // Login form
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/mainWindow")
                //Username and password for validation
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                //Logout controlling
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/index")
                .and()
                .exceptionHandling()
                //Cross site disable
                .and()
                .csrf()
                .disable();


    }
}
