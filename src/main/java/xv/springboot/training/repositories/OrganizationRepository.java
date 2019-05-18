package xv.springboot.training.repositories;

import org.springframework.data.repository.CrudRepository;

import xv.springboot.training.entities.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, Long>{

}
