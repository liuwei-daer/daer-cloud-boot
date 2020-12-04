package con.daer.cloud.gateway.config;

import con.daer.cloud.gateway.handler.HystrixFallbackHandler;
import con.daer.cloud.gateway.handler.ImageCodeHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * @author liuwei
 * @date 2019-11-24
 * 路由配置信息
 */
@Slf4j
@Configuration
public class RouterFunctionConfig {

	@Autowired
	private HystrixFallbackHandler hystrixFallbackHandler;

	@Autowired
	private ImageCodeHandler imageCodeHandler;

//	@Autowired
//	private final SwaggerResourceHandler swaggerResourceHandler;
//
//	@Autowired
//	private final SwaggerSecurityHandler swaggerSecurityHandler;
//
//	@Autowired
//	private final SwaggerUiHandler swaggerUiHandler;


	@Bean
	public RouterFunction routerFunction() {
		return RouterFunctions.route(
			RequestPredicates.path("/fallback")
				.and(RequestPredicates.accept(MediaType.ALL)), hystrixFallbackHandler)
			.andRoute(RequestPredicates.GET("/code")
				.and(RequestPredicates.accept(MediaType.IMAGE_JPEG)), imageCodeHandler);
//			.andRoute(RequestPredicates.GET("/swagger-resources");
//				.and(RequestPredicates.accept(MediaType.ALL)), swaggerResourceHandler)
//			.andRoute(RequestPredicates.GET("/swagger-resources/configuration/ui")
//				.and(RequestPredicates.accept(MediaType.ALL)), swaggerUiHandler)
//			.andRoute(RequestPredicates.GET("/swagger-resources/configuration/security")
//				.and(RequestPredicates.accept(MediaType.ALL)), swaggerSecurityHandler);

	}

}
