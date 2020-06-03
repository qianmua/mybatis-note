package pres.qianmuna.mybatis.mapper

import org.apache.ibatis.annotations.Param
import org.omg.CORBA.Object

/**
@author HJC
@date 2020/6/3  11:41
@description :
@version 1.0
谦谦君子 卑以自牧也
 */
interface UserMapperKT {

    /**
     * not null
     * kotlin not-null
     */
    fun queryById(@Param("id") id :Long):List<Map<String? , Object?>>?

    /**
     * 同一
     *
     * 验证 用
     */
    fun count():Int

}