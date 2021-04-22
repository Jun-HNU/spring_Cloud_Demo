package shopping.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yxm
 * @date 2021/3/1
 * 用户实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer Id;
    private String UserCode;
    private String UserName;
    private String PassWord;
    private String Mobile;
    private String NickName;
    private String Avatar;
    private String Notes;
    private Integer Status;
    private Integer IsUsed;
    private String UseTime;
    private String Token;
}

