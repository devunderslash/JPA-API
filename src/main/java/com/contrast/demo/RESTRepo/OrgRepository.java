package com.contrast.demo.RESTRepo;

import com.contrast.demo.DTO.DataResponse;
import com.contrast.demo.Entities.Application;
import com.contrast.demo.Entities.Organisation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource
public interface OrgRepository extends CrudRepository<Organisation, Long> {


    @Query(value = "select  ap.id as AppID, ap.name as AppName, pt.id as PlatID, ap.app_fk as PlatAppID, pt.name as PlatName from orgs as og JOIN apps as ap JOIN plats as pt ON og.id = ap.org_fk AND ap.app_fk = pt.id WHERE og.id = :id", nativeQuery = true)
    List<Organisation> findApplications(@Param("id") Long id);

    @Query(value = "select ap.id as AppID, ap.name as AppName, pt.id as PlatID, ap.app_fk as PlatAppID, pt.name as PlatName from orgs as og JOIN apps as ap JOIN plats as pt ON og.id = ap.org_fk AND ap.app_fk = pt.id WHERE og.id = :id AND ap.name LIKE `%:name%`", nativeQuery = true)
    List<Organisation> findApplicationPartial(@Param("id") Long id, @Param("name") String name);

    @Query(value = "select  ap.id as AppID, ap.name as AppName, pt.id as PlatID, ap.app_fk as PlatAppID, pt.name as PlatName from orgs as og JOIN apps as ap JOIN plats as pt ON og.id = ap.org_fk AND ap.app_fk = pt.id WHERE og.id = :id AND ap.name LIKE `%:name%` ORDER BY ap.name :sort", nativeQuery = true)
    List<Organisation> findApplicationPartialSort(@Param("id") Long id, @Param("name") String name, @Param("sort") String sort);

    @Query(value = "select  ap.id as AppID, ap.name as AppName, pt.id as PlatID, ap.app_fk as PlatAppID, pt.name as PlatName from orgs as og JOIN apps as ap JOIN plats as pt ON og.id = ap.org_fk AND ap.app_fk = pt.id WHERE og.id = :id AND ap.name ORDER BY ap.name :sort", nativeQuery = true)
    Iterable<Organisation> findApplicationSort(@Param("id") Long id, @Param("sort") String sort);
}
