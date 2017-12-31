package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.PersonDocument;
import com.hotyum.stars.dal.model.PersonDocumentExample;
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

public interface PersonDocumentMapper {
    @SelectProvider(type=PersonDocumentSqlProvider.class, method="countByExample")
    long countByExample(PersonDocumentExample example);

    @DeleteProvider(type=PersonDocumentSqlProvider.class, method="deleteByExample")
    int deleteByExample(PersonDocumentExample example);

    @Delete({
        "delete from person_document",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into person_document (document_code, customer_name, ",
        "trade_platform, trade_account, ",
        "wheather_get_money, get_money_date, ",
        "certificate_type, certificate_number, ",
        "contract_date, product_type, ",
        "product_rate, service_date, ",
        "buy_num, investment_amount, ",
        "estimated_earnings, contact_phone, ",
        "register_email, agent_code, ",
        "derect_recomand_person, inderect_recomand_person)",
        "values (#{documentCode,jdbcType=VARCHAR}, #{customerName,jdbcType=VARCHAR}, ",
        "#{tradePlatform,jdbcType=VARCHAR}, #{tradeAccount,jdbcType=VARCHAR}, ",
        "#{wheatherGetMoney,jdbcType=TINYINT}, #{getMoneyDate,jdbcType=TIMESTAMP}, ",
        "#{certificateType,jdbcType=TINYINT}, #{certificateNumber,jdbcType=VARCHAR}, ",
        "#{contractDate,jdbcType=TIMESTAMP}, #{productType,jdbcType=VARCHAR}, ",
        "#{productRate,jdbcType=VARCHAR}, #{serviceDate,jdbcType=TINYINT}, ",
        "#{buyNum,jdbcType=INTEGER}, #{investmentAmount,jdbcType=DECIMAL}, ",
        "#{estimatedEarnings,jdbcType=DECIMAL}, #{contactPhone,jdbcType=INTEGER}, ",
        "#{registerEmail,jdbcType=VARCHAR}, #{agentCode,jdbcType=VARCHAR}, ",
        "#{derectRecomandPerson,jdbcType=VARCHAR}, #{inderectRecomandPerson,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(PersonDocument record);

    @InsertProvider(type=PersonDocumentSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(PersonDocument record);

    @SelectProvider(type=PersonDocumentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="document_code", property="documentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_platform", property="tradePlatform", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_account", property="tradeAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="wheather_get_money", property="wheatherGetMoney", jdbcType=JdbcType.TINYINT),
        @Result(column="get_money_date", property="getMoneyDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="certificate_type", property="certificateType", jdbcType=JdbcType.TINYINT),
        @Result(column="certificate_number", property="certificateNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="contract_date", property="contractDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="product_type", property="productType", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_rate", property="productRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_date", property="serviceDate", jdbcType=JdbcType.TINYINT),
        @Result(column="buy_num", property="buyNum", jdbcType=JdbcType.INTEGER),
        @Result(column="investment_amount", property="investmentAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="estimated_earnings", property="estimatedEarnings", jdbcType=JdbcType.DECIMAL),
        @Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.INTEGER),
        @Result(column="register_email", property="registerEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="agent_code", property="agentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="derect_recomand_person", property="derectRecomandPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="inderect_recomand_person", property="inderectRecomandPerson", jdbcType=JdbcType.VARCHAR)
    })
    List<PersonDocument> selectByExample(PersonDocumentExample example);

    @Select({
        "select",
        "id, document_code, customer_name, trade_platform, trade_account, wheather_get_money, ",
        "get_money_date, certificate_type, certificate_number, contract_date, product_type, ",
        "product_rate, service_date, buy_num, investment_amount, estimated_earnings, ",
        "contact_phone, register_email, agent_code, derect_recomand_person, inderect_recomand_person",
        "from person_document",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="document_code", property="documentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_platform", property="tradePlatform", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_account", property="tradeAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="wheather_get_money", property="wheatherGetMoney", jdbcType=JdbcType.TINYINT),
        @Result(column="get_money_date", property="getMoneyDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="certificate_type", property="certificateType", jdbcType=JdbcType.TINYINT),
        @Result(column="certificate_number", property="certificateNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="contract_date", property="contractDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="product_type", property="productType", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_rate", property="productRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_date", property="serviceDate", jdbcType=JdbcType.TINYINT),
        @Result(column="buy_num", property="buyNum", jdbcType=JdbcType.INTEGER),
        @Result(column="investment_amount", property="investmentAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="estimated_earnings", property="estimatedEarnings", jdbcType=JdbcType.DECIMAL),
        @Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.INTEGER),
        @Result(column="register_email", property="registerEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="agent_code", property="agentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="derect_recomand_person", property="derectRecomandPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="inderect_recomand_person", property="inderectRecomandPerson", jdbcType=JdbcType.VARCHAR)
    })
    PersonDocument selectByPrimaryKey(Integer id);

    @UpdateProvider(type=PersonDocumentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PersonDocument record, @Param("example") PersonDocumentExample example);

    @UpdateProvider(type=PersonDocumentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PersonDocument record, @Param("example") PersonDocumentExample example);

    @UpdateProvider(type=PersonDocumentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PersonDocument record);

    @Update({
        "update person_document",
        "set document_code = #{documentCode,jdbcType=VARCHAR},",
          "customer_name = #{customerName,jdbcType=VARCHAR},",
          "trade_platform = #{tradePlatform,jdbcType=VARCHAR},",
          "trade_account = #{tradeAccount,jdbcType=VARCHAR},",
          "wheather_get_money = #{wheatherGetMoney,jdbcType=TINYINT},",
          "get_money_date = #{getMoneyDate,jdbcType=TIMESTAMP},",
          "certificate_type = #{certificateType,jdbcType=TINYINT},",
          "certificate_number = #{certificateNumber,jdbcType=VARCHAR},",
          "contract_date = #{contractDate,jdbcType=TIMESTAMP},",
          "product_type = #{productType,jdbcType=VARCHAR},",
          "product_rate = #{productRate,jdbcType=VARCHAR},",
          "service_date = #{serviceDate,jdbcType=TINYINT},",
          "buy_num = #{buyNum,jdbcType=INTEGER},",
          "investment_amount = #{investmentAmount,jdbcType=DECIMAL},",
          "estimated_earnings = #{estimatedEarnings,jdbcType=DECIMAL},",
          "contact_phone = #{contactPhone,jdbcType=INTEGER},",
          "register_email = #{registerEmail,jdbcType=VARCHAR},",
          "agent_code = #{agentCode,jdbcType=VARCHAR},",
          "derect_recomand_person = #{derectRecomandPerson,jdbcType=VARCHAR},",
          "inderect_recomand_person = #{inderectRecomandPerson,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PersonDocument record);
}