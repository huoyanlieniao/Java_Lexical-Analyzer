package Mod;

import javax.lang.model.util.Types;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ProjectName: Java_Lexical-Analyzer
 * @Package: Mod
 * @ClassName: Mod
 * @Author: SUN
 * @Description: father
 * @Date: 2021/4/11 13:34
 * @Version: 1.0
 */
public class Mod {



    public int type;
    public ArrayList<String> arrayList;

    public void addWord(String s){
        if(!arrayList.contains(s)){
            arrayList.add(s);
        }
    }

    public int getWord(String a){
        return arrayList.indexOf(a);
    }

    public  int getType(){
        return type;
    }


    public boolean isType(String s){
        if(arrayList.contains(s)){
            return true;
        }else {
            return false;
        }
    }
}
