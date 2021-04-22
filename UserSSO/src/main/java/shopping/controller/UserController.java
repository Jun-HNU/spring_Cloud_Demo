package shopping.controller;

import shopping.pojo.User;
import shopping.service.UserService;
import shopping.tools.JwtUtil;
import shopping.tools.MD5Utils;
import shopping.tools.ResponseResult;
import shopping.tools.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author yxm
 * @date 2021/3/1
 */
@RestController
@RequestMapping("/rfid")
@Api(value = "用户登录模块API")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 通过账号或手机号登录
     *
     * @param map
     * @return
     */
    @ApiOperation(value = "用户登录", notes = "通过账号或者手机号登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseResult queryByName(@RequestBody Map map) {
        ResponseResult response = null;
        String username = (String) map.get("usercode");
        String password = MD5Utils.stringToMD5((String) map.get("password"));
        try {
            User user = userService.queryByName(username);
            if (user == null || !password.equals(user.getPassWord())) {
                response = new ResponseResult(StatusCode.Fail);
            } else {
                String token = JwtUtil.sign(username, password);
                user.setToken(token);
                response = new ResponseResult(StatusCode.Success);
                response.setData(user);
            }
        } catch (Exception e) {
            response = new ResponseResult(StatusCode.SysBusy);
        }
        return response;
    }

    /**
     * 通过用户账号返回用户所有信息
     *
     * @return
     */
    @RequestMapping(value = "/queryByUserCode", method = RequestMethod.POST)
    public ResponseResult queryByUserCode(@RequestBody Map map) {
        ResponseResult response = null;
        try {
            String usercode = (String) map.get("usercode");
            User user = userService.queryByUserCode(usercode);
            response = new ResponseResult(StatusCode.Success);
            response.setData(user);
        } catch (Exception e) {
            response = new ResponseResult(StatusCode.SysBusy);
        }
        return response;
    }
}
