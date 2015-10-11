/**
 * 
 */
package aaa.utils.dao.pojo.collection;

import aaa.utils.dao.pojo.IAbstractPOJO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class AbstractPOJOHashMap<T extends IAbstractPOJO<?>, V> extends AbstractMap<T, V> implements
		Serializable {

	HashMap<AbstractPOJOPack<T>, V> map = new HashMap<>();

	@Override
	public Set<Map.Entry<T, V>> entrySet() {
		return map.entrySet()
				.stream()
				.map(fakeEntry -> new Entry<>(fakeEntry.getKey().getValue(), fakeEntry.getValue()))
				.collect(toSet());
	}

	@Override
	public boolean containsKey(Object key) {
		return (key instanceof IAbstractPOJO<?>)
			&& map.containsKey(new AbstractPOJOPack<IAbstractPOJO<?>>((IAbstractPOJO<?>) key));
	}

	@Override
	public V get(Object key) {
		if (key instanceof IAbstractPOJO<?>) {
			return map.get(new AbstractPOJOPack<IAbstractPOJO<?>>((IAbstractPOJO<?>) key));
		}
		return null;
	}

	@Override
	public V put(T key, V value) {
		return map.put(new AbstractPOJOPack<>(key), value);
	}

	@Override
	public V remove(Object key) {
		if (key instanceof IAbstractPOJO<?>) {
			return map.remove(new AbstractPOJOPack<IAbstractPOJO<?>>((IAbstractPOJO<?>) key));
		}
		return null;
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public void clear() {
		map.clear();
	}

	@FieldDefaults(level = AccessLevel.PRIVATE)
	@AllArgsConstructor
	@Getter
	private static class Entry<T, V> implements Map.Entry<T, V> {

		T key;
		V value;

		@Override
		public V setValue(V value) {
			return this.value = value;
		}
	}

}
