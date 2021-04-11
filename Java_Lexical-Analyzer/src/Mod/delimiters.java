package Mod;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;

@Data
public class delimiters {
    public int type=5;
    public ArrayList<String> arrayList=new ArrayList<>(Arrays.asList(";",","));

    public void addWord(String s){
        if(!arrayList.contains(s)){
            arrayList.add(s);
        }
    }

    public boolean isType(String s){
        if(arrayList.contains(s)){
            return true;
        }else {
            return false;
        }
    }

    public int getWord(String s){
        return arrayList.indexOf(s);
    }

}
