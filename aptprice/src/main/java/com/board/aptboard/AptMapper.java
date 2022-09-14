package com.board.aptboard;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AptMapper {
	
	/* 시 리스트 */
	List<AptResponse> findCity();
	
	

	/* 군 리스트 */
	List<AptResponse> findGun(String city);
	
	/* 구 리스트 */
	List<AptResponse> findGu(String gun);
	
	/* 아파트 리스트 */
	List<AptResponse> findAptName(String gu);
	
	/* 평수 리스트 */
	List<AptResponse> findAptArea(String aptName);
	
	/* 아파트 가격 리스트 */
	String findAptPrice(@Param("aptArea") String aptArea, @Param("aptName")String aptName);
	
	
	
}
