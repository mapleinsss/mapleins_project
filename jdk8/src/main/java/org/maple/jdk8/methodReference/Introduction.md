# 方法引用 method reference
    方法引用是 lambda 表达式的一种语法糖
    
### 可以将方法引用看做是一个【函数指针】，function pointer

## 方法引用共分为4类：
1.类名::静态方法名
2.引用名(对象名)::实例方法名
3.类名::实例方法名 第一个参数是调用者，后面的参数都是传入者
4.构造方法引用: 类名::new