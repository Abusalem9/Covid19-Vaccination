package com.covid.vaccination.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class WelcomePageController {
    @GetMapping("/")
    @ApiOperation(value = "This method is used to show Home page.", hidden = true)
    public String welcome(){
        return "<body style=\"color: #fff; font-family:\">\n" +
                "    <h1 style=\"text-align:center;padding-top:50px;color: black;font-weight:bold;font-family: 'Courier New', Courier, monospace; \" >Welcome To Our Covid-19 Vaccination Rest Api.<h1></h1>\n" +
                "    <img style=\"height: 400px; padding-left: 250px;\" src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNcj9X6cYTFHgEDINJ7-OWMZliLEMTDpz5qg&usqp=CAU\"\" alt=\"\">\n" +
                "</body>";
    }
}
