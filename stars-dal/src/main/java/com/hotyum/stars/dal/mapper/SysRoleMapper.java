package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.SysRole;
import com.hotyum.stars.dal.model.SysRoleExample;
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

public interface SysRoleMapper {
    @SelectProvider(type=SysRoleSqlProvider.class, method="countByExample")
    long countByExample(SysRoleExample example);

    @DeleteProvider(type=SysRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysRoleExample example);

    @Delete({
        "delete from sys_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_role (name, enabled, ",
        "remarks, gmt_create, ",
        "gmt_modify, status, ",
        "default_role)",
        "values (#{name,jdbcType=VARCHAR}, #{enabled,jdbcType=TINYINT}, ",
        "#{remarks,jdbcType=VARCHAR}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP}, #{status,jdbcType=TINYINT}, ",
        "#{defaultRole,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SysRole record);

    @InsertProvider(type=SysRoleSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(SysRole record);

    @SelectProvider(type=SysRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.TINYINT),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="default_role", property="defaultRole", jdbcType=JdbcType.TINYINT)
    })
    List<SysRole> selectByExample(SysRoleExample example);

    @Select({
        "select",
        "id, name, enabled, remarks, gmt_create, gmt_modify, status, default_role",
        "from sys_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.TINYINT),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="default_role", property="defaultRole", jdbcType=JdbcType.TINYINT)
    })
    SysRole selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    @UpdateProvider(type=SysRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    @UpdateProvider(type=SysRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysRole record);

    @Update({
        "update sys_role",
        "set name = #{name,jdbcType=VARCHAR},",
          "enabled = #{enabled,jdbcType=TINYINT},",
          "remarks = #{remarks,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT},",
          "default_role = #{defaultRole,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysRole record);
}