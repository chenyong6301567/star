package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.SystemNotice;
import com.hotyum.stars.dal.model.SystemNoticeExample;
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

public interface SystemNoticeMapper {
    @SelectProvider(type=SystemNoticeSqlProvider.class, method="countByExample")
    long countByExample(SystemNoticeExample example);

    @DeleteProvider(type=SystemNoticeSqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemNoticeExample example);

    @Delete({
        "delete from system_notice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into system_notice (to_type, sys_type, ",
        "notice_content, gmt_create, ",
        "gmt_modify, status)",
        "values (#{toType,jdbcType=TINYINT}, #{sysType,jdbcType=TINYINT}, ",
        "#{noticeContent,jdbcType=VARCHAR}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP}, #{status,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SystemNotice record);

    @InsertProvider(type=SystemNoticeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(SystemNotice record);

    @SelectProvider(type=SystemNoticeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="to_type", property="toType", jdbcType=JdbcType.TINYINT),
        @Result(column="sys_type", property="sysType", jdbcType=JdbcType.TINYINT),
        @Result(column="notice_content", property="noticeContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<SystemNotice> selectByExample(SystemNoticeExample example);

    @Select({
        "select",
        "id, to_type, sys_type, notice_content, gmt_create, gmt_modify, status",
        "from system_notice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="to_type", property="toType", jdbcType=JdbcType.TINYINT),
        @Result(column="sys_type", property="sysType", jdbcType=JdbcType.TINYINT),
        @Result(column="notice_content", property="noticeContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    SystemNotice selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SystemNoticeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemNotice record, @Param("example") SystemNoticeExample example);

    @UpdateProvider(type=SystemNoticeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemNotice record, @Param("example") SystemNoticeExample example);

    @UpdateProvider(type=SystemNoticeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemNotice record);

    @Update({
        "update system_notice",
        "set to_type = #{toType,jdbcType=TINYINT},",
          "sys_type = #{sysType,jdbcType=TINYINT},",
          "notice_content = #{noticeContent,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemNotice record);
}