package com.controller;

import com.biboheart.brick.exception.BhException;
import com.constant.Constant;
import com.entity.User;
import com.service.CallCountService;
import com.service.UserService;
import com.utils.CallCount.Add;
import com.utils.msgutils.Msg;

import com.utils.msgutils.MsgCode;
import com.utils.msgutils.MsgUtil;
import com.utils.sessionutils.SessionUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.util.concurrent.*;


@RestController
public class LoginController {


    @Autowired
    private UserService userService;
    @Autowired
    private CallCountService callCountService;

    @ResponseBody
    @RequestMapping("/login")

    public Msg login(@RequestBody JSONObject param) throws BhException {
        String username = param.getString("username");
        String password = param.getString("password");
        float posx = (float) param.getDouble("posx");
        float posy = (float) param.getDouble("posy");
        User auth = userService.checkUser(username, password);
        if(auth != null){
            new Thread(new Add(callCountService)).start();
            JSONObject obj = new JSONObject();
            obj.put(Constant.USER_ID, auth.getUserId());
            obj.put(Constant.USERNAME, auth.getUsername());
            obj.put(Constant.USER_TYPE, auth.getUserType());
            SessionUtil.setSession(obj);

            JSONObject data = JSONObject.fromObject(auth);
            data.remove(Constant.PASSWORD);

            auth.setPosx(posx);
            auth.setPosy(posy);


            auth = userService.save(auth);

            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGIN_SUCCESS_MSG, data);
        }
        else{
            return MsgUtil.makeMsg(MsgCode.LOGIN_USER_ERROR);
        }

    }

    @RequestMapping("/logout")
    public Msg logout(){
        Boolean status = SessionUtil.removeSession();

        if(status){
            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGOUT_SUCCESS_MSG);
        }
        return MsgUtil.makeMsg(MsgCode.ERROR, MsgUtil.LOGOUT_ERR_MSG);
    }

    /**
     * @Description: getSession
     * @Param: null
     * @return: Msg
     * @Author: thunderBoy
     */
    @RequestMapping("/checkSession")
    public Msg checkSession(){
        JSONObject auth = SessionUtil.getAuth();

        if(auth == null){
            return MsgUtil.makeMsg(MsgCode.NOT_LOGGED_IN_ERROR);
        }
        else{
            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGIN_SUCCESS_MSG, auth);
        }
    }


    @ResponseBody
    @RequestMapping("/register")
    public boolean exist(@RequestBody JSONObject param){
        String username = param.getString("username");
        String password = param.getString("password");
        User userAuth=userService.exist(username);
        if(userAuth==null) {
            userService.register(username,password);
            return true;
        }
        else return false;
    }
    @RequestMapping("/getCallNum")
    public int getNum() throws ExecutionException, InterruptedException {
        ExecutorService exc = Executors.newCachedThreadPool();
        FutureTask<Integer> callableTask= (FutureTask<Integer>) exc.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws InterruptedException {
                return callCountService.getNum();
            }
        });
        return callableTask.get();
    }

    @RequestMapping("/hello")
    public JSONObject hello(){
        JSONObject outData = new JSONObject();
        outData.put("ResTable", "a");
        System.out.println(11);
        return outData;
    }
}
