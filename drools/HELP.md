* 规则文件，就是我们新建的这个HelloWord.drl可以理解为一个Java类
* package，这个跟Java中的包名是差不多的
* import，此文件中需要的类。
* rule，可以理解为给这个规则起的一个名字，一个规则文件中可以包含多个rule。
* when，when下面可以放置一些条件判断的表达式以及定义一些变量什么的。如果里面内容为空的话则会默认添加一个eval(true)代表一个为true的表达式
* then，当when下面的表达式为true是then下方的代码才会执行，在这里可以直接编写Java代码（代码所需要的类通过import引入），当然也可以使用when模块定义的一些变量
* end 代表规则hello,word的结束
