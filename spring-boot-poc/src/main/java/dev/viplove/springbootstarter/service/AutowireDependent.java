package dev.viplove.springbootstarter.service;

import org.springframework.beans.factory.annotation.Qualifier;

import dev.viplove.springbootstarter.model.Joe;

public class AutowireDependent {
	
	private String dependencyStr;
	
	private Joe a;
	
	private Joe b;

	public AutowireDependent(Joe employeeD, Joe joeDaessin) {
		super();
		this.a = employeeD;
		this.b = joeDaessin;
	}

	public String getDependencyStr() {
		return dependencyStr;
	}

	public void setDependencyStr(String dependencyStr) {
		this.dependencyStr = dependencyStr;
	}

	public Joe getDependencyD() {
		return a;
	}

	@Qualifier("joeDaessin")
	public void setEmployeeD(Joe dependencyEmployee) {
		this.a = dependencyEmployee;
	}

	public Joe getJoeDaessin() {
		return b;
	}

	@Qualifier("pankaj")
	public void setJoeDaessin(Joe joeDaessin) {
		this.b = joeDaessin;
	}

	@Override
	public String toString() {
		return "AutowireDependent [dependencyStr=" + dependencyStr + ", a=" + a + ", b=" + b + "]";
	}
}
