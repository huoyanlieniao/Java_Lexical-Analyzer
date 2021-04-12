# Java_Lexical-Analyzer
java词法分析器，大作业



## 程序设计思路

大体两个部分：基础字符、识别转化

  

-   基础字符


接口：识别字符、添加字符、得到字符、字符编号（符号为自身编号）

  - 识别转化

     转为二维列表进行字符识别添加字符标识符

     逻辑拼接

     




## 详细设计

 - 标识符设计

​       用户输入动态添加

​       identifier

​       Arraylist[]

​      字符种类：1

+ 常数

​       constant

​       Arraylist[]

​       字符种类：2

- 保留字

  keyWords

  Arraylist[]

  字符种类：3
  
- 运算符

  operator

  Arraylist[]

  字符种类：4

- 界符

  delimiters

  Arraylist[]

  字符种类：5
  
- 非法字符

  字符种类：0

- 英文字符

  字符种类：6

  中间临时使用



### uml图





![](https://github.com/huoyanlieniao/Java_Lexical-Analyzer/blob/main/Java_Lexical-Analyzer/uml/Package%20Mod.png?raw=true)





![](https://github.com/huoyanlieniao/Java_Lexical-Analyzer/blob/main/Java_Lexical-Analyzer/uml/Package%20Tool.png?raw=true)





![](https://github.com/huoyanlieniao/Java_Lexical-Analyzer/blob/main/Java_Lexical-Analyzer/uml/Top-Level%20Package.png?raw=true)

### 不足

部分情况并没有进行处理 ：例如英文字母+分界符  num[],num[i]
