package com.cn.business.hetongmanage.Test;

import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.business.comm.PaginationPage;
import com.cn.business.hetongmanage.model.HetongVo;
import com.cn.business.hetongmanage.services.I_hetongServices;

public class HetongServiceImplTest {
	static I_hetongServices db1=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context=new  ClassPathXmlApplicationContext("applicationContext.xml");
		db1=(I_hetongServices)context.getBean("hetongservices");
		System.out.println("=db1======="+db1);
	}

	@Test
	public void testQueryListVoByPage() {
		testAdd(); /*增加测试数据*/
		PaginationPage pagination = new PaginationPage();
		System.out.println("=====================执行查询测试开始=HibernateHQL==queryListVoBySQL1======================");
		HetongVo dataVo=new HetongVo();
		pagination.setPage("1");
		List list1 = db1.queryListVoByPage(pagination,dataVo);
		System.out.println("=====================执行查询测试结束=HibernateHQL==queryListVoBySQL1============list="+list1);
	}

	@Test
	public void testQueryVo() {
		testAdd(); /*增加测试数据*/
	    PaginationPage paginationPage=new PaginationPage();
	    paginationPage.setPageSize(1);
	    HetongVo vo=new HetongVo();
	    vo.setId(1);
        vo=db1.queryVo(vo);
        System.out.println("queryVo()=查询某条记录=====vo="+vo);
        System.out.println("============---[HibernateHQL方式查询某条记录]---============================");
	}

	@Test
	public void testAdd() {
		HetongVo vo=new HetongVo();
		vo.setDizhi("地址");
		vo.setHetong("合同");
        vo.setJibie("级别");
        vo.setJzmc("基站名称");
        vo.setMianji("面积");
        vo.setQuyu("区域");
		db1.add(vo);
        System.out.println("============---[Hibernate OBJECT方式增加一条数据]---============================");
	}

	@Test
	public void testUpdate() {
		testAdd(); /*增加测试数据*/
		HetongVo vo=new HetongVo();
		vo.setId(1);
		db1.update(vo);
	    System.out.println("============---[Hibernate HQL方式修改一条数据]---============================");       
	}

	@Test
	public void testDelete() {
		testAdd(); /*增加测试数据*/
		HetongVo vo=new HetongVo();
		vo.setId(1);
		db1.delete(vo);
	    System.out.println("============---[Hibernate HQL方式修改一条数据]--============================");       
	}



}
