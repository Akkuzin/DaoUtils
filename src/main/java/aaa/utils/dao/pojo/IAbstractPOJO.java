/**
 * 
 */
package aaa.utils.dao.pojo;

import aaa.lang.IPublicClonable;

import java.io.Serializable;

public interface IAbstractPOJO<ID extends Serializable> extends IPublicClonable {

	ID getId();

	String getRepresentation();

}
