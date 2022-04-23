
package atm.atm.securityConfiguration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select username,password,enabled from tbl_users where username=?")
                .authoritiesByUsernameQuery("select username,roles from roles where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/user/add","/account/add","/account/delete")
                .permitAll()
                /*
                 //because is not formLogin
                .and().authorizeRequests()
                .antMatchers("/user")
                .hasAnyAuthority("ADMIN","SUPERADMIN")
                */
                .anyRequest()
                .authenticated()
                /* // error exception access denied page
                .and()
                .exceptionHandling().accessDeniedPage("")*/;

                //redirect to loging for all request
                /*
                .and()
                .formLogin().loginPage().permitAll().and().logout().permitAll();
                */

    }

}
