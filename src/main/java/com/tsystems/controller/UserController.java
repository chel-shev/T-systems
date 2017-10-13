package com.tsystems.controller;

import com.tsystems.bean.UserBean;
import com.tsystems.entity.User;
import com.tsystems.service.impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("userJSP")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserBean.class);

    @Autowired
    private UserService userService;

    @ModelAttribute("userJSP")
    public UserBean createUserBean() {
        return new UserBean();
    }

    @GetMapping(value = "/")
    public ModelAndView home(HttpServletRequest request) {
        logger.info("path = /");
        ModelAndView modelAndView = new ModelAndView("page");
        UserBean userBean = (UserBean) request.getSession().getAttribute("userJSP");
        if (userBean == null)
            modelAndView.addObject("userJSP", new UserBean());
        else
            modelAndView.addObject("userJSP", userBean);
        return modelAndView;
    }

    @PostMapping(path = "/user/sing_in")
    public ModelAndView signInUser(String email_in, String password_in, HttpServletRequest request) {
        logger.info("path = /user/sing_in");
        ModelAndView modelAndView = new ModelAndView("account");
        User user = userService.checkUser(email_in, password_in);
        if (user != null) {
            UserBean userBean = (UserBean) request.getSession().getAttribute("userJSP");
            userBean.setData(user);
            modelAndView.addObject("userJSP", userBean);
            return modelAndView;
        } else {
            return null;
        }
    }

    @PostMapping(path = "/user/sing_up")
    public ModelAndView signUpUser(String first_name_up, String last_name_up, String email_up, String date_up, String password_up, HttpServletRequest request) {
        logger.info("path = /user/sing_up");
        ModelAndView modelAndView = new ModelAndView("account");
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(date_up);
            User user = new User(email_up, password_up, first_name_up, last_name_up, date, false, null);
            userService.addUser(user);
            UserBean userBean = (UserBean) request.getSession().getAttribute("userJSP");
            userBean.setData(user);
            modelAndView.addObject("userJSP", userBean);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @ResponseBody
    @PostMapping(path = "/user/check_email")
    public String checkEmail(String email_up) {
        logger.info("path = /user/check_email");
        boolean check = userService.checkEmail(email_up);
        if (check) {
            return "no";
        } else {
            return "yes";
        }
    }

    @PostMapping(path = "/user")
    public ModelAndView updateUser(HttpServletRequest request) {
        logger.info("path = /user");
        UserBean userBean = (UserBean) request.getSession().getAttribute("userJSP");
        ModelAndView modelAndView;
        if (userBean.getEmail() == null) {
            modelAndView = new ModelAndView("account_login");
        } else {
            modelAndView = new ModelAndView("account");
            modelAndView.addObject("userJSP", userBean);
        }
        return modelAndView;
    }

    @PostMapping(path = "/user/menu")
    public ModelAndView getMenu() {
        logger.info("path = /user/menu");
        return new ModelAndView("menu");
    }

    @PostMapping(path = "/user/logout")
    public ModelAndView logoutUser() {
        logger.info("path = /user/logout");
        ModelAndView modelAndView = new ModelAndView("account_login");
        modelAndView.addObject("userJSP", new UserBean());
        return modelAndView;
    }
}