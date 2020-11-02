package com.winism.winism.controller.search;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.winism.winism.dao.search.SearchDAO;
import com.winism.winism.model.wine.wineList;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@CrossOrigin(origins = { "*" })
@RestController
public class SearchController {

	@Autowired
	SearchDAO searchDao;

	@GetMapping("/search")
    @ApiOperation(value = "게시글 리스트 불러오기")
    public Object listWine(
        @RequestParam(required = false)final String page
    )throws IOException {
        //pagination
		int pageInt=0;
		if(page != null){
			pageInt = Integer.parseInt(page);
        }
        
		Pageable pageable = PageRequest.of(pageInt,10);
        Page<wineList> list = searchDao.findAll(pageable);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }



}