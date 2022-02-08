package com.produtos.apirest.config;

/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
*/
import springfox.documentation.service.ApiInfo;
import org.springframework.context.annotation.Bean;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

	    @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          //.apis(RequestHandlerSelectors.any())
	          .apis(RequestHandlerSelectors.basePackage("com.produtos.apirest"))
	          //.paths(PathSelectors.any())
	          //.paths(PathSelectors.regex("/api.*")) 
	          .build()
	          .apiInfo(metaData());
	    }
	    
	    private ApiInfo metaData() {
		    return new ApiInfoBuilder()
		        .title("Api Rest v1.0 2022")
		        .description("Gerenciamento de aplicação java Web / Android ")
		        .version("1.0.0")
		        .license("Apache License Version 2.0")
		        .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.txt")
		        .build();
		  }
	    
	  @Override
	  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("swagger-ui.html")
	        .addResourceLocations("classpath:/META-INF/resources/");

	    registry.addResourceHandler("/webjars/**")
	        .addResourceLocations("classpath:/META-INF/resources/webjars/");
	  }
	 

	    /*
	    	@Override    
	    	public void configure(WebSe web) throws Exception {
	    	web.ignoring().mvcMatchers(
	    			"/swagger-ui.html/**", 
	    			"/configuration/**",
	    			"/*",
	    			"/swagger-resources/**", 
	    			"/v2/api-docs",
	    			"/webjars/**");
	    	}
	    	*/
/*
	private static final String[] AUTH_WHITELIST = {
	        "/produto-resources/**",
	        "/swagger-ui.html",
	        "/v2/api-docs",
	        "/webjars/**"
	};

	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers(AUTH_WHITELIST);
	}
*/

}









//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

/*   EDUARDO
package com.produtos.apirest.config;
import springfox.documentation.service.ApiInfo;
import org.springframework.context.annotation.Bean;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

	@Bean
	public Docket greetingApi() {
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.produtos"))
		.build()
		.apiInfo(metaData());
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder()
		.title("Api Rest V1.0 2022")
		.description("Gerenciamento de aplicação java Web / Android ")
		.version("1.0.0")
		.license("Apache License Version 2.0")
		.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.txt")
		.build();
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {	
		registry.addResourceHandler("/swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
*/