package lxf.order.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 领域层返回类
 * @author : liangxifeng
 * @date: 2018-1-20
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DomainResponse<T> {
    //操作码, 默认=1 为正常返回应用层所需数据
    private int code = 1;
    //响应描述信息
    private String message;
    //响应数据
    private T data;

    public DomainResponse(int code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public DomainResponse(String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 出现错误时调用该方法
     * @param code 错误码
     * @param message 错误描述
     * @return
     */
    public static DomainResponse ofMessage(int code, String message) {
        return new DomainResponse(code, message, null);
    }

    /**
     * 成功调用方法
     * @param data 返回数据
     * @return
     */
    public static DomainResponse ofSuccess(Object data) {
        return new DomainResponse(1, "请求成功", data);
    }

}
