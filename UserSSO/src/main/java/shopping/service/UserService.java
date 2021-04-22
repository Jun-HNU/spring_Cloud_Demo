package shopping.service;

//import shopping.service.UserService.User;

import shopping.pojo.User;

/**
 * @author yxm
 * @date 2021/3/1
 */
public interface UserService {
    /**
     * 根据用户名或手机号查询用户
     * @param username
     * @return
     */
    User queryByName(String username);

    /**
     * 根据用户名去数据库查询获得密码
     * @param username
     * @return
     */
    String getPassword(String username);

    /**
     * 通过用户账号返回用户所有信息
     * @param userCode
     * @return
     */
    User queryByUserCode(String userCode);


}
