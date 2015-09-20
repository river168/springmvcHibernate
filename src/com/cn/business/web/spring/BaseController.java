package com.cn.business.web.spring;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.cn.business.comm.FlexiGrid;

/**
 * @author changjun
 */
@Controller
public class BaseController {
	
	/**
	 * 获取客户端分页信息
	 * @author changjun
	 * @param HttpServletRequest request
	 * @returnFlexiGrid fg
	 */
	public FlexiGrid getFlexiGridFromRequest(HttpServletRequest request){
		FlexiGrid fg = new FlexiGrid();
		
		fg.setPage(StringUtils.isEmpty(request.getParameter("page")) ? 0 : Integer.parseInt(request.getParameter("page")));
		
		fg.setRp(StringUtils.isEmpty(request.getParameter("rp")) ? 0 : Integer.parseInt(request.getParameter("rp")));
		
		fg.setSortname(StringUtils.isEmpty(request.getParameter("sortname")) ? null : request.getParameter("sortname"));
		
		fg.setSortorder(StringUtils.isEmpty(request.getParameter("sortorder")) ? null : request.getParameter("sortorder"));
		
		return fg;
	}
	
	
	
	/**
	 * 构建返回的包含分页的数据json信息 这里也可以由map通过json转换为String
	 * @author changjun
	 * @param  totalRowNum 记录函数
	 * @param  list
	 * @return String
	 */
	public String buildResponsePageJson(FlexiGrid flexiGrid) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		pageInfo.put("page",  flexiGrid.getPage());
		pageInfo.put("total", flexiGrid.getTotal());
		pageInfo.put("rows",  flexiGrid.getRows());
		 
		return  JSON.toJSONString(pageInfo);
	}
	
	
	
	/**
	 * ajax对象输出
	 * @author changjun
	 * @param String data 
	 * @param HttpServletResponse  response
	 * @return  void
	 */
	public void print(String data,HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(data);
		out.flush();
		out.close();
	}
	
 
	/**
	 * 以JSON数据返回到页面
	 * @author changjun
	 * @param requset
	 * @param response
	 * @param Map<?,?> data
	 * @param data
	 */
	public void printJSON(HttpServletRequest request,
			HttpServletResponse response, Map<?, ?> data) {
		    printJSON(request, response, JSON.toJSONString(data));
	}
	
	/**
	 * 将JSON数据返回到页面
	 * @author changjun
	 * @param requset
	 * @param response
	 * @param data
	 * @author void
	 */
	public void printJSON(HttpServletRequest request,
			HttpServletResponse response, String data) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}

}
