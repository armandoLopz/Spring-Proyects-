package com.springweb.springbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springweb.springbootweb.models.dto.ParamDto;
import com.springweb.springbootweb.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false) String message) {

        ParamDto param = new ParamDto();
        param.setMessage(message != null? message: "unsent message");
        return param;
    }

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code) {
        
        ParamMixDto paramsmix = new ParamMixDto();

        paramsmix.setMessage(text);
        paramsmix.setCode(code);
        
        return paramsmix ;
    }

    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request) {
        
        ParamMixDto params = new ParamMixDto();

        params.setCode(Integer.parseInt(request.getParameter("code")));
        params.setMessage(request.getParameter("message"));
        
        return params;
    }
    
    
    
}
