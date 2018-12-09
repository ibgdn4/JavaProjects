package com.springbootwx.sell.VO;

import lombok.Data;

/**
 * http 请求返回的最外层对象
 */
@Data
public class ResultVO<T> {
    /*"code": 0,
    "msg": "成功",
    "data": [
        {
            "name": "热榜",
            "type": 1,
            "foods": [
                {
                    "id": "123456",
                    "name": "皮蛋粥",
                    "price": 1.2,
                    "description": "好吃的皮蛋粥",
                    "icon": "http://xxx.com",
                }
            ]
        },...
    */
    // 状态码 0：成功
    private Integer code;
    // 提示信息
    private String msg;
    //
    private T data;

}
