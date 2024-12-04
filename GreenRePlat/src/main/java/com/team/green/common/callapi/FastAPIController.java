package com.team.green.common.callapi;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FastAPIController {

    private final FastApiService fastApiService;

    @Autowired
    public FastAPIController(FastApiService fastApiService) {
        this.fastApiService = fastApiService;
    }

    // 클라이언트가 /get-products 경로로 요청을 보낼 때 FastAPI 서버에 POST 요청을 보냄
    @PostMapping("/getProducts")
    public String getProducts(@RequestParam String memId) {
    	String answ = fastApiService.postProductsList(memId);
    	System.out.println();
    	System.out.println(answ);
        return fastApiService.postProductsList(memId);
    }

}
