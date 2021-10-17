package TMSserver.Services.Config;


import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

//@Import(value= ResourceServerConfiguration.class)
//@Deprecated
//@Configuration(proxyBeanMethods = false)
//@EnableResourceServer
//@Configuration
//@OAuth2ResourceServerSecurityMarker
public class ResourcesServerConfig /*extends WebSecurityConfigurerAdapter */{

//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.requestMatchers()
//                .antMatchers("/login", "/oauth/authorize")
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .permitAll();
//    }
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.parentAuthenticationManager(authenticationManager)
//                .inMemoryAuthentication()
//                .withUser("Peter")
//                .password("peter")
//                .roles("USER");
//    }
}
