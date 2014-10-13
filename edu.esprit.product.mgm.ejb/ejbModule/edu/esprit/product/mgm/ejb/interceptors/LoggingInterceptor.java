package edu.esprit.product.mgm.ejb.interceptors;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggingInterceptor {

	@PostConstruct
	public void init(InvocationContext invCtx) throws Exception{

		Logger logger = Logger.getLogger(invCtx.getTarget().getClass().getName());
		logger.info("\n\n===================> Allocating resources for bean [ " + 
				invCtx.getTarget().getClass().getName() + " ]\n\n");

	}

	@AroundInvoke
	public Object processLogging(InvocationContext invCtx) throws Exception {

		Logger logger = Logger.getLogger(invCtx.getMethod().getDeclaringClass().getName());

		logger.info("\n\n===================> Starting processing method [ " + invCtx.getMethod().getName() + " ]\n\n");
		Object obj = invCtx.proceed();
		logger.info("\n\n===================> Ending processing method [ " + invCtx.getMethod().getName() + " ]\n\n");

		return obj;
	}

	@PreDestroy
	public void cleanup(InvocationContext invCtx) throws Exception{

		Logger logger = Logger.getLogger(invCtx.getTarget().getClass().getName());
		logger.info("\n\n===================> Releasing resources for bean [ " + 
				invCtx.getTarget().getClass().getName() + " ]\n\n");

	}

}
