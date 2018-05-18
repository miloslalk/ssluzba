package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;


import dto.StudentDTO;
import service.interfaces.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	IStudentService studentService;
	
	@RequestMapping("/all")
	public ModelAndView studenti() {
		ModelAndView mav= new ModelAndView("student/students");
		mav.addObject("students",studentService.getStudents());
		System.out.println(studentService.getStudents());
		return mav;
	}
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public View addStudent(@ModelAttribute("studentDTO") StudentDTO studentDTO) {
		System.out.println("\n POGODIO");
		System.out.println(studentDTO);
		//studentService.save(studentDTO);
		return new RedirectView("all");
	}
	
	@RequestMapping(path = "/save", method = RequestMethod.GET)
	public ModelAndView addStudentForm() {
		ModelAndView mav = new ModelAndView("student/addStudent2");
		mav.addObject("student",new StudentDTO());
		return mav;
	}
	@RequestMapping("/{id}")
	public ModelAndView edit(@PathVariable("index") int index) {
		ModelAndView mav = new ModelAndView("student/saveDriver");
		
		StudentDTO studentDTO = studentService.get(index);
		if(studentDTO == null) {
			mav.addObject("student",new StudentDTO());
		} else {
			mav.addObject("student", studentDTO);
		}
		return mav;
	}

}
