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
        "where token = #{token,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String token);

    @Insert({
        "insert into token_access (token, user_id, ",
        "token_create, token_expired, ",
        "active_time, active_count, ",
        "remember, anonymous, ",
        "status)",
        "values (#{token,jdbcType=VARCHAR}, #{userId,jdbcType=BIGINT}, ",
        "#{tokenCreate,jdbcType=TIMESTAMP}, #{tokenExpired,jdbcType=TIMESTAMP}, ",
        "#{activeTime,jdbcType=TIMESTAMP}, #{activeCount,jdbcType=INTEGER}, ",
        "#{remember,jdbcType=TINYINT}, #{anonymous,jdbcType=TINYINT}, ",
        "#{status,jdbcType=TINYINT})"
    })
    int insert(TokenAccess record);

    @InsertProvider(type=TokenAccessSqlProvider.class, method="insertSelective")
    int insertSelective(TokenAccess record);

    @SelectProvider(type=TokenAccessSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="token_create", property="tokenCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="token_expired", property="tokenExpired", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="active_time", property="activeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="active_count", property="activeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="remember", property="remember", jdbcType=JdbcType.TINYINT),
        @Result(column="anonymous", property="anonymous", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<TokenAccess> selectByExample(TokenAccessExample example);

    @Select({
        "select",
        "token, user_id, token_create, token_expired, active_time, active_count, remember, ",
        "anonymous, status",
        "from token_access",
        "where token = #{token,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="token_create", property="tokenCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="token_expired", property="tokenExpired", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="active_time", property="activeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="active_count", property="activeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="remember", property="remember", jdbcType=JdbcType.TINYINT),
        @Result(column="anonymous", property="anonymous", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    TokenAccess selectByPrimaryKey(String token);

    @UpdateProvider(type=TokenAccessSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TokenAccess record, @Param("example") TokenAccessExample example);

    @UpdateProvider(type=TokenAccessSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TokenAccess record, @Param("example") TokenAccessExample example);

    @UpdateProvider(type=TokenAccessSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TokenAccess record);

    @Update({
        "update token_access",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "token_create = #{tokenCreate,jdbcType=TIMESTAMP},",
          "token_expired = #{tokenExpired,jdbcType=TIMESTAMP},",
          "active_time = #{activeTime,jdbcType=TIMESTAMP},",
          "active_count = #{activeCount,jdbcType=INTEGER},",
          "remember = #{remember,jdbcType=TINYINT},",
          "anonymous = #{anonymous,jdbcType=TINYINT},",
          "status = #{status,jdbcType=TINYINT}",
        "where token = #{token,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TokenAccess record);
}