package com.kunteng.cyria.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.kunteng.cyria.component.GoAccessDeniedHandler;
import com.kunteng.cyria.component.GoAuthenticationEntryPoint;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	@Autowired
    private ResourceServerTokenServices tokenServices;

    @Value("${security.jwt.resource-ids}")
    private String resourceIds;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceIds).tokenServices(tokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	http
            .requestMatchers()
            .and()
            .authorizeRequests() 
            .antMatchers("/api/v1/oauth/**").permitAll()
            .antMatchers("/api/v1/**").authenticated()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(
					(request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
			.accessDeniedHandler(
					(request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED));
    }
}
