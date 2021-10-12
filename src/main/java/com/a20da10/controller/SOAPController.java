package com.a20da10.controller;

import com.a20da10.SOAPJava.Soap;
import com.a20da10.SOAPJava.SoapService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/SOAP")
public class SOAPController {

    @ResponseBody
    @RequestMapping("/GetInsById")
    public String getInsById(){
        SoapService soapService = new SoapService();
        Soap soap = soapService.getSoapPort();
        return soap.getById(1).getEmail();
    }
}
