package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.TokenAccess;
import com.hotyum.stars.dal.model.TokenAccessExample;
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

public interface TokenAccessMapper {
    @SelectProvider(type=TokenAccessSqlProvider.class, method="countByExample")
    long countByExample(TokenAccessExample example);

    @DeleteProvider(type=TokenAccessSqlProvider.class, method="deleteByExample")
    int deleteByExample(TokenAccessExample example);

    @Delete({
        "delete from token_access",
        "where id = #{id,jdbcType=INTEGER}",
          "and token = #{token,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("token") String token);

    @Insert({
        "insert into token_access (token, user_id, ",
        "token_create, token_expired, ",
        "active_time, active_count, ",
        "remember, anonymous, ",
        "status, gmt_create, ",
        "gmt_modify)",
        "values (#{token,jdbcType=VARCHAR}, #{userId,jdbcType=INTEGER}, ",
        "#{tokenCreate,jdbcType=TIMESTAMP}, #{tokenExpired,jdbcType=TIMESTAMP}, ",
        "#{activeTime,jdbcType=TIMESTAMP}, #{activeCount,jdbcType=INTEGER}, ",
        "#{remember,jdbcType=TINYINT}, #{anonymous,jdbcType=TINYINT}, ",
        "#{status,jdbcType=TINYINT}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TokenAccess record);

    @InsertProvider(type=TokenAccessSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TokenAccess record);

    @SelectProvider(type=TokenAccessSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="token_create", property="tokenCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="token_expired", property="tokenExpired", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="active_time", property="activeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="active_count", property="activeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="remember", property="remember", jdbcType=JdbcType.TINYINT),
        @Result(column="anonymous", property="anonymous", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TokenAccess> selectByExample(TokenAccessExample example);

    @Select({
        "select",
        "id, token, user_id, token_create, token_expired, active_time, active_count, ",
        "remember, anonymous, status, gmt_create, gmt_modify",
        "from token_access",
        "where id = #{id,jdbcType=INTEGER}",
          "and token = #{token,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="token_create", property="tokenCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="token_expired", property="tokenExpired", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="active_time", property="activeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="active_count", property="activeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="remember", property="remember", jdbcType=JdbcType.TINYINT),
        @Result(column="anonymous", property="anonymous", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    TokenAccess selectByPrimaryKey(@Param("id") Integer id, @Param("token") String token);

    @UpdateProvider(type=TokenAccessSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TokenAccess record, @Param("example") TokenAccessExample example);

    @UpdateProvider(type=TokenAccessSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TokenAccess record, @Param("example") TokenAccessExample example);

    @UpdateProvider(type=TokenAccessSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TokenAccess record);

    @Update({
        "update token_access",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "token_create = #{tokenCreate,jdbcType=TIMESTAMP},",
          "token_expired = #{tokenExpired,jdbcType=TIMESTAMP},",
          "active_time = #{activeTime,jdbcType=TIMESTAMP},",
          "active_count = #{activeCount,jdbcType=INTEGER},",
          "remember = #{remember,jdbcType=TINYINT},",
          "anonymous = #{anonymous,jdbcType=TINYINT},",
          "status = #{status,jdbcType=TINYINT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}",
          "and token = #{token,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TokenAccess record);
}