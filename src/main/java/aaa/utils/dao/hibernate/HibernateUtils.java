package aaa.utils.dao.hibernate;

import org.hibernate.proxy.HibernateProxy;

public class HibernateUtils {
	
	public static final String FIELD_SEPARATOR = "."; //$NON-NLS-1$
	
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getClass(T proxy) {
		if (proxy instanceof HibernateProxy) {
			return ((HibernateProxy) proxy).getHibernateLazyInitializer().getPersistentClass();
		} else {
			return (Class<T>) proxy.getClass();
		}
	}

}
