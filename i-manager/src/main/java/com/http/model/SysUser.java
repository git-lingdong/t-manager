package com.http.model;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author GR·cheng
 * @since 2017-11-17
 */
@TableName("sys_user")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
	private Long id;
    /**
     * 用户名
     */
	private String name;
    /**
     * 用户年龄
     */
	private Integer age;
    /**
     * 自定义填充的创建时间
     */
	private Date ctime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysUser{" +
			"id=" + id +
			", name=" + name +
			", age=" + age +
			", ctime=" + ctime +
			"}";
	}
}
