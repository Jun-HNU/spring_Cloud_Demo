package shopping.tools;

/**
 * @author yxm
 * @date 2021/3/1
 */

public enum StatusCode {

    Success(200,"成功！"),
    Fail(500,"失败,用户名或密码错误！"),
    SysBusy(300,"系统繁忙,请稍后重试"),
    InsertFail(500,"插入失败！"),
    NotFound(404,"用户不存在"),
    Entity_Not_Exist(10011,"实体信息不存在"),
    Invalid_Params(10012,"请求参数不合法!"),
    ERROR(400,"token验证失败！"),
    DelFail(-1,"部门下存在子级部门，不能删除"),
    Opertimenull(100013,"操作时间为空值错误");

    private Integer code;
    private String msg;
    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

