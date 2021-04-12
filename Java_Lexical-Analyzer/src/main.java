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
                    if(num[i]==6){
                        //单独英文字符添加
                        num[i]=identifier.getType();
                        identifier.addWord(str[i]);
                    }
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
                        default://什么都不是，设为0
                            num[i]=0;
                            add(i);
                            break;
                    }
                }else{
                    //长度不为1,字符串切割
                    String[] strings=str[i].split("");
                    for(int j=0;j<strings.length;j++){
                        String ss="";
                        switch (tool.isType(strings[j])){
                            case 2:
                                //判断数字，如果是数字则一直判断直到不是数字
                                while (j<strings.length&&constant.isType(strings[j])){
                                    ss=ss+strings[j];
                                    j++;
                                }
                                j--;
                                add(ss,2);
                                break;
                            case 6:
                                //ss,s0,s0s
                                //如果是英文则判断英文|数字
                                while (j<strings.length&&(tool.isEn(strings[j])||constant.isType(strings[j]))){
                                    ss=ss+strings[j];
                                    j++;
                                }
                                //这里最后一次多加了一次，所以需要减少一次
                                j--;
                                add(ss,1);
                                identifier.addWord(ss);
                                break;
                            case 4:
                                //运算符多判断后面一位
                                if((j+1<strings.length)&&(operator.isType(strings[j+1]))){
                                    //如果下一个也是运算符则视为一个
                                    ss=ss+strings[j]+strings[j+1];
                                    add(ss,4);
                                    j++;
                                }else{
                                    //将本身添加进去
                                    add(strings[j],4);
                                }
                                break;
                            case 5:
                                //分界符则
                                str1.add(strings[j]);
                                num1.add(delimiters.getType());
                                break;
                            default:
                                //默认则设为0
                                add(strings[j],0);
                                break;
                        }
                    }
                }

            }
        }

        //输出
        for(int i=0;i<str1.size();i++){
            switch (num1.get(i)){
                case 1: System.out.println("(1，"+identifier.getWord(str1.get(i))+")");break;
                case 2:   System.out.println("(2，"+str1.get(i)+")");break;
                case 3: System.out.println("(3，"+str1.get(i)+")");break;
                case 4: System.out.println("(4，"+str1.get(i)+")");break;
                case 5: System.out.println("(5，"+str1.get(i)+")");break;
                case 0:   System.out.println("(0，"+str1.get(i)+")");break;
            }

        }

    }


 /**
  * Description str1，num1添加
  * @param i
  * @author sun
  * @date 2021/4/12 13:26
  */
    public static void add(int i){
        str1.add(str[i]);
        num1.add(num[i]);
    }

/**
 * Description str1，num1添加
 * @param str
 * @param i
 * @author sun
 * @date 2021/4/12 13:26
 */
    public static void add(String str, int i){
        str1.add(str);
        num1.add(i);
    }





}
