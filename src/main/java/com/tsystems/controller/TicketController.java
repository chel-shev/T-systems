package com.tsystems.controller;

import com.tsystems.bean.UserBean;
import com.tsystems.service.impl.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @PostMapping(path = "/ticket/buy")
    public ModelAndView buyTicket(HttpServletRequest request, String id, String numSit) {
        UserBean userBean = (UserBean) request.getSession().getAttribute("userJSP");
        ModelAndView modelAndView = new ModelAndView("ticket");
        if (userBean.getEmail() != null) {
            if (!ticketService.buyTicket(userBean, id, numSit)) {
                return null;
            } else {
                modelAndView.addObject("ticketDTO", ticketService.getTicket(userBean.getEmail()));
                modelAndView.addObject("user", userBean);
            }
        } else {
            return null;
        }
        return modelAndView;

    }


    @PostMapping(path = "/ticket")
    public ModelAndView search(HttpServletRequest request) {
        return new ModelAndView("user_ticket_search");
    }

    @PostMapping(path = "/ticket/get")
    public ModelAndView getTicket(HttpServletRequest request) {
        UserBean userBean = (UserBean) request.getSession().getAttribute("userJSP");
        ModelAndView modelAndView = new ModelAndView("ticket");
        modelAndView.addObject("ticketDTO", ticketService.getTicket(userBean.getEmail()));
        modelAndView.addObject("user", userBean);
        return modelAndView;
    }

    @PostMapping(path = "/ticket/get/ticket_info")
    public ModelAndView infoTicket(String id) {
        ModelAndView modelAndView = new ModelAndView("ticket_info");
        modelAndView.addObject("listTicket", ticketService.getListTicket(id));
        return modelAndView;
    }

    @PostMapping(path = "/ticket/list")
    public ModelAndView listTicket(String id) {
        ModelAndView modelAndView = new ModelAndView("list_ticket");
        modelAndView.addObject("listTicket", ticketService.getListTicket(id));
        return modelAndView;
    }
}
