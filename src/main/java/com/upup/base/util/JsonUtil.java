package com.upup.base.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    public static String toJsonString(Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
