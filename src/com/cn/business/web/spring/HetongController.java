package com.cn.business.web.spring;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cn.business.comm.FlexiGrid;
import com.cn.business.comm.PaginationPage;
import com.cn.business.hetongmanage.model.HetongVo;
import com.cn.business.hetongmanage.services.I_hetongServices;

@Controller
@RequestMapping("/hetongAction.do") 
public class HetongController  extends BaseController{
	// 跳转友情链接页面
	@Resource 
	protected  I_hetongServices hetongService;
	
	@RequestMapping(params="method=queryList")
	public  ModelAndView queryList(HttpServletRequest request,
		    //获取查询条件的值：
			@RequestParam(required = false, defaultValue = "") String jzmc,
			@RequestParam(required = false, defaultValue = "") String quyu,
			@RequestParam(required = false, defaultValue = "") String yzdh,
			//这个参数绑定到页面中隐含控件 message:作为报消息用的
			//1:还有就是增加,修改，删除等后，将消息存放到模型中：在这里可以从这些操作的模型对象中将消息获取
			//存到下面该方法的模型对象中：mv.addObject("message",message);去页面显示。
			@RequestParam(required = false, defaultValue = "") String message)throws Exception {
		
		ModelAndView mv = new ModelAndView("ContractManage/ContractLackingPage");
		try {
			//这里是分页需要的：从页面的标签中获取要去的页号：存入到分页对象中。
			String pageNO = request.getParameter(PaginationPage.jumpPage);
			PaginationPage PaginationPageVo = new PaginationPage();
			PaginationPageVo.setPage(pageNO);
			
			HetongVo hetong = new HetongVo();
			hetong.setJzmc(jzmc);		
			hetong.setQuyu(quyu);
			hetong.setYzdh(yzdh);
			//页面记住查询对象的值
			request.setAttribute("quyu", quyu);
			request.setAttribute("jzmc", jzmc);
			request.setAttribute("yzdh", yzdh);
			
			List<HetongVo> list = this.hetongService.queryListVoByPage(PaginationPageVo, hetong);
			mv.addObject("list",list);
			//将消息存储起来到页面去显示：
			mv.addObject("message",message);
			//这里是分页要用到的。将分页对象存住。让分页标签后台程序获取分页信息，输出到页面显示分页控件。
		    request.setAttribute(PaginationPage.pagination, PaginationPageVo); //标签中取对象值
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	
	//直接转发，不做查询
	@RequestMapping(params="method=queryList2")
	public ModelAndView  frowardto(HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "") String message){	
		ModelAndView mv = new ModelAndView("ContractManage/ContractLackingPage");
		//将消息存储起来到页面去显示：
		try {
			if(StringUtils.isNotBlank(message)){
				mv.addObject("message",URLDecoder.decode(message,"UTF-8"));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	//通过ajax来取数据
	@RequestMapping(params="method=getJsonList")
	public void  getJSONList(HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "") String jzmc,
			@RequestParam(required = false, defaultValue = "") String quyu,
			@RequestParam(required = false, defaultValue = "") String yzdh,
			HttpServletResponse response){
		FlexiGrid  flexiGrid = this.getFlexiGridFromRequest(request);
		PaginationPage paginationpagevo = new PaginationPage();
		paginationpagevo.setPage(String.valueOf(flexiGrid.getPage()));
		HetongVo hetong = new HetongVo();
		hetong.setJzmc(jzmc);		
		hetong.setQuyu(quyu);
		hetong.setYzdh(yzdh);
		List<HetongVo> list = this.hetongService.queryListVoByPage(paginationpagevo, hetong);
		//分页总记录数
		flexiGrid.setTotal(paginationpagevo.getTotalCount());
		flexiGrid.setRows(list);
		this.printJSON(request, response, buildResponsePageJson(flexiGrid));
		 
	}
	
	
	//转发到增加页面
	@RequestMapping(params="method=toaddpage")
	public ModelAndView  toaddpage(HttpServletRequest request){	
		ModelAndView mv = new ModelAndView("ContractManage/Add");		
		return mv;
	}
	
	
	@RequestMapping(params="method=add")
	public ModelAndView   add(HetongVo hetongVo)throws Exception{
		    ModelAndView mv = new ModelAndView(new RedirectView("hetongAction.do?method=queryList2"));
			try {
				System.out.println("hetongVo="+hetongVo);
				this.hetongService.add(hetongVo);
				mv.addObject("message", URLEncoder.encode("增加成功", "UTF-8"));
			} catch (Exception e) {
				mv.addObject("message", URLEncoder.encode("增加失败","UTF-8"));
				e.printStackTrace();
			}
		return mv;
	}
	
	
	@RequestMapping(params="method=delete"  ,method = RequestMethod.GET)
	public ModelAndView deleteHetong(@RequestParam("id") Integer id) {
		ModelAndView mv = new ModelAndView(new RedirectView("hetongAction.do?method=queryList"));
		try {
			HetongVo vo = new HetongVo();
			vo.setId(id);
			this.hetongService.delete(vo);
			mv.addObject("message", URLEncoder.encode("删除成功","UTF-8"));
		} catch (Exception e){
			try {
				mv.addObject("message", URLEncoder.encode("删除失败","UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				 
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return mv;
	}
	
	
	@RequestMapping(params="method=queryVo" ,method = RequestMethod.GET)
	public ModelAndView queryVo(@RequestParam(required = false, defaultValue = "") String id) {
		ModelAndView mv = new ModelAndView("ContractManage/Update");
		try {
			System.out.println("===============getHetongVo========================");
			if(StringUtils.isNotBlank(id)){
				id = id.substring(0,id.indexOf(","));
			}
			HetongVo vo = new HetongVo();
			vo.setId(Integer.parseInt(id));
		HetongVo  hetong=this.hetongService.queryVo(vo);
		mv.addObject("hetong", hetong);
		} catch (Exception e){
			e.printStackTrace();
		}
		return mv;
	}	
	
	 
	
 
	@RequestMapping(params="method=update")
	public ModelAndView   updateHetong(HetongVo hetongVo)throws Exception{
		ModelAndView mv = new ModelAndView(new RedirectView("hetongAction.do?method=queryList2"));
			try {
				this.hetongService.update(hetongVo);
				mv.addObject("message",URLEncoder.encode("修改成功","UTF-8"));
			} catch (Exception e) {
				mv.addObject("message", URLEncoder.encode("修改失败","UTF-8"));
				e.printStackTrace();
			}
		return mv;
	}
	
	
	@RequestMapping(params="method=deletebach")
	public ModelAndView batchdelete(@RequestParam("pkes") String ids) {
		ModelAndView mv = new ModelAndView(new RedirectView("hetongAction.do?method=queryList2"));
		try {
		   if(StringUtils.isNotBlank(ids)){
			   ids = ids.substring(0, ids.length() - 1);
		   }
           this.hetongService.deleteBatch(ids);
       		mv.addObject("message", URLEncoder.encode("删除成功","UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(params="method=reset")
	public ModelAndView reset() {
		//来这里重定向以后：返回到前面的queryList没有带参数值过去。因此queryList方法中获取的查询条件就空字符串：不做查询条件
		ModelAndView mv = new ModelAndView(new RedirectView("hetongAction.do?method=queryList"));
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
}
