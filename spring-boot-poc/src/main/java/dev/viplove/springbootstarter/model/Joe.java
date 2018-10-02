package dev.viplove.springbootstarter.model;

public class Joe {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dependency [name=" + name + "]";
	}
}
