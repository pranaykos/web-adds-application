package com.webadds.WebAdds.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webadds.WebAdds.entity.Redemptionreq;

public interface RedemptionDao extends JpaRepository<Redemptionreq, Integer> {
	
	public List<Redemptionreq> getByUserId(int userId);
	
	@Query("SELECT r FROM Redemptionreq r WHERE r.isAccepted = 1")
	public List<Redemptionreq> getAllAcceptedRedemptions();
	
	@Query("SELECT COUNT(*) FROM Redemptionreq")
	public int getTotalRedemptionCount();
	
	@Query("SELECT COUNT(*) FROM Redemptionreq r WHERE r.isAccepted = 1")
	public int getApprovedRedemptionCount();
}
