package com.inet.codeBase.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.inet.codeBase.beans.Type;

import java.util.List;

public interface TypeService {
    /**
     * 插入一个类型实体
     * @param type
     * @return
     */
    int InsertType(Type type);

    /**
     * 创建分页信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    IPage<Type> pageIng(int pageNum, int pageSize);

    /**
     * 通过序号删除类别
     * @param typeId
     * @return
     */
    String deleteById(String typeId);

    /**
     * 通过序号查找类别
     * @param typeId
     * @return
     */
    Type selectById(String typeId);

    /**
     * 通过序号修改类型
     * @param type
     * @return
     */
    String updateById(Type type);

    /**
     * 获取全部得类别
     * @return
     */
    List<Type> selectAll();
}
