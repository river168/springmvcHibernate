package com.cn.business.hetongmanage.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import com.cn.business.comm.PaginationPage;
import com.cn.business.hetongmanage.model.HetongVo;



public interface I_hetong {
	public  List  queryListVoByPage(PaginationPage PaginationPageVo,HetongVo contionVo)throws HibernateException;
	public  HetongVo  queryVo(HetongVo contionVo)throws HibernateException ;
	public  boolean   update(HetongVo contionVo)throws HibernateException ;
	public  boolean   delete(HetongVo contionVo)throws HibernateException ;
	public  boolean   add(HetongVo HetongVo)throws HibernateException;
	public  boolean   deleteBatch(String id) throws SQLException ;

}
