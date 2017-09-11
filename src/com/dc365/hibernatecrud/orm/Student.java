package com.dc365.hibernatecrud.orm;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable
{

	// Fields

	private String id;
	private String name;

	// Constructors

	/** default constructor */
	public Student()
	{
	}

	/** full constructor */
	public Student(String id, String name)
	{
		this.id = id;
		this.name = name;
	}

	// Property accessors

	public String getId()
	{
		return this.id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}