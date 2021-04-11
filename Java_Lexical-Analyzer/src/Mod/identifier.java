package Mod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class identifier {
     public int type=1;
     public ArrayList<String> arrayList=new ArrayList<>();

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
