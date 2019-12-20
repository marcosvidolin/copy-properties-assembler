package com.vidolima.copypropertiesassembler;

import java.util.Collection;

/**
 * Assembler interface. If a class is responsible for transforming one object
 * into another it should implement this interface.
 *
 * @author mvidolin
 * @since Dez 20, 2019
 *
 * @param <D>
 */
public interface ResourceAssembler<D> {

  /**
   * Transforms an object of type D (domain) into an object of type R
   * (Resource)
   *
   * @param domain
   *            object
   * @param clazz
   *            the type of the class to convert
   * @return resource object
   */
  <R> R fromDomain(D domain, Class<R> clazz);

  /**
   * Transforms a collection of D (domain) objects into a collection of R
   * (resource) objects
   *
   * @param domains
   * 			collection of domains
   * @param clazz
   *      the type of the class to convert
   * @return collection of resources
   */
  <R> Collection<R> fromDomain(Collection<D> domains, Class<R> clazz);

  /**
   * Transforms a collection of D (domain) objects into a collection of R
   * (resource) objects
   *
   * @param domains
   * 			collection of domains
   * @param clazz
   *      the type of the class to convert
   * @return collection of resources
   */
  <R> Iterable<R> fromDomain(Iterable<D> domains, Class<R> clazz);

}
