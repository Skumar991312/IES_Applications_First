package in.skumar.services;

import java.util.List;

import org.springframework.stereotype.Service;

import in.skumar.bindings.PlanForm;

@Service
public class PlanServiceImpl implements PlanService {

	@Override
	public boolean createPlan(PlanForm planForm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PlanForm> fetchPlans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanForm getPlanBYId(Integer planId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changePlanStatatus(Integer planId, String Status) {
		// TODO Auto-generated method stub
		return null;
	}

}
