# 读取文件和写入文件的方式

`UpdateTime: 20181224`

> - [读取文件和写入文件的方式](#读取文件和写入文件的方式)
>     - [说明](#说明)
>     - [文件操作: 根据处理数据类型分类](#文件操作: 根据处理数据类型分类)
>         - [1 字节流](#1-字节流)
>             - [1.1 文件字节流](#11-文件字节流)
>                 - [1.1.1 FileWriter](#111-filewriter)
>             - [1.2 缓存字节流](#12-缓存字节流)
>         - [2 字符流](#2-字符流)
>     - [扩展](#扩展)

## 说明

在Java类库中，IO部分的内容是很庞大的，涉及的领域包括: 标准输入输出，文件操作，网络上的数据流，字符串流，对象流，zip文件流。

Java把不同来源和目标的数据都统一抽象为数据流。

Java中的流的分类可以根据以下维度进行分类：

1. 根据处理数据类型分类

   * 字符流
   * 字节流
1. 根据数据流向不同分类

   * 输入流
   * 输出流
1. 根据数据来源（去向）分类
   * 1、File（文件）： FileInputStream, FileOutputStream, FileReader, FileWriter 
   * 2、byte[]：ByteArrayInputStream, ByteArrayOutputStream
   * 3、Char[]: CharArrayReader,CharArrayWriter
   * 4、String: StringBufferInputStream, StringReader, StringWriter
   * 5、网络数据流：InputStream, OutputStream, Reader, Writer 

## 文件操作: 根据处理数据类型分类

  * 字节流：数据流中最小的数据单元是字节
      * 文件字节流
        * InputStream/OutputStream
        * FileInputStream/FileOutputStream
      * 缓存字节流
        * BufferedInputStream/BufferedOutputStream

* 字符流：数据流中最小的数据单元是字符， Java中的字符是Unicode编码，一个字符占用两个字节。

> * 参考: [JAVA 字节流和字符流度读写的区别](https://www.cnblogs.com/jun9207/p/5197697.html)
>
> Java处理文件的类里面，stream结尾都是采用字节流，reader和writer结尾都是采用字符流。两者的区别就是读写的时候一个是按字节读写，一个是按字符。 
>
> 字符流的底层就是字节流。而字符流主要是读取文本文件内容的，可以一个字符一个字符的读取，也可以一行一行的读取文本文件内容。而字节流读取单位为byte.byte作为计算机存储最基本单位，可以用字节流来读取很多其他格式的文件，比如图片视频等等。基于B/S和C/S的[文件传输](https://www.baidu.com/s?wd=%E6%96%87%E4%BB%B6%E4%BC%A0%E8%BE%93&tn=44039180_cpr&fenlei=mv6quAkxTZn0IZRqIHckPjm4nH00T1YznW9hPjmLuW-BPWuWPW00IAYqnWm3PW64rj0d0AP8IA3qPjfsn1bkrjKxmLKz0ZNzUjdCIZwsrBtEXh9GuA7EQhF9pywdQhPEUiqkIyN1IA-EUBtdn10LPWD3P10)都可以采用字节流的形式。在读写文件需要对内容按行处理，比如比较特定字符，处理某一行数据的时候一般会选择字符流。只是读写文件，和文件内容无关的，一般选择字节流。 (注：除了字符和字节流之外，java还有一种叫对象流。有兴趣可以去查API学习一下。)
>
> 字节流就是按照字节来进行传输,字符流是按照字符来传输.最基本的是字节流,字符流可以说是对字节流的一个包装流.比如你知道了一个字符是8个字节,那么你让字节流一次传输8个字节,那不就相当于一次传输一个字符,也就是字符流了。
>
> 字节流与和字符流的使用非常相似，两者除了操作代码上的不同之外，是否还有其他的不同呢？
> 实际上字节流在操作时本身不会用到缓冲区（内存），是文件本身直接操作的，而字符流在操作时使用了缓冲区，通过缓冲区再操作文件，如图
>
> ![img](https://images2015.cnblogs.com/blog/504580/201602/504580-20160218113616988-966099438.jpg)
>
> 下面以两个写文件的操作为主进行比较，但是在操作时字节流和字符流的操作完成之后都不关闭输出流。

### 1 字节流

* 复制文件的原理
  * 文件字节流：读取一个个字节(或者字节数组)，然后再写入文件中去。
  * 缓冲字节流：读取一个个字节(或者字节数组)放到缓冲字节数组中，等到缓冲字节数组读满后，再把这几次读取到的字节一并写到文件中去。这样使用缓冲字节流，就能**少写几次文件，进而节省时间**。

#### 1.1 文件字节流

##### 1.1.1 FileInputStream/FileOutputStream

> [java以字节流形式读写文件](https://blog.csdn.net/l527719041/article/details/77461196)
>
> [Java精选笔记_IO流(字节流、InputStream、OutputStream、字节文件、缓冲区输入输出流)](https://www.cnblogs.com/justdoitba/p/7582140.html)

#### 1.2 缓存字节流

##### 1.2.1


### 2 字符流

**字符流的由来：** Java中字符是采用Unicode标准，一个字符是16位，即一个字符使用两个字节来表示。为此，JAVA中引入了处理字符的流。因为数据编码的不同，而有了对字符进行高效操作的流对象。本质其实就是基于字节流读取时，去查了指定的码表。

#### 2.1 文件字符流
##### 2.1.1 FileWriter

FileWriter: 字符流写入字符到文件。

默认情况下，FileWriter会使用新的内容取代所有现有的内容。然而，当指定一个true （布尔）值作为FileWriter构造函数的第二个参数，它会保留现有的内容，并追加新内容在文件的末尾。

1.替换所有现有的内容与新的内容。

```java
new FileWriter(file); 
```

2.保留现有的内容和附加在该文件的末尾的新内容。

```java
new FileWriter(file, true);
```

3.实例

```java
/**
 * Copyright (c) 2018 jiuchou. All rights reserved worldwise.
 */
package com.jiuchou.demo.file_jiuchou;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWrite {
    public static void saveFile(String filename, String content) {
        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "D:\\jiuchou_ReadAndWrite";
        String content = "test";
        saveFile(filename, content);
    }
}
```

## 扩展
* [java读取文件和写入文件的方式](https://www.cnblogs.com/fnlingnzb-learner/p/6011324.html)
* [java.io几种读写文件的方式](https://www.cnblogs.com/xiaoliu66007/p/9067883.html)
* [java写入文件的几种方法分享](https://www.cnblogs.com/x_wukong/p/4679116.html)
* [JavaIO 使用缓冲字节流和文件字节流拷贝文件](https://blog.csdn.net/qq_21808961/article/details/80308228)
* [使用字节流及缓存字节流读取、写入和拷贝文件](https://blog.csdn.net/u014465934/article/details/79376090)
* [深入理解Java中的IO](https://blog.csdn.net/qq_25184739/article/details/51205186)
* [Java IO 经典教程 (上) (翻译自jenkov.com)](https://blog.csdn.net/I_AM_KOP/article/details/78513802)
* [java IO 字节流、字节流读写文件、字节流缓冲区、文件拷贝、装饰设计模式](https://blog.csdn.net/yPassion/article/details/78917330)
* [JAVA使用字节流与高速缓冲字节流复制文件对比](https://blog.csdn.net/ckinghan58/article/details/72170072)
