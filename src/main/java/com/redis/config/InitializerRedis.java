package com.redis.config;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class InitializerRedis extends AbstractHttpSessionApplicationInitializer{
	  public InitializerRedis() {
          super(AppSesionConfig.class); 
  }

}
