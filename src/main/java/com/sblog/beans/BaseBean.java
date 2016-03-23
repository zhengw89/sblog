package com.sblog.beans;

import java.util.Date;

public abstract class BaseBean {

	private Date createTime;
	
	private Date updateTime;
	
	public BaseBean(){
		this.createTime = new Date();
		this.updateTime = new Date();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
