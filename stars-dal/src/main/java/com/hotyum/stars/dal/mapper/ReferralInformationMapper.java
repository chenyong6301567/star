package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.ReferralInformation;
import com.hotyum.stars.dal.model.ReferralInformationExample;
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

public interface ReferralInformationMapper {
    @SelectProvider(type=ReferralInformationSqlProvider.class, method="countByExample")
    long countByExample(ReferralInformationExample example);

    @DeleteProvider(type=ReferralInformationSqlProvider.class, method="deleteByExample")
    int deleteByExample(ReferralInformationExample example);

    @Delete({
        "delete from referral_information",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into referral_information (us_id, user_name, ",
        "star_degree, sum_money, ",
        "direct_reward_rate, contract_number, ",
        "referral_number, gmt_create, ",
        "gmt_modify, status, ",
        "direct_recommendation_id, direct_recommendation_name, ",
        "indirect_recommendation_id, indirect_recommendation_name)",
        "values (#{usId,jdbcType=INTEGER}, #{userName,jdbcType=VARCHAR}, ",
        "#{starDegree,jdbcType=TINYINT}, #{sumMoney,jdbcType=DECIMAL}, ",
        "#{directRewardRate,jdbcType=VARCHAR}, #{contractNumber,jdbcType=INTEGER}, ",
        "#{referralNumber,jdbcType=INTEGER}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP}, #{status,jdbcType=TINYINT}, ",
        "#{directRecommendationId,jdbcType=INTEGER}, #{directRecommendationName,jdbcType=VARCHAR}, ",
        "#{indirectRecommendationId,jdbcType=INTEGER}, #{indirectRecommendationName,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(ReferralInformation record);

    @InsertProvider(type=ReferralInformationSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(ReferralInformation record);

    @SelectProvider(type=ReferralInformationSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="us_id", property="usId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="star_degree", property="starDegree", jdbcType=JdbcType.TINYINT),
        @Result(column="sum_money", property="sumMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="direct_reward_rate", property="directRewardRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="contract_number", property="contractNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="referral_number", property="referralNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="direct_recommendation_id", property="directRecommendationId", jdbcType=JdbcType.INTEGER),
        @Result(column="direct_recommendation_name", property="directRecommendationName", jdbcType=JdbcType.VARCHAR),
        @Result(column="indirect_recommendation_id", property="indirectRecommendationId", jdbcType=JdbcType.INTEGER),
        @Result(column="indirect_recommendation_name", property="indirectRecommendationName", jdbcType=JdbcType.VARCHAR)
    })
    List<ReferralInformation> selectByExample(ReferralInformationExample example);

    @Select({
        "select",
        "id, us_id, user_name, star_degree, sum_money, direct_reward_rate, contract_number, ",
        "referral_number, gmt_create, gmt_modify, status, direct_recommendation_id, direct_recommendation_name, ",
        "indirect_recommendation_id, indirect_recommendation_name",
        "from referral_information",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="us_id", property="usId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="star_degree", property="starDegree", jdbcType=JdbcType.TINYINT),
        @Result(column="sum_money", property="sumMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="direct_reward_rate", property="directRewardRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="contract_number", property="contractNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="referral_number", property="referralNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="direct_recommendation_id", property="directRecommendationId", jdbcType=JdbcType.INTEGER),
        @Result(column="direct_recommendation_name", property="directRecommendationName", jdbcType=JdbcType.VARCHAR),
        @Result(column="indirect_recommendation_id", property="indirectRecommendationId", jdbcType=JdbcType.INTEGER),
        @Result(column="indirect_recommendation_name", property="indirectRecommendationName", jdbcType=JdbcType.VARCHAR)
    })
    ReferralInformation selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ReferralInformationSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ReferralInformation record, @Param("example") ReferralInformationExample example);

    @UpdateProvider(type=ReferralInformationSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ReferralInformation record, @Param("example") ReferralInformationExample example);

    @UpdateProvider(type=ReferralInformationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ReferralInformation record);

    @Update({
        "update referral_information",
        "set us_id = #{usId,jdbcType=INTEGER},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "star_degree = #{starDegree,jdbcType=TINYINT},",
          "sum_money = #{sumMoney,jdbcType=DECIMAL},",
          "direct_reward_rate = #{directRewardRate,jdbcType=VARCHAR},",
          "contract_number = #{contractNumber,jdbcType=INTEGER},",
          "referral_number = #{referralNumber,jdbcType=INTEGER},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT},",
          "direct_recommendation_id = #{directRecommendationId,jdbcType=INTEGER},",
          "direct_recommendation_name = #{directRecommendationName,jdbcType=VARCHAR},",
          "indirect_recommendation_id = #{indirectRecommendationId,jdbcType=INTEGER},",
          "indirect_recommendation_name = #{indirectRecommendationName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ReferralInformation record);
}