package com.webadds.WebAdds.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webadds.WebAdds.entity.Advertise;

public interface AdvertiseDao extends JpaRepository<Advertise, Integer> {
	
	@Query("select a.points from Advertise a WHERE a.id =:id")
	public int getAddpointById(@Param("id") int id);
	
	@Query("SELECT a FROM Advertise a WHERE a.isAssigned =1")
	public List<Advertise> getAssignedAdds();
	
	@Query("SELECT a FROM Advertise a WHERE a.isAssigned =0")
	public List<Advertise> getUnAssignedAdds();
	
}
