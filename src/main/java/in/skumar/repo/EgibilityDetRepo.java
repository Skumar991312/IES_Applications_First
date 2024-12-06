package in.skumar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.skumar.entity.EgibilityDetermination;

public interface EgibilityDetRepo extends JpaRepository<EgibilityDetermination, Integer> {

}
