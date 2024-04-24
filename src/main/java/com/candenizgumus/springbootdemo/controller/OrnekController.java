package com.candenizgumus.springbootdemo.controller;


import com.candenizgumus.springbootdemo.entity.Auth;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrnekController
{

    @RequestMapping(value = "/selam",method = RequestMethod.GET)
    public String selamVer(){
        return "Selam";
    }


    @GetMapping("selam2")
    public String selamVer2(){
        return "Selam2";
    }

    @RequestMapping(value = "/selam3",method = RequestMethod.POST)
    public String selamVer3(){
        return "Selam3";
    }

    @PostMapping("/selam4")
    public String selamVer4(){
        return "Selam4";
    }

    @GetMapping("selam5")
    public String selamVer5(String ad){
        return "Selam5" + ad;
    }

    @GetMapping("selam6")
    public String selamVer6(@RequestParam(defaultValue = "Misafir") String ad){
        return "Selam6" + ad;
    }


    @GetMapping("selam/{selamID}")
    public String selamVer7(@PathVariable Long selamID){
        return "Selam PathVariable " + selamID;
    }


    @PostMapping("/selamVer8")
    public String selamVer8(@RequestBody Auth auth){
        return "Selam PostMapping! " + auth.getUsername();
    }

    @GetMapping("/selamVer9")
    public ResponseEntity<String> selamVer9(){
        String mesaj = "Selam";
        HttpHeaders headers = new HttpHeaders();
        headers.add("key","value");
        headers.add("username","deniz123");
        return new ResponseEntity<>(mesaj,headers, HttpStatus.OK);
    }


    @GetMapping("/selamVer10")
    public ResponseEntity<String> selamVer10(){
        return ResponseEntity.ok("Selam ok!");
    }

    @GetMapping("/selamVer11")
    public ResponseEntity<Auth> selamVer11(){
        Auth a = Auth.builder().password("1234").username("deniz").build();
        return ResponseEntity.ok(a);
    }

    @GetMapping("/selamVer12")
    public ResponseEntity<List<Auth>> selamVer12(){
        List<Auth> liste = new ArrayList<>();
        Auth a = Auth.builder().password("1234").username("deniz").build();
        Auth a1 = Auth.builder().password("1234").username("Kaan").build();
        Auth a2 = Auth.builder().password("1234").username("Akin").build();
        liste.addAll(List.of(a,a1,a2));
        return ResponseEntity.ok(liste);
    }

}
