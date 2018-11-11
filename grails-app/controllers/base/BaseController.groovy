package base

import grails.rest.RestfulController

class BaseController extends RestfulController{



    BaseController(){
        super(BaseController)
    }

    /**
     * Description: 获取参数
     * @param
     * @return
     * @throws
     * @see
     * @Note:
     */
    def getParameter(){
        def requestData=request.JSON
        def paramData=params
        if(requestData){
            paramData.putAll(requestData)
        }
        return paramData
    }

    /**
     * 返回数据
     * @param result true:成功，false:失败
     * @param data 业务数据
     * @param errcode 状态码：失败或异常时返回状态码
     * @param msg 消息
     * @return
     */
    def static jsonData(boolean result, def data, def errcode, def msg) {
        def json = [result: result]
        json.data = !data ? '' : data
        json.errcode = !errcode ? '' : errcode
        json.msg = !msg ? '操作成功！' : msg
        return json
    }


    /**
     * 返回数据
     * @param result true:成功，false:失败
     * @return
     */
    def static jsonData(boolean result) {
        def json = jsonData(result,null,null,null)
        return json
    }


}
