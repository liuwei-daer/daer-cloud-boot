package con.daer.cloud.gateway.handler;

import com.daer.cloud.common.core.util.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR;

/**
 * @author liuwei
 * @date 2019-11-24
 * Hystrix 降级处理
 */
@Slf4j
@Component
public class HystrixFallbackHandler implements HandlerFunction<ServerResponse> {

	@Autowired
	ObjectMapper objectMapper;

	@Override
	public Mono<ServerResponse> handle(ServerRequest serverRequest) {
		Optional<Object> originalUris = serverRequest.attribute(GATEWAY_ORIGINAL_REQUEST_URL_ATTR);

		originalUris.ifPresent(originalUri -> log.error("网关执行请求:{}失败,hystrix服务降级处理", originalUri));
		Result result = new Result<>();
		result.setSuccess(false);
		result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		result.setMessage("服务异常!");
		String resultstr = "";
		try {
			resultstr = objectMapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			log.error("服务降级处理JSON转换出错：",e);
		}
		return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
			.contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(resultstr));
	}
}
