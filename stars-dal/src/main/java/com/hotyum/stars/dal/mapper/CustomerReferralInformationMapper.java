package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.CustomerReferralInformation;
import com.hotyum.stars.dal.model.CustomerReferralInformationExample;
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

public interface CustomerReferralInformationMapper {
    @SelectProvider(type=CustomerReferralInformationSqlProvider.class, method="countByExample")
    long countByExample(CustomerReferralInformationExample example);

    @DeleteProvider(type=CustomerReferralInformationSqlProvider.class, method="deleteByExample")
    int deleteByExample(CustomerReferralInformationExample example);

    @Delete({
        "delete from customer_referral_information",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into customer_referral_information (gmt_create, gmt_modify, ",
        "status, contract_num, ",
        "type, recommendation_us_id, ",
        "recommendation_user_name, us_id)",
        "values (#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModify,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=TINYINT}, #{contractNum,jdbcType=INTEGER}, ",
        "#{type,jdbcType=TINYINT}, #{recommendationUsId,jdbcType=INTEGER}, ",
        "#{recommendationUserName,jdbcType=VARCHAR}, #{usId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CustomerReferralInformation record);

    @InsertProvider(type=CustomerReferralInformationSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(CustomerReferralInformation record);

    @SelectProvider(type=CustomerReferralInformationSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="contract_num", property="contractNum", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="recommendation_us_id", property="recommendationUsId", jdbcType=JdbcType.INTEGER),
        @Result(column="recommendation_user_name", property="recommendationUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="us_id", property="usId", jdbcType=JdbcType.INTEGER)
    })
    List<CustomerReferralInformation> selectByExample(CustomerReferralInformationExample example);

    @Select({
        "select",
        "id, gmt_create, gmt_modify, status, contract_num, type, recommendation_us_id, ",
        "recommendation_user_name, us_id",
        "from customer_referral_information",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="contract_num", property="contractNum", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="recommendation_us_id", property="recommendationUsId", jdbcType=JdbcType.INTEGER),
        @Result(column="recommendation_user_name", property="recommendationUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="us_id", property="usId", jdbcType=JdbcType.INTEGER)
    })
    CustomerReferralInformation selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CustomerReferralInformationSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CustomerReferralInformation record, @Param("example") CustomerReferralInformationExample example);

    @UpdateProvider(type=CustomerReferralInformationSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CustomerReferralInformation record, @Param("example") CustomerReferralInformationExample example);

    @UpdateProvider(type=CustomerReferralInformationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CustomerReferralInformation record);

    @Update({
        "update customer_referral_information",
        "set gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT},",
          "contract_num = #{contractNum,jdbcType=INTEGER},",
          "type = #{type,jdbcType=TINYINT},",
          "recommendation_us_id = #{recommendationUsId,jdbcType=INTEGER},",
          "recommendation_user_name = #{recommendationUserName,jdbcType=VARCHAR},",
          "us_id = #{usId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CustomerReferralInformation record);
}