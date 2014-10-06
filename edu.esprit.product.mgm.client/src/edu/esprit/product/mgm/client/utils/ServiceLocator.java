package edu.esprit.product.mgm.client.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocator {

	private static ServiceLocator myInstance;
	private Context ctx;
	private Map<String, Object> proxiesCache;

	private ServiceLocator() {

		try {

			ctx = new InitialContext();

		} catch (NamingException e) {

			e.printStackTrace();
		}

		proxiesCache = Collections
				.synchronizedMap(new HashMap<String, Object>());
	}

	public static ServiceLocator getInstance() {

		if (null == myInstance)
			myInstance = new ServiceLocator();

		return myInstance;
	}

	public Object lookupProxy(String JNDIName) {

		Object proxy = null;

		if (proxiesCache.containsKey(JNDIName)) {

			proxy = proxiesCache.get(JNDIName);
			System.out.println("\nProxy retrieved from the cache. \n "
					+ "Proxy: " + proxy + "\n JNDI NAME: " + JNDIName 
					+ "\n");

		} else {

			try {

				proxy = ctx.lookup(JNDIName);
				System.out.println("\nProxy retrieved by JNDI lookup. \n "
						+ "Proxy: " + proxy + "\n JNDI NAME: " + JNDIName
						+ "\n");
			} catch (NamingException e) {
				e.printStackTrace();
			}

			proxiesCache.put(JNDIName, proxy);
		}

		return proxy;

	}

}
