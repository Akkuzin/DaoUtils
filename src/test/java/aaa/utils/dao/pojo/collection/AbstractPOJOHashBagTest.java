package aaa.utils.dao.pojo.collection;

import aaa.utils.dao.pojo.IAbstractPOJO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractPOJOHashBagTest {

	@FieldDefaults(level = AccessLevel.PRIVATE)
	@Getter
	@Setter
	@AllArgsConstructor
	static class AbstractPOJOStub implements IAbstractPOJO<Long> {

		Long id;
		String data;

		@Override
		public String getRepresentation() {
			return toString();
		}

		@Override
		public Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}

	@Test
	public void simpleTest() {
		AbstractPOJOBag<IAbstractPOJO<Long>> bag = new AbstractPOJOHashBag<>();
		bag.add(new AbstractPOJOStub(1L, "ABC")); //$NON-NLS-1$
		bag.add(new AbstractPOJOStub(1L, "XXX")); //$NON-NLS-1$
		bag.add(new AbstractPOJOStub(2L, "ZXC")); //$NON-NLS-1$
		bag.add(new AbstractPOJOStub(3L, "QWE")); //$NON-NLS-1$
		assertEquals(2, bag.getCount(new AbstractPOJOStub(1L, "info"))); //$NON-NLS-1$
		assertEquals(1, bag.getCount(new AbstractPOJOStub(2L, "info"))); //$NON-NLS-1$
		assertEquals(1, bag.getCount(new AbstractPOJOStub(3L, "info"))); //$NON-NLS-1$
	}

}
