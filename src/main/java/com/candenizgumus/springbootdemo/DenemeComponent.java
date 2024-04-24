package com.candenizgumus.springbootdemo;


import org.springframework.stereotype.Component;

@Component
public class DenemeComponent
{
    public DenemeComponent()
    {
        System.out.println("Deneme compoennet constructor çalıştı.");
    }

    public void denemeMetod(){
        System.out.println("DenemeComponent içindeki denemeMetod");
    }
}
