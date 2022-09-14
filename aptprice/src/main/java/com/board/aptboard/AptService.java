package com.board.aptboard;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AptService {
	
	
	private final AptMapper aptMapper;
	
	/* 시 리스트 */
    public List<AptResponse> findCityList() {
        return aptMapper.findCity();
    }
	
	/* 군 리스트 */
    public List<AptResponse> findGunList(String city) {    	
        return aptMapper.findGun(city);
    }
    
    /* 구 리스트 */
    public List<AptResponse> findGuList(String gun) {    	
        return aptMapper.findGu(gun);
    }
    
    /* 아파트 리스트 */
    public List<AptResponse> findAptList(String gu) {    	
        return aptMapper.findAptName(gu);
    }
    
    /* 평수 리스트 */
    public List<AptResponse> findAptAreaList(String aptName) {    	
        return aptMapper.findAptArea(aptName);
    }
    
    /* 평수 리스트 */
    public String findAptPrice(String aptArea,String aptName) {    	
        return aptMapper.findAptPrice(aptArea,aptName);
    }
}
