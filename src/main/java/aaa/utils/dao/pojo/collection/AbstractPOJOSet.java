/**
 * 
 */
package aaa.utils.dao.pojo.collection;

import aaa.utils.dao.pojo.IAbstractPOJO;

import java.io.Serializable;
import java.util.AbstractSet;

public abstract class AbstractPOJOSet<T extends IAbstractPOJO<?>> extends AbstractSet<T> implements
		Serializable {

}
