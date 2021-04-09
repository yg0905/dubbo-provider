package com.sxkj.config;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回结果对象
 *
 * @author
 */
@Data
public class JsonResult implements Serializable {
    
    private static final long serialVersionUID = 1L;

    /**
     * html start
     */
    public static final String HTML_START = "<!DOCTYPE html><html><head lang=en'><meta charset='UTF-8'>"+
            "<meta content='width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no' name='viewport' />"+
            "<style type='text/css'>body,html,p,section,img,h1,h2,h3,div {margin: 0 !important;padding: 0 !important;}"+
            "img {max-width: 100% !important; width: 100% !important; height: auto;}p > span {line-height:35px;}"+
            "p {display:block;overflow:hidden;margin:5px;}</style></head><body>";

    /**
     * html end
     */
    public static final String HTML_END = "</body></html>";

    public enum Code {

        SUCCESS(200, "成功"),
        FAIL(500, "操作失败"),
        EXCEPTION(400, "系统繁忙,请稍后再试"),
        AUTH_ERROR(403, "没有访问权限"),
        NO_FOUND_ERROR(404, "请求路径不存在"),
        METHOD_ERROR(405, "请求方法错误"),
        PARAMETER_ERROR(501, "参数错误"),
        LOGIN_ERROR(502, "未登录"),
        LOGIN_EXPIRED(503, "未登录"),
        PAY_PASSWORD_NOT_SET(601, "支付密码未设置");

        private int code;
        private String desc;

        public int getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }

        Code(int code, String desc){
            this.code = code;
            this.desc = desc;
        }
    }

    private int code = Code.SUCCESS.getCode();
    private String msg;
    private Object data;

    public JsonResult(){}

    JsonResult(int code, String msg){
        setCode(code);
        setMsg(msg);
        setData(null);
    }

    JsonResult(int code, String msg, Object data){
        setCode(code);
        setMsg(msg);
        setData(data);
    }

    public static JsonResult success(){
        return new JsonResult(Code.SUCCESS.getCode(), Code.SUCCESS.getDesc());
    }

    /*public static JsonResult success(String msg){
        return new JsonResult(JsonResult.Code.SUCCESS.getCode(), msg);
    }
*/
    public static JsonResult success(Object data){
        return new JsonResult(Code.SUCCESS.getCode(), Code.SUCCESS.getDesc(), data);
    }

    public static JsonResult success(String msg, Object data){
        return new JsonResult(Code.SUCCESS.getCode(), msg, data);
    }

    public static JsonResult success(int code, String msg, Object data){
        return new JsonResult(code, msg, data);
    }

    public static JsonResult fail() {
        return new JsonResult(Code.FAIL.getCode(), Code.FAIL.getDesc());
    }

    public static JsonResult fail(String msg) {
        return new JsonResult(Code.FAIL.getCode(), msg);
    }

    public static JsonResult fail(int code, String msg) {
        return new JsonResult(code, msg);
    }

    public static JsonResult exception() {
        return new JsonResult(Code.EXCEPTION.getCode(), Code.EXCEPTION.getDesc());
    }

    public static JsonResult exception(String msg) {
        return new JsonResult(Code.EXCEPTION.getCode(), msg);
    }

    public static JsonResult exception(int code, String msg) {
        return new JsonResult(code, msg);
    }

    public static JsonResult exception(Exception ex) {
        return new JsonResult(Code.EXCEPTION.getCode(), Code.EXCEPTION.getDesc(), ex.getMessage());
    }

    public static JsonResult parameterError() {
        return new JsonResult(Code.PARAMETER_ERROR.getCode(), Code.PARAMETER_ERROR.getDesc());
    }

    public static JsonResult parameterError(String msg) {
        return new JsonResult(Code.PARAMETER_ERROR.getCode(), msg);
    }

    public static JsonResult loginError() {
        return new JsonResult(Code.LOGIN_ERROR.getCode(), Code.LOGIN_ERROR.getDesc());
    }

    public static JsonResult loginError(String msg) {
        return new JsonResult(Code.LOGIN_ERROR.getCode(), msg);
    }

    public static JsonResult error(int code, String msg) {
        return new JsonResult(code, msg);
    }
}