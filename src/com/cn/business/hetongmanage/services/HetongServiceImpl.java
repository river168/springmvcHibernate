package com.cn.business.hetongmanage.services;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import com.cn.business.comm.PaginationPage;
import com.cn.business.hetongmanage.dao.I_hetong;
import com.cn.business.hetongmanage.model.HetongVo;

@Service("hetongservices")
public class HetongServiceImpl implements I_hetongServices {
    @Resource  I_hetong  hetongDAO;
    boolean  falg=false;
	public boolean add(HetongVo HetongVo) throws HibernateException {
		
		return hetongDAO.add(HetongVo);
		
	}

	public boolean delete(HetongVo contionVo) throws HibernateException {
		return	hetongDAO.delete(contionVo);
	}

	public boolean deleteBatch(String id) throws SQLException {
		return hetongDAO.deleteBatch(id);
	}

	public List queryListVoByPage(PaginationPage PaginationPageVo,
			HetongVo contionVo) throws HibernateException {
		return hetongDAO.queryListVoByPage(PaginationPageVo, contionVo);
	}

	public HetongVo queryVo(HetongVo contionVo) throws HibernateException {
		return hetongDAO.queryVo(contionVo);
	}

	public boolean update(HetongVo contionVo) throws HibernateException {
		return hetongDAO.update(contionVo);
	}

}
