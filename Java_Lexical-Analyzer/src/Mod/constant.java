package Mod;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;

@Data
public class constant {
    public int type=2;
    public ArrayList<String> arrayList=new ArrayList<String>(Arrays.asList("0","1","2","3","4","5","6","7","8","9"));

    public int getWord(String a){
        return arrayList.indexOf(a);
    }
    public boolean isType(String s){
        if(arrayList.contains(s)){
            return true;
        }else {
            return false;
        }
    }
}
