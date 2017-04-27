package com.example.web;

import java.util.List;
import java.util.Map;

import com.example.dto.SwaggerDemoDTO;
import com.example.result.DataResult;
import com.example.util.ObjectRandomFieldValueUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wb-zhangkenan on 2017/4/19.
 *
 * @author wb-zhangkenan
 * @date 2017/04/19
 */
@Api(value = "Swagger的demo")
@RestController
@RequestMapping("/swaggerDemo")
public class SwaggerDemo {

    @ApiOperation(value = "swagger的第一个请求,必须是POST请求", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
        @ApiResponse(code = 2000,message = "请求正常返回"),
        @ApiResponse(code = 3002,message = "请求出现异常")
    })
    @RequestMapping(value = "/swaggerFir",produces = MediaType.APPLICATION_JSON_VALUE)
    public DataResult<List<SwaggerDemoDTO>> swaggerFir(SwaggerDemoDTO swaggerDemoDTO){

        return (DataResult<List<SwaggerDemoDTO>>)ObjectRandomFieldValueUtil.getRealObject(DataResult.class,SwaggerDemoDTO.class,2);
    }

    /**
     * 注意这里对Map的支持是有限制的，即key和value不能为Collections的实现类和Map的实现类
     */
    @ApiOperation(value = "swagger的第二个请求,必须是POST请求", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
        @ApiResponse(code = 2000,message = "请求正常返回"),
        @ApiResponse(code = 3002,message = "请求出现异常")
    })
    @RequestMapping(value = "/swaggerSec",produces = MediaType.APPLICATION_JSON_VALUE)
    public DataResult<Map<String,String>> swaggerSec(SwaggerDemoDTO swaggerDemoDTO){

        return (DataResult<Map<String,String>>)ObjectRandomFieldValueUtil.getMapDataResult(DataResult.class,2,String.class,String.class);
    }

    @ApiOperation(value = "swagger的第三个请求,必须是GET请求", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "address", value = "地址", dataType = "String", paramType = "query")
    })
    @ApiResponses({
        @ApiResponse(code = 2000,message = "请求正常返回"),
        @ApiResponse(code = 3002,message = "请求出现异常")
    })
    @RequestMapping(value = "/swaggerThir",produces = MediaType.APPLICATION_JSON_VALUE)
    public DataResult<SwaggerDemoDTO> swaggerThir(String userName,String address){

        return (DataResult<SwaggerDemoDTO>)ObjectRandomFieldValueUtil.getRealObject(DataResult.class,SwaggerDemoDTO.class,1);
    }
}
