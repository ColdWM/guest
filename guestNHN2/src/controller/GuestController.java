package controller;


import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.GuestService;
import dto.Guest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller public class GuestController {        
       
        @RequestMapping("/hello")      
        public ModelAndView helloWorld(HttpServletRequest request,
    			 HttpServletResponse response) throws Exception{             
        	ModelAndView nextPage = new ModelAndView();
        	ArrayList<Guest> guestList = new GuestService().getGuests();
        	request.setAttribute("guestList", guestList);
        	nextPage.addObject("guestList",guestList);
        	nextPage.setViewName("list.jsp");
       
        return new ModelAndView("hello", "guestList", guestList);       
    }   
        
        @RequestMapping("/save")
        public ModelAndView saveGuest(HttpServletRequest request,
   			 HttpServletResponse response) throws Exception{          	
        	
       	ModelAndView nextPage = new ModelAndView();
       	boolean guestErr=false;
       	String guestE=request.getParameter("guestE");
		String guestText=request.getParameter("guestText");
		String guestPA=request.getParameter("guestPA");
		guestText = new String(guestText.getBytes("8859_1"), "utf-8");
		System.out.println(guestText);
		
		String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";   
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(guestE);
		if(m.matches()) {
			guestErr = true; 
			  }
		
		if(guestErr){  
			new GuestService().insert(new Guest(guestE, guestText, guestPA));			
			request.setAttribute("message", guestE+"님의 방명록을 등록했습니다.");
		}else{			
			request.setAttribute("message", "Email 형식이 올바르지 않습니다.");
		}
		
		
		
		nextPage.setViewName("result");
		return nextPage;       
   }
        
        @RequestMapping("/updateMove")
        public ModelAndView updateMoveGuest(HttpServletRequest request,
   			 HttpServletResponse response) throws Exception{
        	ModelAndView nextPage = new ModelAndView();
        	
    		String guestId=request.getParameter("guestId");
    		Guest guest = new GuestService().getGuest(guestId);
    		
    		request.setAttribute("guest", guest);
    		
    		nextPage.setViewName("update");
    		return nextPage; 
        	
        }
        
        
        @RequestMapping("/update")
        public ModelAndView updateGuest(HttpServletRequest request,
   			 HttpServletResponse response) throws Exception{
        	ModelAndView nextPage = new ModelAndView();
           	String guestE=request.getParameter("guestE");
    		String guestText=request.getParameter("guestText");
    		String guestPA=request.getParameter("guestPA");
    		String guestId=request.getParameter("guestId");
    		guestText = new String(guestText.getBytes("8859_1"), "utf-8");
    		System.out.println(guestText+" gg "+guestPA+" hh "+guestId);
    		Guest guest = new Guest(guestE, guestText, guestPA, guestId);
    		
    		boolean paCheck = new GuestService().PACheck((new Guest(guestPA, guestId)));
    		if(paCheck){
    		new GuestService().update(guest);
    		request.setAttribute("message", guestE+"님의 방명록을 수정했습니다.");
    		}else{
    			request.setAttribute("message","암호 확인하세요." );
    			nextPage.setViewName("result.jsp");
    			
    		}
    		
    		nextPage.setViewName("result");
    		return nextPage; 
        	
        }
}  