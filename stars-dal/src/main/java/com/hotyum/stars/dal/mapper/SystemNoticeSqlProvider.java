package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.SystemNotice;
import com.hotyum.stars.dal.model.SystemNoticeExample.Criteria;
import com.hotyum.stars.dal.model.SystemNoticeExample.Criterion;
import com.hotyum.stars.dal.model.SystemNoticeExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SystemNoticeSqlProvider {

    public String countByExample(SystemNoticeExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("system_notice");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SystemNoticeExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("system_notice");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SystemNotice record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("system_notice");
        
        if (record.getToType() != null) {
            sql.VALUES("to_type", "#{toType,jdbcType=TINYINT}");
        }
        
        if (record.getSysType() != null) {
            sql.VALUES("sys_type", "#{sysType,jdbcType=TINYINT}");
        }
        
        if (record.getNoticeContent() != null) {
            sql.VALUES("notice_content", "#{noticeContent,jdbcType=VARCHAR}");
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
        
        if (record.getNoticeStatus() != null) {
            sql.VALUES("notice_status", "#{noticeStatus,jdbcType=TINYINT}");
        }
        
        if (record.getSmsStatus() != null) {
            sql.VALUES("sms_status", "#{smsStatus,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SystemNoticeExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("to_type");
        sql.SELECT("sys_type");
        sql.SELECT("notice_content");
        sql.SELECT("gmt_create");
        sql.SELECT("gmt_modify");
        sql.SELECT("status");
        sql.SELECT("notice_status");
        sql.SELECT("sms_status");
        sql.FROM("system_notice");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SystemNotice record = (SystemNotice) parameter.get("record");
        SystemNoticeExample example = (SystemNoticeExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("system_notice");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getToType() != null) {
            sql.SET("to_type = #{record.toType,jdbcType=TINYINT}");
        }
        
        if (record.getSysType() != null) {
            sql.SET("sys_type = #{record.sysType,jdbcType=TINYINT}");
        }
        
        if (record.getNoticeContent() != null) {
            sql.SET("notice_content = #{record.noticeContent,jdbcType=VARCHAR}");
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
        
        if (record.getNoticeStatus() != null) {
            sql.SET("notice_status = #{record.noticeStatus,jdbcType=TINYINT}");
        }
        
        if (record.getSmsStatus() != null) {
            sql.SET("sms_status = #{record.smsStatus,jdbcType=TINYINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("system_notice");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("to_type = #{record.toType,jdbcType=TINYINT}");
        sql.SET("sys_type = #{record.sysType,jdbcType=TINYINT}");
        sql.SET("notice_content = #{record.noticeContent,jdbcType=VARCHAR}");
        sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        sql.SET("gmt_modify = #{record.gmtModify,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("notice_status = #{record.noticeStatus,jdbcType=TINYINT}");
        sql.SET("sms_status = #{record.smsStatus,jdbcType=TINYINT}");
        
        SystemNoticeExample example = (SystemNoticeExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SystemNotice record) {
        SQL sql = new SQL();
        sql.UPDATE("system_notice");
        
        if (record.getToType() != null) {
            sql.SET("to_type = #{toType,jdbcType=TINYINT}");
        }
        
        if (record.getSysType() != null) {
            sql.SET("sys_type = #{sysType,jdbcType=TINYINT}");
        }
        
        if (record.getNoticeContent() != null) {
            sql.SET("notice_content = #{noticeContent,jdbcType=VARCHAR}");
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
        
        if (record.getNoticeStatus() != null) {
            sql.SET("notice_status = #{noticeStatus,jdbcType=TINYINT}");
        }
        
        if (record.getSmsStatus() != null) {
            sql.SET("sms_status = #{smsStatus,jdbcType=TINYINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SystemNoticeExample example, boolean includeExamplePhrase) {
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