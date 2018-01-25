package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.SendEmail;
import com.hotyum.stars.dal.model.SendEmailExample;
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

public interface SendEmailMapper {
    @SelectProvider(type=SendEmailSqlProvider.class, method="countByExample")
    long countByExample(SendEmailExample example);

    @DeleteProvider(type=SendEmailSqlProvider.class, method="deleteByExample")
    int deleteByExample(SendEmailExample example);

    @Delete({
        "delete from send_email",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into send_email (to_email, code, ",
        "gmt_create, gmt_update, ",
        "end_date, status)",
        "values (#{toEmail,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtUpdate,jdbcType=TIMESTAMP}, ",
        "#{endDate,jdbcType=TIMESTAMP}, #{status,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SendEmail record);

    @InsertProvider(type=SendEmailSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(SendEmail record);

    @SelectProvider(type=SendEmailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="to_email", property="toEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_update", property="gmtUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<SendEmail> selectByExample(SendEmailExample example);

    @Select({
        "select",
        "id, to_email, code, gmt_create, gmt_update, end_date, status",
        "from send_email",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="to_email", property="toEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_update", property="gmtUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    SendEmail selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SendEmailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SendEmail record, @Param("example") SendEmailExample example);

    @UpdateProvider(type=SendEmailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SendEmail record, @Param("example") SendEmailExample example);

    @UpdateProvider(type=SendEmailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SendEmail record);

    @Update({
        "update send_email",
        "set to_email = #{toEmail,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_update = #{gmtUpdate,jdbcType=TIMESTAMP},",
          "end_date = #{endDate,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SendEmail record);
}