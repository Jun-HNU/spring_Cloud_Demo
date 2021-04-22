package shopping.mapper;


import shopping.pojo.User;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper  extends Mapper<User> {
    User queryUserByName(String username);
    User queryByUserCode (String userCode);
    String getPassword(String username);

}
