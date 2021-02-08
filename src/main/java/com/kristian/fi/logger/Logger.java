package com.kristian.fi.logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// This class serves to log the messages to terminal/console.
public class Logger {

    private static Logger instance = null;

    private Logger(){

    }

    public static Logger getInstance(){
        if(instance == null){
            instance =new Logger();
        }
        return instance;
    }

    public static void  log(String message){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date) + " : " + message); //2016/11/16 12:08:43
    }

}
