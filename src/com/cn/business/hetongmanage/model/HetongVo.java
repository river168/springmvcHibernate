package com.cn.business.hetongmanage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cn.business.comm.BaseVo;


@Entity
@Table(name="hetongtable")
public class HetongVo extends BaseVo{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  int  id;

	private  String  jzmc;
	private  String  hetong;
	private  String  jibie;
	private  String  quyu;
	private  String  zhengqu;
	private  String  mianji;
	private  String  dizhi;
	private  String  yzmc;
	private  String  yzdh;
	
	private  String checkbox;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getJzmc() {
		return jzmc;
	}
	public void setJzmc(String jzmc) {
		this.jzmc = jzmc;
	}
	public String getHetong() {
		return hetong;
	}
	public void setHetong(String hetong) {
		this.hetong = hetong;
	}
	public String getJibie() {
		return jibie;
	}
	public void setJibie(String jibie) {
		this.jibie = jibie;
	}
	public String getQuyu() {
		return quyu;
	}
	public void setQuyu(String quyu) {
		this.quyu = quyu;
	}
	public String getZhengqu() {
		return zhengqu;
	}
	public void setZhengqu(String zhengqu) {
		this.zhengqu = zhengqu;
	}
	public String getMianji() {
		return mianji;
	}
	public void setMianji(String mianji) {
		this.mianji = mianji;
	}
	public String getDizhi() {
		return dizhi;
	}
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	public String getYzmc() {
		return yzmc;
	}
	public void setYzmc(String yzmc) {
		this.yzmc = yzmc;
	}
	public String getYzdh() {
		return yzdh;
	}
	public void setYzdh(String yzdh) {
		this.yzdh = yzdh;
	}
	public String getCheckbox() {
		return "<input type='checkbox' value= '"+this.id+"' class='row' name = 'mycheckbox'   onclick ='javascript:singleRowCheck(this)' />";
	}
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
	
    
	
	
}
