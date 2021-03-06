package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.User;
import com.hotyum.stars.dal.model.UserExample;
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

public interface UserMapper {
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    long countByExample(UserExample example);

    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user (account, pwd, ",
        "contact_phone, email, ",
        "check_email, sex, ",
        "real_name, whether_real_name, ",
        "wheather_get_money, sum_money, ",
        "gmt_create, gmt_modify, ",
        "status, referee_qualification, ",
        "agent_code, agent_name, ",
        "direct_recommendation_account, indirect_recommendation_account, ",
        "certificate_type, certificate_number, ",
        "certificate_front, certificate_back, ",
        "address_pic, user_name, ",
        "user_type, whether_freeze, ",
        "freeze_date, customer_agent)",
        "values (#{account,jdbcType=VARCHAR}, #{pwd,jdbcType=VARCHAR}, ",
        "#{contactPhone,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{checkEmail,jdbcType=TINYINT}, #{sex,jdbcType=TINYINT}, ",
        "#{realName,jdbcType=VARCHAR}, #{whetherRealName,jdbcType=TINYINT}, ",
        "#{wheatherGetMoney,jdbcType=TINYINT}, #{sumMoney,jdbcType=DECIMAL}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModify,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=TINYINT}, #{refereeQualification,jdbcType=TINYINT}, ",
        "#{agentCode,jdbcType=VARCHAR}, #{agentName,jdbcType=VARCHAR}, ",
        "#{directRecommendationAccount,jdbcType=VARCHAR}, #{indirectRecommendationAccount,jdbcType=VARCHAR}, ",
        "#{certificateType,jdbcType=TINYINT}, #{certificateNumber,jdbcType=VARCHAR}, ",
        "#{certificateFront,jdbcType=VARCHAR}, #{certificateBack,jdbcType=VARCHAR}, ",
        "#{addressPic,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{userType,jdbcType=TINYINT}, #{whetherFreeze,jdbcType=TINYINT}, ",
        "#{freezeDate,jdbcType=TIMESTAMP}, #{customerAgent,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(User record);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_email", property="checkEmail", jdbcType=JdbcType.TINYINT),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="whether_real_name", property="whetherRealName", jdbcType=JdbcType.TINYINT),
        @Result(column="wheather_get_money", property="wheatherGetMoney", jdbcType=JdbcType.TINYINT),
        @Result(column="sum_money", property="sumMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="referee_qualification", property="refereeQualification", jdbcType=JdbcType.TINYINT),
        @Result(column="agent_code", property="agentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="agent_name", property="agentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="direct_recommendation_account", property="directRecommendationAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="indirect_recommendation_account", property="indirectRecommendationAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="certificate_type", property="certificateType", jdbcType=JdbcType.TINYINT),
        @Result(column="certificate_number", property="certificateNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="certificate_front", property="certificateFront", jdbcType=JdbcType.VARCHAR),
        @Result(column="certificate_back", property="certificateBack", jdbcType=JdbcType.VARCHAR),
        @Result(column="address_pic", property="addressPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_type", property="userType", jdbcType=JdbcType.TINYINT),
        @Result(column="whether_freeze", property="whetherFreeze", jdbcType=JdbcType.TINYINT),
        @Result(column="freeze_date", property="freezeDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="customer_agent", property="customerAgent", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "id, account, pwd, contact_phone, email, check_email, sex, real_name, whether_real_name, ",
        "wheather_get_money, sum_money, gmt_create, gmt_modify, status, referee_qualification, ",
        "agent_code, agent_name, direct_recommendation_account, indirect_recommendation_account, ",
        "certificate_type, certificate_number, certificate_front, certificate_back, address_pic, ",
        "user_name, user_type, whether_freeze, freeze_date, customer_agent",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_email", property="checkEmail", jdbcType=JdbcType.TINYINT),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="whether_real_name", property="whetherRealName", jdbcType=JdbcType.TINYINT),
        @Result(column="wheather_get_money", property="wheatherGetMoney", jdbcType=JdbcType.TINYINT),
        @Result(column="sum_money", property="sumMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="referee_qualification", property="refereeQualification", jdbcType=JdbcType.TINYINT),
        @Result(column="agent_code", property="agentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="agent_name", property="agentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="direct_recommendation_account", property="directRecommendationAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="indirect_recommendation_account", property="indirectRecommendationAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="certificate_type", property="certificateType", jdbcType=JdbcType.TINYINT),
        @Result(column="certificate_number", property="certificateNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="certificate_front", property="certificateFront", jdbcType=JdbcType.VARCHAR),
        @Result(column="certificate_back", property="certificateBack", jdbcType=JdbcType.VARCHAR),
        @Result(column="address_pic", property="addressPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_type", property="userType", jdbcType=JdbcType.TINYINT),
        @Result(column="whether_freeze", property="whetherFreeze", jdbcType=JdbcType.TINYINT),
        @Result(column="freeze_date", property="freezeDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="customer_agent", property="customerAgent", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set account = #{account,jdbcType=VARCHAR},",
          "pwd = #{pwd,jdbcType=VARCHAR},",
          "contact_phone = #{contactPhone,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "check_email = #{checkEmail,jdbcType=TINYINT},",
          "sex = #{sex,jdbcType=TINYINT},",
          "real_name = #{realName,jdbcType=VARCHAR},",
          "whether_real_name = #{whetherRealName,jdbcType=TINYINT},",
          "wheather_get_money = #{wheatherGetMoney,jdbcType=TINYINT},",
          "sum_money = #{sumMoney,jdbcType=DECIMAL},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT},",
          "referee_qualification = #{refereeQualification,jdbcType=TINYINT},",
          "agent_code = #{agentCode,jdbcType=VARCHAR},",
          "agent_name = #{agentName,jdbcType=VARCHAR},",
          "direct_recommendation_account = #{directRecommendationAccount,jdbcType=VARCHAR},",
          "indirect_recommendation_account = #{indirectRecommendationAccount,jdbcType=VARCHAR},",
          "certificate_type = #{certificateType,jdbcType=TINYINT},",
          "certificate_number = #{certificateNumber,jdbcType=VARCHAR},",
          "certificate_front = #{certificateFront,jdbcType=VARCHAR},",
          "certificate_back = #{certificateBack,jdbcType=VARCHAR},",
          "address_pic = #{addressPic,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "user_type = #{userType,jdbcType=TINYINT},",
          "whether_freeze = #{whetherFreeze,jdbcType=TINYINT},",
          "freeze_date = #{freezeDate,jdbcType=TIMESTAMP},",
          "customer_agent = #{customerAgent,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}