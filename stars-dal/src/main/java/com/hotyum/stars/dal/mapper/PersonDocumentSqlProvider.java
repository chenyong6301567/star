package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.PersonDocument;
import com.hotyum.stars.dal.model.PersonDocumentExample.Criteria;
import com.hotyum.stars.dal.model.PersonDocumentExample.Criterion;
import com.hotyum.stars.dal.model.PersonDocumentExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class PersonDocumentSqlProvider {

    public String countByExample(PersonDocumentExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("person_document");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(PersonDocumentExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("person_document");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(PersonDocument record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("person_document");
        
        if (record.getDocumentCode() != null) {
            sql.VALUES("document_code", "#{documentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerName() != null) {
            sql.VALUES("customer_name", "#{customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getTradePlatform() != null) {
            sql.VALUES("trade_platform", "#{tradePlatform,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeAccount() != null) {
            sql.VALUES("trade_account", "#{tradeAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getWheatherGetMoney() != null) {
            sql.VALUES("wheather_get_money", "#{wheatherGetMoney,jdbcType=TINYINT}");
        }
        
        if (record.getGetMoneyDate() != null) {
            sql.VALUES("get_money_date", "#{getMoneyDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCertificateType() != null) {
            sql.VALUES("certificate_type", "#{certificateType,jdbcType=TINYINT}");
        }
        
        if (record.getCertificateNumber() != null) {
            sql.VALUES("certificate_number", "#{certificateNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getContractDate() != null) {
            sql.VALUES("contract_date", "#{contractDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProductId() != null) {
            sql.VALUES("product_id", "#{productId,jdbcType=INTEGER}");
        }
        
        if (record.getProductTypeName() != null) {
            sql.VALUES("product_type_name", "#{productTypeName,jdbcType=VARCHAR}");
        }
        
        if (record.getProductRate() != null) {
            sql.VALUES("product_rate", "#{productRate,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceDate() != null) {
            sql.VALUES("service_date", "#{serviceDate,jdbcType=TINYINT}");
        }
        
        if (record.getBuyNum() != null) {
            sql.VALUES("buy_num", "#{buyNum,jdbcType=INTEGER}");
        }
        
        if (record.getInvestmentAmount() != null) {
            sql.VALUES("investment_amount", "#{investmentAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getEstimatedEarnings() != null) {
            sql.VALUES("estimated_earnings", "#{estimatedEarnings,jdbcType=DECIMAL}");
        }
        
        if (record.getContractIncome() != null) {
            sql.VALUES("contract_income", "#{contractIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getContactPhone() != null) {
            sql.VALUES("contact_phone", "#{contactPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getRegisterEmail() != null) {
            sql.VALUES("register_email", "#{registerEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getAgentCode() != null) {
            sql.VALUES("agent_code", "#{agentCode,jdbcType=VARCHAR}");
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
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.VALUES("gmt_modify", "#{gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(PersonDocumentExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("document_code");
        sql.SELECT("customer_name");
        sql.SELECT("trade_platform");
        sql.SELECT("trade_account");
        sql.SELECT("wheather_get_money");
        sql.SELECT("get_money_date");
        sql.SELECT("certificate_type");
        sql.SELECT("certificate_number");
        sql.SELECT("contract_date");
        sql.SELECT("product_id");
        sql.SELECT("product_type_name");
        sql.SELECT("product_rate");
        sql.SELECT("service_date");
        sql.SELECT("buy_num");
        sql.SELECT("investment_amount");
        sql.SELECT("estimated_earnings");
        sql.SELECT("contract_income");
        sql.SELECT("contact_phone");
        sql.SELECT("register_email");
        sql.SELECT("agent_code");
        sql.SELECT("derect_recomand_person_id");
        sql.SELECT("derect_recomand_person_name");
        sql.SELECT("inderect_recomand_person_id");
        sql.SELECT("inderect_recomand_person_name");
        sql.SELECT("gmt_create");
        sql.SELECT("gmt_modify");
        sql.SELECT("status");
        sql.FROM("person_document");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PersonDocument record = (PersonDocument) parameter.get("record");
        PersonDocumentExample example = (PersonDocumentExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("person_document");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getDocumentCode() != null) {
            sql.SET("document_code = #{record.documentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerName() != null) {
            sql.SET("customer_name = #{record.customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getTradePlatform() != null) {
            sql.SET("trade_platform = #{record.tradePlatform,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeAccount() != null) {
            sql.SET("trade_account = #{record.tradeAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getWheatherGetMoney() != null) {
            sql.SET("wheather_get_money = #{record.wheatherGetMoney,jdbcType=TINYINT}");
        }
        
        if (record.getGetMoneyDate() != null) {
            sql.SET("get_money_date = #{record.getMoneyDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCertificateType() != null) {
            sql.SET("certificate_type = #{record.certificateType,jdbcType=TINYINT}");
        }
        
        if (record.getCertificateNumber() != null) {
            sql.SET("certificate_number = #{record.certificateNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getContractDate() != null) {
            sql.SET("contract_date = #{record.contractDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{record.productId,jdbcType=INTEGER}");
        }
        
        if (record.getProductTypeName() != null) {
            sql.SET("product_type_name = #{record.productTypeName,jdbcType=VARCHAR}");
        }
        
        if (record.getProductRate() != null) {
            sql.SET("product_rate = #{record.productRate,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceDate() != null) {
            sql.SET("service_date = #{record.serviceDate,jdbcType=TINYINT}");
        }
        
        if (record.getBuyNum() != null) {
            sql.SET("buy_num = #{record.buyNum,jdbcType=INTEGER}");
        }
        
        if (record.getInvestmentAmount() != null) {
            sql.SET("investment_amount = #{record.investmentAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getEstimatedEarnings() != null) {
            sql.SET("estimated_earnings = #{record.estimatedEarnings,jdbcType=DECIMAL}");
        }
        
        if (record.getContractIncome() != null) {
            sql.SET("contract_income = #{record.contractIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getContactPhone() != null) {
            sql.SET("contact_phone = #{record.contactPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getRegisterEmail() != null) {
            sql.SET("register_email = #{record.registerEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getAgentCode() != null) {
            sql.SET("agent_code = #{record.agentCode,jdbcType=VARCHAR}");
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
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.SET("gmt_modify = #{record.gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("person_document");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("document_code = #{record.documentCode,jdbcType=VARCHAR}");
        sql.SET("customer_name = #{record.customerName,jdbcType=VARCHAR}");
        sql.SET("trade_platform = #{record.tradePlatform,jdbcType=VARCHAR}");
        sql.SET("trade_account = #{record.tradeAccount,jdbcType=VARCHAR}");
        sql.SET("wheather_get_money = #{record.wheatherGetMoney,jdbcType=TINYINT}");
        sql.SET("get_money_date = #{record.getMoneyDate,jdbcType=TIMESTAMP}");
        sql.SET("certificate_type = #{record.certificateType,jdbcType=TINYINT}");
        sql.SET("certificate_number = #{record.certificateNumber,jdbcType=VARCHAR}");
        sql.SET("contract_date = #{record.contractDate,jdbcType=TIMESTAMP}");
        sql.SET("product_id = #{record.productId,jdbcType=INTEGER}");
        sql.SET("product_type_name = #{record.productTypeName,jdbcType=VARCHAR}");
        sql.SET("product_rate = #{record.productRate,jdbcType=VARCHAR}");
        sql.SET("service_date = #{record.serviceDate,jdbcType=TINYINT}");
        sql.SET("buy_num = #{record.buyNum,jdbcType=INTEGER}");
        sql.SET("investment_amount = #{record.investmentAmount,jdbcType=DECIMAL}");
        sql.SET("estimated_earnings = #{record.estimatedEarnings,jdbcType=DECIMAL}");
        sql.SET("contract_income = #{record.contractIncome,jdbcType=DECIMAL}");
        sql.SET("contact_phone = #{record.contactPhone,jdbcType=VARCHAR}");
        sql.SET("register_email = #{record.registerEmail,jdbcType=VARCHAR}");
        sql.SET("agent_code = #{record.agentCode,jdbcType=VARCHAR}");
        sql.SET("derect_recomand_person_id = #{record.derectRecomandPersonId,jdbcType=INTEGER}");
        sql.SET("derect_recomand_person_name = #{record.derectRecomandPersonName,jdbcType=VARCHAR}");
        sql.SET("inderect_recomand_person_id = #{record.inderectRecomandPersonId,jdbcType=INTEGER}");
        sql.SET("inderect_recomand_person_name = #{record.inderectRecomandPersonName,jdbcType=VARCHAR}");
        sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        sql.SET("gmt_modify = #{record.gmtModify,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        
        PersonDocumentExample example = (PersonDocumentExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PersonDocument record) {
        SQL sql = new SQL();
        sql.UPDATE("person_document");
        
        if (record.getDocumentCode() != null) {
            sql.SET("document_code = #{documentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerName() != null) {
            sql.SET("customer_name = #{customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getTradePlatform() != null) {
            sql.SET("trade_platform = #{tradePlatform,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeAccount() != null) {
            sql.SET("trade_account = #{tradeAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getWheatherGetMoney() != null) {
            sql.SET("wheather_get_money = #{wheatherGetMoney,jdbcType=TINYINT}");
        }
        
        if (record.getGetMoneyDate() != null) {
            sql.SET("get_money_date = #{getMoneyDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCertificateType() != null) {
            sql.SET("certificate_type = #{certificateType,jdbcType=TINYINT}");
        }
        
        if (record.getCertificateNumber() != null) {
            sql.SET("certificate_number = #{certificateNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getContractDate() != null) {
            sql.SET("contract_date = #{contractDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=INTEGER}");
        }
        
        if (record.getProductTypeName() != null) {
            sql.SET("product_type_name = #{productTypeName,jdbcType=VARCHAR}");
        }
        
        if (record.getProductRate() != null) {
            sql.SET("product_rate = #{productRate,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceDate() != null) {
            sql.SET("service_date = #{serviceDate,jdbcType=TINYINT}");
        }
        
        if (record.getBuyNum() != null) {
            sql.SET("buy_num = #{buyNum,jdbcType=INTEGER}");
        }
        
        if (record.getInvestmentAmount() != null) {
            sql.SET("investment_amount = #{investmentAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getEstimatedEarnings() != null) {
            sql.SET("estimated_earnings = #{estimatedEarnings,jdbcType=DECIMAL}");
        }
        
        if (record.getContractIncome() != null) {
            sql.SET("contract_income = #{contractIncome,jdbcType=DECIMAL}");
        }
        
        if (record.getContactPhone() != null) {
            sql.SET("contact_phone = #{contactPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getRegisterEmail() != null) {
            sql.SET("register_email = #{registerEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getAgentCode() != null) {
            sql.SET("agent_code = #{agentCode,jdbcType=VARCHAR}");
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
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.SET("gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, PersonDocumentExample example, boolean includeExamplePhrase) {
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