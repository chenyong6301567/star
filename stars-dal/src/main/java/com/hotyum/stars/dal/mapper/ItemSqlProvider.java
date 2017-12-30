package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.Item;
import com.hotyum.stars.dal.model.ItemExample.Criteria;
import com.hotyum.stars.dal.model.ItemExample.Criterion;
import com.hotyum.stars.dal.model.ItemExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ItemSqlProvider {

    public String countByExample(ItemExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("item");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ItemExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("item");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Item record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("item");
        
        if (record.getShopId() != null) {
            sql.VALUES("shop_id", "#{shopId,jdbcType=INTEGER}");
        }
        
        if (record.getBarcode() != null) {
            sql.VALUES("barcode", "#{barcode,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPinyin() != null) {
            sql.VALUES("pinyin", "#{pinyin,jdbcType=VARCHAR}");
        }
        
        if (record.getSpec() != null) {
            sql.VALUES("spec", "#{spec,jdbcType=VARCHAR}");
        }
        
        if (record.getUnit() != null) {
            sql.VALUES("unit", "#{unit,jdbcType=VARCHAR}");
        }
        
        if (record.getLocation() != null) {
            sql.VALUES("location", "#{location,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=INTEGER}");
        }
        
        if (record.getSecrStock() != null) {
            sql.VALUES("secr_stock", "#{secrStock,jdbcType=DOUBLE}");
        }
        
        if (record.getStock() != null) {
            sql.VALUES("stock", "#{stock,jdbcType=DOUBLE}");
        }
        
        if (record.getVipPrice() != null) {
            sql.VALUES("vip_price", "#{vipPrice,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=SMALLINT}");
        }
        
        if (record.getCostPrice() != null) {
            sql.VALUES("cost_price", "#{costPrice,jdbcType=INTEGER}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.VALUES("gmt_modify", "#{gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getKeyword() != null) {
            sql.VALUES("keyword", "#{keyword,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ItemExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("shop_id");
        sql.SELECT("barcode");
        sql.SELECT("name");
        sql.SELECT("pinyin");
        sql.SELECT("spec");
        sql.SELECT("unit");
        sql.SELECT("location");
        sql.SELECT("price");
        sql.SELECT("secr_stock");
        sql.SELECT("stock");
        sql.SELECT("vip_price");
        sql.SELECT("status");
        sql.SELECT("cost_price");
        sql.SELECT("gmt_create");
        sql.SELECT("gmt_modify");
        sql.SELECT("keyword");
        sql.FROM("item");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Item record = (Item) parameter.get("record");
        ItemExample example = (ItemExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("item");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getShopId() != null) {
            sql.SET("shop_id = #{record.shopId,jdbcType=INTEGER}");
        }
        
        if (record.getBarcode() != null) {
            sql.SET("barcode = #{record.barcode,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getPinyin() != null) {
            sql.SET("pinyin = #{record.pinyin,jdbcType=VARCHAR}");
        }
        
        if (record.getSpec() != null) {
            sql.SET("spec = #{record.spec,jdbcType=VARCHAR}");
        }
        
        if (record.getUnit() != null) {
            sql.SET("unit = #{record.unit,jdbcType=VARCHAR}");
        }
        
        if (record.getLocation() != null) {
            sql.SET("location = #{record.location,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{record.price,jdbcType=INTEGER}");
        }
        
        if (record.getSecrStock() != null) {
            sql.SET("secr_stock = #{record.secrStock,jdbcType=DOUBLE}");
        }
        
        if (record.getStock() != null) {
            sql.SET("stock = #{record.stock,jdbcType=DOUBLE}");
        }
        
        if (record.getVipPrice() != null) {
            sql.SET("vip_price = #{record.vipPrice,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=SMALLINT}");
        }
        
        if (record.getCostPrice() != null) {
            sql.SET("cost_price = #{record.costPrice,jdbcType=INTEGER}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.SET("gmt_modify = #{record.gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getKeyword() != null) {
            sql.SET("keyword = #{record.keyword,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("item");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("shop_id = #{record.shopId,jdbcType=INTEGER}");
        sql.SET("barcode = #{record.barcode,jdbcType=VARCHAR}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("pinyin = #{record.pinyin,jdbcType=VARCHAR}");
        sql.SET("spec = #{record.spec,jdbcType=VARCHAR}");
        sql.SET("unit = #{record.unit,jdbcType=VARCHAR}");
        sql.SET("location = #{record.location,jdbcType=VARCHAR}");
        sql.SET("price = #{record.price,jdbcType=INTEGER}");
        sql.SET("secr_stock = #{record.secrStock,jdbcType=DOUBLE}");
        sql.SET("stock = #{record.stock,jdbcType=DOUBLE}");
        sql.SET("vip_price = #{record.vipPrice,jdbcType=INTEGER}");
        sql.SET("status = #{record.status,jdbcType=SMALLINT}");
        sql.SET("cost_price = #{record.costPrice,jdbcType=INTEGER}");
        sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        sql.SET("gmt_modify = #{record.gmtModify,jdbcType=TIMESTAMP}");
        sql.SET("keyword = #{record.keyword,jdbcType=VARCHAR}");
        
        ItemExample example = (ItemExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Item record) {
        SQL sql = new SQL();
        sql.UPDATE("item");
        
        if (record.getShopId() != null) {
            sql.SET("shop_id = #{shopId,jdbcType=INTEGER}");
        }
        
        if (record.getBarcode() != null) {
            sql.SET("barcode = #{barcode,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPinyin() != null) {
            sql.SET("pinyin = #{pinyin,jdbcType=VARCHAR}");
        }
        
        if (record.getSpec() != null) {
            sql.SET("spec = #{spec,jdbcType=VARCHAR}");
        }
        
        if (record.getUnit() != null) {
            sql.SET("unit = #{unit,jdbcType=VARCHAR}");
        }
        
        if (record.getLocation() != null) {
            sql.SET("location = #{location,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=INTEGER}");
        }
        
        if (record.getSecrStock() != null) {
            sql.SET("secr_stock = #{secrStock,jdbcType=DOUBLE}");
        }
        
        if (record.getStock() != null) {
            sql.SET("stock = #{stock,jdbcType=DOUBLE}");
        }
        
        if (record.getVipPrice() != null) {
            sql.SET("vip_price = #{vipPrice,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=SMALLINT}");
        }
        
        if (record.getCostPrice() != null) {
            sql.SET("cost_price = #{costPrice,jdbcType=INTEGER}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.SET("gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getKeyword() != null) {
            sql.SET("keyword = #{keyword,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ItemExample example, boolean includeExamplePhrase) {
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