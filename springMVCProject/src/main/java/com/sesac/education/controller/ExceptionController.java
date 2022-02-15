package com.sesac.education.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
//1.���������� �̿��ؼ� 500error�� ����ó��(servlet-context)

//404���� �������� �ʴ� ������ ��û�� ��
//�������� ���� ��� ������ �̰�����ó��
//2.ControllerAdvice�� �̿��ؼ� ���� Exception ó��

@ControllerAdvice //����Exception
public class ExceptionController {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handler404(HttpServletRequest request, Model model) {
		model.addAttribute("message", "�������� �ʴ� �������Դϴ�.");
		model.addAttribute("url", request.getRequestURL());
		
		return "error/errorPage404";
	}
}
