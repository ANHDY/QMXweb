package qmx.Dao;

import Entity.stuEntity;

public interface stuDao {
	//添加学生信息
	public static void addStu(stuEntity stu){};
	//学生修改信息
	public static void stuUpdate(stuEntity stu){};
	
	//学号查重
	public static boolean xuehaoSearch(String xuehao){
		return false;
		
	}
	
}
