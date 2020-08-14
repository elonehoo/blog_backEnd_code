package com.inet.codeBase.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.inet.codeBase.beans.Type;
import com.inet.codeBase.service.TypeService;
import com.inet.codeBase.utils.Result;
import com.inet.codeBase.utils.UUIDUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Resource
    private TypeService typeService;


    /**
     * 创建新的类型
     * @param map
     * @return
     */
    @PostMapping("/insert")
    @CrossOrigin
    public Result getInsert(@RequestBody HashMap<String,Object> map){
        //获取前端的数据
        String typeName = (String) map.get("typeName");
        //创建序号
        String id = UUIDUtils.getId();
        //创建Type实体类对象
        Type type = new Type();
        type.setTypeId(id);
        type.setTypeName(typeName);
        //使用Service层的插入方法
        int insert = typeService.InsertType(type);
        //判断是否创建成功
        if (insert != 1){
            return new Result("产生错误","添加类别请求失败",104);
        }else {
            return new Result("添加成功","添加类别请求成功",100);
        }
    }

    /**
     * 查找所有的类型集合，进行分页展示，一页展示五条数据
     */
    @PostMapping("/paging")
    @CrossOrigin
    public Result getPaging(@RequestBody HashMap<String,Object> map){
        //获取页数
        int pageNum = (int) map.get("pageNum");
        //设置
        int pageSize = 5;
        //获取分页后得信息
        IPage<Type> typeLists = typeService.pageIng(pageNum,pageSize);
        return new Result(typeLists,"分页信息",100);
    }
    /**
     * 删除类别
     */
    @PostMapping("/del")
    @CrossOrigin
    public Result getDelete(@RequestBody HashMap<String,Object> map){
        //获取需要删除得序号
        String typeId = (String) map.get("typeId");
        //调用方法
        String message = typeService.deleteById(typeId);
        return new Result(message,"删除请求",100);
    }

    /**
     * 寻找修改得类别
     * @param map
     * @return
     */
    @PostMapping("/search")
    @CrossOrigin
    public Result getSearch(@RequestBody HashMap<String,Object> map){
        //获取需要查找得序号
        String typeId = (String) map.get("typeId");
        //调用方法
        Type type = typeService.selectById(typeId);
        //判断是否有
        if (type == null){
            return new Result("修改失败","修改请求",104);
        }else {
            return new Result(type,"修改请求",100);
        }
    }

    /**
     * 修改类别
     * @param map
     * @return
     */
    @PostMapping("/update")
    @CrossOrigin
    public Result getUpdate(@RequestBody HashMap<String,Object> map){
        //获取前端得数据
        String typeId = (String) map.get("typeId");
        String typeName = (String) map.get("typeName");
        //设置需要修改得实体类
        Type type = new Type();
        type.setTypeId(typeId);
        type.setTypeName(typeName);
        String message = typeService.updateById(type);
        return new Result(message,"修改请求",100);
    }

    /**
     * 查找所有得类别
     * @param map
     * @return
     */
    @PostMapping("/classifier")
    @CrossOrigin
    public Result getClassifier(@RequestBody HashMap<String,Object> map){
        //获取全部
        List<Type> types = typeService.selectAll();
        return new Result(types,"查找全部",100);
    }
}
