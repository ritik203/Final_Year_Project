package com.sunbeam.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sunbeam.entities.Mobile;
import com.sunbeam.entities.MobileForm;
import com.sunbeam.entities.Result;
import com.sunbeam.services.MobileServiceImpl;

@RestController
public class MobileController {
	
@Autowired
private MobileServiceImpl ms;

@GetMapping("/mobile")
public Result findAllMobiles() {
	List<Mobile> list=ms.findAllMobiles();
	return Result.success(list);
}
@GetMapping("/mobile/{id}")
public Result findMobileById(@PathVariable("id")int id) {
	Mobile mob=ms.findById(id);
	return Result.success(mob);
	
}

@Value("${images.path}")
private String imageFolderPath;

@GetMapping(value="/images/{imagename}", produces="image/jpg")
public void downloadImage(@PathVariable("imagename") String imageName,
		HttpServletResponse resp) throws IOException {
	//resp.setContentType("image/jpeg");
	System.out.println(imageName);
	try(FileInputStream in = new FileInputStream(imageFolderPath + imageName)) {
		FileCopyUtils.copy(in, resp.getOutputStream());
	} // in.close();
}

@Autowired
private MobileForm2MobileConverter mobileForm2MobileConverter;

@PostMapping(value="/mobile", consumes="multipart/form-data")
public Result saveMobile(@ModelAttribute MobileForm m) throws IOException {
	MultipartFile inFile = m.getImageFile();
	String fileName = inFile.getOriginalFilename();
	File outFile = new File(imageFolderPath + fileName); 
	inFile.transferTo(outFile);
	Mobile mob = mobileForm2MobileConverter.convert(m);
	int id = ms.saveMobile(mob);
	mob.setId(id); // set auto-generated id into mobile object
	return Result.success(mob);
}



}
