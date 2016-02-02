package com.younghoe.jpa;

import org.springframework.data.repository.CrudRepository;

/**
 * <p>
 *     Generic CRUD Repository
 * </p>
 *
 * @author Younghoe Ahn
 */
public interface EntityRepository extends CrudRepository<Entity, Long>{

    public Entity save(Entity entity);

}
