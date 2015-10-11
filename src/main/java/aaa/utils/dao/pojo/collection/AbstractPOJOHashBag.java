/**
 * 
 */
package aaa.utils.dao.pojo.collection;

import aaa.nvl.Nvl;
import aaa.utils.dao.pojo.IAbstractPOJO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class AbstractPOJOHashBag<T extends IAbstractPOJO<?>> extends AbstractPOJOBag<T> implements
		Serializable {

	AbstractPOJOHashMap<T, Long> map = new AbstractPOJOHashMap<>();

	public AbstractPOJOHashBag(Collection<T> collection) {
		addAll(collection);
	}

	@Override
	public long getCount(T object) {
		return Nvl.nvl(map.get(object), 0L);
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public void add(T object) {
		add(object, 1);
	}

	@Override
	public long remove(T object) {
		return remove(object, 1);
	}

	@Override
	public void add(T object, long count) {
		map.put(object, getCount(object) + count);
	}

	@Override
	public long remove(T object, long count) {
		long currentCount = getCount(object);
		if (currentCount <= count) {
			map.remove(object);
			return currentCount;
		}
		map.put(object, currentCount - count);
		return count;
	}

	@Override
	public void addAll(AbstractPOJOBag<T> bag) {
		bag.getEntrySet().stream().forEach(entry -> add(entry.getKey(), entry.getValue()));
	}

	@Override
	public void removeAll(AbstractPOJOBag<T> bag) {
		bag.getEntrySet().stream().forEach(entry -> remove(entry.getKey(), entry.getValue()));
	}

	@Override
	public void addAll(Collection<T> collection) {
		collection.stream().forEach(this::add);
	}

	@Override
	public void removeAll(Collection<T> collection) {
		collection.stream().forEach(this::remove);
	}

	@Override
	public Set<Entry<T, Long>> getEntrySet() {
		return map.entrySet();
	}

	@Override
	public Set<T> getObjectSet() {
		return map.keySet();
	}

}
