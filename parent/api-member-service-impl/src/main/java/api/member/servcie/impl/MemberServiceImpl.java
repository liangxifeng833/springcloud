package api.member.servcie.impl;

import api.common.base.BaseApiService;
import api.common.base.ResponseBase;
import api.member.entity.User;
import api.member.service.IMemberServcie;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 会员接口实现,注意：实现的是api.member.servcie项目中的api接口
 */
@RestController
//swagger接口文档相关注解
@Api(tags = "会员服务接口")
public class MemberServiceImpl extends BaseApiService implements IMemberServcie {
    @Value("${server.port}")
    private Integer serverPort;

    @ApiOperation("会员服务默认方法")
    @GetMapping("/")
    public String index() {
        return "我是会员服务,port="+serverPort;
    }

    @Override
    //swagger接口文档相关注解--start
    @ApiOperation("查询会员接口")
    @ApiImplicitParam(name="name",value = "会员名称",defaultValue = "用户信息参数",required = true)
    //swagger接口文档相关注解--end
    @GetMapping("/getMember")
    public User getMember(@RequestParam("name") String name) {
        User user = new User();
        user.setName(name+serverPort);
        user.setAge(20);
        return user;
    }

    @GetMapping("/getUserInfo")
    @Override
    public ResponseBase getUserInfo() {
        try {
            //会员服务接口产生1.5秒的延迟
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return setResultSuccess("调用会员服务接口成功...");
    }

    @PostMapping("/postDemo")
    public ResponseBase postDemo(@RequestBody Map<String,Object> params)
    {
        return setResultSuccess("调用成功");
    }
}
