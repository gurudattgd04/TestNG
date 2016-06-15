package com.test.testng;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class annotationsTesting {
	
	
	@BeforeClass(alwaysRun = true)
	public void beforeclass()
	{
		System.out.println("before class test case");
	}
	
	@BeforeMethod(alwaysRun = true, groups="p1")
	public void beforemethod()
	{
		System.out.println("before test case");
	}
	
	@Test(groups="p1", alwaysRun=true)
	public void test1()
	{
		System.out.println("1st test case");
	}
	
	@Test(groups="p2", dependsOnGroups = {"p1.*"})
	public void testDependency()
	{
		System.out.println("dependecy test case");
	}

	@Test(groups="p2")
	public void test2()
	{
		System.out.println("2nd test case");
	}
	
	@Test(groups="p1")
	public void test3()
	{
		System.out.println("p1 test case");
	}
}
