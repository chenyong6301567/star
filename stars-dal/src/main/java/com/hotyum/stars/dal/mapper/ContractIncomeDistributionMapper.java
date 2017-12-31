package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.ContractIncomeDistribution;
import com.hotyum.stars.dal.model.ContractIncomeDistributionExample;
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

public interface ContractIncomeDistributionMapper {
    @SelectProvider(type=ContractIncomeDistributionSqlProvider.class, method="countByExample")
    long countByExample(ContractIncomeDistributionExample example);

    @DeleteProvider(type=ContractIncomeDistributionSqlProvider.class, method="deleteByExample")
    int deleteByExample(ContractIncomeDistributionExample example);

    @Delete({
        "delete from contract_income_distribution",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into contract_income_distribution (document_code, customer_name, ",
        "investment_amount, contract_income, ",
        "first_trade_date, product_type_id, ",
        "product_type_name, trade_end_date, ",
        "trade_status, product_rate, ",
        "derect_recomand_person, inderect_recomand_person, ",
        "derect_recomand_rate, inderect_recomand_rate, ",
        "agent_code, agent_rate, ",
        "customer_income, derect_income, ",
        "inderect_income, agent_income, ",
        "company_income, gmt_create, ",
        "gmt_modify, status)",
        "values (#{documentCode,jdbcType=VARCHAR}, #{customerName,jdbcType=VARCHAR}, ",
        "#{investmentAmount,jdbcType=DECIMAL}, #{contractIncome,jdbcType=DECIMAL}, ",
        "#{firstTradeDate,jdbcType=TIMESTAMP}, #{productTypeId,jdbcType=INTEGER}, ",
        "#{productTypeName,jdbcType=VARCHAR}, #{tradeEndDate,jdbcType=TIMESTAMP}, ",
        "#{tradeStatus,jdbcType=TINYINT}, #{productRate,jdbcType=VARCHAR}, ",
        "#{derectRecomandPerson,jdbcType=VARCHAR}, #{inderectRecomandPerson,jdbcType=VARCHAR}, ",
        "#{derectRecomandRate,jdbcType=VARCHAR}, #{inderectRecomandRate,jdbcType=VARCHAR}, ",
        "#{agentCode,jdbcType=VARCHAR}, #{agentRate,jdbcType=VARCHAR}, ",
        "#{customerIncome,jdbcType=DECIMAL}, #{derectIncome,jdbcType=DECIMAL}, ",
        "#{inderectIncome,jdbcType=DECIMAL}, #{agentIncome,jdbcType=DECIMAL}, ",
        "#{companyIncome,jdbcType=DECIMAL}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP}, #{status,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(ContractIncomeDistribution record);

    @InsertProvider(type=ContractIncomeDistributionSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(ContractIncomeDistribution record);

    @SelectProvider(type=ContractIncomeDistributionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="document_code", property="documentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="investment_amount", property="investmentAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="contract_income", property="contractIncome", jdbcType=JdbcType.DECIMAL),
        @Result(column="first_trade_date", property="firstTradeDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="product_type_id", property="productTypeId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_type_name", property="productTypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_end_date", property="tradeEndDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="trade_status", property="tradeStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="product_rate", property="productRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="derect_recomand_person", property="derectRecomandPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="inderect_recomand_person", property="inderectRecomandPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="derect_recomand_rate", property="derectRecomandRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="inderect_recomand_rate", property="inderectRecomandRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="agent_code", property="agentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="agent_rate", property="agentRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_income", property="customerIncome", jdbcType=JdbcType.DECIMAL),
        @Result(column="derect_income", property="derectIncome", jdbcType=JdbcType.DECIMAL),
        @Result(column="inderect_income", property="inderectIncome", jdbcType=JdbcType.DECIMAL),
        @Result(column="agent_income", property="agentIncome", jdbcType=JdbcType.DECIMAL),
        @Result(column="company_income", property="companyIncome", jdbcType=JdbcType.DECIMAL),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<ContractIncomeDistribution> selectByExample(ContractIncomeDistributionExample example);

    @Select({
        "select",
        "id, document_code, customer_name, investment_amount, contract_income, first_trade_date, ",
        "product_type_id, product_type_name, trade_end_date, trade_status, product_rate, ",
        "derect_recomand_person, inderect_recomand_person, derect_recomand_rate, inderect_recomand_rate, ",
        "agent_code, agent_rate, customer_income, derect_income, inderect_income, agent_income, ",
        "company_income, gmt_create, gmt_modify, status",
        "from contract_income_distribution",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="document_code", property="documentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="investment_amount", property="investmentAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="contract_income", property="contractIncome", jdbcType=JdbcType.DECIMAL),
        @Result(column="first_trade_date", property="firstTradeDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="product_type_id", property="productTypeId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_type_name", property="productTypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_end_date", property="tradeEndDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="trade_status", property="tradeStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="product_rate", property="productRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="derect_recomand_person", property="derectRecomandPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="inderect_recomand_person", property="inderectRecomandPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="derect_recomand_rate", property="derectRecomandRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="inderect_recomand_rate", property="inderectRecomandRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="agent_code", property="agentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="agent_rate", property="agentRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_income", property="customerIncome", jdbcType=JdbcType.DECIMAL),
        @Result(column="derect_income", property="derectIncome", jdbcType=JdbcType.DECIMAL),
        @Result(column="inderect_income", property="inderectIncome", jdbcType=JdbcType.DECIMAL),
        @Result(column="agent_income", property="agentIncome", jdbcType=JdbcType.DECIMAL),
        @Result(column="company_income", property="companyIncome", jdbcType=JdbcType.DECIMAL),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    ContractIncomeDistribution selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ContractIncomeDistributionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ContractIncomeDistribution record, @Param("example") ContractIncomeDistributionExample example);

    @UpdateProvider(type=ContractIncomeDistributionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ContractIncomeDistribution record, @Param("example") ContractIncomeDistributionExample example);

    @UpdateProvider(type=ContractIncomeDistributionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ContractIncomeDistribution record);

    @Update({
        "update contract_income_distribution",
        "set document_code = #{documentCode,jdbcType=VARCHAR},",
          "customer_name = #{customerName,jdbcType=VARCHAR},",
          "investment_amount = #{investmentAmount,jdbcType=DECIMAL},",
          "contract_income = #{contractIncome,jdbcType=DECIMAL},",
          "first_trade_date = #{firstTradeDate,jdbcType=TIMESTAMP},",
          "product_type_id = #{productTypeId,jdbcType=INTEGER},",
          "product_type_name = #{productTypeName,jdbcType=VARCHAR},",
          "trade_end_date = #{tradeEndDate,jdbcType=TIMESTAMP},",
          "trade_status = #{tradeStatus,jdbcType=TINYINT},",
          "product_rate = #{productRate,jdbcType=VARCHAR},",
          "derect_recomand_person = #{derectRecomandPerson,jdbcType=VARCHAR},",
          "inderect_recomand_person = #{inderectRecomandPerson,jdbcType=VARCHAR},",
          "derect_recomand_rate = #{derectRecomandRate,jdbcType=VARCHAR},",
          "inderect_recomand_rate = #{inderectRecomandRate,jdbcType=VARCHAR},",
          "agent_code = #{agentCode,jdbcType=VARCHAR},",
          "agent_rate = #{agentRate,jdbcType=VARCHAR},",
          "customer_income = #{customerIncome,jdbcType=DECIMAL},",
          "derect_income = #{derectIncome,jdbcType=DECIMAL},",
          "inderect_income = #{inderectIncome,jdbcType=DECIMAL},",
          "agent_income = #{agentIncome,jdbcType=DECIMAL},",
          "company_income = #{companyIncome,jdbcType=DECIMAL},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ContractIncomeDistribution record);
}