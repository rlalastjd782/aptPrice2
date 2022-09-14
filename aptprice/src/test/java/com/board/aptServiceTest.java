package com.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.board.aptboard.AptResponse;
import com.board.aptboard.AptService;

public class aptServiceTest {
    @Autowired
    AptService aptService;
    
    @Test
    List<AptResponse> findCity() {
    	return aptService.findCityList();
    }
}
