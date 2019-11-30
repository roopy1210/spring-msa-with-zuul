package com.roopy.services.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.netflix.zuul.http.HttpServletRequestWrapper;

public class RequestLoggingFilter extends ZuulFilter {
	
	private static Logger log = LoggerFactory.getLogger(RequestLoggingFilter.class);

	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = new HttpServletRequestWrapper(ctx.getRequest());
		
		log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
		
		String requestData = null;
		JSONParser jsonParser = new JSONParser();
		JSONObject requestJson = null;
		
		try {
			if (request.getContentLength() > 0 ) {
				requestData = CharStreams.toString(request.getReader());
			}
			
			if (requestData == null) {
				return null;
			}
			requestJson = (JSONObject) jsonParser.parse(requestData);
		} catch (Exception e) {
			log.error("Error parsing JSON request", e);
			return null;
		}
		log.info(String.format("%s request payload %s", request.getMethod(), requestJson.toJSONString()));
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
