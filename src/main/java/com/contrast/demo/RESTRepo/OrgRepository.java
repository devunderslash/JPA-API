package com.contrast.demo.RESTRepo;

import com.contrast.demo.DTO.DataResponse;
import com.contrast.demo.Entities.Application;
import com.contrast.demo.Entities.Organisation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@RepositoryRestResource
public interface OrgRepository extends CrudRepository<Organisation, Long> {


    @Query(value = "select DISTINCT og.id as id, og.name as OrgName, ap.org_fk as OrgId, ap.id as AppID, ap.name as AppName, pt.id as PlatID, ap.app_fk as PlatAppID, pt.name as PlatName\n" +
            "from Orgs as og\n" +
            "JOIN Apps as ap\n" +
            "JOIN Plats as pt\n" +
            "ON og.id = ap.org_fk\n" +
            "AND ap.app_fk = pt.id\n" +
            "WHERE og.id = :id", nativeQuery = true)
    List<Organisation> findApplications(@Param("id") Long id);

//    @Query(value = "select ap.id as AppID, ap.name as AppName, pt.id as PlatID, ap.app_fk as PlatAppID, pt.name as PlatName from Orgs as og JOIN Apps as ap JOIN Plats as pt ON og.id = ap.org_fk AND ap.app_fk = pt.id WHERE og.id = :id AND ap.name LIKE `%:name%`", nativeQuery = true)
//    List<Organisation> findApplicationPartial(@Param("id") Long id, @Param("name") String name);
//
//    @Query(value = "select  ap.id as AppID, ap.name as AppName, pt.id as PlatID, ap.app_fk as PlatAppID, pt.name as PlatName from Orgs as og JOIN Apps as ap JOIN Plats as pt ON og.id = ap.org_fk AND ap.app_fk = pt.id WHERE og.id = :id AND ap.name LIKE `%:name%` ORDER BY ap.name :sort", nativeQuery = true)
//    List<Organisation> findApplicationPartialSort(@Param("id") Long id, @Param("name") String name, @Param("sort") String sort);
//
//    @Query(value = "select  ap.id as AppID, ap.name as AppName, pt.id as PlatID, ap.app_fk as PlatAppID, pt.name as PlatName from Orgs as og JOIN Apps as ap JOIN Plats as pt ON og.id = ap.org_fk AND ap.app_fk = pt.id WHERE og.id = :id AND ap.name ORDER BY ap.name :sort", nativeQuery = true)
//    Iterable<Organisation> findApplicationSort(@Param("id") Long id, @Param("sort") String sort);
}
