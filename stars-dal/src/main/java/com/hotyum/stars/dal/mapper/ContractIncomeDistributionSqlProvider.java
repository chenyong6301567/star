package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.ContractIncomeDistribution;
import com.hotyum.stars.dal.model.ContractIncomeDistributionExample.Criteria;
import com.hotyum.stars.dal.model.ContractIncomeDistributionExample.Criterion;
import com.hotyum.stars.dal.model.ContractIncomeDistributionExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ContractIncomeDistributionSqlProvider {

    public String countByExample(ContractIncomeDistributionExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("contract_income_distribution");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ContractIncomeDistributionExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("contract_income_distribution");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ContractIncomeDistribution record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("contract_income_distribution");
        
        if (record.getDocumentCode() != null) {
            sql.VALUES("document_code", "#{documentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerName() != null) {
            sql.VALUES("customer_name", "#{customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getInvestmentAmount() != null) {
            sql.VALUES("investment_amount", "#{investmentAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getContractIncome() != null) {
            sql.VALUES("contract_income", "#{contractIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getTradePlatform() != null) {
            sql.VALUES("trade_platform", "#{tradePlatform,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeAccount() != null) {
            sql.VALUES("trade_account", "#{tradeAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getFirstTradeDate() != null) {
            sql.VALUES("first_trade_date", "#{firstTradeDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProductTypeId() != null) {
            sql.VALUES("product_type_id", "#{productTypeId,jdbcType=INTEGER}");
        }
        
        if (record.getProductTypeName() != null) {
            sql.VALUES("product_type_name", "#{productTypeName,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeEndDate() != null) {
            sql.VALUES("trade_end_date", "#{tradeEndDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTradeStatus() != null) {
            sql.VALUES("trade_status", "#{tradeStatus,jdbcType=TINYINT}");
        }
        
        if (record.getProductRate() != null) {
            sql.VALUES("product_rate", "#{productRate,jdbcType=VARCHAR}");
        }
        
        if (record.getDerectRecomandPersonId() != null) {
            sql.VALUES("derect_recomand_person_id", "#{derectRecomandPersonId,jdbcType=INTEGER}");
        }
        
        if (record.getDerectRecomandPersonName() != null) {
            sql.VALUES("derect_recomand_person_name", "#{derectRecomandPersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getInderectRecomandPersonId() != null) {
            sql.VALUES("inderect_recomand_person_id", "#{inderectRecomandPersonId,jdbcType=INTEGER}");
        }
        
        if (record.getInderectRecomandPersonName() != null) {
            sql.VALUES("inderect_recomand_person_name", "#{inderectRecomandPersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getDerectRecomandRate() != null) {
            sql.VALUES("derect_recomand_rate", "#{derectRecomandRate,jdbcType=VARCHAR}");
        }
        
        if (record.getInderectRecomandRate() != null) {
            sql.VALUES("inderect_recomand_rate", "#{inderectRecomandRate,jdbcType=VARCHAR}");
        }
        
        if (record.getAgentCode() != null) {
            sql.VALUES("agent_code", "#{agentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAgentRate() != null) {
            sql.VALUES("agent_rate", "#{agentRate,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerIncome() != null) {
            sql.VALUES("customer_income", "#{customerIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getDerectIncome() != null) {
            sql.VALUES("derect_income", "#{derectIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getInderectIncome() != null) {
            sql.VALUES("inderect_income", "#{inderectIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getAgentIncome() != null) {
            sql.VALUES("agent_income", "#{agentIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getCompanyIncome() != null) {
            sql.VALUES("company_income", "#{companyIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.VALUES("gmt_modify", "#{gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ContractIncomeDistributionExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("document_code");
        sql.SELECT("customer_name");
        sql.SELECT("investment_amount");
        sql.SELECT("contract_income");
        sql.SELECT("trade_platform");
        sql.SELECT("trade_account");
        sql.SELECT("first_trade_date");
        sql.SELECT("product_type_id");
        sql.SELECT("product_type_name");
        sql.SELECT("trade_end_date");
        sql.SELECT("trade_status");
        sql.SELECT("product_rate");
        sql.SELECT("derect_recomand_person_id");
        sql.SELECT("derect_recomand_person_name");
        sql.SELECT("inderect_recomand_person_id");
        sql.SELECT("inderect_recomand_person_name");
        sql.SELECT("derect_recomand_rate");
        sql.SELECT("inderect_recomand_rate");
        sql.SELECT("agent_code");
        sql.SELECT("agent_rate");
        sql.SELECT("customer_income");
        sql.SELECT("derect_income");
        sql.SELECT("inderect_income");
        sql.SELECT("agent_income");
        sql.SELECT("company_income");
        sql.SELECT("gmt_create");
        sql.SELECT("gmt_modify");
        sql.SELECT("status");
        sql.SELECT("user_id");
        sql.FROM("contract_income_distribution");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ContractIncomeDistribution record = (ContractIncomeDistribution) parameter.get("record");
        ContractIncomeDistributionExample example = (ContractIncomeDistributionExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("contract_income_distribution");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getDocumentCode() != null) {
            sql.SET("document_code = #{record.documentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerName() != null) {
            sql.SET("customer_name = #{record.customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getInvestmentAmount() != null) {
            sql.SET("investment_amount = #{record.investmentAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getContractIncome() != null) {
            sql.SET("contract_income = #{record.contractIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getTradePlatform() != null) {
            sql.SET("trade_platform = #{record.tradePlatform,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeAccount() != null) {
            sql.SET("trade_account = #{record.tradeAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getFirstTradeDate() != null) {
            sql.SET("first_trade_date = #{record.firstTradeDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProductTypeId() != null) {
            sql.SET("product_type_id = #{record.productTypeId,jdbcType=INTEGER}");
        }
        
        if (record.getProductTypeName() != null) {
            sql.SET("product_type_name = #{record.productTypeName,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeEndDate() != null) {
            sql.SET("trade_end_date = #{record.tradeEndDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTradeStatus() != null) {
            sql.SET("trade_status = #{record.tradeStatus,jdbcType=TINYINT}");
        }
        
        if (record.getProductRate() != null) {
            sql.SET("product_rate = #{record.productRate,jdbcType=VARCHAR}");
        }
        
        if (record.getDerectRecomandPersonId() != null) {
            sql.SET("derect_recomand_person_id = #{record.derectRecomandPersonId,jdbcType=INTEGER}");
        }
        
        if (record.getDerectRecomandPersonName() != null) {
            sql.SET("derect_recomand_person_name = #{record.derectRecomandPersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getInderectRecomandPersonId() != null) {
            sql.SET("inderect_recomand_person_id = #{record.inderectRecomandPersonId,jdbcType=INTEGER}");
        }
        
        if (record.getInderectRecomandPersonName() != null) {
            sql.SET("inderect_recomand_person_name = #{record.inderectRecomandPersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getDerectRecomandRate() != null) {
            sql.SET("derect_recomand_rate = #{record.derectRecomandRate,jdbcType=VARCHAR}");
        }
        
        if (record.getInderectRecomandRate() != null) {
            sql.SET("inderect_recomand_rate = #{record.inderectRecomandRate,jdbcType=VARCHAR}");
        }
        
        if (record.getAgentCode() != null) {
            sql.SET("agent_code = #{record.agentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAgentRate() != null) {
            sql.SET("agent_rate = #{record.agentRate,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerIncome() != null) {
            sql.SET("customer_income = #{record.customerIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getDerectIncome() != null) {
            sql.SET("derect_income = #{record.derectIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getInderectIncome() != null) {
            sql.SET("inderect_income = #{record.inderectIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getAgentIncome() != null) {
            sql.SET("agent_income = #{record.agentIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getCompanyIncome() != null) {
            sql.SET("company_income = #{record.companyIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.SET("gmt_modify = #{record.gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("contract_income_distribution");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("document_code = #{record.documentCode,jdbcType=VARCHAR}");
        sql.SET("customer_name = #{record.customerName,jdbcType=VARCHAR}");
        sql.SET("investment_amount = #{record.investmentAmount,jdbcType=DECIMAL}");
        sql.SET("contract_income = #{record.contractIncome,jdbcType=DECIMAL}");
        sql.SET("trade_platform = #{record.tradePlatform,jdbcType=VARCHAR}");
        sql.SET("trade_account = #{record.tradeAccount,jdbcType=VARCHAR}");
        sql.SET("first_trade_date = #{record.firstTradeDate,jdbcType=TIMESTAMP}");
        sql.SET("product_type_id = #{record.productTypeId,jdbcType=INTEGER}");
        sql.SET("product_type_name = #{record.productTypeName,jdbcType=VARCHAR}");
        sql.SET("trade_end_date = #{record.tradeEndDate,jdbcType=TIMESTAMP}");
        sql.SET("trade_status = #{record.tradeStatus,jdbcType=TINYINT}");
        sql.SET("product_rate = #{record.productRate,jdbcType=VARCHAR}");
        sql.SET("derect_recomand_person_id = #{record.derectRecomandPersonId,jdbcType=INTEGER}");
        sql.SET("derect_recomand_person_name = #{record.derectRecomandPersonName,jdbcType=VARCHAR}");
        sql.SET("inderect_recomand_person_id = #{record.inderectRecomandPersonId,jdbcType=INTEGER}");
        sql.SET("inderect_recomand_person_name = #{record.inderectRecomandPersonName,jdbcType=VARCHAR}");
        sql.SET("derect_recomand_rate = #{record.derectRecomandRate,jdbcType=VARCHAR}");
        sql.SET("inderect_recomand_rate = #{record.inderectRecomandRate,jdbcType=VARCHAR}");
        sql.SET("agent_code = #{record.agentCode,jdbcType=VARCHAR}");
        sql.SET("agent_rate = #{record.agentRate,jdbcType=VARCHAR}");
        sql.SET("customer_income = #{record.customerIncome,jdbcType=DECIMAL}");
        sql.SET("derect_income = #{record.derectIncome,jdbcType=DECIMAL}");
        sql.SET("inderect_income = #{record.inderectIncome,jdbcType=DECIMAL}");
        sql.SET("agent_income = #{record.agentIncome,jdbcType=DECIMAL}");
        sql.SET("company_income = #{record.companyIncome,jdbcType=DECIMAL}");
        sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        sql.SET("gmt_modify = #{record.gmtModify,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("user_id = #{record.userId,jdbcType=INTEGER}");
        
        ContractIncomeDistributionExample example = (ContractIncomeDistributionExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ContractIncomeDistribution record) {
        SQL sql = new SQL();
        sql.UPDATE("contract_income_distribution");
        
        if (record.getDocumentCode() != null) {
            sql.SET("document_code = #{documentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerName() != null) {
            sql.SET("customer_name = #{customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getInvestmentAmount() != null) {
            sql.SET("investment_amount = #{investmentAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getContractIncome() != null) {
            sql.SET("contract_income = #{contractIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getTradePlatform() != null) {
            sql.SET("trade_platform = #{tradePlatform,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeAccount() != null) {
            sql.SET("trade_account = #{tradeAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getFirstTradeDate() != null) {
            sql.SET("first_trade_date = #{firstTradeDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProductTypeId() != null) {
            sql.SET("product_type_id = #{productTypeId,jdbcType=INTEGER}");
        }
        
        if (record.getProductTypeName() != null) {
            sql.SET("product_type_name = #{productTypeName,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeEndDate() != null) {
            sql.SET("trade_end_date = #{tradeEndDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTradeStatus() != null) {
            sql.SET("trade_status = #{tradeStatus,jdbcType=TINYINT}");
        }
        
        if (record.getProductRate() != null) {
            sql.SET("product_rate = #{productRate,jdbcType=VARCHAR}");
        }
        
        if (record.getDerectRecomandPersonId() != null) {
            sql.SET("derect_recomand_person_id = #{derectRecomandPersonId,jdbcType=INTEGER}");
        }
        
        if (record.getDerectRecomandPersonName() != null) {
            sql.SET("derect_recomand_person_name = #{derectRecomandPersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getInderectRecomandPersonId() != null) {
            sql.SET("inderect_recomand_person_id = #{inderectRecomandPersonId,jdbcType=INTEGER}");
        }
        
        if (record.getInderectRecomandPersonName() != null) {
            sql.SET("inderect_recomand_person_name = #{inderectRecomandPersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getDerectRecomandRate() != null) {
            sql.SET("derect_recomand_rate = #{derectRecomandRate,jdbcType=VARCHAR}");
        }
        
        if (record.getInderectRecomandRate() != null) {
            sql.SET("inderect_recomand_rate = #{inderectRecomandRate,jdbcType=VARCHAR}");
        }
        
        if (record.getAgentCode() != null) {
            sql.SET("agent_code = #{agentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAgentRate() != null) {
            sql.SET("agent_rate = #{agentRate,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerIncome() != null) {
            sql.SET("customer_income = #{customerIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getDerectIncome() != null) {
            sql.SET("derect_income = #{derectIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getInderectIncome() != null) {
            sql.SET("inderect_income = #{inderectIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getAgentIncome() != null) {
            sql.SET("agent_income = #{agentIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getCompanyIncome() != null) {
            sql.SET("company_income = #{companyIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.SET("gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ContractIncomeDistributionExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}