package com.br.brazilpanels.controllers;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.brazilpanels.bean.DataBean;
import com.br.brazilpanels.bean.ResultBean;
import com.br.brazilpanels.service.ResultBeanService;
import com.br.brazilpanels.util.Utils;
 
@Controller
public class LoadController {
	
	@Autowired
	ResultBeanService resultBeanService;
	
	@RequestMapping(value="/load/{data}", method = RequestMethod.POST,produces="application/json")
	public @ResponseBody String load(@PathVariable String data) {
 
		String result = "";
		System.out.println(data);
		
		//Type type = new TypeToken<List<Object>>(){}.getType();	
		
        //List<Object> objecto=(List<Object>) Utils.toGenericObject(data,type);
		try{
			
			DataBean dataBean = (DataBean) Utils.toGenericObject(data,DataBean.class);
		
			if(dataBean.getStatus().equals("OK")){
				for (ResultBean resultBean : dataBean.getResults()) {
					resultBean.setID(null);
					System.out.println("ID: " + resultBean.getID());
					System.out.println("Name: " + resultBean.getName());
					System.out.println("Q1_1: " + resultBean.getQ1_1());
					System.out.println("Q1_2: " + resultBean.getQ1_2());
					System.out.println("Q1_3: " + resultBean.getQ1_3());
					System.out.println("Q1_4: " + resultBean.getQ1_4());
					System.out.println("Q1_5: " + resultBean.getQ1_5());
					System.out.println("Q1_6: " + resultBean.getQ1_6());
					System.out.println("Q1_7: " + resultBean.getQ1_7());
					System.out.println("Q1_8: " + resultBean.getQ1_8());
					System.out.println("Q1_9: " + resultBean.getQ1_9());
					System.out.println("Q1_Outros: " + resultBean.getQ1_Outros());
					System.out.println("Q2: " + resultBean.getQ2());
					System.out.println("Q3: " + resultBean.getQ3());
					resultBeanService.saveOrUpdate(resultBean);
				}
				result = "OK";
			}else{
				result = "NO DATA";
			}

		}catch (Exception e) {
			System.out.println(e.getMessage());
			result = "ERROR";
		}
		System.out.println("Result: " + result);
		return "{\"status\":\""+result+"\"}";
 
	}
	
	@RequestMapping(value="/load2", method = RequestMethod.POST,produces="application/json")
	public @ResponseBody String load2(HttpServletRequest request, HttpServletResponse response) {
 
		String result = "";
		String data = request.getParameter("data");
		System.out.println(data);
		
		//Type type = new TypeToken<List<Object>>(){}.getType();	
		
        //List<Object> objecto=(List<Object>) Utils.toGenericObject(data,type);
		try{
			
			DataBean dataBean = (DataBean) Utils.toGenericObject(data,DataBean.class);
		
			if(dataBean.getStatus().equals("OK")){
				for (ResultBean resultBean : dataBean.getResults()) {
					resultBean.setID(null);
					System.out.println("ID: " + resultBean.getID());
					System.out.println("Name: " + resultBean.getName());
					System.out.println("Q1_1: " + resultBean.getQ1_1());
					System.out.println("Q1_2: " + resultBean.getQ1_2());
					System.out.println("Q1_3: " + resultBean.getQ1_3());
					System.out.println("Q1_4: " + resultBean.getQ1_4());
					System.out.println("Q1_5: " + resultBean.getQ1_5());
					System.out.println("Q1_6: " + resultBean.getQ1_6());
					System.out.println("Q1_7: " + resultBean.getQ1_7());
					System.out.println("Q1_8: " + resultBean.getQ1_8());
					System.out.println("Q1_9: " + resultBean.getQ1_9());
					System.out.println("Q1_Outros: " + resultBean.getQ1_Outros());
					System.out.println("Q2: " + resultBean.getQ2());
					System.out.println("Q3: " + resultBean.getQ3());
					resultBeanService.saveOrUpdate(resultBean);
				}
				result = "OK";
			}else{
				result = "NO DATA";
			}

		}catch (Exception e) {
			System.out.println(e.getMessage());
			result = "ERROR";
		}
		System.out.println("Result: " + result);
		return "{\"status\":\""+result+"\"}";
 
	}

	
}