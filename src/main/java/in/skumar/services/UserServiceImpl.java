package in.skumar.services;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.skumar.bindings.DashbordCard;
import in.skumar.bindings.LoginForm;
import in.skumar.bindings.UserAccForm;
import in.skumar.constants.AppConstants;
import in.skumar.entity.EligEntity;
import in.skumar.entity.UserEntity;
import in.skumar.repo.EligRepo;
import in.skumar.repo.PlanRepo;
import in.skumar.repo.UserRepo;
import in.skumar.utils.EmailUtils;

@Service
public class UserServiceImpl implements UserServices{

  @Autowired
  private UserRepo userRepo;

  @Autowired
  private EmailUtils emailUtils;

  @Autowired
  private EligRepo eligRepo;

  @Autowired
  private PlanRepo planRepo;

	@Override
	public String login(LoginForm loginForm) {

		UserEntity entity=userRepo.findByEmailAndPwd(loginForm.getEmail(),loginForm.getPwd());

		if(entity == null) {

			return AppConstants.INVALID_CREDENTIALS;
		}
		if(AppConstants.MESSAGE.equals(entity.getActiveSw()) && AppConstants.UNLOCKED.equals(entity.getAccountStatus())){

		   return AppConstants.SUCCESS;
		}
		else {
			return AppConstants.ACTIVE_LOCK_UNACTIVE_LOCK;
		}

	}

	@Override
	public boolean recoverPWD(String email) {

		  UserEntity userEntity=userRepo.findByEmail(email);

		  if(null==userEntity){

			  return false;
	      }else {

		String subject=AppConstants.RECOVER_PWD;
		String body=readEmailBody(AppConstants.FORGET_EMAIL_BODY,userEntity);

		return emailUtils.senEmail(subject, body,email);


		  }
	}

	@Override
	public DashbordCard fetchDashbordInfo() {

	Long planCont=planRepo.count();

	List<EligEntity> eligList=eligRepo.findAll();

	Long approvedCount=eligList.stream().filter(ed->ed.getPlanStatus().equals(AppConstants.APROVE_PLAIN)).count();


	Long denined=eligList.stream().filter(ed->ed.getPlanStatus().equals(AppConstants.DCLINED_PLAIN)).count();

	Double benefitAmt=eligList.stream().mapToDouble(ed->ed.getBenefitAmt()).summaryStatistics().getSum();

	DashbordCard card=new DashbordCard();

	card.setPlanCout(planCont);
	card.setApprovedCount(approvedCount);
	card.setBenefitAtmGiven(benefitAmt);
	card.setDeninedCount(denined);

	return card;
	}

	@Override
	public UserAccForm getUserByEmail(String email) {

		UserEntity userEntity=userRepo.findByEmail(email);
		UserAccForm user=new UserAccForm();
		BeanUtils.copyProperties(userEntity, user);

		return user;
	}

    private String readEmailBody(String fiename, UserEntity user) {

          StringBuilder sb=new StringBuilder();

		try(Stream<String> lines=Files.lines(Paths.get(fiename))){
			lines.forEach(line-> {

				line=line.replace(AppConstants.FNAME,user.getFullName());
				line=line.replace(AppConstants.PWD,user.getUserPwd());
				line=line.replace(AppConstants.EMAIL,user.getUserEmail());

				sb.append(line);
				});
		   }
		   catch(Exception e) {
			    e.printStackTrace();
		    }
         return sb.toString();

    }
}

