<<<<<<< HEAD
package service;

import java.util.List;

public interface EntityBeanConverter {

	<E, B> B convertToBean(E entity, Class<B> beanClass);

	<E, B> List<B> convertToBeanList(Iterable<E> entities, Class<B> beanClass);

	<E, B> E convertToEntity(B bean, Class<E> entityClass);
}
=======
package service;

import java.util.List;

public interface EntityBeanConverter {

	<E, B> B convertToBean(E entity, Class<B> beanClass);

	<E, B> List<B> convertToBeanList(Iterable<E> entities, Class<B> beanClass);

	<E, B> E convertToEntity(B bean, Class<E> entityClass);
}
>>>>>>> N commit from master
