package pres.qianmuna.test

import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSession
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.junit.Test
import pres.qianmuna.mybatis.mapper.UserMapperKT
import kotlin.Exception

/**
@author HJC
@date 2020/6/2  20:00
@description :
@version 1.0
谦谦君子 卑以自牧也
 */

class Test {
    /*
    * mybatis OPM 框架
    *
    *
    * 什么 是 OPM
    *
    * 实现 面向对象编程语言里面
    * 不同类型数据 之间的互相转换
    *
    * */



    /*
    * Test2 Config
    * */

    @Test
    fun test(){

        // 全局 配置 文件
        val res = "mybatis-config.xml"
        val count:Int
        val sqlSession : SqlSession?
        /*加载 全局配置*/
        /*java -> 加载 xml 配置 文件*/
        val asStream = Resources.getResourceAsStream(res) ?: throw Exception("err")
        /*mybatis*/
        /*
        * mybatis 启动 的 加载 从 这里 开始
        * */
        /*构建 sqlSession工厂*/
        /*
        * SqlSessionFactoryBuilder 构建 解析xml
        *
        *  -> parse //
        *  -> parseConfiguration // 解析 xml 中 属性
        *  -> xNode ->   Configuration // 解析 映射属性
        *  -> 得到配置 数据源
        *
        * // 解析 mappers 得到 mapper sql //
        *  -> MappedStatement  ——> 标签 属性 的 所有 内容
        * */
        // 得到 了数据源 // sql
        val build = SqlSessionFactoryBuilder().build(asStream) ?: throw Exception("err")

        //操作
        /*
        * 创建 缓存
        * */
        // /////
        /// 取到后装配 装配
        sqlSession = build.openSession()

        //getMappedStatement // 得到info
        // 去缓存 查找
        // 无则 去 数据库 取
        // 并且 添加到缓存中
        /*
        * 缓存 标志 四个key
        * 类hashcode / 方法 / 方法 标志 / sql
        * */

        /*
        *
        *
        *   封装了 jdbc 基本的 三个操作
        *
        *   得到ResultMataDara // 封装了
        *   数据库字段 （columnNames） ， 类型(jdbcTypes)
        *   实体类映射 类型 (classNames)
        *
        * // 然后基于反射的技术 进行相应的 输出
        *
        *
        *
        *
        * */
        count = sqlSession.selectOne("pres.qianmuna.mybatis.mapper.UserMapper.count")
        println("///================///")
        println(count)
        println("///================///")

        /*
        * 根据ID 查找
        * */
        // getMapper
        val mapper = sqlSession.getMapper(UserMapperKT::class.java)
        var count1 = mapper.count() // kt OK？
        var list = mapper.queryById(11L)

        println("///========///")
       /* sqlSession
                .selectOne<MutableList<Map<String? , Any?>>>(
                        "pres.qianmuna.mybatis.mapper.UserMapperKT.queryById" ,
                        1L)*/

        //

        /*
        * mybatis 一级 缓存 默认 开启
        *
        * */



    }
}