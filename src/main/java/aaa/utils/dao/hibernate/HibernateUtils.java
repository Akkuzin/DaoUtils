package aaa.utils.dao.hibernate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
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

	/** Получение следующего значения для sequence (Hibernate 4+) */
	public static Long getNextSequence(SessionFactory sessionFactory, String sequenceName) {
		return sessionFactory.getCurrentSession()
				.doReturningWork(connection -> {
					try (PreparedStatement preparedStatement =
							connection.prepareStatement(((SessionFactoryImplementor) sessionFactory).getDialect()
									.getSequenceNextValString(sequenceName))) {
						try (ResultSet resultSet = preparedStatement.executeQuery()) {
							resultSet.next();
							return resultSet.getLong(1);
						}
					}
				});
	}

}
