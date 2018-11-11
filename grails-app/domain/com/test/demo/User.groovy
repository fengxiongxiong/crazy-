package com.test.demo

class User {

    String name
    String age
    String sex
    String nickName

    static constraints = {
        name comment: '姓名'
        age comment: '年龄'
        sex comment: '性别'
        nickName comment: '昵称'
    }
}
