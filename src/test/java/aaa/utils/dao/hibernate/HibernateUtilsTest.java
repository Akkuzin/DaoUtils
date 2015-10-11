package aaa.utils.dao.hibernate;

import aaa.utils.dao.pojo.IAbstractPOJO;
import org.hibernate.HibernateException;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;

public class HibernateUtilsTest {

	public static class Request implements IAbstractPOJO<Long> {

		@Override
		public Long getId() {
			return null;
		}

		@Override
		public String getRepresentation() {
			return null;
		}

		@Override
		public Object clone() throws CloneNotSupportedException {
			return null;
		}
	}

	@Test
	public void testInitialized() {
		assertEquals(Request.class, HibernateUtils.getClass(new Request()));
	}

	@Test
	public void testProxy() {
		HibernateProxy proxy = new HibernateProxy() {

			@Override
			public Object writeReplace() {
				return null;
			}

			@Override
			public LazyInitializer getHibernateLazyInitializer() {
				return new LazyInitializer() {

					@Override
					public void unsetSession() {

					}

					@Override
					public void setUnwrap(boolean unwrap) {

					}

					@Override
					public void setSession(org.hibernate.engine.spi.SessionImplementor session)
							throws HibernateException {

					}

					@Override
					public void setReadOnly(boolean readOnly) {

					}

					@Override
					public void setImplementation(Object target) {

					}

					@Override
					public void setIdentifier(Serializable id) {

					}

					@Override
					public boolean isUnwrap() {
						return false;
					}

					@Override
					public boolean isUninitialized() {
						return false;
					}

					@Override
					public boolean isReadOnlySettingAvailable() {
						return false;
					}

					@Override
					public boolean isReadOnly() {
						return false;
					}

					@Override
					public void initialize() throws HibernateException {

					}

					@Override
					public org.hibernate.engine.spi.SessionImplementor getSession() {
						return null;
					}

					@Override
					public Class getPersistentClass() {
						return Request.class;
					}

					@Override
					public Object getImplementation(org.hibernate.engine.spi.SessionImplementor session)
							throws HibernateException {
						return null;
					}

					@Override
					public Object getImplementation() {
						return null;
					}

					@Override
					public Serializable getIdentifier() {
						return null;
					}

					@Override
					public String getEntityName() {
						return null;
					}
				};
			}
		};
		assertEquals(Request.class, HibernateUtils.getClass(proxy));
	}

}