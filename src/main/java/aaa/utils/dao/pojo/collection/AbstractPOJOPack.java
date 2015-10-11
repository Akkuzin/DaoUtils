/**
 * 
 */
package aaa.utils.dao.pojo.collection;

import aaa.utils.dao.pojo.AbstractPOJOUtils;
import aaa.utils.dao.pojo.IAbstractPOJO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AbstractPOJOPack<T extends IAbstractPOJO<?>> implements Serializable {

	T value;

	@Override
	public int hashCode() {
		if (value == null) {
			return 0;
		} else if (value.getId() != null) {
			return value.getId().hashCode();
		} else {
			return value.hashCode();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractPOJOPack<?>) {
			return AbstractPOJOUtils.pojoEquals(value, ((AbstractPOJOPack<?>) obj).getValue());
		} else if (obj instanceof IAbstractPOJO<?>) {
			return AbstractPOJOUtils.pojoEquals(value, (IAbstractPOJO<?>) obj);
		}
		return false;
	}

}
