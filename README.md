### 概述

知识逃逸：某个知识没有被有效的控制在特定的范围内，导致所有人都需要掌握该知识，导致没有权威能站出来定义该知识。知识逃逸问题是编程中一个重要又普遍存在的问题。

使用redis时，该项目可以用来解决key的知识逃逸问题。当我们的多个项目共享同一个redis实例时，所有数据被同时暴露给了所有项目，这对于开发人员来说可能是方便的，但对于项目管理人员来说，它可能导致僵尸key的产生。

本项目通过将key设置为某种模板形式，来控制客户端程序员对redis中存储数据的使用。

### 示例

- :[项目名称]:[读权限]:[写权限]:[key]

    注意有前置“:”
    
- :[读权限]:[写权限]:[key]

    本项目key
    
- :::key 

    公有数据，不分项目，会被组装成 forAll:[key]
    
- key

    给一个不以“:”打头的字符串，相当于声明了一个纯粹的key，代理将会将它补充项目名，并打开读写标识，[项目名称]\:o\:o:[key]