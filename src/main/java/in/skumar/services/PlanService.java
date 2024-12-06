package in.skumar.services;

import java.util.List;

import in.skumar.bindings.PlanForm;

public interface PlanService {

	public boolean createPlan(PlanForm planForm);

	public List<PlanForm> fetchPlans();

	public PlanForm getPlanBYId(Integer planId);

	public String changePlanStatatus(Integer planId,String Status);



}
