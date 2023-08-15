package com.hospitallaboratory.util;

public class Queries {
	public static final String CREATEQUERY=
			"create table laboratory(category varchar(20),testName varchar(20),testId integer primary key,testAmount float,categoryId int )";
	public static final String INSERTQUERY=
			"insert into laboratory(category,testName,testId,testAmount,categoryId) values(?,?,?,?,?)";
	public static final String UPDATEQUERY=
			"update laboratory set testAmount=? where testId=?";
	public static final String DELETEQUERY=
			"delete from laboratory where testId=?";
	public static final String QUERY=
			"select * from laboratory";
	public static final String QUERYBYCATEGORY=
			"select * from laboratory where category=?";
	public static final String QUERYBYCATEGORYANDTESTNAME=
			"select * from laboratory where category=? and testName=?";
	public static final String QUERYBYTESTNAMEANDTESTID=
			"select * from laboratory where testName=? and testId=?";
	public static final String QUERYBYTESTNAMEANDTESTAMOUNT=
			"select * from laboratory where testName=? and testAmount=?";

}
