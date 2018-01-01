package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.Agent;
import com.hotyum.stars.dal.model.AgentExample.Criteria;
import com.hotyum.stars.dal.model.AgentExample.Criterion;
import com.hotyum.stars.dal.model.AgentExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class AgentSqlProvider {

    public String countByExample(AgentExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("agent");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(AgentExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("agent");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Agent record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("agent");
        
        if (record.getAgentCode() != null) {
            sql.VALUES("agent_code", "#{agentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAgentName() != null) {
            sql.VALUES("agent_name", "#{agentName,jdbcType=VARCHAR}");
        }
        
        if (record.getUnifiedSocialCreditCode() != null) {
            sql.VALUES("unified_social_credit_code", "#{unifiedSocialCreditCode,jdbcType=VARCHAR}");
        }
        
        if (record.getLegalRepresentative() != null) {
            sql.VALUES("legal_representative", "#{legalRepresentative,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceId() != null) {
            sql.VALUES("province_id", "#{provinceId,jdbcType=INTEGER}");
        }
        
        if (record.getProvinceName() != null) {
            sql.VALUES("province_name", "#{provinceName,jdbcType=VARCHAR}");
        }
        
        if (record.getContact() != null) {
            sql.VALUES("contact", "#{contact,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessAddress() != null) {
            sql.VALUES("business_address", "#{businessAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessStartTime() != null) {
            sql.VALUES("business_start_time", "#{businessStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBusinessEndTime() != null) {
            sql.VALUES("business_end_time", "#{businessEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContractStartTime() != null) {
            sql.VALUES("contract_start_time", "#{contractStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContrctEndTime() != null) {
            sql.VALUES("contrct_end_time", "#{contrctEndTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(AgentExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("agent_code");
        sql.SELECT("agent_name");
        sql.SELECT("unified_social_credit_code");
        sql.SELECT("legal_representative");
        sql.SELECT("province_id");
        sql.SELECT("province_name");
        sql.SELECT("contact");
        sql.SELECT("business_address");
        sql.SELECT("business_start_time");
        sql.SELECT("business_end_time");
        sql.SELECT("contract_start_time");
        sql.SELECT("contrct_end_time");
        sql.FROM("agent");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Agent record = (Agent) parameter.get("record");
        AgentExample example = (AgentExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("agent");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getAgentCode() != null) {
            sql.SET("agent_code = #{record.agentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAgentName() != null) {
            sql.SET("agent_name = #{record.agentName,jdbcType=VARCHAR}");
        }
        
        if (record.getUnifiedSocialCreditCode() != null) {
            sql.SET("unified_social_credit_code = #{record.unifiedSocialCreditCode,jdbcType=VARCHAR}");
        }
        
        if (record.getLegalRepresentative() != null) {
            sql.SET("legal_representative = #{record.legalRepresentative,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceId() != null) {
            sql.SET("province_id = #{record.provinceId,jdbcType=INTEGER}");
        }
        
        if (record.getProvinceName() != null) {
            sql.SET("province_name = #{record.provinceName,jdbcType=VARCHAR}");
        }
        
        if (record.getContact() != null) {
            sql.SET("contact = #{record.contact,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessAddress() != null) {
            sql.SET("business_address = #{record.businessAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessStartTime() != null) {
            sql.SET("business_start_time = #{record.businessStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBusinessEndTime() != null) {
            sql.SET("business_end_time = #{record.businessEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContractStartTime() != null) {
            sql.SET("contract_start_time = #{record.contractStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContrctEndTime() != null) {
            sql.SET("contrct_end_time = #{record.contrctEndTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("agent");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("agent_code = #{record.agentCode,jdbcType=VARCHAR}");
        sql.SET("agent_name = #{record.agentName,jdbcType=VARCHAR}");
        sql.SET("unified_social_credit_code = #{record.unifiedSocialCreditCode,jdbcType=VARCHAR}");
        sql.SET("legal_representative = #{record.legalRepresentative,jdbcType=VARCHAR}");
        sql.SET("province_id = #{record.provinceId,jdbcType=INTEGER}");
        sql.SET("province_name = #{record.provinceName,jdbcType=VARCHAR}");
        sql.SET("contact = #{record.contact,jdbcType=VARCHAR}");
        sql.SET("business_address = #{record.businessAddress,jdbcType=VARCHAR}");
        sql.SET("business_start_time = #{record.businessStartTime,jdbcType=TIMESTAMP}");
        sql.SET("business_end_time = #{record.businessEndTime,jdbcType=TIMESTAMP}");
        sql.SET("contract_start_time = #{record.contractStartTime,jdbcType=TIMESTAMP}");
        sql.SET("contrct_end_time = #{record.contrctEndTime,jdbcType=TIMESTAMP}");
        
        AgentExample example = (AgentExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Agent record) {
        SQL sql = new SQL();
        sql.UPDATE("agent");
        
        if (record.getAgentCode() != null) {
            sql.SET("agent_code = #{agentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAgentName() != null) {
            sql.SET("agent_name = #{agentName,jdbcType=VARCHAR}");
        }
        
        if (record.getUnifiedSocialCreditCode() != null) {
            sql.SET("unified_social_credit_code = #{unifiedSocialCreditCode,jdbcType=VARCHAR}");
        }
        
        if (record.getLegalRepresentative() != null) {
            sql.SET("legal_representative = #{legalRepresentative,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceId() != null) {
            sql.SET("province_id = #{provinceId,jdbcType=INTEGER}");
        }
        
        if (record.getProvinceName() != null) {
            sql.SET("province_name = #{provinceName,jdbcType=VARCHAR}");
        }
        
        if (record.getContact() != null) {
            sql.SET("contact = #{contact,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessAddress() != null) {
            sql.SET("business_address = #{businessAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessStartTime() != null) {
            sql.SET("business_start_time = #{businessStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBusinessEndTime() != null) {
            sql.SET("business_end_time = #{businessEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContractStartTime() != null) {
            sql.SET("contract_start_time = #{contractStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContrctEndTime() != null) {
            sql.SET("contrct_end_time = #{contrctEndTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, AgentExample example, boolean includeExamplePhrase) {
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