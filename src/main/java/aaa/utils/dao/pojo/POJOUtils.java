package aaa.utils.dao.pojo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class POJOUtils {

	private static final String CLASS_FIELD_NAME = "class"; //$NON-NLS-1$

	@FunctionalInterface
	public interface FieldProcessor {
		void processField(	String attributeName,
							Class<?> fieldClazz,
							Column columnAnnotation,
							JoinColumn joinColumnAnnotation);
	}

	public static void iterateOverProperties(Class<?> clazz, FieldProcessor processor)
			throws IntrospectionException, SecurityException, NoSuchFieldException {
		for (PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(clazz)
				.getPropertyDescriptors()) {
			Method readMethod = propertyDescriptor.getReadMethod();
			if (readMethod != null && readMethod.getAnnotation(Transient.class) == null
				&& readMethod.getAnnotation(EmbeddedId.class) == null) {
				String attributeName = propertyDescriptor.getName();
				if ((!CLASS_FIELD_NAME.equals(attributeName))
					&& clazz.getDeclaredField(attributeName) != null) {
					processor.processField(	attributeName,
											clazz.getDeclaredField(attributeName).getType(),
											readMethod.getAnnotation(Column.class),
											readMethod.getAnnotation(JoinColumn.class));
				}
			}
		}
	}

}
