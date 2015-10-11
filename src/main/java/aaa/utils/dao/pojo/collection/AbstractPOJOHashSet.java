/**
 * 
 */
package aaa.utils.dao.pojo.collection;

import aaa.utils.dao.pojo.IAbstractPOJO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

@SuppressWarnings("serial")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AbstractPOJOHashSet<T extends IAbstractPOJO<?>> extends AbstractPOJOSet<T> {

	HashSet<AbstractPOJOPack<T>> set = new HashSet<>();

	public AbstractPOJOHashSet(Collection<T> collection) {
		addAll(collection);
	}

	@Override
	public boolean add(T e) {
		return set.add(new AbstractPOJOPack<>(e));
	}

	@Override
	public boolean remove(Object o) {
		return (o instanceof IAbstractPOJO<?>)
			&& set.remove(new AbstractPOJOPack<IAbstractPOJO<?>>((IAbstractPOJO<?>) o));
	}

	@Override
	public boolean contains(Object o) {
		return (o instanceof IAbstractPOJO<?>)
			&& set.contains(new AbstractPOJOPack<IAbstractPOJO<?>>((IAbstractPOJO<?>) o));
	}

	@Override
	public Iterator<T> iterator() {
		return new AbstractPOJOPackIterator<>(set.iterator());
	}

	@Override
	public int size() {
		return set.size();
	}

	@Override
	public boolean isEmpty() {
		return set.isEmpty();
	}

	@Override
	public void clear() {
		set.clear();
	}

}
