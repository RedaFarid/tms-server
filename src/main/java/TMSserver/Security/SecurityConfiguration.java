package TMSserver.Security;

import TMSserver.Security.Filter.CustomAuthenticationFilter;
import TMSserver.Security.Filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        //This one not authorized
        http.authorizeRequests().antMatchers("/login/**","/saveLog","/saveComputer","/computers","/saveRole","/roleById/","/roles","/roleByName/","/users","/userById/**","/userByName/**","/roleRefs").permitAll();
        //Clients
        http.authorizeRequests().antMatchers(POST,"/saveClient/**").hasAnyAuthority("Save Clients");
        http.authorizeRequests().antMatchers(GET,"/clients/**").hasAnyAuthority("View Clients");
        http.authorizeRequests().antMatchers(POST,"/deleteClientById/**").hasAnyAuthority("Delete Clients");
        http.authorizeRequests().antMatchers(GET,"/clientById/**","/clientByName/**").hasAnyAuthority("View Clients","Save Clients","Delete Clients");

        //Drivers
        http.authorizeRequests().antMatchers(POST,"/saveDriver/**").hasAnyAuthority("Save Drivers");
        http.authorizeRequests().antMatchers(GET,"/drivers/**").hasAnyAuthority("View Drivers");
        http.authorizeRequests().antMatchers(POST,"/deleteDriverById/**").hasAnyAuthority("Delete Drivers");
        http.authorizeRequests().antMatchers(GET,"/driverById/**","/driverByLicenceId/**").hasAnyAuthority("View Drivers","Save Drivers","Delete Drivers");

        //Logs
        http.authorizeRequests().antMatchers(GET,"/logs/**").hasAnyAuthority("View Logs");

        //Materials
        http.authorizeRequests().antMatchers(POST,"/saveMaterial/**").hasAnyAuthority("Save Materials");
        http.authorizeRequests().antMatchers(GET,"/material/**").hasAnyAuthority("View Materials");
        http.authorizeRequests().antMatchers(POST,"/deleteMaterialByID/**").hasAnyAuthority("Delete Materials");
        http.authorizeRequests().antMatchers(GET,"/materialByID/**","/materialByName/**").hasAnyAuthority("View Materials","Save Materials","Delete Materials");

        //Stations
        http.authorizeRequests().antMatchers(POST,"/saveStations/**").hasAnyAuthority("Save Stations");
        http.authorizeRequests().antMatchers(GET,"/stations/**").hasAnyAuthority("View Stations");
        http.authorizeRequests().antMatchers(POST,"/deleteStationsById/**").hasAnyAuthority("Delete Stations");
        http.authorizeRequests().antMatchers(GET,"/stationsById/**","/stationByName/**").hasAnyAuthority("View Stations","Save Stations","Delete Stations");

        //Tanks
        http.authorizeRequests().antMatchers(POST,"/saveTank/**").hasAnyAuthority("Save Tanks","Set Quantity In Tanks");
        http.authorizeRequests().antMatchers(GET,"/tanks/**").hasAnyAuthority("View Tanks");
        http.authorizeRequests().antMatchers(POST,"/deleteTankById/**").hasAnyAuthority("Delete Tanks");
        http.authorizeRequests().antMatchers(GET,"/tankById/**","/tankByNameAndStation/**","/tanksByMaterialAndStation/**").hasAnyAuthority("View Tanks","Save Tanks","Delete Tanks");


        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
