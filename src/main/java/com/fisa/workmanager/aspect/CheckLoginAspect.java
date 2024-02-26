package com.fisa.workmanager.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fisa.workmanager.exception.NotLoggedInException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Aspect
@Component
public class CheckLoginAspect {

    @Autowired
    private HttpServletRequest request;

    @Before("@annotation(com.fisa.workmanager.annotation.CheckLogin)")
    public void before(JoinPoint joinPoint) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("session") == null) {
            throw new NotLoggedInException(); 
        }
    }
}
