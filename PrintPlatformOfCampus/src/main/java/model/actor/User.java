package model.actor;

public abstract class User {
	private static int count=0;
	private int id;
	@Override
	public boolean equals(Object obj) {
		User user=(User)obj;
		return this.id==user.id;
	}
	public User() {
		this.id=count;
		count++;
	}
	public int getId() {
		return id;
	}
}
