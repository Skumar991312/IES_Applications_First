package in.skumar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.skumar.entity.COEntity;

public interface CORepo extends JpaRepository<COEntity, Integer> {

}
