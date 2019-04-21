package qmx.User;

public class Users {
	public Users(){
		
	}
	private int id;
	private String name; 
	private String xuehao; 
	private String xueyuan;
	private String zhuanye;
	private String qq; 
	private String phone;
	private String sex;
	private String hobby;
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public int getId() {
		return id;
	}
	public void setId(int string) {
		this.id = string;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getXuehao() {
		return xuehao;
	}
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	public String getXueyuan() {
		return xueyuan;
	}
	public void setXueyuan(String xueyuan) {
		this.xueyuan = xueyuan;
	}
	public String getZhuanye() {
		return zhuanye;
	}
	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Users(int id,String name,String xuehao,String xueyuan,String zhuanye,
			String qq,String phone,String sex,String hobby){
		super();
		this.id = id;
		this.name = name;
		this.xuehao = xuehao;
		this.xueyuan = xueyuan;
		this.zhuanye = zhuanye;
		this.qq = qq;
		this.phone = phone;
		this.sex = sex;
		this.hobby = hobby;
	}
	
}
