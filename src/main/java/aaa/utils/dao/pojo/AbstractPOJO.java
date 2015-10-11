package aaa.utils.dao.pojo;

import java.io.Serializable;

import javax.persistence.Transient;

public abstract class AbstractPOJO<T extends Serializable> implements IAbstractPOJO<T> {

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public abstract T getId();

	@Override
	@Transient
	public String getRepresentation() {
		return null;
	}

}
