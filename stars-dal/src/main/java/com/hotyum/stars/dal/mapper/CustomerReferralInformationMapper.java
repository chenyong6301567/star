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
        "status, direct_recommendation_id, ",
        "direct_recommendation_name, indirect_recommendation_id, ",
        "indirect_recommendation_name, contract_num)",
        "values (#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModify,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=TINYINT}, #{directRecommendationId,jdbcType=INTEGER}, ",
        "#{directRecommendationName,jdbcType=VARCHAR}, #{indirectRecommendationId,jdbcType=INTEGER}, ",
        "#{indirectRecommendationName,jdbcType=VARCHAR}, #{contractNum,jdbcType=INTEGER})"
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
        @Result(column="direct_recommendation_id", property="directRecommendationId", jdbcType=JdbcType.INTEGER),
        @Result(column="direct_recommendation_name", property="directRecommendationName", jdbcType=JdbcType.VARCHAR),
        @Result(column="indirect_recommendation_id", property="indirectRecommendationId", jdbcType=JdbcType.INTEGER),
        @Result(column="indirect_recommendation_name", property="indirectRecommendationName", jdbcType=JdbcType.VARCHAR),
        @Result(column="contract_num", property="contractNum", jdbcType=JdbcType.INTEGER)
    })
    List<CustomerReferralInformation> selectByExample(CustomerReferralInformationExample example);

    @Select({
        "select",
        "id, gmt_create, gmt_modify, status, direct_recommendation_id, direct_recommendation_name, ",
        "indirect_recommendation_id, indirect_recommendation_name, contract_num",
        "from customer_referral_information",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="direct_recommendation_id", property="directRecommendationId", jdbcType=JdbcType.INTEGER),
        @Result(column="direct_recommendation_name", property="directRecommendationName", jdbcType=JdbcType.VARCHAR),
        @Result(column="indirect_recommendation_id", property="indirectRecommendationId", jdbcType=JdbcType.INTEGER),
        @Result(column="indirect_recommendation_name", property="indirectRecommendationName", jdbcType=JdbcType.VARCHAR),
        @Result(column="contract_num", property="contractNum", jdbcType=JdbcType.INTEGER)
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
          "direct_recommendation_id = #{directRecommendationId,jdbcType=INTEGER},",
          "direct_recommendation_name = #{directRecommendationName,jdbcType=VARCHAR},",
          "indirect_recommendation_id = #{indirectRecommendationId,jdbcType=INTEGER},",
          "indirect_recommendation_name = #{indirectRecommendationName,jdbcType=VARCHAR},",
          "contract_num = #{contractNum,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CustomerReferralInformation record);
}