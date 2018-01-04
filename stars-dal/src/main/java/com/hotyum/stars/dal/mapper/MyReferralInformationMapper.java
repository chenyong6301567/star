package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.MyReferralInformation;
import com.hotyum.stars.dal.model.MyReferralInformationExample;
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

public interface MyReferralInformationMapper {
    @SelectProvider(type=MyReferralInformationSqlProvider.class, method="countByExample")
    long countByExample(MyReferralInformationExample example);

    @DeleteProvider(type=MyReferralInformationSqlProvider.class, method="deleteByExample")
    int deleteByExample(MyReferralInformationExample example);

    @Delete({
        "delete from my_referral_information",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into my_referral_information (us_id, user_name, ",
        "star_degree, sum_money, ",
        "direct_reward_rate, indirect_reward_rate, ",
        "indirect_referral_number, direct_referral_number, ",
        "gmt_create, gmt_modify, ",
        "status)",
        "values (#{usId,jdbcType=INTEGER}, #{userName,jdbcType=VARCHAR}, ",
        "#{starDegree,jdbcType=TINYINT}, #{sumMoney,jdbcType=DECIMAL}, ",
        "#{directRewardRate,jdbcType=VARCHAR}, #{indirectRewardRate,jdbcType=VARCHAR}, ",
        "#{indirectReferralNumber,jdbcType=INTEGER}, #{directReferralNumber,jdbcType=INTEGER}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModify,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(MyReferralInformation record);

    @InsertProvider(type=MyReferralInformationSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(MyReferralInformation record);

    @SelectProvider(type=MyReferralInformationSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="us_id", property="usId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="star_degree", property="starDegree", jdbcType=JdbcType.TINYINT),
        @Result(column="sum_money", property="sumMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="direct_reward_rate", property="directRewardRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="indirect_reward_rate", property="indirectRewardRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="indirect_referral_number", property="indirectReferralNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="direct_referral_number", property="directReferralNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<MyReferralInformation> selectByExample(MyReferralInformationExample example);

    @Select({
        "select",
        "id, us_id, user_name, star_degree, sum_money, direct_reward_rate, indirect_reward_rate, ",
        "indirect_referral_number, direct_referral_number, gmt_create, gmt_modify, status",
        "from my_referral_information",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="us_id", property="usId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="star_degree", property="starDegree", jdbcType=JdbcType.TINYINT),
        @Result(column="sum_money", property="sumMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="direct_reward_rate", property="directRewardRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="indirect_reward_rate", property="indirectRewardRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="indirect_referral_number", property="indirectReferralNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="direct_referral_number", property="directReferralNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    MyReferralInformation selectByPrimaryKey(Integer id);

    @UpdateProvider(type=MyReferralInformationSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MyReferralInformation record, @Param("example") MyReferralInformationExample example);

    @UpdateProvider(type=MyReferralInformationSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MyReferralInformation record, @Param("example") MyReferralInformationExample example);

    @UpdateProvider(type=MyReferralInformationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MyReferralInformation record);

    @Update({
        "update my_referral_information",
        "set us_id = #{usId,jdbcType=INTEGER},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "star_degree = #{starDegree,jdbcType=TINYINT},",
          "sum_money = #{sumMoney,jdbcType=DECIMAL},",
          "direct_reward_rate = #{directRewardRate,jdbcType=VARCHAR},",
          "indirect_reward_rate = #{indirectRewardRate,jdbcType=VARCHAR},",
          "indirect_referral_number = #{indirectReferralNumber,jdbcType=INTEGER},",
          "direct_referral_number = #{directReferralNumber,jdbcType=INTEGER},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MyReferralInformation record);
}