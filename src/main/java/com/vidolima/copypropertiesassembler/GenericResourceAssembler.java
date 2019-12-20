package com.vidolima.copypropertiesassembler;

import com.vidolima.copypropertiesassembler.exception.IllegalAssemblerConversionException;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.BeanUtils;

/**
 * Generic class responsible for copying the matching data from domain (D) to
 * resource (R) classes and vice versa. The only require is to the both classes have the same
 * param names
 *
 * @author mvidolin
 * @since Dez 20, 2019
 *
 * @param <D>
 */
public class GenericResourceAssembler<D> implements ResourceAssembler<D> {

  private Class<D> domainClass;

  /**
   * Assembler Constructor. You must pass an instance of the target class
   * (this could be an empty instance).
   */
  public GenericResourceAssembler(Class<D> domainClass) {
    this.domainClass = domainClass;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public <R> R fromDomain(D domain, Class<R> clazz) {
    if (domain == null) {
      return null;
    }
    try {
      R resource = clazz.newInstance();
      BeanUtils.copyProperties(domain, resource);
      return resource;
    } catch (InstantiationException | IllegalAccessException e) {
      throw new IllegalAssemblerConversionException("Could not create new instance of the target class.", e);
    }
  }

  /**
   * {@inheritDoc}
   * @return
   */
  @Override
  public <R> Collection<R> fromDomain(Collection<D> domains, Class<R> clazz) {
    if (domains == null) {
      return null;
    }
    Collection<R> resources = new ArrayList<>();
    for (D domain : domains) {
      resources.add(this.fromDomain(domain, clazz));
    }
    return resources;
  }

  /**
   * {@inheritDoc}
   * @return
   */
  @Override
  public <R> Iterable<R> fromDomain(Iterable<D> domains, Class<R> clazz) {
    return this.fromDomain(domains, clazz);
  }

}