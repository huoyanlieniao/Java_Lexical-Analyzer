package Mod;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;

@Data
public class keyWords {
    public int type=3;
    public ArrayList<String> arrayList=new ArrayList<>(Arrays.asList("if","then","else","while","do","and"));

    public void addWord(String s){
        if(!arrayList.contains(s)){
            arrayList.add(s);
        }
    }

    public int getWord(String s){
        return arrayList.indexOf(s);
    }

    public boolean isType(String s){
        if(arrayList.contains(s)){
            return true;
        }else {
            return false;
        }
    }
}
