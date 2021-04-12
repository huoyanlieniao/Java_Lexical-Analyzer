package Tool;

import Mod.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class tool {

    private static identifier identifier = new identifier();
    private static constant constant = new constant();
    private static delimiters delimiters = new delimiters();
    private static keyWords keyWords = new keyWords();
    private static operator operator = new operator();
    
    
    /**
     * @Description: 获取文件内容
     * @Param: [filePath]
     * @return: java.lang.String
     * @Author: sun
     * @Date: 2021/4/11
     **/
    public static String getText(String filePath) throws IOException {

        File file = new File(filePath);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        reader = new BufferedReader(new FileReader(file));
        String tempStr;
        while ((tempStr = reader.readLine()) != null) {
            sbf.append(tempStr);
        }

        return String.valueOf(sbf);
    }

    /**
     * Description  判断英文字符
     * @param str
     * @return boolean
     * @author sun
     * @date 2021/4/12 13:22
     */
    public static boolean isEn(String str) {
        if(!str.equals("")){
            char[] ch=str.toCharArray();
            if(Character.isLowerCase(ch[0])||Character.isUpperCase(ch[0])){
                return true;
            }
        }
        return false;

    }


/**
 * Description isType封装；
 * identifier 1
 * constant 2
 * keyword 3
 * operator 4
 * delimiters 5
 * engilsh 6
 * @param str
 * @return int
 * @author sun
 * @date 2021/4/11 21:06
 */
    public static int isType(String str) {
        int result;

        if (identifier.isType(str)) {
            result = identifier.getType();
        } else if (constant.isType(str)) {
            result = constant.getType();
        } else if (keyWords.isType(str)) {
            result = keyWords.getType();
        } else if (operator.isType(str)) {
            result = operator.getType();
        } else if (delimiters.isType(str)) {
            result = delimiters.getType();
        } else if (str.length() == 1 && isEn(str)) {
            result = 6;
        } else {
            //不属于所有的则设为0
            result = 0;
        }

        return result;
    }


}
