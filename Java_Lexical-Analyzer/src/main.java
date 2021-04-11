import Mod.*;
import Tool.tool;

import java.io.*;
import java.util.ArrayList;

public class main {
    //第一遍临时保存
    private static int[] num;
    //最终输出
    private static ArrayList<String> str1 = new ArrayList<>();
    private static ArrayList<Integer> num1 = new ArrayList<Integer>();
    //文件读取字符串
    private static String[] str;

    public static void main(String[] args) throws IOException {

         identifier identifier = new identifier();
         constant constant = new constant();
         delimiters delimiters = new delimiters();
         keyWords keyWords = new keyWords();
         operator operator = new operator();

         String filePath="src\\text";
         str = tool.getText(filePath).split(" ");
         num=new int[str.length];

        //第一轮判断
        for (int i = 0; i < str.length; i++) {
            num[i]=tool.isType(str[i]);
        }



        //第二轮处理
        for(int i=0;i<str.length;i++){
            //去空
            if(str[i].equals("")){

            }else{
                if(num[i]!=0){
                    //可以直接识别字符，直接添加
                    add(i);
                }else if(str[i].length()==1){
                    //如果是未识别的,长度为1

                    switch (tool.isType(str[i])){
                        case 2://constant
                            num[i]=constant.getType();
                            add(i);
                            break;
                        case 4://operator
                            num[i]=operator.getType();
                            add(i);
                            break;
                        case 5://delimiters
                            num[i]=operator.getType();
                            add(i);
                            break;
                        case 6://english,将其放入identifier中，同时更改numi
                            num[i]=identifier.getType();
                            identifier.addWord(str[i]);
                            add(i);
                            break;
                        default://什么都不是，设为0，非法字符
                            num[i]=0;
                            add(i);
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


                        }else if(tool.isEn(strings[j])){
                            //ss,s0,s0s
                            String s="";
                            while ((tool.isEn(strings[j])||constant.isType(strings[j]))&&j<strings.length){
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


    /**
    * @Description: 向最终字符串添加
    * @Param: [i]
    * @return: void
    * @Author: sun
    * @Date: 2021/4/11
    */
    public static void add(int i){
        str1.add(str[i]);
        num1.add(num[i]);
    }

    /**
    * @Description: 向最终字符串添加
    * @Param: [str, i]
    * @return: void
    * @Author: sun
    * @Date: 2021/4/11
    */
    public void add(String str,int i){
        str1.add(str);
        num1.add(i);
    }





}