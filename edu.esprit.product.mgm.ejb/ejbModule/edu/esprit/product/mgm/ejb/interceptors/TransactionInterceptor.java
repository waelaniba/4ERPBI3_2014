package edu.esprit.product.mgm.ejb.interceptors;

import java.lang.reflect.Field;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.transaction.UserTransaction;

public class TransactionInterceptor {

	@AroundInvoke
	public Object processTransaction(InvocationContext invCtx) throws Exception{

		Logger logger = Logger.getLogger(invCtx.getMethod().getDeclaringClass().getName());

		Field field = invCtx.getMethod().getDeclaringClass().getField("tx");
		Object oTx = field.get(invCtx.getTarget());
		UserTransaction tx = (UserTransaction) oTx;

		logger.info("\n\n===================> Starting transaction for method [ " + invCtx.getMethod().getName() + " ]\n\n");
		tx.begin();

		Object obj = invCtx.proceed();

		logger.info("\n\n===================> Committing transaction for method [ " + invCtx.getMethod().getName() + " ]\n\n");
		tx.commit();


		return obj;
	}

}
