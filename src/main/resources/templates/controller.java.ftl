package ${package.Controller};


import org.springframework.web.bind.annotation.*;
import com.mageline.techworks.api.model.BaseResponse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${table.entityName};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
  * <p>
  * ${table.comment!} 前端控制器
  * </p>
  *
  * @author ${author}
  * @since ${date}
  * @version v1.0
**/
<#if restControllerStyle>
@Api(tags = {"${table.comment!}"})
@RestController
<#else>
@Controller
@Slf4j
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
    class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
    <#else>
public class ${table.controllerName} {
    </#if>

    @Resource
    private ${table.serviceName} ${(table.serviceName)?uncap_first};

    /**
    * 查询分页数据
    */
    @ApiOperation(value = "查询分页数据",notes = "查询分页数据",nickname = "${author}",response = ${entity}.class)
    @GetMapping(value = "/list")
    public BaseResponse<IPage<${entity}>> findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,@RequestParam(name = "pageSize", defaultValue = "20") int pageSize){
        return BaseResponse.success(${(table.serviceName)?uncap_first}.page(new Page<>(pageNum, pageSize)));
    }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "根据id查询数据",notes = "根据id查询数据",nickname = "${author}",response = ${entity}.class)
    @GetMapping(value = "/getById")
    public BaseResponse<${entity}> getById(@RequestParam("id") Long id){
        return BaseResponse.success(${(table.serviceName)?uncap_first}.getById(id));
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增数据",notes = "新增数据",nickname = "${author}")
    @PostMapping(value = "/add")
    public BaseResponse add(@RequestBody ${entity} ${entity?uncap_first}){
        return BaseResponse.success(${(table.serviceName)?uncap_first}.saveOrUpdate(${entity?uncap_first}));
    }

    /**
    * 删除
    */
    @ApiOperation(value = "删除数据",notes = "删除数据",nickname = "${author}")
    @GetMapping(value = "/del")
    public BaseResponse delete(@RequestParam("ids") List<Long> ids){
        return BaseResponse.success(${(table.serviceName)?uncap_first}.removeByIds(ids));
    }

    /**
    * 修改
    */
    @ApiOperation(value = "更新数据")
    @PostMapping(value = "/update")
    public BaseResponse update(@RequestBody ${entity} ${entity?uncap_first}){
        return BaseResponse.success(${(table.serviceName)?uncap_first}.updateById(${entity?uncap_first}));
    }

}
</#if>