package model.item;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.impl.Locatable;

public class Location {
	double longitude;
	double latitude;
	String locatAt;
	public Location(double longitude, double latitude, String locatAt) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.locatAt = locatAt;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getLocatAt() {
		return locatAt;
	}
	public void setLocatAt(String locatAt) {
		this.locatAt = locatAt;
	}
	public double distance(Location location) {
		double alpha = this.latitude / 180 * Math.PI;
		double gama = location.latitude / 180 * Math.PI;
		double beta = Math.abs(this.longitude - location.longitude) / 180 * Math.PI;
		return 6371 * Math.acos(Math.sin(alpha) * Math.sin(gama) + Math.cos(alpha) * Math.cos(beta) * Math.cos(gama));
	}

	public <T extends Locatable> List<T> matchList(List<T> list) {
		List<T> newList=list.subList(0, list.size());
		newList.sort(new LocationComparator(this));
		return newList;
	}
	public <T extends Locatable> List<T> matchList(List<T> list,int n) {
		return matchList(list).subList(0, n);
	}
	
	public static class LocationComparator implements Comparator<Locatable>{
		Location location;
		public LocationComparator(Location location){
			this.location=location;
		}
		@Override
		public int compare(Locatable o1, Locatable o2) {
			if((location.distance(o1.getLocation())-location.distance(o2.getLocation()))>0) {
				return 1;
			}
			else {
				if((location.distance(o1.getLocation())-location.distance(o2.getLocation()))<0) {
					return -1;
				}
				else {
					return 0;
				}
			}
		}
	}
	@Override
	public String toString() {
		String str="";
		str+=locatAt;
		str+="Longitude: ";
		str+=String.format("%.8f\n", longitude);
		str+="Latitude: ";
		str+=String.format("%.8f", latitude);
		return str;
	}
	public String toString(String breaker) {
		String str="";
		str+=locatAt+breaker;
		str+="Longitude: ";
		str+=String.format("%.8f"+breaker, longitude);
		str+="Latitude: ";
		str+=String.format("%.8f", latitude);
		return str;
	}
	public static List<Location> allLocation;
	static {
		init();
	}
	private static void init() {
		allLocation=new ArrayList<Location>();
		allLocation.add(new Location(116.974206,36.620264,"济南大学第八食堂"));
		allLocation.add(new Location(116.971061,36.615967,"济南大学第九食堂"));
		allLocation.add(new Location(116.968488,36.616245,"济南大学学生公寓24号楼"));
		allLocation.add(new Location(116.979945,36.622343,"济南大学第12教学楼"));
	}
}
