package com.webadds.WebAdds.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webadds.WebAdds.entity.Advertise;
import com.webadds.WebAdds.entity.AssignRecord;

public interface RecordDao extends JpaRepository<AssignRecord, Integer> {
	
	@Query("SELECT r FROM AssignRecord r WHERE r.userId = :rid AND r.addId = :aid")
	public AssignRecord getUsersRecordsForId(@Param("rid") int recordId,
										  @Param("aid") int addId); 
	
	@Query("SELECT r FROM AssignRecord r WHERE r.addId = :aid ")
	public List<AssignRecord> getRecordsForAddId(@Param("aid") int addId);
	
	public List<AssignRecord> getByUserId(int userId);
	
	public AssignRecord getByUserIdAndAddId(int userId, int addId );
}
