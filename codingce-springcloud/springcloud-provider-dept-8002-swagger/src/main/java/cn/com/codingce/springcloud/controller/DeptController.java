package cn.com.codingce.springcloud.controller;

import cn.com.codingce.springcloud.pojo.Dept;
import cn.com.codingce.springcloud.service.DeptClientService;
import cn.com.codingce.springcloud.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xzMa
 *
 * 提供RestFul服务
 */
@RestController
public class DeptController {

    @Resource
    private DeptService deptService;

    //获取一些配置的信息
    @Resource
    private DiscoveryClient client;

    @ApiOperation(value="添加部门信息", notes="接收传过来的对象，添加进数据库")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Dept", value = "Dept对象", required = true, dataType = "Dept")    })
    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @ApiOperation(value="根据Id获取部门信息", notes="根据url的id来获取指定的部门信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "部门Id", required = true, dataType = "int")    })
    @GetMapping("/dept/get/{id}")
    public Dept queryBuId(@PathVariable("id") Long id) {
        return deptService.queryById(id);
    }

    @ApiOperation(value="获取部门详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新部门详细信息")
    @GetMapping("/dept/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

    //注册进来的微服务, 获取一些消息
    @ApiIgnore
    @GetMapping("/dept/discovery")
    public Object discovery() {
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>" + services);
        //得到一个具体的服务信息, 通过微服务id, applicationName
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t" +
                    instance.getServiceId());
        }

        return this.client;
    }

}
