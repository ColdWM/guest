package controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.GuestService;
import dto.Guest;

@Controller public class GuestController {        
       
        @RequestMapping("/hello")      
        public ModelAndView helloWorld(HttpServletRequest request,
    			 HttpServletResponse response) throws Exception{             
        	ModelAndView nextPage = new ModelAndView();
        	ArrayList<Guest> guestList = new GuestService().getGuests();
        	request.setAttribute("guestList", guestList);
        	nextPage.addObject("guestList",guestList);
        	nextPage.setViewName("list.jsp");
        	
            //String message = "Hello World, Spring 3.0!";           
            //return new ModelAndView("hello", "message", message); 
       
        return new ModelAndView("hello", "guestList", guestList);       
    }   
}  