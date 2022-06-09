package com.utils.msgutils;

import net.sf.json.JSONObject;

/**
 * @ClassName Msg
 * @Description TODO
 * @Author thunderBoy
 * @Date 2019/11/7 14:32
 */
public class MsgUtil {

    public static final int SUCCESS = 0;
    public static final int ERROR = -1;
    public static final int LOGIN_USER_ERROR = -100;
    public static final int NOT_LOGGED_IN_ERROR = -101;
    public static final int Ban = -401;

    public static final String SUCCESS_MSG = "Success!";
    public static final String LOGIN_SUCCESS_MSG = "Login Success!";
    public static final String LOGOUT_SUCCESS_MSG = "Logout Success!";
    public static final String LOGOUT_ERR_MSG = "Logout Error!";
    public static final String ERROR_MSG = "Error!";
    public static final String LOGIN_USER_ERROR_MSG = "The user name or password is incorrect. Please enter it again！";
    public static final String NOT_LOGGED_IN_ERROR_MSG = "Login invalid, please log in again!";
    public static final String Ban_MSG = "The user has been banned!";



    public static Msg makeMsg(MsgCode code, JSONObject data){
        return new Msg(code, data);
    }

    public static Msg makeMsg(MsgCode code, String msg, JSONObject data){
        return new Msg(code, msg, data);
    }

    public static Msg makeMsg(MsgCode code){
        return new Msg(code);
    }

    public static Msg makeMsg(MsgCode code, String msg){
        return new Msg(code, msg);
    }

    public static Msg makeMsg(int status, String msg, JSONObject data){
        return new Msg(status, msg, data);
    }

    public static Msg makeMsg(int status, String msg){
        return new Msg(status, msg);
    }
}
