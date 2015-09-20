package com.cn.business.hetongmanage.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.cn.business.comm.PaginationPage;
import com.cn.business.comm.Tools;
import com.cn.business.hetongmanage.dao.I_hetong;
import com.cn.business.hetongmanage.model.HetongVo;
@Component("hetongDAO")
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class HetongDAOImpl  implements I_hetong{
    Log logger = LogFactory.getLog(getClass());
    @Resource private SessionFactory sessionFactory;
    
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
    public List<?> queryListVoByPage(PaginationPage paginationPage,HetongVo vo) throws HibernateException {
	logger.info("DAO实现类开始");
	List<?> list = null;
	list = new ArrayList<HetongVo>();
	Session session = null;
	try {
	    // 取当前要显示的数据的页号
	    int pageNo = paginationPage.getPage();
	    // 得到一页数据的记录数
	    int pagesize = paginationPage.getPageSize();
	    //获取要去页面的开始记录索引号：
	    int index = (pageNo - 1) * pagesize; 
	    // 取session对象
	    session = sessionFactory.getCurrentSession();
	    String strhql = "from  HetongVo a  where 1=1  ";
	    String sql = "";
	    String jzmc =  Tools.checkNull(vo.getJzmc());
	    String quyu =  Tools.checkNull(vo.getQuyu());
	    String yzdh =  Tools.checkNull(vo.getYzdh());

	    if (!Tools.isEmpty(jzmc)) {
		sql = sql + " and a.jzmc like '%" + jzmc + "'";
	    }
	    if (!Tools.isEmpty(quyu)) {
		sql = sql + " and a.quyu = '" + quyu + "'";
	    }
	    if (!Tools.isEmpty(yzdh)) {
			sql = sql + " and a.yzdh = '" + yzdh + "'";
		}
	    sql = sql + " order by  a.id  desc ";
	    strhql += sql;
	    System.out.println("strhql=="+strhql);
	    Query query = session.createQuery(strhql);
	    // 设定分页参数
	    query.setFirstResult(index); //设定要提取一页数据的开始记录索引号
	    query.setMaxResults(pagesize);//设定一页记录数的大小。
	    list = query.list();
	    //获取符合条件的总记录数
	    Query query1 = session.createQuery(" select count(a.id) as maxrecord from HetongVo  as a where 1=1  " + sql);
	    int Count = ((Long) query1.list().get(0)).intValue();
	    paginationPage.setTotalCount(Count); //将总记录数存入对象中：
	    logger.info("得到查询记录总数=" + Count);
	    logger.info("DAO实现类成功");
	} catch (Exception ex) {
	    logger.info("DAO实现类失败,失败原因是：" + ex);
	    throw new HibernateException(ex.getMessage());
	}
	return list;
    }

    //==================================查询某个对象==================================================================================
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
    public  HetongVo  queryVo(HetongVo vo1)throws HibernateException {
    HetongVo vo=null;
	Session session =null;
	try{
	vo=new HetongVo();
	session = sessionFactory.getCurrentSession();
	vo=(HetongVo)session.get(HetongVo.class, vo1.getId());
	}
	catch(Exception ex)
	{   System.err.println("==queryVo==ex="+ex.getMessage());
	    ex.printStackTrace();
	    throw new HibernateException(ex.getMessage());
	}
	return vo;
    }
 
//=================================增加====================================================================================
    public boolean add(HetongVo obj) throws HibernateException {
    	logger.info("增加 DAO实现类开始");
    	Session session = null;
    	boolean  flag=false;
    	try {
    	    session = sessionFactory.getCurrentSession();
    	    session.save(obj);         
    	    logger.info("增加DAO实现类成功");
    	    flag=true;
    	} catch (Exception ex) {
    	    logger.info("增加DAO实现类失败,失败原因是：" + ex);
    	    ex.printStackTrace();
    	    flag=false;
    	    throw new HibernateException(ex.getMessage());
    	}
    	  return flag;
        }

    
//=================================修改==================================================================================
    public  boolean   update(HetongVo vo)throws HibernateException {
	Session session = null;
	boolean  flag=false;
	try {
		session = sessionFactory.getCurrentSession();
	    
	    String hqlUpdate = "update HetongVo set jzmc = :jzmc,hetong=:hetong,jibie=:jibie,quyu=:quyu,zhengqu=:zhengqu,mianji=:mianji,dizhi=:dizhi,yzmc=:yzmc,yzdh=:yzdh where id = :id";
	    Query query = session.createQuery(hqlUpdate);
	    query.setString("jzmc", vo.getJzmc());
	    query.setString("hetong", vo.getHetong());
	    query.setString("jibie", vo.getJibie());
	    query.setString("quyu", vo.getQuyu());
	    query.setString("zhengqu", vo.getZhengqu());
	    query.setString("mianji", vo.getMianji());
	    query.setString("dizhi", vo.getDizhi());
	    query.setString("yzmc", vo.getYzmc());
	    query.setString("yzdh", vo.getYzdh());
	    query.setInteger("id", vo.getId());
	    query.executeUpdate();
	   
	    flag=true;
	} catch (Exception ex) {
	    logger.info(" [修改DAO实现类失败,失败原因是：" + ex);
	    ex.printStackTrace();
	    flag=false;
	    throw new HibernateException(ex.getMessage());
	}
	 return flag;
    }
    
 // ==================================删除==================================================================================

    public  boolean   delete(HetongVo obj)throws HibernateException {
	logger.info("删除数据 DAO实现类开始");
	Session session = null;
	boolean  flag=false;
	try {
	    session = sessionFactory.getCurrentSession();
	    String deletehql=" delete HetongVo as a  where a.id =:id";
	    Query query=session.createQuery(deletehql);
	    query.setInteger("id", obj.getId());
	    int deleteint=query.executeUpdate();
	    System.out.println("删除数目="+deleteint);
	    logger.info("删除数据DAO实现类成功");
	    flag=true;
	} catch (Exception ex) {
	    
	    logger.info("删除数据DAO实现类失败,失败原因是：" + ex);
	    ex.printStackTrace();
	    flag=false;
	    throw new HibernateException(ex.getMessage());
	}
	  return flag;
    }
    
    
    
/*********************************************************************************************
    hibernate 的批量删除或修改：这里指一个sql可能修改或删除很多数据的情况一律采取HQL这样效率高
************************************************************************************************/  

	public  boolean   deleteBatch(String id) throws SQLException {
	logger.info("删除数据DAO实现类开始");
	Session session = null;
	boolean  flag=false;
	try {
	session = sessionFactory.getCurrentSession();
	String deletehql=" delete HetongVo where id in ("+id+")";
	Query query=session.createQuery(deletehql);
	int deleteint=query.executeUpdate();
	System.out.println("删除数目="+deleteint);
	logger.info("删除数据DAO实现类成功");
	flag=true;
	} catch (Exception ex) {
	logger.info("删除数据DAO实现类失败,失败原因是：" + ex);
	ex.printStackTrace();
	flag=false;
	throw new HibernateException(ex.getMessage());
	}
	return flag;
	}  


}