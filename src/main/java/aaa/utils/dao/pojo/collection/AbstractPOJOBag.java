/**
 * 
 */
package aaa.utils.dao.pojo.collection;

import aaa.utils.dao.pojo.IAbstractPOJO;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;

@SuppressWarnings("serial")
public abstract class AbstractPOJOBag<T extends IAbstractPOJO<?>> implements Serializable {
	public abstract void add(T object);

	public abstract long remove(T object);

	public abstract void add(T object, long count);

	public abstract long remove(T object, long count);

	public abstract long getCount(T object);

	public abstract void addAll(AbstractPOJOBag<T> bag);

	public abstract void removeAll(AbstractPOJOBag<T> bag);

	public abstract void addAll(Collection<T> collection);

	public abstract void removeAll(Collection<T> collection);

	public abstract Set<T> getObjectSet();

	public abstract Set<Entry<T, Long>> getEntrySet();

	public abstract void clear();

}
