package shopping.tools;


import lombok.Data;


/**
 * @author yxm
 * @date 2021/3/1
 */
@Data
public class ResponseResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResponseResult(StatusCode statusCode){
        this.code=statusCode.getCode();
        this.msg=statusCode.getMsg();
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(T data, StatusCode statusCode) {
        this.data = data;
        this.code=statusCode.getCode();
        this.msg=statusCode.getMsg();
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}

