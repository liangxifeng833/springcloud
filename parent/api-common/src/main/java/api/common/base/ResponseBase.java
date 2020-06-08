package api.common.base;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 服务接口响应类
 */
@Data
@Slf4j
public class ResponseBase {
    private Integer rtnCode;
    private String msg;
    private Object data;

    public ResponseBase () {}

    public ResponseBase( Integer rtnCode, String msg, Object data)
    {
        super();
        this.rtnCode = rtnCode;
        this.msg = msg;
        this.data = data;
    }

}
