package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.SysMenu;
import com.hotyum.stars.dal.model.SysMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SysMenuMapper {
    @SelectProvider(type=SysMenuSqlProvider.class, method="countByExample")
    long countByExample(SysMenuExample example);

    @DeleteProvider(type=SysMenuSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysMenuExample example);

    @Delete({
        "delete from sys_menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_menu (parent_id, parent_ids, ",
        "name, sort, href, ",
        "icon, is_show, permission, ",
        "remarks, gmt_create, ",
        "gmt_modify, status)",
        "values (#{parentId,jdbcType=INTEGER}, #{parentIds,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{sort,jdbcType=DECIMAL}, #{href,jdbcType=VARCHAR}, ",
        "#{icon,jdbcType=VARCHAR}, #{isShow,jdbcType=TINYINT}, #{permission,jdbcType=VARCHAR}, ",
        "#{remarks,jdbcType=VARCHAR}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP}, #{status,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SysMenu record);

    @InsertProvider(type=SysMenuSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(SysMenu record);

    @SelectProvider(type=SysMenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="parent_ids", property="parentIds", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.DECIMAL),
        @Result(column="href", property="href", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_show", property="isShow", jdbcType=JdbcType.TINYINT),
        @Result(column="permission", property="permission", jdbcType=JdbcType.VARCHAR),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<SysMenu> selectByExample(SysMenuExample example);

    @Select({
        "select",
        "id, parent_id, parent_ids, name, sort, href, icon, is_show, permission, remarks, ",
        "gmt_create, gmt_modify, status",
        "from sys_menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="parent_ids", property="parentIds", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.DECIMAL),
        @Result(column="href", property="href", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_show", property="isShow", jdbcType=JdbcType.TINYINT),
        @Result(column="permission", property="permission", jdbcType=JdbcType.VARCHAR),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    SysMenu selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysMenuSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    @UpdateProvider(type=SysMenuSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    @UpdateProvider(type=SysMenuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysMenu record);

    @Update({
        "update sys_menu",
        "set parent_id = #{parentId,jdbcType=INTEGER},",
          "parent_ids = #{parentIds,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=DECIMAL},",
          "href = #{href,jdbcType=VARCHAR},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "is_show = #{isShow,jdbcType=TINYINT},",
          "permission = #{permission,jdbcType=VARCHAR},",
          "remarks = #{remarks,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysMenu record);
}