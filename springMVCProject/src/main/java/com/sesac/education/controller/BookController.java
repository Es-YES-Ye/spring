package com.sesac.education.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import kr.co.sesac.vo.BookVO;

@Controller
@RequestMapping("/book")
public class BookController {
	
	List<BookVO> blist = new ArrayList<BookVO>();
	
	public BookController() {

		blist.add(new BookVO(1, "java", "���ñ浿", "���ǻ�", "2022-02-08"));
		blist.add(new BookVO(2, "java", "����浿", "���ǻ�", "2022-02-08"));
		blist.add(new BookVO(3, "java", "����浿", "���ǻ�", "2022-02-08"));
		blist.add(new BookVO(4, "java", "�����浿", "���ǻ�", "2022-02-08"));
		blist.add(new BookVO(5, "java", "�浿", "���ǻ�", "2022-02-08"));

	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String bookInsert(BookVO book) {
		System.out.println("get : " + book);
		return "book/bookInsertForm";
	}

	/*@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String bookInsertPost2(BookVO book) {
		System.out.println("post : " + book);

		return "book/bookResult";
	}*/

	// @RequestParam : int bookNo = Integer.parseInt(request.getParameter("bno"))
	// @RequestParam �� ���� �̸��� �Ķ���� �̸��� ���ٸ� �����Ѵ�.
	//@ModelAttribute("book") : �Ķ���ͷ� ���� ���� View ���� �����ϱ�
	//==model.addAttribute("book2", book3);
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String bookInsertPost(
			@RequestParam("bno") int bookNo, 
			@RequestParam String title, 
			String author, 
			String pub,
			String pubDate, 
			int status, 
			@ModelAttribute("book") BookVO book,
			BookVO book3, 
			Model model, RedirectAttributes redirectAttr) {
	

		model.addAttribute("myname", "SUN");
	    model.addAttribute("book2", book3);
	    blist.add(book3);
	    redirectAttr.addFlashAttribute("message", " �� �� �� �� ! ");
	    
		return "redirect:/book/list";
	}

//�ϳ��� controller������ Exception ó��
//	@ExceptionHandler(Exception.class)
//	public String processException(Exception ex) {
//		ex.printStackTrace();
//		System.out.println("����: " + ex.getMessage());
//		return "error/errorPage500";
//	}
//	
	
	@RequestMapping("/list")
	public String booklist(Model model, HttpServletRequest request) {
	
		
		//�������� list�� redirect���� ��å��Ͽ��� list�� redirect���� �����Ѵ�
		//�����̶� ��å��Ͽ��� set�ߴ� attribute�� request�� ��´�.
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if(flashMap !=null) {
			String msg = (String)flashMap.get("message");
			model.addAttribute("message", msg);
		}		
		model.addAttribute("booklist", blist);
		return "book/booklist";
	}
	


	@RequestMapping("/detail")
	public String bookDetail(int bno, Model model) {
		//List���� bno ã�´�.
		BookVO book = null;

		for(BookVO b : blist) {
			if(b.getBno() == bno) {
				book = b;
				break;
			}
		}
		//������ model�� �����Ѵ�.
		model.addAttribute("book", book);
		
		//detail�������� forward�Ѵ�	
		return "book/detail"; //forward �����ϴ�
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BookVO book, Model model, RedirectAttributes redirectAttr) {
		System.out.println("������ Book" + book);
		for(BookVO b : blist) {
			if(b.getBno() == book.getBno()) {
				b.setAuthor(book.getAuthor());
				b.setPub(book.getPub());
				b.setPubDate(book.getPubDate());
				b.setStatus(book.getStatus());
				b.setTitle(book.getTitle());
				break;
			}
		}
//		model.addAttribute("message", "���� ����");
		//redirect������ model.addAttribute ��� �Ұ�
		redirectAttr.addFlashAttribute("message", "�� �� �� �� !!");
		return "redirect:/book/list"; //���ο� ��û
	}
	
	@RequestMapping(value = "/delete")
	public String delete(int bno, RedirectAttributes redirectAttr) {

		for(BookVO b : blist) {
			if(b.getBno() == bno) {
				blist.remove(b);
					break;
			}
		}

		redirectAttr.addFlashAttribute("message", "�� �� �� �� !!");
		return "redirect:/book/list"; //���ο� ��û
	}
}
