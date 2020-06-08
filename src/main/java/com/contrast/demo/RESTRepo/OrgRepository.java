package com.contrast.demo.RESTRepo;

import com.contrast.demo.Entities.Organisation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrgRepository extends CrudRepository<Organisation, Long> {

}
