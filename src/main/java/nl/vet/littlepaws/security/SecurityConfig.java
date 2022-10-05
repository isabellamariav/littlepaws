//package nl.vet.littlepaws.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//public class SecurityConfig {
//
//    @Configuration
//    public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//        @Autowired
//        public CustomUserDetailsService customUserDetailsService;
//
//        @Autowired
//        private JwtRequestFilter jwtRequestFilter;
//
//        @Override
//        @Bean
//        public AuthenticationManager authenticationManagerBean() throws Exception {
//            return super.authenticationManagerBean();
//        }
//
//        @Bean
//        public PasswordEncoder passwordEncoder() {
//            return new BCryptPasswordEncoder();
//        }
//
//        @Override
//        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(customUserDetailsService);
//        }
//
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
////        auth.jdbcAuthentication().dataSource(dataSource)
////                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?")
////                .authoritiesByUsernameQuery("SELECT username, authority FROM authorities AS a WHERE username=?");
////    }
//
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .httpBasic().disable()
//                    .csrf().disable()
//                    .authorizeRequests()
//                    .antMatchers("/books").hasRole("USER")
//                    .antMatchers("/authenticate").permitAll()
//                    .antMatchers("/**").denyAll()
//                    .and()
//                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                    .and()
//                    .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//        }
//}
