package grailsdemo

import com.test.demo.User
import grails.gorm.transactions.Transactional
import groovy.sql.Sql


class UserService {

    def sessionFactory

    @Transactional(readOnly = true)
    def listUser(){
        def users = User.findAll()
        return users
    }


    @Transactional(readOnly = true)
    def findUserByName(def param){
        def result = [result: true]
        if(!param.name){
            return [result: false,msg: '参数有误！']
        }
        def sql = new StringBuffer("""
            select 
            u.name,
            u.age,
            u.sex,
            u.nick_name as nickName
            from user u
            where u.name like '%${param.name}%'
        """)
        def db = new Sql(sessionFactory.currentSession.connection())
        def list = db.rows(sql.toString())
        list?.each{
            user ->
//            it.sexText = it.sex == '0' ? '男' : '女'
            user.sexText = user.sex == '0' ? '男' : '女'
        }

        result.data = list
        return result
    }
}
