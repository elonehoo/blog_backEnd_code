package com.inet.codeBase.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inet.codeBase.beans.Type;
import com.inet.codeBase.mapper.TypeMapper;
import com.inet.codeBase.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeMapper typeMapper;

    @Override
    public int InsertType(Type type) {
        int insert = typeMapper.insert(type);
        return insert;
    }

    @Override
    public IPage<Type> pageIng(int pageNum, int pageSize) {
        IPage<Type> iPage = typeMapper.selectPage(new Page<>(pageNum, pageSize), new QueryWrapper<Type>());
        return iPage;
    }

    @Override
    public String deleteById(String typeId) {
        int i = typeMapper.deleteById(typeId);
        if (i != 1){
            return "删除失败";
        }else {
            return "删除成功";
        }
    }

    @Override
    public Type selectById(String typeId) {
        Type type = typeMapper.selectById(typeId);
        return type;
    }

    @Override
    public String updateById(Type type) {
        int i = typeMapper.updateById(type);
        if (i != 1){
            return "修改失败";
        }else {
            return "修改成功";
        }
    }

    @Override
    public List<Type> selectAll() {
        List<Type> types = typeMapper.selectList(null);
        return types;
    }
}
