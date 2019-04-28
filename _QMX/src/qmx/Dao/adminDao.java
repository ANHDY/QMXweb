package qmx.Dao;

import Entity.adminEntity;
import Entity.stuEntity;

public interface adminDao {
	//管理员注册
	public static void adminRegister(adminEntity admin){
		
	}
	
	//管理员登录核对
	public static adminEntity adminLogin(adminEntity admin){
		return null;
	}
	//管理员删除学生
	public static void deletesStu(int id) {
	}
	
	//管理员查询某一个id的信息
	public static stuEntity adminSelect(int id){
		return null;
	}
	
	//管理员修改查询id的信息
	public static void adminUpdate(int id){
		
	}
	
}
