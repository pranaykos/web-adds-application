package com.webadds.WebAdds.pojos;

import com.webadds.WebAdds.entity.Advertise;
import com.webadds.WebAdds.entity.AssignRecord;

public class AdvertiseUserRecord {

	private Advertise advertise;
	private AssignRecord assignRecord;

	public AdvertiseUserRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdvertiseUserRecord(Advertise advertise, AssignRecord assignRecord) {
		super();
		this.advertise = advertise;
		this.assignRecord = assignRecord;
	}

	public Advertise getAdvertise() {
		return advertise;
	}

	public void setAdvertise(Advertise advertise) {
		this.advertise = advertise;
	}

	public AssignRecord getAssignRecord() {
		return assignRecord;
	}

	public void setAssignRecord(AssignRecord assignRecord) {
		this.assignRecord = assignRecord;
	}

}
