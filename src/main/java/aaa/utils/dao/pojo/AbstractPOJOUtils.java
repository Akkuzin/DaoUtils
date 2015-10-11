/**
 * 
 */
package aaa.utils.dao.pojo;

import aaa.utils.dao.hibernate.HibernateUtils;

import java.io.Serializable;

public class AbstractPOJOUtils {

	/** Check if two objects is equal (in "id" terms) */
	public static boolean pojoEquals(IAbstractPOJO first, IAbstractPOJO second) {
		return (first == null && second == null)
			|| (first != null && second != null
				&& HibernateUtils.getClass(first).equals(HibernateUtils.getClass(second))
				&& first.getId() != null && first.getId().equals(second.getId()));
	}

	/** Check if two objects is not equal (in "id" terms) */
	public static boolean pojoNotEquals(IAbstractPOJO first, IAbstractPOJO second) {
		return !pojoEquals(first, second);
	}

	public static boolean isPojoValid(IAbstractPOJO pojo) {
		return pojo != null && pojo.getId() != null;
	}

	public static boolean isPojoNotValid(IAbstractPOJO pojo) {
		return !isPojoValid(pojo);
	}

	public static <ID extends Serializable> ID getId(IAbstractPOJO<ID> bean) {
		return bean == null ? null : bean.getId();
	}
}
