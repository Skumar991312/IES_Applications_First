package in.skumar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.skumar.entity.BenefitInfo;

public interface BenefitInfoRepo extends JpaRepository<BenefitInfo,Integer> {

}
