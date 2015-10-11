/**
 * 
 */
package aaa.utils.dao.pojo.collection;

import aaa.utils.dao.pojo.IAbstractPOJO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Iterator;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AbstractPOJOPackIterator<T extends IAbstractPOJO<?>> implements Iterator<T>,
		Serializable {

	Iterator<AbstractPOJOPack<T>> iterator;

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public T next() {
		return iterator.next().getValue();
	}

	@Override
	public void remove() {
		iterator.remove();
	}

}
