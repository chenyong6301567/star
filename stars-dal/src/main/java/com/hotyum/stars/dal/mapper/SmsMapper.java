package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.Sms;
import com.hotyum.stars.dal.model.SmsExample;
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

public interface SmsMapper {
    @SelectProvider(type=SmsSqlProvider.class, method="countByExample")
    long countByExample(SmsExample example);

    @DeleteProvider(type=SmsSqlProvider.class, method="deleteByExample")
    int deleteByExample(SmsExample example);

    @Delete({
        "delete from sms",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sms (phone, code, ",
        "gmt_create, gmt_modify, ",
        "status, content, ",
        "type)",
        "values (#{phone,jdbcType=INTEGER}, #{code,jdbcType=VARCHAR}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModify,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=TINYINT}, #{content,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Sms record);

    @InsertProvider(type=SmsSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Sms record);

    @SelectProvider(type=SmsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="phone", property="phone", jdbcType=JdbcType.INTEGER),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT)
    })
    List<Sms> selectByExample(SmsExample example);

    @Select({
        "select",
        "id, phone, code, gmt_create, gmt_modify, status, content, type",
        "from sms",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="phone", property="phone", jdbcType=JdbcType.INTEGER),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT)
    })
    Sms selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SmsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Sms record, @Param("example") SmsExample example);

    @UpdateProvider(type=SmsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Sms record, @Param("example") SmsExample example);

    @UpdateProvider(type=SmsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Sms record);

    @Update({
        "update sms",
        "set phone = #{phone,jdbcType=INTEGER},",
          "code = #{code,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT},",
          "content = #{content,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Sms record);
}