package grailsdemo

import base.BaseController
import grails.converters.JSON

class UserController extends BaseController{

    def userService

    def index() {
        render userService.listUser() as JSON
    }


    def findUserByName(){
        def result = jsonData(true)
        try {
            def param = getParameter()
            def users = userService.findUserByName(param)
            if(!users.result){
                result.result = false
                result.msg = '操作失败！'
                render result as JSON
                return
            }
            result.data = users.data
        }catch (Exception e){
            e.printStackTrace()
            result.result = false
            result.msg = '操作失败！'
        }
        render result as JSON
    }
}

