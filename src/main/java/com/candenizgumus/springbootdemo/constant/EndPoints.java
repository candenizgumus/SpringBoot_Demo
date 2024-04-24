package com.candenizgumus.springbootdemo.constant;

public class EndPoints
{

    public static final String VERSION = "/v1";

    //Profiller:
    public static final String API = "/api";
    public static final String DEV = "/dev";
    public static final String TEST = "/test";

    public static final String ROOT = API+VERSION;

    //Entities:

    public static final String MUSTERI = "/musteri";
    public static final String AUTH = "/auth";
    public static final String URUN = "/urun";
    public static final String SATIS = "/satis";

    //Methods:

    public static final String SAVE = "/save";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";
    public static final String FINDALL = "/findall";
    public static final String FINDBYID = "/findbyid";
    public static final String FINDALLDTO = "/findalldto";
    public static final String FINDALLORDERBYFIYAT = "/findallorderbyfiyat";

}
