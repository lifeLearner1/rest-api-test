package com.ivy.rest.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ivy.rest.entity.Student;
import com.ivy.rest.service.StudentService;

@Controller
public class FileUploadController {
	@Autowired
	private StudentService stuService;
	
	@GetMapping("")
	public String showUploadForm() {
		System.out.println("hi");
		return "uploadForm";
	}
	 
	@RequestMapping(method = RequestMethod.POST, value = "/upload")
	public String uploadFile(@RequestParam("file") MultipartFile fileUpload) throws Exception{
		InputStream input = fileUpload.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		String line;
		while((line = br.readLine()) != null) {
			String[] arr= line.split(" ");
			stuService.addStudent(new Student(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), arr[3]));
			
		}
//		String name = fileUpload.getName();
//		System.out.println(name);
//		if(fileUpload != null && fileUpload.length > 0) {
//			for(CommonsMultipartFile file : fileUpload) {
//				InputStream input = file.getInputStream();
//				while(input.read() != -1) {
//					System.out.println(input.toString());
//				}
////				stuService.addStudent(file);
//			}
//		}
		return "success";
	}
	
}
