package com.board.aptboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AptController {
		private final AptService aptService;
		String cityName;
		String gunName;
		String guName;
		String aptName1;
		String aptAreas;
		String aptPrices;
	

		@GetMapping("/apt/apt")
		public String selectApt(Model model, @RequestParam( required = false) String city) {
			List<AptResponse> aptresponse = aptService.findCityList();
			List<String> aptResponseCity = new ArrayList<String>();
			for (int i = 0; i < aptresponse.size(); i++) {
				aptResponseCity.add(aptresponse.get(i).getCity());
			}
	
	
	
			model.addAttribute("city", aptResponseCity);
	
			return "/apt/apt";
		}
	
	
	  @GetMapping("/apt/apt1") 
	  public String selectApt1(Model model, @RequestParam(required=false) String city) {
	 
		  List<AptResponse> aptGunResponse = aptService.findGunList(city); 
		  List<String>  aptResponseGun = new ArrayList<String>(); 
		  for(int i=0; i<aptGunResponse.size(); i++) {
		  aptResponseGun.add(aptGunResponse.get(i).getGun()); }
		  
		  cityName = city;
		  model.addAttribute("city", cityName);
		  model.addAttribute("gun", aptResponseGun); 
		  return "/apt/apt";
	  }
	  
	  @GetMapping("/apt/apt2") 
	  public String selectApt2(Model model, @RequestParam(required=false) String gun) {
	 
		  List<AptResponse> aptGuResponse = aptService.findGuList(gun); 
		  List<String>  aptResponseGu = new ArrayList<String>(); 
		  for(int i=0; i<aptGuResponse.size(); i++) {
			  aptResponseGu.add(aptGuResponse.get(i).getGu()); 
		  }
		  
		  gunName = gun;
	
		  model.addAttribute("city", cityName);
		  model.addAttribute("gun", gunName); 
		  model.addAttribute("gu", aptResponseGu); 
		  return "/apt/apt"; 
	  }
	  @GetMapping("/apt/apt3") 
	  public String selectApt3(Model model, @RequestParam(required=false) String gu) {
	 
		  List<AptResponse> aptAptResponse = aptService.findAptList(gu); 
		  List<String>  aptResponseAptName = new ArrayList<String>(); 
		  for(int i=0; i<aptAptResponse.size(); i++) {
			  aptResponseAptName.add(aptAptResponse.get(i).getAptName()); 
		  }
		  
		  guName = gu;
	
		  model.addAttribute("city", cityName);
		  model.addAttribute("gun", gunName); 
		  model.addAttribute("gu", guName); 
		  model.addAttribute("aptName" ,aptResponseAptName);
		  return "/apt/apt"; 
	  }
	 
	  @GetMapping("/apt/apt4") 
	  public String selectApt4(Model model, @RequestParam(required=false) String aptName) {

		  List<AptResponse> aptAptAreaResponse = aptService.findAptAreaList(aptName); 
		  List<String>  aptResponseAptArea = new ArrayList<String>(); 
		  
		  for(int i=0; i<aptAptAreaResponse.size(); i++) {
			  aptResponseAptArea.add(aptAptAreaResponse.get(i).getAptArea()); 
		  }

		  aptName1 = aptName;
		  model.addAttribute("city", cityName);
		  model.addAttribute("gun", gunName); 
		  model.addAttribute("gu", guName); 
		  model.addAttribute("aptName" ,aptName1);
		  model.addAttribute("aptArea" ,aptResponseAptArea);

		  return "/apt/apt"; 
	  }
	  
		 
	  @GetMapping("/apt/apt5") 
	  public String selectApt5(Model model, @RequestParam(required=false) String aptArea, @RequestParam(required=false) String aptName) {
		  try {
			  System.out.println(aptArea);
			  System.out.println(aptName1);
			  String aptAptPriceResponse = aptService.findAptPrice(aptArea, aptName1); 
			  System.out.println(aptAptPriceResponse);
			  aptAreas = aptArea;
			  aptPrices = aptAptPriceResponse;
			  model.addAttribute("city", cityName);
			  model.addAttribute("gun", gunName); 
			  model.addAttribute("gu", guName); 
			  model.addAttribute("aptName" ,aptName1);
			  model.addAttribute("aptArea" ,aptAreas);
			  model.addAttribute("aptPrice" ,aptAptPriceResponse);
			  model.addAttribute("error" ,"false");

			  System.out.println(model.addAttribute("aptPrice" ,aptAptPriceResponse));
		  }
		  catch (Exception e) {
			  System.out.println("에러메세지:" + e.getMessage());
			  model.addAttribute("error" ,"true");
			  e.printStackTrace(); 
			  return "/apt/apt";
			  
			  
		  }
		  return "/apt/apt"; 
	  }

}
