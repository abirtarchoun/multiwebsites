package app.igesa.config;
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;  
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(
						new 
					 	ApiInfoBuilder().title("Swagger Configuration For a Multiwebsites Application")
						.description("\"  Spring Boot Swagger configuration  \"")
								.license("\" Apache tomcat v 8.5 \"")
								.version("0.0.1")
						.build()).groupName("REST API V1")
				.select()
				.apis(RequestHandlerSelectors.basePackage("app.igesa"))
				.paths(PathSelectors.any()).build();
				
	}
}
	
	/*protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(
                                "/v2/api-docs",
                                 "/swagger-resources", 
                                "/swagger-resources/configuration/ui", 
                                "/swagger-resources/configuration/security")
                .permitAll()
}*/
