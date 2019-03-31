package com.lvyl.lotterydisplay.utils;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Utils {

    public String objectToJson(Object object){
        return "("+a(object)+")";
    }

    public StringBuffer a(Object obj){
        if(null==obj)
            return new StringBuffer("\"{null}\"");
        StringBuffer result = new StringBuffer();
        if(obj instanceof List){
            result.append("[");
            List list = (List) obj;
            for(int i=0;i<list.size();i++){
                Object obj01=list.get(i);
                if(obj01 instanceof List||obj01 instanceof Map){
                    if(i==list.size()-1){
                        result.append(a(obj01));
                    }else{
                        result.append(a(obj01)+",");
                    }
                }else{
                    if(i==list.size()-1){
                        result.append("\""+obj01.toString()+"\"");
                    }else{
                        result.append("\""+obj01.toString()+"\",");
                    }
                }
            }
            return result.append("]");
        }else if(obj instanceof Map){
            result.append("{");
            Map map = (Map) obj;
            Set set = map.keySet();
            int setIndex = 0;
            for (Object obj01:set) {
                setIndex++;
                if(map.get(obj01) instanceof List||map.get(obj01) instanceof Map){
                    if(setIndex==set.size()){
                        result.append("\""+obj01.toString()+"\":"+a(map.get(obj01)));
                    }else{
                        result.append("\""+obj01.toString()+"\":"+a(map.get(obj01))+",");
                    }
                }else{
                    if(setIndex==set.size()){
                        result.append("\""+obj01.toString()+"\":\""+map.get(obj01)+"\"");
                    }else{
                        result.append("\""+obj01.toString()+"\":\""+map.get(obj01)+"\",");
                    }
                }
            }
            return result.append("}");
        }else{
            return result.append("{"+obj.toString()+"}");
        }
    }
}
