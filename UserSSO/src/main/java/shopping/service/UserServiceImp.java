package shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shopping.mapper.UserMapper;
import shopping.pojo.User;
@Component
public class UserServiceImp implements UserService{
@Autowired
    UserMapper userMapper;

    @Override
    public User queryByName(String username) {
        return userMapper.queryUserByName(username);
    }

    @Override
    public String getPassword(String username) {
        return userMapper.getPassword(username);
    }

    @Override
    public User queryByUserCode(String userCode) {
        return  userMapper.queryByUserCode(userCode);
    }
}
