package com.redis.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SesionController {

	@GetMapping
	private String contador(HttpServletRequest request) {
		request.getSession().setAttribute("bazinga", "hola mundo");
		return request.getSession().getId();
	}

	@Cacheable("este")
	@GetMapping("/cache")
	private String cache(HttpServletRequest request) {

		return "cachin";
	}

}
