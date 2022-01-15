package model.actor;

import java.util.ArrayList;
import java.util.List;

import model.impl.Locatable;
import model.item.Location;

public class ServiceRequester extends User implements Locatable{
	private Location location;

	@Override
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location=location;
	}

	public static List<ServiceRequester> allServiceRequester;
	static {
		init();
	}
	private static void init() {
		allServiceRequester=new ArrayList<ServiceRequester>();
		ServiceRequester sr1=new ServiceRequester();
		ServiceRequester sr2=new ServiceRequester();
		sr1.setLocation(Location.allLocation.get(2));
		sr2.setLocation(Location.allLocation.get(3));
		allServiceRequester.add(sr1);
		allServiceRequester.add(sr2);
	}
}
