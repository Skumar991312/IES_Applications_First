package in.skumar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.skumar.entity.CitizenAppEntity;

public interface CitizenAppRepo extends JpaRepository<CitizenAppEntity, Integer>{

}
