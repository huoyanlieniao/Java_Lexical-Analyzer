# Java_Lexical-Analyzer
java词法分析器，大作业



## 程序设计思路

大体三个部分：基础字符、识别转化、出错管理

  

-   基础字符


接口：识别字符、添加字符、删除字符、得到字符、添加字符种类、字符编号（符号为自身编号）

  - 识别转化

     转为二维列表进行字符识别添加字符标识符

     逻辑拼接

  - 出错管理

     识别非法字符，逻辑识别



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







​       

​       

​     