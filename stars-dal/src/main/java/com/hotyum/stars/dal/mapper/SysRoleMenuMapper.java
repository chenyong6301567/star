package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.SysRoleMenu;
import com.hotyum.stars.dal.model.SysRoleMenuExample;
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

public interface SysRoleMenuMapper {
    @SelectProvider(type=SysRoleMenuSqlProvider.class, method="countByExample")
    long countByExample(SysRoleMenuExample example);

    @DeleteProvider(type=SysRoleMenuSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysRoleMenuExample example);

    @Delete({
        "delete from sys_role_menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_role_menu (role_id, menu_id)",
        "values (#{roleId,jdbcType=INTEGER}, #{menuId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SysRoleMenu record);

    @InsertProvider(type=SysRoleMenuSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(SysRoleMenu record);

    @SelectProvider(type=SysRoleMenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.INTEGER)
    })
    List<SysRoleMenu> selectByExample(SysRoleMenuExample example);

    @Select({
        "select",
        "id, role_id, menu_id",
        "from sys_role_menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.INTEGER)
    })
    SysRoleMenu selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysRoleMenuSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysRoleMenu record, @Param("example") SysRoleMenuExample example);

    @UpdateProvider(type=SysRoleMenuSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysRoleMenu record, @Param("example") SysRoleMenuExample example);

    @UpdateProvider(type=SysRoleMenuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysRoleMenu record);

    @Update({
        "update sys_role_menu",
        "set role_id = #{roleId,jdbcType=INTEGER},",
          "menu_id = #{menuId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysRoleMenu record);
}