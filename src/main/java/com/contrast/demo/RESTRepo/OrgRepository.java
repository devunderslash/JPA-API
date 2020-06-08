package com.contrast.demo.RESTRepo;

import com.contrast.demo.Entities.Organisation;
import org.springframework.data.repository.CrudRepository;

public interface OrgRepository extends CrudRepository<Organisation, Long> {

}
