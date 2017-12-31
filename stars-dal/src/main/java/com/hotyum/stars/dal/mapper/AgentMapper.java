package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.Agent;
import com.hotyum.stars.dal.model.AgentExample;
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

public interface AgentMapper {
    @SelectProvider(type=AgentSqlProvider.class, method="countByExample")
    long countByExample(AgentExample example);

    @DeleteProvider(type=AgentSqlProvider.class, method="deleteByExample")
    int deleteByExample(AgentExample example);

    @Delete({
        "delete from agent",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into agent (agent_code, agent_name, ",
        "unified_social_credit_code, legal_representative, ",
        "province_id, province_name, ",
        "contact, business_address, ",
        "business_start_time, business_end_time, ",
        "contract_start_time, contrct_end_time)",
        "values (#{agentCode,jdbcType=VARCHAR}, #{agentName,jdbcType=VARCHAR}, ",
        "#{unifiedSocialCreditCode,jdbcType=VARCHAR}, #{legalRepresentative,jdbcType=VARCHAR}, ",
        "#{provinceId,jdbcType=INTEGER}, #{provinceName,jdbcType=VARCHAR}, ",
        "#{contact,jdbcType=VARCHAR}, #{businessAddress,jdbcType=VARCHAR}, ",
        "#{businessStartTime,jdbcType=TIMESTAMP}, #{businessEndTime,jdbcType=TIMESTAMP}, ",
        "#{contractStartTime,jdbcType=TIMESTAMP}, #{contrctEndTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Agent record);

    @InsertProvider(type=AgentSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Agent record);

    @SelectProvider(type=AgentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="agent_code", property="agentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="agent_name", property="agentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="unified_social_credit_code", property="unifiedSocialCreditCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="legal_representative", property="legalRepresentative", jdbcType=JdbcType.VARCHAR),
        @Result(column="province_id", property="provinceId", jdbcType=JdbcType.INTEGER),
        @Result(column="province_name", property="provinceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_address", property="businessAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_start_time", property="businessStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="business_end_time", property="businessEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="contract_start_time", property="contractStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="contrct_end_time", property="contrctEndTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Agent> selectByExample(AgentExample example);

    @Select({
        "select",
        "id, agent_code, agent_name, unified_social_credit_code, legal_representative, ",
        "province_id, province_name, contact, business_address, business_start_time, ",
        "business_end_time, contract_start_time, contrct_end_time",
        "from agent",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="agent_code", property="agentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="agent_name", property="agentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="unified_social_credit_code", property="unifiedSocialCreditCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="legal_representative", property="legalRepresentative", jdbcType=JdbcType.VARCHAR),
        @Result(column="province_id", property="provinceId", jdbcType=JdbcType.INTEGER),
        @Result(column="province_name", property="provinceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_address", property="businessAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_start_time", property="businessStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="business_end_time", property="businessEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="contract_start_time", property="contractStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="contrct_end_time", property="contrctEndTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Agent selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AgentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Agent record, @Param("example") AgentExample example);

    @UpdateProvider(type=AgentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Agent record, @Param("example") AgentExample example);

    @UpdateProvider(type=AgentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Agent record);

    @Update({
        "update agent",
        "set agent_code = #{agentCode,jdbcType=VARCHAR},",
          "agent_name = #{agentName,jdbcType=VARCHAR},",
          "unified_social_credit_code = #{unifiedSocialCreditCode,jdbcType=VARCHAR},",
          "legal_representative = #{legalRepresentative,jdbcType=VARCHAR},",
          "province_id = #{provinceId,jdbcType=INTEGER},",
          "province_name = #{provinceName,jdbcType=VARCHAR},",
          "contact = #{contact,jdbcType=VARCHAR},",
          "business_address = #{businessAddress,jdbcType=VARCHAR},",
          "business_start_time = #{businessStartTime,jdbcType=TIMESTAMP},",
          "business_end_time = #{businessEndTime,jdbcType=TIMESTAMP},",
          "contract_start_time = #{contractStartTime,jdbcType=TIMESTAMP},",
          "contrct_end_time = #{contrctEndTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Agent record);
}