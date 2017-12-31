package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.RegisterNotice;
import com.hotyum.stars.dal.model.RegisterNoticeExample;
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

public interface RegisterNoticeMapper {
    @SelectProvider(type=RegisterNoticeSqlProvider.class, method="countByExample")
    long countByExample(RegisterNoticeExample example);

    @DeleteProvider(type=RegisterNoticeSqlProvider.class, method="deleteByExample")
    int deleteByExample(RegisterNoticeExample example);

    @Delete({
        "delete from register_notice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into register_notice (user_id, phone, ",
        "type, notice_content, ",
        "gmt_create, gmt_modify, ",
        "status)",
        "values (#{userId,jdbcType=INTEGER}, #{phone,jdbcType=INTEGER}, ",
        "#{type,jdbcType=TINYINT}, #{noticeContent,jdbcType=VARCHAR}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModify,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(RegisterNotice record);

    @InsertProvider(type=RegisterNoticeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(RegisterNotice record);

    @SelectProvider(type=RegisterNoticeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="phone", property="phone", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="notice_content", property="noticeContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<RegisterNotice> selectByExample(RegisterNoticeExample example);

    @Select({
        "select",
        "id, user_id, phone, type, notice_content, gmt_create, gmt_modify, status",
        "from register_notice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="phone", property="phone", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="notice_content", property="noticeContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    RegisterNotice selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RegisterNoticeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RegisterNotice record, @Param("example") RegisterNoticeExample example);

    @UpdateProvider(type=RegisterNoticeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RegisterNotice record, @Param("example") RegisterNoticeExample example);

    @UpdateProvider(type=RegisterNoticeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RegisterNotice record);

    @Update({
        "update register_notice",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "phone = #{phone,jdbcType=INTEGER},",
          "type = #{type,jdbcType=TINYINT},",
          "notice_content = #{noticeContent,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RegisterNotice record);
}