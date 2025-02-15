package com.sunbeam.controllers;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.Mobile;
import com.sunbeam.entities.MobileForm;

@Component
public class MobileForm2MobileConverter implements Converter<MobileForm, Mobile> {
	
	public Mobile convert(MobileForm mf) {
		String imageName = mf.getImageFile().getOriginalFilename();
		Mobile m = new Mobile(mf.getId(), mf.getName(), mf.getRam(), mf.getStorage(), mf.getCompany(), mf.getPrice(), imageName); 
		return m;
	}



}
