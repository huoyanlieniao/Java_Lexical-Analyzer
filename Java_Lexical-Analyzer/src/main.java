import Mod.*;

import java.io.*;
import java.util.ArrayList;

public class main {



    public static void main(String[] args) throws IOException {

         Mod.identifier identifier = new identifier();
         Mod.constant constant = new constant();
         Mod.delimiters delimiters = new delimiters();
         Mod.keyWords keyWords = new keyWords();
         Mod.operator operator = new operator();

         File file = new File("C:\\Users\\huoya\\IdeaProjects\\untitled\\src\\text");
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        reader = new BufferedReader(new FileReader(file));
        String tempStr;
        while ((tempStr = reader.readLine()) != null) {
            sbf.append(tempStr);
        }
        
        String[] str = sbf.toString().split(" ");
        int[] num = new int[str.length];

        ArrayList<String> str1 = new ArrayList<>();
        ArrayList<Integer> num1 = new ArrayList<Integer>();

        for (int i = 0; i < str.length; i++) {
            if (identifier.isType(str[i])) {
               num[i]= identifier.getType();
            } else if (constant.isType(str[i])) {
                num[i]= constant.getType();
            } else if (keyWords.isType(str[i])) {
                num[i]= keyWords.getType();
            } else if (operator.isType(str[i])) {
                num[i]= operator.getType();
            } else if (delimiters.isType(str[i])) {
                num[i]= delimiters.getType();
            }
            else {
                num[i]= 0;
            }
        }

        for(int i=0;i<str.length;i++){
            if(str[i].equals("")){

            }else{
                if(num[i]!=0){
                    str1.add(str[i]);
                    num1.add(num[i]);
                }else if(str[i].length()==1){
                    //如果是未识别的
                    //如果长度为1，判断是否为英文字符，如果是英文字符则放入identifier如果是标点符号则放入界符中
                    if(constant.isType(str[i])){
                        num[i]=constant.getType();
                        str1.add(str[i]);
                        num1.add(num[i]);
                    }else if(isEn(str[i])){
                        num[i]=identifier.getType();
                        identifier.addWord(str[i]);
                        str1.add(str[i]);
                        num1.add(num[i]);
                    }else if(operator.isType(str[i])){
                        num[i]=operator.getType();
                        str1.add(str[i]);
                        num1.add(num[i]);
                    }else if(delimiters.isType(str[i])){
                        num[i]=delimiters.getType();
                        str1.add(str[i]);
                        num1.add(num[i]);
                    }else{//什么都不是则设为6，非法字符
                        num[i]=6;
                        str1.add(str[i]);
                        num1.add(num[i]);
                    }

                }else{
                    //长度不为1,字符串切割
                    String[] strings=str[i].split("");
                    for(int j=0;j<strings.length;j++){

                        //如果是未识别的
                        if(constant.isType(strings[j])){//判断数字，如果是数字则一直判断知道不是数字或者字符串结束
                            String s="";
                            while (j<strings.length&&constant.isType(strings[j])){
                                s=s+strings[j];
                                j++;
                            }
                            j--;
                            str1.add(s);
                            num1.add(2);


                        }else if(isEn(strings[j])){
                            //ss,s0,s0s
                            String s="";
                            while ((isEn(strings[j])||constant.isType(strings[j]))&&j<strings.length){
                                s=s+strings[j];
                                j++;
                            }
                            //这里最后一次多加了一次，所以需要减少一次
                            j--;
                            str1.add(s);
                            num1.add(1);
                            identifier.addWord(s);
                        }else if(operator.isType(strings[j])){
                            String s="";
                            if((strings[j+1]!=null)&&(operator.isType(strings[j+1]))){
                                //如果下一个也是运算符则视为一个
                                s=s+strings[j]+strings[j+1];
                                str1.add(s);
                                num1.add(4);
                                j++;
                            }else{
                                //将本身添加进去
                                str1.add(strings[j]);
                                num1.add(4);
                            }

                        }else if(delimiters.isType(strings[j])){
                            //分界符则
                            str1.add(strings[j]);
                            num1.add(delimiters.getType());
                        }else{//什么都不是则设为6，非法字符

                            str1.add(strings[j]);
                            num1.add(6);
                        }


                    }
            }



            }
        }


        //输出
        for(int i=0;i<str1.size();i++){
            //只有用户自定义的才输出编号
            if(num1.get(i)==1){
                System.out.println("(1，"+identifier.getWord(str1.get(i))+")");
            }else if(num1.get(i)==2){
                System.out.println("(2，"+str1.get(i)+")");
            }else if(num1.get(i)==3){
                System.out.println("(3，"+str1.get(i)+")");
            }else if(num1.get(i)==4){
                System.out.println("(4，"+str1.get(i)+")");
            }else if(num1.get(i)==5){
                System.out.println("(5，"+str1.get(i)+")");
            }else if(num1.get(i)==6){
                System.out.println("(6，"+str1.get(i)+")");
            }
        }

    }

    private static boolean isEn(String s) {
       if(!s.equals("")){
           char[] ch=s.toCharArray();
           if(Character.isLowerCase(ch[0])||Character.isUpperCase(ch[0])){
               return true;
           }
       }
       return false;

    }




}
