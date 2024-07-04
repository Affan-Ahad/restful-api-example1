package com.restful.api.restful_example1.controller;

import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/myapi")
public class MyController {

    @GetMapping
    public String getData() {
        return "Hello World";
    }

    @GetMapping("/{name}")
    public String addGoodMorningName(@PathVariable String name) {
        return "Good Morning "+name;
    }

    @PostMapping("/{name}")
    public String addName(@PathVariable String name) {
        return "Hello "+name;
    }

    @GetMapping("/email")
    public ResponseEntity<Boolean> addEmail(@RequestParam String email) {
        boolean isEmail = email.contains("@") && email.contains(".");
        if(isEmail==false) {
            return new ResponseEntity<>(false, HttpStatus.NOT_ACCEPTABLE);
        } else {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
    }

    @PostMapping("/country")
    public ResponseEntity<String> addCountry(@RequestBody CountryInfo country) {
        if("india".equalsIgnoreCase(country.getCountry())){
            return new ResponseEntity<>(country.getCountry() +" is a great country", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(country.getCountry() +" is a good country", HttpStatus.ACCEPTED);
        }
    }

    @PostMapping("/registration")
    public ResponseEntity<String> addCountry(@RequestBody UserRegistration userRegistration) {
        if("india".equalsIgnoreCase(userRegistration.getCountry())){
            return new ResponseEntity<>(userRegistration.getCountry() +" User is from India", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(userRegistration.getCountry() +" User is out from india", HttpStatus.ACCEPTED);
        }
    }

    @PutMapping("/update/{monthValue}")
    public ResponseEntity<String> updateMonth(@PathVariable Integer monthValue) {
        String monthName = null;
        switch (monthValue) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
            default:
                throw new RuntimeException("Invalid Month Value");
        }
        return new ResponseEntity<>(monthName, HttpStatus.OK);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFirstCharacter(@RequestParam String input) {
        String response = input.substring(1);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
